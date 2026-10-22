package hb;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import jb.u;

/* JADX INFO: loaded from: classes2.dex */
public class f implements u, ServiceConnection {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f9245m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f9246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f9247o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private hb.c f9248c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f9249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private hb.b f9250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.a.e.InterfaceC0143a f9251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f9252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Future<?> f9253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CountDownLatch f9254l;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f9255c;

        a(f r10) {
            this.f9255c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.n() == false) goto L5;
            return;
        L5:
            if (f.p(this.f9255c) == null) goto L9;
            f.p(this.f9255c).a();
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IBinder f9256c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f9257g;

        class a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f9258a;

            a(b r10) {
                this.f9258a = r10;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                f.o(false);
                if (f.t(this.f9258a.f9257g) == false) goto L5;
                return;
            L5:
                if (f.p(this.f9258a.f9257g) == null) goto L9;
                f.w(this.f9258a.f9257g).postDelayed(f.u(this.f9258a.f9257g), 2000);
                return;
            }
        }

        b(f r10, IBinder r11) {
            this.f9257g = r10;
            this.f9256c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            monitor-enter(this);
        L15:
            th = move-exception;
            lb.a.c("SqlDownloadCacheAidlWra", "onServiceConnected", "Exception: " + th);     // Catch: Throwable -> L24
            if (f.p(this.f9257g) == null) goto L19;
            f.p(this.f9257g).a();     // Catch: Throwable -> L24
        L19:
            f.s(this.f9257g).countDown();     // Catch: Throwable -> L13
            IBinder r10 = this.f9256c;     // Catch: Throwable -> L30
            a r11 = new a(this);     // Catch: Throwable -> L30
        L11:
            r10.linkToDeath(r11, 0);     // Catch: Throwable -> L30
        L24:
            th = move-exception;
            f.s(this.f9257g).countDown();     // Catch: Throwable -> L13
            this.f9256c.linkToDeath(new a(this), 0);     // Catch: Throwable -> L31
        L27:
            throw th;     // Catch: Throwable -> L13
        L5:
            if (f.q(this.f9257g) != null) goto L7;
        L9:
            f.s(this.f9257g).countDown();     // Catch: Throwable -> L13
            r10 = this.f9256c;     // Catch: Throwable -> L30
            r11 = new a(this);     // Catch: Throwable -> L30
            goto L11
        L7:
            if (f.r(this.f9257g) == null) goto L9;
            f.r(this.f9257g).s1(f.q(this.f9257g));     // Catch: Throwable -> L15
        L22:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f9259c;

        c(f r10) {
            this.f9259c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.a.h(), this.f9259c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SparseArray f9260c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HashMap f9261g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f9262h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ hb.d f9263i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f9264j;

        class a extends hb.b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f9265c;

            a(d r10) {
                this.f9265c = r10;
            }

            @Override // hb.b
            public void c1(Map r10, Map r11, Map r12, boolean r13) {
                com.ss.android.socialbase.downloader.utils.c.a0(this.f9265c.f9260c, r10);
                HashMap r14 = this.f9265c.f9261g;
                if (r14 == null) goto L11;
                monitor-enter(r14);
                com.ss.android.socialbase.downloader.utils.c.j(r11, this.f9265c.f9261g);     // Catch: Throwable -> L8
                monitor-exit(r14);     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                throw th;
            L11:
                com.ss.android.socialbase.downloader.utils.c.O(r12, this.f9265c.f9262h);
                this.f9265c.f9263i.a(r13);
                if (r13 == false) goto L17;
                this.f9265c.f9264j.C(null);
                return;
            }
        }

        d(f r10, SparseArray r11, HashMap r12, List r13, hb.d r14) {
            this.f9264j = r10;
            this.f9260c = r11;
            this.f9261g = r12;
            this.f9262h = r13;
            this.f9263i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9264j.C(new a(this));
            boolean r10 = false;
            boolean r11 = !f.s(this.f9264j).await(5000, TimeUnit.MILLISECONDS);
        L7:
            if (r11 == false) goto L11;
            Future r12 = f.x(this.f9264j);
            if (r12 == null) goto L11;
            r12.cancel(true);
        L11:
            f r13 = this.f9264j;
            if (this.f9261g != null) goto L14;
        L16:
            r13.B(r10);
            if (r11 == false) goto L24;
            hb.d r14 = this.f9263i;
            if (r14 == null) goto L25;
            r14.a(true);
            return;
        L25:
            return;
        L24:
            return;
        L14:
            if (this.f9262h == null) goto L16;
            r10 = true;
        L5:
            th = move-exception;
            th.printStackTrace();
            r11 = false;
            goto L7
        }
    }

    static {
    }

    public f() {
        this.f9249g = new Handler(Looper.getMainLooper());
        this.f9250h = null;
        this.f9252j = new a(this);
        this.f9254l = new CountDownLatch(1);
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.a.h(), this);
    }

    static /* synthetic */ boolean n() {
        return f9245m;
    }

    static /* synthetic */ boolean o(boolean r10) {
        f9245m = r10;
        return r10;
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.downloader.a.e.InterfaceC0143a p(f r10) {
        return r10.f9251i;
    }

    static /* synthetic */ hb.b q(f r10) {
        return r10.f9250h;
    }

    static /* synthetic */ hb.c r(f r10) {
        return r10.f9248c;
    }

    static /* synthetic */ CountDownLatch s(f r10) {
        return r10.f9254l;
    }

    static /* synthetic */ boolean t(f r10) {
        return r10.z();
    }

    static /* synthetic */ Runnable u(f r10) {
        return r10.f9252j;
    }

    static /* synthetic */ Handler w(f r10) {
        return r10.f9249g;
    }

    static /* synthetic */ Future x(f r10) {
        return r10.f9253k;
    }

    private boolean z() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return false;
    L6:
        if (f9245m == false) goto L9;
        return false;
    L9:
        if (f9246n > 5) goto L11;
        long r10 = System.currentTimeMillis();
        if ((r10 - f9247o) < 15000) goto L17;
        f9246n++;
        f9247o = r10;
        this.f9249g.postDelayed(new c(this), 1000);
        return true;
    L17:
        if (lb.a.a() == false) goto L19;
        lb.a.b("SqlDownloadCacheAidlWra", "bindMainProcessDelayed", "Time too short since last bin");
    L19:
        return false;
    L11:
        if (lb.a.a() == false) goto L13;
        lb.a.b("SqlDownloadCacheAidlWra", "bindMainProcessDelayed", "Bind too many times");
    L13:
        return false;
    }

    public ArrayList<i> A(int r10) {
        return null;
    }

    @Override // jb.i
    public boolean A0() {
        hb.c r10 = this.f9248c;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.A0();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void B(boolean r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L11;
        r11.A(r10);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.i
    public DownloadInfo B0(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.B0(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void C(hb.b r10) {
        monitor-enter(this);
        hb.c r11 = this.f9248c;     // Catch: Throwable -> L12
        if (r11 != null) goto L17;
        this.f9250h = r10;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L17:
        r11.s1(r10);     // Catch: RemoteException -> L7 Throwable -> L12
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void D(com.ss.android.socialbase.downloader.downloader.a.e.InterfaceC0143a r10) {
        this.f9251i = r10;
    }

    @Override // jb.i
    public DownloadInfo E(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.E(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public DownloadInfo I0(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.I0(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public boolean U0(int r10, Map<Long, i> r11) {
        return false;
    }

    @Override // jb.i
    public DownloadInfo V(int r10, long r11) {
        hb.c r12 = this.f9248c;     // Catch: RemoteException -> L6
        if (r12 == null) goto L12;
        return r12.V(r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    @Nullable
    public DownloadInfo a(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.a(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public boolean b(DownloadInfo r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.b(r10);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.i
    public void c() {
        hb.c r10 = this.f9248c;     // Catch: RemoteException -> L6
        if (r10 == null) goto L11;
        r10.c();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.i
    public boolean d() {
        hb.c r10 = this.f9248c;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.d();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.i
    public DownloadInfo d0(int r10, long r11) {
        hb.c r12 = this.f9248c;     // Catch: RemoteException -> L6
        if (r12 == null) goto L12;
        return r12.d0(r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> e(String r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.e(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> f(String r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.f(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public void f2(int r10) {
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> g(String r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.g(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public boolean h(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.h(r10);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.i
    public void i(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L11;
        r11.i(r10);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.i
    public boolean j(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.j(r10);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> k() {
        hb.c r10 = this.f9248c;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.k();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public /* bridge */ /* synthetic */ List k1(int r10) {
        return A(r10);
    }

    @Override // jb.u
    public void k2(SparseArray<DownloadInfo> r10, HashMap<Integer, Integer> r11, List<DownloadInfo> r12, List<String> r13, hb.d r14) {
        com.ss.android.socialbase.downloader.downloader.a.i().submit(new d(this, r10, r11, r12, r14));
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> l(String r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.l(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public Map<Long, i> l2(int r10) {
        return null;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> m(String r10, String r11) {
        hb.c r12 = this.f9248c;     // Catch: RemoteException -> L6
        if (r12 == null) goto L12;
        return r12.m(r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public DownloadInfo n0(int r10, long r11) {
        hb.c r12 = this.f9248c;     // Catch: RemoteException -> L6
        if (r12 == null) goto L12;
        return r12.n0(r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r10, IBinder r11) {
        f9245m = true;
        this.f9249g.removeCallbacks(this.f9252j);
        this.f9248c = hb.c.a.p2(r11);     // Catch: Throwable -> L5
    L7:
        this.f9253k = com.ss.android.socialbase.downloader.downloader.a.i().submit(new b(this, r11));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r10) {
        this.f9248c = null;
        f9245m = false;
    }

    @Override // jb.i
    public DownloadInfo t0(int r10, long r11, String r12, String r13) {
        hb.c r14 = this.f9248c;     // Catch: RemoteException -> L6
        if (r14 == null) goto L12;
        return r14.t0(r10, r11, r12, r13);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public void v(DownloadInfo r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L11;
        r11.v(r10);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.i
    public DownloadInfo w0(int r10) {
        hb.c r11 = this.f9248c;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.w0(r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // jb.i
    public DownloadInfo y(int r10, long r11) {
        hb.c r12 = this.f9248c;     // Catch: RemoteException -> L6
        if (r12 == null) goto L12;
        return r12.y(r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
