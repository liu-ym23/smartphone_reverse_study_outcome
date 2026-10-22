package com.lynx.animax.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXLog {

    public static final enum LogLevel extends Enum<LogLevel> {
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel VERBOSE = null;
        public static final LogLevel WARN = null;
        public static final /* synthetic */ LogLevel[] a = null;

        static {
            LogLevel r0 = new LogLevel("VERBOSE", 0);
            VERBOSE = r0;
            LogLevel r1 = new LogLevel("DEBUG", 1);
            DEBUG = r1;
            LogLevel r3 = new LogLevel("INFO", 2);
            INFO = r3;
            LogLevel r5 = new LogLevel("WARN", 3);
            WARN = r5;
            LogLevel r7 = new LogLevel("ERROR", 4);
            ERROR = r7;
            a = new LogLevel[]{r0, r1, r3, r5, r7};
        }

        public static LogLevel[] values() {
            return (LogLevel[]) a.clone();
        }

        public static LogLevel valueOf(String r1) {
            return (LogLevel) a.a(LogLevel.class, r1);
        }

        public LogLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    public AnimaXLog() {
    }

    private static native void nativeLog(int r0, String r1, String r2);

    public static void a(String r1, String r2) {
        c(LogLevel.ERROR, r1, r2);
    }

    public static void b(String r1, String r2) {
        c(LogLevel.INFO, r1, r2);
    }

    public static void d(String r1, String r2) {
        c(LogLevel.WARN, r1, r2);
    }

    public static void c(LogLevel r1, String r2, String r3) {
        if (AnimaX.e().a == false) goto L6;
        nativeLog(r1.ordinal(), r2, r3);
        return;
    }
}
