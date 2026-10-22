package com.bytedance.crash.util;

import android.util.Log;
import com.bytedance.crash.config.RuntimeConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class NpthLog {
    private static final String TAG = "NPTH";

    public NpthLog() {
    }

    public static void d(Object r1) {
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        Log.d(TAG, String.valueOf(r1));
        return;
    }

    public static void d(String r1, Object r2) {
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        Log.i(TAG, r1 + " " + r2);
        return;
    }

    public static void e(String r1, Object r2) {
        Log.e(TAG, r1 + " " + r2);
    }

    public static void e(String r1, Object r2, Throwable r3) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.e(TAG, r1 + " " + r2, r3);
        return;
    }

    public static void e(String r1, Throwable r2) {
        Log.e(TAG, r1, r2);
    }

    public static void e(Throwable r1) {
        e("", r1);
    }

    public static void i(Object r1) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.i(TAG, String.valueOf(r1));
        return;
    }

    public static void i(String r1, Object r2) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.i(TAG, r1 + " " + r2);
        return;
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void w(String r1, String r2) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r1, r2);
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r1, r2, r3);
        return;
    }

    public static void w(String r1, Throwable r2) {
        if (RuntimeConfig.isDebugMode() == false) goto L6;
        Log.w(r1, r2);
        return;
    }

    public static void w(Throwable r1) {
        w(TAG, r1);
    }
}
