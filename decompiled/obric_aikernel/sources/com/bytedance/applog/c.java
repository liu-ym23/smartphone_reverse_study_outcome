package com.bytedance.applog;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.Level;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import o1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {
    private static final List<c> W = null;
    private static final AtomicInteger X = null;
    private volatile boolean A;
    private volatile boolean B;
    private volatile boolean C;
    private volatile boolean D;
    private volatile boolean E;
    private volatile int F;
    private volatile int G;
    private volatile boolean H;
    private volatile boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private volatile boolean f1162J;
    private volatile int K;
    private volatile Long L;
    private volatile Integer M;
    private volatile l N;
    private volatile IBDAccountCallback O;
    private final d1.b P;
    private volatile boolean Q;
    private volatile DataIsolateKey R;
    private volatile e1.b S;
    private volatile JSONObject T;
    private final f1.g U;
    private volatile boolean V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d1.c f1163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d1.a f1164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g1.a f1165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.monitor.a f1166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k1.b f1167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k1.a f1168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final INetworkClient f1169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f1172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile Application f1173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile g1.b f1174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile g1.c f1175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile a1.c f1176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final x0.a f1177o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f1178p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile j f1179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile c1.a f1180r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private o1.c f1181s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile Proxy f1182t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f1183u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final w0.d f1184v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile f f1185w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f1186x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile boolean f1187y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile boolean f1188z;

    class a implements f1.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f1189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f1190b;

        a(c r10, n r11) {
            this.f1190b = r10;
            this.f1189a = r11;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("appId", this.f1189a.d());     // Catch: Throwable -> L48
            r10.put("channel", this.f1189a.j());     // Catch: Throwable -> L48
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L48
            r11.put(f1.k.f8808a, "5.6.8-bugfix.11");     // Catch: Throwable -> L48
            r11.put(f1.k.f8809b, "cn");     // Catch: Throwable -> L48
            r11.put(f1.k.f8810c, c.h(this.f1190b));     // Catch: Throwable -> L48
            r11.put(f1.k.f8811d, o1.n.f11387a);     // Catch: Throwable -> L48
            String r12 = f1.k.f8812e;     // Catch: Throwable -> L48
            boolean r13 = false;
            if (this.f1189a.s() == null) goto L6;
            boolean r14 = true;
        L7:
            r11.put(r12, r14);     // Catch: Throwable -> L48
            r11.put(f1.k.f8813f, this.f1189a.a());     // Catch: Throwable -> L48
            r11.put(f1.k.f8814g, this.f1189a.J());     // Catch: Throwable -> L48
            r11.put(f1.k.f8815h, this.f1189a.W());     // Catch: Throwable -> L48
            r11.put(f1.k.f8816i, this.f1189a.A());     // Catch: Throwable -> L48
            r11.put(f1.k.f8817j, this.f1189a.l());     // Catch: Throwable -> L48
            r11.put(f1.k.f8818k, this.f1189a.Q());     // Catch: Throwable -> L48
            String r15 = f1.k.f8819l;     // Catch: Throwable -> L48
            if (c.i(this.f1190b) != null) goto L10;
        L12:
            boolean r16 = false;
        L13:
            r11.put(r15, r16);     // Catch: Throwable -> L48
            r11.put(f1.k.f8820m, this.f1189a.G());     // Catch: Throwable -> L48
            r11.put(f1.k.f8821n, String.valueOf(this.f1189a.F()));     // Catch: Throwable -> L48
            r11.put(f1.k.f8822o, this.f1189a.E());     // Catch: Throwable -> L48
            r11.put(f1.k.f8823p, this.f1189a.f());     // Catch: Throwable -> L48
            String r17 = f1.k.f8824q;     // Catch: Throwable -> L48
            if (this.f1189a.w() != 1) goto L16;
            String r18 = "main";
        L17:
            r11.put(r17, r18);     // Catch: Throwable -> L48
            r11.put(f1.k.f8825r, this.f1189a.x());     // Catch: Throwable -> L48
            r11.put(f1.k.f8826s, this.f1189a.q());     // Catch: Throwable -> L48
            r11.put(f1.k.f8827t, this.f1189a.V());     // Catch: Throwable -> L48
            r11.put(f1.k.f8828u, this.f1190b.f0());     // Catch: Throwable -> L48
            r11.put(f1.k.f8829v, this.f1190b.e0());     // Catch: Throwable -> L48
            r11.put(f1.k.f8830w, this.f1190b.D());     // Catch: Throwable -> L48
            r11.put(f1.k.f8831x, this.f1190b.k0());     // Catch: Throwable -> L48
            r11.put(f1.k.f8832y, this.f1190b.d0());     // Catch: Throwable -> L48
            r11.put(f1.k.f8833z, this.f1190b.o());     // Catch: Throwable -> L48
            String r19 = f1.k.A;     // Catch: Throwable -> L48
            if (c.j(this.f1190b) == null) goto L20;
            r13 = true;
        L20:
            r11.put(r19, r13);     // Catch: Throwable -> L48
            r11.put(f1.k.C, this.f1190b.H());     // Catch: Throwable -> L48
            if (this.f1189a.D() == null) goto L45;
            ArrayList r20 = new ArrayList();     // Catch: Throwable -> L48
            if (this.f1189a.D().b() == null) goto L33;
            if (this.f1189a.D().b().getConfig() == null) goto L33;
            if (TextUtils.isEmpty(this.f1189a.D().b().getConfig().getRegisterUri()) == true) goto L30;
            r20.add(this.f1189a.D().b().getConfig().getRegisterUri());     // Catch: Throwable -> L48
        L30:
            if (TextUtils.isEmpty(this.f1189a.D().b().getConfig().getActiveUri()) == true) goto L33;
            r20.add(this.f1189a.D().b().getConfig().getActiveUri());     // Catch: Throwable -> L48
        L33:
            if (this.f1189a.D().d() == null) goto L38;
            if (this.f1189a.D().d().length <= 0) goto L38;
            r20.add(TextUtils.join(";", this.f1189a.D().d()));     // Catch: Throwable -> L48
        L38:
            if (TextUtils.isEmpty(this.f1189a.D().e()) == true) goto L41;
            r20.add(this.f1189a.D().e());     // Catch: Throwable -> L48
        L41:
            if (TextUtils.isEmpty(this.f1189a.D().e()) == true) goto L43;
            r20.add(this.f1189a.D().e());     // Catch: Throwable -> L48
        L43:
            String r21 = f1.k.B;     // Catch: Throwable -> L48
            String r22 = TextUtils.join("、", r20);     // Catch: Throwable -> L48
        L44:
            r11.put(r21, r22);     // Catch: Throwable -> L48
            r10.put("config", r11);     // Catch: Throwable -> L48
            goto L47
        L45:
            r21 = f1.k.B;     // Catch: Throwable -> L48
            r22 = DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
            goto L44
        L16:
            r18 = "child";
            goto L17
        L10:
            if (c.i(this.f1190b).intValue() != 1) goto L12;
            r16 = true;
            goto L13
        L6:
            r14 = false;
        L47:
            return r10;
        }
    }

    static {
        W = new CopyOnWriteArrayList();
        X = new AtomicInteger(0);
    }

    public c() {
        this.f1163a = new d1.c();
        this.f1164b = new d1.a();
        this.f1171i = 0;
        this.f1172j = "";
        this.f1173k = null;
        this.f1183u = true;
        this.f1186x = false;
        this.f1187y = false;
        this.f1188z = true;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 5;
        this.G = 200;
        this.H = false;
        this.I = true;
        this.f1162J = false;
        this.K = 8;
        this.Q = false;
        this.T = null;
        this.V = false;
        this.f1170h = X.getAndIncrement();
        this.U = new f1.n();
        this.f1168f = new k1.a(this);
        this.f1166d = new com.bytedance.applog.monitor.a(this);
        this.P = new d1.b(this);
        this.f1167e = new k1.b(this);
        this.f1169g = new o1.e(this);
        W.add(this);
        this.f1165c = new g1.a(this);
        this.f1184v = new w0.b(this);
        this.f1177o = new x0.a(this);
    }

    private void Y() {
        if (this.f1173k == null) goto L13;
        if ((this.f1173k.getApplicationInfo().flags & 2) == 0) goto L7;
        boolean r10 = true;
    L8:
        this.V = r10;     // Catch: Throwable -> L10
        return;
    L7:
        r10 = false;
    L14:
        return;
    }

    private void Z() {
        if (N() != null) goto L6;
        t0(new o1.f(this, this.f1174l));
        return;
    }

    static /* synthetic */ boolean h(c r10) {
        return r10.f1183u;
    }

    static /* synthetic */ Integer i(c r10) {
        return r10.M;
    }

    static /* synthetic */ Proxy j(c r10) {
        return r10.f1182t;
    }

    private void l0(l1.a r11) {
        if (this.f1164b.a(1) == false) goto L24;
        return;
    L24:
    L21:
        th = move-exception;
        P().v(4, "notify event observer before receive failed", th, new Object[0]);
        return;
    L6:
        if ((r11 instanceof l1.c) == false) goto L8;
        l1.c r12 = (l1.c) r11;     // Catch: Throwable -> L21
        this.f1164b.b(1, r12.f10857z, r12.A, r12.B, r12.D, r12.E, r12.C);     // Catch: Throwable -> L21
        return;
    L8:
        JSONObject r10 = null;
        if ((r11 instanceof l1.e) == false) goto L15;
        l1.e r13 = (l1.e) r11;     // Catch: Throwable -> L21
        d1.a r14 = this.f1164b;     // Catch: Throwable -> L21
        String r15 = r13.F();     // Catch: Throwable -> L21
        if (r13.l() == null) goto L13;
        r10 = new JSONObject(r13.l());     // Catch: Throwable -> L21
    L13:
        r14.c(1, r15, r10);     // Catch: Throwable -> L21
        return;
    L15:
        if ((r11 instanceof l1.d) == false) goto L27;
        l1.d r16 = (l1.d) r11;     // Catch: Throwable -> L21
        d1.a r17 = this.f1164b;     // Catch: Throwable -> L21
        String r18 = r16.E();     // Catch: Throwable -> L21
        if (r16.l() == null) goto L19;
        r10 = new JSONObject(r16.l());     // Catch: Throwable -> L21
    L19:
        r17.d(1, r18, r10);     // Catch: Throwable -> L21
        return;
    }

    private void o0(@NonNull String r10, @Nullable JSONObject r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        R().h(MonitorKey.event_v3, MonitorState.f_block);
        P().c("event name is empty", new Object[0]);
        return;
    L6:
        p0(new l1.e(this.f1172j, r10, false, x0(r10, null, r11)));
    }

    public static List<c> q() {
        return W;
    }

    private void r0(n r10) {
        f1.m.d("init_begin", new a(this, r10));
    }

    private String x0(String r10, String r11, JSONObject r12) {
        if (r12 != null) goto L36;
        return null;
    L36:
        return r12.toString();
    L7:
        th = move-exception;
        P().j("event toString failed " + r10 + ", label: " + r11, th, new Object[0]);
        JSONObject r13 = p.d(r12);
        if (r13 == null) goto L35;
        n r14 = K();
        if (r14 != null) goto L13;
    L15:
        boolean r15 = false;
    L38:
    L43:
        return r13.toString();
    L24:
        e = move-exception;
        if (r15 == true) goto L29;
        P().j("event toString OOM tag: " + r10 + ", label: " + r11, e, new Object[0]);
        return null;
    L29:
        throw new RuntimeException("event toString OOM tag: " + r10 + ", label: " + r11, e);
    L18:
        e = move-exception;
        if (r15 == true) goto L23;
        P().j("event toString stack overflow tag: " + r10 + ", label: " + r11, e, new Object[0]);
        return null;
    L23:
        throw new RuntimeException("event toString stack overflow tag: " + r10 + ", label: " + r11, e);
    L30:
        return r13.toString();
    L32:
        th = move-exception;
        throw new RuntimeException("event params exception tag: " + r10 + ", label: " + r11, th);
    L13:
        if ("local_test".equalsIgnoreCase(r14.j()) == false) goto L15;
        r15 = true;
        goto L38
    L35:
        return null;
    }

    public o1.c A() {
        return this.f1181s;
    }

    public Proxy B() {
        return this.f1182t;
    }

    public Integer C() {
        return this.M;
    }

    public boolean D() {
        return this.f1186x;
    }

    public boolean E() {
        return this.f1183u;
    }

    public c1.a F() {
        return this.f1180r;
    }

    public d1.a G() {
        return this.f1164b;
    }

    public JSONObject H() {
        return this.T;
    }

    @Nullable
    public JSONObject I() {
        if (this.f1175m != null) goto L7;
        P().c("Init first please to get header", new Object[0]);
        return null;
    L7:
        return this.f1175m.e();
    }

    public j J() {
        return this.f1179q;
    }

    public n K() {
        if (this.f1174l != null) goto L7;
        return null;
    L7:
        return this.f1174l.q();
    }

    public int L() {
        return this.f1171i;
    }

    public d1.b M() {
        return this.P;
    }

    public l N() {
        return this.N;
    }

    public JSONObject O() {
        if (this.f1174l != null) goto L7;
        P().c("call getLogback after init plz.", new Object[0]);
        return null;
    L7:
        return this.f1174l.u();
    }

    public f1.g P() {
        return this.U;
    }

    public int Q() {
        return this.K;
    }

    public com.bytedance.applog.monitor.a R() {
        return this.f1166d;
    }

    public INetworkClient S() {
        INetworkClient r10 = this.f1174l.q().u();
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f1169g;
    }

    public long T() {
        if (this.f1176n != null) goto L7;
        return 0;
    L7:
        return this.f1176n.C().m();
    }

    public c1.e U() {
        if (this.f1176n != null) goto L7;
        return null;
    L7:
        return this.f1176n.A();
    }

    public d1.c V() {
        return this.f1163a;
    }

    public String W() {
        if (this.f1175m != null) goto L5;
        return "";
    L5:
        return this.f1175m.g();
    }

    public boolean X() {
        return this.f1178p;
    }

    @Override // com.bytedance.applog.g
    public void a(@NonNull String r10, @Nullable JSONObject r11) {
        R().h(MonitorKey.event_v3, MonitorState.init);
        o0(r10, r11);
    }

    public boolean a0() {
        return this.Q;
    }

    @Override // com.bytedance.applog.g
    public String addNetCommonParams(Context r10, String r11, boolean r12, Level r13) {
        return k(r10, new StringBuilder(r11), r12, r13);
    }

    @Override // com.bytedance.applog.g
    public void b(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        this.f1177o.b(r10, r11);
        return;
    }

    public boolean b0() {
        return this.V;
    }

    @Override // com.bytedance.applog.g
    public void c(boolean r10) {
        this.f1183u = r10;
    }

    public boolean c0() {
        if (K() == null) goto L9;
        if (K().X() == false) goto L9;
        return false;
    L9:
        return this.D;
    }

    @Override // com.bytedance.applog.g
    public void d(@NonNull Context r13, @NonNull n r14) {
        monitor-enter(c.class);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r14.d()) == true) goto L35;
        if (b.c(r14.d()) == true) goto L33;
        P().e(r14.d());     // Catch: Throwable -> L36
        this.f1172j = r14.d();     // Catch: Throwable -> L36
        this.f1173k = (Application) r13.getApplicationContext();     // Catch: Throwable -> L36
        Y();     // Catch: Throwable -> L36
        if (r14.R() == true) goto L11;
    L15:
        P().p("App:{} init begin...", new Object[]{this.f1172j});     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r14.A()) == false) goto L18;
        r14.g0(b.b(this, "applog_stats"));     // Catch: Throwable -> L36
    L18:
        r0(r14);     // Catch: Throwable -> L36
        if (i0() == true) goto L21;
    L23:
        this.f1174l = new g1.b(this, this.f1173k, r14);     // Catch: Throwable -> L36
        Z();     // Catch: Throwable -> L36
        this.f1175m = new g1.c(this, this.f1174l, this.f1184v);     // Catch: Throwable -> L36
        this.f1176n = new a1.c(this, this.f1174l, this.f1175m, this.f1184v, r14.i(), this.f1165c);     // Catch: Throwable -> L36
        if (r14.Q() == false) goto L26;
        this.f1173k.registerActivityLifecycleCallbacks(this.f1177o);     // Catch: Throwable -> L36
    L26:
        this.f1171i = 1;     // Catch: Throwable -> L36
        this.f1178p = r14.a();     // Catch: Throwable -> L36
        if (this.L == null) goto L29;
        u0(this.L.longValue());     // Catch: Throwable -> L36
        this.L = null;     // Catch: Throwable -> L36
    L29:
        f1.m.f("init_end", this.f1172j);     // Catch: Throwable -> L36
        P().p("App:{} init end.", new Object[]{this.f1172j});     // Catch: Throwable -> L36
        this.f1174l.J();     // Catch: Throwable -> L36
        monitor-exit(c.class);     // Catch: Throwable -> L36
        return;
    L21:
        if (r14.S() == false) goto L23;
        this.f1166d.f(this.f1172j, r13);     // Catch: Throwable -> L36
        goto L23
    L11:
        if (r14.s() == null) goto L14;
        String r10 = this.f1172j;     // Catch: Throwable -> L36
        f1.h r11 = new f1.d(r14.s());     // Catch: Throwable -> L36
    L13:
        f1.l.g(r10, r11);     // Catch: Throwable -> L36
        goto L15
    L14:
        r10 = this.f1172j;     // Catch: Throwable -> L36
        r11 = new f1.c(this);     // Catch: Throwable -> L36
        goto L13
    L33:
        throw new IllegalStateException("The app id is init already!");     // Catch: Throwable -> L36
    L35:
        throw new IllegalStateException("App id must not be empty!");     // Catch: Throwable -> L36
    }

    public boolean d0() {
        return this.f1188z;
    }

    @Override // com.bytedance.applog.g
    public String e() {
        if (this.f1176n != null) goto L7;
        return null;
    L7:
        return String.valueOf(this.f1176n.C().i());
    }

    public boolean e0() {
        return this.C;
    }

    @Override // com.bytedance.applog.g
    public void f(Context r10) {
        if ((r10 instanceof Activity) == false) goto L5;
        m0((Activity) r10, r10.hashCode());
        return;
    L5:
        f1.g r11 = P();
        StringBuilder r12 = new StringBuilder();
        r12.append("onResume context: ");
        if (r10 != null) goto L8;
        String r13 = "null";
    L9:
        r12.append(r13);
        r11.f(r12.toString(), new Object[0]);
        return;
    L8:
        r13 = r10.getClass().getName();
        goto L9
    }

    public boolean f0() {
        return this.B;
    }

    @Override // com.bytedance.applog.g
    public void flush() {
        if (this.f1176n == null) goto L6;
        this.f1176n.L(null, true);
        return;
    }

    @Override // com.bytedance.applog.g
    public synchronized void g(h r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f1181s != null) goto L6;
        this.f1181s = new o1.c();     // Catch: Throwable -> L9
    L6:
        this.f1181s.b(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public boolean g0() {
        return this.E;
    }

    @Override // com.bytedance.applog.g
    public String getAppId() {
        return this.f1172j;
    }

    @Override // com.bytedance.applog.g
    public String getDid() {
        w0.d r10 = this.f1184v;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10.getDid();
    }

    @Override // com.bytedance.applog.g
    public String getIid() {
        w0.d r10 = this.f1184v;
        if (r10 != null) goto L5;
        return "";
    L5:
        InstallInfo r11 = r10.getInstallInfo();
        if (r11 != null) goto L8;
        return "";
    L8:
        return r11.getIid();
    }

    @Override // com.bytedance.applog.g
    public String getSessionId() {
        if (this.f1176n != null) goto L7;
        return null;
    L7:
        return this.f1176n.D();
    }

    public boolean h0() {
        return this.H;
    }

    public boolean i0() {
        return this.I;
    }

    public boolean j0() {
        return this.f1162J;
    }

    public String k(Context r10, StringBuilder r11, boolean r12, Level r13) {
        return this.f1184v.addNetCommonParams(r10, r11, r12, r13);
    }

    public boolean k0() {
        return this.f1187y;
    }

    public void l(l1.a r10) {
        if (this.f1176n != null) goto L5;
        return;
    L5:
        this.f1176n.C().a(r10);
    }

    public String m() {
        if (this.f1176n != null) goto L6;
        return null;
    L6:
        long r10 = this.f1176n.C().f59a;
        IBDAccountCallback r11 = t();
        if (r11 == null) goto L10;
        r10 = ((Long) r11.getOdinUserInfo().second).longValue();
    L10:
        return n(String.valueOf(r10));
    }

    public void m0(Activity r10, int r11) {
        if (r10 == null) goto L5;
        this.f1177o.onActivityResumed(r10);
        return;
    }

    public String n(String r10) {
        f r11 = this.f1185w;
        if (r11 == null) goto L7;
        return r11.a(r10);
    L7:
        if (this.f1175m != null) goto L9;
        return null;
    L9:
        return this.f1175m.c();
    }

    public void n0(@NonNull String r10, @Nullable Bundle r11) {
        R().h(MonitorKey.event_v3, MonitorState.init);
        JSONObject r12 = null;
        if (r11 != null) goto L21;
    L17:
        o0(r10, r12);
        return;
    L21:
    L15:
        th = th;
    L16:
        R().h(MonitorKey.event_v3, MonitorState.f_block);
        P().j("parse bundle params failed", th, new Object[0]);
        goto L17
    L5:
        if (r11.isEmpty() == true) goto L17;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L15
        Iterator<String> r14 = r11.keySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r14.hasNext() == false) goto L12;
        String r15 = r14.next();     // Catch: Throwable -> L13
        r13.put(r15, r11.get(r15));     // Catch: Throwable -> L13
        goto L9
    L12:
        r12 = r13;
    L13:
        th = th;
        r12 = r13;
        goto L16
    }

    public boolean o() {
        return this.A;
    }

    public String p() {
        return getAppId();
    }

    public void p0(l1.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.u(getAppId());
        l0(r10);
        if (this.f1176n != null) goto L7;
        this.f1165c.a(r10);
    L8:
        f1.m.e("event_receive", r10);
        return;
    L7:
        this.f1176n.M(r10);
        goto L8
    }

    @Override // com.bytedance.applog.g
    public void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13) {
        this.f1184v.putCommonParams(r10, r11, r12, r13);
    }

    public void q0(String[] r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length == 0) goto L17;
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        String r13 = r10[r12];
        r12 = r12 + 1;
        goto L7
    L10:
        if (this.f1176n != null) goto L12;
        this.f1165c.b(r10);
        return;
    L12:
        this.f1176n.N(r10);
        return;
    }

    public k1.a r() {
        return this.f1168f;
    }

    public k1.b s() {
        return this.f1167e;
    }

    public void s0(int r10) {
        this.f1171i = r10;
    }

    public IBDAccountCallback t() {
        return this.O;
    }

    public void t0(l r10) {
        this.N = r10;
    }

    @NonNull
    public String toString() {
        return "AppLogInstance{id:" + this.f1170h + ";appId:" + this.f1172j + "}@" + hashCode();
    }

    public int u() {
        return this.F;
    }

    public void u0(long r10) {
        if (this.f1176n != null) goto L5;
    L9:
        this.L = Long.valueOf(r10);
        return;
    L5:
        if (this.f1176n.C() == null) goto L9;
        if (this.f1176n.C().i() == r10) goto L11;
        this.f1176n.C().o(r10);
        return;
    }

    public int v() {
        return this.G;
    }

    public void v0() {
        if (this.f1178p == true) goto L6;
        this.f1178p = true;
        this.f1176n.T();
        P().p("System start!", new Object[0]);
        return;
    }

    public Context w() {
        return this.f1173k;
    }

    public void w0() {
        P().p("System stop!", new Object[0]);
        if (this.f1178p == false) goto L6;
        this.f1178p = false;
        return;
    }

    public l1.h x() {
        return this.f1177o.a();
    }

    public e1.b y() {
        return this.S;
    }

    public DataIsolateKey z() {
        return this.R;
    }
}
