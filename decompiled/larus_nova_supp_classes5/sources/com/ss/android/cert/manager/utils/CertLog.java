package com.ss.android.cert.manager.utils;

import android.util.Log;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CertLog {
    private static final String TAG = "CertLog";

    public CertLog() {
    }

    public static String getStackTraceString(Throwable r0) {
        return Log.getStackTraceString(r0);
    }

    public static void d(String r0, String r1) {
        Logger.d(r0, r1);
    }

    public static void e(String r0, String r1) {
        Logger.e(r0, r1);
    }

    public static void i(String r0, String r1) {
        Logger.i(r0, r1);
    }

    public static void v(String r0, String r1) {
        Logger.v(r0, r1);
    }

    public static void w(String r0, String r1) {
        Logger.w(r0, r1);
    }

    public static void e(String r0, String r1, Throwable r2) {
        Logger.e(r0, r1, r2);
    }

    public static void w(String r0, String r1, Throwable r2) {
        Logger.w(r0, r1, r2);
    }
}
