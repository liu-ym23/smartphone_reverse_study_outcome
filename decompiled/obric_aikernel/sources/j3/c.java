package j3;

import android.util.Log;
import com.bytedance.apm6.util.log.ILogger;
import com.bytedance.framwork.core.sdklib.apm6.j;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ILogger f9759a;

    public static class a implements ILogger {
        public a() {
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void d(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.d(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.e(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void e(String r10, String r11, Throwable r12) {
            if (j.f() == false) goto L6;
            Log.e(r10, r11, r12);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void i(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.i(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void v(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.v(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.w(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void w(String r10, String r11, Throwable r12) {
            if (j.f() == false) goto L6;
            Log.w(r10, r11, r12);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r10, String r11) {
            if (j.f() == false) goto L6;
            Log.wtf(r10, r11);
            return;
        }

        @Override // com.bytedance.apm6.util.log.ILogger
        public void wtf(String r10, String r11, Throwable r12) {
            if (j.f() == false) goto L6;
            Log.e(r10, r11, r12);
            return;
        }
    }

    static {
        f9759a = new a();
    }

    public static void a(String r10, String r11) {
        ILogger r12 = f9759a;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    public static void b(String r10, String r11) {
        ILogger r12 = f9759a;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void c(String r10, String r11, Throwable r12) {
        ILogger r13 = f9759a;
        if (r13 == null) goto L6;
        r13.e(r10, r11, r12);
        return;
    }

    public static void d(String r10, String r11) {
        ILogger r12 = f9759a;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    public static void e(ILogger r10) {
        f9759a = r10;
    }

    public static void f(String r10, String r11) {
        ILogger r12 = f9759a;
        if (r12 == null) goto L6;
        r12.w(r10, r11);
        return;
    }
}
