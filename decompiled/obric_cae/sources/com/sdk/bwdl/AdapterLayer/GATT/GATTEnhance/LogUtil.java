package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.util.Log;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class LogUtil {
    private static final String TAG = "Connectivity";

    public LogUtil() {
    }

    public static void d(String r8) {
        Log.d(TAG, r8);
    }

    public static void e(String r8) {
        Log.e(TAG, r8);
    }

    public static void i(String r8) {
        Log.i(TAG, r8);
    }

    public static boolean isLoggable(int r8) {
        return Log.isLoggable(TAG, r8);
    }

    public static void v(String r8) {
        Log.v(TAG, r8);
    }

    public static void w(String r8) {
        Log.w(TAG, r8);
    }

    public static void d(String r8, String r10) {
        Log.d(TAG, "[" + r8 + "] " + r10);
    }

    public static void e(String r8, String r10) {
        Log.e(TAG, "[" + r8 + "] " + r10);
    }

    public static void i(String r8, String r10) {
        Log.i(TAG, "[" + r8 + "] " + r10);
    }

    public static void v(String r8, String r10) {
        Log.v(TAG, "[" + r8 + "] " + r10);
    }

    public static void w(String r8, String r10) {
        Log.w(TAG, "[" + r8 + "] " + r10);
    }

    public static void e(String r8, String r10, Throwable r11) {
        Log.e(TAG, b.e("[", r8, "] ", r10), r11);
    }

    public static void w(String r8, String r10, Throwable r11) {
        Log.w(TAG, b.e("[", r8, "] ", r10), r11);
    }

    public static void e(String r8, Throwable r10) {
        Log.e(TAG, r8, r10);
    }

    public static void w(String r8, Throwable r10) {
        Log.w(TAG, r8, r10);
    }
}
