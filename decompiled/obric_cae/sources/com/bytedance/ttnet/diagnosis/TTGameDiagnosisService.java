package com.bytedance.ttnet.diagnosis;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class TTGameDiagnosisService {
    private static final String TAG = "TTGameDiagnosisService";
    private static volatile TTGameDiagnosisService sInstance;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    public class a implements IDiagnosisCallback {
        @Override // com.bytedance.ttnet.diagnosis.IDiagnosisCallback
        public final void onDiagnosisComplete(String r8) {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTGameDiagnosisService.access$000(), "onDiagnosisComplete: " + r8);
            return;
        }
    }

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
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

    public void doDiagnosisDuringGaming(String r8) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mRequest.doExtraCommand("diagnosis", r8);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    public void monitorBegin(String r8, String r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        IDiagnosisRequest r11 = TTNetDiagnosisService.createRequest(4, r8, 0, Integer.MAX_VALUE);     // Catch: Throwable -> L10
        this.mRequest = r11;     // Catch: Throwable -> L10
        r11.start(new a());     // Catch: Throwable -> L10
        this.mRequest.doExtraCommand("extra_info", r10);     // Catch: Throwable -> L10
        this.mIsMonitoring = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public void monitorEnd() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mRequest.doExtraCommand("finish", "");     // Catch: Throwable -> L10
        this.mIsMonitoring = false;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }
}
