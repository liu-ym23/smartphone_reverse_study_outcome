package com.bytedance.crash.resource;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;

/* JADX INFO: loaded from: classes2.dex */
public class NativeResourceMonitor {
    public NativeResourceMonitor() {
    }

    public static int LoadNativeBridgeSoInit(int r1, int r2, String r3, String r4, String r5, String r6) {
        if (isSoLoaded() == true) goto L7;
        NpthLog.e("NativeBridgeInit fail", "monitorType:" + r2 + " soName:" + r3);
        return -1;
    L7:
        return nNativeBridgeInit(r1, r2, r3, r4, r5, r6);
    }

    public static int StartXasanInit(int r1, String r2, String r3) {
        if (isSoLoaded() == true) goto L7;
        NpthLog.e("NPTH", "xasan load so failed");
        return -1;
    L7:
        return nXasanInit(r1, r2, r3);
    }

    public static void dumpNativeInfoThreads(String r1) {
        if (isSoLoaded() == false) goto L6;
        nDumpNativeInfoThreads(r1);
        return;
    }

    public static int fakeOpen(String r1) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFakeOpen(r1);
    }

    public static int fdTrackDoCommand(int r1) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDoCommand(r1);
    }

    public static int fdTrackDumpNative(int r1, String r2) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDumpNative(r1, r2);
    }

    public static int fdTrackGetFdCount(int r1) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackGetFdCount(r1);
    }

    public static boolean isSoLoaded() {
        return NativeBridge.isSoLoaded();
    }

    private static native void nDumpNativeInfoThreads(String r0);

    private static native int nFakeOpen(String r0);

    private static native int nFdTrackDoCommand(int r0);

    private static native int nFdTrackDumpNative(int r0, String r1);

    private static native int nFdTrackGetFdCount(int r0);

    private static native int nNativeBridgeInit(int r0, int r1, String r2, String r3, String r4, String r5);

    private static native int nNativeDoCommnad(int r0);

    private static native long nNativeGetHeapLeakSize();

    private static native long nNativeGetHeapSize();

    private static native void nNativeNeedDumpMemInfo(int r0);

    private static native void nNativeSetDumpThreshold(long r0);

    private static native void nNativeSetMinSizeByte(long r0);

    private static native int nVmMonitorDoCommand(int r0, int r1);

    private static native void nVmMonitorDumpMaps(String r0);

    private static native int nVmMonitorDumpNative(int r0, int r1, String r2);

    private static native int nXasanInit(int r0, String r1, String r2);

    public static int nativeDoCommnad(int r1) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nNativeDoCommnad(r1);
    }

    public static long nativeGetHeapLeakSize() {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapLeakSize();
    }

    public static long nativeGetHeapSize() {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapSize();
    }

    public static void nativeNeedDumpMemInfo(int r1) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeNeedDumpMemInfo(r1);
    }

    public static void nativeSetDumpThreshold(long r1) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeSetDumpThreshold(r1);
    }

    public static void nativeSetMinSizeByte(int r2) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeSetMinSizeByte(r2);
    }

    public static int vmMonitorDoCommand(int r1, int r2) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDoCommand(r1, r2);
    }

    public static void vmMonitorDumpMaps(String r1) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nVmMonitorDumpMaps(r1);
    }

    public static int vmMonitorDumpNative(int r1, int r2, String r3) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDumpNative(r1, r2, r3);
    }
}
