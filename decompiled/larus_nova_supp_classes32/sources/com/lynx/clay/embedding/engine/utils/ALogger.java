package com.lynx.clay.embedding.engine.utils;

import android.content.Context;
import android.os.Build;
import com.ss.android.agilelogger.ALog;
import t5a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ALogger {
    private static String CLAY_TAG = "clay";
    private static boolean alogEnable;
    private static long alogNativePtr;

    public ALogger() {
    }

    private static native void nativeInitALogNative(long r0, boolean r2);

    public static void Initialize(Context r5) {
        if (alogEnable == false) goto L5;
        return;
    L5:
        boolean r6 = false;
        long r2 = ((Long) a.a().getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();     // Catch: Throwable -> L8
    L9:
        alogNativePtr = r2;     // Catch: Throwable -> L16
        if (r2 != 0) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT <= 24) goto L14;
        r6 = true;
    L14:
        nativeInitALogNative(alogNativePtr, r6);     // Catch: Throwable -> L16
        alogEnable = true;     // Catch: Throwable -> L16
        return;
    L8:
        r2 = 0;
    }

    public static void d(String r1) {
        if (alogEnable == false) goto L6;
        ALog.d(CLAY_TAG, r1);
        return;
    }

    public static void e(String r1) {
        if (alogEnable == false) goto L6;
        ALog.e(CLAY_TAG, r1);
        return;
    }

    public static void i(String r1) {
        if (alogEnable == false) goto L6;
        ALog.i(CLAY_TAG, r1);
        return;
    }

    public static void v(String r1) {
        if (alogEnable == false) goto L6;
        ALog.v(CLAY_TAG, r1);
        return;
    }

    public static void w(String r1) {
        if (alogEnable == false) goto L6;
        ALog.w(CLAY_TAG, r1);
        return;
    }
}
