package com.obric.cae.smartBluetooth;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothService extends Service {
    private static final String TAG = "SmartBluetoothService";
    private static SmartBluetoothEventReceiver sSmartBluetoothEventReceiver;
    private static SmartBluetoothManager sSmartBluetoothManager;
    private static SmartBluetoothService sSmartBluetoothService;

    public SmartBluetoothService() {
    }

    public static SmartBluetoothManager getSmartBluetoothManager() {
        return sSmartBluetoothManager;
    }

    public static synchronized SmartBluetoothService getSmartBluetoothService() {
        monitor-enter(SmartBluetoothService.class);
        SmartBluetoothService r8 = sSmartBluetoothService;     // Catch: Throwable -> L12
        if (r8 != null) goto L10;
        CaeLog.w(TAG, "getSmartBluetoothService(): service is null");     // Catch: Throwable -> L12
        monitor-exit(SmartBluetoothService.class);
        return null;
    L10:
        monitor-exit(SmartBluetoothService.class);
        return r8;
    L12:
        th = move-exception;
        throw th;
    }

    private void registerSmartBluetoothReceiver() {
        if (sSmartBluetoothEventReceiver == null) goto L5;
        return;
    L5:
        sSmartBluetoothEventReceiver = SmartBluetoothEventReceiver.getInstance(this);
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r8.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        r8.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        r8.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r8.addAction("android.bluetooth.device.action.FOUND");
        r8.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r8.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        r8.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r8.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        r8.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        r8.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        r8.addAction("android.bluetooth.device.action.UUID");
        r8.addAction("android.bluetooth.adapter.action.BLE_STATE_CHANGED");
        registerReceiver(sSmartBluetoothEventReceiver, r8, 2);
    }

    private static synchronized void setSmartBluetoothService(SmartBluetoothService r8) {
        monitor-enter(SmartBluetoothService.class);
        sSmartBluetoothService = r8;     // Catch: Throwable -> L7
        monitor-exit(SmartBluetoothService.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CaeLog.d(TAG, "onBind");
        return new SmartBluetoothBinderServer(this, getApplicationContext());
    }

    @Override // android.app.Service
    public void onCreate() {
        CaeLog.d(TAG, "onCreate");
        registerSmartBluetoothReceiver();
        SmartBluetoothManager r8 = SmartBluetoothManager.getInstance(this);
        sSmartBluetoothManager = r8;
        r8.init();
        setSmartBluetoothService(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        CaeLog.d(TAG, "onDestroy");
        SmartBluetoothManager r8 = sSmartBluetoothManager;
        if (r8 == null) goto L5;
        r8.cleanup();
    L5:
        setSmartBluetoothService(null);
        SmartBluetoothEventReceiver r10 = sSmartBluetoothEventReceiver;
        if (r10 == null) goto L8;
        unregisterReceiver(r10);
    L8:
        SmartBluetoothEventReceiver.clean();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        CaeLog.d(TAG, "onStartCommand");
        registerSmartBluetoothReceiver();
        return super.onStartCommand(r8, r10, r11);
    }
}
