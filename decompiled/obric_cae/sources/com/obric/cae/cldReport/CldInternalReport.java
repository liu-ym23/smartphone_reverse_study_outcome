package com.obric.cae.cldReport;

import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes.dex */
public final class CldInternalReport {
    private static final String TAG = "CldInternalReport";
    private static volatile CldReportService mCldReportService;

    private CldInternalReport() {
    }

    public static void addCldReportService(CldReportService r8) {
        monitor-enter(CldInternalReport.class);
        mCldReportService = r8;     // Catch: Throwable -> L7
        monitor-exit(CldInternalReport.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void reportErrorEvent(int r8, int r10, int r11, int r12, String r13) {
        monitor-enter(CldInternalReport.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (mCldReportService != null) goto L9;
        CaeLog.e(TAG, "CldReportService not registered.");     // Catch: Throwable -> L12
        monitor-exit(CldInternalReport.class);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(CldInternalReport.class);     // Catch: Throwable -> L12
        mCldReportService.internalReportErrorEvent(r8, r10, r11, r12, r13);
    }
}
