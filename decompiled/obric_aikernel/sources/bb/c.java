package bb;

import android.os.Handler;
import android.os.Process;
import cb.g;
import cb.h;
import cb.i;
import cb.j;
import cb.l;
import cb.m;
import cb.n;
import cb.o;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.k;
import ib.f0;
import java.util.concurrent.Future;
import jb.v;
import jb.w;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f552c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Future f554h;

    public c(com.ss.android.socialbase.downloader.model.d r10, Handler r11) {
        h r12 = new h();
        this.f552c = r12;
        this.f553g = new b(r12);
        h r13 = this.f552c;
        r13.f677b = r10;
        r13.f678c = r10.y();
        h r14 = this.f552c;
        r14.f680e = new jb.e(r10, r11);
        h r15 = this.f552c;
        r15.f679d = rb.a.g(r15.f678c.getId());
        h r16 = this.f552c;
        r16.f676a = com.ss.android.socialbase.downloader.downloader.a.o();
        h r17 = this.f552c;
        r17.f688m = new w(r17.f678c);
        h r18 = this.f552c;
        r18.f689n = new v(r18.f678c);
    }

    private void a() {
        i();
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadRunnable", this.f552c.f678c.getId(), "run", "Run Time:" + (System.currentTimeMillis() - this.f552c.f677b.M().f8186f));
    L5:
        f0 r10 = com.ss.android.socialbase.downloader.downloader.a.B();
        if (r10 == null) goto L16;
        r10.a(this.f552c.f678c.getStatus());
    L16:
        com.ss.android.socialbase.downloader.downloader.a.s().K(this);     // Catch: Throwable -> L10
    L13:
        if (k.j(this.f552c.f678c) == false) goto L18;
        k.f().l(this);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    private void i() {
        this.f552c.f677b.M().d();
        this.f552c.f677b.L().d();
    }

    public void b() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadRunnable", this.f552c.f678c.getId(), "cancel", "Run");
    L5:
        h r10 = this.f552c;
        r10.f681f = RunStatus.RUN_STATUS_CANCELED;
        this.f553g.d();
        if (this.f553g.e() == true) goto L9;
        this.f552c.f680e.i();
        i();
        return;
    }

    public int c() {
        return this.f552c.f678c.getId();
    }

    public com.ss.android.socialbase.downloader.model.d d() {
        return this.f552c.f677b;
    }

    public Future e() {
        return this.f554h;
    }

    public boolean f() {
        return this.f552c.f682g;
    }

    public void g() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadRunnable", this.f552c.f678c.getId(), "pause", "Run");
    L5:
        h r10 = this.f552c;
        r10.f681f = RunStatus.RUN_STATUS_PAUSE;
        this.f553g.f();
        if (this.f553g.e() == true) goto L9;
        this.f552c.f680e.o();
        i();
        return;
    }

    public void h() {
        this.f552c.f680e.p();
    }

    public void j(boolean r10) {
        this.f553g.h(r10);
    }

    public void k(boolean r10) {
        this.f552c.f683h = r10;
    }

    public void l(Future r10) {
        this.f554h = r10;
    }

    public void m(long r10, int r11) {
        this.f553g.i(r10, r11);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.model.f r10 = this.f552c.f677b.M();
        r10.f8186f = System.currentTimeMillis();
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadRunnable", this.f552c.f678c.getId(), "run", "Run");
    L5:
        Process.setThreadPriority(10);
        b r11 = new b(this.f552c).c(new cb.e()).c(new cb.d()).c(new g()).c(new cb.f()).c(new db.a()).c(new eb.a()).c(new gb.a()).c(new fb.a()).c(new i());
        this.f553g.c(new cb.b()).c(new l()).c(new o()).c(new j()).c(new n()).c(new cb.k()).c(new cb.c()).c(new m(r11));
        this.f553g.b();     // Catch: Throwable -> L8
    L10:
        a();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        this.f552c.f680e.l(new BaseException(1045, th));
        goto L10
    }
}
