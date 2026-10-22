package com.bytedance.vmsdk.log;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import gk.a;
import java.util.Timer;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public class VLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "VLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static long alogNativePtr = 0;
    private static final int sDefaultLogLevel = 6;
    private static final int sDetectALogDependencyInterval = 500;
    private static final int sMaxTryCounts = 120;
    private static int[] sNativeLevelMap = null;
    private static int sNativeMinLogLevel = 6;
    private static int sTryCounts;

    public VLog() {
    }

    public static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    public static void d(String r5, String r10) {
        internalLog(3, r5, r10);
    }

    private static boolean detectALogDependence() {
        long r5 = j.a();
        if (r5 == 0) goto L6;
        initALog(r5);
        Log.i(TAG, "ALog dependency load successfully");
        return true;
    L6:
        int r10 = sTryCounts + 1;
        sTryCounts = r10;
        if (r10 != 120) goto L10;
        Log.e(TAG, "Get ALog dependency failed");
        return true;
    L10:
        return false;
    }

    public static void e(String r5, String r10) {
        internalLog(6, r5, r10);
    }

    @CalledByNative
    private static long getALogPtr() {
        return alogNativePtr;
    }

    public static void i(String r5, String r10) {
        internalLog(4, r5, r10);
    }

    public static void init() {
        onEnvReady();     // Catch: Throwable -> L6
        long r5 = j.a();     // Catch: Throwable -> L6
        if (r5 == 0) goto L10;
        initALog(r5);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    L6:
        Log.e(TAG, "vmsdk alog init fail");
    }

    public static void initALog(long r5) {
        alogNativePtr = r5;
        nativeInitALogNative(r5, true);
    }

    @CalledByNative
    private static void initALogLazy() {
        loadALogDependency();
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap != null) goto L6;
        sNativeLevelMap = new int[]{0, 0, -1, 0, 0, 1, 2, 3};
        return;
    }

    public static void internalLog(int r5, String r10, String r11) {
        nativeInternalLog(r5, r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e(TAG, th.getMessage());
    }

    private static void loadALogDependency() {
        if (detectALogDependence() == true) goto L6;
        new Timer().schedule(new a(), 0, 500);
        return;
    }

    private static native void nativeInitALogNative(long r5, boolean r10);

    private static native void nativeInternalLog(int r5, String r10, String r11);

    private static native void nativeSetNativeMinLogLevel(int r5);

    public static void onEnvReady() {
        setMinimumLoggingLevel(4);
    }

    public static void setMinimumLoggingLevel(int r5) {
        initNativeLogLevelMap();     // Catch: ArrayIndexOutOfBoundsException -> L6
        nativeSetNativeMinLogLevel(sNativeLevelMap[r5]);     // Catch: ArrayIndexOutOfBoundsException -> L6
        if (sNativeMinLogLevel == r5) goto L11;
        sNativeMinLogLevel = r5;     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("vmsdk", "Please check index, " + e.getMessage());
        sNativeMinLogLevel = 6;
        nativeSetNativeMinLogLevel(sNativeLevelMap[6]);
    }

    public static void v(String r5, String r10) {
        internalLog(2, r5, r10);
    }

    public static void w(String r5, String r10) {
        internalLog(5, r5, r10);
    }
}
