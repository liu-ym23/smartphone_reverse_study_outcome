package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static c sLogWriter;

    static /* synthetic */ class a {
    }

    private static final class b extends c {

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final b f1253a = null;

            static {
                f1253a = new b(null);
            }

            static /* synthetic */ b a() {
                return f1253a;
            }
        }

        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }

        static b m() {
            return a.a();
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void b(String r10, String r11) {
            Log.d(r10, r11);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void c(String r10, String r11, Throwable r12) {
            Log.d(r10, r11, r12);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void d(String r10, String r11) {
            Log.e(r10, r11);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void e(String r10, String r11, Throwable r12) {
            Log.e(r10, r11, r12);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void f(String r10, String r11) {
            Log.i(r10, r11);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void g(String r10, String r11, Throwable r12) {
            Log.i(r10, r11, r12);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void i(String r10, String r11) {
            Log.v(r10, r11);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void j(String r10, String r11, Throwable r12) {
            Log.v(r10, r11, r12);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void k(String r10, String r11) {
            Log.w(r10, r11);
        }

        @Override // com.bytedance.common.utility.Logger.c
        public void l(String r10, String r11, Throwable r12) {
            Log.w(r10, r11, r12);
        }
    }

    public static abstract class c {
        public c() {
        }

        public boolean a(int r10) {
            if (Logger.getLogLevel() > r10) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract void b(String r10, String r11);

        public abstract void c(String r10, String r11, Throwable r12);

        public abstract void d(String r10, String r11);

        public abstract void e(String r10, String r11, Throwable r12);

        public abstract void f(String r10, String r11);

        public abstract void g(String r10, String r11, Throwable r12);

        public void h(String r10, String r11) {
        }

        public abstract void i(String r10, String r11);

        public abstract void j(String r10, String r11, Throwable r12);

        public abstract void k(String r10, String r11);

        public abstract void l(String r10, String r11, Throwable r12);
    }

    static {
        sLogWriter = b.m();
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
        if (sLogWriter.a(3) == false) goto L8;
        sLogWriter.b(r10, r11);
        return;
    }

    public static void d(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(3) == false) goto L9;
        sLogWriter.c(r10, r11, r12);
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
        if (sLogWriter.a(6) == false) goto L8;
        sLogWriter.d(r10, r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(6) == false) goto L9;
        sLogWriter.e(r10, r11, r12);
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
        if (sLogWriter.a(4) == false) goto L8;
        sLogWriter.f(r10, r11);
        return;
    }

    public static void i(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(4) == false) goto L9;
        sLogWriter.g(r10, r11, r12);
        return;
    }

    @Deprecated
    public static void k(String r10) {
        k(TAG, r10);
    }

    @Deprecated
    public static void k(String r10, String r11) {
        if (sLogWriter.a(3) == false) goto L6;
        sLogWriter.h(r10, r11);
        return;
    }

    public static void registerLogHandler(c r10) {
        sLogWriter = r10;
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
        if (sLogWriter.a(2) == false) goto L8;
        sLogWriter.i(r10, r11);
        return;
    }

    public static void v(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(2) == false) goto L9;
        sLogWriter.j(r10, r11, r12);
        return;
    }

    public static void w(String r10) {
        w(TAG, r10);
    }

    public static void w(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(5) == false) goto L8;
        sLogWriter.k(r10, r11);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(5) == false) goto L9;
        sLogWriter.l(r10, r11, r12);
        return;
    }
}
