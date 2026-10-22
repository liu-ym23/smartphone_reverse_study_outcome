package com.bytedance.ttnet.diagnosis;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class TTGameDiagnosisService {
    private static final String TAG = "TTGameDiagnosisService";
    private static volatile TTGameDiagnosisService sInstance;
    private IDiagnosisCallback mDiagnosisCallback;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    static {
    }

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
        this.mDiagnosisCallback = $$Lambda$TTGameDiagnosisService$YUW49OCSvG_BSWATIuphulsviM.INSTANCE;
    }

    public static TTGameDiagnosisService inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTGameDiagnosisService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTGameDiagnosisService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTGameDiagnosisService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static /* synthetic */ void lambda$new$0(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onDiagnosisComplete: " + r3);
        return;
    }

    public void doDiagnosisDuringGaming(String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mRequest.doExtraCommand("diagnosis", r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    public void monitorBegin(String r4, String r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        IDiagnosisRequest r6 = TTNetDiagnosisService.createRequest(4, r4, 0, Integer.MAX_VALUE);     // Catch: Throwable -> L10
        this.mRequest = r6;     // Catch: Throwable -> L10
        r6.start(this.mDiagnosisCallback);     // Catch: Throwable -> L10
        this.mRequest.doExtraCommand("extra_info", r5);     // Catch: Throwable -> L10
        this.mIsMonitoring = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public void monitorEnd() {
        monitorEnd(null);
    }

    public void monitorEnd(String r3) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        if (r3 == null) goto L9;
        this.mRequest.doExtraCommand("extra_info", r3);     // Catch: Throwable -> L12
    L9:
        this.mRequest.doExtraCommand("finish", "");     // Catch: Throwable -> L12
        this.mIsMonitoring = false;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }
}
