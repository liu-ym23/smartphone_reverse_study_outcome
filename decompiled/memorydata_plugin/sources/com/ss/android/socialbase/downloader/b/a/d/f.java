package com.ss.android.socialbase.downloader.b.a.d;

import android.os.Process;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public class f extends com.ss.android.socialbase.downloader.b.a.a implements b.a, Runnable {
    private Future g;
    private boolean h;
    private c i;
    private com.ss.android.socialbase.downloader.b.d j;
    private com.ss.android.socialbase.downloader.network.h k;
    private e l;
    private d m;
    private b n;
    private i o;
    private g p;
    private int q;
    private a r;
    private g s;
    private h t;

    public interface a {
        void a(Throwable r1);
    }

    public f(e r3, d r4, b r5, i r6, g r7, int r8, a r9) {
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        this.h = false;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        r5.a(this);
        this.o = r6;
        this.p = r7;
        this.q = r8;
        this.r = r10;
    }

    private Throwable a(String r21, boolean r22) {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "doDownload", "Before Url:" + r21 + " isPcdn:" + r22 + " index:" + this.i.f15255a);
    L5:
        this.o.a(r21, r22);
        List<HttpHeader> r0 = a(this.i.f15256b, this.i.c, true);
        long r6 = (this.i.c - this.i.f15256b) + 1;
        Throwable r16 = null;
        this.k = a(r21, r0, this.i.f15256b);     // Catch: Throwable -> L8
        com.ss.android.socialbase.downloader.b.d r1 = new com.ss.android.socialbase.downloader.b.d(this.f, this.k, this.i.f15256b, r6, this);     // Catch: Throwable -> L8
        this.j = r1;     // Catch: Throwable -> L8
        r1.a();     // Catch: Throwable -> L8
        this.l.a(this.i.f15255a);     // Catch: Throwable -> L8
    L12:
        Throwable r2 = r16;
        this.o.a(r21, this.i.f15256b, r22, g(), this.k, this.j, r2);
        com.ss.android.socialbase.downloader.b.d r4 = this.j;
        if (r4 == null) goto L16;
        this.i.f15256b = r4.d();
    L16:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "doDownload", "After Url:" + r21 + " isPcdn:" + r22 + " index:" + this.i.f15255a);
    L18:
        return r2;
    L8:
        th = move-exception;
        r16 = th;
        r16.printStackTrace();
        this.s.d();
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "doDownload", "OnError index:" + this.i.f15255a);
        goto L12
    }

    private void e() {
        g r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        g r1 = new g(this.c.getPcdnUrls(), this.c.getCdnUrls());
    L8:
        this.s = r1;
        this.t = new h(this.q);
    L9:
        Throwable r2 = a(this.s.a(), this.s.c());
        if (r2 == null) goto L26;
        if (this.t.a(true) == false) goto L15;
        if (g() == false) goto L9;
        return;
    L15:
        if (g() == true) goto L25;
        this.r.a(r2);
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (r0.c() == true) goto L7;
        r1 = this.p.e();
        goto L8
    }

    private void f() {
        this.g.cancel(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean g() {
        if (j_() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.h == true) goto L8;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a() {
        this.h = true;
        com.ss.android.socialbase.downloader.b.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.b();
    L6:
        f();
        return;
    L5:
        a(this.k);
        goto L6
    }

    public void a(Future r3) {
        this.g = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.h.d
    public boolean a(long r2) {
        if (this.s.c() == false) goto L6;
        this.n.a(r2);
    L6:
        return this.l.a(this.i.f15255a, r2);
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void b() {
        this.h = true;
        com.ss.android.socialbase.downloader.b.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.c();
    L6:
        f();
        return;
    L5:
        a(this.k);
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.b.a.d.b.a
    public void c() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "onLowSpeed", "Run");
    L5:
        h r0 = this.t;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.a(false) == false) goto L19;
        g r1 = this.s;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.b() == true) goto L14;
        return;
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "onLowSpeed", "Run switch cdn");
    L16:
        a(this.k);
        return;
    }

    public Future d() {
        return this.g;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "run", "Run");
    L5:
        this.n.a();
    L7:
        if (g() == true) goto L13;
        c r0 = this.m.a();
        this.i = r0;
        if (r0 == null) goto L10;
        e();
        goto L7
    L10:
        return;
    L13:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("PCDNChunkRunnableModule", this.c, "run", "Run End");
        return;
    }
}
