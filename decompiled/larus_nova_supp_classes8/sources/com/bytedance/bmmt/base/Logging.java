package com.bytedance.bmmt.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class Logging {
    private static Severity loggableSeverity = null;
    private static volatile boolean loggingEnabled = true;

    public static final enum Severity extends Enum<Severity> {
        private static final /* synthetic */ Severity[] $VALUES = null;
        public static final Severity LS_DEBUG = null;
        public static final Severity LS_ERROR = null;
        public static final Severity LS_INFO = null;
        public static final Severity LS_NONE = null;
        public static final Severity LS_TRACE = null;
        public static final Severity LS_WARNING = null;

        private static /* synthetic */ Severity[] $values() {
            return new Severity[]{LS_DEBUG, LS_TRACE, LS_INFO, LS_WARNING, LS_ERROR, LS_NONE};
        }

        static {
            LS_DEBUG = new Severity("LS_DEBUG", 0);
            LS_TRACE = new Severity("LS_TRACE", 1);
            LS_INFO = new Severity("LS_INFO", 2);
            LS_WARNING = new Severity("LS_WARNING", 3);
            LS_ERROR = new Severity("LS_ERROR", 4);
            LS_NONE = new Severity("LS_NONE", 5);
            $VALUES = $values();
        }

        public static Severity[] values() {
            return (Severity[]) $VALUES.clone();
        }

        public static Severity valueOf(String r1) {
            return (Severity) a.a(Severity.class, r1);
        }

        private Severity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum TraceLevel extends Enum<TraceLevel> {
        private static final /* synthetic */ TraceLevel[] $VALUES = null;
        public static final TraceLevel TRACE_ALL = null;
        public static final TraceLevel TRACE_APICALL = null;
        public static final TraceLevel TRACE_CRITICAL = null;
        public static final TraceLevel TRACE_DEBUG = null;
        public static final TraceLevel TRACE_DEFAULT = null;
        public static final TraceLevel TRACE_ERROR = null;
        public static final TraceLevel TRACE_INFO = null;
        public static final TraceLevel TRACE_MEMORY = null;
        public static final TraceLevel TRACE_MODULECALL = null;
        public static final TraceLevel TRACE_NONE = null;
        public static final TraceLevel TRACE_STATEINFO = null;
        public static final TraceLevel TRACE_STREAM = null;
        public static final TraceLevel TRACE_TERSEINFO = null;
        public static final TraceLevel TRACE_TIMER = null;
        public static final TraceLevel TRACE_WARNING = null;
        public final int level;

        private static /* synthetic */ TraceLevel[] $values() {
            return new TraceLevel[]{TRACE_NONE, TRACE_STATEINFO, TRACE_WARNING, TRACE_ERROR, TRACE_CRITICAL, TRACE_APICALL, TRACE_DEFAULT, TRACE_MODULECALL, TRACE_MEMORY, TRACE_TIMER, TRACE_STREAM, TRACE_DEBUG, TRACE_INFO, TRACE_TERSEINFO, TRACE_ALL};
        }

        static {
            TRACE_NONE = new TraceLevel("TRACE_NONE", 0, 0);
            TRACE_STATEINFO = new TraceLevel("TRACE_STATEINFO", 1, 1);
            TRACE_WARNING = new TraceLevel("TRACE_WARNING", 2, 2);
            TRACE_ERROR = new TraceLevel("TRACE_ERROR", 3, 4);
            TRACE_CRITICAL = new TraceLevel("TRACE_CRITICAL", 4, 8);
            TRACE_APICALL = new TraceLevel("TRACE_APICALL", 5, 16);
            TRACE_DEFAULT = new TraceLevel("TRACE_DEFAULT", 6, 255);
            TRACE_MODULECALL = new TraceLevel("TRACE_MODULECALL", 7, 32);
            TRACE_MEMORY = new TraceLevel("TRACE_MEMORY", 8, 256);
            TRACE_TIMER = new TraceLevel("TRACE_TIMER", 9, 512);
            TRACE_STREAM = new TraceLevel("TRACE_STREAM", 10, 1024);
            TRACE_DEBUG = new TraceLevel("TRACE_DEBUG", 11, 2048);
            TRACE_INFO = new TraceLevel("TRACE_INFO", 12, 4096);
            TRACE_TERSEINFO = new TraceLevel("TRACE_TERSEINFO", 13, DeviceInfoAndroid.BUFFER_SIZE);
            TRACE_ALL = new TraceLevel("TRACE_ALL", 14, 65535);
            $VALUES = $values();
        }

        public static TraceLevel[] values() {
            return (TraceLevel[]) $VALUES.clone();
        }

        public static TraceLevel valueOf(String r1) {
            return (TraceLevel) a.a(TraceLevel.class, r1);
        }

        private TraceLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.level = r3;
        }
    }

    public Logging() {
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int r0);

    private static native void nativeLog(int r0, String r1, String r2);

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Severity r1) {
        monitor-enter(Logging.class);
        nativeEnableLogToDebugOutput(r1.ordinal());     // Catch: Throwable -> L7
        loggingEnabled = true;     // Catch: Throwable -> L7
        monitor-exit(Logging.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getStackTraceString(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }

    public static void d(String r1, String r2) {
        log(Severity.LS_DEBUG, r1, r2);
    }

    public static void e(String r1, String r2) {
        log(Severity.LS_ERROR, r1, r2);
    }

    public static void i(String r1, String r2) {
        log(Severity.LS_INFO, r1, r2);
    }

    public static void t(String r1, String r2) {
        log(Severity.LS_TRACE, r1, r2);
    }

    public static void w(String r1, String r2) {
        log(Severity.LS_WARNING, r1, r2);
    }

    public static void e(String r1, String r2, Throwable r3) {
        Severity r0 = Severity.LS_ERROR;
        log(r0, r1, r2);
        log(r0, r1, r3.toString());
        log(r0, r1, getStackTraceString(r3));
    }

    public static void log(Severity r1, String r2, String r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        if (loggingEnabled == false) goto L10;
        nativeLog(r1.ordinal(), r2, r3);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Logging tag or message may not be null.");
    }

    public static void w(String r1, String r2, Throwable r3) {
        Severity r0 = Severity.LS_WARNING;
        log(r0, r1, r2);
        log(r0, r1, r3.toString());
        log(r0, r1, getStackTraceString(r3));
    }
}
