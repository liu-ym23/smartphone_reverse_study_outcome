package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.h {
    private static AtomicBoolean e;
    private static AtomicBoolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f15477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s f15478b;
    private volatile boolean c;
    private volatile boolean d;
    private int g;
    private int h;
    private boolean i;
    private ThreadLocal<Boolean> j;
    private com.ss.android.socialbase.downloader.h.f.a k;
    private com.ss.android.socialbase.downloader.h.f l;

    static {
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
    }

    public b() {
        boolean r0 = false;
        this.i = false;
        this.j = new ThreadLocal();
        this.k = new AnonymousClass1(this);
        this.l = null;
        if (com.ss.android.socialbase.downloader.utils.c.a() == false) goto L5;
    L8:
        s r1 = new com.ss.android.socialbase.downloader.c.e();
    L9:
        this.f15478b = r1;
        this.c = false;
        this.l = new com.ss.android.socialbase.downloader.h.f(Looper.getMainLooper(), this.k);
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("lru_download_info_cache_enable", 0) <= 0) goto L12;
    L15:
        f r2 = new k(this.f15478b);
    L16:
        this.f15477a = r2;
        this.g = com.ss.android.socialbase.downloader.g.a.b().optInt("load_db_wait_time_ms", 5000);
        this.h = com.ss.android.socialbase.downloader.g.a.b().optInt("biz_close_db_batch_init", 0);
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("thread_load_download_cache_only_once") <= 0) goto L19;
        r0 = true;
    L19:
        this.i = r0;
        Runnable r3 = new AnonymousClass3(this);
        long r4 = com.ss.android.socialbase.downloader.g.a.c().c("delay_init_download_cache_ms");
        if (r4 <= 0) goto L22;
        com.ss.android.socialbase.downloader.downloader.b.a(r3, r4, TimeUnit.MILLISECONDS);
        return;
    L22:
        r3.run();
        return;
    L12:
        if (com.ss.android.socialbase.downloader.downloader.b.aa() == true) goto L15;
        r2 = new f(this.f15478b);
        goto L16
    L5:
        if (com.ss.android.socialbase.downloader.downloader.b.X() == false) goto L8;
        r1 = com.ss.android.socialbase.downloader.downloader.b.Y().a(new AnonymousClass2(this));
        goto L9
    }

    static /* synthetic */ s a(b r2, s r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        r2.f15478b = r4;
        return r4;
    }

    static /* synthetic */ f a(b r0) {
        return r0.f15477a;
    }

    private void a(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.utils.c.b() == false) goto L10;
        if (r3 == false) goto L12;
        com.ss.android.socialbase.downloader.downloader.l r4 = g.a(true);
        if (r4 == null) goto L10;
        r4.c(r2);
        return;
    L12:
        return;
    L10:
        this.f15478b.a(r2);
    }

    private void a(Object r6) {
        if (this.i == false) goto L9;
        if (this.j.get() == null) goto L7;
        return;
    L7:
        this.j.set(true);
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "waitDBLoad", "Run loadDBWaitTime:" + this.g);
    L16:
        r6.wait(this.g);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DefaultDownloadCache", "waitDBLoad", "Error:" + th);
    }

    static /* synthetic */ void b(b r0) {
        r0.k();
    }

    private void c(DownloadInfo r2) {
        a(r2, true);
    }

    private void k() {
        if (f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        l();
        h();
        com.ss.android.socialbase.downloader.downloader.b.a(DownloadCacheSyncStatus.SYNC_SUCCESS);
    }

    private void l() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "onDownloadCacheSyncSuccess", "Run");
    L6:
        if (this.f15477a.i() == false) goto L9;
        m();
        return;
    L9:
        monitor-enter(this);
        this.c = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void m() {
        a r0 = com.ss.android.socialbase.downloader.downloader.b.F();
        monitor-enter(r0);
        this.c = true;     // Catch: Throwable -> L8
        r0.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void n() {
        a r0 = com.ss.android.socialbase.downloader.downloader.b.F();
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.c == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L14
    L9:
        g();     // Catch: Throwable -> L14
        a(r0);     // Catch: Throwable -> L14
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L14
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r2, long r3) {
        DownloadInfo r4 = this.f15477a.a(r2, r3);
        a(r4, false);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r7, long r8, String r10, String r11) {
        DownloadInfo r9 = this.f15477a.a(r7, r8, r10, r11);
        c(r9);
        return r9;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a() {
        return this.f15477a.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r1) {
        return this.f15477a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r1, String r2) {
        return this.f15477a.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(double r1) {
        this.f15477a.a(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void a(boolean r9) {
        if (e.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "Run");
    L8:
        com.ss.android.socialbase.downloader.downloader.b.a(DownloadCacheSyncStatus.SYNC_START);
        final SparseArray<DownloadInfo> r3 = new SparseArray();
        this.f15477a.a(r3);
        this.f15478b.a(r3, this.f15477a.e(), this.f15477a.f(), this.f15477a.h(), new AnonymousClass4(this, r3));
        int r10 = com.ss.android.socialbase.downloader.g.a.b().optInt("init_download_cache_timeout_ms");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "InitTimeout:" + r10);
    L11:
        if (r10 > 0) goto L13;
        return;
    L13:
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass5(this), r10, TimeUnit.MILLISECONDS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(int r3, Map<Long, com.ss.android.socialbase.downloader.segment.i> r4) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f15477a.a(r3, r5);
        this.f15478b.a(r3, r5);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        boolean r0 = this.f15477a.a(r2);
        c(r2);
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r1) {
        return this.f15477a.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r2, long r3) {
        DownloadInfo r4 = this.f15477a.b(r2, r3);
        i(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> b(String r1) {
        return this.f15477a.b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b() {
        this.f15477a.b();     // Catch: SQLiteException -> L4
    L7:
        if (com.ss.android.socialbase.downloader.utils.c.b() == false) goto L11;
        com.ss.android.socialbase.downloader.downloader.l r0 = g.a(true);
        if (r0 == null) goto L11;
        r0.e();
        return;
    L11:
        this.f15478b.b();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(DownloadInfo r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f15477a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo c(int r2, long r3) {
        DownloadInfo r4 = this.f15477a.c(r2, r3);
        i(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> c(String r1) {
        return this.f15477a.c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c(int r2) {
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        return this.f15477a.c(r2);
    L3:
        if (com.ss.android.socialbase.downloader.utils.c.b() == false) goto L9;
        com.ss.android.socialbase.downloader.downloader.l r0 = g.a(true);     // Catch: SQLiteException -> L11
        if (r0 == null) goto L7;
        r0.j(r2);     // Catch: SQLiteException -> L11
        goto L14
    L7:
        s r1 = this.f15478b;     // Catch: SQLiteException -> L11
    L8:
        r1.c(r2);     // Catch: SQLiteException -> L11
        goto L14
    L9:
        r1 = this.f15478b;     // Catch: SQLiteException -> L11
        goto L8
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo d(int r2, long r3) {
        DownloadInfo r4 = this.f15477a.d(r2, r3);
        i(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> d(String r1) {
        return this.f15477a.d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d() {
        if (this.c == false) goto L7;
        return true;
    L7:
        if (this.f15477a.i() == false) goto L10;
        n();
        return this.c;
    L10:
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.c == false) goto L14;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L29
        return this.c;
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L17;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.g);     // Catch: Throwable -> L29
    L17:
        if (this.h <= 0) goto L23;
        s r0 = this.f15478b;     // Catch: Throwable -> L29
        if (r0 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r0, com.ss.android.socialbase.downloader.c.e.class) == false) goto L23;
        ((com.ss.android.socialbase.downloader.c.e) ZeusTransformUtils.preCheckCast(this.f15478b, com.ss.android.socialbase.downloader.c.e.class, "com.obric.memorydata.plugin")).f();     // Catch: Throwable -> L29
    L23:
        a(this);     // Catch: Throwable -> L29
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L26;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L29
        goto L26
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d(int r2) {
        if (com.ss.android.socialbase.downloader.utils.c.b() == false) goto L7;
        com.ss.android.socialbase.downloader.downloader.l r0 = g.a(true);
        if (r0 == null) goto L7;
        r0.k(r2);
    L9:
        return this.f15477a.d(r2);
    L7:
        this.f15478b.d(r2);
        goto L9
    }

    public f e() {
        return this.f15477a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo e(int r2) {
        DownloadInfo r3 = this.f15477a.e(r2);
        c(r3);
        return r3;
    }

    public s f() {
        return this.f15478b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo f(int r2) {
        DownloadInfo r3 = this.f15477a.f(r2);
        c(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo g(int r2) {
        DownloadInfo r3 = this.f15477a.g(r2);
        c(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void g() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "initImmediately", "Run isRunInit:" + e.get());
    L5:
        a(ZeusTransformUtils.instanceOf(this.f15477a, k.class));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo h(int r2) {
        DownloadInfo r3 = this.f15477a.h(r2);
        c(r3);
        return r3;
    }

    public void h() {
        Message r0 = this.l.obtainMessage(1);
        this.l.sendMessageDelayed(r0, WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS);
    }

    public void i() {
        if (this.c == true) goto L6;
        return;
    L6:
        if (this.d == true) goto L8;
        this.d = true;
        if (com.ss.android.socialbase.downloader.utils.c.a() == true) goto L14;
        return;
    L14:
        com.ss.android.socialbase.downloader.downloader.j r1 = com.ss.android.socialbase.downloader.downloader.b.B();
        List<DownloadInfo> r3 = this.f15477a.f();
        if (r1 == null) goto L22;
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.isEmpty() == true) goto L24;
        r1.a(r3, 1);
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L21;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadCache", "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void i(int r2) {
        a(this.f15477a.b(r2));     // Catch: Exception -> L11
        if (com.ss.android.socialbase.downloader.utils.c.b() == false) goto L9;
        com.ss.android.socialbase.downloader.downloader.l r0 = g.a(true);     // Catch: Exception -> L11
        if (r0 == null) goto L7;
        r0.l(r2);     // Catch: Exception -> L11
        return;
    L7:
        s r1 = this.f15478b;     // Catch: Exception -> L11
    L8:
        r1.i(r2);     // Catch: Exception -> L11
        return;
    L9:
        r1 = this.f15478b;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public void j() {
        if (this.c == true) goto L5;
        return;
    L5:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        com.ss.android.socialbase.downloader.downloader.b.b(new AnonymousClass6(this, r0));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> k(int r3) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r0 = this.f15477a.k(r3);
        if (r0 != null) goto L5;
    L6:
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r1 = this.f15478b.k(r3);
        this.f15477a.a(r3, r1);
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L6;
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void l(int r2) {
        this.f15477a.l(r2);
        this.f15478b.l(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<com.ss.android.socialbase.downloader.segment.i> m(int r3) {
        List<com.ss.android.socialbase.downloader.segment.i> r0 = this.f15477a.m(r3);
        if (r0 == null) goto L7;
        if (r0.size() == 0) goto L7;
        return r0;
    L7:
        return this.f15478b.m(r3);
    }
}
