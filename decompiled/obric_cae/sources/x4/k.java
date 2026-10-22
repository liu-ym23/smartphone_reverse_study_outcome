package x4;

import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public c0 A;
    public boolean B;
    public final defpackage.c C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public h5.b H;
    public TelephonyManager I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f13490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f13494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b0 f13497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f13498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f13499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f13500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f13502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f13503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f13504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f13505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f13506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f13507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f13508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f13509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f13510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f13511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map<String, Object> f13512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Account f13513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13514z;

    public k() {
        this.f13514z = false;
        this.C = new defpackage.c();
        this.D = true;
        this.E = false;
        this.F = true;
        this.G = false;
    }

    public final j0 a() {
        if (this.f13498j != null) goto L5;
    L29:
        StringBuilder r8 = new StringBuilder("parameters error:");
        if (this.f13498j != null) goto L32;
        boolean r10 = true;
    L33:
        r8.append(r10);
        r8.append(", ");
        r8.append(this.f13496h);
        r8.append(", ");
        r8.append(this.f13507s);
        throw new IllegalArgumentException(r8.toString());
    L32:
        r10 = false;
        goto L33
    L5:
        if (this.f13496h <= 0) goto L29;
        if (TextUtils.isEmpty(this.f13507s) == true) goto L29;
        if (TextUtils.isEmpty(this.f13506r) == true) goto L28;
        int r11 = r.f13543a;
        if (this.f13497i == null) goto L26;
        if (this.f13490b == null) goto L24;
        if (TextUtils.isEmpty(this.f13508t) == false) goto L19;
        this.f13508t = this.f13507s;
    L19:
        if (this.I != null) goto L21;
        this.I = (TelephonyManager) this.f13498j.getSystemService("phone");
    L21:
        k5.c r12 = k5.c.b();
        int r13 = this.f13496h;
        r12.getClass();
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        r14.put("register", new b5.c());
        r14.put("activate", new b5.a());
        r14.put("params", new b5.b());
        r12.f8933a.put(String.valueOf(r13), r14);
        return new j0(this);
    L24:
        throw new IllegalArgumentException("please set event depend");
    L26:
        throw new IllegalArgumentException("please set network client");
    L28:
        throw new IllegalArgumentException("appName is empty");
    }
}
