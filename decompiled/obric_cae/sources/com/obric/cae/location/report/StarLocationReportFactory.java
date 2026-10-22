package com.obric.cae.location.report;

import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationReportFactory {
    private static final String TAG = "StarLocation-ReportFactory";
    private static StarLocationReportBase sReportInstance;

    public StarLocationReportFactory() {
    }

    public static synchronized void createReportInstance(StarLocationReportBase r8) {
        monitor-enter(StarLocationReportFactory.class);
        CommSenseLog.d(TAG, "Creating Location report instance");     // Catch: Throwable -> L14
        if (sReportInstance != null) goto L9;
        CommSenseLog.d(TAG, "Creating instance: " + r8.getTag());     // Catch: Throwable -> L14
    L7:
        sReportInstance = r8;     // Catch: Throwable -> L14
    L12:
        monitor-exit(StarLocationReportFactory.class);
        return;
    L9:
        if (r8.getTag().equals(sReportInstance.getTag()) == true) goto L12;
        sReportInstance.cleanup();     // Catch: Throwable -> L14
        CommSenseLog.d(TAG, "Creating instance: " + r8.getTag());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static StarLocationReportBase getReportInstance() {
        return sReportInstance;
    }

    public static void releaseReportInstance() {
        StarLocationReportBase r8 = sReportInstance;
        if (r8 == null) goto L5;
        r8.cleanup();
    L5:
        sReportInstance = null;
    }
}
