package com.bytedance.bdlocation_impl.shake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothUtil;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import defpackage.c;
import ha.m;

/* JADX INFO: loaded from: classes.dex */
public class BDShakeScanTask {
    public static m mBleInfos;
    public static m mWifiInfos;
    private final String TAG;
    private BluetoothInfoManager blueToothCollectManager;
    private volatile boolean isBleScanRun;
    private volatile boolean isLocationRun;
    private boolean isStartScanTask;
    private volatile boolean isWifiScanRun;
    private String mBpeaAction;
    private Object mBpeaCert;
    private Context mContext;
    private String mUploadSource;
    private ScanReceiver receiver;
    private long startScanTime;
    private Handler workHandler;

    public class BleScanTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public BleScanTask(BDShakeScanTask r8, Object r10) {
            this.this$0 = r8;
            this.mBpeaCert = r10;
            BDShakeScanTask.access$502(r8, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationUtil.checkBackground() == false) goto L7;
            BDShakeScanTask.access$502(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$500(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L12;
            return;
        L12:
            Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "BleScanTask run:" + BDShakeConfig.getBleScanTime() + "--" + BDShakeConfig.getClassicScanTime());
            BDShakeScanTask.access$600(this.this$0).startScan(new AnonymousClass1(this), BDShakeConfig.getClassicScanTime(), BDShakeConfig.getBleScanTime(), this.mBpeaCert);
        }
    }

    public class LocationTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public LocationTask(BDShakeScanTask r8, Object r10) {
            this.this$0 = r8;
            this.mBpeaCert = r10;
            BDShakeScanTask.access$002(r8, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationUtil.checkBackground() == false) goto L7;
            BDShakeScanTask.access$002(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$000(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L12;
            return;
        L12:
            Logger.d(BluetoothUtil.BLE_SCAN_TRACE, "LocationTask run--------------:" + BDShakeConfig.getLocationInterval());
            BDShakeScanTask r8 = this.this$0;
            c.K(BDShakeScanTask.access$300(r8, BDShakeScanTask.access$200(r8), 1, false, 0, 0, this.mBpeaCert));
            if (BDShakeScanTask.access$000(this.this$0) == false) goto L16;
            BDShakeScanTask.access$400(this.this$0).postDelayed(this, BDShakeConfig.getLocationInterval());
            return;
        }
    }

    public class ScanReceiver extends BroadcastReceiver {
        final /* synthetic */ BDShakeScanTask this$0;

        public ScanReceiver(BDShakeScanTask r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            String r11 = r10.getAction();
            r11.getClass();
            if (r11.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L5;
            BDShakeScanTask.access$1000(this.this$0, r10);
            return;
        L5:
            if (r11.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L11;
            BDShakeScanTask.access$900(this.this$0, r10);
            return;
        }
    }

    public class WifiScanTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public WifiScanTask(BDShakeScanTask r8, Object r10) {
            this.this$0 = r8;
            this.mBpeaCert = r10;
            BDShakeScanTask.access$702(r8, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationUtil.checkBackground() == false) goto L7;
            BDShakeScanTask.access$702(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$700(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L17;
            return;
        L17:
            Logger.d("ShakeScanTask", "WifiScanTask run:");     // Catch: Exception -> L16
            BDShakeScanTask.mWifiInfos = WifiUtil.getWifiInfoJson(BDShakeScanTask.access$800(this.this$0), this.mBpeaCert);     // Catch: Exception -> L16
            if (BDShakeScanTask.access$700(this.this$0) == false) goto L19;
            BDShakeScanTask.access$400(this.this$0).postDelayed(this, BDShakeConfig.getWifiScanInterval());     // Catch: Exception -> L16
            return;
        L19:
            return;
        }
    }

    public BDShakeScanTask() {
        this.TAG = "ShakeScanTask";
        this.mUploadSource = "ShakeScanTask";
        this.isLocationRun = false;
        this.isBleScanRun = false;
        this.isWifiScanRun = false;
        this.isStartScanTask = false;
        this.mBpeaCert = null;
        this.mBpeaAction = "";
        Context r8 = BDLocationConfig.getContext();
        this.mContext = r8;
        this.blueToothCollectManager = new BluetoothInfoManager(r8);
        this.workHandler = new Handler(ThreadLooperManager.getShakeTaskWorker());
    }

    public static /* synthetic */ boolean access$000(BDShakeScanTask r8) {
        return r8.isLocationRun;
    }

    public static /* synthetic */ boolean access$002(BDShakeScanTask r8, boolean r10) {
        r8.isLocationRun = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$100(BDShakeScanTask r8) {
        return r8.isTimeout();
    }

    public static /* synthetic */ void access$1000(BDShakeScanTask r8, Intent r10) {
        r8.setWifiState(r10);
    }

    public static /* synthetic */ String access$200(BDShakeScanTask r8) {
        return r8.mUploadSource;
    }

    public static /* synthetic */ LocationOption access$300(BDShakeScanTask r8, String r10, int r11, boolean r12, int r13, long r14, Object r15) {
        return r8.getShakeScanOption(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Handler access$400(BDShakeScanTask r8) {
        return r8.workHandler;
    }

    public static /* synthetic */ boolean access$500(BDShakeScanTask r8) {
        return r8.isBleScanRun;
    }

    public static /* synthetic */ boolean access$502(BDShakeScanTask r8, boolean r10) {
        r8.isBleScanRun = r10;
        return r10;
    }

    public static /* synthetic */ BluetoothInfoManager access$600(BDShakeScanTask r8) {
        return r8.blueToothCollectManager;
    }

    public static /* synthetic */ boolean access$700(BDShakeScanTask r8) {
        return r8.isWifiScanRun;
    }

    public static /* synthetic */ boolean access$702(BDShakeScanTask r8, boolean r10) {
        r8.isWifiScanRun = r10;
        return r10;
    }

    public static /* synthetic */ Context access$800(BDShakeScanTask r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$900(BDShakeScanTask r8, Intent r10) {
        r8.setBluetoothState(r10);
    }

    private LocationOption getShakeScanOption(String r8, int r10, boolean r11, int r12, long r13, Object r14) {
        LocationOption r15 = new LocationOption();
        r15.setUploadSource(r8);
        r15.setMaxCacheTime(r13);
        r15.setTriggerType(r10);
        r15.setUpload(r11);
        r15.setLocationTimeOutMs(r12);
        r15.setLocateType(BDLocationConfig.getLocateType());
        r15.setBpeaCert(r14);
        r15.setBpeaAction(this.mBpeaAction);
        r15.setScanBle(false);
        return r15;
    }

    private boolean isTimeout() {
        if ((System.currentTimeMillis() - this.startScanTime) <= BDShakeConfig.getScanTimeoutMS()) goto L6;
        return true;
    L6:
        return false;
    }

    private void registerScanReceiver() {
        this.receiver = new ScanReceiver(this);
        IntentFilter r8 = defpackage.a.c("android.bluetooth.adapter.action.STATE_CHANGED", "android.net.wifi.WIFI_STATE_CHANGED");
        this.mContext.registerReceiver(this.receiver, r8);
    }

    private void setBluetoothState(Intent r8) {
        int r10 = r8.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        switch(r10) {
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L15;
        };
    L5:
        StringBuilder r11 = new StringBuilder("setBluetoothState 13:");
    L12:
        r11.append(r10);
        String r12 = r11.toString();
    L13:
        Logger.d(BDShakeConfig.TAG, r12);
        return;
    L10:
        r11 = new StringBuilder("setBluetoothState 11:");
        goto L12
    L11:
        stopBleScan();
        r11 = new StringBuilder("setBluetoothState 10 stopBleScan:");
        goto L12
    L15:
        return;
    L7:
        if (this.isStartScanTask == false) goto L9;
        startBleScan();
    L9:
        r12 = "setBluetoothState 12 startBleScan isStartScanTask:" + this.isStartScanTask;
        goto L13
    }

    private void setWifiState(Intent r8) {
        int r10 = r8.getIntExtra("wifi_state", 0);
        if (r10 != 0) goto L5;
        StringBuilder r11 = new StringBuilder("setWifiState 0:");
    L21:
        r11.append(r10);
        Logger.d(BDShakeConfig.TAG, r11.toString());
        return;
    L5:
        if (r10 != 1) goto L7;
        stopWifiScan();
        r11 = new StringBuilder("setWifiState 1:");
        goto L21
    L7:
        if (r10 != 2) goto L9;
        r11 = new StringBuilder("setWifiState 2:");
        goto L21
    L9:
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L23;
        r11 = new StringBuilder("setWifiState 4:");
        goto L21
    L23:
        return;
    L15:
        if (this.isWifiScanRun == true) goto L17;
        startWifiScan();
    L17:
        r11 = new StringBuilder("setWifiState 3:");
        goto L21
    }

    private boolean startBleScan() {
        Logger.d(BDShakeConfig.TAG, "startBleScan:" + BDShakeConfig.isShakeUploadBle());
        if (PermissionManager.hasBluetoothPermissions(this.mContext) == true) goto L6;
        return false;
    L6:
        if (BDShakeConfig.isShakeUploadBle() == true) goto L8;
    L13:
        return false;
    L8:
        if (this.isBleScanRun == true) goto L13;
        if (isBlueToothEnabled() == false) goto L13;
        BDLocationConfig.setEnableScanBle(false);
        this.workHandler.post(new BleScanTask(this, this.mBpeaCert));
        return true;
    }

    private boolean startGetLocation() {
        Logger.d(BDShakeConfig.TAG, "startGetLocation:" + BDShakeConfig.isStartLocationTask());
        if (BDShakeConfig.isStartLocationTask() == true) goto L5;
        return false;
    L5:
        if (this.isLocationRun == true) goto L10;
        this.workHandler.post(new LocationTask(this, this.mBpeaCert));
        return true;
    L10:
        return false;
    }

    private boolean startWifiScan() {
        Logger.d(BDShakeConfig.TAG, "startWifiScan:" + BDShakeConfig.isShakeUploadWifi());
        if (BDShakeConfig.isShakeUploadWifi() == true) goto L5;
        return false;
    L5:
        if (this.isWifiScanRun == false) goto L7;
        return false;
    L7:
        if (isWifiEnabled() == false) goto L13;
        this.workHandler.post(new WifiScanTask(this, this.mBpeaCert));
        return true;
    L13:
        return false;
    }

    private void stopBleScan() {
    L8:
        e = move-exception;
        Logger.d("ShakeScanTask", "stopBleScan error" + e.getMessage());
        return;
    L3:
        if (this.isBleScanRun == false) goto L13;
        BDLocationConfig.setEnableScanBle(true);     // Catch: Exception -> L8
        this.blueToothCollectManager.stopScan();     // Catch: Exception -> L8
        this.isBleScanRun = false;     // Catch: Exception -> L8
        if (mBleInfos == null) goto L14;
        mBleInfos = null;     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private void stopLocationScan() {
        if (this.isLocationRun == false) goto L6;
        this.isLocationRun = false;
        return;
    }

    private void stopWifiScan() {
        if (this.isWifiScanRun == false) goto L8;
        this.isWifiScanRun = false;
        if (mWifiInfos == null) goto L9;
        mWifiInfos = null;
        return;
    L9:
        return;
    }

    private void unRegisterScanReceiver() {
        ScanReceiver r8 = this.receiver;
        if (r8 == null) goto L6;
        this.mContext.unregisterReceiver(r8);
        this.receiver = null;
        return;
    }

    public boolean isBlueToothEnabled() {
        return this.blueToothCollectManager.blueToothIsEnabled();
    }

    public boolean isScanning() {
        if (this.isBleScanRun == false) goto L5;
    L10:
        return true;
    L5:
        if (this.isWifiScanRun == true) goto L10;
        if (this.isLocationRun == true) goto L10;
        return false;
    }

    public boolean isWifiEnabled() {
        WifiManager r8 = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.isWifiEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void setUploadSource(String r8) {
        this.mUploadSource = r8;
    }

    public boolean startScan(Object r8, String r10) {
        this.mBpeaCert = r8;
        this.mBpeaAction = r10;
        boolean r11 = false;
        if (LocationUtil.checkBackground() == false) goto L6;
        return false;
    L6:
        if (this.isBleScanRun == true) goto L8;
    L13:
        this.startScanTime = System.currentTimeMillis();
        boolean r12 = startBleScan();
        boolean r13 = startWifiScan();
        boolean r14 = startGetLocation();
        if (r12 == true) goto L17;
        if (r13 == true) goto L17;
        if (r14 == true) goto L17;
    L18:
        if (r11 == false) goto L20;
        this.isStartScanTask = true;
        registerScanReceiver();
    L20:
        return r11;
    L17:
        r11 = true;
        goto L18
    L8:
        if (this.isWifiScanRun == false) goto L13;
        if (this.isLocationRun == false) goto L13;
        Logger.d(BDShakeConfig.TAG, "ScanTask is running!");
        return false;
    }

    public void stopScan() {
        Logger.d("ShakeScanTask", "stopScan:");     // Catch: Exception -> L5
        stopBleScan();     // Catch: Exception -> L5
        stopWifiScan();     // Catch: Exception -> L5
        stopLocationScan();     // Catch: Exception -> L5
        unRegisterScanReceiver();     // Catch: Exception -> L5
        this.workHandler.removeCallbacksAndMessages(null);     // Catch: Exception -> L5
        this.isStartScanTask = false;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.d("ShakeScanTask", "stopScan error" + e.getMessage());
    }
}
