package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public float f17456u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f17457v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f17458w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public d f17459x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f17460y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f17461z0;

    public k() {
        this.f17456u0 = -1.0f;
        this.f17457v0 = -1;
        this.f17458w0 = -1;
        this.f17459x0 = this.K;
        int r5 = 0;
        this.f17460y0 = 0;
        this.S.clear();
        this.S.add(this.f17459x0);
        int r10 = this.R.length;
    L3:
        if (r5 >= r10) goto L5;
        this.R[r5] = this.f17459x0;
        r5 = r5 + 1;
        goto L3
    }

    @Override // hr.f
    public final boolean B() {
        return this.f17461z0;
    }

    @Override // hr.f
    public final boolean C() {
        return this.f17461z0;
    }

    @Override // hr.f
    public final void R(fr.c r5, boolean r10) {
        if (this.V != null) goto L5;
        return;
    L5:
        d r11 = this.f17459x0;
        r5.getClass();
        int r12 = fr.c.n(r11);
        if (this.f17460y0 != 1) goto L8;
        this.f17395a0 = r12;
        this.f17397b0 = 0;
        M(this.V.l());
        P(0);
        return;
    L8:
        this.f17395a0 = 0;
        this.f17397b0 = r12;
        P(this.V.r());
        M(0);
    }

    public final void S(int r5) {
        this.f17459x0.l(r5);
        this.f17461z0 = true;
    }

    public final void T(int r5) {
        if (this.f17460y0 != r5) goto L5;
        return;
    L5:
        this.f17460y0 = r5;
        ArrayList r10 = this.S;
        r10.clear();
        if (this.f17460y0 != 1) goto L8;
        this.f17459x0 = this.J;
    L9:
        r10.add(this.f17459x0);
        d[] r11 = this.R;
        int r12 = r11.length;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L12;
        r11[r13] = this.f17459x0;
        r13 = r13 + 1;
        goto L10
    L12:
        return;
    L8:
        this.f17459x0 = this.K;
        goto L9
    }

    @Override // hr.f
    public final void b(fr.c r10, boolean r11) {
        g r12 = (g) this.V;
        if (r12 != null) goto L5;
        return;
    L5:
        Object r5 = r12.j(ConstraintAnchor$Type.LEFT);
        Object r13 = r12.j(ConstraintAnchor$Type.RIGHT);
        f r14 = this.V;
        boolean r15 = true;
        if (r14 != null) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (this.f17460y0 != 0) goto L21;
        r5 = r12.j(ConstraintAnchor$Type.TOP);
        r13 = r12.j(ConstraintAnchor$Type.BOTTOM);
        f r17 = this.V;
        if (r17 != null) goto L16;
    L18:
        r15 = false;
    L19:
        r16 = r15;
        goto L21
    L16:
        if (r17.U[1] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.f17461z0 == false) goto L35;
        d r18 = this.f17459x0;
        if (r18.f17389c == false) goto L35;
        fr.e r19 = r10.k(r18);
        r10.d(r19, this.f17459x0.d());
        if (this.f17457v0 == (-1)) goto L29;
        if (r16 == false) goto L32;
        r10.f(r10.k(r13), r19, 0, 5);
    L32:
        this.f17461z0 = false;
        return;
    L29:
        if (this.f17458w0 == (-1)) goto L32;
        if (r16 == false) goto L32;
        fr.e r20 = r10.k(r13);
        r10.f(r19, r10.k(r5), 0, 5);
        r10.f(r20, r19, 0, 5);
    L35:
        if (this.f17457v0 == (-1)) goto L40;
        fr.e r21 = r10.k(this.f17459x0);
        r10.e(r21, r10.k(r5), this.f17457v0, 8);
        if (r16 == false) goto L48;
        r10.f(r10.k(r13), r21, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.f17458w0 == (-1)) goto L45;
        fr.e r22 = r10.k(this.f17459x0);
        fr.e r23 = r10.k(r13);
        r10.e(r22, r23, -this.f17458w0, 8);
        if (r16 == false) goto L50;
        r10.f(r22, r10.k(r5), 0, 5);
        r10.f(r23, r22, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f17456u0 == (-1.0f)) goto L52;
        fr.e r24 = r10.k(this.f17459x0);
        fr.e r25 = r10.k(r13);
        float r26 = this.f17456u0;
        fr.b r27 = r10.l();
        r27.d.g(r24, -1.0f);
        r27.d.g(r25, r26);
        r10.c(r27);
        return;
    L52:
        return;
    L8:
        if (r14.U[0] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L10;
        r16 = true;
        goto L12
    }

    @Override // hr.f
    public final boolean c() {
        return true;
    }

    @Override // hr.f
    public final void g(f r5, HashMap r10) {
        super.g(r5, r10);
        k r11 = (k) r5;
        this.f17456u0 = r11.f17456u0;
        this.f17457v0 = r11.f17457v0;
        this.f17458w0 = r11.f17458w0;
        T(r11.f17460y0);
    }

    @Override // hr.f
    public final d j(ConstraintAnchor$Type r5) {
        int r10 = j.f17455a[r5.ordinal()];
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L12;
        if (r10 == 4) goto L12;
        return null;
    L12:
        if (this.f17460y0 == 0) goto L14;
        return null;
    L14:
        return this.f17459x0;
    L16:
        if (this.f17460y0 == 1) goto L18;
        return null;
    L18:
        return this.f17459x0;
    }
}
