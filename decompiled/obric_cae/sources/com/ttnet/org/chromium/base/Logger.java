package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static final String TAG = "Logger";
    static int mLevel = 4;

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
        android.util.Log.d(r8, r10);
        return;
    }

    public static void e(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L8;
        android.util.Log.e(r8, r10);
        return;
    }

    public static void i(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L8;
        android.util.Log.i(r8, r10);
        return;
    }

    public static void v(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 2) goto L8;
        android.util.Log.v(r8, r10);
        return;
    }

    public static void w(String r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L8;
        android.util.Log.w(r8, r10);
        return;
    }

    public static void d(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L9;
        android.util.Log.d(r8, r10, r11);
        return;
    }

    public static void e(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L9;
        android.util.Log.e(r8, r10, r11);
        return;
    }

    public static void i(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L9;
        android.util.Log.i(r8, r10, r11);
        return;
    }

    public static void v(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L9;
        android.util.Log.v(r8, r10, r11);
        return;
    }

    public static void w(String r8, String r10, Throwable r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L9;
        android.util.Log.w(r8, r10, r11);
        return;
    }
}
