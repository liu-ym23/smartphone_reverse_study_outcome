package s;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public float f11925s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f11926t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f11927u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public d f11928v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f11929w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f11930x0;

    public h() {
        this.f11925s0 = -1.0f;
        this.f11926t0 = -1;
        this.f11927u0 = -1;
        this.f11928v0 = this.L;
        int r8 = 0;
        this.f11929w0 = 0;
        this.T.clear();
        this.T.add(this.f11928v0);
        int r10 = this.S.length;
    L3:
        if (r8 >= r10) goto L5;
        this.S[r8] = this.f11928v0;
        r8 = r8 + 1;
        goto L3
    }

    @Override // s.e
    public final boolean A() {
        return this.f11930x0;
    }

    @Override // s.e
    public final boolean B() {
        return this.f11930x0;
    }

    @Override // s.e
    public final void P(p.d r8, boolean r10) {
        if (this.W != null) goto L5;
        return;
    L5:
        d r11 = this.f11928v0;
        r8.getClass();
        int r12 = p.d.o(r11);
        if (this.f11929w0 != 1) goto L8;
        this.f11851b0 = r12;
        this.f11853c0 = 0;
        K(this.W.l());
        N(0);
        return;
    L8:
        this.f11851b0 = 0;
        this.f11853c0 = r12;
        N(this.W.q());
        K(0);
    }

    public final void Q(int r8) {
        if (this.f11929w0 != r8) goto L5;
        return;
    L5:
        this.f11929w0 = r8;
        ArrayList<d> r10 = this.T;
        r10.clear();
        if (this.f11929w0 != 1) goto L8;
        d r11 = this.K;
    L9:
        this.f11928v0 = r11;
        r10.add(this.f11928v0);
        d[] r12 = this.S;
        int r13 = r12.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L12;
        r12[r14] = this.f11928v0;
        r14 = r14 + 1;
        goto L10
    L12:
        return;
    L8:
        r11 = this.L;
        goto L9
    }

    @Override // s.e
    public final void c(p.d r8, boolean r10) {
        f r11 = (f) this.W;
        if (r11 != null) goto L5;
        return;
    L5:
        Object r12 = r11.j(d.a.f11839a);
        Object r13 = r11.j(d.a.f11841m);
        e r14 = this.W;
        boolean r15 = true;
        if (r14 != null) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (this.f11929w0 != 0) goto L21;
        r12 = r11.j(d.a.f11840b);
        r13 = r11.j(d.a.f11842n);
        e r17 = this.W;
        if (r17 != null) goto L16;
    L18:
        r15 = false;
    L19:
        r16 = r15;
        goto L21
    L16:
        if (r17.V[1] != e.a.f11892b) goto L18;
    L21:
        if (this.f11930x0 == false) goto L35;
        d r18 = this.f11928v0;
        if (r18.f11832c == false) goto L35;
        p.h r19 = r8.l(r18);
        r8.d(r19, this.f11928v0.d());
        if (this.f11926t0 == (-1)) goto L29;
        if (r16 == false) goto L32;
        r8.f(r8.l(r13), r19, 0, 5);
    L32:
        this.f11930x0 = false;
        return;
    L29:
        if (this.f11927u0 == (-1)) goto L32;
        if (r16 == false) goto L32;
        p.h r20 = r8.l(r13);
        r8.f(r19, r8.l(r12), 0, 5);
        r8.f(r20, r19, 0, 5);
    L35:
        if (this.f11926t0 == (-1)) goto L40;
        p.h r21 = r8.l(this.f11928v0);
        r8.e(r21, r8.l(r12), this.f11926t0, 8);
        if (r16 == false) goto L48;
        r8.f(r8.l(r13), r21, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.f11927u0 == (-1)) goto L45;
        p.h r22 = r8.l(this.f11928v0);
        p.h r23 = r8.l(r13);
        r8.e(r22, r23, -this.f11927u0, 8);
        if (r16 == false) goto L50;
        r8.f(r22, r8.l(r12), 0, 5);
        r8.f(r23, r22, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f11925s0 == (-1.0f)) goto L52;
        p.h r24 = r8.l(this.f11928v0);
        p.h r25 = r8.l(r13);
        float r26 = this.f11925s0;
        p.b r27 = r8.m();
        r27.f9864d.e(r24, -1.0f);
        r27.f9864d.e(r25, r26);
        r8.c(r27);
        return;
    L52:
        return;
    L8:
        if (r14.V[0] != e.a.f11892b) goto L10;
        r16 = true;
        goto L12
    }

    @Override // s.e
    public final boolean d() {
        return true;
    }

    @Override // s.e
    public final d j(d.a r8) {
        int r10 = r8.ordinal();
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L16;
        if (r10 == 4) goto L12;
        return null;
    L12:
        if (this.f11929w0 == 0) goto L14;
        return null;
    L14:
        return this.f11928v0;
    L16:
        if (this.f11929w0 == 1) goto L18;
        return null;
    L18:
        return this.f11928v0;
    }
}
