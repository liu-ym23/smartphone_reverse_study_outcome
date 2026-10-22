package com.bytedance.crash.npth_repair.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class RepairLog {
    private static final String TAG = "NpthRepair";
    private static boolean debuggable = false;

    static {
    }

    public RepairLog() {
    }

    public static void d(Object r1) {
        if (debuggable == false) goto L6;
        Log.d(TAG, String.valueOf(r1));
        return;
    }

    public static void d(String r1, Object r2) {
        if (debuggable == false) goto L6;
        Log.i(TAG, r1 + " " + r2);
        return;
    }

    public static boolean getDebuggable() {
        return debuggable;
    }

    public static void i(Object r1) {
        if (debuggable == false) goto L6;
        Log.i(TAG, String.valueOf(r1));
        return;
    }

    public static void i(String r1, Object r2) {
        if (debuggable == false) goto L6;
        Log.i(TAG, r1 + " " + r2);
        return;
    }

    public static void setDebuggable(boolean r0) {
        debuggable = r0;
    }
}
