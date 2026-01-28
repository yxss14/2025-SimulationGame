package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;
import frc.robot.TankDriveModule;

public class TankDrive extends SubsystemBase {

    private TankDriveModule rightWheel;
    private TankDriveModule leftWheel;

    public TankDrive(int kRightFrontWheelID, int kRightRearWheelID, int kLeftFrontWheelID, int kLeftRearWheelID) {
        rightWheel = new TankDriveModule(kRightFrontWheelID, kRightRearWheelID);
        leftWheel = new TankDriveModule(kLeftFrontWheelID, kLeftRearWheelID);   
        
    }

    public void drive(double x, double y) {
        double left_power = (-x + y)* DriveConstants.kspeed; //kspeed still undone yet(還沒調整到最佳速度)
        double right_power = (-x - y) * DriveConstants.kspeed;

        // bounding
        if (left_power > 1) left_power = 1;
        else if (left_power < -1) left_power = -1;
        if (right_power > 1) right_power = 1;
        else if (right_power < -1) right_power = -1;
        
        rightWheel.setPower(right_power);
        leftWheel.setPower(left_power);
    }

}
