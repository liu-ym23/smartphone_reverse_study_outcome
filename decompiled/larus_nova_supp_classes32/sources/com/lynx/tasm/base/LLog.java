package com.lynx.tasm.base;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LLog {
    public static final int DEBUG = 1;
    public static final int ERROR = 4;
    public static final int INFO = 2;
    public static final int REPORT = -1;
    public static final int VERBOSE = 0;
    public static final int WARN = 3;

    public LLog() {
    }

    public static void DTHROW() {
        DTHROW(null);
    }

    public static int addLoggingDelegate(AbsLogDelegate r0) {
        return -1;
    }

    public static void initALog(long r0) {
    }

    public static void internalLog(int r0, String r1, String r2, LogSource r3, Long r4, int r5) {
    }

    public static boolean isLoggable(int r0) {
        return false;
    }

    public static void onEnvReady() {
    }

    public static void setLoggingDelegate(AbsLogDelegate r0) {
    }

    public static int getMinimumLoggingLevel() {
        return LynxLog.getMinimumLoggingLevel();
    }

    public static void initLynxLog() {
        LynxLog.initLynxLog(LynxEnv.inst().isDevtoolEnabled());
    }

    public static void DCHECK(boolean r0) {
        LynxLog.DCHECK(r0);
    }

    public static void DTHROW(RuntimeException r0) {
        LynxLog.DTHROW(r0);
    }

    public static synchronized void removeLoggingDelegate(int r0) {
        monitor-enter(LLog.class);
        monitor-exit(LLog.class);
    }

    public static void setDebugLoggingDelegate(AbsLogDelegate r2) {
        if (b.b == null) goto L5;
    L14:
        b.b.getClass();
        b.a = r2;
        LynxLog.setDebugLoggingDelegate(b.a());
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.b != null) goto L9;
        b.b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void setJSLogsFromExternalChannels(boolean r0) {
        LynxLog.setJSLogsFromExternalChannels(r0);
    }

    public static void setMinimumLoggingLevel(int r0) {
        LynxLog.setMinimumLoggingLevel(r0);
    }

    public static void d(String r0, String r1) {
        LynxLog.d(r0, r1);
    }

    public static void e(String r0, String r1) {
        LynxLog.e(r0, r1);
    }

    public static void i(String r0, String r1) {
        LynxLog.i(r0, r1);
    }

    public static void report(String r0, String r1) {
        LynxLog.e(r0, r1);
    }

    public static void v(String r0, String r1) {
        LynxLog.v(r0, r1);
    }

    public static void w(String r0, String r1) {
        LynxLog.w(r0, r1);
    }

    public static void internalLog(int r0, String r1, String r2) {
        LynxLog.internalLog(r0, r1, r2);
    }
}
