package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7821l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7822m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7823n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7824o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7825p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f7826q;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0138a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f7827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f7830d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f7831e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f7832f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f7833g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f7834h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f7835i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f7836j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f7837k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f7838l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f7839m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f7840n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f7841o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f7842p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f7843q;

        public b(Context r10) {
            this.f7828b = 14;
            this.f7829c = 20971520;
            this.f7830d = 0.1f;
            this.f7831e = 2097152;
            this.f7834h = true;
            this.f7835i = true;
            this.f7836j = 3;
            this.f7837k = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.f7838l = true;
            this.f7839m = false;
            this.f7840n = false;
            this.f7841o = false;
            this.f7842p = false;
            this.f7843q = 256;
            if (r10 == null) goto L10;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L7;
            r10 = r11;
        L7:
            this.f7827a = r10;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public a a() {
            a r10 = new a(null);
            r10.u(this.f7827a);
            r10.A(this.f7828b);
            r10.C(this.f7829c);
            r10.H(this.f7830d);
            r10.F(this.f7831e);
            if (TextUtils.isEmpty(this.f7832f) == false) goto L5;
            String r11 = xa.a.a(this.f7827a);
        L6:
            r10.r(r11);
            if (TextUtils.isEmpty(this.f7833g) == false) goto L9;
            String r12 = xa.a.b(this.f7827a).getAbsolutePath();
        L10:
            r10.z(r12);
            r10.t(this.f7834h);
            r10.x(this.f7835i);
            r10.y(this.f7836j);
            r10.G(this.f7837k);
            r10.B(this.f7838l);
            r10.E(this.f7839m);
            r10.v(this.f7840n);
            r10.w(this.f7842p);
            r10.D(this.f7841o);
            r10.s(this.f7843q);
            return r10;
        L9:
            r12 = this.f7833g;
            goto L10
        L5:
            r11 = this.f7832f;
            goto L6
        }

        public b b(boolean r10) {
            this.f7834h = r10;
            return this;
        }

        public b c(boolean r10) {
            this.f7835i = r10;
            return this;
        }

        public b d(int r10) {
            this.f7836j = r10;
            return this;
        }

        public b e(String r10) {
            this.f7833g = r10;
            return this;
        }

        public b f(int r10) {
            this.f7829c = r10;
            return this;
        }

        public b g(boolean r10) {
            this.f7841o = r10;
            return this;
        }

        public b h(boolean r10) {
            this.f7839m = r10;
            return this;
        }

        public b i(int r10) {
            this.f7831e = r10;
            return this;
        }
    }

    private a() {
    }

    /* synthetic */ a(C0138a r10) {
        this();
    }

    public void A(int r10) {
        this.f7811b = r10;
    }

    public void B(boolean r10) {
        this.f7820k = r10;
    }

    public void C(int r10) {
        this.f7812c = r10;
    }

    public void D(boolean r10) {
        this.f7823n = r10;
    }

    public void E(boolean r10) {
        this.f7821l = r10;
    }

    public void F(int r10) {
        this.f7813d = r10;
    }

    public void G(String r10) {
        this.f7819j = r10;
    }

    public void H(float r10) {
        this.f7826q = r10;
    }

    public boolean a() {
        return this.f7822m;
    }

    public boolean b() {
        return this.f7824o;
    }

    public String c() {
        return this.f7814e;
    }

    public int d() {
        return this.f7825p;
    }

    public Context e() {
        return this.f7810a;
    }

    public int f() {
        return this.f7818i;
    }

    public String g() {
        return this.f7815f;
    }

    public int h() {
        return this.f7811b;
    }

    public int i() {
        return this.f7812c;
    }

    public int j() {
        return this.f7813d;
    }

    public String k() {
        return this.f7819j;
    }

    public float l() {
        return this.f7826q;
    }

    public boolean m() {
        return this.f7816g;
    }

    public boolean n() {
        return this.f7817h;
    }

    public boolean o() {
        return this.f7820k;
    }

    public boolean p() {
        return this.f7823n;
    }

    public boolean q() {
        return this.f7821l;
    }

    public void r(String r10) {
        this.f7814e = r10;
    }

    public void s(int r10) {
        this.f7825p = r10;
    }

    public void t(boolean r10) {
        this.f7816g = r10;
    }

    public void u(Context r10) {
        this.f7810a = r10;
    }

    public void v(boolean r10) {
        this.f7822m = r10;
    }

    public void w(boolean r10) {
        this.f7824o = r10;
    }

    public void x(boolean r10) {
        this.f7817h = r10;
    }

    public void y(int r10) {
        this.f7818i = r10;
    }

    public void z(String r10) {
        this.f7815f = r10;
    }
}
