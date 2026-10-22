package com.bytedance.framwork.core.sdklib.apm6.safety;

import android.util.Log;
import com.bytedance.apm6.util.log.ILogger;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ILogger f2617a;

    public static class a implements ILogger {
        public a() {
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void d(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.d(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.e(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r1, String r2, Throwable r3) {
            if (j.d() == false) goto L6;
            Log.e(r1, r2, r3);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void i(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.i(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void v(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.v(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.w(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r1, String r2, Throwable r3) {
            if (j.d() == false) goto L6;
            Log.w(r1, r2, r3);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r1, String r2) {
            if (j.d() == false) goto L6;
            Log.wtf(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r1, String r2, Throwable r3) {
            if (j.d() == false) goto L6;
            Log.e(r1, r2, r3);
            return;
        }
    }

    static {
        f2617a = new a();
    }

    public static void a(ILogger r2) {
        f2617a = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1, String r2) {
        ILogger r0 = f2617a;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void a(String r1, String r2, Throwable r3) {
        ILogger r0 = f2617a;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }

    public static void b(String r1, String r2) {
        ILogger r0 = f2617a;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        ILogger r0 = f2617a;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }
}
