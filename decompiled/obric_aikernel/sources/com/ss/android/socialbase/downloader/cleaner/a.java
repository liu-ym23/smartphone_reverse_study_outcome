package com.ss.android.socialbase.downloader.cleaner;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f7863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f7864c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f7865a;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.a$a, reason: collision with other inner class name */
    class RunnableC0140a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f7866c;

        RunnableC0140a(a r10) {
            this.f7866c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            new c(a.a(this.f7866c)).d();     // Catch: Throwable -> L4
        L3:
            a.a(this.f7866c).b();
            return;
        L4:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L8
            lb.a.c("Cleaner", "run", "Exception: " + th);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            a.a(this.f7866c).b();
            throw th;
        }
    }

    static {
        f7863b = new AtomicBoolean();
        f7864c = null;
    }

    public a() {
        this.f7865a = new b();
    }

    static /* synthetic */ b a(a r10) {
        return r10.f7865a;
    }

    public static a b() {
        if (f7864c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7864c != null) goto L9;
        f7864c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7864c;
    }

    public void c() {
        if (lb.a.a() == false) goto L5;
        long r10 = System.currentTimeMillis();
    L6:
        this.f7865a.i();
        if (lb.a.a() == false) goto L10;
        lb.a.b("Cleaner", CommonConsts.APM_INNER_EVENT_COST_INIT, "Cleaner init cost time=" + (System.currentTimeMillis() - r10));
        return;
    L10:
        return;
    L5:
        r10 = 0;
        goto L6
    }

    public boolean d(int r10) {
        if (r10 != 0) goto L6;
        return false;
    L6:
        return this.f7865a.j(r10);
    }

    public void e(int r10) {
        this.f7865a.p(r10);
    }

    public void f() {
        if (lb.a.a() == false) goto L6;
        lb.a.b("Cleaner", CommonConsts.APM_INNER_EVENT_COST_START, "enter Cleaner start");
    L6:
        if (f7863b.compareAndSet(true, true) == false) goto L9;
        return;
    L9:
        if (com.ss.android.socialbase.downloader.utils.c.F() == true) goto L12;
        this.f7865a.b();
        return;
    L12:
        d.a();
        int r10 = rb.a.j().n("start_clean_delay_time_s");
        if (lb.a.a() == false) goto L15;
        lb.a.b("Cleaner", "run", "Run cleaner startCleanDelayTime: " + r10 + " isNoCacheNeedClean:" + this.f7865a.k());
    L15:
        if (r10 > 0) goto L17;
    L21:
        this.f7865a.b();
        return;
    L17:
        if (this.f7865a.k() == true) goto L21;
        com.ss.android.socialbase.downloader.downloader.a.L0(new RunnableC0140a(this), r10, TimeUnit.SECONDS);
    }

    public boolean g(DownloadInfo r10) {
        return this.f7865a.r(r10);
    }
}
