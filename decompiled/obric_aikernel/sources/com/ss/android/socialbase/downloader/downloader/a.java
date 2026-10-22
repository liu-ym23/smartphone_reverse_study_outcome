package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.g;
import ib.e0;
import ib.f0;
import ib.g0;
import ib.h0;
import ib.j;
import ib.k0;
import ib.m;
import ib.n;
import ib.n0;
import ib.z;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import jb.i;
import jb.k;
import jb.l;
import jb.o;
import jb.r;
import jb.t;
import jb.u;
import nb.f;
import nb.h;
import okhttp3.Protocol;
import okhttp3.p;
import okhttp3.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile mb.b A;
    private static volatile e0 B;
    private static volatile List<n0> C;
    private static volatile boolean D;
    private static volatile w E;
    private static volatile f F;
    private static volatile f G;
    private static volatile com.ss.android.socialbase.downloader.downloader.b H;
    private static volatile z I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static volatile l f7892J;
    private static volatile n K;
    private static volatile f0 L;
    private static final List<m> M = null;
    private static volatile h0 N;
    private static boolean O;
    private static volatile boolean P;
    private static final int Q = 0;
    private static final int R = 0;
    private static final int S = 0;
    private static final int T = 0;
    private static int U;
    private static boolean V;
    private static final List<j> W = null;
    private static final List<g0> X = null;
    private static boolean Y;
    private static t Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f7893a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static mb.c f7894a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile i f7895b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static volatile boolean f7896b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile k0 f7897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.impls.a f7898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile o f7899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile o f7900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile e f7901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile nb.i f7902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile nb.i f7903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile k f7904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile ExecutorService f7905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile ExecutorService f7906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile ExecutorService f7907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile ExecutorService f7908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile ExecutorService f7909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile ExecutorService f7910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile ExecutorService f7911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile ExecutorService f7912r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile ExecutorService f7913s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile ExecutorService f7914t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile ScheduledExecutorService f7915u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static volatile ExecutorService f7916v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static volatile ExecutorService f7917w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static volatile ExecutorService f7918x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static volatile jb.d f7919y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile r f7920z;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.a$a, reason: collision with other inner class name */
    static class RunnableC0142a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7921c;

        RunnableC0142a(boolean r10) {
            this.f7921c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f7921c);
            a.b();
            a.U().c();
            Context r10 = a.h();
            if (r10 == null) goto L5;
            g.q(r10);
        L5:
            com.ss.android.socialbase.downloader.utils.a.d();
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(true);
        }
    }

    static class c implements f {
        c() {
        }

        @Override // nb.f
        public List<InetAddress> a(String r10) {
            return p.f12019a.a(r10);
        }
    }

    static class d implements mb.c {
        d() {
        }

        @Override // mb.c
        public void a(int r10, String r11, JSONObject r12) {
        }
    }

    public interface e {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.a$e$a, reason: collision with other inner class name */
        public interface InterfaceC0143a {
            void a();
        }

        jb.m a();

        u b(InterfaceC0143a r10);

        o c();
    }

    static {
        C = new CopyOnWriteArrayList();
        D = false;
        E = null;
        M = new ArrayList();
        O = false;
        P = false;
        int r10 = Runtime.getRuntime().availableProcessors() + 1;
        Q = r10;
        R = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        S = r10;
        T = r10;
        U = ab.b.f132e;
        W = new ArrayList();
        X = new ArrayList();
        Y = true;
        f7896b0 = false;
        qb.p r11 = (qb.p) qb.k.a(qb.p.class);
        if (r11 == null) goto L6;
        r11.a();
        return;
    }

    private a() {
    }

    @NonNull
    public static JSONObject A() {
        if (B == null) goto L5;
        JSONObject r10 = B.get();
    L6:
        if (r10 == null) goto L8;
        return r10;
    L8:
        return ab.b.f134g;
    L5:
        r10 = null;
        goto L6
    }

    public static void A0(e r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.b("DownloadComponentManager", "setIndependentServiceCreator", "Creator: " + r10);
    L5:
        f7901g = r10;
    }

    public static f0 B() {
        return L;
    }

    private static void B0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7910p = r10;
        return;
    }

    public static h0 C() {
        return N;
    }

    private static void C0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7907m = r10;
        return;
    }

    @NonNull
    public static mb.c D() {
        if (f7894a0 != null) goto L6;
        f7894a0 = new d();
    L6:
        return f7894a0;
    }

    private static void D0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7909o = r10;
        return;
    }

    public static ExecutorService E() {
        if (f7918x != null) goto L22;
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (f7918x != null) goto L16;
        int r10 = rb.a.d().optInt("fast_download_thread_pool_size_limit");     // Catch: Throwable -> L18
        if (r10 > 0) goto L11;
        r10 = 20;
    L11:
        int r11 = r10;
        if (Z() == false) goto L14;
        long r12 = 15;
    L15:
        f7918x = new ThreadPoolExecutor(0, r11, r12, TimeUnit.SECONDS, new SynchronousQueue(), new sb.a("DownloadThreadPool-Fast", true));     // Catch: Throwable -> L18
        goto L16
    L14:
        r12 = 60;
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L18
    L22:
        return f7918x;
    }

    public static void E0(k0 r10) {
        if (r10 == null) goto L5;
        f7897c = r10;
        return;
    }

    public static ExecutorService F() {
        if (f7908n != null) goto L25;
        monitor-enter(a.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f7908n != null) goto L19;
        int r10 = S;     // Catch: Throwable -> L21
        int r11 = r10 * 2;     // Catch: Throwable -> L21
        long r12 = 15;
        if (c0() == false) goto L11;
        r12 = 8;
        int r13 = r10;
    L12:
        int r14 = r10 * 2;     // Catch: Throwable -> L21
        ThreadPoolExecutor r15 = new ThreadPoolExecutor(r13, r14, r12, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-global-throttle", true));     // Catch: Throwable -> L21
        if (c0() == true) goto L28;
    L18:
        f7908n = r15;     // Catch: Throwable -> L21
        goto L19
    L28:
        r15.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r13 = r11;
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
    L25:
        return f7908n;
    }

    public static void F0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7914t = r10;
        return;
    }

    public static nb.i G() {
        return f7902h;
    }

    public static void G0(Runnable r10) {
        H0(r10, false);
    }

    public static ExecutorService H() {
        if (f7906l == null) goto L6;
        return f7906l;
    L6:
        return i();
    }

    public static void H0(Runnable r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 == true) goto L6;
    L8:
        i().execute(r10);
        return;
    L6:
        if (g.O() == true) goto L8;
        r10.run();
    }

    public static o I() {
        if (f7900f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7900f != null) goto L9;
        f7900f = f7901g.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7900f;
    }

    public static void I0(Runnable r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (g.O() == true) goto L7;
        r10.run();
        return;
    L7:
        l().execute(r10);
    }

    public static e J() {
        return f7901g;
    }

    public static void J0(Runnable r10) {
        K0(r10, false);
    }

    public static ExecutorService K() {
        if (f7910p == null) goto L6;
        return f7910p;
    L6:
        return L();
    }

    public static void K0(Runnable r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 == true) goto L6;
    L8:
        H().execute(r10);
        return;
    L6:
        if (g.O() == true) goto L8;
        r10.run();
    }

    public static ExecutorService L() {
        if (f7907m != null) goto L24;
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f7907m != null) goto L18;
        int r10 = S;     // Catch: Throwable -> L20
        if (Z() == false) goto L11;
        long r11 = 8;
        int r12 = r10 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(r12, r10, r11, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-mix-fixed", true));     // Catch: Throwable -> L20
        r13.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        f7907m = r13;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r11 = 15;
        r12 = r10;
    L18:
        monitor-exit(a.class);     // Catch: Throwable -> L20
    L24:
        return f7907m;
    }

    public static Future L0(Runnable r10, long r11, TimeUnit r12) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return R().schedule(r10, r11, r12);
    }

    public static ExecutorService M() {
        if (f7909o == null) goto L6;
        return f7909o;
    L6:
        return L();
    }

    public static void M0(Runnable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        T().execute(r10);
    }

    public static synchronized r N() {
        monitor-enter(a.class);
        r r10 = f7920z;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean N0() {
        if (f7901g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static k0 O() {
        return f7897c;
    }

    public static void O0(com.ss.android.socialbase.downloader.model.d r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.y().isFastDownload() == true) goto L16;
        com.ss.android.socialbase.downloader.model.e r12 = r10.L();
        if (r11 == false) goto L9;
        Map<String, com.ss.android.socialbase.downloader.model.e.a> r13 = r12.f8175a;
    L11:
        if (r13.isEmpty() == true) goto L13;
        return;
    L13:
        r13.put("cpu", com.ss.android.socialbase.downloader.model.e.c(f7905k));
        r13.put("io", com.ss.android.socialbase.downloader.model.e.c(f7906l));
        r13.put("mixDefault", com.ss.android.socialbase.downloader.model.e.c(f7907m));
        r13.put("mixApk", com.ss.android.socialbase.downloader.model.e.c(f7910p));
        r13.put("db", com.ss.android.socialbase.downloader.model.e.c(f7911q));
        r13.put("chunk", com.ss.android.socialbase.downloader.model.e.c(f7912r));
        r13.put("segment", com.ss.android.socialbase.downloader.model.e.c(f7913s));
        r13.put("okHttp", com.ss.android.socialbase.downloader.model.e.c(f7914t));
        r13.put("schedule", com.ss.android.socialbase.downloader.model.e.c(f7915u));
        r13.put("single", com.ss.android.socialbase.downloader.model.e.c(f7916v));
        r13.put("custom", com.ss.android.socialbase.downloader.model.e.c(f7917w));
        return;
    L9:
        r13 = r12.f8176b;
        goto L11
    }

    public static List<n0> P() {
        return C;
    }

    public static t Q() {
        return Z;
    }

    public static ScheduledExecutorService R() {
        if (f7915u != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7915u != null) goto L9;
        f7915u = new ScheduledThreadPoolExecutor(4, new sb.a("DownloadThreadPool-Schedule", true));     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7915u;
    }

    public static ExecutorService S() {
        if (f7913s != null) goto L20;
        monitor-enter(a.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (f7913s != null) goto L14;
        ThreadPoolExecutor r10 = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-segment-fixed", true));     // Catch: Throwable -> L16
        r10.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        f7913s = r10;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(a.class);     // Catch: Throwable -> L16
    L20:
        return f7913s;
    }

    public static ExecutorService T() {
        if (f7916v != null) goto L25;
        monitor-enter(a.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f7916v == null) goto L9;
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
        goto L25
    L9:
        if (Z() == false) goto L11;
        long r10 = 30;
    L12:
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(1, 1, r10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-Single", true));     // Catch: Throwable -> L21
        if (Z() == true) goto L26;
    L18:
        f7916v = r11;     // Catch: Throwable -> L21
        goto L19
    L26:
        r11.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r10 = 60;
    L25:
        return f7916v;
    }

    public static com.ss.android.socialbase.downloader.downloader.b U() {
        if (H != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (H != null) goto L9;
        H = new com.ss.android.socialbase.downloader.downloader.b.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return H;
    }

    public static int V() {
        return U;
    }

    public static synchronized void W(jb.g r10) {
        monitor-enter(a.class);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (f7896b0 == false) goto L9;
        lb.a.c("DownloadComponentManager", "initComponent", "Component has init");     // Catch: Throwable -> L38
        monitor-exit(a.class);
        return;
    L9:
        boolean r11 = D;     // Catch: Throwable -> L38
        q0(r10);     // Catch: Throwable -> L38
        int r12 = A().optInt("downloader_alog_level");     // Catch: Throwable -> L38
        if (lb.a.a() == false) goto L12;
        lb.a.b("DownloadComponentManager", "initComponent", "ALogLevel:" + r12);     // Catch: Throwable -> L38
    L12:
        if (r12 <= 0) goto L15;
        lb.a.e(r12);     // Catch: Throwable -> L38
    L15:
        if (f7895b != null) goto L18;
        f7895b = new com.ss.android.socialbase.downloader.impls.b();     // Catch: Throwable -> L38
    L18:
        if (f7899e != null) goto L21;
        f7899e = new com.ss.android.socialbase.downloader.impls.e();     // Catch: Throwable -> L38
    L21:
        if (f7900f != null) goto L26;
        if (f7901g == null) goto L26;
        f7900f = f7901g.c();     // Catch: Throwable -> L38
    L26:
        if (f7898d != null) goto L29;
        f7898d = new com.ss.android.socialbase.downloader.impls.c();     // Catch: Throwable -> L38
    L29:
        if (D == false) goto L34;
        if (r11 == true) goto L34;
        if (com.ss.android.socialbase.downloader.utils.c.A() == true) goto L34;
        boolean r13 = true;
    L35:
        i0(r13);     // Catch: Throwable -> L38
        g();     // Catch: Throwable -> L38
        f7896b0 = true;     // Catch: Throwable -> L38
        monitor-exit(a.class);
        return;
    L34:
        r13 = false;
        goto L35
    }

    public static synchronized boolean X() {
        monitor-enter(a.class);
        boolean r10 = D;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean Y() {
        return P;
    }

    static boolean Z() {
        if (rb.a.d().optInt("global_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    static /* synthetic */ void a(boolean r10) {
        k0(r10);
    }

    public static synchronized boolean a0() {
        monitor-enter(a.class);
        boolean r10 = V;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void b() {
        j0();
    }

    public static boolean b0() {
        return f7896b0;
    }

    public static void c(n0 r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        C.add(r10);
    }

    static boolean c0() {
        if (rb.a.d().optInt("throttle_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static synchronized void d(jb.g r10) {
        monitor-enter(a.class);
        q0(r10);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void d0(boolean r10) {
        Y = r10;
    }

    public static w.a e() {
        w.a r10 = new w.a();
        int r11 = rb.a.d().optInt("connect_timeout", 30000);
        int r12 = rb.a.d().optInt("io_timeout", 30000);
        long r13 = r11;
        TimeUnit r14 = TimeUnit.MILLISECONDS;
        long r15 = r12;
        r10.d(r13, r14).U(r15, r14).Z(r15, r14).V(true).l(true).S(Collections.singletonList(Protocol.HTTP_1_1));
        if (f7914t == null) goto L5;
        r10.h(new okhttp3.o(f7914t));
    L5:
        return r10;
    }

    public static boolean e0() {
        return Y;
    }

    public static h f(boolean r10, int r11, String r12, String r13, List<HttpHeader> r14, int r15, boolean r16, DownloadInfo r17) {
        return ((qb.r) qb.k.a(qb.r.class)).a(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static void f0(DownloadCacheSyncStatus r10) {
        List<j> r11 = W;
        monitor-enter(r11);
        Iterator<j> r12 = r11.iterator();     // Catch: Throwable -> L20
    L6:
        if (r12.hasNext() == false) goto L16;
        j r13 = r12.next();     // Catch: Throwable -> L20
        if (r13 == null) goto L6;
        if (r10 == DownloadCacheSyncStatus.SYNC_START) goto L11;
        if (r10 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L6;
        r13.a();     // Catch: Throwable -> L20
        goto L6
    L11:
        r13.onStart();     // Catch: Throwable -> L20
        goto L6
    L16:
        if (r10 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L18;
        W.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void g() {
        if (TextUtils.isEmpty(ab.b.f130c) == false) goto L6;
        ab.b.f130c = "oppo";
        ab.b.f129b = ab.b.f130c.toUpperCase();
        return;
    }

    public static void g0(com.ss.android.socialbase.downloader.model.d r10, int r11) {
        List<g0> r12 = X;
        monitor-enter(r12);
        Iterator<g0> r13 = r12.iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L10;
        g0 r14 = r13.next();     // Catch: Throwable -> L12
        if (r14 == null) goto L6;
        r14.a(r10, r11);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized Context h() {
        monitor-enter(a.class);
        Context r10 = f7893a;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void h0(com.ss.android.socialbase.downloader.model.d r10, int r11) {
        List<g0> r12 = X;
        monitor-enter(r12);
        Iterator<g0> r13 = r12.iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L10;
        g0 r14 = r13.next();     // Catch: Throwable -> L12
        if (r14 == null) goto L6;
        r14.b(r10, r11);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static ExecutorService i() {
        if (f7905k != null) goto L24;
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f7905k != null) goto L18;
        int r10 = Q;     // Catch: Throwable -> L20
        if (Z() == false) goto L11;
        long r11 = 8;
        int r12 = r10 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(r12, r10, r11, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-cpu-fixed", true));     // Catch: Throwable -> L20
        r13.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        f7905k = r13;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r11 = 15;
        r12 = r10;
    L18:
        monitor-exit(a.class);     // Catch: Throwable -> L20
    L24:
        return f7905k;
    }

    private static void i0(boolean r10) {
        J0(new RunnableC0142a(r10));
    }

    public static ExecutorService j() {
        if (f7912r != null) goto L24;
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f7912r != null) goto L18;
        int r10 = R;     // Catch: Throwable -> L20
        if (Z() == false) goto L11;
        long r11 = 8;
        int r12 = r10 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(r12, r10, r11, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-chunk-fixed", true));     // Catch: Throwable -> L20
        r13.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        f7912r = r13;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r11 = 15;
        r12 = r10;
    L18:
        monitor-exit(a.class);     // Catch: Throwable -> L20
    L24:
        return f7912r;
    }

    private static synchronized void j0() {
        monitor-enter(a.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f7919y != null) goto L8;
        f7919y = new jb.d();     // Catch: Throwable -> L17
    L8:
        if (O == false) goto L20;
        monitor-exit(a.class);
        return;
    L20:
        IntentFilter r10 = new IntentFilter();     // Catch: Throwable -> L13
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L13
        r10.addAction("android.intent.action.MEDIA_MOUNTED");     // Catch: Throwable -> L13
        r10.addAction("android.intent.action.MEDIA_UNMOUNTED");     // Catch: Throwable -> L13
        r10.addAction("android.intent.action.MEDIA_REMOVED");     // Catch: Throwable -> L13
        r10.addAction("android.intent.action.MEDIA_BAD_REMOVAL");     // Catch: Throwable -> L13
        r10.addAction("android.intent.action.MEDIA_EJECT");     // Catch: Throwable -> L13
        f7893a.registerReceiver(f7919y, r10);     // Catch: Throwable -> L13
        O = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(a.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }

    public static ExecutorService k() {
        return f7917w;
    }

    private static void k0(boolean r10) {
        if (r10 == false) goto L5;
        com.ss.android.socialbase.downloader.impls.g.a(true).B();
        return;
    }

    public static ExecutorService l() {
        if (f7911q != null) goto L24;
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f7911q != null) goto L18;
        int r10 = T;     // Catch: Throwable -> L20
        if (Z() == false) goto L11;
        long r11 = 8;
        int r12 = r10 / 2;     // Catch: Throwable -> L20
    L12:
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(r12, r10, r11, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-db-fixed", true));     // Catch: Throwable -> L20
        r13.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        f7911q = r13;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r11 = 15;
        r12 = r10;
    L18:
        monitor-exit(a.class);     // Catch: Throwable -> L20
    L24:
        return f7911q;
    }

    public static synchronized void l0(Context r10) {
        monitor-enter(a.class);
        if (r10 != null) goto L16;
    L14:
        monitor-exit(a.class);
        return;
    L16:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f7893a != null) goto L14;
        f7893a = r10.getApplicationContext();     // Catch: Throwable -> L11
        za.a.k().m(f7893a);     // Catch: Throwable -> L11
        if (lb.a.a() == false) goto L14;
        lb.a.b("DownloadComponentManager", "setAppContext", "Context:" + r10);     // Catch: Throwable -> L11
        goto L14
    }

    public static f m() {
        if (G != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (G != null) goto L9;
        G = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return G;
    }

    private static void m0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7905k = r10;
        return;
    }

    public static nb.i n() {
        if (f7903i != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7903i != null) goto L9;
        f7903i = new com.ss.android.socialbase.downloader.impls.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7903i;
    }

    public static void n0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7912r = r10;
        return;
    }

    public static i o() {
        if (f7895b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7895b != null) goto L9;
        f7895b = new com.ss.android.socialbase.downloader.impls.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7895b;
    }

    public static void o0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7917w = r10;
        return;
    }

    public static w p() {
        if (E != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (E != null) goto L9;
        E = e().c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return E;
    }

    private static void p0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7911q = r10;
        return;
    }

    public static n q() {
        return K;
    }

    private static void q0(jb.g r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.d() == null) goto L7;
        l0(r10.d());
    L7:
        if (r10.o() == null) goto L10;
        z0(r10.o());
    L10:
        if (r10.t() == null) goto L13;
        E0(r10.t());
    L13:
        if (r10.m() == null) goto L16;
        x0(r10.m());
    L16:
        if (r10.j() == null) goto L19;
        u0(r10.j());
    L19:
        if (r10.b() == null) goto L22;
        m0(r10.b());
    L22:
        if (r10.n() == null) goto L25;
        y0(r10.n());
    L25:
        if (r10.q() == null) goto L28;
        C0(r10.q());
    L28:
        if (r10.r() == null) goto L31;
        D0(r10.r());
    L31:
        if (r10.p() == null) goto L34;
        B0(r10.p());
    L34:
        if (r10.f() == null) goto L37;
        p0(r10.f());
    L37:
        if (r10.c() == null) goto L40;
        n0(r10.c());
    L40:
        if (r10.u() == null) goto L43;
        F0(r10.u());
    L43:
        if (r10.e() == null) goto L46;
        o0(r10.e());
    L46:
        if (r10.g().isEmpty() == true) goto L49;
        r0(r10.g());
    L49:
        if (r10.s() == null) goto L52;
        f7920z = r10.s();
    L52:
        if (r10.w() <= 1024) goto L55;
        U = r10.w();
    L55:
        if (r10.x() == false) goto L58;
        D = true;
    L58:
        if (r10.v() == null) goto L65;
        H = r10.v();
        if (H.a() == false) goto L62;
        nb.i r11 = H.d();
    L63:
        x0(r11);
        goto L65
    L62:
        r11 = n();
    L65:
        if (r10.l() == null) goto L68;
        w0(r10.l());
    L68:
        if (r10.h() == null) goto L71;
        F = r10.h();
    L71:
        if (r10.i() == null) goto L73;
        t0(r10.i());
    L73:
        d0(r10.y());
        if (r10.k() == null) goto L78;
        v0(r10.k());
        return;
    }

    public static f r() {
        return F;
    }

    private static void r0(List<m> r10) {
        List<m> r11 = M;
        if (r11.isEmpty() == false) goto L11;
        monitor-enter(r11);
        r11.addAll(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static com.ss.android.socialbase.downloader.impls.a s() {
        if (f7898d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7898d != null) goto L9;
        f7898d = new com.ss.android.socialbase.downloader.impls.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7898d;
    }

    public static synchronized void s0() {
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (D == false) goto L7;
    L18:
        monitor-exit(a.class);
        return;
    L7:
        if (N0() == false) goto L18;
        Intent r10 = new Intent(h(), DownloadHandleService.class);     // Catch: Throwable -> L14
        r10.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");     // Catch: Throwable -> L14
        h().startService(r10);     // Catch: Throwable -> L14
        if (com.ss.android.socialbase.downloader.utils.c.A() == true) goto L12;
        J0(new b());     // Catch: Throwable -> L14
    L12:
        D = true;     // Catch: Throwable -> L14
    L16:
        monitor-exit(a.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L16
    }

    public static int t(DownloadInfo r10) {
        return ((qb.n) qb.k.a(qb.n.class)).c(r10);
    }

    public static void t0(z r10) {
        if (r10 == null) goto L5;
        I = r10;
        return;
    }

    public static int u(String r10, String r11) {
        return ((qb.n) qb.k.a(qb.n.class)).b(r10, r11);
    }

    public static synchronized void u0(k r10) {
        monitor-enter(a.class);
        if (r10 != null) goto L14;
    L12:
        monitor-exit(a.class);
        return;
    L14:
        f7904j = r10;     // Catch: Throwable -> L9
        if ((f7895b instanceof com.ss.android.socialbase.downloader.impls.b) == false) goto L12;
        ((com.ss.android.socialbase.downloader.impls.b) f7895b).B();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static z v() {
        return I;
    }

    public static void v0(mb.b r10) {
        if (r10 == null) goto L5;
        A = r10;
        return;
    }

    public static synchronized k w() {
        monitor-enter(a.class);
        k r10 = f7904j;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void w0(e0 r10) {
        B = r10;
        rb.a.e();
        if (lb.a.a() == true) goto L5;
        return;
    L5:
        if (B == null) goto L9;
        lb.a.b("DownloadComponentManager", "setDownloadSetting", "Setting: " + B.get());
        return;
    }

    public static l x() {
        return f7892J;
    }

    public static void x0(nb.i r10) {
        if (r10 == null) goto L5;
        f7902h = r10;
    L5:
        if (f7902h == null) goto L7;
        boolean r11 = true;
    L8:
        V = r11;
        return;
    L7:
        r11 = false;
        goto L8
    }

    public static mb.b y() {
        return A;
    }

    private static void y0(ExecutorService r10) {
        if (r10 == null) goto L5;
        f7906l = r10;
        return;
    }

    public static o z() {
        if (f7899e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7899e != null) goto L9;
        f7899e = new com.ss.android.socialbase.downloader.impls.e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f7899e;
    }

    private static void z0(jb.j r10) {
        if (r10 == null) goto L5;
        ((qb.n) qb.k.a(qb.n.class)).a(r10);
        return;
    }
}
