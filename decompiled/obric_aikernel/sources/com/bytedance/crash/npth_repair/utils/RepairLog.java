package com.bytedance.crash.npth_repair.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class RepairLog {
    private static final String TAG = "NpthRepair";
    private static boolean debuggable = false;

    static {
    }

    public RepairLog() {
    }

    public static void d(Object r10) {
        if (debuggable == false) goto L6;
        Log.d(TAG, String.valueOf(r10));
        return;
    }

    public static void d(String r10, Object r11) {
        if (debuggable == false) goto L6;
        Log.i(TAG, r10 + " " + r11);
        return;
    }

    public static boolean getDebuggable() {
        return debuggable;
    }

    public static void i(Object r10) {
        if (debuggable == false) goto L6;
        Log.i(TAG, String.valueOf(r10));
        return;
    }

    public static void i(String r10, Object r11) {
        if (debuggable == false) goto L6;
        Log.i(TAG, r10 + " " + r11);
        return;
    }

    public static void setDebuggable(boolean r10) {
        debuggable = r10;
    }
}
