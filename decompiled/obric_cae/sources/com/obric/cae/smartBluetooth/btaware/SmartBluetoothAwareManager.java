package com.obric.cae.smartBluetooth.btaware;

import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.btaware.carkey.SmartBluetoothCarKeyManager;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothAwareListener;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothScanListener;
import com.obric.cae.smartBluetooth.scan.SmartBluetoothBleScanManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothAwareManager {
    private static final String TAG = "SmartBluetoothAwareManager";
    private static SmartBluetoothCarKeyManager mCarKeyManager;
    private static SmartBluetoothEBikeAware mEBikeAware;
    private static SmartBluetoothInCarAware mIncarAware;
    private static volatile SmartBluetoothAwareManager sInstance;
    private final BleScanListener mBleScanListener;
    private final SmartBluetoothBleScanManager mBleScanManager;
    private final List<SmartBluetoothAwareListener> mBluetoothAwareListenerList;
    private final Context mContext;
    private boolean mIsScanning;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.btaware.SmartBluetoothAwareManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BleScanListener implements SmartBluetoothScanListener {
        private BleScanListener() {
        }

        public /* synthetic */ BleScanListener(AnonymousClass1 r8) {
            this();
        }

        @Override // com.obric.cae.smartBluetooth.callback.SmartBluetoothScanListener
        public void onScanResult(int r8, ScanResult r10) {
            if (SmartBluetoothAwareManager.access$100() == null) goto L6;
            SmartBluetoothAwareManager.access$100().onScanResult(r10);
            return;
        }
    }

    private SmartBluetoothAwareManager(Context r8) {
        this.mBleScanListener = new BleScanListener(null);
        this.mBluetoothAwareListenerList = new CopyOnWriteArrayList();
        this.mIsScanning = false;
        CaeLog.w(TAG, TAG);
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mBleScanManager = SmartBluetoothBleScanManager.getInstance(r10);
        mIncarAware = SmartBluetoothInCarAware.getInstance(r10);
        mCarKeyManager = SmartBluetoothCarKeyManager.getInstance(r10);
    }

    public static /* synthetic */ SmartBluetoothEBikeAware access$100() {
        return mEBikeAware;
    }

    public static SmartBluetoothAwareManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothAwareManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothAwareManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothAwareManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void startBleScan() {
        CaeLog.d(TAG, "startBleScan");
        if (this.mIsScanning == false) goto L6;
        return;
    L6:
        if (this.mBluetoothAwareListenerList.isEmpty() == false) goto L8;
        return;
    L8:
        ScanSettings r8 = new ScanSettings.Builder().setScanMode(2).setCallbackType(1).setLegacy(false).build();
        this.mIsScanning = this.mBleScanManager.startScan(null, r8, this.mBleScanListener);
    }

    public void addSmartBluetoothAwareListener(SmartBluetoothAwareListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        List<SmartBluetoothAwareListener> r10 = this.mBluetoothAwareListenerList;
        monitor-enter(r10);
        this.mBluetoothAwareListenerList.add(r8);     // Catch: Throwable -> L12
        CaeLog.d(TAG, "add listener to mBluetoothAwareListenerList");     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (this.mIsScanning == true) goto L17;
        startBleScan();
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        this.mIsScanning = false;
        this.mBleScanManager.stopScan(this.mBleScanListener);
        this.mBluetoothAwareListenerList.clear();
        SmartBluetoothEBikeAware r8 = mEBikeAware;
        if (r8 == null) goto L5;
        r8.cleanup();
    L5:
        sInstance = null;
    }

    public List<SmartBluetoothAwareListener> getSmartBluetoothAwareListenerList() {
        return this.mBluetoothAwareListenerList;
    }

    public void init() {
        CaeLog.d(TAG, "init");
        this.mIsScanning = false;
        mEBikeAware = SmartBluetoothEBikeAware.getInstance(this.mContext);
        SmartBluetoothInCarAware r8 = mIncarAware;
        if (r8 == null) goto L5;
        r8.init();
    L5:
        SmartBluetoothCarKeyManager r10 = mCarKeyManager;
        if (r10 == null) goto L8;
        r10.init();
    L8:
        startBleScan();
    }

    public void onBluetoothBleOn() {
        CaeLog.w(TAG, "onBluetoothBleOn");
        startBleScan();
    }

    public void onBluetoothOff() {
        CaeLog.d(TAG, "onBluetoothOff");
        this.mIsScanning = false;
        this.mBleScanManager.stopScan(this.mBleScanListener);
    }

    public void onEventReported(Bundle r8) {
        CaeLog.d(TAG, "onEventReported, data is " + r8);
        if (r8 != null) goto L5;
        return;
    L5:
        Log.d(TAG, "eventType is " + r8.getInt("event"));
        SmartBluetoothCarKeyManager r10 = mCarKeyManager;
        if (r10 == null) goto L9;
        r10.onEventReported(r8);
        return;
    }

    public void removeSmartBluetoothAwareListener(SmartBluetoothAwareListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        List<SmartBluetoothAwareListener> r10 = this.mBluetoothAwareListenerList;
        monitor-enter(r10);
        this.mBluetoothAwareListenerList.remove(r8);     // Catch: Throwable -> L12
        if (this.mBluetoothAwareListenerList.isEmpty() == false) goto L9;
        this.mBleScanManager.stopScan(this.mBleScanListener);     // Catch: Throwable -> L12
        this.mIsScanning = false;     // Catch: Throwable -> L12
    L9:
        CaeLog.d(TAG, "remove listener from mBluetoothAwareListenerList");     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
