package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f15508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f15509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f15510c;
    public final Handler d;
    public final Runnable e;

    public AbsDownloadServiceHandler() {
        this.f15508a = new SparseArray();
        this.f15509b = false;
        this.f15510c = new AtomicBoolean(false);
        this.d = new Handler(Looper.getMainLooper());
        this.e = new AnonymousClass2(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void a() {
    }

    public abstract void a(Context r5, ServiceConnection r10);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void b(DownloadTask r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void c() {
        if (this.f15509b == false) goto L5;
        return;
    L5:
        if (Logger.b() == false) goto L8;
        Logger.b("AbsDownloadServiceHandler", "startService", "Run StartService");
    L8:
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L13
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L13
        a(r5, null);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void d() {
    }

    public final void e() {
        SparseArray r5 = this.f15508a;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Logger.b() == false) goto L9;
        Logger.b("AbsDownloadServiceHandler", "resumePendingTask", "PendingTasks.size:" + this.f15508a.size());     // Catch: Throwable -> L7
    L9:
        SparseArray r10 = this.f15508a.clone();     // Catch: Throwable -> L7
        this.f15508a.clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        AbsDownloadEngine r11 = DownloadComponentManager.j();
        if (r11 == null) goto L26;
        int r12 = 0;
    L15:
        if (r12 >= r10.size()) goto L36;
        List r13 = (List) r10.get(r10.keyAt(r12));
        if (r13 == null) goto L25;
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L25;
        DownloadTask r15 = (DownloadTask) r14.next();
        if (Logger.a(r15.f15878a) == false) goto L24;
        Logger.a("AbsDownloadServiceHandler", r15.f15878a, "resumePendingTask", "Resume Task");
    L24:
        r11.b(r15);
    L25:
        r12 = r12 + 1;
        goto L15
    L36:
        return;
    }

    public void f() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void a(IndependentProcessDownloadHandler r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder b() {
        if (Logger.b() == false) goto L6;
        Logger.b("AbsDownloadServiceHandler", "onBind", "OnBind Abs");
    L6:
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void a(DownloadTask r10) {
        DownloadInfo r5 = r10.f15878a;
        if (r5 != null) goto L5;
        return;
    L5:
        ((IDownloadGlobalThrottleService) DownloadServiceManager.a(IDownloadGlobalThrottleService.class)).a(r10);
        if (DownloadUtils.b() == false) goto L9;
        f();
    L9:
        if (this.f15509b == true) goto L26;
        if (Logger.a(r5) == false) goto L14;
        Logger.a("AbsDownloadServiceHandler", r5.l(), r5.P, "tryDownload", "Service is not alive", false);
    L14:
        if (this.f15510c.compareAndSet(false, true) == true) goto L16;
        this.d.removeCallbacks(this.e);
        this.d.postDelayed(this.e, 10);
        goto L26
    L16:
        if (Logger.a(r5) == false) goto L19;
        Logger.a("AbsDownloadServiceHandler", r5.l(), r5.P, "tryDownload", "Do StartService", false);
    L19:
        if (r10.f15878a.K == false) goto L23;
        f();
        if (Logger.a(r5) == false) goto L26;
        Logger.a("AbsDownloadServiceHandler", r5.l(), r5.P, "tryDownload", "NeedCurrentProcess", false);
        goto L26
    L23:
        Runnable r11 = new AnonymousClass1(this);
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(r11);
    L26:
        if (this.f15508a.get(r10.e()) == null) goto L38;
        SparseArray r12 = this.f15508a;
        monitor-enter(r12);
    L32:
        th = move-exception;
        throw th;
    L30:
        if (this.f15508a.get(r10.e()) == null) goto L34;
        this.f15508a.remove(r10.e());     // Catch: Throwable -> L32
    L34:
        monitor-exit(r12);     // Catch: Throwable -> L32
    L38:
        AbsDownloadEngine r13 = DownloadComponentManager.j();
        if (r13 == null) goto L41;
        r13.b(r10);
    L41:
        e();
    }
}
