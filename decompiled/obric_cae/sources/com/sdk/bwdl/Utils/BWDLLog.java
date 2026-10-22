package com.sdk.bwdl.Utils;

import android.annotation.SuppressLint;
import android.util.Log;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLLog {
    private static final String LOG_TAG = "BWDLLog";

    public BWDLLog() {
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String r8, String r10) {
        if (isLoggable(3) == false) goto L6;
        Log.d(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    public static void e(String r8, String r10) {
        Log.e(LOG_TAG, formatMessage(r8, r10));
    }

    private static String formatMessage(String r8, String r10) {
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        return b.e("<", r8, "> ", r10);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String r8, String r10) {
        if (isLoggable(4) == false) goto L6;
        Log.i(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    public static boolean isLoggable(int r8) {
        if (3 > r8) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setBWDLLogLevel(BWDLConstant.LogLevel r8) {
    }

    @SuppressLint({"LogTagMismatch"})
    public static void v(String r8, String r10) {
        if (isLoggable(2) == false) goto L6;
        Log.v(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void w(String r8, String r10) {
        if (isLoggable(5) == false) goto L6;
        Log.w(LOG_TAG, formatMessage(r8, r10));
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String r8, String r10, Throwable r11) {
        if (isLoggable(3) == false) goto L6;
        Log.d(LOG_TAG, formatMessage(r8, r10), r11);
        return;
    }

    public static void e(String r8, String r10, Throwable r11) {
        Log.e(LOG_TAG, formatMessage(r8, r10), r11);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String r8, String r10, Throwable r11) {
        if (isLoggable(4) == false) goto L6;
        Log.i(LOG_TAG, formatMessage(r8, r10), r11);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void v(String r8, String r10, Throwable r11) {
        if (isLoggable(2) == false) goto L6;
        Log.v(LOG_TAG, formatMessage(r8, r10), r11);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void w(String r8, String r10, Throwable r11) {
        if (isLoggable(5) == false) goto L6;
        Log.w(LOG_TAG, formatMessage(r8, r10), r11);
        return;
    }
}
