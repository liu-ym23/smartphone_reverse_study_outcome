package com.bytedance.bdlocation.trace;

/* JADX INFO: loaded from: classes.dex */
public class StackTraceRecorder {
    private static volatile String sColdBootStackTrace = "";

    static {
    }

    public StackTraceRecorder() {
    }

    public static String getColdBootStackTrace() {
        return sColdBootStackTrace;
    }

    public static void setColdBootStackTrace(String r0) {
        sColdBootStackTrace = r0;
    }
}
