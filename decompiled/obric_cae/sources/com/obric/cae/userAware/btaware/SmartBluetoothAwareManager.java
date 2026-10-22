package com.obric.cae.userAware.btaware;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.obric.cae.log.CommSenseLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SmartBluetoothAwareManager {
    private static final String TAG = "SmartBluetoothAwareManager";
    private static SmartBluetoothEBikeAware mEBikeAware;
    private static volatile SmartBluetoothAwareManager sInstance;
    private final List<SmartBluetoothAwareListener> mBluetoothAwareListenerList;
    private final Context mContext;

    private SmartBluetoothAwareManager(Context r8) {
        this.mBluetoothAwareListenerList = new CopyOnWriteArrayList();
        CommSenseLog.w(TAG, TAG);
        this.mContext = r8.getApplicationContext();
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

    public void addSmartBluetoothAwareListener(SmartBluetoothAwareListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        List<SmartBluetoothAwareListener> r10 = this.mBluetoothAwareListenerList;
        monitor-enter(r10);
        this.mBluetoothAwareListenerList.add(r8);     // Catch: Throwable -> L9
        CommSenseLog.d(TAG, "add listener to mBluetoothAwareListenerList");     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
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
        CommSenseLog.d(TAG, "init");
        mEBikeAware = SmartBluetoothEBikeAware.getInstance(this.mContext);
    }

    public void onScanResult(int r8, ScanResult r10) {
        CommSenseLog.d(TAG, "onScanResult " + r10.getDevice());
        SmartBluetoothEBikeAware r11 = mEBikeAware;
        if (r11 == null) goto L6;
        r11.onScanResult(r10);
        return;
    }

    public void removeSmartBluetoothAwareListener(SmartBluetoothAwareListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        List<SmartBluetoothAwareListener> r10 = this.mBluetoothAwareListenerList;
        monitor-enter(r10);
        this.mBluetoothAwareListenerList.remove(r8);     // Catch: Throwable -> L9
        CommSenseLog.d(TAG, "remove listener from mBluetoothAwareListenerList");     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
