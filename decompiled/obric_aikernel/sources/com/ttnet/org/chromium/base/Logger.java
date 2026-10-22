package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static final String TAG = "Logger";
    static int mLevel = 4;

    static {
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r10) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r10);
    }

    public static void d(String r10) {
        d(TAG, r10);
    }

    public static void d(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L8;
        android.util.Log.d(r10, r11);
        return;
    }

    public static void d(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L9;
        android.util.Log.d(r10, r11, r12);
        return;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(String r10) {
        e(TAG, r10);
    }

    public static void e(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L8;
        android.util.Log.e(r10, r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L9;
        android.util.Log.e(r10, r11, r12);
        return;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    private static String getSimpleClassName(String r10) {
        int r11 = r10.lastIndexOf(46);
        if (r11 >= 0) goto L6;
        return r10;
    L6:
        return r10.substring(r11 + 1);
    }

    public static void i(String r10) {
        i(TAG, r10);
    }

    public static void i(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L8;
        android.util.Log.i(r10, r11);
        return;
    }

    public static void i(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L9;
        android.util.Log.i(r10, r11, r12);
        return;
    }

    public static void setLogLevel(int r10) {
        mLevel = r10;
    }

    public static void st(String r10, int r11) {
    L4:
        e = move-exception;
        StackTraceElement[] r12 = e.getStackTrace();
        StringBuilder r13 = new StringBuilder();
        int r14 = 1;
    L7:
        if (r14 >= Math.min(r11, r12.length)) goto L11;
        if (r14 <= 1) goto L10;
        r13.append("\n");
    L10:
        r13.append(getSimpleClassName(r12[r14].getClassName()));
        r13.append(".");
        r13.append(r12[r14].getMethodName());
        r14 = r14 + 1;
        goto L7
    L11:
        v(r10, r13.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void throwException(Throwable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r10);
    }

    public static void v(String r10) {
        v(TAG, r10);
    }

    public static void v(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (mLevel > 2) goto L8;
        android.util.Log.v(r10, r11);
        return;
    }

    public static void v(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L9;
        android.util.Log.v(r10, r11, r12);
        return;
    }

    public static void w(String r10) {
        w(TAG, r10);
    }

    public static void w(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L8;
        android.util.Log.w(r10, r11);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L9;
        android.util.Log.w(r10, r11, r12);
        return;
    }
}
