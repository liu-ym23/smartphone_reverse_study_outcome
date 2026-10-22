package com.bytedance.bdinstall.dtrait;

import com.bytedance.bdinstall.dtrait.interfaces.IDTraitLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DTLog {
    public static boolean DEBUG = false;
    static final String TAG = "[dt] ";
    private static IDTraitLog logger;

    static {
    }

    public DTLog() {
    }

    public static void d(String r3) {
        IDTraitLog r0 = logger;
        if (r0 == null) goto L6;
        r0.d("[dt] " + r3, null);
        return;
    }

    public static boolean debug() {
        return DEBUG;
    }

    public static void e(String r3) {
        IDTraitLog r0 = logger;
        if (r0 == null) goto L6;
        r0.e("[dt] " + r3, null);
        return;
    }

    public static void e(String r3, Throwable r4) {
        IDTraitLog r0 = logger;
        if (r0 == null) goto L6;
        r0.e("[dt] " + r3, r4);
        return;
    }

    public static void i(String r3, Throwable r4) {
        IDTraitLog r0 = logger;
        if (r0 == null) goto L6;
        r0.i("[dt] " + r3, r4);
        return;
    }

    public static void setLogger(IDTraitLog r2) {
        logger = (IDTraitLog) ZeusTransformUtils.wrapperContextForParams(r2, IDTraitLog.class, "com.obric.memorydata.plugin");
    }

    public static void w(String r3, Throwable r4) {
        IDTraitLog r0 = logger;
        if (r0 == null) goto L6;
        r0.w("[dt] " + r3, r4);
        return;
    }
}
