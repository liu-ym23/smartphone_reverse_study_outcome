package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.IAbContext;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import java.util.Map;
import o1.p;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private String F;
    private PreInstallChannelCallback G;
    private ISstInfoProvider H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private a f1213J;
    private IAbContext K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private volatile IAppTraitCallback Q;
    private d R;
    private DeviceCategory S;
    private boolean T;
    private boolean U;
    private boolean V;
    private DefaultSensitiveInterceptor W;
    private boolean X;
    private boolean Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b4.a f1217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ILogger f1219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f1225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f1226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private o f1227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f1228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f1229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f1230q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f1231r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f1232s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f1233t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f1234u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Map<String, Object> f1235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Account f1236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private INetworkClient f1237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1239z;

    public interface a {
        boolean a(String[] r10);
    }

    public n(@NonNull String r10, @NonNull String r11) {
        this.f1215b = true;
        this.f1222i = false;
        this.f1224k = 0;
        this.f1239z = true;
        this.B = false;
        this.C = false;
        this.D = true;
        this.f1213J = null;
        this.K = null;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = false;
        this.T = false;
        this.U = true;
        this.V = true;
        this.X = false;
        this.Y = false;
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (TextUtils.isEmpty(r11) == true) goto L9;
        this.f1214a = r10;
        this.f1216c = r11;
        return;
    L9:
        throw new IllegalStateException("Channel must not be empty!");
    L11:
        throw new IllegalStateException("App id must not be empty!");
    }

    public String A() {
        return this.F;
    }

    public String B() {
        return this.f1229p;
    }

    public long C() {
        return this.f1231r;
    }

    public o D() {
        return this.f1227n;
    }

    public String E() {
        return this.f1228o;
    }

    public long F() {
        return this.f1230q;
    }

    public String G() {
        return this.f1233t;
    }

    public String H() {
        return this.f1234u;
    }

    public boolean I() {
        return this.B;
    }

    public boolean J() {
        return this.f1239z;
    }

    public boolean K() {
        return this.Y;
    }

    public boolean L() {
        return this.V;
    }

    public boolean M() {
        return this.D;
    }

    public boolean N() {
        return this.f1238y;
    }

    public boolean O() {
        return this.I;
    }

    public boolean P() {
        return this.O;
    }

    public boolean Q() {
        return this.C;
    }

    public boolean R() {
        return this.N;
    }

    public boolean S() {
        return this.M;
    }

    public boolean T() {
        return this.T;
    }

    public boolean U() {
        return this.U;
    }

    public boolean V() {
        return this.f1223j;
    }

    public boolean W() {
        return this.A;
    }

    public boolean X() {
        return this.P;
    }

    public boolean Y() {
        return this.L;
    }

    public n Z(String r10) {
        this.f1226m = r10;
        return this;
    }

    public boolean a() {
        return this.f1215b;
    }

    public n a0(boolean r10) {
        this.f1215b = r10;
        return this;
    }

    public IAbContext b() {
        return this.K;
    }

    public void b0(DefaultSensitiveInterceptor r10) {
        this.W = r10;
    }

    public Account c() {
        return this.f1236w;
    }

    public n c0(ILogger r10) {
        this.f1219f = r10;
        return this;
    }

    public String d() {
        return this.f1214a;
    }

    public n d0(INetworkClient r10) {
        this.f1237x = r10;
        return this;
    }

    public boolean e() {
        return this.f1221h;
    }

    @NonNull
    public n e0(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 1;
    L5:
        this.f1224k = r11;
        return this;
    L4:
        r11 = 2;
        goto L5
    }

    public String f() {
        return this.f1226m;
    }

    public void f0(ISstInfoProvider r10) {
        this.H = r10;
    }

    public IAppTraitCallback g() {
        return this.Q;
    }

    public n g0(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        this.F = r10;
    L5:
        return this;
    }

    public boolean h() {
        return this.X;
    }

    public n h0(o r10) {
        this.f1227n = r10;
        return this;
    }

    public d i() {
        return this.R;
    }

    public String j() {
        return this.f1216c;
    }

    public Map<String, Object> k() {
        return this.f1235v;
    }

    public String l() {
        if (TextUtils.isEmpty(this.E) == false) goto L7;
        return p.q(this.f1214a) + "@bd_tea_agent.db";
    L7:
        return this.E;
    }

    public DefaultSensitiveInterceptor m() {
        return this.W;
    }

    public DeviceCategory n() {
        return this.S;
    }

    public b4.a o() {
        return this.f1217d;
    }

    public a p() {
        return this.f1213J;
    }

    public String q() {
        return this.f1218e;
    }

    public boolean r() {
        return this.f1222i;
    }

    public ILogger s() {
        return this.f1219f;
    }

    public long t() {
        return this.f1232s;
    }

    public INetworkClient u() {
        return this.f1237x;
    }

    public PreInstallChannelCallback v() {
        return this.G;
    }

    public int w() {
        return this.f1224k;
    }

    public String x() {
        return this.f1220g;
    }

    public String y() {
        return this.f1225l;
    }

    public ISstInfoProvider z() {
        return this.H;
    }
}
