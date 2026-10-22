package fr;

import com.obric.oui.constraintlayout.core.SolverVariable$Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17001c;
    public int d;
    public float e;
    public boolean f;
    public final float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f17002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable$Type f17003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b[] f17004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17006l;

    public e(SolverVariable$Type r5) {
        this.f17000b = -1;
        this.f17001c = -1;
        this.d = 0;
        this.f = false;
        this.g = new float[9];
        this.f17002h = new float[9];
        this.f17004j = new b[16];
        this.f17005k = 0;
        this.f17006l = 0;
        this.f17003i = r5;
    }

    public final void a(b r5) {
        int r10 = 0;
    L3:
        int r11 = this.f17005k;
        if (r10 >= r11) goto L9;
        if (this.f17004j[r10] == r5) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return;
    L9:
        b[] r12 = this.f17004j;
        if (r11 < r12.length) goto L12;
        this.f17004j = (b[]) Arrays.copyOf(r12, r12.length * 2);
    L12:
        b[] r13 = this.f17004j;
        int r14 = this.f17005k;
        r13[r14] = r5;
        this.f17005k = r14 + 1;
    }

    public final void b(b r5) {
        int r10 = this.f17005k;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        if (this.f17004j[r11] == r5) goto L7;
        r11 = r11 + 1;
    L7:
        if (r11 >= (r10 - 1)) goto L9;
        b[] r12 = this.f17004j;
        int r13 = r11 + 1;
        r12[r11] = r12[r13];
        r11 = r13;
        goto L7
    L9:
        this.f17005k--;
        return;
    }

    public final void c() {
        this.f17003i = SolverVariable$Type.UNKNOWN;
        this.d = 0;
        this.f17000b = -1;
        this.f17001c = -1;
        this.e = 0.0f;
        this.f = false;
        int r5 = this.f17005k;
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.f17004j[r10] = null;
        r10 = r10 + 1;
        goto L3
    L5:
        this.f17005k = 0;
        this.f17006l = 0;
        this.f16999a = false;
        Arrays.fill(this.f17002h, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        return this.f17000b - ((e) r5).f17000b;
    }

    public final void d(c r5, float r10) {
        this.e = r10;
        this.f = true;
        int r11 = this.f17005k;
        this.f17001c = -1;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f17004j[r12].h(r5, this, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f17005k = 0;
    }

    public final void e(c r5, b r10) {
        int r11 = this.f17005k;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f17004j[r12].i(r5, r10, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f17005k = 0;
    }

    public final String toString() {
        return "" + this.f17000b;
    }
}
