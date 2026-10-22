package hr;

import ai.j0;
import android.view.View;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.obric.oui.constraintlayout.core.widgets.analyzer.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public int A;
    public float B;
    public int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public final d J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d P;
    public final d Q;
    public final d[] R;
    public final ArrayList S;
    public final boolean[] T;
    public ConstraintWidget$DimensionBehaviour[] U;
    public f V;
    public int W;
    public int X;
    public float Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17394a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f17395a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.d f17396b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f17397b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.d f17398c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f17399c0;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.m d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f17400d0;
    public p e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f17401e0;
    public final boolean[] f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f17402f0;
    public boolean g;
    public float g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17403h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public View f17404h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17405i;
    public int i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f17406j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f17407j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17408k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f17409k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f17410l;
    public int l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17411m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f17412m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17413n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final float[] f17414n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17415o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final f[] f17416o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17417p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final f[] f17418p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17419q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public f f17420q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17421r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public f f17422r0;
    public int s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f17423s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f17424t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f17425t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17426u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f17427v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f17428w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f17429x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f17430y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f17431z;

    public f() {
        this.f17394a = false;
        this.d = null;
        this.e = null;
        this.f = new boolean[]{true, true};
        this.g = true;
        this.f17403h = -1;
        this.f17405i = -1;
        new HashMap();
        this.f17408k = false;
        this.f17410l = false;
        this.f17411m = false;
        this.f17413n = false;
        this.f17415o = -1;
        this.f17417p = -1;
        this.f17419q = 0;
        this.f17421r = 0;
        this.s = 0;
        this.f17424t = new int[2];
        this.f17426u = 0;
        this.f17427v = 0;
        this.f17428w = 1.0f;
        this.f17429x = 0;
        this.f17430y = 0;
        this.f17431z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = Float.NaN;
        this.E = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        d r5 = new d(this, ConstraintAnchor$Type.LEFT);
        this.J = r5;
        d r12 = new d(this, ConstraintAnchor$Type.TOP);
        this.K = r12;
        d r13 = new d(this, ConstraintAnchor$Type.RIGHT);
        this.L = r13;
        d r14 = new d(this, ConstraintAnchor$Type.BOTTOM);
        this.M = r14;
        d r15 = new d(this, ConstraintAnchor$Type.BASELINE);
        this.N = r15;
        d r11 = new d(this, ConstraintAnchor$Type.CENTER_X);
        this.O = r11;
        d r10 = new d(this, ConstraintAnchor$Type.CENTER_Y);
        this.P = r10;
        d r16 = new d(this, ConstraintAnchor$Type.CENTER);
        this.Q = r16;
        this.R = new d[]{r5, r13, r12, r14, r15, r16};
        ArrayList r17 = new ArrayList();
        this.S = r17;
        this.T = new boolean[2];
        ConstraintWidget$DimensionBehaviour r18 = ConstraintWidget$DimensionBehaviour.FIXED;
        this.U = new ConstraintWidget$DimensionBehaviour[]{r18, r18};
        this.V = null;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.f17395a0 = 0;
        this.f17397b0 = 0;
        this.f17399c0 = 0;
        this.f17402f0 = 0.5f;
        this.g0 = 0.5f;
        this.i0 = 0;
        this.f17407j0 = false;
        this.f17409k0 = null;
        this.l0 = 0;
        this.f17412m0 = 0;
        this.f17414n0 = new float[]{-1.0f, -1.0f};
        this.f17416o0 = new f[]{null, null};
        this.f17418p0 = new f[]{null, null};
        this.f17420q0 = null;
        this.f17422r0 = null;
        this.f17423s0 = -1;
        this.f17425t0 = -1;
        r17.add(r5);
        r17.add(r12);
        r17.add(r13);
        r17.add(r14);
        r17.add(r11);
        r17.add(r10);
        r17.add(r16);
        r17.add(r15);
    }

    public static void H(StringBuilder r5, int r10, int r11, String r12) {
        if (r10 != r11) goto L4;
        return;
    L4:
        r5.append(r12);
        r5.append(" :   ");
        r5.append(r10);
        r5.append(",\n");
    }

    public static void I(StringBuilder r5, String r10, float r11, float r12) {
        if (r11 != r12) goto L5;
        return;
    L5:
        r5.append(r10);
        r5.append(" :   ");
        r5.append(r11);
        r5.append(",\n");
    }

    public static void p(StringBuilder r5, String r10, int r11, int r12, int r13, int r14, int r15, float r16, ConstraintWidget$DimensionBehaviour r17) {
        r5.append(r10);
        r5.append(" :  {\n");
        String r18 = r17.toString();
        if (ConstraintWidget$DimensionBehaviour.FIXED.toString().equals(r18) == true) goto L6;
        androidx.constraintlayout.motion.widget.a.C(r5, "      behavior", " :   ", r18, ",\n");
    L6:
        H(r5, r11, 0, "      size");
        H(r5, r12, 0, "      min");
        H(r5, r13, Integer.MAX_VALUE, "      max");
        H(r5, r14, 0, "      matchMin");
        H(r5, r15, 0, "      matchDef");
        I(r5, "      matchPercent", r16, 1.0f);
        r5.append("    },\n");
    }

    public static void q(StringBuilder r5, String r10, d r11) {
        if (r11.f != null) goto L5;
        return;
    L5:
        r5.append("    ");
        r5.append(r10);
        r5.append(" : [ '");
        r5.append(r11.f);
        r5.append("'");
        if (r11.f17390h == Integer.MIN_VALUE) goto L8;
    L9:
        r5.append(",");
        r5.append(r11.g);
        if (r11.f17390h == Integer.MIN_VALUE) goto L12;
        r5.append(",");
        r5.append(r11.f17390h);
        r5.append(",");
    L12:
        r5.append(" ] ,\n");
        return;
    L8:
        if (r11.g == 0) goto L12;
        goto L9
    }

    public final boolean A() {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.i0 == 8) goto L7;
        return true;
    }

    public boolean B() {
        if (this.f17408k == false) goto L5;
    L10:
        return true;
    L5:
        if (this.J.f17389c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.L.f17389c == false) goto L9;
        goto L9
    }

    public boolean C() {
        if (this.f17410l == false) goto L5;
    L10:
        return true;
    L5:
        if (this.K.f17389c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.M.f17389c == false) goto L9;
        goto L9
    }

    public void D() {
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.V = null;
        this.D = Float.NaN;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.f17395a0 = 0;
        this.f17397b0 = 0;
        this.f17399c0 = 0;
        this.f17400d0 = 0;
        this.f17401e0 = 0;
        this.f17402f0 = 0.5f;
        this.g0 = 0.5f;
        ConstraintWidget$DimensionBehaviour[] r5 = this.U;
        ConstraintWidget$DimensionBehaviour r10 = ConstraintWidget$DimensionBehaviour.FIXED;
        r5[0] = r10;
        r5[1] = r10;
        this.f17404h0 = null;
        this.i0 = 0;
        this.l0 = 0;
        this.f17412m0 = 0;
        float[] r11 = this.f17414n0;
        r11[0] = -1.0f;
        r11[1] = -1.0f;
        this.f17415o = -1;
        this.f17417p = -1;
        int[] r12 = this.C;
        r12[0] = Integer.MAX_VALUE;
        r12[1] = Integer.MAX_VALUE;
        this.f17421r = 0;
        this.s = 0;
        this.f17428w = 1.0f;
        this.f17431z = 1.0f;
        this.f17427v = Integer.MAX_VALUE;
        this.f17430y = Integer.MAX_VALUE;
        this.f17426u = 0;
        this.f17429x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] r13 = this.f;
        r13[0] = true;
        r13[1] = true;
        this.G = false;
        boolean[] r14 = this.T;
        r14[0] = false;
        r14[1] = false;
        this.g = true;
        int[] r15 = this.f17424t;
        r15[0] = 0;
        r15[1] = 0;
        this.f17403h = -1;
        this.f17405i = -1;
    }

    public final void E() {
        f r5 = this.V;
        if (r5 != null) goto L5;
    L7:
        ArrayList r10 = this.S;
        int r11 = r10.size();
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        ((d) r10.get(r12)).j();
        r12 = r12 + 1;
        goto L8
    L10:
        return;
    L5:
        if ((r5 instanceof g) == false) goto L7;
        ((g) r5).getClass();
        goto L7
    }

    public final void F() {
        this.f17408k = false;
        this.f17410l = false;
        this.f17411m = false;
        this.f17413n = false;
        ArrayList r5 = this.S;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        d r12 = (d) r5.get(r11);
        r12.f17389c = false;
        r12.f17388b = 0;
        r11 = r11 + 1;
        goto L3
    }

    public void G(w r5) {
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.Q.k();
        this.O.k();
        this.P.k();
    }

    public final void J(int r5) {
        this.f17399c0 = r5;
        if (r5 <= 0) goto L5;
        boolean r10 = true;
    L6:
        this.E = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void K(int r5, int r10) {
        if (this.f17408k == false) goto L5;
        return;
    L5:
        this.J.l(r5);
        this.L.l(r10);
        this.f17395a0 = r5;
        this.W = r10 - r5;
        this.f17408k = true;
    }

    public final void L(int r5, int r10) {
        if (this.f17410l == false) goto L5;
        return;
    L5:
        this.K.l(r5);
        this.M.l(r10);
        this.f17397b0 = r5;
        this.X = r10 - r5;
        if (this.E == false) goto L8;
        int r11 = r5 + this.f17399c0;
        this.N.l(r11);
    L8:
        this.f17410l = true;
    }

    public final void M(int r5) {
        this.X = r5;
        int r10 = this.f17401e0;
        if (r5 >= r10) goto L6;
        this.X = r10;
        return;
    }

    public final void N(ConstraintWidget$DimensionBehaviour r5) {
        this.U[0] = r5;
    }

    public final void O(ConstraintWidget$DimensionBehaviour r5) {
        this.U[1] = r5;
    }

    public final void P(int r5) {
        this.W = r5;
        int r10 = this.f17400d0;
        if (r5 >= r10) goto L6;
        this.W = r10;
        return;
    }

    public void Q(boolean r10, boolean r11) {
        com.obric.oui.constraintlayout.core.widgets.analyzer.m r5 = this.d;
        boolean r12 = r10 & r5.g;
        p r13 = this.e;
        boolean r14 = r11 & r13.g;
        int r15 = r5.f12595h.g;
        int r16 = r13.f12595h.g;
        int r17 = r5.f12596i.g;
        int r18 = r13.f12596i.g;
        int r19 = r18 - r16;
        if ((r17 - r15) < 0) goto L15;
        if (r19 < 0) goto L15;
        if (r15 == Integer.MIN_VALUE) goto L15;
        if (r15 == Integer.MAX_VALUE) goto L15;
        if (r16 == Integer.MIN_VALUE) goto L15;
        if (r16 == Integer.MAX_VALUE) goto L15;
        if (r17 == Integer.MIN_VALUE) goto L15;
        if (r17 == Integer.MAX_VALUE) goto L15;
        if (r18 == Integer.MIN_VALUE) goto L15;
        if (r18 == Integer.MAX_VALUE) goto L15;
    L16:
        int r20 = r17 - r15;
        int r21 = r18 - r16;
        if (r12 == false) goto L19;
        this.f17395a0 = r15;
    L19:
        if (r14 == false) goto L22;
        this.f17397b0 = r16;
    L22:
        if (this.i0 != 8) goto L25;
        this.W = 0;
        this.X = 0;
        return;
    L25:
        if (r12 == true) goto L27;
    L34:
        if (r14 == true) goto L36;
        return;
    L36:
        if (this.U[1] != ConstraintWidget$DimensionBehaviour.FIXED) goto L40;
        int r22 = this.X;
        if (r21 >= r22) goto L40;
        r21 = r22;
    L40:
        this.X = r21;
        int r23 = this.f17401e0;
        if (r21 >= r23) goto L45;
        this.X = r23;
        return;
    L45:
        return;
    L27:
        if (this.U[0] != ConstraintWidget$DimensionBehaviour.FIXED) goto L31;
        int r24 = this.W;
        if (r20 >= r24) goto L31;
        r20 = r24;
    L31:
        this.W = r20;
        int r25 = this.f17400d0;
        if (r20 >= r25) goto L34;
        this.W = r25;
    L15:
        r17 = 0;
        r18 = 0;
        r15 = 0;
        r16 = 0;
        goto L16
    }

    public void R(fr.c r10, boolean r11) {
        d r5 = this.J;
        r10.getClass();
        int r12 = fr.c.n(r5);
        int r13 = fr.c.n(this.K);
        int r14 = fr.c.n(this.L);
        int r15 = fr.c.n(this.M);
        if (r11 == false) goto L11;
        com.obric.oui.constraintlayout.core.widgets.analyzer.m r16 = this.d;
        if (r16 == null) goto L11;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g r17 = r16.f12595h;
        if (r17.f12576j == false) goto L11;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g r18 = r16.f12596i;
        if (r18.f12576j == false) goto L11;
        r12 = r17.g;
        r14 = r18.g;
    L11:
        if (r11 == false) goto L19;
        p r19 = this.e;
        if (r19 == null) goto L19;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g r20 = r19.f12595h;
        if (r20.f12576j == false) goto L19;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g r21 = r19.f12596i;
        if (r21.f12576j == false) goto L19;
        r13 = r20.g;
        r15 = r21.g;
    L19:
        int r22 = r15 - r13;
        if ((r14 - r12) < 0) goto L32;
        if (r22 < 0) goto L32;
        if (r12 == Integer.MIN_VALUE) goto L32;
        if (r12 == Integer.MAX_VALUE) goto L32;
        if (r13 == Integer.MIN_VALUE) goto L32;
        if (r13 == Integer.MAX_VALUE) goto L32;
        if (r14 == Integer.MIN_VALUE) goto L32;
        if (r14 == Integer.MAX_VALUE) goto L32;
        if (r15 == Integer.MIN_VALUE) goto L32;
        if (r15 == Integer.MAX_VALUE) goto L32;
    L33:
        int r23 = r14 - r12;
        int r24 = r15 - r13;
        this.f17395a0 = r12;
        this.f17397b0 = r13;
        if (this.i0 != 8) goto L36;
        this.W = 0;
        this.X = 0;
        return;
    L36:
        ConstraintWidget$DimensionBehaviour[] r25 = this.U;
        ConstraintWidget$DimensionBehaviour r26 = r25[0];
        ConstraintWidget$DimensionBehaviour r27 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r26 != r27) goto L42;
        int r28 = this.W;
        if (r23 >= r28) goto L42;
        r23 = r28;
    L42:
        if (r25[1] != r27) goto L46;
        int r29 = this.X;
        if (r24 >= r29) goto L46;
        r24 = r29;
    L46:
        this.W = r23;
        this.X = r24;
        int r30 = this.f17401e0;
        if (r24 >= r30) goto L49;
        this.X = r30;
    L49:
        int r31 = this.f17400d0;
        if (r23 >= r31) goto L52;
        this.W = r31;
    L52:
        int r32 = this.f17427v;
        if (r32 > 0) goto L55;
    L57:
        int r33 = this.f17430y;
        if (r33 > 0) goto L60;
    L62:
        int r34 = this.W;
        if (r23 == r34) goto L65;
        this.f17403h = r34;
    L65:
        int r35 = this.X;
        if (r24 == r35) goto L70;
        this.f17405i = r35;
        return;
    L70:
        return;
    L60:
        if (this.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        this.X = Math.min(this.X, r33);
        goto L62
    L55:
        if (r26 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        this.W = Math.min(this.W, r32);
    L32:
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        goto L33
    }

    public final void a(g r10, fr.c r11, HashSet r12, int r13, boolean r14) {
        if (r14 == true) goto L4;
    L7:
        if (r13 != 0) goto L20;
        HashSet r15 = this.J.f17387a;
        if (r15 == null) goto L14;
        Iterator r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        ((d) r16.next()).d.a(r10, r11, r12, r13, true);
    L14:
        HashSet r17 = this.L.f17387a;
        if (r17 == null) goto L38;
        Iterator r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L45;
        ((d) r18.next()).d.a(r10, r11, r12, r13, true);
        goto L18
    L45:
        return;
    L38:
        return;
    L20:
        HashSet r19 = this.K.f17387a;
        if (r19 == null) goto L26;
        Iterator r110 = r19.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        ((d) r110.next()).d.a(r10, r11, r12, r13, true);
    L26:
        HashSet r111 = this.M.f17387a;
        if (r111 == null) goto L32;
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        ((d) r112.next()).d.a(r10, r11, r12, r13, true);
    L32:
        HashSet r20 = this.N.f17387a;
        if (r20 == null) goto L44;
        Iterator r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        ((d) r21.next()).d.a(r10, r11, r12, r13, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r12.contains(this) == true) goto L6;
        return;
    L6:
        m.b(r10, r11, this);
        r12.remove(this);
        b(r11, r10.X(64));
        goto L7
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 20191. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void b(fr.c r61, boolean r62) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: IGET (r0v0 ?? I:hr.d) = (r60v0 'this' ?? I:hr.f A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] hr.f.J hr.d in method: hr.f.b(fr.c, boolean):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hr.f.b(fr.c, boolean):void");
    }

    public boolean c() {
        if (this.i0 == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(fr.c r31, boolean r32, boolean r33, boolean r34, boolean r35, fr.e r36, fr.e r37, ConstraintWidget$DimensionBehaviour r38, boolean r39, d r40, d r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        int r5 = r54;
        int r10 = r55;
        fr.e r11 = r31.k(r40);
        fr.e r12 = r31.k(r41);
        fr.e r13 = r31.k(r40.f);
        fr.e r14 = r31.k(r41.f);
        boolean r16 = r40.h();
        boolean r17 = r41.h();
        boolean r15 = this.Q.h();
        if (r17 == false) goto L5;
        int r18 = (r16 ? 1 : 0) + 1;
    L6:
        if (r15 == false) goto L8;
        r18 = r18 + 1;
    L8:
        int r19 = r18;
        if (r47 == false) goto L11;
        int r110 = 3;
    L12:
        int r111 = e.f17393b[r38.ordinal()];
        if (r111 != 1) goto L15;
    L20:
        int r112 = r110;
    L21:
        boolean r113 = false;
    L25:
        int r114 = this.f17403h;
        if (r114 == (-1)) goto L29;
        if (r32 == false) goto L29;
        this.f17403h = -1;
        r43 = r114;
        r113 = false;
    L29:
        int r115 = this.f17405i;
        if (r115 == (-1)) goto L33;
        if (r32 == true) goto L33;
        this.f17405i = -1;
        r113 = false;
    L34:
        int r410 = r115;
        if (this.i0 != 8) goto L37;
        int r20 = 0;
        r113 = false;
    L38:
        if (r57 == false) goto L47;
        if (r16 == true) goto L44;
        if (r17 == true) goto L44;
        if (r15 == true) goto L44;
        r31.d(r11, r42);
    L43:
        int r116 = 8;
    L48:
        if (r113 == true) goto L60;
        if (r39 == false) goto L56;
        r31.e(r12, r11, 0, 3);
        if (r44 <= 0) goto L54;
        r31.f(r12, r11, r44, r116);
    L54:
        if (r45 >= Integer.MAX_VALUE) goto L58;
        r31.g(r12, r11, r45, r116);
    L58:
        int r117 = r5;
    L108:
        if (r57 == false) goto L328;
        if (r49 == false) goto L111;
        char r21 = 2;
        char r29 = 1;
    L329:
        if (r19 >= r21) goto L360;
        if (r33 == false) goto L361;
        if (r35 == false) goto L362;
        r31.f(r11, r36, 0, 8);
        d r22 = this.N;
        if (r32 == false) goto L335;
    L338:
        char r118 = r29;
    L339:
        if (r32 == true) goto L350;
        d r23 = r22.f;
        if (r23 == null) goto L350;
        f r24 = r23.d;
        if (r24.Y == 0.0f) goto L349;
        ConstraintWidget$DimensionBehaviour[] r25 = r24.U;
        ConstraintWidget$DimensionBehaviour r26 = r25[0];
        ConstraintWidget$DimensionBehaviour r27 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r26 != r27) goto L349;
        if (r25[r29] != r27) goto L349;
        r118 = r29;
    L349:
        r118 = 0;
    L350:
        if (r118 == 0) goto L363;
        r31.f(r37, r12, 0, 8);
        return;
    L363:
        return;
    L335:
        if (r22.f == null) goto L338;
        r118 = 0;
        goto L339
    L362:
        return;
    L361:
        return;
    L360:
        return;
    L111:
        if (r16 == true) goto L116;
        if (r17 == true) goto L116;
        if (r15 == true) goto L116;
        fr.e r28 = r14;
    L115:
        int r30 = 5;
    L318:
        boolean r210 = r33;
    L317:
        int r119 = r30;
    L319:
        if (r210 == false) goto L357;
        if (r35 == true) goto L322;
        return;
    L322:
        if (r41.f == null) goto L324;
        int r58 = r41.e();
    L325:
        if (r28 == r37) goto L359;
        r31.f(r37, r12, r58, r119);
        return;
    L359:
        return;
    L324:
        r58 = 0;
        goto L325
    L357:
        return;
    L116:
        if (r16 == false) goto L125;
        if (r17 == true) goto L125;
        f r59 = r40.f.d;
        if (r33 == true) goto L121;
    L123:
        int r60 = 5;
    L124:
        r41 = r41;
        r12 = r12;
        r35 = r35;
        r119 = r60;
        r28 = r14;
        r210 = r33;
        goto L319
    L121:
        if ((r59 instanceof a) == false) goto L123;
        r60 = 8;
    L125:
        if (r16 == true) goto L131;
        if (r17 == false) goto L131;
        fr.e r61 = r14;
        r31.e(r12, r61, -r41.e(), 8);
        if (r33 == false) goto L130;
        r31.f(r11, r36, 0, 5);
        r41 = r41;
        r30 = 5;
        r28 = r61;
        r12 = r12;
        r35 = r35;
    L130:
        r28 = r61;
    L131:
        r61 = r14;
        if (r16 == false) goto L130;
        if (r17 == false) goto L130;
        f r62 = r40.f.d;
        r41 = r41;
        f r63 = r41.f.d;
        f r120 = this.V;
        int r121 = 6;
        if (r113 == false) goto L206;
        if (r112 != 0) goto L156;
        if (r10 != 0) goto L146;
        if (r117 != 0) goto L146;
        if (r13.f == true) goto L142;
    L145:
        int r310 = 8;
        int r122 = 8;
        boolean r211 = false;
        boolean r212 = true;
        boolean r213 = false;
    L148:
        if ((r62 instanceof a) == false) goto L150;
    L154:
        r112 = r112;
        r121 = 6;
        boolean r214 = r211;
        boolean r215 = r212;
        boolean r123 = true;
        int r216 = 4;
        int r217 = r310;
    L153:
        r37 = r37;
    L221:
        if (r213 == false) goto L225;
        if (r13 != r61) goto L225;
        if (r62 == r120) goto L225;
        boolean r218 = false;
        boolean r219 = false;
    L226:
        if (r214 == false) goto L235;
        if (r113 == true) goto L233;
        if (r48 == true) goto L233;
        if (r50 == true) goto L233;
        if (r13 != r36) goto L233;
        if (r61 != r37) goto L233;
        r210 = false;
        int r220 = 8;
        int r221 = 8;
        boolean r222 = false;
    L234:
        boolean r223 = true;
        fr.e r224 = r12;
        r31.b(r11, r13, r40.e(), r46, r61, r12, r41.e(), r221);
        int r64 = r220;
        r218 = r222;
    L237:
        if (this.i0 != 8) goto L245;
        HashSet r65 = r41.f17387a;
        if (r65 != null) goto L242;
        return;
    L242:
        if (r65.size() > 0) goto L245;
        return;
    L245:
        r28 = r61;
        if (r219 == false) goto L256;
        if (r210 == false) goto L255;
        if (r13 == r28) goto L255;
        if (r113 == true) goto L255;
        if ((r62 instanceof a) == false) goto L253;
    L254:
        r64 = 6;
        goto L255
    L253:
        if ((r63 instanceof a) == true) goto L254;
    L255:
        r31.f(r11, r13, r40.e(), r64);
        r12 = r224;
        r31.g(r12, r28, -r41.e(), r64);
    L257:
        if (r210 == false) goto L266;
        if (r51 == false) goto L266;
        if ((r62 instanceof a) == true) goto L266;
        if ((r63 instanceof a) == true) goto L266;
        f r66 = r120;
        if (r63 == r66) goto L267;
        r64 = 6;
        int r67 = 6;
        r218 = r223;
    L268:
        if (r218 == false) goto L300;
        if (r215 == false) goto L290;
        if (r50 == false) goto L272;
        if (r34 == false) goto L290;
    L272:
        if (r62 == r66) goto L277;
        if (r63 == r66) goto L277;
        r121 = r67;
    L277:
        if ((r62 instanceof k) == false) goto L279;
    L280:
        r121 = 5;
    L282:
        if ((r62 instanceof a) == false) goto L284;
    L285:
        r121 = 5;
    L286:
        if (r50 == false) goto L288;
        int r68 = 5;
    L289:
        r67 = Math.max(r68, r67);
        goto L290
    L288:
        r68 = r121;
        goto L289
    L284:
        if ((r63 instanceof a) == false) goto L286;
    L279:
        if ((r63 instanceof k) == false) goto L282;
    L290:
        if (r210 == false) goto L298;
        int r69 = Math.min(r64, r67);
        if (r47 == false) goto L297;
        if (r50 == true) goto L297;
        if (r62 == r66) goto L296;
        if (r63 != r66) goto L297;
    L296:
        int r124 = 4;
    L299:
        r31.e(r11, r13, r40.e(), r124);
        r31.e(r12, r28, -r41.e(), r124);
    L297:
        r124 = r69;
        goto L299
    L298:
        r124 = r67;
    L300:
        if (r210 == true) goto L302;
    L307:
        if (r210 == false) goto L315;
        if (r113 == false) goto L315;
        if (r44 != 0) goto L315;
        if (r117 != 0) goto L315;
        if (r113 == true) goto L313;
    L316:
        r30 = 5;
        r31.f(r12, r11, 0, 5);
        goto L317
    L313:
        if (r112 != 3) goto L316;
        r31.f(r12, r11, 0, 8);
    L315:
        r30 = 5;
        goto L317
    L302:
        if (r36 != r13) goto L304;
        int r70 = r40.e();
    L305:
        if (r13 == r36) goto L307;
        r31.f(r11, r36, r70, 5);
        goto L307
    L304:
        r70 = 0;
    L267:
        r67 = r216;
    L266:
        r66 = r120;
        goto L267
    L256:
        r12 = r224;
    L233:
        r221 = r121;
        r222 = r218;
        r220 = r217;
        r210 = r33;
        goto L234
    L235:
        r224 = r12;
        r223 = r123;
        r64 = r217;
        r210 = r33;
    L225:
        r219 = r213;
        r218 = r123;
        goto L226
    L150:
        if ((r63 instanceof a) == true) goto L154;
        r121 = 6;
        r214 = r211;
        r215 = r212;
        r123 = true;
        r217 = r310;
        r216 = r122;
        r112 = r112;
        goto L153
    L142:
        if (r61.f == false) goto L145;
        r31.e(r11, r13, r40.e(), 8);
        r31.e(r12, r61, -r41.e(), 8);
        return;
    L146:
        r310 = 5;
        r122 = 5;
        r211 = true;
        r212 = false;
        r213 = true;
        goto L148
    L156:
        if (r112 != 2) goto L167;
        if ((r62 instanceof a) == false) goto L160;
    L165:
        r123 = true;
        r216 = 4;
    L163:
        r217 = 5;
    L164:
        r213 = true;
        r214 = true;
        r215 = false;
        goto L153
    L160:
        if ((r63 instanceof a) == true) goto L165;
        r123 = true;
        r216 = 5;
        goto L163
    L167:
        if (r112 != 1) goto L170;
        r112 = r112;
        r121 = 6;
        r123 = true;
        r216 = 4;
        r217 = 8;
        goto L164
    L170:
        if (r112 != 3) goto L204;
        r112 = r112;
        if (this.A != (-1)) goto L180;
        if (r50 == false) goto L179;
        r37 = r37;
        if (r33 == false) goto L178;
        r121 = 5;
    L177:
        r123 = true;
        r216 = 5;
        r217 = 8;
        r213 = true;
        r214 = true;
        r215 = true;
        goto L221
    L178:
        r121 = 4;
        goto L177
    L179:
        r37 = r37;
        r121 = 8;
        goto L177
    L180:
        if (r47 == true) goto L182;
        r123 = true;
        if (r10 <= 0) goto L194;
        r213 = true;
        r214 = true;
        r215 = true;
        r216 = 5;
    L193:
        r217 = 5;
        goto L221
    L194:
        if (r10 != 0) goto L203;
        if (r117 != 0) goto L203;
        if (r50 == true) goto L198;
        r213 = true;
        r214 = true;
        r215 = true;
        r216 = 8;
        goto L193
    L198:
        if (r62 == r120) goto L201;
        if (r63 == r120) goto L201;
        int r71 = 4;
    L202:
        r37 = r37;
        r217 = r71;
        r213 = true;
        r214 = true;
        r215 = true;
        r121 = 6;
        r216 = 4;
    L201:
        r71 = 5;
    L203:
        r213 = true;
        r214 = true;
        r215 = true;
        r216 = 4;
        goto L193
    L182:
        if (r53 == 2) goto L187;
        r123 = true;
        if (r53 == 1) goto L188;
        int r72 = 8;
        int r125 = 5;
    L189:
        r217 = r72;
        r216 = r125;
        r213 = r123;
        r214 = r213;
        r215 = r214;
        r121 = 6;
    L188:
        r72 = 5;
        r125 = 4;
        goto L189
    L187:
        r123 = true;
        goto L188
    L204:
        r123 = true;
        r216 = 4;
        r217 = 5;
        r213 = false;
        r214 = false;
    L205:
        r215 = false;
        goto L221
    L206:
        r123 = true;
        if (r13.f == true) goto L209;
    L220:
        r213 = true;
        r214 = true;
        r216 = 4;
        r217 = 5;
        goto L205
    L209:
        if (r61.f == false) goto L220;
        r31.b(r11, r13, r40.e(), r46, r61, r12, r41.e(), 8);
        if (r33 == false) goto L353;
        if (r35 == true) goto L214;
        return;
    L214:
        if (r41.f == null) goto L216;
        int r126 = r41.e();
    L217:
        if (r61 == r37) goto L355;
        r31.f(r37, r12, r126, 5);
        return;
    L355:
        return;
    L216:
        r126 = 0;
        goto L217
    L353:
        return;
    L328:
        r29 = 1;
        r21 = 2;
        goto L329
    L56:
        r31.e(r12, r11, r20, r116);
        goto L58
    L60:
        if (r19 == 2) goto L70;
        if (r47 == true) goto L70;
        if (r112 == 1) goto L65;
        if (r112 != 0) goto L70;
    L65:
        int r73 = Math.max(r5, r20);
        if (r10 <= 0) goto L68;
        r73 = Math.min(r10, r73);
    L68:
        r31.e(r12, r11, r73, 8);
        r35 = r35;
        r19 = r19 == true ? 1 : 0;
        r117 = r5;
        r113 = false;
    L70:
        if (r5 != (-2)) goto L72;
        r5 = r20;
    L72:
        if (r10 != (-2)) goto L74;
        r10 = r20;
    L74:
        if (r20 <= 0) goto L79;
        if (r112 == 1) goto L79;
        r20 = 0;
    L79:
        if (r5 <= 0) goto L82;
        r31.f(r12, r11, r5, 8);
        r20 = Math.max(r20, r5);
    L82:
        if (r10 <= 0) goto L88;
        if (r33 == false) goto L86;
        if (r112 != 1) goto L86;
    L87:
        r20 = Math.min(r20, r10);
    L86:
        r31.g(r12, r11, r10, 8);
    L88:
        if (r112 != 1) goto L95;
        if (r33 == false) goto L91;
        r31.e(r12, r11, r20, 8);
        goto L58
    L91:
        if (r49 == false) goto L93;
        r31.e(r12, r11, r20, 5);
        r31.g(r12, r11, r20, 8);
        goto L58
    L93:
        r31.e(r12, r11, r20, 5);
        r31.g(r12, r11, r20, 8);
        goto L58
    L95:
        if (r112 != 2) goto L107;
        ConstraintAnchor$Type r74 = ConstraintAnchor$Type.TOP;
        ConstraintAnchor$Type r127 = r40.e;
        if (r127 != r74) goto L99;
    L102:
        fr.e r75 = r31.k(this.V.j(r74));
        fr.e r76 = r31.k(this.V.j(ConstraintAnchor$Type.BOTTOM));
    L103:
        fr.b r128 = r31.l();
        r128.d.g(r12, -1.0f);
        r128.d.g(r11, 1.0f);
        r128.d.g(r76, r56);
        r128.d.g(r75, -r56);
        r31.c(r128);
        if (r33 == false) goto L58;
        r113 = false;
        goto L58
    L99:
        if (r127 == ConstraintAnchor$Type.BOTTOM) goto L102;
        r75 = r31.k(this.V.j(ConstraintAnchor$Type.LEFT));
        r76 = r31.k(this.V.j(ConstraintAnchor$Type.RIGHT));
        goto L103
    L107:
        r19 = r19 == true ? 1 : 0;
        r117 = r5;
        r35 = true;
    L44:
        if (r16 == false) goto L43;
        if (r17 == true) goto L43;
        r116 = 8;
        r31.e(r11, r13, r40.e(), 8);
        goto L48
    L47:
        r116 = 8;
        goto L48
    L37:
        r20 = r410;
    L33:
        r115 = r43;
        goto L34
    L15:
        if (r111 == 2) goto L20;
        if (r111 == 3) goto L20;
        if (r111 != 4) goto L20;
        r112 = r110;
        if (r112 == 4) goto L21;
        r113 = true;
        goto L25
    L11:
        r110 = r52;
        goto L12
    L5:
        r18 = r16 ? 1 : 0;
        goto L6
    }

    public final void e(ConstraintAnchor$Type r10, f r11, ConstraintAnchor$Type r12, int r13) {
        ConstraintAnchor$Type r5 = ConstraintAnchor$Type.CENTER;
        if (r10 != r5) goto L40;
        if (r12 != r5) goto L29;
        ConstraintAnchor$Type r14 = ConstraintAnchor$Type.LEFT;
        d r15 = j(r14);
        ConstraintAnchor$Type r16 = ConstraintAnchor$Type.RIGHT;
        d r17 = j(r16);
        ConstraintAnchor$Type r18 = ConstraintAnchor$Type.TOP;
        d r19 = j(r18);
        ConstraintAnchor$Type r20 = ConstraintAnchor$Type.BOTTOM;
        d r21 = j(r20);
        boolean r22 = true;
        if (r15 != null) goto L8;
    L9:
        if (r17 != null) goto L11;
    L13:
        e(r14, r11, r14, 0);
        e(r16, r11, r16, 0);
        boolean r23 = true;
    L14:
        if (r19 != null) goto L16;
    L17:
        if (r21 != null) goto L19;
    L21:
        e(r18, r11, r18, 0);
        e(r20, r11, r20, 0);
    L22:
        if (r23 == false) goto L25;
        if (r22 == false) goto L25;
        j(r5).a(r11.j(r5), 0);
        return;
    L25:
        if (r23 == false) goto L27;
        ConstraintAnchor$Type r24 = ConstraintAnchor$Type.CENTER_X;
        j(r24).a(r11.j(r24), 0);
        return;
    L27:
        if (r22 == false) goto L97;
        ConstraintAnchor$Type r25 = ConstraintAnchor$Type.CENTER_Y;
        j(r25).a(r11.j(r25), 0);
        return;
    L97:
        return;
    L19:
        if (r21.h() == false) goto L21;
    L20:
        r22 = false;
        goto L22
    L16:
        if (r19.h() == true) goto L20;
    L11:
        if (r17.h() == false) goto L13;
    L12:
        r23 = false;
        goto L14
    L8:
        if (r15.h() == true) goto L12;
    L29:
        ConstraintAnchor$Type r26 = ConstraintAnchor$Type.LEFT;
        if (r12 != r26) goto L32;
    L39:
        e(r26, r11, r12, 0);
        e(ConstraintAnchor$Type.RIGHT, r11, r12, 0);
        j(r5).a(r11.j(r12), 0);
        return;
    L32:
        if (r12 == ConstraintAnchor$Type.RIGHT) goto L39;
        ConstraintAnchor$Type r27 = ConstraintAnchor$Type.TOP;
        if (r12 != r27) goto L37;
    L38:
        e(r27, r11, r12, 0);
        e(ConstraintAnchor$Type.BOTTOM, r11, r12, 0);
        j(r5).a(r11.j(r12), 0);
        return;
    L37:
        if (r12 == ConstraintAnchor$Type.BOTTOM) goto L38;
        return;
    L40:
        ConstraintAnchor$Type r28 = ConstraintAnchor$Type.CENTER_X;
        if (r10 != r28) goto L47;
        ConstraintAnchor$Type r29 = ConstraintAnchor$Type.LEFT;
        if (r12 != r29) goto L45;
    L46:
        d r30 = j(r29);
        d r110 = r11.j(r12);
        d r111 = j(ConstraintAnchor$Type.RIGHT);
        r30.a(r110, 0);
        r111.a(r110, 0);
        j(r28).a(r110, 0);
        return;
    L45:
        if (r12 == ConstraintAnchor$Type.RIGHT) goto L46;
    L47:
        ConstraintAnchor$Type r31 = ConstraintAnchor$Type.CENTER_Y;
        if (r10 != r31) goto L54;
        ConstraintAnchor$Type r32 = ConstraintAnchor$Type.TOP;
        if (r12 != r32) goto L52;
    L53:
        d r33 = r11.j(r12);
        j(r32).a(r33, 0);
        j(ConstraintAnchor$Type.BOTTOM).a(r33, 0);
        j(r31).a(r33, 0);
        return;
    L52:
        if (r12 == ConstraintAnchor$Type.BOTTOM) goto L53;
    L54:
        if (r10 != r28) goto L57;
        if (r12 != r28) goto L57;
        ConstraintAnchor$Type r34 = ConstraintAnchor$Type.LEFT;
        j(r34).a(r11.j(r34), 0);
        ConstraintAnchor$Type r35 = ConstraintAnchor$Type.RIGHT;
        j(r35).a(r11.j(r35), 0);
        j(r28).a(r11.j(r12), 0);
        return;
    L57:
        if (r10 != r31) goto L60;
        if (r12 != r31) goto L60;
        ConstraintAnchor$Type r36 = ConstraintAnchor$Type.TOP;
        j(r36).a(r11.j(r36), 0);
        ConstraintAnchor$Type r37 = ConstraintAnchor$Type.BOTTOM;
        j(r37).a(r11.j(r37), 0);
        j(r31).a(r11.j(r12), 0);
        return;
    L60:
        d r38 = j(r10);
        d r112 = r11.j(r12);
        if (r38.i(r112) == false) goto L106;
        ConstraintAnchor$Type r113 = ConstraintAnchor$Type.BASELINE;
        if (r10 != r113) goto L70;
        d r39 = j(ConstraintAnchor$Type.TOP);
        d r40 = j(ConstraintAnchor$Type.BOTTOM);
        if (r39 == null) goto L67;
        r39.j();
    L67:
        if (r40 == null) goto L93;
        r40.j();
    L93:
        r38.a(r112, r13);
        return;
    L70:
        if (r10 != ConstraintAnchor$Type.TOP) goto L72;
    L84:
        d r114 = j(r113);
        if (r114 == null) goto L87;
        r114.j();
    L87:
        d r115 = j(r5);
        if (r115.f == r112) goto L90;
        r115.j();
    L90:
        d r41 = j(r10).f();
        d r42 = j(r31);
        if (r42.h() == false) goto L93;
        r41.j();
        r42.j();
        goto L93
    L72:
        if (r10 == ConstraintAnchor$Type.BOTTOM) goto L84;
        if (r10 != ConstraintAnchor$Type.LEFT) goto L77;
    L78:
        d r116 = j(r5);
        if (r116.f == r112) goto L81;
        r116.j();
    L81:
        d r43 = j(r10).f();
        d r44 = j(r28);
        if (r44.h() == false) goto L93;
        r43.j();
        r44.j();
        goto L93
    L77:
        if (r10 != ConstraintAnchor$Type.RIGHT) goto L93;
    }

    public final void f(d r5, d r10, int r11) {
        if (r5.d != this) goto L6;
        f r12 = r10.d;
        e(r5.e, r12, r10.e, r11);
        return;
    }

    public void g(f r10, HashMap r11) {
        this.f17415o = r10.f17415o;
        this.f17417p = r10.f17417p;
        this.f17421r = r10.f17421r;
        this.s = r10.s;
        int[] r5 = r10.f17424t;
        int r12 = r5[0];
        int[] r13 = this.f17424t;
        r13[0] = r12;
        r13[1] = r5[1];
        this.f17426u = r10.f17426u;
        this.f17427v = r10.f17427v;
        this.f17429x = r10.f17429x;
        this.f17430y = r10.f17430y;
        this.f17431z = r10.f17431z;
        this.A = r10.A;
        this.B = r10.B;
        int[] r14 = r10.C;
        this.C = Arrays.copyOf(r14, r14.length);
        this.D = r10.D;
        this.E = r10.E;
        this.F = r10.F;
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.U = (ConstraintWidget$DimensionBehaviour[]) Arrays.copyOf(this.U, 2);
        f r15 = null;
        if (this.V != null) goto L5;
        f r16 = null;
    L6:
        this.V = r16;
        this.W = r10.W;
        this.X = r10.X;
        this.Y = r10.Y;
        this.Z = r10.Z;
        this.f17395a0 = r10.f17395a0;
        this.f17397b0 = r10.f17397b0;
        this.f17399c0 = r10.f17399c0;
        this.f17400d0 = r10.f17400d0;
        this.f17401e0 = r10.f17401e0;
        this.f17402f0 = r10.f17402f0;
        this.g0 = r10.g0;
        this.f17404h0 = r10.f17404h0;
        this.i0 = r10.i0;
        this.f17407j0 = r10.f17407j0;
        this.f17409k0 = r10.f17409k0;
        this.l0 = r10.l0;
        this.f17412m0 = r10.f17412m0;
        float[] r17 = r10.f17414n0;
        float r18 = r17[0];
        float[] r19 = this.f17414n0;
        r19[0] = r18;
        r19[1] = r17[1];
        f[] r20 = r10.f17416o0;
        f r21 = r20[0];
        f[] r22 = this.f17416o0;
        r22[0] = r21;
        r22[1] = r20[1];
        f[] r23 = r10.f17418p0;
        f r24 = r23[0];
        f[] r25 = this.f17418p0;
        r25[0] = r24;
        r25[1] = r23[1];
        f r26 = r10.f17420q0;
        if (r26 != null) goto L9;
        f r27 = null;
    L10:
        this.f17420q0 = r27;
        f r28 = r10.f17422r0;
        if (r28 == null) goto L14;
        r15 = (f) r11.get(r28);
    L14:
        this.f17422r0 = r15;
        return;
    L9:
        r27 = (f) r11.get(r26);
        goto L10
    L5:
        r16 = (f) r11.get(r10.V);
        goto L6
    }

    public final void h(fr.c r5) {
        r5.k(this.J);
        r5.k(this.K);
        r5.k(this.L);
        r5.k(this.M);
        if (this.f17399c0 <= 0) goto L6;
        r5.k(this.N);
        return;
    }

    public final void i() {
        if (this.d != null) goto L6;
        this.d = new com.obric.oui.constraintlayout.core.widgets.analyzer.m(this);
    L6:
        if (this.e != null) goto L9;
        this.e = new p(this);
        return;
    }

    public d j(ConstraintAnchor$Type r5) {
        switch(e.f17392a[r5.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r5.name());
    L9:
        return this.P;
    L11:
        return this.O;
    L13:
        return this.Q;
    L15:
        return this.N;
    L17:
        return this.M;
    L19:
        return this.L;
    L21:
        return this.K;
    L23:
        return this.J;
    }

    public final ConstraintWidget$DimensionBehaviour k(int r5) {
        if (r5 != 0) goto L6;
        return this.U[0];
    L6:
        if (r5 == 1) goto L8;
        return null;
    L8:
        return this.U[1];
    }

    public final int l() {
        if (this.i0 != 8) goto L7;
        return 0;
    L7:
        return this.X;
    }

    public final f m(int r5) {
        if (r5 != 0) goto L10;
        d r10 = this.L;
        d r11 = r10.f;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.f == r10) goto L8;
        return null;
    L8:
        return r11.d;
    L10:
        if (r5 != 1) goto L20;
        d r12 = this.M;
        d r13 = r12.f;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.f == r12) goto L16;
        return null;
    L16:
        return r13.d;
    L20:
        return null;
    }

    public final f n(int r5) {
        if (r5 != 0) goto L10;
        d r10 = this.J;
        d r11 = r10.f;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.f == r10) goto L8;
        return null;
    L8:
        return r11.d;
    L10:
        if (r5 != 1) goto L20;
        d r12 = this.K;
        d r13 = r12.f;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.f == r12) goto L16;
        return null;
    L16:
        return r13.d;
    L20:
        return null;
    }

    public void o(StringBuilder r13) {
        r13.append("  " + this.f17406j + ":{\n");
        StringBuilder r5 = new StringBuilder("    actualWidth:");
        r5.append(this.W);
        r13.append(r5.toString());
        r13.append("\n");
        r13.append("    actualHeight:" + this.X);
        r13.append("\n");
        r13.append("    actualLeft:" + this.f17395a0);
        r13.append("\n");
        r13.append("    actualTop:" + this.f17397b0);
        r13.append("\n");
        q(r13, OpenPageMethod.ALIGN_LEFT, this.J);
        q(r13, "top", this.K);
        q(r13, "right", this.L);
        q(r13, "bottom", this.M);
        q(r13, "baseline", this.N);
        q(r13, "centerX", this.O);
        q(r13, "centerY", this.P);
        int r10 = this.W;
        int r11 = this.f17400d0;
        int r12 = this.C[0];
        int r14 = this.f17426u;
        int r15 = this.f17421r;
        float r16 = this.f17428w;
        ConstraintWidget$DimensionBehaviour r17 = this.U[0];
        float[] r18 = this.f17414n0;
        float r19 = r18[0];
        p(r13, "    width", r10, r11, r12, r14, r15, r16, r17);
        int r20 = this.X;
        int r21 = this.f17401e0;
        int r22 = this.C[1];
        int r23 = this.f17429x;
        int r24 = this.s;
        float r25 = this.f17431z;
        ConstraintWidget$DimensionBehaviour r26 = this.U[1];
        float r27 = r18[1];
        p(r13, "    height", r20, r21, r22, r23, r24, r25, r26);
        float r28 = this.Y;
        int r29 = this.Z;
        if (r28 == 0.0f) goto L6;
        r13.append("    dimensionRatio");
        r13.append(" :  [");
        r13.append(r28);
        r13.append(",");
        r13.append(r29);
        r13.append("");
        r13.append("],\n");
    L6:
        I(r13, "    horizontalBias", this.f17402f0, 0.5f);
        I(r13, "    verticalBias", this.g0, 0.5f);
        H(r13, this.l0, 0, "    horizontalChainStyle");
        H(r13, this.f17412m0, 0, "    verticalChainStyle");
        r13.append("  }");
    }

    public final int r() {
        if (this.i0 != 8) goto L7;
        return 0;
    L7:
        return this.W;
    }

    public final int s() {
        f r5 = this.V;
        if (r5 == null) goto L9;
        if ((r5 instanceof g) == false) goto L9;
        return ((g) r5).B0 + this.f17395a0;
    L9:
        return this.f17395a0;
    }

    public final int t() {
        f r5 = this.V;
        if (r5 == null) goto L9;
        if ((r5 instanceof g) == false) goto L9;
        return ((g) r5).C0 + this.f17397b0;
    L9:
        return this.f17397b0;
    }

    public String toString() {
        String r5 = "";
        StringBuilder r10 = j0.u("");
        if (this.f17409k0 == null) goto L5;
        r5 = j0.q(new StringBuilder("id: "), this.f17409k0, " ");
    L5:
        r10.append(r5);
        r10.append("(");
        r10.append(this.f17395a0);
        r10.append(", ");
        r10.append(this.f17397b0);
        r10.append(") - (");
        r10.append(this.W);
        r10.append(" x ");
        return androidx.constraintlayout.motion.widget.a.s(r10, this.X, ")");
    }

    public final boolean u(int r5) {
        if (r5 != 0) goto L17;
        if (this.J.f == null) goto L7;
        int r10 = 1;
    L9:
        if (this.L.f == null) goto L11;
        int r11 = 1;
    L13:
        if ((r10 + r11) < 2) goto L15;
        return false;
    L15:
        return true;
    L11:
        r11 = 0;
        goto L13
    L7:
        r10 = 0;
        goto L9
    L17:
        if (this.K.f == null) goto L19;
        int r12 = 1;
    L21:
        if (this.M.f == null) goto L23;
        int r13 = 1;
    L24:
        int r14 = r12 + r13;
        if (this.N.f == null) goto L27;
        int r15 = 1;
    L29:
        if ((r14 + r15) < 2) goto L31;
        return false;
    L31:
        return true;
    L27:
        r15 = 0;
        goto L29
    L23:
        r13 = 0;
        goto L24
    L19:
        r12 = 0;
        goto L21
    }

    public final boolean v(int r5, int r10) {
        if (r5 != 0) goto L17;
        d r11 = this.J;
        d r12 = r11.f;
        if (r12 != null) goto L7;
    L30:
        return false;
    L7:
        if (r12.f17389c == false) goto L30;
        d r13 = this.L;
        d r14 = r13.f;
        if (r14 == null) goto L30;
        if (r14.f17389c == false) goto L30;
        int r15 = r14.d() - r13.e();
        int r16 = r11.f.d();
        if ((r15 - (r11.e() + r16)) < r10) goto L16;
        return true;
    L16:
        return false;
    L17:
        d r17 = this.K;
        d r18 = r17.f;
        if (r18 == null) goto L30;
        if (r18.f17389c == false) goto L30;
        d r19 = this.M;
        d r20 = r19.f;
        if (r20 == null) goto L30;
        if (r20.f17389c == false) goto L30;
        int r21 = r20.d() - r19.e();
        int r22 = r17.f.d();
        if ((r21 - (r17.e() + r22)) < r10) goto L29;
        return true;
    L29:
        return false;
    }

    public final void w(ConstraintAnchor$Type r5, f r10, ConstraintAnchor$Type r11, int r12, int r13) {
        j(r5).b(r10.j(r11), r12, r13, true);
    }

    public final boolean x(int r5) {
        int r10 = r5 * 2;
        d[] r11 = this.R;
        d r12 = r11[r10];
        d r13 = r12.f;
        if (r13 != null) goto L5;
    L11:
        return false;
    L5:
        if (r13.f == r12) goto L11;
        d r14 = r11[r10 + 1];
        d r15 = r14.f;
        if (r15 == null) goto L11;
        if (r15.f != r14) goto L11;
        return true;
    }

    public final boolean y() {
        d r5 = this.J;
        d r10 = r5.f;
        if (r10 != null) goto L5;
    L6:
        d r11 = this.L;
        d r12 = r11.f;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.f != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.f != r5) goto L6;
        return true;
    }

    public final boolean z() {
        d r5 = this.K;
        d r10 = r5.f;
        if (r10 != null) goto L5;
    L6:
        d r11 = this.M;
        d r12 = r11.f;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.f != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.f != r5) goto L6;
        return true;
    }
}
