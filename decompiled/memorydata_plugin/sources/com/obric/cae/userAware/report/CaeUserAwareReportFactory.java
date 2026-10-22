package com.obric.cae.userAware.report;

import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CaeUserAwareReportFactory {
    private static final String TAG = "CaeUserAwareReportFactory";
    private static volatile CaeUserAwareReportBase sReportInstance;

    public CaeUserAwareReportFactory() {
    }

    public static synchronized void createReportInstance(CaeUserAwareReportBase r5) {
        monitor-enter(CaeUserAwareReportFactory.class);
        String r1 = TAG;     // Catch: Throwable -> L14
        a.c(r1, "Creating report instance");     // Catch: Throwable -> L14
        if (sReportInstance != null) goto L8;
        a.c(r1, "Creating instance: " + r5.getTag());     // Catch: Throwable -> L14
        sReportInstance = r5;     // Catch: Throwable -> L14
    L12:
        monitor-exit(CaeUserAwareReportFactory.class);
        return;
    L8:
        if (r5.getTag().equals(sReportInstance.getTag()) == true) goto L12;
        CaeUserAwareReportBase r2 = sReportInstance;     // Catch: Throwable -> L14
        a.c(r1, "Creating instance: " + r5.getTag());     // Catch: Throwable -> L14
        sReportInstance = r5;     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r2, CaeUserAwareReportJson.class) == false) goto L12;
        r2.cleanup();     // Catch: Throwable -> L14
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
        a.c(TAG, "getReportInstance: null");     // Catch: Throwable -> L13
        monitor-exit(CaeUserAwareReportFactory.class);
        return null;
    L10:
        a.c(TAG, "getReportInstance: " + sReportInstance.getTag());     // Catch: Throwable -> L13
        CaeUserAwareReportBase r1 = sReportInstance;     // Catch: Throwable -> L13
        monitor-exit(CaeUserAwareReportFactory.class);
        return r1;
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
