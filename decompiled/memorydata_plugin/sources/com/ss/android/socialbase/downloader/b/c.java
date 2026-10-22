package com.ss.android.socialbase.downloader.b;

import android.os.Handler;
import android.os.Process;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.ss.android.socialbase.downloader.b.a.g;
import com.ss.android.socialbase.downloader.b.a.h;
import com.ss.android.socialbase.downloader.b.a.i;
import com.ss.android.socialbase.downloader.b.a.j;
import com.ss.android.socialbase.downloader.b.a.k;
import com.ss.android.socialbase.downloader.b.a.l;
import com.ss.android.socialbase.downloader.b.a.m;
import com.ss.android.socialbase.downloader.b.a.n;
import com.ss.android.socialbase.downloader.b.a.o;
import com.ss.android.socialbase.downloader.b.a.p;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.downloader.v;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f15280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f15281b;
    private Future c;

    public c(DownloadTask r3, Handler r4) {
        this.f15280a = new i();
        this.f15281b = new b(this.f15280a);
        this.f15280a.f15272b = r3;
        i r0 = this.f15280a;
        r0.c = r3.getDownloadInfo();
        i r1 = this.f15280a;
        r1.e = new com.ss.android.socialbase.downloader.downloader.e(r3, r4);
        i r5 = this.f15280a;
        r5.d = com.ss.android.socialbase.downloader.g.a.a(r5.c.getId());
        i r6 = this.f15280a;
        r6.f15271a = com.ss.android.socialbase.downloader.downloader.b.C();
        i r7 = this.f15280a;
        r7.m = new w(this.f15280a.c);
        i r8 = this.f15280a;
        r8.n = new v(this.f15280a.c);
    }

    private void i() {
        j();
        if (com.ss.android.socialbase.downloader.e.a.a(this.f15280a.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRunnable", this.f15280a.c, "run", "Run Time:" + (System.currentTimeMillis() - this.f15280a.f15272b.getTimingInfo().f));
    L5:
        ac r0 = com.ss.android.socialbase.downloader.downloader.b.L();
        if (r0 == null) goto L13;
        r0.a(this.f15280a.c.getStatus());
    L13:
        com.ss.android.socialbase.downloader.downloader.b.F().a(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    private void j() {
        this.f15280a.f15272b.getTimingInfo().d();
        this.f15280a.f15272b.getThreadInfo().c();
    }

    public void a() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.f15280a.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRunnable", this.f15280a.c, "pause", "Run");
    L5:
        i r0 = this.f15280a;
        r0.f = RunStatus.RUN_STATUS_PAUSE;
        this.f15281b.c();
        if (this.f15281b.f() == true) goto L9;
        this.f15280a.e.e();
        j();
        return;
    }

    public void a(long r1, int r3) {
        this.f15281b.a(r1, r3);
    }

    public void a(Future r3) {
        this.c = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        this.f15280a.h = r1;
    }

    public void b() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.f15280a.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRunnable", this.f15280a.c, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "Run");
    L5:
        i r0 = this.f15280a;
        r0.f = RunStatus.RUN_STATUS_CANCELED;
        this.f15281b.d();
        if (this.f15281b.f() == true) goto L9;
        this.f15280a.e.d();
        j();
        return;
    }

    public DownloadTask c() {
        return this.f15280a.f15272b;
    }

    public boolean d() {
        return this.f15280a.g;
    }

    public int e() {
        return this.f15280a.c.getId();
    }

    public DownloadInfo f() {
        return this.f15280a.c;
    }

    public void g() {
        this.f15280a.e.a();
    }

    public Future h() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.model.e r0 = this.f15280a.f15272b.getTimingInfo();
        r0.f = System.currentTimeMillis();
        if (com.ss.android.socialbase.downloader.e.a.a(this.f15280a.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadRunnable", this.f15280a.c, "run", "Run");
    L5:
        Process.setThreadPriority(10);
        b r1 = new b(this.f15280a).a(new com.ss.android.socialbase.downloader.b.a.e()).a(new com.ss.android.socialbase.downloader.b.a.d()).a(new h()).a(new com.ss.android.socialbase.downloader.b.a.f()).a(new com.ss.android.socialbase.downloader.b.a.a.a()).a(new com.ss.android.socialbase.downloader.b.a.b.a()).a(new com.ss.android.socialbase.downloader.b.a.d.a()).a(new com.ss.android.socialbase.downloader.b.a.c.a()).a(new j());
        this.f15281b.a(new g()).a(new com.ss.android.socialbase.downloader.b.a.b()).a(new m()).a(new p()).a(new k()).a(new o()).a(new l()).a(new com.ss.android.socialbase.downloader.b.a.c()).a(new n(r1));
        this.f15281b.a();     // Catch: Throwable -> L8
    L10:
        i();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        this.f15280a.e.b(new BaseException(1045, th));
        goto L10
    }
}
