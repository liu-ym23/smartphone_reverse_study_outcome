package com.sdk.bwdl.ExternalAPI;

import android.content.Context;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.BWDLDeviceManager;
import com.sdk.bwdl.BWDLReceiver;
import com.sdk.bwdl.NearFieldSwap.AdvEngine;
import com.sdk.bwdl.NearFieldSwap.DiscoveryEngine;
import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLManager {
    private static final String TAG = "BWDLManager";
    public static BWDLCallback mBWDLCallback;
    public static BWDLConfigs mBWDLConfigs;
    private static volatile BWDLManager sInstance;
    private AdvEngine mAdvEngine;
    private BWDLDeviceManager mBWDLDeviceManager;
    private BWDLReceiver mBWDLReceiver;
    private Context mContext;
    private DiscoveryEngine mDiscoveryEngine;

    private BWDLManager(Context r8) {
        this.mContext = r8;
    }

    private DiscoveryEngine getDiscoveryEngine() {
        return this.mDiscoveryEngine;
    }

    public static BWDLManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BWDLManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BWDLManager(r8);     // Catch: Throwable -> L11
        BWDLLog.d(TAG, "BWDLManager version:0.0.20");     // Catch: Throwable -> L11
    L9:
        monitor-exit(BWDLManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isDiscoveryEngineRunning() {
        DiscoveryEngine r8 = this.mDiscoveryEngine;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isReady() == false) goto L7;
        return true;
    }

    private boolean setAdvertisingInterval(BWDLConstant.ADV_INTERVAL_LEVEL r8) {
        if (isAdvEngineRunning() == false) goto L6;
        this.mAdvEngine.setAdvSetParameters(r8);
        mBWDLConfigs.setAdvertisingInterval(r8);
        return true;
    L6:
        return false;
    }

    private boolean setAdvertisingTxPower(BWDLConstant.ADV_TX_POWER_LEVEL r8) {
        if (isAdvEngineRunning() == false) goto L6;
        this.mAdvEngine.setAdvSetParameters(r8);
        mBWDLConfigs.setAdvertisingTxPower(r8);
        return true;
    L6:
        return false;
    }

    private boolean setBwdlOptionalAdvConfig(int r8) {
        if (isAdvEngineRunning() == false) goto L6;
        this.mAdvEngine.setOptionalAdvConfig(r8);
        return true;
    L6:
        BWDLLog.e(TAG, "adv engine not running.");
        return false;
    }

    private boolean setDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL r8) {
        BWDLLog.d(TAG, "setDiscoveryParameters");
        if (isAdvEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.setDiscoveryInterval(r8);
        mBWDLConfigs.setDiscoveryInterval(r8);
        return true;
    L6:
        return false;
    }

    public void Listen() {
    }

    public boolean connect(BWDLDevice r8) {
        return this.mBWDLDeviceManager.connect(mBWDLConfigs, r8);
    }

    public boolean disconnect(BWDLDevice r8) {
        return this.mBWDLDeviceManager.disconnect(mBWDLConfigs, r8);
    }

    public void exit() {
        this.mBWDLDeviceManager.unRegisterFeature(mBWDLConfigs);
        this.mBWDLDeviceManager.cleanup();
        this.mBWDLReceiver.cleanup();
        this.mDiscoveryEngine.exit();
        this.mAdvEngine.exit();
    }

    public AdvEngine getAdvEngine() {
        return this.mAdvEngine;
    }

    public boolean init(BWDLConfigs r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        this.mBWDLDeviceManager = BWDLDeviceManager.getInstance(this.mContext);
        this.mBWDLReceiver = BWDLReceiver.getInstance(this.mContext);
        mBWDLConfigs = r8;
        mBWDLCallback = r8.getCallback();
        this.mBWDLDeviceManager.registerFeature(mBWDLConfigs);
        setBwdlOptionalAdvConfig(mBWDLConfigs.getAdvertisingOptional());
        this.mDiscoveryEngine = new DiscoveryEngine(this.mContext);
        this.mAdvEngine = new AdvEngine(this.mContext, mBWDLConfigs);
        if (mBWDLCallback != null) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean isAdvEngineRunning() {
        AdvEngine r8 = this.mAdvEngine;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isReady() == false) goto L7;
        return true;
    }

    public boolean pair(String r8) {
        if (isDiscoveryEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.pair(r8, mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "Discovery engine not running.");
        return false;
    }

    public boolean startAdvertising() {
        if (isAdvEngineRunning() == false) goto L6;
        BWDLAdvertisingData r8 = mBWDLConfigs.getBWDLAdvertisingData();
        this.mAdvEngine.start(mBWDLCallback, r8);
        return true;
    L6:
        BWDLLog.e(TAG, "adv engine not running.");
        return false;
    }

    public boolean startDiscovery() {
        if (isDiscoveryEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.start(mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "discovery engine not running.");
        return false;
    }

    public boolean stopAdvertising() {
        if (isAdvEngineRunning() == false) goto L6;
        this.mAdvEngine.stop(mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "adv engine not running.");
        return false;
    }

    public boolean stopDiscovery() {
        if (isDiscoveryEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.stop(mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "Discovery engine not running.");
        return false;
    }

    public boolean updaeOptionalAdvConfig(int r8) {
        BWDLLog.d(TAG, "updaeOptionalAdvConfig");
        if (r8 != mBWDLConfigs.getAdvertisingOptional()) goto L7;
        return false;
    L7:
        return setBwdlOptionalAdvConfig(r8);
    }

    public boolean updateAdvertisingData(byte[] r8) {
        BWDLLog.d(TAG, "updateAdvertisingData");
        BWDLAdvertisingData r10 = mBWDLConfigs.getBWDLAdvertisingData();
        if (r10 == null) goto L12;
        if (r8 == null) goto L12;
        if (r8.equals(r10.getFeatureData()) == true) goto L12;
        if (isAdvEngineRunning() == false) goto L12;
        BWDLAdvertisingData r11 = new BWDLAdvertisingData(r10.getServiceUuid(), r10.getFeatureType(), r8, r10.getPrivData());
        mBWDLConfigs.setAdvertisingData(r11);
        return true;
    L12:
        return false;
    }

    public boolean updateAdvertisingInterval(BWDLConstant.ADV_INTERVAL_LEVEL r8) {
        BWDLLog.d(TAG, "setAdvertisingInterval");
        if (r8 != mBWDLConfigs.getAdvertisingIntervale()) goto L7;
        return false;
    L7:
        return setAdvertisingInterval(r8);
    }

    public boolean updateAdvertisingTxPower(BWDLConstant.ADV_TX_POWER_LEVEL r8) {
        BWDLLog.d(TAG, "updateAdvertisingTxPower");
        if (r8 != mBWDLConfigs.getAdvertisingTxPower()) goto L7;
        return false;
    L7:
        return setAdvertisingTxPower(r8);
    }

    public boolean updateDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL r8) {
        BWDLLog.d(TAG, "setDiscoveryParameters");
        if (r8 != mBWDLConfigs.getDiscoveryInterval()) goto L7;
        return false;
    L7:
        return setDiscoveryInterval(r8);
    }

    public boolean startDiscovery(short r8) {
        if (isDiscoveryEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.start(r8, mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "Discovery engine not running.");
        return false;
    }

    public boolean startDiscovery(short r8, byte r10) {
        if (isDiscoveryEngineRunning() == false) goto L6;
        this.mDiscoveryEngine.start(r8, r10, mBWDLCallback);
        return true;
    L6:
        BWDLLog.e(TAG, "Discovery engine not running.");
        return false;
    }
}
