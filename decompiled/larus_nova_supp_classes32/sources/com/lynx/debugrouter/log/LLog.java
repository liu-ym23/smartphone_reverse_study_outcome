package com.lynx.debugrouter.log;

import com.lynx.debugrouter.DebugRouter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int REPORT = 8;
    private static final String TAG = "DebugRouter_LLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static Integer currentId = null;
    private static final int sDefaultLogLevel = 6;
    private static int sHandlerId = -1;
    private static final ConcurrentHashMap<Integer, ILogDelegate> sHandlerMap = null;
    private static int[] sNativeLevelMap;
    private static int sNativeMinLogLevel;

    public LLog() {
    }

    private static native void nativeSetHasLoggingDelegate(boolean r0);

    private static native void nativeSetNativeMinLogLevel(int r0);

    static {
        sHandlerMap = new ConcurrentHashMap();
        currentId = 0;
        sNativeMinLogLevel = 6;
    }

    public static synchronized void addDebugLoggingDelegate() {
        monitor-enter(LLog.class);
        addLoggingDelegate(new AnonymousClass1());     // Catch: Throwable -> L7
        monitor-exit(LLog.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getMinimumLoggingLevel() {
        ILogDelegate r0 = sHandlerMap.get(Integer.valueOf(sHandlerId));
        if (r0 != null) goto L5;
        return 4;
    L5:
        return r0.getMinimumLoggingLevel();
    }

    private static void initNativeLogLevelMap() {
        if (sNativeLevelMap != null) goto L6;
        sNativeLevelMap = new int[]{0, 0, -1, 0, 0, 1, 2, 3, 5};
        return;
    }

    private static void resetMinLogLevel() {
        Iterator<Map.Entry<Integer, ILogDelegate>> r0 = sHandlerMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ILogDelegate r1 = r0.next().getValue();
        int r2 = sNativeMinLogLevel;
        if (r2 == 6) goto L7;
        sNativeMinLogLevel = Math.min(r2, r1.getMinimumLoggingLevel());
        goto L4
    L7:
        sNativeMinLogLevel = r1.getMinimumLoggingLevel();
        goto L4
    L9:
        setMinimumLoggingLevel(sNativeMinLogLevel);
    }

    private static void ensureNativeLibraryLoaded() {
        if (DebugRouter.isNativeLibraryLoaded() == true) goto L6;
        DebugRouter.loadNativeLibrary();
        return;
    }

    public static synchronized int addLoggingDelegate(AbsLogDelegate r5) {
        monitor-enter(LLog.class);
        ensureNativeLibraryLoaded();     // Catch: Throwable -> L18
        if (r5 != null) goto L9;
        monitor-exit(LLog.class);
        return -1;
    L9:
        Integer r2 = Integer.valueOf(currentId.intValue() + 1);     // Catch: Throwable -> L18
        currentId = r2;     // Catch: Throwable -> L18
        if (r5.type() != 1) goto L15;
        int r4 = sHandlerId;     // Catch: Throwable -> L18
        if (r4 == (-1)) goto L14;
        sHandlerMap.remove(Integer.valueOf(r4));     // Catch: Throwable -> L18
    L14:
        sHandlerId = r2.intValue();     // Catch: Throwable -> L18
        resetMinLogLevel();     // Catch: Throwable -> L18
    L15:
        sHandlerMap.put(r2, r5);     // Catch: Throwable -> L18
        nativeSetHasLoggingDelegate(true);     // Catch: Throwable -> L18
        int r6 = r2.intValue();     // Catch: Throwable -> L18
        monitor-exit(LLog.class);
        return r6;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeLoggingDelegate(int r2) {
        monitor-enter(LLog.class);
        sHandlerMap.remove(Integer.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(LLog.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setMinimumLoggingLevel(int r1) {
        ensureNativeLibraryLoaded();
        if (sNativeMinLogLevel == r1) goto L9;
        sNativeMinLogLevel = r1;
    L9:
        initNativeLogLevelMap();     // Catch: Throwable -> L7
        nativeSetNativeMinLogLevel(sNativeLevelMap[r1]);     // Catch: Throwable -> L7
        return;
    L7:
        sNativeMinLogLevel = 6;
        nativeSetNativeMinLogLevel(sNativeLevelMap[6]);
    }

    public static void d(String r1, String r2) {
        internalLog(3, r1, r2);
    }

    public static void e(String r1, String r2) {
        internalLog(6, r1, r2);
    }

    public static void i(String r1, String r2) {
        internalLog(4, r1, r2);
    }

    public static void report(String r1, String r2) {
        internalLog(8, r1, r2);
    }

    public static void v(String r1, String r2) {
        internalLog(2, r1, r2);
    }

    public static void w(String r1, String r2) {
        internalLog(5, r1, r2);
    }

    public static void internalLog(int r1, String r2, String r3) {
        internalLog(r1, r2, r3, LogSource.JAVA);
    }

    private static void log(int r1, String r2, String r3) {
        if (r1 == 7) goto L11;
        internalLog(r1, r2, r3, LogSource.Native);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.getMessage();
        return;
    }

    public static void internalLog(int r2, String r3, String r4, LogSource r5) {
        Iterator<ILogDelegate> r6 = sHandlerMap.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L27;
        ILogDelegate r0 = r6.next();
        if (r0.isLoggable(r2) == false) goto L4;
        if (r2 != 2) goto L11;
        r0.v(r3, r4);
        goto L4
    L11:
        if (r2 != 3) goto L13;
        r0.d(r3, r4);
        goto L4
    L13:
        if (r2 != 4) goto L15;
        r0.i(r3, r4);
        goto L4
    L15:
        if (r2 != 5) goto L17;
        r0.w(r3, r4);
        goto L4
    L17:
        if (r2 != 6) goto L19;
        r0.e(r3, r4);
        goto L4
    L19:
        if (r2 != 8) goto L4;
        r0.k(r3, r4);
        goto L4
    }
}
