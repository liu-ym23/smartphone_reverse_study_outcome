package com.ss.android.socialbase.downloader.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public class f implements ServiceConnection, s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15322b;
    private static int c;
    private static long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f15323a;
    private Handler e;
    private b f;
    private com.ss.android.socialbase.downloader.downloader.b.a.InterfaceC0826a g;
    private Runnable h;
    private Future<?> i;
    private CountDownLatch j;

    static {
    }

    public f() {
        this.e = new Handler(Looper.getMainLooper());
        this.f = null;
        this.h = new AnonymousClass1(this);
        this.j = new CountDownLatch(1);
        SqlDownloadCacheService.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.downloader.b.a.InterfaceC0826a a(f r0) {
        return r0.g;
    }

    static /* synthetic */ b b(f r0) {
        return r0.f;
    }

    static /* synthetic */ boolean b(boolean r0) {
        f15322b = r0;
        return r0;
    }

    static /* synthetic */ c c(f r0) {
        return r0.f15323a;
    }

    static /* synthetic */ CountDownLatch d(f r0) {
        return r0.j;
    }

    static /* synthetic */ boolean e() {
        return f15322b;
    }

    static /* synthetic */ boolean e(f r0) {
        return r0.f();
    }

    static /* synthetic */ Runnable f(f r0) {
        return r0.h;
    }

    private boolean f() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return false;
    L6:
        if (f15322b == false) goto L9;
        return false;
    L9:
        if (c > 5) goto L11;
        long r5 = System.currentTimeMillis();
        if ((r5 - d) < SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME) goto L17;
        c++;
        d = r5;
        this.e.postDelayed(new AnonymousClass3(this), 1000);
        return true;
    L17:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCacheAidlWra", "bindMainProcessDelayed", "Time too short since last bin");
    L19:
        return false;
    L11:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCacheAidlWra", "bindMainProcessDelayed", "Bind too many times");
    L13:
        return false;
    }

    static /* synthetic */ Handler g(f r0) {
        return r0.e;
    }

    static /* synthetic */ Future h(f r0) {
        return r0.i;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r1, long r2) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r7, long r8, String r10, String r11) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a(r7, r8, r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public ArrayList<i> a(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a() {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r1, String r2) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(double r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public void a(final SparseArray<DownloadInfo> r9, final HashMap<Integer, Integer> r10, List<DownloadInfo> r11, List<String> r12, d r13) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        final d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.b.i().submit(new AnonymousClass4(this, r9, r10, r6, r7));
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        c r0 = this.f15323a;     // Catch: Throwable -> L13
        if (r0 != null) goto L16;
        this.f = r4;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L16:
        r0.a(r4);     // Catch: RemoteException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void a(com.ss.android.socialbase.downloader.downloader.b.a.InterfaceC0826a r3) {
        this.g = (com.ss.android.socialbase.downloader.downloader.b.a.InterfaceC0826a) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.downloader.b.a.InterfaceC0826a.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.a(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(int r1, Map<Long, i> r2) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(DownloadInfo r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.a(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.b(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r1, long r2) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.b(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> b(String r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.b(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b() {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.b();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(DownloadInfo r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.b(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo c(int r1, long r2) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.c(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> c(String r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.c(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c() {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.c();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.c(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo d(int r1, long r2) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.d(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> d(String r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.d(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d() {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.d();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.d(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo e(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.e(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo f(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.f(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo g(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.g(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void g() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo h(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.h(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void i(int r1) {
        c r0 = this.f15323a;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.i(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public Map<Long, i> k(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void l(int r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public /* synthetic */ List m(int r1) {
        return a(r1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        final IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        f15322b = true;
        this.e.removeCallbacks(this.h);
        this.f15323a = c.a.a(r4);     // Catch: Throwable -> L5
    L7:
        this.i = com.ss.android.socialbase.downloader.downloader.b.i().submit(new AnonymousClass2(this, r4));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.f15323a = null;
        f15322b = false;
    }
}
