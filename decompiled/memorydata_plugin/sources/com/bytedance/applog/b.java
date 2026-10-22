package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.params.CommonParamsWrapper;
import com.bytedance.applog.priority.PriorityCallbackImpl;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f1518a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<b> f1519b = null;
    private static final AtomicInteger c = null;
    private volatile e A;
    private volatile boolean B;
    private volatile boolean C;
    private volatile boolean D;
    private volatile boolean E;
    private final AtomicInteger F;
    private volatile boolean G;
    private volatile boolean H;
    private volatile boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private volatile boolean f1520J;
    private volatile boolean K;
    private volatile boolean L;
    private volatile int M;
    private volatile int N;
    private volatile boolean O;
    private volatile boolean P;
    private volatile HashSet<String> Q;
    private volatile int R;
    private volatile int S;
    private volatile boolean T;
    private volatile boolean U;
    private volatile boolean V;
    private volatile boolean W;
    private volatile boolean X;
    private volatile int Y;
    private volatile com.bytedance.applog.o.b Z;
    private final com.bytedance.applog.log.j aA;
    private final AtomicBoolean aB;
    private final List<String> aC;
    private final com.bytedance.applog.collector.d aD;
    private final com.bytedance.applog.b.a aE;
    private final com.bytedance.applog.l.e aF;
    private final com.bytedance.applog.monitor.a aa;
    private final com.bytedance.applog.monitor.v3.e ab;
    private volatile Long ac;
    private volatile Integer ad;
    private volatile k ae;
    private volatile IBDAccountCallback af;
    private final com.bytedance.applog.j.b ag;
    private volatile boolean ah;
    private volatile DataIsolateKey ai;
    private volatile com.bytedance.applog.isolate.b aj;
    private volatile JSONObject ak;
    private volatile com.bytedance.applog.i.a al;
    private PriorityWrapper am;
    private volatile boolean an;
    private volatile boolean ao;
    private volatile ConcurrentHashMap<String, String> ap;
    private volatile boolean aq;
    private volatile boolean ar;
    private volatile boolean as;
    private volatile boolean at;
    private volatile boolean au;
    private volatile boolean av;
    private volatile boolean aw;
    private volatile boolean ax;
    private volatile long ay;
    private final com.bytedance.applog.log.b<CommonParamsWrapper> az;
    private final com.bytedance.applog.j.c d;
    private final com.bytedance.applog.j.a e;
    private final com.bytedance.applog.k.a f;
    private final com.bytedance.applog.m.b g;
    private final com.bytedance.applog.m.a h;
    private final INetworkClient i;
    private final int j;
    private int k;
    private String l;
    private volatile Application m;
    private volatile com.bytedance.applog.k.b n;
    private volatile com.bytedance.applog.k.c o;
    private volatile com.bytedance.applog.e.c p;
    private final com.bytedance.applog.collector.a q;
    private volatile boolean r;
    private volatile i s;
    private volatile m t;
    private volatile Integer u;
    private volatile com.bytedance.applog.filter.a v;
    private com.bytedance.applog.util.b w;
    private volatile Proxy x;
    private volatile boolean y;
    private final com.bytedance.applog.c.e z;

    static {
        f1518a = System.currentTimeMillis();
        f1519b = new CopyOnWriteArrayList();
        c = new AtomicInteger(0);
    }

    public b() {
        this.d = new com.bytedance.applog.j.c();
        this.e = new com.bytedance.applog.j.a();
        this.k = 0;
        this.l = "";
        this.m = null;
        this.y = true;
        this.B = false;
        this.C = false;
        this.D = true;
        this.E = false;
        this.F = new AtomicInteger(0);
        this.G = false;
        this.H = false;
        this.I = false;
        this.f1520J = false;
        this.K = true;
        this.L = false;
        this.M = 5;
        this.N = 200;
        this.O = false;
        this.P = false;
        this.Q = new HashSet();
        this.R = 200;
        this.S = 20;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 8;
        this.Z = null;
        this.aa = new com.bytedance.applog.monitor.a();
        this.ah = false;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = true;
        this.ao = false;
        this.ap = new ConcurrentHashMap();
        this.aq = false;
        this.ar = false;
        this.as = true;
        this.at = true;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = 0;
        this.az = new AnonymousClass1(this);
        this.aB = new AtomicBoolean(false);
        this.aC = new CopyOnWriteArrayList();
        this.aE = new com.bytedance.applog.b.a(new AnonymousClass2(this));
        this.aF = new com.bytedance.applog.l.e();
        this.j = c.getAndIncrement();
        this.aA = new q();
        this.h = new com.bytedance.applog.m.a(this);
        this.ag = new com.bytedance.applog.j.b(this);
        this.g = new com.bytedance.applog.m.b(this);
        this.i = new com.bytedance.applog.util.d(this);
        f1519b.add(this);
        this.f = new com.bytedance.applog.k.a(this);
        this.z = new com.bytedance.applog.c.c(this);
        this.q = new com.bytedance.applog.collector.a(this);
        this.ab = new com.bytedance.applog.monitor.v3.e();
        this.aD = new com.bytedance.applog.collector.d();
    }

    private String a(StageEventType r13, String r14, String r15, JSONObject r16) {
        if (r16 != null) goto L48;
        return null;
    L48:
        return r16.toString();
    L7:
        th = move-exception;
        aA().a("event toString failed " + r14 + ", label: " + r15, th, new Object[0]);
        JSONObject r0 = com.bytedance.applog.util.o.a(r16);
        if (r0 == null) goto L45;
        o r2 = f();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L50:
    L54:
        return r0.toString();
    L27:
        e = move-exception;
        ab().a(StatsCountKeys.MEM_ERROR_COUNT);
        if (r3 == true) goto L31;
        aA().a("event toString OOM tag: " + r14 + ", label: " + r15, e, new Object[0]);
        return null;
    L31:
        if (ab().c(r14) == false) goto L34;
        ab().a(EventStage.PARAMS_INVALID_DROP, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), StageEventType.V3_EVENT);
    L34:
        throw new RuntimeException("event toString OOM tag: " + r14 + ", label: " + r15, e);
    L18:
        e = move-exception;
        ab().a(StatsCountKeys.SOF_ERROR_COUNT);
        if (r3 == true) goto L22;
        aA().a("event toString stack overflow tag: " + r14 + ", label: " + r15, e, new Object[0]);
        return null;
    L22:
        if (ab().c(r14) == false) goto L25;
        ab().a(EventStage.PARAMS_INVALID_DROP, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), r13);
    L25:
        throw new RuntimeException("event toString stack overflow tag: " + r14 + ", label: " + r15, e);
    L36:
        ab().a(StatsCountKeys.CONCURRENT_MODIFY_ERROR_COUNT);
        return r0.toString();
    L39:
        th = move-exception;
        if (ab().c(r14) == false) goto L44;
        ab().a(EventStage.PARAMS_INVALID_DROP, r14, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), r13);
    L44:
        throw new RuntimeException("event params exception tag: " + r14 + ", label: " + r15, th);
    L13:
        if ("local_test".equalsIgnoreCase(r2.g()) == false) goto L15;
        r3 = true;
        goto L50
    L45:
        return null;
    }

    public static List<b> a() {
        return f1519b;
    }

    private void a(final o r2) {
        if (com.bytedance.applog.log.p.a() == false) goto L5;
        return;
    L5:
        com.bytedance.applog.log.p.a("init_begin", new AnonymousClass3(this, r2));
    }

    private void a(String r8, String r9, boolean r10) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        aA().d("event name is empty", new Object[0]);
        return;
    L6:
        a(new com.bytedance.applog.n.e(this.l, r8, false, r9, r10));
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.y;
    }

    static /* synthetic */ Integer b(b r0) {
        return r0.ad;
    }

    private void b(View r4, String r5, String r6, JSONObject r7) {
        if (TextUtils.isEmpty(r6) == false) goto L7;
        aA().d("event name is empty", new Object[0]);
        return;
    L7:
        if (af() == false) goto L11;
        if (r4 == null) goto L10;
        r7 = com.bytedance.applog.map.api.b.f1663a.a(r4, r5, r7);
        goto L11
    L10:
        r7 = com.bytedance.applog.map.api.b.f1663a.a(r7);
    L11:
        a(new com.bytedance.applog.n.e(this.l, r6, false, a(StageEventType.V3_EVENT, r6, null, r7)));
    }

    private void b(final String r2, final Object r3) {
        if (com.bytedance.applog.log.p.a() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(j()) == true) goto L9;
        com.bytedance.applog.log.p.a("update_config", new AnonymousClass4(this, r2, r3));
        return;
    }

    private void bf() {
        if (Z() != null) goto L6;
        a(new com.bytedance.applog.util.e(this, this.n));
        return;
    }

    static /* synthetic */ Proxy c(b r0) {
        return r0.x;
    }

    private void c(com.bytedance.applog.n.a r11) {
        if (this.e.a(1) == false) goto L20;
        return;
    L20:
    L16:
        th = move-exception;
        aA().a(4, "notify event observer before receive failed", th, new Object[0]);
        ab().a("notify event observer before receive failed", th);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.c.class) == false) goto L10;
        com.bytedance.applog.n.c r12 = (com.bytedance.applog.n.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.n.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.e.a(1, r12.v, r12.w, r12.x, r12.z, r12.A, r12.y);     // Catch: Throwable -> L16
    L19:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.e.class) == false) goto L13;
        com.bytedance.applog.n.e r13 = (com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.e.a(1, r13.u(), r13.p());     // Catch: Throwable -> L16
        goto L19
    L13:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.d.class) == false) goto L19;
        com.bytedance.applog.n.d r14 = (com.bytedance.applog.n.d) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.n.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.e.b(1, r14.t(), r14.p());     // Catch: Throwable -> L16
        goto L19
    }

    private void d(String r2, JSONObject r3) {
        b(null, null, r2, r3);
    }

    @Override // com.bytedance.applog.f
    public m A() {
        return this.t;
    }

    @Override // com.bytedance.applog.f
    public void A(boolean r2) {
        this.ar = r2;
        ab().a("custom_header_control_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public int B() {
        if (this.u == null) goto L7;
        return this.u.intValue();
    L7:
        if (this.n != null) goto L11;
        return 0;
    L11:
        return this.n.s();
    }

    @Override // com.bytedance.applog.f
    public void B(boolean r2) {
        this.as = r2;
        if (this.as == true) goto L6;
        ((CommonParamsWrapper) ZeusTransformUtils.preCheckCast(this.az.c(new Object[0]), CommonParamsWrapper.class, "com.obric.memorydata.plugin")).a();
        return;
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.filter.a C() {
        return this.v;
    }

    @Override // com.bytedance.applog.f
    public void C(boolean r1) {
        this.aD.a(r1);
    }

    @Override // com.bytedance.applog.f
    public Map<String, String> D() {
        return this.z.l();
    }

    @Override // com.bytedance.applog.f
    public void D(boolean r1) {
        this.au = r1;
    }

    @Override // com.bytedance.applog.f
    public String E() {
        if (this.p != null) goto L7;
        return null;
    L7:
        return this.p.c();
    }

    @Override // com.bytedance.applog.f
    public void E(boolean r1) {
        this.av = r1;
    }

    @Override // com.bytedance.applog.f
    public void F(boolean r1) {
        this.aw = r1;
    }

    @Override // com.bytedance.applog.f
    public boolean F() {
        return this.B;
    }

    @Override // com.bytedance.applog.f
    public IBDAccountCallback G() {
        return this.af;
    }

    @Override // com.bytedance.applog.f
    public void G(boolean r1) {
        this.ax = r1;
    }

    @Override // com.bytedance.applog.f
    public void H(boolean r2) {
        if (this.p == null) goto L6;
        this.p.b(r2);
        return;
    }

    @Override // com.bytedance.applog.f
    public boolean H() {
        return this.C;
    }

    @Override // com.bytedance.applog.f
    public boolean I() {
        return this.D;
    }

    @Override // com.bytedance.applog.f
    public boolean J() {
        return this.E;
    }

    @Override // com.bytedance.applog.f
    public boolean K() {
        return this.G;
    }

    @Override // com.bytedance.applog.f
    public boolean L() {
        return this.H;
    }

    @Override // com.bytedance.applog.f
    public void M() {
        if (this.p == null) goto L5;
        this.p.k();
        return;
    L5:
        aA().e("init priority failed for not init engine!", new Object[0]);
    }

    public int N() {
        return this.k;
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.filter.h O() {
        if (this.p != null) goto L7;
        return null;
    L7:
        return this.p.o();
    }

    @Override // com.bytedance.applog.f
    public void P() {
        if (this.p == null) goto L6;
        this.p.f();
        return;
    }

    @Override // com.bytedance.applog.f
    public void Q() {
        if (this.p == null) goto L6;
        this.p.g();
        return;
    }

    @Override // com.bytedance.applog.f
    public boolean R() {
        if (f() == null) goto L9;
        if (f().Q() == false) goto L9;
        return false;
    L9:
        return this.I;
    }

    public boolean S() {
        return this.ah;
    }

    public DataIsolateKey T() {
        return this.ai;
    }

    public com.bytedance.applog.isolate.b U() {
        return this.aj;
    }

    public JSONObject V() {
        return this.ak;
    }

    public JSONObject W() {
        if (this.n != null) goto L7;
        aA().d("call getLogback after init plz.", new Object[0]);
        return null;
    L7:
        return this.n.D();
    }

    @Override // com.bytedance.applog.f
    public void X() {
        if (this.p == null) goto L6;
        this.p.q();
        return;
    }

    @Override // com.bytedance.applog.f
    public Integer Y() {
        return this.ad;
    }

    @Override // com.bytedance.applog.f
    public k Z() {
        return this.ae;
    }

    @Override // com.bytedance.applog.f
    public <T> T a(String r2, T r3, Class<T> r4) {
        if (this.o != null) goto L5;
        return null;
    L5:
        return (T) this.o.a(r2, r3, r4);
    }

    @Override // com.bytedance.applog.f
    public String a(Context r3, String r4, boolean r5, Level r6) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), new StringBuilder(r4), r5, r6);
    }

    @Override // com.bytedance.applog.f
    public String a(Context r3, StringBuilder r4, boolean r5, Level r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return this.z.a(r7, r4, r5, r6);
    }

    @Override // com.bytedance.applog.f
    public void a(int r3) {
        this.u = Integer.valueOf(r3);
        ab().a("http_monitor_port", r3);
    }

    @Override // com.bytedance.applog.f
    public void a(int r3, h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        this.e.a(r3, r5);
    }

    @Override // com.bytedance.applog.f
    public void a(long r3) {
        if (this.p != null) goto L5;
    L9:
        this.ac = Long.valueOf(r3);
        return;
    L5:
        if (this.p.b() == null) goto L9;
        if (this.p.b().e() == r3) goto L11;
        this.p.b().a(r3);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(long r3, OnResetListener r5) {
        OnResetListener r6 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r5, OnResetListener.class, "com.obric.memorydata.plugin");
        if (this.p == null) goto L6;
        this.p.a(r3, r6);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(Account r1) {
        this.z.a(r1);
    }

    @Override // com.bytedance.applog.f
    public void a(Activity r2, int r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.q.onActivityResumed(r4);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(Context r23, o r24) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(b.class);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r24.f()) == true) goto L54;
        if (a.a(r24.f()) == true) goto L52;
        aA().a(r24.f());     // Catch: Throwable -> L55
        this.l = r24.f();     // Catch: Throwable -> L55
        this.m = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        if (r24.O() == true) goto L11;
    L17:
        aA().b("App:{} init begin...", new Object[]{this.l});     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r24.F()) == false) goto L20;
        r24.d(a.a(this, "applog_stats"));     // Catch: Throwable -> L55
    L20:
        a(r24);     // Catch: Throwable -> L55
        this.n = new com.bytedance.applog.k.b(this, this.m, r24);     // Catch: Throwable -> L55
        bf();     // Catch: Throwable -> L55
        this.o = new com.bytedance.applog.k.c(this, this.n, this.z);     // Catch: Throwable -> L55
        this.p = new com.bytedance.applog.e.c(this, this.n, this.o, this.z, r24.M(), this.f, this.aE);     // Catch: Throwable -> L55
        if (r24.C() == false) goto L23;
        this.m.registerActivityLifecycleCallbacks(this.q);     // Catch: Throwable -> L55
    L23:
        this.k = 1;     // Catch: Throwable -> L55
        this.r = r24.b();     // Catch: Throwable -> L55
        if (this.ac == null) goto L27;
        a(this.ac.longValue());     // Catch: Throwable -> L55
        this.ac = null;     // Catch: Throwable -> L55
    L27:
        if (L() == false) goto L34;
        String[] r1 = this.p.i().c();     // Catch: Throwable -> L55
        String r15 = this.l;     // Catch: Throwable -> L55
        if (r1.length <= 0) goto L31;
        String r2 = r1[0];     // Catch: Throwable -> L55
    L32:
        this.am = new PriorityWrapper(r10, new com.bytedance.applog.priority.e(r15, r2, r24.O(), F(), k(), new PriorityCallbackImpl(this), new com.bytedance.applog.priority.h(this)));     // Catch: Throwable -> L55
        goto L34
    L31:
        r2 = "";
    L34:
        if (r24.D() == false) goto L37;
        ab().a("congestion_enable", 1);     // Catch: Throwable -> L55
    L37:
        if (r24.A() == false) goto L40;
        ab().a("silence_in_background", 1);     // Catch: Throwable -> L55
    L40:
        if (r24.J() == false) goto L43;
        ab().a("event_filter_enable", 1);     // Catch: Throwable -> L55
    L43:
        if (r24.Q() == false) goto L46;
        ab().a("stop_on_enter_background", 1);     // Catch: Throwable -> L55
    L46:
        if (r24.C() == false) goto L48;
        ab().a("handle_lifecycle_enable", 1);     // Catch: Throwable -> L55
    L48:
        com.bytedance.applog.log.p.a("init_end", this.l);     // Catch: Throwable -> L55
        aA().b("App:{} init end.", new Object[]{this.l});     // Catch: Throwable -> L55
        this.n.G();     // Catch: Throwable -> L55
        monitor-exit(b.class);     // Catch: Throwable -> L55
        return;
    L11:
        if (this.aB.compareAndSet(false, true) == false) goto L17;
        if (r24.a() == null) goto L16;
        String r3 = this.l;     // Catch: Throwable -> L55
        com.bytedance.applog.log.k r4 = new com.bytedance.applog.log.e(r24.a());     // Catch: Throwable -> L55
    L15:
        com.bytedance.applog.log.o.a(r3, r4);     // Catch: Throwable -> L55
        goto L17
    L16:
        r3 = this.l;     // Catch: Throwable -> L55
        r4 = new com.bytedance.applog.log.d(this);     // Catch: Throwable -> L55
        goto L15
    L52:
        throw new IllegalStateException("The app id is init already!");     // Catch: Throwable -> L55
    L54:
        throw new IllegalStateException("App id must not be empty!");     // Catch: Throwable -> L55
    }

    @Override // com.bytedance.applog.f
    public void a(Context r3, Map<String, String> r4, boolean r5, Level r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.z.a(r7, r8, r5, r6);
    }

    @Override // com.bytedance.applog.f
    public void a(Context r3, JSONObject r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.z.b(r5, r4);
    }

    @Override // com.bytedance.applog.f
    public void a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.z.a(r5, r4);
        b(com.bytedance.applog.log.n.T, Boolean.valueOf(r4));
        ab().a(Api.KEY_NEW_USER_MODE, r4);
    }

    @Override // com.bytedance.applog.f
    public void a(Context r3, boolean r4, long r5, OnResetListener r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r8 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r7, OnResetListener.class, "com.obric.memorydata.plugin");
        if (this.p == null) goto L5;
        this.p.a(r4, r5, r8);
    L5:
        ab().a("child_mode", r4);
    }

    @Override // com.bytedance.applog.f
    public void a(View r1, String r2, String r3, JSONObject r4) {
        b(r1, r2, r3, r4);
    }

    @Override // com.bytedance.applog.f
    public void a(IBDAccountCallback r3) {
        this.af = (IBDAccountCallback) ZeusTransformUtils.wrapperContextForParams(r3, IBDAccountCallback.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(com.bytedance.applog.collector.b r3) {
        com.bytedance.applog.collector.b r4 = (com.bytedance.applog.collector.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.collector.b.class, "com.obric.memorydata.plugin");
        if (this.p == null) goto L6;
        this.p.l().a(r4);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(e r3) {
        this.A = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public synchronized void a(g r3) {
        monitor-enter(this);
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (this.w != null) goto L6;
        this.w = new com.bytedance.applog.util.b();     // Catch: Throwable -> L9
    L6:
        this.w.a(r4);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.f
    public void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        this.e.a(0, r4);
    }

    @Override // com.bytedance.applog.f
    public void a(com.bytedance.applog.i.a r3) {
        this.al = (com.bytedance.applog.i.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.i.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(i r3) {
        this.s = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(DataIsolateKey r1) {
        this.ai = r1;
    }

    @Override // com.bytedance.applog.f
    public void a(com.bytedance.applog.isolate.b r3) {
        this.aj = (com.bytedance.applog.isolate.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.isolate.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        this.ag.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void a(k r3) {
        this.ae = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        this.aa.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void a(m r3) {
        this.t = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
    }

    public void a(com.bytedance.applog.n.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r5.a(b());
        r5.a(this.aD.a());
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.n.e.class) == false) goto L7;
    L10:
        ab().a(StatsCountKeys.COLLECT_EVENT_COUNT);
        r5.s = com.bytedance.applog.monitor.b.c(ab(), r5);
        if (r5.s <= 0) goto L13;
        com.bytedance.applog.monitor.b.a(ab(), EventStage.PRE_PROCESS_START, r5);
    L13:
        c(r5);
        if (this.p != null) goto L18;
        this.f.a(r5);
        if (r5.s <= 0) goto L20;
        com.bytedance.applog.monitor.b.a(ab(), EventStage.CACHED_BEFORE_HANDLE, r5);
    L20:
        if (r5.j() <= 1048576) goto L22;
        ab().a("receive data too big (>1MB)", new Throwable(r5.toString()));
    L22:
        com.bytedance.applog.log.p.a("event_receive", r5);
        return;
    L18:
        this.p.a(r5);
        goto L20
    L7:
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.n.c.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.n.d.class) == false) goto L13;
        goto L10
    }

    @Override // com.bytedance.applog.f
    public void a(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        this.d.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void a(com.bytedance.applog.o.b r3) {
        this.Z = (com.bytedance.applog.o.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.o.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.f
    public void a(com.bytedance.applog.p.a r3) {
        com.bytedance.applog.p.a r4 = (com.bytedance.applog.p.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.p.a.class, "com.obric.memorydata.plugin");
        if (this.p == null) goto L6;
        this.p.l().a(r4);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(p r2) {
        if (this.p == null) goto L6;
        this.p.a(r2);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(IExtraParams r3) {
        IExtraParams r4 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r3, IExtraParams.class, "com.obric.memorydata.plugin");
        this.z.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void a(ILogger r4) {
        ILogger r5 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r4, ILogger.class, "com.obric.memorydata.plugin");
        if (f() == null) goto L5;
        return;
    L5:
        if (this.aB.compareAndSet(false, true) == false) goto L9;
        com.bytedance.applog.log.o.a(new com.bytedance.applog.log.e(r5));
        aV().a(true);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(String r2) {
        if (this.p == null) goto L6;
        this.p.a(r2);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.q.a(r2, r3);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(String r6, Bundle r7) {
        JSONObject r0 = null;
        if (r7 != null) goto L21;
    L17:
        d(r6, r0);
        return;
    L21:
    L15:
        th = th;
    L16:
        aA().a("parse bundle params failed", th, new Object[0]);
        ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        goto L17
    L5:
        if (r7.isEmpty() == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r1.put(r3, r7.get(r3));     // Catch: Throwable -> L13
        goto L9
    L12:
        r0 = r1;
    L13:
        th = th;
        r0 = r1;
        goto L16
    }

    @Override // com.bytedance.applog.f
    public void a(String r7, Bundle r8, String r9, String r10, String r11) {
        if (TextUtils.isEmpty(r9) == true) goto L5;
    L8:
        JSONObject r0 = null;
        String r12 = "second_app_" + r7;
        if (r8 != null) goto L27;
    L23:
        d(r12, r0);
        return;
    L27:
    L21:
        th = th;
    L22:
        aA().a("prepare params failed", th, new Object[0]);
        ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        goto L23
    L11:
        if (r8.isEmpty() == true) goto L23;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L21
        Iterator<String> r1 = r8.keySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r1.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r2.put(r3, r8.get(r3));     // Catch: Throwable -> L19
        goto L15
    L17:
        r2.put("params_for_special", "second_app");     // Catch: Throwable -> L19
        r2.put("second_appid", r9);     // Catch: Throwable -> L19
        r2.put("second_appname", r10);     // Catch: Throwable -> L19
        r2.put("product_type", r11);     // Catch: Throwable -> L19
        r0 = r2;
    L19:
        th = th;
        r0 = r2;
        goto L22
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        aA().d("both second appid and second app name is empty, return", new Object[0]);
    }

    @Override // com.bytedance.applog.f
    public void a(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        HashMap<String, Object> r0 = new HashMap();
        r0.put(r2, r3);
        this.z.a(r0);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(String r2, String r3) {
        if (this.p == null) goto L6;
        this.p.a(r2, r3);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(String r4, String r5, int r6) {
        if (r6 >= 0) goto L7;
        aA().d("interval must not less than 0", new Object[0]);
        return;
    L7:
        if (this.ak != null) goto L15;
        this.ak = new JSONObject();
    L15:
        this.ak.put("interval", r6);     // Catch: Throwable -> L11
        this.ak.put("caller", r4);     // Catch: Throwable -> L11
        this.ak.put(Header.KEY_UNIQUE_KEY, r5);     // Catch: Throwable -> L11
    L13:
        ab().a("expected_batch_interval_config", com.bytedance.applog.util.o.a(this.ak));
        return;
    L11:
        th = move-exception;
        aA().a("json build ExpectedBatchInterval failed", th, new Object[0]);
        ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        goto L13
    }

    @Override // com.bytedance.applog.f
    public void a(String r10, String r11, String r12, long r13, long r15) {
        a(r10, r11, r12, r13, r15, null);
    }

    @Override // com.bytedance.applog.f
    public void a(String r13, String r14, String r15, long r16, long r18, JSONObject r20) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L9:
        aA().d("category or tag is empty", new Object[0]);
        return;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L9;
        a(new com.bytedance.applog.n.c(this.l, r13, r14, r15, r16, r18, a(StageEventType.V1_EVENT, r14, r15, r20)));
    }

    @Override // com.bytedance.applog.f
    public void a(String r1, Throwable r2) {
        ab().a(r1, r2);
    }

    @Override // com.bytedance.applog.f
    public void a(String r1, JSONObject r2) {
        d(r1, r2);
    }

    @Override // com.bytedance.applog.f
    public void a(String r4, JSONObject r5, String r6, String r7, String r8) {
        if (TextUtils.isEmpty(r6) == true) goto L5;
    L8:
        if (r5 != null) goto L10;
        r5 = new JSONObject();
    L10:
        String r9 = "second_app_" + r4;
        r5.put("params_for_special", "second_app");     // Catch: Throwable -> L13
        r5.put("second_appid", r6);     // Catch: Throwable -> L13
        r5.put("second_appname", r7);     // Catch: Throwable -> L13
        r5.put("product_type", r8);     // Catch: Throwable -> L13
    L15:
        d(r9, r5);
        return;
    L13:
        th = move-exception;
        aA().a("prepare params failed", th, new Object[0]);
        ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        goto L15
    L5:
        if (TextUtils.isEmpty(r7) == false) goto L8;
        aA().d("both second appid and second app name is empty, return", new Object[0]);
    }

    @Override // com.bytedance.applog.f
    public void a(Proxy r2) {
        this.x = r2;
        String r0 = com.bytedance.applog.log.n.B;
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        b(r0, Boolean.valueOf(r3));
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.applog.f
    public void a(HashMap<String, Object> r1) {
        this.z.a(r1);
    }

    @Override // com.bytedance.applog.f
    public void a(HashSet<String> r1, int r2, int r3) {
        this.Q = r1;
        this.R = r2;
        this.S = r3;
        this.P = true;
        if (this.p == null) goto L6;
        this.p.a(true);
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(List<String> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.v = com.bytedance.applog.filter.a.a(this, r5, r4);
        com.bytedance.applog.monitor.v3.e r2 = ab();
        if (r5 == null) goto L8;
        if (r4 == false) goto L6;
        int r6 = 1;
    L7:
        long r7 = r6;
    L9:
        r2.a("custom_event_filter", r7);
        return;
    L6:
        r6 = 2;
        goto L7
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.bytedance.applog.f
    public void a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        InstallInfo r2 = this.z.c();
        if (r2 == null) goto L17;
        String r0 = r2.getDid();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        r4.put("device_id", r0);
    L7:
        String r1 = r2.getIid();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r4.put("install_id", r1);
    L10:
        String r5 = r2.getOpenUdid();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r4.put("openudid", r5);
    L13:
        String r6 = r2.getClientUdid();
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r4.put("clientudid", r6);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.applog.f
    public void a(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.z.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.applog.f
    public void a(boolean r3) {
        this.y = r3;
        com.bytedance.applog.monitor.v3.e r2 = ab();
        if (r3 == false) goto L5;
        long r0 = 1;
    L6:
        r2.a("encrypt_enable", r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.bytedance.applog.f
    public void a(boolean r5, String r6) {
        if (TextUtils.isEmpty(b()) == false) goto L6;
        aA().d("Not init before change event sender", new Object[0]);
        return;
    L6:
        com.bytedance.applog.util.g.a(b(), r5, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (TextUtils.isEmpty(r6) == true) goto L9;
        com.bytedance.applog.util.g.a(b(), r6);
    L9:
        ab().a("et_enable", r5);
        ab().b("et_host", r6);
    }

    public void a(String[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length == 0) goto L17;
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        r0.append(r5[r2]);
        r0.append(",");
        r2 = r2 + 1;
        goto L7
    L10:
        if (this.p != null) goto L12;
        this.f.a(r5);
        return;
    L12:
        this.p.a(r5);
        return;
    }

    @Override // com.bytedance.applog.f
    public boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return this.z.a(r4);
    }

    public com.bytedance.applog.log.j aA() {
        return this.aA;
    }

    public long aB() {
        if (this.p != null) goto L7;
        return 0;
    L7:
        return this.p.b().h();
    }

    public boolean aC() {
        return this.T;
    }

    public boolean aD() {
        return this.U;
    }

    public int aE() {
        return this.Y;
    }

    public com.bytedance.applog.monitor.a aF() {
        return this.aa;
    }

    public com.bytedance.applog.i.a aG() {
        return this.al;
    }

    public boolean aH() {
        return this.ao;
    }

    public com.bytedance.applog.h.a aI() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return this.n.F();
    }

    public com.bytedance.applog.priority.a aJ() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return this.n.z();
    }

    public int aK() {
        return this.F.get();
    }

    public boolean aL() {
        return this.V;
    }

    public boolean aM() {
        return this.W;
    }

    public boolean aN() {
        o r0 = f();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.O();
    }

    public boolean aO() {
        return this.X;
    }

    public List<String> aP() {
        return this.aC;
    }

    public boolean aQ() {
        return this.aq;
    }

    public boolean aR() {
        return this.ar;
    }

    public PriorityWrapper aS() {
        if (L() == true) goto L7;
        return null;
    L7:
        return this.am;
    }

    public boolean aT() {
        return this.an;
    }

    public boolean aU() {
        return this.as;
    }

    public com.bytedance.applog.params.c aV() {
        if (aU() == false) goto L6;
        return (com.bytedance.applog.params.c) ZeusTransformUtils.preCheckCast(this.az.c(new Object[0]), com.bytedance.applog.params.c.class, "com.obric.memorydata.plugin");
    L6:
        return com.bytedance.applog.params.d.f1767a;
    }

    public Map<String, String> aW() {
        return this.ap;
    }

    public com.bytedance.applog.collector.d aX() {
        return this.aD;
    }

    public boolean aY() {
        return this.f1520J;
    }

    public boolean aZ() {
        return this.at;
    }

    public boolean aa() {
        return this.L;
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.monitor.v3.e ab() {
        return this.ab;
    }

    @Override // com.bytedance.applog.f
    public IBDInstallApi ac() {
        return this.z.n();
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.params.b ad() {
        if (aU() == false) goto L6;
        return (com.bytedance.applog.params.b) ZeusTransformUtils.preCheckCast(this.az.c(new Object[0]), com.bytedance.applog.params.b.class, "com.obric.memorydata.plugin");
    L6:
        return com.bytedance.applog.params.d.f1767a;
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.b.b ae() {
        return this.aE;
    }

    @Override // com.bytedance.applog.f
    public boolean af() {
        return this.aw;
    }

    @Override // com.bytedance.applog.f
    public boolean ag() {
        return this.ax;
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.g.b ah() {
        if (ag() == true) goto L5;
    L7:
        com.bytedance.applog.g.b r1 = null;
    L8:
        if (r1 == null) goto L11;
        return r1;
    L11:
        return com.bytedance.applog.g.a.f1602a;
    L5:
        if (this.p == null) goto L7;
        r1 = this.p.s();
        goto L8
    }

    @Override // com.bytedance.applog.f
    public com.bytedance.applog.l.e ai() {
        return this.aF;
    }

    public long aj() {
        return f1518a;
    }

    @Override // com.bytedance.applog.f
    public void ak() {
        this.P = false;
        if (this.p == null) goto L6;
        this.p.a(false);
        return;
    }

    public boolean al() {
        return this.P;
    }

    public HashSet<String> am() {
        return this.Q;
    }

    public int an() {
        return this.R;
    }

    public int ao() {
        return this.S;
    }

    public int ap() {
        return this.M;
    }

    public int aq() {
        return this.N;
    }

    public com.bytedance.applog.util.b ar() {
        return this.w;
    }

    public com.bytedance.applog.j.c as() {
        return this.d;
    }

    public com.bytedance.applog.j.a at() {
        return this.e;
    }

    public com.bytedance.applog.j.b au() {
        return this.ag;
    }

    public com.bytedance.applog.m.b av() {
        return this.g;
    }

    public com.bytedance.applog.m.a aw() {
        return this.h;
    }

    public com.bytedance.applog.n.i ax() {
        return this.q.a();
    }

    public Proxy ay() {
        return this.x;
    }

    public com.bytedance.applog.o.b az() {
        if (this.Z != null) goto L7;
        return com.bytedance.applog.o.a.a();
    L7:
        return this.Z;
    }

    @Override // com.bytedance.applog.f
    public NUApi b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return this.z.b(r4);
    }

    @Override // com.bytedance.applog.f
    public String b() {
        return this.l;
    }

    public void b(int r1) {
        this.k = r1;
    }

    @Override // com.bytedance.applog.f
    public void b(long r2) {
        if (this.p == null) goto L6;
        this.p.a(r2);
        return;
    }

    @Override // com.bytedance.applog.f
    public void b(com.bytedance.applog.collector.b r3) {
        com.bytedance.applog.collector.b r4 = (com.bytedance.applog.collector.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.collector.b.class, "com.obric.memorydata.plugin");
        this.q.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void b(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.util.b r2 = this.w;
        if (r2 == null) goto L6;
        r2.b(r4);
        return;
    }

    @Override // com.bytedance.applog.f
    public void b(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        this.e.a(r4);
    }

    @Override // com.bytedance.applog.f
    public void b(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        this.ag.b(r4);
    }

    public void b(com.bytedance.applog.n.a r2) {
        if (this.p != null) goto L5;
        return;
    L5:
        this.p.b().b(r2);
    }

    @Override // com.bytedance.applog.f
    public void b(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        this.d.b(r4);
    }

    @Override // com.bytedance.applog.f
    public void b(String r2) {
        a("touch_point", r2);
    }

    @Override // com.bytedance.applog.f
    public void b(String r1, int r2) {
        ab().a(r1, r2);
    }

    @Override // com.bytedance.applog.f
    public void b(String r10, String r11) {
        a("event_v1", r10, r11, 0, 0, null);
    }

    @Override // com.bytedance.applog.f
    public void b(String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L15:
        aA().d("call onEventData with invalid params, return", new Object[0]);
        return;
    L5:
        if (r11.length() <= 0) goto L15;
        a(new com.bytedance.applog.n.d(this.l, r10, r11));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        if (ab().c(r10) == false) goto L13;
        ab().a(EventStage.PARAMS_INVALID_DROP, r10, com.bytedance.applog.monitor.v3.f.c(), System.currentTimeMillis(), StageEventType.LOG_DATA);
    L13:
        aA().a("call onEventData get exception: ", e, new Object[0]);
    }

    @Override // com.bytedance.applog.f
    public void b(boolean r3) {
        this.B = r3;
        b(com.bytedance.applog.log.n.x, Boolean.valueOf(r3));
        ab().a("event_uid_enable", r3);
    }

    public boolean ba() {
        return this.au;
    }

    public boolean bb() {
        return this.av;
    }

    public long bc() {
        return this.ay;
    }

    public long bd() {
        if (this.p != null) goto L7;
        return 0;
    L7:
        return this.p.b().e();
    }

    public com.bytedance.applog.e.f be() {
        if (this.p != null) goto L7;
        return null;
    L7:
        return this.p.b();
    }

    @Override // com.bytedance.applog.f
    public void c() {
        if (this.r == true) goto L6;
        this.r = true;
        this.p.j();
        aA().b("System start!", new Object[0]);
        return;
    }

    @Override // com.bytedance.applog.f
    public void c(int r2) {
        this.ad = Integer.valueOf(r2);
        com.bytedance.applog.monitor.v3.e r1 = ab();
        if (r2 <= 0) goto L5;
        boolean r3 = true;
    L6:
        r1.a("disable_personalization_enable", r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.applog.f
    public void c(long r1) {
        this.ay = r1;
    }

    @Override // com.bytedance.applog.f
    public void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L5;
        a((Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin"), r4.hashCode());
        return;
    L5:
        com.bytedance.applog.log.j r2 = aA();
        StringBuilder r0 = new StringBuilder().append("onResume context: ");
        if (r4 != null) goto L8;
        String r5 = "null";
    L9:
        r2.e(r0.append(r5).toString(), new Object[0]);
        return;
    L8:
        r5 = r4.getClass().getName();
        goto L9
    }

    @Override // com.bytedance.applog.f
    public void c(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.z.a(r2);
        return;
    }

    public void c(String r2, String r3) {
        a(r2, r3, false);
    }

    @Override // com.bytedance.applog.f
    public void c(boolean r3) {
        this.C = r3;
        ab().a("tourist_mode", r3);
        b(com.bytedance.applog.log.n.y, Boolean.valueOf(r3));
    }

    @Override // com.bytedance.applog.f
    public boolean c(String r2, JSONObject r3) {
        if (aK() != 0) goto L5;
        return false;
    L5:
        if (this.p != null) goto L8;
        return false;
    L8:
        return this.p.a(r2, r3);
    }

    @Override // com.bytedance.applog.f
    public void d() {
        aA().b("System stop!", new Object[0]);
        if (this.r == false) goto L6;
        this.r = false;
        return;
    }

    @Override // com.bytedance.applog.f
    public void d(int r2) {
        this.M = Math.max(r2, 1);
    }

    @Override // com.bytedance.applog.f
    public void d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L5;
        y();
        return;
    L5:
        com.bytedance.applog.log.j r2 = aA();
        StringBuilder r0 = new StringBuilder().append("onPause context: ");
        if (r4 != null) goto L8;
        String r5 = "null";
    L9:
        r2.e(r0.append(r5).toString(), new Object[0]);
        return;
    L8:
        r5 = r4.getClass().getName();
        goto L9
    }

    @Override // com.bytedance.applog.f
    public void d(String r2) {
        if (this.o == null) goto L6;
        this.o.a(r2);
        return;
    }

    @Override // com.bytedance.applog.f
    public void d(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, String> r1 = this.ap;
        if (r3 != null) goto L9;
        r1.remove(r2);
        return;
    L9:
        r1.put(r2, r3);
    }

    @Override // com.bytedance.applog.f
    public void d(boolean r3) {
        this.D = r3;
        ab().a("tourist_mode_event_enable", r3);
        b(com.bytedance.applog.log.n.z, Boolean.valueOf(r3));
    }

    public String e(String r2) {
        e r0 = this.A;
        if (r0 == null) goto L7;
        return r0.a(r2);
    L7:
        if (this.o != null) goto L9;
        return null;
    L9:
        return this.o.f();
    }

    @Override // com.bytedance.applog.f
    public void e(int r2) {
        this.N = Math.max(r2, 100);
    }

    @Override // com.bytedance.applog.f
    public void e(boolean r3) {
        this.E = r3;
        b(com.bytedance.applog.log.n.A, Boolean.valueOf(r3));
        ab().a("dau_fix", r3);
    }

    @Override // com.bytedance.applog.f
    public boolean e() {
        return this.r;
    }

    @Override // com.bytedance.applog.f
    public o f() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return this.n.c();
    }

    @Override // com.bytedance.applog.f
    public void f(int r3) {
        this.Y = Math.min(Math.max(1, r3), 8);
        ab().a("max_request_once_report", r3);
    }

    @Override // com.bytedance.applog.f
    public void f(String r4) {
        this.z.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.applog.f
    public void f(boolean r3) {
        AtomicInteger r0 = this.F;
        int r1 = r0.get();
        if (r3 == false) goto L5;
        int r2 = r1 | 1;
    L6:
        r0.set(r2);
        b(com.bytedance.applog.log.n.u, Boolean.valueOf(r3));
        ab().a("normal_sample_enable", r3);
        return;
    L5:
        r2 = r1 & (-2);
        goto L6
    }

    @Override // com.bytedance.applog.f
    public void g() {
        if (this.K == false) goto L7;
        h();
        return;
    L7:
        if (this.p == null) goto L9;
        this.p.a(null, true);
    L9:
        ab().a(StatsCountKeys.FLUSH_COUNT);
    }

    @Override // com.bytedance.applog.f
    public void g(int r3) {
        this.f.a(r3);
        ab().a("max_cache_event_num", r3);
    }

    @Override // com.bytedance.applog.f
    public void g(String r10) {
        a("event_v1", r10, null, 0, 0, null);
    }

    @Override // com.bytedance.applog.f
    public void g(boolean r3) {
        AtomicInteger r0 = this.F;
        int r1 = r0.get();
        if (r3 == false) goto L5;
        int r2 = r1 | 2;
    L6:
        r0.set(r2);
        b(com.bytedance.applog.log.n.v, Boolean.valueOf(r3));
        ab().a("tea_sample_enable", r3);
        return;
    L5:
        r2 = r1 & (-3);
        goto L6
    }

    @Override // com.bytedance.applog.f
    public Context getContext() {
        return this.m;
    }

    @Override // com.bytedance.applog.f
    public void h() {
        if (this.p == null) goto L5;
        this.p.n();
    L5:
        ab().a(StatsCountKeys.FLUSH_COUNT);
    }

    @Override // com.bytedance.applog.f
    public void h(String r2) {
        d(r2, null);
    }

    @Override // com.bytedance.applog.f
    public void h(boolean r2) {
        this.G = r2;
        ab().a("priority_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public String i() {
        if (this.p != null) goto L6;
        return null;
    L6:
        long r0 = this.p.b().e();
        IBDAccountCallback r2 = G();
        if (r2 == null) goto L10;
        r0 = ((Long) ZeusTransformUtils.preCheckCast(r2.getOdinUserInfo().second, Long.class, "com.obric.memorydata.plugin")).longValue();
    L10:
        return e(String.valueOf(r0));
    }

    @Override // com.bytedance.applog.f
    public void i(boolean r1) {
        this.H = r1;
    }

    @Override // com.bytedance.applog.f
    public boolean i(String r2) {
        if (aK() != 0) goto L5;
        return false;
    L5:
        if (this.p != null) goto L8;
        return false;
    L8:
        return this.p.a(r2, null);
    }

    @Override // com.bytedance.applog.f
    public String j() {
        return b();
    }

    @Override // com.bytedance.applog.f
    public void j(String r1) {
        this.aC.add(r1);
    }

    @Override // com.bytedance.applog.f
    public void j(boolean r1) {
        this.an = r1;
    }

    @Override // com.bytedance.applog.f
    public void k(String r1) {
        this.aC.remove(r1);
    }

    @Override // com.bytedance.applog.f
    public void k(boolean r2) {
        this.f1520J = r2;
        ab().a("bg_session_report_after_pause_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public boolean k() {
        return this.y;
    }

    @Override // com.bytedance.applog.f
    public void l(String r1) {
        this.aD.a(r1);
    }

    @Override // com.bytedance.applog.f
    public void l(boolean r2) {
        this.I = r2;
        ab().a("bg_session_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public boolean l() {
        return this.z.b();
    }

    @Override // com.bytedance.applog.f
    public String m() {
        return this.z.d();
    }

    @Override // com.bytedance.applog.f
    public void m(String r1) {
        this.aD.c(r1);
    }

    @Override // com.bytedance.applog.f
    public void m(boolean r2) {
        this.ah = r2;
        ab().a("isolate_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public String n() {
        return this.z.f();
    }

    @Override // com.bytedance.applog.f
    public void n(boolean r2) {
        if (this.p == null) goto L5;
        this.p.c(r2);
    L5:
        ab().a("child_mode", r2);
    }

    @Override // com.bytedance.applog.f
    public String o() {
        return this.z.h();
    }

    @Override // com.bytedance.applog.f
    public void o(boolean r2) {
        this.L = r2;
        ab().a("insert_event_opt_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public String p() {
        if (this.o != null) goto L5;
        return "";
    L5:
        return this.o.d();
    }

    @Override // com.bytedance.applog.f
    public void p(boolean r2) {
        this.T = r2;
        ab().a("migrate_old_applog_data_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public String q() {
        if (this.p != null) goto L7;
        return null;
    L7:
        return String.valueOf(this.p.b().e());
    }

    @Override // com.bytedance.applog.f
    public void q(boolean r1) {
        this.X = r1;
    }

    @Override // com.bytedance.applog.f
    public String r() {
        return this.z.e();
    }

    @Override // com.bytedance.applog.f
    public void r(boolean r2) {
        ab().a().a(r2);
        ab().a("monitor_debug_mode", r2);
    }

    @Override // com.bytedance.applog.f
    public String s() {
        return this.z.g();
    }

    @Override // com.bytedance.applog.f
    public void s(boolean r2) {
        this.U = r2;
        ab().a("terminate_immediately_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public void t(boolean r2) {
        this.ao = r2;
        ab().a("event_forward_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public boolean t() {
        return this.z.i();
    }

    public String toString() {
        return "AppLogInstance{id:" + this.j + ";appId:" + this.l + "}@" + hashCode();
    }

    @Override // com.bytedance.applog.f
    public void u() {
        com.bytedance.applog.util.b r0 = this.w;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.applog.f
    public void u(boolean r2) {
        this.V = r2;
        ab().a("pack_launch_desc", r2);
    }

    @Override // com.bytedance.applog.f
    public INetworkClient v() {
        INetworkClient r0 = this.n.c().q();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.i;
    }

    @Override // com.bytedance.applog.f
    public void v(boolean r2) {
        this.W = r2;
        ab().a("bdinstall_event_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public JSONObject w() {
        if (this.o != null) goto L7;
        aA().d("Init first please to get header", new Object[0]);
        return null;
    L7:
        return this.o.a();
    }

    @Override // com.bytedance.applog.f
    public void w(boolean r2) {
        this.q.a(r2);
        ab().a("track_resume_event_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public void x(boolean r2) {
        this.K = r2;
        ab().a("flush_async_default_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public boolean x() {
        return this.z.k();
    }

    @Override // com.bytedance.applog.f
    public void y() {
        this.q.onActivityPaused(null);
    }

    @Override // com.bytedance.applog.f
    public void y(boolean r2) {
        this.at = r2;
        ab().a("flush_threshold_enable", r2);
    }

    @Override // com.bytedance.applog.f
    public i z() {
        return this.s;
    }

    @Override // com.bytedance.applog.f
    public void z(boolean r2) {
        this.aq = r2;
        ab().a("event_param_control_enable", r2);
    }
}
