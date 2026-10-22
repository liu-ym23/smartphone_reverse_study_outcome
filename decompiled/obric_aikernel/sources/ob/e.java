package ob;

import android.net.TrafficStats;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e extends f {
    private long A;
    private long B;
    private double C;
    private long D;
    private double E;
    private long F;
    private int G;
    private double H;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f11631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f11632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final float f11633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f11634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f11635r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f11636s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f11637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final nb.d f11638u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final nb.d f11639v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f11640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f11641x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f11642y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double f11643z;

    public e(InputStream r10, float r11, float r12) {
        super(r10);
        this.f11631n = 0.1f;
        this.f11632o = 0.7f;
        this.f11634q = 0.1f;
        this.f11635r = 0.1f;
        this.f11636s = 1000;
        this.f11637t = 2000;
        this.f11638u = new nb.d(0.1d);
        this.f11639v = new nb.d(0.1d);
        this.G = 60;
        if (r11 < r12) goto L5;
    L9:
        if (r11 < r12) goto L11;
    L15:
        this.f11633p = (this.f11631n + this.f11632o) / 2.0f;
        return;
    L11:
        if (r12 <= 0.0f) goto L15;
        if (r12 > 1.0f) goto L15;
        this.f11632o = r12;
        goto L15
    L5:
        if (r11 < 0.0f) goto L9;
        if (r11 >= 1.0f) goto L9;
        this.f11631n = r11;
        goto L9
    }

    private void f(float r10) {
        if (r10 <= 0.0f) goto L8;
        if (this.f11634q < this.f11632o) goto L12;
        r10 = -this.f11635r;
    L12:
        float r11 = this.f11634q + r10;
        this.f11634q = r11;
        if (r10 <= 0.0f) goto L15;
        float r12 = Math.min(r11, this.f11632o);
    L16:
        this.f11634q = r12;
        return;
    L15:
        r12 = Math.max(this.f11631n, r11);
        goto L16
    L8:
        if (r10 >= 0.0f) goto L12;
        if (this.f11634q > this.f11631n) goto L12;
        r10 = this.f11635r;
        goto L12
    }

    private int i(double r10, double r11, double r12) {
        double r13 = r12 + this.H;
        this.H = 0.0d;
        int r14 = this.G;
        if (r13 < r14) goto L6;
        return -1;
    L6:
        if (r13 >= (-r14)) goto L8;
        return -1;
    L8:
        this.H = r13;
        if (r13 <= ((-r14) / 2.0f)) goto L12;
        return 1;
    L12:
        return 0;
    }

    private void k() {
        if (this.f11634q <= this.f11633p) goto L5;
        float r10 = (-this.f11635r) * 2.0f;
    L6:
        f(r10);
        return;
    L5:
        r10 = -this.f11635r;
        goto L6
    }

    private void l() {
        if (this.f11634q >= this.f11633p) goto L5;
        float r10 = this.f11635r * 2.0f;
    L6:
        f(r10);
        return;
    L5:
        r10 = this.f11635r;
        goto L6
    }

    private void o(long r10) {
        long r11 = this.f11640w;
        if ((r10 - r11) < this.f11636s) goto L12;
        double r12 = r10 - r11;
        if (r11 > 0) goto L7;
    L10:
        this.f11640w = r10;
        this.A = TrafficStats.getTotalRxBytes();
        this.f11641x = this.f11642y;
        return;
    L7:
        if (r12 <= 0.0d) goto L10;
        this.f11640w = r10;
        long r13 = TrafficStats.getTotalRxBytes();
        this.B = r13;
        long r14 = this.f11642y;
        long r15 = r14 - this.f11641x;
        long r16 = r13 - this.A;
        this.f11641x = r14;
        this.A = r13;
        this.f11638u.a(r15 / r12);
        this.f11639v.a(r16 / r12);
        return;
    }

    private void p(long r14) {
        long r10 = this.D;
        if ((r14 - r10) < this.f11637t) goto L18;
        this.D = r14;
        if (r10 != 0) goto L7;
        return;
    L7:
        double r15 = this.f11638u.b();
        double r11 = this.f11639v.b();
        double r12 = r11 - r15;
        double r13 = r15 - this.f11643z;
        double r16 = r11 - this.C;
        double r17 = r12 - this.E;
        this.f11643z = r15;
        this.C = r11;
        this.E = r12;
        int r18 = i(r13, r16, r17);
        if (r18 <= 0) goto L10;
        l();
        return;
    L10:
        if (r18 >= 0) goto L13;
        k();
        return;
    L13:
        if (this.f11634q >= this.f11633p) goto L15;
        float r19 = this.f11635r;
    L16:
        f(r19);
        return;
    L15:
        r19 = -this.f11635r;
        goto L16
    }

    @Override // ob.f, java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (this.f11645g != (-1)) goto L27;
        long r13 = System.currentTimeMillis();
        if ((r13 - this.f11650l) <= this.f11647i) goto L22;
        this.f11650l = r13;
        o(r13);
        p(r13);
        long r14 = (long) (this.f11647i * ((double) (1.0f - this.f11634q)));
        long r15 = this.F;
        if (r15 < r14) goto L10;
        this.F = r15 - r14;
        goto L22
    L10:
        if (r15 <= 0) goto L13;
        r14 = r14 - r15;
        this.F = 0;
    L13:
        if (r14 <= 0) goto L22;
        long r16 = System.currentTimeMillis();
        Thread.sleep(r14);     // Catch: InterruptedException -> L19
        long r17 = (System.currentTimeMillis() - r16) - r14;
        if (r17 <= 0) goto L22;
        this.F = r17;
    L19:
        e = move-exception;
        throw new IOException(e);
    L22:
        int r18 = c(r10, r11, r12);
        if (r18 == (-1)) goto L25;
        this.f11642y += (long) r18;
    L25:
        return r18;
    L27:
        return super.read(r10, r11, r12);
    }
}
