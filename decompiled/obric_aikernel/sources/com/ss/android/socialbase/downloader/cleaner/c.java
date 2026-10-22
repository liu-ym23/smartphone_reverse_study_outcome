package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.utils.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Semaphore f7880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f7881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f7882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<Integer, List<Integer>> f7883d;

    class a implements Detecter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7884a;

        a(c r10) {
            this.f7884a = r10;
        }

        @Override // com.ss.android.socialbase.downloader.cleaner.Detecter.c
        public void a() {
            if (lb.a.a() == false) goto L5;
            lb.a.b("CleanerImpl", "startSync", "enter onSmooth");
        L5:
            c.b(this.f7884a);
        }

        @Override // com.ss.android.socialbase.downloader.cleaner.Detecter.c
        public void b() {
            if (lb.a.a() == false) goto L5;
            lb.a.b("CleanerImpl", "startSync", "enter onStuck");
        L5:
            c.a(this.f7884a, true);
        }
    }

    public c(b r10) {
        this.f7880a = new Semaphore(0);
        this.f7881b = false;
        this.f7882c = r10;
        this.f7883d = r10.c();
    }

    static /* synthetic */ boolean a(c r10, boolean r11) {
        r10.f7881b = r11;
        return r11;
    }

    static /* synthetic */ void b(c r10) {
        r10.c();
    }

    private void c() {
        if (this.f7881b == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, List<Integer>>> r10 = this.f7883d.entrySet().iterator();
    L39:
    L30:
        th = move-exception;
        if (lb.a.a() == false) goto L35;
        th.printStackTrace();
    L35:
        if (lb.a.a() == false) goto L37;
        lb.a.b("CleanerImpl", "startClean", "clean completed!");
    L37:
        this.f7880a.release();
        return;
    L7:
        if (r10.hasNext() == false) goto L35;
        Map.Entry<Integer, List<Integer>> r11 = r10.next();     // Catch: Throwable -> L30
        int r12 = r11.getKey().intValue();     // Catch: Throwable -> L30
        Iterator<Integer> r13 = r11.getValue().iterator();     // Catch: Throwable -> L30
    L10:
        if (r13.hasNext() == false) goto L28;
        if (this.f7881b == true) goto L14;
        int r14 = r13.next().intValue();     // Catch: Throwable -> L30
        if (this.f7882c.j(r14) == false) goto L21;
        g.h(this.f7882c.f(r14), this.f7882c.h(r14), this.f7882c.e(r14));     // Catch: Throwable -> L30
        com.ss.android.socialbase.downloader.downloader.a.o().j(r14);     // Catch: Throwable -> L30
        if (lb.a.a() == false) goto L27;
        lb.a.b("CleanerImpl", "startClean", "clean cache downloadId=" + r14);     // Catch: Throwable -> L30
    L27:
        r13.remove();     // Catch: Throwable -> L30
        this.f7882c.p(r14);     // Catch: Throwable -> L30
        goto L10
    L21:
        if (lb.a.a() == false) goto L23;
        lb.a.b("CleanerImpl", "startClean", "dwg888Find in visit history,can't do clean,downloadId=" + r14);     // Catch: Throwable -> L30
    L23:
        r13.remove();     // Catch: Throwable -> L30
        goto L10
    L14:
        if (lb.a.a() == false) goto L16;
        lb.a.b("CleanerImpl", "startClean", "stop cleaning");     // Catch: Throwable -> L30
    L16:
        this.f7881b = false;     // Catch: Throwable -> L30
        return;
    L28:
        r10.remove();     // Catch: Throwable -> L30
        this.f7882c.s(r12);     // Catch: Throwable -> L30
        goto L39
    }

    public void d() {
        if (this.f7882c.k() == true) goto L12;
        if (this.f7883d.isEmpty() == true) goto L12;
        long r10 = System.currentTimeMillis();
        Detecter r11 = new Detecter(new a(this));
        r11.j();
        c();
        this.f7880a.acquire();
        r11.k();
        if (lb.a.a() == false) goto L15;
        lb.a.b("CleanerImpl", "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - r10));
        return;
    L15:
        return;
    L12:
        if (lb.a.a() == false) goto L16;
        lb.a.b("CleanerImpl", "startSync", "CleanCacheKeyMaps Empty");
        return;
    }
}
