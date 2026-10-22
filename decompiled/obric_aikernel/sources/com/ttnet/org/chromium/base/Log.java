package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private Log() {
    }

    @CheckDiscard("crbug.com/1231625")
    public static void d(String r10, String r11, Object... r12) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLogWithStack(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L8;
        android.util.Log.d(r15, r14, r13);
        return;
    L8:
        android.util.Log.d(r15, r14);
    }

    public static void e(String r10, String r11, Object... r12) {
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLog(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L5;
        android.util.Log.e(r15, r14, r13);
        return;
    L5:
        android.util.Log.e(r15, r14);
    }

    private static String formatLog(String r10, Throwable r11, Object... r12) {
        if (r12 == null) goto L10;
        if (r11 != null) goto L7;
        if (r12.length <= 0) goto L7;
    L9:
        return String.format(Locale.US, r10, r12);
    L7:
        if (r12.length > 1) goto L9;
        return r10;
    L10:
        return r10;
    }

    private static String formatLogWithStack(String r10, Throwable r11, Object... r12) {
        return "[" + getCallOrigin() + "] " + formatLog(r10, r11, r12);
    }

    @CheckDiscard("crbug.com/1231625")
    private static String getCallOrigin() {
        StackTraceElement[] r10 = Thread.currentThread().getStackTrace();
        String r11 = Log.class.getName();
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        if (r10[r12].getClassName().equals(r11) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        r12 = r12 + 3;
    L10:
        return r10[r12].getFileName() + ":" + r10[r12].getLineNumber();
    }

    public static String getStackTraceString(Throwable r10) {
        return android.util.Log.getStackTraceString(r10);
    }

    private static Throwable getThrowableToLog(Object[] r10) {
        if (r10 != null) goto L5;
    L12:
        return null;
    L5:
        if (r10.length == 0) goto L12;
        Object r11 = r10[r10.length - 1];
        if ((r11 instanceof Throwable) == true) goto L11;
        return null;
    L11:
        return (Throwable) r11;
    }

    public static void i(String r10, String r11, Object... r12) {
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLog(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L5;
        android.util.Log.i(r15, r14, r13);
        return;
    L5:
        android.util.Log.i(r15, r14);
    }

    private static boolean isDebug() {
        return false;
    }

    public static boolean isLoggable(String r10, int r11) {
        if (isDebug() == true) goto L9;
        if (r11 > 4) goto L9;
        return false;
    L9:
        return android.util.Log.isLoggable(r10, r11);
    }

    public static String normalizeTag(String r10) {
        if (r10.startsWith(sTagPrefix) == false) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (r10.startsWith(sDeprecatedTagPrefix) == false) goto L9;
        r11 = 3;
    L9:
        return sTagPrefix + r10.substring(r11, r10.length());
    }

    @CheckDiscard("crbug.com/1231625")
    public static void v(String r10, String r11, Object... r12) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLogWithStack(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L8;
        android.util.Log.v(r15, r14, r13);
        return;
    L8:
        android.util.Log.v(r15, r14);
    }

    public static void w(String r10, String r11, Object... r12) {
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLog(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L5;
        android.util.Log.w(r15, r14, r13);
        return;
    L5:
        android.util.Log.w(r15, r14);
    }

    public static void wtf(String r10, String r11, Object... r12) {
        Throwable r13 = getThrowableToLog(r12);
        String r14 = formatLog(r11, r13, r12);
        String r15 = normalizeTag(r10);
        if (r13 == null) goto L5;
        android.util.Log.wtf(r15, r14, r13);
        return;
    L5:
        android.util.Log.wtf(r15, r14);
    }
}
