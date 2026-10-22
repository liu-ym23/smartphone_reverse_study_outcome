package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import jb.u;

/* JADX INFO: loaded from: classes2.dex */
public class b implements jb.i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static AtomicBoolean f7963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static AtomicBoolean f7964q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f7965c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u f7966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f7967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f7968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ThreadLocal<Boolean> f7972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private sb.f.a f7973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private sb.f f7974o;

    class a implements sb.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7975a;

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.b$a$a, reason: collision with other inner class name */
        class RunnableC0145a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f7976c;

            RunnableC0145a(a r10) {
                this.f7976c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7976c.f7975a.A();     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                e.printStackTrace();
            }
        }

        a(b r10) {
            this.f7975a = r10;
        }

        @Override // sb.f.a
        public void handleMsg(Message r10) {
            if (r10.what != 1) goto L6;
            com.ss.android.socialbase.downloader.downloader.a.i().execute(new RunnableC0145a(this));
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.b$b, reason: collision with other inner class name */
    class C0146b implements com.ss.android.socialbase.downloader.downloader.a.e.InterfaceC0143a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7977a;

        C0146b(b r10) {
            this.f7977a = r10;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.a.e.InterfaceC0143a
        public void a() {
            b.n(this.f7977a, new hb.e());
            lb.a.c("DefaultDownloadCache", "onRebindError", "Rebind error,use backup sqlDownloadCache");
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f7978c;

        c(b r10) {
            this.f7978c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7978c.u();
        }
    }

    class d implements hb.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SparseArray f7979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f7980b;

        d(b r10, SparseArray r11) {
            this.f7980b = r10;
            this.f7979a = r11;
        }

        @Override // hb.d
        public void a(boolean r10) {
            if (this.f7979a == null) goto L12;
            int r11 = 0;
        L6:
            if (r11 >= this.f7979a.size()) goto L12;
            int r12 = this.f7979a.keyAt(r11);
            if (r12 == 0) goto L10;
            b.o(this.f7980b).n((DownloadInfo) this.f7979a.get(r12));
        L10:
            r11 = r11 + 1;
        L12:
            if (lb.a.a() == false) goto L14;
            lb.a.b("DefaultDownloadCache", "callback", "Finish:" + r10);
        L14:
            if (r10 == false) goto L20;
            b.p(this.f7980b);
            return;
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f7981c;

        e(b r10) {
            this.f7981c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.p(this.f7981c);
        }
    }

    static {
        f7963p = new AtomicBoolean(false);
        f7964q = new AtomicBoolean(false);
    }

    public b() {
        boolean r10 = false;
        this.f7971l = false;
        this.f7972m = new ThreadLocal();
        this.f7973n = new a(this);
        this.f7974o = null;
        if (com.ss.android.socialbase.downloader.utils.c.F() == false) goto L5;
    L8:
        u r11 = new hb.e();
    L9:
        this.f7966g = r11;
        this.f7967h = false;
        this.f7974o = new sb.f(Looper.getMainLooper(), this.f7973n);
        if (rb.a.d().optInt("lru_download_info_cache_enable", 0) <= 0) goto L12;
    L15:
        f r12 = new LruDownloadCache(this.f7966g);
    L16:
        this.f7965c = r12;
        this.f7969j = rb.a.d().optInt("load_db_wait_time_ms", 5000);
        this.f7970k = rb.a.d().optInt("biz_close_db_batch_init", 0);
        if (rb.a.d().optInt("thread_load_download_cache_only_once") <= 0) goto L19;
        r10 = true;
    L19:
        this.f7971l = r10;
        c r13 = new c(this);
        long r14 = rb.a.j().r("delay_init_download_cache_ms");
        if (r14 <= 0) goto L22;
        com.ss.android.socialbase.downloader.downloader.a.L0(r13, r14, TimeUnit.MILLISECONDS);
        return;
    L22:
        r13.run();
        return;
    L12:
        if (com.ss.android.socialbase.downloader.downloader.a.Y() == true) goto L15;
        r12 = new f(this.f7966g);
        goto L16
    L5:
        if (com.ss.android.socialbase.downloader.downloader.a.N0() == false) goto L8;
        r11 = com.ss.android.socialbase.downloader.downloader.a.J().b(new C0146b(this));
        goto L9
    }

    private void C(DownloadInfo r10) {
        D(r10, true);
    }

    private void D(DownloadInfo r10, boolean r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.utils.c.Q() == false) goto L10;
        if (r11 == false) goto L12;
        jb.m r12 = g.a(true);
        if (r12 == null) goto L10;
        r12.b(r10);
        return;
    L12:
        return;
    L10:
        this.f7966g.b(r10);
    }

    private void F(Object r10) {
        if (this.f7971l == false) goto L9;
        if (this.f7972m.get() == null) goto L7;
        return;
    L7:
        this.f7972m.set(Boolean.TRUE);
    L9:
        if (lb.a.a() == false) goto L16;
        lb.a.b("DefaultDownloadCache", "waitDBLoad", "Run loadDBWaitTime:" + this.f7969j);
    L16:
        r10.wait(this.f7969j);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("DefaultDownloadCache", "waitDBLoad", "Error:" + th);
    }

    static /* synthetic */ u n(b r10, u r11) {
        r10.f7966g = r11;
        return r11;
    }

    static /* synthetic */ f o(b r10) {
        return r10.f7965c;
    }

    static /* synthetic */ void p(b r10) {
        r10.t();
    }

    private void t() {
        if (f7964q.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        z();
        B();
        com.ss.android.socialbase.downloader.downloader.a.f0(DownloadCacheSyncStatus.SYNC_SUCCESS);
    }

    private void w() {
        com.ss.android.socialbase.downloader.impls.a r10 = com.ss.android.socialbase.downloader.downloader.a.s();
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f7967h == false) goto L7;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.b("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L14
    L9:
        u();     // Catch: Throwable -> L14
        F(r10);     // Catch: Throwable -> L14
        if (lb.a.a() == false) goto L12;
        lb.a.b("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L14
        goto L12
    }

    private void x() {
        com.ss.android.socialbase.downloader.impls.a r10 = com.ss.android.socialbase.downloader.downloader.a.s();
        monitor-enter(r10);
        this.f7967h = true;     // Catch: Throwable -> L8
        r10.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void z() {
        if (lb.a.a() == false) goto L6;
        lb.a.b("DefaultDownloadCache", "onDownloadCacheSyncSuccess", "Run");
    L6:
        if (this.f7965c.u() == false) goto L9;
        x();
        return;
    L9:
        monitor-enter(this);
        this.f7967h = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void A() {
        if (this.f7967h == true) goto L6;
        return;
    L6:
        if (this.f7968i == true) goto L8;
        this.f7968i = true;
        if (com.ss.android.socialbase.downloader.utils.c.F() == true) goto L14;
        return;
    L14:
        jb.k r10 = com.ss.android.socialbase.downloader.downloader.a.w();
        List<DownloadInfo> r11 = this.f7965c.q();
        if (r10 == null) goto L22;
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.isEmpty() == true) goto L24;
        r10.a(r11, 1);
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (lb.a.a() == false) goto L21;
        lb.a.b("DefaultDownloadCache", "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    @Override // jb.i
    public boolean A0() {
        if (this.f7967h == false) goto L7;
        return true;
    L7:
        if (this.f7965c.u() == false) goto L10;
        w();
        return this.f7967h;
    L10:
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.f7967h == false) goto L14;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L29
        return this.f7967h;
    L14:
        if (lb.a.a() == false) goto L17;
        lb.a.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.f7969j);     // Catch: Throwable -> L29
    L17:
        if (this.f7970k <= 0) goto L23;
        u r10 = this.f7966g;     // Catch: Throwable -> L29
        if (r10 == null) goto L23;
        if ((r10 instanceof hb.e) == false) goto L23;
        ((hb.e) r10).u3();     // Catch: Throwable -> L29
    L23:
        F(this);     // Catch: Throwable -> L29
        if (lb.a.a() == false) goto L26;
        lb.a.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L29
        goto L26
    }

    public void B() {
        Message r10 = this.f7974o.obtainMessage(1);
        this.f7974o.sendMessageDelayed(r10, 4000);
    }

    @Override // jb.i
    public DownloadInfo B0(int r10) {
        DownloadInfo r11 = this.f7965c.B0(r10);
        C(r11);
        return r11;
    }

    @Override // jb.i
    public DownloadInfo E(int r10) {
        DownloadInfo r11 = this.f7965c.E(r10);
        C(r11);
        return r11;
    }

    @Override // jb.i
    public DownloadInfo I0(int r10) {
        DownloadInfo r11 = this.f7965c.I0(r10);
        C(r11);
        return r11;
    }

    @Override // jb.i
    public boolean U0(int r10, Map<Long, com.ss.android.socialbase.downloader.segment.i> r11) {
        this.f7965c.U0(r10, r11);
        this.f7966g.U0(r10, r11);
        return false;
    }

    @Override // jb.i
    public DownloadInfo V(int r10, long r11) {
        DownloadInfo r12 = this.f7965c.V(r10, r11);
        i(r10);
        return r12;
    }

    @Override // jb.i
    @Nullable
    public DownloadInfo a(int r10) {
        return this.f7965c.a(r10);
    }

    @Override // jb.i
    public boolean b(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        boolean r11 = this.f7965c.b(r10);
        C(r10);
        return r11;
    }

    @Override // jb.i
    public void c() {
        this.f7965c.c();     // Catch: SQLiteException -> L4
    L7:
        if (com.ss.android.socialbase.downloader.utils.c.Q() == false) goto L11;
        jb.m r10 = g.a(true);
        if (r10 == null) goto L11;
        r10.c();
        return;
    L11:
        this.f7966g.c();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // jb.i
    public boolean d() {
        return this.f7967h;
    }

    @Override // jb.i
    public DownloadInfo d0(int r10, long r11) {
        DownloadInfo r12 = this.f7965c.d0(r10, r11);
        i(r10);
        return r12;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> e(String r10) {
        return this.f7965c.e(r10);
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> f(String r10) {
        return this.f7965c.f(r10);
    }

    @Override // jb.i
    public void f2(int r10) {
        this.f7965c.f2(r10);
        this.f7966g.f2(r10);
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> g(String r10) {
        return this.f7965c.g(r10);
    }

    @Override // jb.i
    public boolean h(int r10) {
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        return this.f7965c.h(r10);
    L3:
        if (com.ss.android.socialbase.downloader.utils.c.Q() == false) goto L9;
        jb.m r11 = g.a(true);     // Catch: SQLiteException -> L11
        if (r11 == null) goto L7;
        r11.h(r10);     // Catch: SQLiteException -> L11
        goto L14
    L7:
        u r12 = this.f7966g;     // Catch: SQLiteException -> L11
    L8:
        r12.h(r10);     // Catch: SQLiteException -> L11
        goto L14
    L9:
        r12 = this.f7966g;     // Catch: SQLiteException -> L11
        goto L8
    }

    @Override // jb.i
    public void i(int r10) {
        b(this.f7965c.a(r10));     // Catch: Exception -> L11
        if (com.ss.android.socialbase.downloader.utils.c.Q() == false) goto L9;
        jb.m r11 = g.a(true);     // Catch: Exception -> L11
        if (r11 == null) goto L7;
        r11.i(r10);     // Catch: Exception -> L11
        return;
    L7:
        u r12 = this.f7966g;     // Catch: Exception -> L11
    L8:
        r12.i(r10);     // Catch: Exception -> L11
        return;
    L9:
        r12 = this.f7966g;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.i
    public boolean j(int r10) {
        if (com.ss.android.socialbase.downloader.utils.c.Q() == false) goto L7;
        jb.m r11 = g.a(true);
        if (r11 == null) goto L7;
        r11.j(r10);
    L9:
        return this.f7965c.j(r10);
    L7:
        this.f7966g.j(r10);
        goto L9
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> k() {
        return this.f7965c.k();
    }

    @Override // jb.i
    public List<com.ss.android.socialbase.downloader.segment.i> k1(int r10) {
        List<com.ss.android.socialbase.downloader.segment.i> r11 = this.f7965c.k1(r10);
        if (r11 == null) goto L7;
        if (r11.size() == 0) goto L7;
        return r11;
    L7:
        return this.f7966g.k1(r10);
    }

    @Override // jb.i
    public List<DownloadInfo> l(String r10) {
        return this.f7965c.l(r10);
    }

    @Override // jb.i
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> l2(int r10) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r11 = this.f7965c.l2(r10);
        if (r11 != null) goto L5;
    L6:
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r12 = this.f7966g.l2(r10);
        this.f7965c.U0(r10, r12);
        return r12;
    L5:
        if (r11.isEmpty() == true) goto L6;
        return r11;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> m(String r10, String r11) {
        return this.f7965c.m(r10, r11);
    }

    @Override // jb.i
    public DownloadInfo n0(int r10, long r11) {
        DownloadInfo r12 = this.f7965c.n0(r10, r11);
        D(r12, false);
        return r12;
    }

    public f q() {
        return this.f7965c;
    }

    public u r() {
        return this.f7966g;
    }

    public void s(boolean r10) {
        if (f7963p.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (lb.a.a() == false) goto L8;
        lb.a.b("DefaultDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "Run");
    L8:
        com.ss.android.socialbase.downloader.downloader.a.f0(DownloadCacheSyncStatus.SYNC_START);
        SparseArray<DownloadInfo> r11 = new SparseArray();
        this.f7965c.p(r11);
        this.f7966g.k2(r11, this.f7965c.t(), this.f7965c.q(), this.f7965c.s(), new d(this, r11));
        int r12 = rb.a.d().optInt("init_download_cache_timeout_ms");
        if (lb.a.a() == false) goto L11;
        lb.a.b("DefaultDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "InitTimeout:" + r12);
    L11:
        if (r12 > 0) goto L13;
        return;
    L13:
        com.ss.android.socialbase.downloader.downloader.a.L0(new e(this), r12, TimeUnit.MILLISECONDS);
    }

    @Override // jb.i
    public DownloadInfo t0(int r10, long r11, String r12, String r13) {
        DownloadInfo r14 = this.f7965c.t0(r10, r11, r12, r13);
        C(r14);
        return r14;
    }

    public void u() {
        if (lb.a.a() == false) goto L5;
        lb.a.b("DefaultDownloadCache", "initImmediately", "Run isRunInit:" + f7963p.get());
    L5:
        s(this.f7965c instanceof LruDownloadCache);
    }

    @Override // jb.i
    public void v(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f7965c.b(r10);
    }

    @Override // jb.i
    public DownloadInfo w0(int r10) {
        DownloadInfo r11 = this.f7965c.w0(r10);
        C(r11);
        return r11;
    }

    @Override // jb.i
    public DownloadInfo y(int r10, long r11) {
        DownloadInfo r12 = this.f7965c.y(r10, r11);
        i(r10);
        return r12;
    }
}
