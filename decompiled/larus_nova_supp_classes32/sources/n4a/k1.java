package n4a;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k1 extends m1 {
    public static final k1 d = null;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r2, Throwable r3) {
            r.f(r3, "TPool", "ThreadPool");
        }
    }

    static {
        a r0 = new a();
        j1.a r2 = new j1.a();
        r2.a = r0;
        r2.b = "amap-global-threadPool";
        j1 r1 = new j1(r2);
        r2.a = null;
        r2.b = null;
        d = new k1(r1);
    }

    public k1(j1 r10) {
        PThreadPoolExecutor r8 = new PThreadPoolExecutor(r10.e, r10.f, r10.h, TimeUnit.SECONDS, r10.g, r10);     // Catch: Throwable -> L5
        this.a = r8;     // Catch: Throwable -> L5
        r8.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r.f(th, "TPool", "ThreadPool");
        th.printStackTrace();
    }
}
