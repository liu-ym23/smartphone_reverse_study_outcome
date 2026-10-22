package com.bytedance.crypto.utils;

import android.util.Log;
import com.bytedance.crypto.bridge.ILogBridge;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;
    private static ILogBridge mLogBridge;

    static {
        LOG_DEBUG = CryptoConfig.isDebug();
    }

    public LogUtils() {
    }

    public static void d(String r10, String r11) {
        if (LOG_DEBUG == false) goto L8;
        Log.i(r10, r11);
        ILogBridge r12 = mLogBridge;
        if (r12 == null) goto L9;
        r12.i(r10, r11);
        return;
    L9:
        return;
    }

    public static void d(String r10, String r11, Throwable r12) {
        if (LOG_DEBUG == false) goto L8;
        Log.i(r10, r11);
        ILogBridge r13 = mLogBridge;
        if (r13 == null) goto L9;
        r13.i(r10, r11);
        return;
    L9:
        return;
    }

    public static void e(String r10, String r11) {
        Log.e(r10, r11);
        ILogBridge r12 = mLogBridge;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        Log.e(r10, r11);
        ILogBridge r13 = mLogBridge;
        if (r13 == null) goto L6;
        r13.e(r10, r11);
        return;
    }

    public static void i(String r10, String r11) {
        Log.i(r10, r11);
        ILogBridge r12 = mLogBridge;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    public static void i(String r10, String r11, Throwable r12) {
        Log.i(r10, r11);
        ILogBridge r13 = mLogBridge;
        if (r13 == null) goto L6;
        r13.i(r10, r11);
        return;
    }

    public static void init(ILogBridge r10) {
        mLogBridge = r10;
    }

    public static void w(String r10, String r11) {
        Log.w(r10, r11);
        ILogBridge r12 = mLogBridge;
        if (r12 == null) goto L6;
        r12.w(r10, r11);
        return;
    }
}
