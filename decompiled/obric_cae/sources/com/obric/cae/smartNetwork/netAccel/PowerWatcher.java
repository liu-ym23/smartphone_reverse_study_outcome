package com.obric.cae.smartNetwork.netAccel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class PowerWatcher {
    private static final int LOW_BATTERY_THRESHOLD = 20;
    private static final String TAG = "MultiNetwork-PowerWatcher";
    private final AtomicInteger mBatteryLevel;
    private final BroadcastReceiver mBatteryReceiver;
    private Context mContext;
    private final AtomicBoolean mIsLowBattery;
    private final AtomicBoolean mIsPowerSaveMode;
    private boolean mIsRegistered;
    private PowerManager mPowerManager;
    private final BroadcastReceiver mPowerSaveReceiver;
    private PowerStatusListener mPowerStatusListener;
    private final AtomicInteger mThermalStatus;
    private final PowerManager.OnThermalStatusChangedListener mThermalStatusListener;

    public interface PowerStatusListener {
        void onBatteryLevelChanged(int r8, boolean r10);

        void onPowerSaveModeChanged(boolean r8);

        void onThermalStatusChanged(int r8);
    }

    public PowerWatcher(Context r8) {
        this.mIsRegistered = false;
        this.mIsLowBattery = new AtomicBoolean(false);
        this.mIsPowerSaveMode = new AtomicBoolean(false);
        this.mBatteryLevel = new AtomicInteger(0);
        this.mThermalStatus = new AtomicInteger(0);
        this.mThermalStatusListener = new AnonymousClass1(this);
        this.mBatteryReceiver = new AnonymousClass2(this);
        this.mPowerSaveReceiver = new AnonymousClass3(this);
        this.mContext = r8;
        this.mPowerManager = (PowerManager) r8.getSystemService("power");
    }

    public static /* synthetic */ AtomicInteger access$000(PowerWatcher r8) {
        return r8.mThermalStatus;
    }

    public static /* synthetic */ PowerStatusListener access$100(PowerWatcher r8) {
        return r8.mPowerStatusListener;
    }

    public static /* synthetic */ String access$200(PowerWatcher r8, int r10) {
        return r8.getThermalStatusString(r10);
    }

    public static /* synthetic */ AtomicInteger access$300(PowerWatcher r8) {
        return r8.mBatteryLevel;
    }

    public static /* synthetic */ AtomicBoolean access$400(PowerWatcher r8) {
        return r8.mIsLowBattery;
    }

    public static /* synthetic */ PowerManager access$500(PowerWatcher r8) {
        return r8.mPowerManager;
    }

    public static /* synthetic */ AtomicBoolean access$600(PowerWatcher r8) {
        return r8.mIsPowerSaveMode;
    }

    private String getThermalStatusString(int r8) {
        if (r8 != 0) goto L4;
        return BdimCategoryConstants.VALUE_NONE;
    L4:
        if (r8 != 1) goto L6;
        return "LIGHT";
    L6:
        if (r8 != 2) goto L8;
        return "MODERATE";
    L8:
        if (r8 != 3) goto L10;
        return "SEVERE";
    L10:
        if (r8 != 4) goto L12;
        return "CRITICAL";
    L12:
        if (r8 == 5) goto L15;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L15:
        return "EMERGENCY";
    }

    public int getBatteryLevel() {
        return this.mBatteryLevel.get();
    }

    public int getThermalStatus() {
        return this.mThermalStatus.get();
    }

    public boolean isHighTemperature() {
        if (this.mThermalStatus.get() < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLowBattery() {
        return this.mIsLowBattery.get();
    }

    public boolean isPowerRestricted() {
        if (isLowBattery() == false) goto L5;
    L10:
        return true;
    L5:
        if (isPowerSaveMode() == true) goto L10;
        if (isHighTemperature() == true) goto L10;
        return false;
    }

    public boolean isPowerSaveMode() {
        return this.mIsPowerSaveMode.get();
    }

    public void setPowerStatusListener(PowerStatusListener r8) {
        this.mPowerStatusListener = r8;
    }

    public void start() {
        if (this.mIsRegistered == false) goto L5;
        return;
    L5:
        IntentFilter r8 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.mContext.registerReceiver(this.mBatteryReceiver, r8);
        this.mContext.registerReceiver(this.mPowerSaveReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        boolean r10 = true;
        this.mIsRegistered = true;
        CaeLog.i(TAG, "PowerWatcher started");
        Intent r11 = this.mContext.registerReceiver(null, r8);
        if (r11 == null) goto L12;
        int r12 = (r11.getIntExtra("level", 0) * 100) / r11.getIntExtra("scale", 100);
        if (r12 <= 20) goto L11;
        r10 = false;
    L11:
        this.mBatteryLevel.set(r12);
        this.mIsLowBattery.set(r10);
        CaeLog.i(TAG, "Initial battery level: " + r12 + "%, isLow: " + r10);
    L12:
        PowerManager r13 = this.mPowerManager;
        if (r13 == null) goto L16;
        boolean r14 = r13.isPowerSaveMode();
        this.mIsPowerSaveMode.set(r14);
        CaeLog.i(TAG, "Initial power save mode: " + r14);
        this.mPowerManager.addThermalStatusListener(this.mThermalStatusListener);
        int r15 = this.mPowerManager.getCurrentThermalStatus();
        this.mThermalStatus.set(r15);
        CaeLog.d(TAG, "Initial thermal status: " + r15 + " (" + getThermalStatusString(r15) + ")");
        return;
    }

    public void stop() {
        if (this.mIsRegistered == true) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(this.mBatteryReceiver);
        this.mContext.unregisterReceiver(this.mPowerSaveReceiver);
        PowerManager r8 = this.mPowerManager;
        if (r8 == null) goto L8;
        r8.removeThermalStatusListener(this.mThermalStatusListener);
    L8:
        this.mIsRegistered = false;
        CaeLog.i(TAG, "PowerWatcher stopped");
    }
}
