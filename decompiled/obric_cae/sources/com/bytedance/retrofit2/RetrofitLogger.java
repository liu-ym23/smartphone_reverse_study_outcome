package com.bytedance.retrofit2;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitLogger {
    private static final String TAG = "Logger";
    static int mLevel = 4;
    static ILogWritter sLogWritter;

    public static abstract class ILogWritter {
        public ILogWritter() {
        }

        public void logE(String r8, String r10) {
        }

        public void logI(String r8, String r10) {
        }

        public void logK(String r8, String r10) {
        }

        public void logW(String r8, String r10) {
        }

        public void logE(String r8, String r10, Throwable r11) {
        }

        public void logI(String r8, String r10, Throwable r11) {
        }

        public void logW(String r8, String r10, Throwable r11) {
        }
    }

    public RetrofitLogger() {
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

    public static void k(String r8) {
        k(TAG, r8);
    }

    public static void registerLogHandler(ILogWritter r8) {
        sLogWritter = r8;
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
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L8;
        Log.d(r8, r10);
        return;
    }

    public static void e(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L7;
        Log.e(r8, r10);
    L7:
        ILogWritter r11 = sLogWritter;
        if (r11 == null) goto L11;
        r11.logE(r8, r10);
        return;
    }

    public static void i(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L7;
        Log.i(r8, r10);
    L7:
        ILogWritter r11 = sLogWritter;
        if (r11 == null) goto L11;
        r11.logI(r8, r10);
        return;
    }

    public static void k(String r8, String r10) {
        if (mLevel > 3) goto L5;
        Log.d(r8, r10);
    L5:
        ILogWritter r11 = sLogWritter;
        if (r11 == null) goto L9;
        r11.logK(r8, r10);
        return;
    }

    public static void v(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 2) goto L8;
        Log.v(r8, r10);
        return;
    }

    public static void w(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L7;
        Log.w(r8, r10);
    L7:
        ILogWritter r11 = sLogWritter;
        if (r11 == null) goto L11;
        r11.logW(r8, r10);
        return;
    }

    public static void d(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L9;
        Log.d(r8, r10, r11);
        return;
    }

    public static void e(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L8;
        Log.e(r8, r10, r11);
    L8:
        ILogWritter r12 = sLogWritter;
        if (r12 == null) goto L12;
        r12.logE(r8, r10, r11);
        return;
    }

    public static void i(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L8;
        Log.i(r8, r10, r11);
    L8:
        ILogWritter r12 = sLogWritter;
        if (r12 == null) goto L12;
        r12.logI(r8, r10, r11);
        return;
    }

    public static void v(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L9;
        Log.v(r8, r10, r11);
        return;
    }

    public static void w(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L8;
        Log.w(r8, r10, r11);
    L8:
        ILogWritter r12 = sLogWritter;
        if (r12 == null) goto L12;
        r12.logW(r8, r10, r11);
        return;
    }
}
