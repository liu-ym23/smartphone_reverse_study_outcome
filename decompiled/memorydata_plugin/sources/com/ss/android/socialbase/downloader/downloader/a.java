package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements n {
    private static final String d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final SparseArray<List<DownloadTask>> f15397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile boolean f15398b;
    protected AtomicBoolean c;
    private WeakReference<Service> e;
    private Handler f;
    private Runnable g;

    static {
    }

    public a() {
        this.f15397a = new SparseArray();
        this.f15398b = false;
        this.c = new AtomicBoolean(false);
        this.f = new Handler(Looper.getMainLooper());
        this.g = new AnonymousClass2(this);
    }

    static /* synthetic */ String f() {
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public IBinder a(Intent r2) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(d, "onBind", "OnBind Abs");
    L6:
        return new Binder();
    }

    public void a() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(int r1) {
        com.ss.android.socialbase.downloader.e.a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(Intent r1, int r2, int r3) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(m r2) {
        m r1 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
    }

    public void a(DownloadTask r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r0 = r8.getDownloadId();
        DownloadInfo r1 = r8.getDownloadInfo();
        SparseArray<List<DownloadTask>> r2 = this.f15397a;
        monitor-enter(r2);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a(r1) == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a(d, r1, "pendDownloadTask", "PendingTasks.size:" + this.f15397a.size());     // Catch: Throwable -> L20
    L9:
        List<DownloadTask> r3 = (List) ZeusTransformUtils.preCheckCast(this.f15397a.get(r0), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r3 != null) goto L13;
        r3 = new ArrayList();     // Catch: Throwable -> L20
        this.f15397a.put(r0, r3);     // Catch: Throwable -> L20
    L13:
        if (com.ss.android.socialbase.downloader.e.a.a(r1) == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a(d, r1, "pendDownloadTask", "Before taskArray.size:" + r3.size());     // Catch: Throwable -> L20
    L15:
        r3.add(r8);     // Catch: Throwable -> L20
        if (com.ss.android.socialbase.downloader.e.a.a(r1) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a(d, r1, "pendDownloadTask", "After pendingTasks.size:" + this.f15397a.size());     // Catch: Throwable -> L20
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L20
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(WeakReference r1) {
        this.e = r1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void b(DownloadTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r5.getDownloadInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        ((com.ss.android.socialbase.downloader.service.m) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.m.class), com.ss.android.socialbase.downloader.service.m.class, "com.obric.memorydata.plugin")).a(r5);
        if (this.f15398b == true) goto L25;
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a(d, r0, "tryDownload", "Service is not alive");
    L13:
        if (this.c.compareAndSet(false, true) == true) goto L15;
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 10);
        goto L25
    L15:
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a(d, r0, "tryDownload", "Do StartService");
    L18:
        if (r5.getDownloadInfo().isNeedCurrentProcess() == false) goto L22;
        a();
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L25;
        com.ss.android.socialbase.downloader.e.a.a(d, r0, "tryDownload", "NeedCurrentProcess");
        goto L25
    L22:
        b.a(new AnonymousClass1(this));
    L25:
        if (this.f15397a.get(r5.getDownloadId()) == null) goto L36;
        SparseArray<List<DownloadTask>> r1 = this.f15397a;
        monitor-enter(r1);
    L33:
        th = move-exception;
        throw th;
    L29:
        if (this.f15397a.get(r5.getDownloadId()) == null) goto L31;
        this.f15397a.remove(r5.getDownloadId());     // Catch: Throwable -> L33
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L33
    L36:
        com.ss.android.socialbase.downloader.impls.a r2 = b.F();
        if (r2 == null) goto L39;
        r2.b(r5);
    L39:
        e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public boolean b() {
        return this.f15398b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void c(DownloadTask r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void d() {
        this.f15398b = false;
    }

    public void e() {
        SparseArray<List<DownloadTask>> r0 = this.f15397a;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a(d, "resumePendingTask", "PendingTasks.size:" + this.f15397a.size());     // Catch: Throwable -> L25
    L7:
        SparseArray<List<DownloadTask>> r1 = this.f15397a.clone();     // Catch: Throwable -> L25
        this.f15397a.clear();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        com.ss.android.socialbase.downloader.impls.a r8 = b.F();
        if (r8 == null) goto L24;
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L35;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1.get(r1.keyAt(r2)), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L23;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L23;
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(r4.next(), DownloadTask.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(r5.getDownloadInfo()) == false) goto L22;
        com.ss.android.socialbase.downloader.e.a.a(d, r5.getDownloadInfo(), "resumePendingTask", "Resume Task");
    L22:
        r8.b(r5);
    L23:
        r2 = r2 + 1;
        goto L13
    L35:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void startService() {
        if (this.f15398b == false) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a(d, "startService", "Run StartService");
    L7:
        startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null);
    }

    public void startService(Context r2, ServiceConnection r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
    }

    public void stopService(Context r2, ServiceConnection r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
    }
}
