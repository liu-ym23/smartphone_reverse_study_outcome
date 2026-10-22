package com.bytedance.bdinstall;

import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes.dex */
public class DrLog {
    public static boolean DEBUG = false;
    public static final int SDK_VERSION_CODE = 0;
    static final String TAG = "DrLog";
    private static final String USNP = "U SHALL NOT PASS!";
    private static ILogger logger;

    static {
        SDK_VERSION_CODE = LocalConstants.getVersionCode();
    }

    public DrLog() {
    }

    public static void d(String r10) {
        ILogger r11 = logger;
        if (r11 == null) goto L6;
        r11.d(r10, null);
        return;
    }

    public static boolean debug() {
        return DEBUG;
    }

    public static void e(String r10) {
        ILogger r11 = logger;
        if (r11 == null) goto L6;
        r11.e(r10, null);
        return;
    }

    public static void e(String r10, Throwable r11) {
        ILogger r12 = logger;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void i(String r10, Throwable r11) {
        ILogger r12 = logger;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    static void setLogger(ILogger r10) {
        logger = r10;
    }

    public static void v(String r10) {
        ILogger r11 = logger;
        if (r11 == null) goto L6;
        r11.v(r10, null);
        return;
    }

    public static void v(String r10, Throwable r11) {
        ILogger r12 = logger;
        if (r12 == null) goto L6;
        r12.v(r10, r11);
        return;
    }

    public static void w(String r10, Throwable r11) {
        ILogger r12 = logger;
        if (r12 == null) goto L6;
        r12.w(r10, r11);
        return;
    }

    public static void ysnp(Throwable r10) {
        ILogger r11 = logger;
        if (r11 == null) goto L6;
        r11.e(USNP, r10);
        return;
    }
}
