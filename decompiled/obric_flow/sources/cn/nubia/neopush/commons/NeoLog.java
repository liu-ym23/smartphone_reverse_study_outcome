package cn.nubia.neopush.commons;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NeoLog {
    private static final String TAG = "NubiaPush";
    public static boolean isShowLog = false;

    public NeoLog() {
    }

    public static void d(String r5) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.d(TAG, r5);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void e(String r5) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.e(TAG, r5);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void i(String r5) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.i(TAG, r5);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void v(String r5) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.v(TAG, r5);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void w(String r5) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.w(TAG, r5);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void d(String r5, String r10) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.d(r5, r10);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void e(String r5, String r10) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.e(r5, r10);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void i(String r5, String r10) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.i(r5, r10);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void v(String r5, String r10) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.v(r5, r10);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }

    public static void w(String r5, String r10) {
        if (BuildConfig.isDebug() == false) goto L5;
    L6:
        Log.w(r5, r10);
        return;
    L5:
        if (isShowLog == true) goto L6;
    }
}
