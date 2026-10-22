package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import com.bytedance.bdinstall.IAbContext;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String F;
    private String G;
    private PreInstallChannelCallback H;
    private ISstInfoProvider I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f1734J;
    private boolean K;
    private boolean L;
    private a M;
    private IAbContext N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private volatile IAppTraitCallback S;
    private c T;
    private DeviceCategory U;
    private boolean V;
    private boolean W;
    private boolean X;
    private DefaultSensitiveInterceptor Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1736b;
    private String c;
    private com.bytedance.mpaas.a d;
    private String e;
    private ILogger f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private String l;
    private String m;
    private p n;
    private String o;
    private String p;
    private long q;
    private long r;
    private long s;
    private String t;
    private String u;
    private String v;
    private Map<String, Object> w;
    private Account x;
    private INetworkClient y;
    private boolean z;

    public interface a {
        boolean a(String[] r1);
    }

    public o(String r4, String r5) {
        this.f1736b = true;
        this.i = false;
        this.k = 0;
        this.A = true;
        this.C = false;
        this.D = false;
        this.E = true;
        this.f1734J = true;
        this.K = true;
        this.M = null;
        this.N = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.V = false;
        this.W = true;
        this.X = true;
        if (TextUtils.isEmpty(r4) == true) goto L11;
        if (TextUtils.isEmpty(r5) == true) goto L9;
        this.f1735a = r4;
        this.c = r5;
        return;
    L9:
        throw new IllegalStateException("Channel must not be empty!");
    L11:
        throw new IllegalStateException("App id must not be empty!");
    }

    public boolean A() {
        return this.B;
    }

    public boolean B() {
        return this.A;
    }

    public boolean C() {
        return this.D;
    }

    public boolean D() {
        return this.E;
    }

    public String E() {
        if (TextUtils.isEmpty(this.F) == false) goto L7;
        return com.bytedance.applog.util.o.a(this.f1735a) + "@bd_tea_agent.db";
    L7:
        return this.F;
    }

    public String F() {
        return this.G;
    }

    public IAbContext G() {
        return this.N;
    }

    public PreInstallChannelCallback H() {
        return this.H;
    }

    public ISstInfoProvider I() {
        return this.I;
    }

    public boolean J() {
        return this.L;
    }

    public a K() {
        return this.M;
    }

    public IAppTraitCallback L() {
        return this.S;
    }

    public c M() {
        return this.T;
    }

    public boolean N() {
        return this.z;
    }

    public boolean O() {
        return this.P;
    }

    public boolean P() {
        return this.Q;
    }

    public boolean Q() {
        return this.R;
    }

    public DeviceCategory R() {
        return this.U;
    }

    public boolean S() {
        return this.V;
    }

    public boolean T() {
        return this.W;
    }

    public boolean U() {
        return this.X;
    }

    public DefaultSensitiveInterceptor V() {
        return this.Y;
    }

    public o a(long r1) {
        this.q = r1;
        return this;
    }

    public o a(p r1) {
        this.n = r1;
        return this;
    }

    public o a(INetworkClient r3) {
        this.y = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClient.class, "com.obric.memorydata.plugin");
        return this;
    }

    public o a(String r1) {
        this.m = r1;
        return this;
    }

    public o a(Map<String, Object> r3) {
        this.w = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return this;
    }

    public o a(boolean r1) {
        this.f1736b = r1;
        return this;
    }

    public ILogger a() {
        return this.f;
    }

    public void a(ISstInfoProvider r3) {
        this.I = (ISstInfoProvider) ZeusTransformUtils.wrapperContextForParams(r3, ISstInfoProvider.class, "com.obric.memorydata.plugin");
    }

    public void a(DefaultSensitiveInterceptor r1) {
        this.Y = r1;
    }

    public o b(long r1) {
        this.r = r1;
        return this;
    }

    public o b(String r1) {
        this.o = r1;
        return this;
    }

    public o b(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 1;
    L5:
        this.k = r2;
        return this;
    L4:
        r2 = 2;
        goto L5
    }

    public boolean b() {
        return this.f1736b;
    }

    public o c(long r1) {
        this.s = r1;
        return this;
    }

    public o c(String r1) {
        this.t = r1;
        return this;
    }

    public String c() {
        return this.l;
    }

    public void c(boolean r1) {
        this.A = r1;
    }

    public o d(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.G = r2;
    L5:
        return this;
    }

    public Map<String, Object> d() {
        return this.w;
    }

    public void d(boolean r1) {
        this.D = r1;
    }

    public void e(boolean r1) {
        this.L = r1;
    }

    public boolean e() {
        return this.j;
    }

    public o f(boolean r1) {
        this.P = r1;
        return this;
    }

    public String f() {
        return this.f1735a;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.g;
    }

    public int j() {
        return this.k;
    }

    public boolean k() {
        return this.C;
    }

    public p l() {
        return this.n;
    }

    public com.bytedance.mpaas.a m() {
        return this.d;
    }

    public boolean n() {
        return this.h;
    }

    public boolean o() {
        return this.i;
    }

    public Account p() {
        return this.x;
    }

    public INetworkClient q() {
        return this.y;
    }

    public String r() {
        return this.m;
    }

    public String s() {
        return this.o;
    }

    public String t() {
        return this.p;
    }

    public boolean u() {
        return this.O;
    }

    public long v() {
        return this.q;
    }

    public long w() {
        return this.r;
    }

    public long x() {
        return this.s;
    }

    public String y() {
        return this.u;
    }

    public String z() {
        return this.v;
    }
}
