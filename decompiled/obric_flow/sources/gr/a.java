package gr;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final double[] s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f17124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f17125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f17126c;
    public double d;
    public double e;
    public double f;
    public double g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f17127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f17128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f17129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f17130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f17131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f17132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f17133n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f17134o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double f17135p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f17136q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17137r;

    static {
        s = new double[91];
    }

    public final double a() {
        double r5 = this.f17129j * this.f17135p;
        double r10 = (-this.f17130k) * this.f17134o;
        double r11 = this.f17133n / Math.hypot(r5, r10);
        if (this.f17136q == false) goto L6;
        r5 = -r5;
    L6:
        return r5 * r11;
    }

    public final double b() {
        double r5 = this.f17129j * this.f17135p;
        double r10 = (-this.f17130k) * this.f17134o;
        double r11 = this.f17133n / Math.hypot(r5, r10);
        if (this.f17136q == false) goto L6;
        return (-r10) * r11;
    L6:
        return r10 * r11;
    }

    public final double c(double r11) {
        double r10 = (r11 - this.f17126c) * this.f17128i;
        double r5 = this.f;
        double r12 = this.e;
        return j0.a(r5, r12, r10, r12);
    }

    public final double d(double r11) {
        double r10 = (r11 - this.f17126c) * this.f17128i;
        double r5 = this.f17127h;
        double r12 = this.g;
        return j0.a(r5, r12, r10, r12);
    }

    public final double e() {
        return (this.f17129j * this.f17134o) + this.f17131l;
    }

    public final double f() {
        return (this.f17130k * this.f17135p) + this.f17132m;
    }

    public final void g(double r13) {
        if (this.f17136q == false) goto L5;
        double r5 = this.d - r13;
    L6:
        double r10 = r5 * this.f17128i;
        double r14 = 0.0d;
        if (r10 <= 0.0d) goto L13;
        r14 = 1.0d;
        if (r10 >= 1.0d) goto L13;
        double[] r15 = this.f17124a;
        double r11 = r10 * ((double) (r15.length - 1));
        int r16 = (int) r11;
        double r12 = r15[r16];
        r14 = j0.a(r15[r16 + 1], r12, r11 - ((double) r16), r12);
    L13:
        double r17 = r14 * 1.5707963267948966d;
        this.f17134o = Math.sin(r17);
        this.f17135p = Math.cos(r17);
        return;
    L5:
        r5 = r13 - this.f17126c;
        goto L6
    }
}
