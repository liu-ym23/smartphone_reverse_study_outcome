package com.bytedance.crash.util;

/* JADX INFO: loaded from: classes.dex */
public final class LogcatUtils {
    private static LogcatImpl sLogcat;

    public static abstract class LogcatImpl {
        public LogcatImpl() {
        }

        abstract String dumpLogcat();

        abstract void dumpLogcat(String r10);
    }

    static {
    }

    public LogcatUtils() {
    }

    public static void dumpLogcat(String r10) {
        LogcatImpl r11 = sLogcat;
        if (r11 == null) goto L6;
        r11.dumpLogcat(r10);
        return;
    }

    public static void setLogcatImpl(LogcatImpl r10) {
        sLogcat = r10;
    }
}
