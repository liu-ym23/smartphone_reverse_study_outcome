package com.lynx.animax.util;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXLog {

    public static final enum LogLevel extends Enum<LogLevel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LogLevel f9713a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LogLevel f9714b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final LogLevel f9715c = null;
        public static final /* synthetic */ LogLevel[] d = null;

        static {
            LogLevel r5 = new LogLevel("VERBOSE", 0);
            LogLevel r10 = new LogLevel("DEBUG", 1);
            LogLevel r11 = new LogLevel("INFO", 2);
            f9713a = r11;
            LogLevel r12 = new LogLevel("WARN", 3);
            f9714b = r12;
            LogLevel r13 = new LogLevel("ERROR", 4);
            f9715c = r13;
            d = new LogLevel[]{r5, r10, r11, r12, r13};
        }

        public LogLevel(String r5, int r10) {
            super(r5, r10);
        }

        public static LogLevel valueOf(String r5) {
            return (LogLevel) Enum.valueOf(LogLevel.class, r5);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) d.clone();
        }
    }

    public static void a(LogLevel r5, String r10, String r11) {
        if (AnimaX.a().f9710a == false) goto L6;
        nativeLog(r5.ordinal(), r10, r11);
        return;
    L6:
        Log.e("[AnimaX]", "AnimaX is not initialized, log will be ignored: " + r11);
    }

    private static native void nativeLog(int r5, String r10, String r11);
}
