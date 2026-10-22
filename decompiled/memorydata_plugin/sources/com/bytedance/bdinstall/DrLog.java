package com.bytedance.bdinstall;

import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DrLog {
    public static boolean DEBUG = false;
    public static final int SDK_VERSION_CODE = 0;
    static final String TAG = "bdinstall# ";
    private static final String USNP = "U SHALL NOT PASS!";
    private static ILogger logger;

    static {
        SDK_VERSION_CODE = LocalConstants.getVersionCode();
    }

    public DrLog() {
    }

    public static void d(String r3) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.d(TAG + r3, null);
        return;
    }

    public static boolean debug() {
        return DEBUG;
    }

    public static void e(String r3) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.e(TAG + r3, null);
        return;
    }

    public static void e(String r3, Throwable r4) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.e(TAG + r3, r4);
        return;
    }

    public static void i(String r3, Throwable r4) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.i(TAG + r3, r4);
        return;
    }

    static void setLogger(ILogger r2) {
        logger = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
    }

    public static void v(String r3) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.v(TAG + r3, null);
        return;
    }

    public static void v(String r3, Throwable r4) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.v(TAG + r3, r4);
        return;
    }

    public static void w(String r3, Throwable r4) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.w(TAG + r3, r4);
        return;
    }

    public static void ysnp(Throwable r2) {
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.e(USNP, r2);
        return;
    }
}
