package com.bytedance.apm6.util.log;

import android.util.Log;
import com.bytedance.apm6.util.ApmBaseContext;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static ILogger sApmLogImp;

    public static class DefaultLogger implements ILogger {
        public DefaultLogger() {
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void d(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.d(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r10, String r11, Throwable r12) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r10, r11, r12);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void i(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.i(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void v(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.v(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.w(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r10, String r11, Throwable r12) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.w(r10, r11, r12);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r10, String r11) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.wtf(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r10, String r11, Throwable r12) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Log.e(r10, r11, r12);
            return;
        }
    }

    static {
        sApmLogImp = new DefaultLogger();
    }

    private Logger() {
    }

    public static void d(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    public static void e(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void e(String r10, String r11, Throwable r12) {
        ILogger r13 = sApmLogImp;
        if (r13 == null) goto L6;
        r13.e(r10, r11, r12);
        return;
    }

    public static void i(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    public static void setLoggerImpl(ILogger r10) {
        sApmLogImp = r10;
    }

    public static void v(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.v(r10, r11);
        return;
    }

    public static void w(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.w(r10, r11);
        return;
    }

    public static void w(String r10, String r11, Throwable r12) {
        ILogger r13 = sApmLogImp;
        if (r13 == null) goto L6;
        r13.w(r10, r11, r12);
        return;
    }

    public static void wtf(String r10, String r11) {
        ILogger r12 = sApmLogImp;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void wtf(String r10, String r11, Throwable r12) {
        ILogger r13 = sApmLogImp;
        if (r13 == null) goto L6;
        r13.e(r10, r11, r12);
        return;
    }
}
