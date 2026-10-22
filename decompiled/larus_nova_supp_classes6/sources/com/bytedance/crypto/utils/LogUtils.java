package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.ILogBridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;
    private static ILogBridge mLogBridge;

    static {
        LOG_DEBUG = CryptoConfig.isDebug();
    }

    public LogUtils() {
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L8;
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L9;
        r0.i(r1, r2);
        return;
    L9:
        return;
    }

    public static void d(String r0, String r1, Throwable r2) {
        if (LOG_DEBUG == false) goto L8;
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L9;
        r3.i(r0, r1);
        return;
    L9:
        return;
    }

    public static void e(String r1, String r2) {
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void e(String r0, String r1, Throwable r2) {
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.e(r0, r1);
        return;
    }

    public static void i(String r1, String r2) {
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.i(r0, r1);
        return;
    }

    public static void init(ILogBridge r0) {
        mLogBridge = r0;
    }

    public static void w(String r1, String r2) {
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }
}
