package qa;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class l1 extends n1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l1 f10784d = null;

    public class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r8, Throwable r10) {
            q.f("TPool", "ThreadPool", r10);
        }
    }

    static {
        a r8 = new a();
        k1.a r10 = new k1.a();
        r10.f10719a = r8;
        r10.f10720b = "amap-global-threadPool";
        k1 r11 = new k1(r10);
        r10.f10719a = null;
        r10.f10720b = null;
        f10784d = new l1(r11);
    }

    public l1(k1 r10) {
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(r10.f10715e, r10.f10716f, r10.f10718h, TimeUnit.SECONDS, r10.f10717g, r10);     // Catch: Throwable -> L5
        this.f10847a = r8;     // Catch: Throwable -> L5
        r8.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q.f("TPool", "ThreadPool", th);
        th.printStackTrace();
    }
}
