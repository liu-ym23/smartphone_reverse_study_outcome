package com.obric.cae.smartNetwork.qoe;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.SmartNetworkService;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQoEMonitor {
    private static final String TAG = "NetworkQoEMonitor";
    private CellularQoEStateTracker mCellularQoEStateTracker;
    private CellularQoeEvaluate mCellularQoeEvaluate;
    private volatile boolean mRunning;
    private int mStartCount;
    private WiFiQoEStateTracker mWiFiQoEStateTracker;

    public NetworkQoEMonitor(Context r8, SmartNetworkService r10) {
        this.mRunning = false;
        this.mStartCount = 0;
        this.mCellularQoEStateTracker = new CellularQoEStateTracker(r8);
        this.mWiFiQoEStateTracker = new WiFiQoEStateTracker(r8, r10);
        this.mCellularQoeEvaluate = CellularQoeEvaluate.getInstance(r8);
    }

    public void registerCellularQoECallback(CellularQoECallback r8) {
        this.mCellularQoEStateTracker.registerQoECallback(r8);
        if (this.mCellularQoeEvaluate.registerErrReportCb(r8) == true) goto L6;
        CaeLog.e(TAG, "register cellular qoe evaluate callback failed");
        return;
    }

    public void registerWiFiQoECallback(WiFiQoECallback r8) {
        WiFiQoEStateTracker r10 = this.mWiFiQoEStateTracker;
        if (r10 == null) goto L6;
        r10.registerQoECallback(r8);
        return;
    }

    public synchronized void start() {
        monitor-enter(this);
        this.mStartCount++;     // Catch: Throwable -> L9
        String r8 = TAG;     // Catch: Throwable -> L9
        CaeLog.d(r8, "start called, current count: " + this.mStartCount);     // Catch: Throwable -> L9
        if (this.mRunning == true) goto L7;
        this.mRunning = true;     // Catch: Throwable -> L9
        CaeLog.d(r8, "actually starting QoE monitor");     // Catch: Throwable -> L9
        this.mCellularQoEStateTracker.startTracker();     // Catch: Throwable -> L9
        this.mWiFiQoEStateTracker.startTracker();     // Catch: Throwable -> L9
        this.mCellularQoeEvaluate.start();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        int r8 = this.mStartCount;     // Catch: Throwable -> L14
        if (r8 <= 0) goto L8;
        this.mStartCount = r8 - 1;     // Catch: Throwable -> L14
        CaeLog.d(TAG, "stop called, current count: " + this.mStartCount);     // Catch: Throwable -> L14
    L8:
        if (this.mRunning == true) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (this.mStartCount != 0) goto L12;
        CaeLog.d(TAG, "actually stopping QoE monitor");     // Catch: Throwable -> L14
        this.mCellularQoEStateTracker.stopTracker();     // Catch: Throwable -> L14
        this.mWiFiQoEStateTracker.stopTracker();     // Catch: Throwable -> L14
        this.mCellularQoeEvaluate.stop();     // Catch: Throwable -> L14
        this.mRunning = false;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void unregisterCellularQoECallback(CellularQoECallback r8) {
        CellularQoEStateTracker r10 = this.mCellularQoEStateTracker;
        if (r10 == null) goto L5;
        r10.unRegisterQoECallback(r8);
    L5:
        CellularQoeEvaluate r11 = this.mCellularQoeEvaluate;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.unregisterErrReportCb(r8) == true) goto L12;
        CaeLog.e(TAG, "unregister cellular qoe evaluate callback failed");
        return;
    }

    public void unregisterWiFiQoECallback(WiFiQoECallback r8) {
        WiFiQoEStateTracker r10 = this.mWiFiQoEStateTracker;
        if (r10 == null) goto L6;
        r10.unRegisterQoECallback(r8);
        return;
    }
}
