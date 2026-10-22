package jb;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f9793k = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SparseArray<List<com.ss.android.socialbase.downloader.model.d>> f9794c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected volatile boolean f9795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected AtomicBoolean f9796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f9797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f9798j;

    /* JADX INFO: renamed from: jb.a$a, reason: collision with other inner class name */
    class RunnableC0208a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9799c;

        RunnableC0208a(a r10) {
            this.f9799c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9799c.j(com.ss.android.socialbase.downloader.downloader.a.h(), null);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f9800c;

        b(a r10) {
            this.f9800c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lb.a.a() == false) goto L6;
            lb.a.b(a.f(), "debounceStartServiceRunnable_run", "Try startService");
        L6:
            if (this.f9800c.f9795g == false) goto L8;
            return;
        L8:
            if (lb.a.a() == false) goto L10;
            lb.a.b(a.f(), "debounceStartServiceRunnable_run", "Try startService Error");
        L10:
            this.f9800c.j(com.ss.android.socialbase.downloader.downloader.a.h(), null);
        }
    }

    static {
    }

    public a() {
        this.f9794c = new SparseArray();
        this.f9795g = false;
        this.f9796h = new AtomicBoolean(false);
        this.f9797i = new Handler(Looper.getMainLooper());
        this.f9798j = new b(this);
    }

    static /* synthetic */ String f() {
        return f9793k;
    }

    @Override // jb.o
    public boolean A() {
        return this.f9795g;
    }

    @Override // jb.o
    public void B() {
        if (this.f9795g == false) goto L5;
        return;
    L5:
        if (lb.a.a() == false) goto L7;
        lb.a.b(f9793k, "startService", "Run StartService");
    L7:
        j(com.ss.android.socialbase.downloader.downloader.a.h(), null);
    }

    @Override // jb.o
    public void C(com.ss.android.socialbase.downloader.model.d r10) {
    }

    @Override // jb.o
    public void a(n r10) {
    }

    @Override // jb.o
    public void b() {
        this.f9795g = false;
    }

    @Override // jb.o
    public void c(WeakReference r10) {
    }

    @Override // jb.o
    public void d() {
    }

    @Override // jb.o
    public void e(Intent r10, int r11, int r12) {
    }

    public void g(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.x();
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r12 = this.f9794c;
        monitor-enter(r12);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g(f9793k, r11, "pendDownloadTask", "PendingTasks.size:" + this.f9794c.size());     // Catch: Throwable -> L20
    L9:
        List<com.ss.android.socialbase.downloader.model.d> r13 = this.f9794c.get(r11);     // Catch: Throwable -> L20
        if (r13 != null) goto L13;
        r13 = new ArrayList();     // Catch: Throwable -> L20
        this.f9794c.put(r11, r13);     // Catch: Throwable -> L20
    L13:
        if (lb.a.a() == false) goto L15;
        lb.a.g(f9793k, r11, "pendDownloadTask", "Before taskArray.size:" + r13.size());     // Catch: Throwable -> L20
    L15:
        r13.add(r10);     // Catch: Throwable -> L20
        if (lb.a.a() == false) goto L18;
        lb.a.g(f9793k, r11, "pendDownloadTask", "After pendingTasks.size:" + this.f9794c.size());     // Catch: Throwable -> L20
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L20
    }

    protected void h() {
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r10 = this.f9794c;
        monitor-enter(r10);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (lb.a.a() == false) goto L7;
        lb.a.b(f9793k, "resumePendingTask", "PendingTasks.size:" + this.f9794c.size());     // Catch: Throwable -> L25
    L7:
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r11 = this.f9794c.clone();     // Catch: Throwable -> L25
        this.f9794c.clear();     // Catch: Throwable -> L25
        monitor-exit(r10);     // Catch: Throwable -> L25
        com.ss.android.socialbase.downloader.impls.a r12 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r12 == null) goto L24;
        int r13 = 0;
    L13:
        if (r13 >= r11.size()) goto L35;
        List<com.ss.android.socialbase.downloader.model.d> r14 = r11.get(r11.keyAt(r13));
        if (r14 == null) goto L23;
        Iterator<com.ss.android.socialbase.downloader.model.d> r15 = r14.iterator();
    L18:
        if (r15.hasNext() == false) goto L23;
        com.ss.android.socialbase.downloader.model.d r16 = r15.next();
        if (lb.a.a() == false) goto L22;
        lb.a.g(f9793k, r16.x(), "resumePendingTask", "Resume Task");
    L22:
        r12.Z(r16);
    L23:
        r13 = r13 + 1;
        goto L13
    L35:
        return;
    }

    protected void i() {
    }

    protected abstract void j(Context r10, ServiceConnection r11);

    @Override // jb.o
    public IBinder onBind(Intent r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f9793k, "onBind", "OnBind Abs");
    L6:
        return new Binder();
    }

    @Override // jb.o
    public void x(int r10) {
        lb.a.f(r10);
    }

    @Override // jb.o
    public void y(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.y() == null) goto L43;
        ((qb.m) qb.k.a(qb.m.class)).a(r10);
        if (this.f9795g == true) goto L24;
        if (lb.a.a() == false) goto L12;
        lb.a.g(f9793k, r10.x(), "tryDownload", "Service is not alive");
    L12:
        if (this.f9796h.compareAndSet(false, true) == true) goto L14;
        this.f9797i.removeCallbacks(this.f9798j);
        this.f9797i.postDelayed(this.f9798j, 10);
        goto L24
    L14:
        if (lb.a.a() == false) goto L17;
        lb.a.g(f9793k, r10.x(), "tryDownload", "Do StartService");
    L17:
        if (r10.y().isNeedCurrentProcess() == false) goto L21;
        i();
        if (lb.a.a() == false) goto L24;
        lb.a.g(f9793k, r10.x(), "tryDownload", "NeedCurrentProcess");
        goto L24
    L21:
        com.ss.android.socialbase.downloader.downloader.a.G0(new RunnableC0208a(this));
    L24:
        if (this.f9794c.get(r10.x()) == null) goto L35;
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r11 = this.f9794c;
        monitor-enter(r11);
    L32:
        th = move-exception;
        throw th;
    L28:
        if (this.f9794c.get(r10.x()) == null) goto L30;
        this.f9794c.remove(r10.x());     // Catch: Throwable -> L32
    L30:
        monitor-exit(r11);     // Catch: Throwable -> L32
    L35:
        com.ss.android.socialbase.downloader.impls.a r12 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r12 == null) goto L38;
        r12.Z(r10);
    L38:
        h();
        return;
    }
}
