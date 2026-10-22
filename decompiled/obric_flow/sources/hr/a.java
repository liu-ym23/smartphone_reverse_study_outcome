package hr;

import ai.j0;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends l {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f17369w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f17370x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f17371y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f17372z0;

    public a() {
        this.f17369w0 = 0;
        this.f17370x0 = true;
        this.f17371y0 = 0;
        this.f17372z0 = false;
    }

    @Override // hr.f
    public final boolean B() {
        return this.f17372z0;
    }

    @Override // hr.f
    public final boolean C() {
        return this.f17372z0;
    }

    public final boolean V() {
        int r5 = 0;
        boolean r10 = true;
        int r11 = 0;
    L3:
        int r12 = this.f17463v0;
        if (r11 >= r12) goto L23;
        f r13 = this.f17462u0[r11];
        if (this.f17370x0 == false) goto L8;
    L10:
        int r14 = this.f17369w0;
        if (r14 == 0) goto L14;
        if (r14 == 1) goto L14;
    L16:
        int r15 = this.f17369w0;
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L20;
    L22:
        r11 = r11 + 1;
    L20:
        if (r13.C() == true) goto L22;
    L15:
        r10 = false;
    L14:
        if (r13.B() == true) goto L16;
    L8:
        if (r13.c() == true) goto L10;
    L23:
        if (r10 == false) goto L62;
        if (r12 <= 0) goto L62;
        int r16 = 0;
        boolean r17 = false;
    L27:
        if (r5 >= this.f17463v0) goto L54;
        f r18 = this.f17462u0[r5];
        if (this.f17370x0 == false) goto L31;
    L33:
        if (r17 == true) goto L44;
        int r19 = this.f17369w0;
        if (r19 != 0) goto L37;
        r16 = r18.j(ConstraintAnchor$Type.LEFT).d();
    L43:
        r17 = true;
        goto L44
    L37:
        if (r19 != 1) goto L39;
        r16 = r18.j(ConstraintAnchor$Type.RIGHT).d();
        goto L43
    L39:
        if (r19 != 2) goto L41;
        r16 = r18.j(ConstraintAnchor$Type.TOP).d();
        goto L43
    L41:
        if (r19 != 3) goto L43;
        r16 = r18.j(ConstraintAnchor$Type.BOTTOM).d();
    L44:
        int r20 = this.f17369w0;
        if (r20 != 0) goto L47;
        r16 = Math.min(r16, r18.j(ConstraintAnchor$Type.LEFT).d());
    L53:
        r5 = r5 + 1;
        goto L27
    L47:
        if (r20 != 1) goto L49;
        r16 = Math.max(r16, r18.j(ConstraintAnchor$Type.RIGHT).d());
        goto L53
    L49:
        if (r20 != 2) goto L51;
        r16 = Math.min(r16, r18.j(ConstraintAnchor$Type.TOP).d());
        goto L53
    L51:
        if (r20 != 3) goto L53;
        r16 = Math.max(r16, r18.j(ConstraintAnchor$Type.BOTTOM).d());
        goto L53
    L31:
        if (r18.c() == true) goto L33;
    L54:
        int r21 = r16 + this.f17371y0;
        int r22 = this.f17369w0;
        if (r22 == 0) goto L59;
        if (r22 == 1) goto L59;
        L(r21, r21);
    L60:
        this.f17372z0 = true;
        return true;
    L59:
        K(r21, r21);
    L62:
        return false;
    }

    public final int W() {
        int r5 = this.f17369w0;
        if (r5 != 0) goto L5;
        return 0;
    L5:
        if (r5 != 1) goto L7;
        return 0;
    L7:
        if (r5 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r5 == 3) goto L12;
        return -1;
    }

    @Override // hr.f
    public final void b(fr.c r17, boolean r18) {
        d[] r5 = this.R;
        d r10 = this.J;
        r5[0] = r10;
        d r11 = this.K;
        int r12 = 2;
        r5[2] = r11;
        d r13 = this.L;
        r5[1] = r13;
        d r14 = this.M;
        r5[3] = r14;
        int r15 = 0;
    L4:
        if (r15 >= r5.length) goto L6;
        d r16 = r5[r15];
        r16.f17391i = r17.k(r16);
        r15 = r15 + 1;
        goto L4
    L6:
        int r19 = this.f17369w0;
        if (r19 >= 0) goto L9;
        return;
    L9:
        if (r19 >= 4) goto L128;
        d r20 = r5[r19];
        if (this.f17372z0 == true) goto L14;
        V();
    L14:
        if (this.f17372z0 == false) goto L24;
        this.f17372z0 = false;
        int r21 = this.f17369w0;
        if (r21 == 0) goto L22;
        if (r21 == 1) goto L22;
        if (r21 == 2) goto L21;
        if (r21 == 3) goto L21;
        return;
    L21:
        r17.d(r11.f17391i, this.f17397b0);
        r17.d(r14.f17391i, this.f17397b0);
        return;
    L22:
        r17.d(r10.f17391i, this.f17395a0);
        r17.d(r13.f17391i, this.f17395a0);
        return;
    L24:
        int r110 = 0;
    L26:
        if (r110 >= this.f17463v0) goto L52;
        f r111 = this.f17462u0[r110];
        if (this.f17370x0 == false) goto L30;
    L32:
        int r112 = this.f17369w0;
        if (r112 == 0) goto L36;
        if (r112 == 1) goto L36;
    L42:
        if (r112 == 2) goto L45;
        if (r112 == 3) goto L45;
    L51:
        r110 = r110 + 1;
    L45:
        if (r111.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L51;
        if (r111.K.f == null) goto L51;
        if (r111.M.f == null) goto L51;
    L41:
        boolean r113 = true;
    L54:
        if (r10.g() == false) goto L56;
    L59:
        boolean r114 = true;
    L61:
        if (r11.g() == false) goto L63;
    L66:
        boolean r115 = true;
    L67:
        if (r113 == true) goto L78;
        int r116 = this.f17369w0;
        if (r116 != 0) goto L71;
        if (r114 == false) goto L71;
    L77:
        int r117 = 5;
    L79:
        int r118 = 0;
    L81:
        if (r118 >= this.f17463v0) goto L100;
        f r119 = this.f17462u0[r118];
        if (this.f17370x0 == false) goto L85;
    L87:
        fr.e r120 = r17.k(r119.R[this.f17369w0]);
        int r121 = this.f17369w0;
        d r122 = r119.R[r121];
        r122.f17391i = r120;
        d r123 = r122.f;
        if (r123 != null) goto L90;
    L92:
        int r124 = 0;
    L93:
        if (r121 == 0) goto L97;
        if (r121 == r12) goto L97;
        fr.e r125 = r20.f17391i;
        int r126 = this.f17371y0 + r124;
        fr.b r22 = r17.l();
        fr.e r23 = r17.m();
        r23.d = 0;
        r22.b(r125, r120, r23, r126);
        r17.c(r22);
    L98:
        r17.e(r20.f17391i, r120, this.f17371y0 + r124, r117);
    L99:
        r118 = r118 + 1;
        r12 = 2;
    L97:
        fr.e r24 = r20.f17391i;
        int r25 = this.f17371y0 - r124;
        fr.b r127 = r17.l();
        fr.e r128 = r17.m();
        r128.d = 0;
        r127.c(r24, r120, r128, r25);
        r17.c(r127);
        goto L98
    L90:
        if (r123.d != this) goto L92;
        r124 = r122.g;
        goto L93
    L85:
        if (r119.c() == true) goto L87;
    L100:
        int r26 = this.f17369w0;
        if (r26 != 0) goto L104;
        r17.e(r13.f17391i, r10.f17391i, 0, 8);
        r17.e(r10.f17391i, this.V.L.f17391i, 0, 4);
        r17.e(r10.f17391i, this.V.J.f17391i, 0, 0);
        return;
    L104:
        if (r26 != 1) goto L107;
        r17.e(r10.f17391i, r13.f17391i, 0, 8);
        r17.e(r10.f17391i, this.V.J.f17391i, 0, 4);
        r17.e(r10.f17391i, this.V.L.f17391i, 0, 0);
        return;
    L107:
        if (r26 != 2) goto L110;
        r17.e(r14.f17391i, r11.f17391i, 0, 8);
        r17.e(r11.f17391i, this.V.M.f17391i, 0, 4);
        r17.e(r11.f17391i, this.V.K.f17391i, 0, 0);
        return;
    L110:
        if (r26 != 3) goto L132;
        r17.e(r11.f17391i, r14.f17391i, 0, 8);
        r17.e(r11.f17391i, this.V.K.f17391i, 0, 4);
        r17.e(r11.f17391i, this.V.M.f17391i, 0, 0);
        return;
    L132:
        return;
    L71:
        if (r116 != 2) goto L73;
        if (r115 == true) goto L77;
    L73:
        if (r116 != 1) goto L75;
        if (r114 == true) goto L77;
    L75:
        if (r116 != 3) goto L78;
        if (r115 == true) goto L77;
    L78:
        r117 = 4;
        goto L79
    L63:
        if (r14.g() == true) goto L66;
        r115 = false;
        goto L67
    L56:
        if (r13.g() == true) goto L59;
        r114 = false;
    L36:
        if (r111.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r111.J.f == null) goto L42;
        if (r111.L.f == null) goto L42;
    L30:
        if (r111.c() == true) goto L32;
    L52:
        r113 = false;
        goto L54
    }

    @Override // hr.f
    public final boolean c() {
        return true;
    }

    @Override // hr.l, hr.f
    public final void g(f r5, HashMap r10) {
        super.g(r5, r10);
        a r11 = (a) r5;
        this.f17369w0 = r11.f17369w0;
        this.f17370x0 = r11.f17370x0;
        this.f17371y0 = r11.f17371y0;
    }

    @Override // hr.f
    public final String toString() {
        String r5 = j0.q(new StringBuilder("[Barrier] "), this.f17409k0, " {");
        int r10 = 0;
    L4:
        if (r10 >= this.f17463v0) goto L10;
        f r11 = this.f17462u0[r10];
        if (r10 <= 0) goto L8;
        r5 = j0.j(r5, ", ");
    L8:
        StringBuilder r12 = j0.u(r5);
        r12.append(r11.f17409k0);
        r5 = r12.toString();
        r10 = r10 + 1;
        goto L4
    L10:
        return j0.j(r5, "}");
    }
}
