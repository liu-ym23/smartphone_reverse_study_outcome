package g2;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f8943d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8944e = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f8945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<e, ScheduledFuture> f8946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<e, Runnable> f8947c;

    static /* synthetic */ class a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e f8948c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f8949g;

        private b(d r10, e r11) {
            this.f8949g = r10;
            this.f8948c = r11;
        }

        /* synthetic */ b(d r10, e r11, a r12) {
            this(r10, r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f8948c.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(d.a(), "Task execute time: " + (System.currentTimeMillis() - r10));     // Catch: Throwable -> L8
        L6:
            if (this.f8948c.c() == true) goto L13;
        L7:
            d.b(this.f8949g).remove(this.f8948c);
            d.c(this.f8949g).remove(this.f8948c);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(d.a(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f8948c.c() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f8948c.c() == true) goto L18;
            d.b(this.f8949g).remove(this.f8948c);
            d.c(this.f8949g).remove(this.f8948c);
        L18:
            throw th;
        }
    }

    static {
    }

    private d() {
        this.f8946b = new ConcurrentHashMap();
        this.f8947c = new ConcurrentHashMap();
        this.f8945a = new ScheduledThreadPoolExecutor(1, new f("frontier"));
    }

    static /* synthetic */ String a() {
        return f8944e;
    }

    static /* synthetic */ ConcurrentHashMap b(d r10) {
        return r10.f8946b;
    }

    static /* synthetic */ ConcurrentHashMap c(d r10) {
        return r10.f8947c;
    }

    public static d d() {
        if (f8943d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8943d != null) goto L9;
        f8943d = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f8943d;
    }

    public void e(e r10) {
        if (r10 != null) goto L13;
        return;
    L13:
        b r11 = new b(this, r10, null);     // Catch: Throwable -> L10
        if (r10.c() == false) goto L7;
        ScheduledFuture<?> r12 = this.f8945a.scheduleWithFixedDelay(r11, r10.a(), r10.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f8947c.put(r10, r11);     // Catch: Throwable -> L10
        this.f8946b.put(r10, r12);     // Catch: Throwable -> L10
        return;
    L7:
        r12 = this.f8945a.schedule(r11, r10.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(f8944e, "sendTask failed.", th);
    }
}
