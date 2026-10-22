package com.lynx.base.log;

import com.lynx.base.LynxBaseEnv;
import com.lynx.tasm.service.ILynxLogService;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;
    private static final String TAG = "LynxLog";
    public static final int VERBOSE = 0;
    public static final int WARN = 3;
    private static int sALogMinLogLevel = 2;
    private static AbsBaseLogDelegate sDebugLoggingDelegate = null;
    private static final int sDetectALogDependencyInterval = 500;
    private static boolean sIsJSLogsFromExternalChannelsOpen = false;
    private static boolean sIsNativeLibLoad = false;
    private static final int sMaxTryCounts = 120;
    private static int sTryCounts;
    private static ILynxLogService service;

    public LynxLog() {
    }

    public static void DCHECK(boolean r0) {
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    public static void DTHROW(RuntimeException r0) {
    }

    private static void logByAndroidUtil(int r0, String r1, String r2) {
    }

    private static native void nativeInitALogNative(long r0);

    private static native void nativeInitLynxLoggingNative(boolean r0);

    private static native void nativeInternalLog(int r0, String r1, String r2);

    private static native void nativeSetLogOutputByPlatform();

    private static native void nativeSetNativeMinLogLevel(int r0);

    private static void setLogOutputChannel() {
        ILynxLogService r0 = service;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLogOutputByPlatform() == false) goto L9;
        nativeSetLogOutputByPlatform();
        return;
    }

    public static /* synthetic */ boolean access$000() {
        return detectALogDependence();
    }

    private static void asyncInitLynxNativeLog() {
        if (detectALogDependence() == false) goto L5;
        return;
    L5:
        final PthreadTimer r1 = new PthreadTimer("e/log/LynxLog");
        r1.schedule(new AnonymousClass1(r1), 0, 500);
    }

    private static boolean detectALogDependence() {
        ILynxLogService r0 = (ILynxLogService) n.c().a(ILynxLogService.class);
        service = r0;
        if (r0 == null) goto L5;
        long r3 = r0.getDefaultWriteFunction();
    L7:
        if (r3 == 0) goto L10;
        nativeInitALogNative(r3);
        return true;
    L10:
        int r1 = sTryCounts + 1;
        sTryCounts = r1;
        if (r1 < sMaxTryCounts) goto L13;
        return true;
    L13:
        return false;
    L5:
        r3 = 0;
        goto L7
    }

    public static int getMinimumLoggingLevel() {
        return sALogMinLogLevel;
    }

    public static void initLynxLog(boolean r1) {
    L9:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (sIsNativeLibLoad == true) goto L6;
        sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: ArrayIndexOutOfBoundsException -> L9
    L6:
        if (sIsNativeLibLoad == false) goto L14;
        initLynxLogging(r1);     // Catch: ArrayIndexOutOfBoundsException -> L9
        return;
    }

    private static void initLynxLogging(boolean r0) {
        nativeInitLynxLoggingNative(r0);
        asyncInitLynxNativeLog();
        setLogOutputChannel();
    }

    public static void setDebugLoggingDelegate(AbsBaseLogDelegate r0) {
        sDebugLoggingDelegate = r0;
    }

    public static void setJSLogsFromExternalChannels(boolean r0) {
        sIsJSLogsFromExternalChannelsOpen = r0;
    }

    public static void setMinimumLoggingLevel(int r5) {
    L12:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (sIsNativeLibLoad == true) goto L6;
        sIsNativeLibLoad = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: ArrayIndexOutOfBoundsException -> L12
    L6:
        if (sIsNativeLibLoad == false) goto L16;
        String[] r0 = {"VERBOSE", "DEBUG", "INFO", "WARN", "ERROR"};     // Catch: ArrayIndexOutOfBoundsException -> L12
        int r1 = sALogMinLogLevel;     // Catch: ArrayIndexOutOfBoundsException -> L12
        if (r1 >= r5) goto L10;
        sALogMinLogLevel = r5;     // Catch: ArrayIndexOutOfBoundsException -> L12
        nativeSetNativeMinLogLevel(r5);     // Catch: ArrayIndexOutOfBoundsException -> L12
        String.format("Reset minimum log level as %s", new Object[]{r0[sALogMinLogLevel]});     // Catch: ArrayIndexOutOfBoundsException -> L12
        return;
    L10:
        String.format("Please set a log level higher than %s to filter lynx logs!", new Object[]{r0[r1]});     // Catch: ArrayIndexOutOfBoundsException -> L12
        return;
    }

    public static void d(String r1, String r2) {
        internalLog(1, r1, r2);
    }

    public static void e(String r1, String r2) {
        internalLog(4, r1, r2);
    }

    public static void i(String r1, String r2) {
        internalLog(2, r1, r2);
    }

    public static void v(String r1, String r2) {
        internalLog(0, r1, r2);
    }

    public static void w(String r1, String r2) {
        internalLog(3, r1, r2);
    }

    public static void internalLog(int r1, String r2, String r3) {
        if (r3 == null) goto L25;
        if (r2 == null) goto L28;
        logByDebugLoggingDelegate(r1, r2, r3);
    L21:
        e = move-exception;
        e.getMessage();
        return;
    L7:
        if (sIsNativeLibLoad == true) goto L13;
        boolean r0 = LynxBaseEnv.inst().isNativeLibraryLoaded();     // Catch: UnsatisfiedLinkError -> L21
        sIsNativeLibLoad = r0;     // Catch: UnsatisfiedLinkError -> L21
        if (r0 == true) goto L13;
        logByAndroidUtil(r1, r2, r3);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L13:
        if (r1 < sALogMinLogLevel) goto L26;
        ILynxLogService r4 = service;     // Catch: UnsatisfiedLinkError -> L21
        if (r4 != null) goto L17;
    L19:
        nativeInternalLog(r1, r2, r3);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L17:
        if (r4.isLogOutputByPlatform() == false) goto L19;
        service.logByPlatform(r1, r2, r3);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L26:
        return;
    L28:
        return;
    }

    private static void logByDebugLoggingDelegate(int r2, String r3, String r4) {
        AbsBaseLogDelegate r0 = sDebugLoggingDelegate;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        r0.v(r3, r4);
        return;
    L7:
        if (r2 != 1) goto L9;
        r0.d(r3, r4);
        return;
    L9:
        if (r2 != 2) goto L11;
        r0.i(r3, r4);
        return;
    L11:
        if (r2 != 3) goto L13;
        r0.w(r3, r4);
        return;
    L13:
        if (r2 != 4) goto L25;
        r0.e(r3, r4);
        return;
    }

    private static void log(int r0, String r1, String r2, int r3, long r4, int r6, int r7) {
        if (r0 <= 4) goto L15;
        r0 = 4;
    L15:
        ILynxLogService r5 = service;     // Catch: Throwable -> L12
        if (r5 != null) goto L8;
    L10:
        logByDebugLoggingDelegate(r0, r1, r2);     // Catch: Throwable -> L12
        return;
    L8:
        if (r5.isLogOutputByPlatform() == false) goto L10;
        service.logByPlatform(r0, r1, r2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.getMessage();
    }

    private static void logByte(int r8, String r9, byte[] r10, int r11, long r12, int r14, int r15) {
        log(r8, r9, new String(r10), r11, r12, r14, r15);
    }
}
