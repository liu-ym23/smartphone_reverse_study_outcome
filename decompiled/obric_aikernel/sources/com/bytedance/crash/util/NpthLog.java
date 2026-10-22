package com.bytedance.crash.util;

import android.util.Log;
import com.bytedance.crash.config.RuntimeConfig;

/* JADX INFO: loaded from: classes.dex */
public final class NpthLog {
    private static final String TAG = "NPTH";

    public NpthLog() {
    }

    public static void d(Object r10) {
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        Log.d(TAG, String.valueOf(r10));
        return;
    }

    public static void d(String r10, Object r11) {
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        Log.i(TAG, r10 + " " + r11);
        return;
    }

    public static void e(String r10, Object r11) {
        Log.e(TAG, r10 + " " + r11);
    }

    public static void e(String r10, Object r11, Throwable r12) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.e(TAG, r10 + " " + r11, r12);
        return;
    }

    public static void e(String r10, Throwable r11) {
        Log.e(TAG, r10, r11);
    }

    public static void e(Throwable r10) {
        e("", r10);
    }

    public static void i(Object r10) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.i(TAG, String.valueOf(r10));
        return;
    }

    public static void i(String r10, Object r11) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.i(TAG, r10 + " " + r11);
        return;
    }

    public static void w(String r10) {
        w(TAG, r10);
    }

    public static void w(String r10, String r11) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r10, r11);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r10, r11, r12);
        return;
    }

    public static void w(String r10, Throwable r11) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r10, r11);
        return;
    }

    public static void w(Throwable r10) {
        w(TAG, r10);
    }
}
