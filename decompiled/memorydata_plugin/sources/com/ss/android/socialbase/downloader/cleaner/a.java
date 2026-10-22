package com.ss.android.socialbase.downloader.cleaner;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f15340a;
    private static volatile a c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile b f15341b;

    static {
        f15340a = new AtomicBoolean();
        c = null;
    }

    public a() {
        this.f15341b = new b();
    }

    public static a a() {
        if (c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    static /* synthetic */ b a(a r0) {
        return r0.f15341b;
    }

    public boolean a(int r1) {
        if (r1 != 0) goto L6;
        return false;
    L6:
        return this.f15341b.b(r1);
    }

    public boolean a(DownloadInfo r1) {
        return this.f15341b.a(r1);
    }

    public boolean a(DownloadInfo r1, boolean r2) {
        return this.f15341b.a(r1, r2);
    }

    public void b() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        this.f15341b.a();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("Cleaner", CommonConsts.APM_INNER_EVENT_COST_INIT, "Cleaner init cost time=" + (System.currentTimeMillis() - r0));
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void b(int r1) {
        this.f15341b.a(r1);
    }

    public void c() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("Cleaner", CommonConsts.APM_INNER_EVENT_COST_START, "enter Cleaner start");
    L6:
        if (f15340a.compareAndSet(true, true) == false) goto L9;
        return;
    L9:
        if (com.ss.android.socialbase.downloader.utils.c.a() == true) goto L12;
        this.f15341b.d();
        return;
    L12:
        d.a();
        int r0 = com.ss.android.socialbase.downloader.g.a.c().b("start_clean_delay_time_s");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("Cleaner", "run", "Run cleaner startCleanDelayTime: " + r0 + " isNoCacheNeedClean:" + this.f15341b.b());
    L15:
        if (r0 > 0) goto L17;
    L21:
        this.f15341b.d();
        return;
    L17:
        if (this.f15341b.b() == true) goto L21;
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass1(this), r0, TimeUnit.SECONDS);
    }
}
