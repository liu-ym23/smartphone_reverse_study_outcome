package com.obric.cae.libs.utils;

import android.util.Log;
import defpackage.b;

/* JADX INFO: loaded from: classes.dex */
public class LogUtil {
    public LogUtil() {
    }

    public static void d(String r8) {
        Log.d("CaeLib", r8);
    }

    public static void e(String r8) {
        Log.e("CaeLib", r8);
    }

    public static void i(String r8) {
        Log.i("CaeLib", r8);
    }

    public static boolean isLoggable(int r8) {
        return Log.isLoggable("CaeLib", r8);
    }

    public static void v(String r8) {
        Log.v("CaeLib", r8);
    }

    public static void w(String r8) {
        Log.w("CaeLib", r8);
    }

    public static void d(String r8, String r10) {
        Log.d("CaeLib", "[" + r8 + "] " + r10);
    }

    public static void e(String r8, String r10) {
        Log.e("CaeLib", "[" + r8 + "] " + r10);
    }

    public static void i(String r8, String r10) {
        Log.i("CaeLib", "[" + r8 + "] " + r10);
    }

    public static void v(String r8, String r10) {
        Log.v("CaeLib", "[" + r8 + "] " + r10);
    }

    public static void w(String r8, String r10) {
        Log.w("CaeLib", "[" + r8 + "] " + r10);
    }

    public static void e(String r8, String r10, Throwable r11) {
        Log.e("CaeLib", b.e("[", r8, "] ", r10), r11);
    }

    public static void w(String r8, String r10, Throwable r11) {
        Log.w("CaeLib", b.e("[", r8, "] ", r10), r11);
    }

    public static void e(String r8, Throwable r10) {
        Log.e("CaeLib", r8, r10);
    }

    public static void w(String r8, Throwable r10) {
        Log.w("CaeLib", r8, r10);
    }
}
