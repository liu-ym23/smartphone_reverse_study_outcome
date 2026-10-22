package com.obric.cae.userAware.report;

import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class CaeUserAwareReportFactory {
    private static final String TAG = "CaeUserAwareReportFactory";
    private static volatile CaeUserAwareReportBase sReportInstance;

    public CaeUserAwareReportFactory() {
    }

    public static synchronized void createReportInstance(CaeUserAwareReportBase r8) {
        monitor-enter(CaeUserAwareReportFactory.class);
        String r10 = TAG;     // Catch: Throwable -> L14
        CommSenseLog.d(r10, "Creating report instance");     // Catch: Throwable -> L14
        if (sReportInstance != null) goto L8;
        CommSenseLog.d(r10, "Creating instance: " + r8.getTag());     // Catch: Throwable -> L14
        sReportInstance = r8;     // Catch: Throwable -> L14
    L12:
        monitor-exit(CaeUserAwareReportFactory.class);
        return;
    L8:
        if (r8.getTag().equals(sReportInstance.getTag()) == true) goto L12;
        CaeUserAwareReportBase r11 = sReportInstance;     // Catch: Throwable -> L14
        CommSenseLog.d(r10, "Creating instance: " + r8.getTag());     // Catch: Throwable -> L14
        sReportInstance = r8;     // Catch: Throwable -> L14
        if ((r11 instanceof CaeUserAwareReportJson) == false) goto L12;
        r11.cleanup();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized CaeUserAwareReportBase getReportInstance() {
        monitor-enter(CaeUserAwareReportFactory.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sReportInstance != null) goto L10;
        CommSenseLog.d(TAG, "getReportInstance: null");     // Catch: Throwable -> L13
        monitor-exit(CaeUserAwareReportFactory.class);
        return null;
    L10:
        CommSenseLog.d(TAG, "getReportInstance: " + sReportInstance.getTag());     // Catch: Throwable -> L13
        CaeUserAwareReportBase r8 = sReportInstance;     // Catch: Throwable -> L13
        monitor-exit(CaeUserAwareReportFactory.class);
        return r8;
    }

    public static synchronized void releaseReportInstance() {
        monitor-enter(CaeUserAwareReportFactory.class);
        sReportInstance = null;     // Catch: Throwable -> L8
        monitor-exit(CaeUserAwareReportFactory.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
