package com.bytedance.crash.resource;

import androidx.annotation.Keep;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;

/* JADX INFO: loaded from: classes.dex */
public class NativeResourceMonitor {
    public NativeResourceMonitor() {
    }

    public static int LoadNativeBridgeSoInit(int r10, int r11, String r12, String r13, String r14, String r15) {
        if (isSoLoaded() == true) goto L7;
        NpthLog.e("NativeBridgeInit fail", "monitorType:" + r11 + " soName:" + r12);
        return -1;
    L7:
        return nNativeBridgeInit(r10, r11, r12, r13, r14, r15);
    }

    public static int StartXasanInit(int r10, String r11, String r12) {
        if (isSoLoaded() == true) goto L7;
        NpthLog.e("NPTH", "xasan load so failed");
        return -1;
    L7:
        return nXasanInit(r10, r11, r12);
    }

    public static void dumpNativeInfoThreads(String r10) {
        if (isSoLoaded() == false) goto L6;
        nDumpNativeInfoThreads(r10);
        return;
    }

    public static int fakeOpen(String r10) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFakeOpen(r10);
    }

    public static int fdTrackDoCommand(int r10) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDoCommand(r10);
    }

    public static int fdTrackDumpNative(int r10, String r11) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDumpNative(r10, r11);
    }

    public static int fdTrackGetFdCount(int r10) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nFdTrackGetFdCount(r10);
    }

    public static boolean isSoLoaded() {
        return NativeBridge.isSoLoaded();
    }

    @Keep
    private static native void nDumpNativeInfoThreads(String r10);

    @Keep
    private static native int nFakeOpen(String r10);

    @Keep
    private static native int nFdTrackDoCommand(int r10);

    @Keep
    private static native int nFdTrackDumpNative(int r10, String r11);

    @Keep
    private static native int nFdTrackGetFdCount(int r10);

    @Keep
    private static native int nNativeBridgeInit(int r10, int r11, String r12, String r13, String r14, String r15);

    @Keep
    private static native int nNativeDoCommnad(int r10);

    @Keep
    private static native long nNativeGetHeapLeakSize();

    @Keep
    private static native long nNativeGetHeapSize();

    @Keep
    private static native void nNativeNeedDumpMemInfo(int r10);

    @Keep
    private static native void nNativeSetDumpThreshold(long r10);

    @Keep
    private static native void nNativeSetMinSizeByte(long r10);

    @Keep
    private static native int nVmMonitorDoCommand(int r10, int r11);

    @Keep
    private static native void nVmMonitorDumpMaps(String r10);

    @Keep
    private static native int nVmMonitorDumpNative(int r10, int r11, String r12);

    @Keep
    private static native int nXasanInit(int r10, String r11, String r12);

    public static int nativeDoCommnad(int r10) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nNativeDoCommnad(r10);
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

    public static void nativeNeedDumpMemInfo(int r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeNeedDumpMemInfo(r10);
    }

    public static void nativeSetDumpThreshold(long r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeSetDumpThreshold(r10);
    }

    public static void nativeSetMinSizeByte(int r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nNativeSetMinSizeByte(r10);
    }

    public static int vmMonitorDoCommand(int r10, int r11) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDoCommand(r10, r11);
    }

    public static void vmMonitorDumpMaps(String r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        nVmMonitorDumpMaps(r10);
    }

    public static int vmMonitorDumpNative(int r10, int r11, String r12) {
        if (isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDumpNative(r10, r11, r12);
    }
}
