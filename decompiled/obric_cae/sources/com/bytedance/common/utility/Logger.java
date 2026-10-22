package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static b sLogWriter;

    public static final class a extends b {

        /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$a$a, reason: collision with other inner class name */
        public static class C0045a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f3851a = null;

            static {
                f3851a = new a();
            }
        }
    }

    public static abstract class b {
        public static boolean a(int r8) {
            if (Logger.getLogLevel() > r8) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        sLogWriter = a.C0045a.f3851a;
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r8) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r8);
    }

    public static void d(String r8) {
        d(TAG, r8);
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(String r8) {
        e(TAG, r8);
    }

    public static int getLogLevel() {
        return mLevel;
    }

    private static String getSimpleClassName(String r8) {
        int r10 = r8.lastIndexOf(46);
        if (r10 >= 0) goto L6;
        return r8;
    L6:
        return r8.substring(r10 + 1);
    }

    public static void i(String r8) {
        i(TAG, r8);
    }

    @Deprecated
    public static void k(String r8) {
        k(TAG, r8);
    }

    public static void registerLogHandler(b r8) {
        sLogWriter = r8;
    }

    public static void setLogLevel(int r8) {
        mLevel = r8;
    }

    public static void st(String r8, int r10) {
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
        v(r8, r12.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void throwException(Throwable r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r8);
    }

    public static void v(String r8) {
        v(TAG, r8);
    }

    public static void w(String r8) {
        w(TAG, r8);
    }

    public static void d(String r8, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (b.a(3) == false) goto L8;
        ((a) sLogWriter).getClass();
        Log.d(r8, r10);
        return;
    }

    public static void e(String r8, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (b.a(6) == false) goto L8;
        ((a) sLogWriter).getClass();
        Log.e(r8, r10);
        return;
    }

    public static void i(String r8, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (b.a(4) == false) goto L8;
        ((a) sLogWriter).getClass();
        Log.i(r8, r10);
        return;
    }

    @Deprecated
    public static void k(String r8, String r10) {
        sLogWriter.getClass();
        if (b.a(3) == false) goto L6;
        sLogWriter.getClass();
        return;
    }

    public static void v(String r8, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (b.a(2) == false) goto L8;
        ((a) sLogWriter).getClass();
        Log.v(r8, r10);
        return;
    }

    public static void w(String r8, String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sLogWriter.getClass();
        if (b.a(5) == false) goto L8;
        ((a) sLogWriter).getClass();
        Log.w(r8, r10);
        return;
    }

    public static void d(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (b.a(3) == false) goto L9;
        ((a) sLogWriter).getClass();
        Log.d(r8, r10, r11);
        return;
    }

    public static void e(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (b.a(6) == false) goto L9;
        ((a) sLogWriter).getClass();
        Log.e(r8, r10, r11);
        return;
    }

    public static void i(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (b.a(4) == false) goto L9;
        ((a) sLogWriter).getClass();
        Log.i(r8, r10, r11);
        return;
    }

    public static void v(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (b.a(2) == false) goto L9;
        ((a) sLogWriter).getClass();
        Log.v(r8, r10, r11);
        return;
    }

    public static void w(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        sLogWriter.getClass();
        if (b.a(5) == false) goto L9;
        ((a) sLogWriter).getClass();
        Log.w(r8, r10, r11);
        return;
    }
}
