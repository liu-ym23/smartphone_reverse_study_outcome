package x4;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    public final boolean A;
    public final z B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final h5.b H;
    public final TelephonyManager I;
    public boolean J;
    public SharedPreferences K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f13464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f13473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Object> f13474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f13475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f13476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final y f13478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0 f13479q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f13480r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final defpackage.c f13481s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f13482t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f13483u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Account f13484v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w f13485w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f13486x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f13487y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13488z;

    public j0(k r8) {
        this.K = null;
        this.f13465c = r8.f13498j;
        this.f13463a = r8.f13496h;
        b0 r10 = r8.f13497i;
        if (r10 != null) goto L6;
        r10 = new androidx.lifecycle.s(6);
    L6:
        this.f13464b = r10;
        if (TextUtils.isEmpty(r8.f13499k) == false) goto L9;
        String r11 = "applog_stats";
    L10:
        this.f13466d = r11;
        this.f13467e = r8.f13500l;
        this.f13468f = r8.f13506r;
        this.f13469g = r8.f13507s;
        this.f13470h = r8.f13508t;
        this.f13471i = r8.f13509u;
        this.f13472j = r8.f13510v;
        this.f13473k = r8.f13511w;
        this.f13474l = r8.f13512x;
        this.f13485w = r8.f13494f;
        this.f13486x = r8.f13495g;
        this.f13487y = r8.f13493e;
        this.f13475m = r8.f13492d;
        this.f13488z = r8.f13491c;
        this.A = true;
        this.B = r8.f13490b;
        this.C = r8.f13489a;
        this.f13476n = new g(r8);
        this.f13484v = r8.f13513y;
        this.f13477o = r8.f13514z;
        this.f13478p = new y.a();
        this.f13479q = r8.A;
        this.f13480r = r8.B;
        this.D = true;
        this.f13481s = r8.C;
        this.f13482t = r8.D;
        this.f13483u = r8.E;
        this.E = r8.F;
        this.F = true;
        this.G = r8.G;
        r8.getClass();
        h5.b r12 = r8.H;
        this.I = r8.I;
        if (r12 == null) goto L13;
        this.H = r12;
        r12.f7907c = this;
        return;
    L13:
        h5.b r13 = new h5.b();
        this.H = r13;
        r13.f7907c = this;
        return;
    L9:
        r11 = r8.f13499k;
        goto L10
    }

    public final String a() {
        return String.valueOf(this.f13463a);
    }

    public final SharedPreferences b() {
        if (this.K != null) goto L10;
        boolean r8 = this.J;
        String r10 = this.f13466d;
        if (r8 == true) goto L8;
        r10 = r10 + "_" + this.f13463a;
    L8:
        this.K = this.f13465c.getSharedPreferences(r10, 0);
    L10:
        return this.K;
    }

    public final String c() {
        g r8 = this.f13476n;
        String r10 = r8.f13419a;
        if (TextUtils.isEmpty(r10) == false) goto L8;
        g.a r11 = r8.f13425g;
        PackageInfo r12 = r11.b(new Object[0]);
        if (r12 != null) goto L7;
        return r10;
    L7:
        return r12.versionName;
    L8:
        return r10;
    }

    public final long d() {
        g r8 = this.f13476n;
        long r10 = r8.f13421c;
        if (r10 != 0) goto L8;
        PackageInfo r11 = r8.f13425g.b(new Object[0]);
        if (r11 != null) goto L7;
        return r10;
    L7:
        return r11.versionCode;
    L8:
        return r10;
    }
}
