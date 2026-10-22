package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static d sLogWriter;

    static {
        sLogWriter = b.f3954b;
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r5) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r5);
    }

    public static void d(String r5) {
        d(TAG, r5);
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(String r5) {
        e(TAG, r5);
    }

    public static int getLogLevel() {
        return mLevel;
    }

    private static String getSimpleClassName(String r5) {
        int r10 = r5.lastIndexOf(46);
        if (r10 >= 0) goto L6;
        return r5;
    L6:
        return r5.substring(r10 + 1);
    }

    public static void i(String r5) {
        i(TAG, r5);
    }

    @Deprecated
    public static void k(String r5) {
        k(TAG, r5);
    }

    public static void registerLogHandler(d r5) {
        sLogWriter = r5;
    }

    public static void setLogLevel(int r5) {
        mLevel = r5;
    }

    public static void st(String r5, int r10) {
    L4:
        e = move-exception;
        StackTraceElement[] r11 = e.getStackTrace();
        StringBuilder r12 = new StringBuilder();
        int r13 = 1;
    L7:
        if (r13 >= Math.min(r10, r11.length)) goto L11;
        if (r13 <= 1) goto L10;
        r12.append("\n");
    L10:
        r12.append(getSimpleClassName(r11[r13].getClassName()));
        r12.append(".");
        r12.append(r11[r13].getMethodName());
        r13 = r13 + 1;
        goto L7
    L11:
        v(r5, r12.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void throwException(Throwable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r5.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r5);
    }

    public static void v(String r5) {
        v(TAG, r5);
    }

    public static void w(String r5) {
        w(TAG, r5);
    }

    public static void d(String r5, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (d.a(3) == false) goto L8;
        ((c) sLogWriter).getClass();
        Log.d(r5, r10);
        return;
    }

    public static void e(String r5, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (d.a(6) == false) goto L8;
        ((c) sLogWriter).getClass();
        Log.e(r5, r10);
        return;
    }

    public static void i(String r5, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (d.a(4) == false) goto L8;
        ((c) sLogWriter).getClass();
        Log.i(r5, r10);
        return;
    }

    @Deprecated
    public static void k(String r5, String r10) {
        sLogWriter.getClass();
        if (d.a(3) == false) goto L6;
        sLogWriter.getClass();
        return;
    }

    public static void v(String r5, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (d.a(2) == false) goto L8;
        ((c) sLogWriter).getClass();
        Log.v(r5, r10);
        return;
    }

    public static void w(String r5, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (d.a(5) == false) goto L8;
        ((c) sLogWriter).getClass();
        Log.w(r5, r10);
        return;
    }

    public static void d(String r5, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (d.a(3) == false) goto L9;
        ((c) sLogWriter).getClass();
        Log.d(r5, r10, r11);
        return;
    }

    public static void e(String r5, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (d.a(6) == false) goto L9;
        ((c) sLogWriter).getClass();
        Log.e(r5, r10, r11);
        return;
    }

    public static void i(String r5, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (d.a(4) == false) goto L9;
        ((c) sLogWriter).getClass();
        Log.i(r5, r10, r11);
        return;
    }

    public static void v(String r5, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (d.a(2) == false) goto L9;
        ((c) sLogWriter).getClass();
        Log.v(r5, r10, r11);
        return;
    }

    public static void w(String r5, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (d.a(5) == false) goto L9;
        ((c) sLogWriter).getClass();
        Log.w(r5, r10, r11);
        return;
    }
}
