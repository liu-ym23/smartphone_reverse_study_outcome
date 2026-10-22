package com.bytedance.ttnet.diagnosis;

import t9.a;

/* JADX INFO: loaded from: classes2.dex */
public class TTGameDiagnosisService {
    private static final String TAG = "TTGameDiagnosisService";
    private static volatile TTGameDiagnosisService sInstance;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static TTGameDiagnosisService inst() {
        if (sInstance != null) goto L16;
        monitor-enter(TTGameDiagnosisService.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new TTGameDiagnosisService();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TTGameDiagnosisService.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void doDiagnosisDuringGaming(String r5) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mRequest.doExtraCommand("diagnosis", r5);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    public void monitorBegin(String r5, String r10) throws Exception {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        IDiagnosisRequest r11 = TTNetDiagnosisService.createRequest(4, r5, 0, Integer.MAX_VALUE);     // Catch: Throwable -> L7
        this.mRequest = r11;     // Catch: Throwable -> L7
        r11.start(new a());     // Catch: Throwable -> L7
        this.mRequest.doExtraCommand("extra_info", r10);     // Catch: Throwable -> L7
        this.mIsMonitoring = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public void monitorEnd() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mRequest.doExtraCommand("finish", "");     // Catch: Throwable -> L7
        this.mIsMonitoring = false;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }
}
