package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12580a = null;

    static {
        f12580a = new b();
    }

    public static boolean a(hr.f r10) {
        ConstraintWidget$DimensionBehaviour[] r5 = r10.U;
        ConstraintWidget$DimensionBehaviour r11 = r5[0];
        ConstraintWidget$DimensionBehaviour r12 = r5[1];
        hr.f r13 = r10.V;
        if (r13 == null) goto L5;
        hr.g r14 = (hr.g) r13;
    L6:
        if (r14 == null) goto L8;
        ConstraintWidget$DimensionBehaviour r15 = r14.U[0];
        ConstraintWidget$DimensionBehaviour r16 = ConstraintWidget$DimensionBehaviour.FIXED;
    L8:
        if (r14 == null) goto L10;
        ConstraintWidget$DimensionBehaviour r17 = r14.U[1];
        ConstraintWidget$DimensionBehaviour r18 = ConstraintWidget$DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget$DimensionBehaviour r19 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r11 != r19) goto L13;
    L31:
        boolean r20 = true;
    L32:
        if (r12 != r19) goto L34;
    L52:
        boolean r21 = true;
    L54:
        if (r10.Y <= 0.0f) goto L58;
        if (r20 == true) goto L57;
        if (r21 == false) goto L58;
    L57:
        return true;
    L58:
        if (r20 == false) goto L62;
        if (r21 == true) goto L61;
        return false;
    L61:
        return true;
    L62:
        return false;
    L34:
        if (r10.C() == true) goto L52;
        if (r12 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L52;
        ConstraintWidget$DimensionBehaviour r22 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r22) goto L40;
    L45:
        if (r12 == r22) goto L47;
    L51:
        r21 = false;
        goto L54
    L47:
        if (r10.s != 1) goto L51;
        if (r10.v(1, r10.l()) == false) goto L51;
    L40:
        if (r10.s != 0) goto L45;
        if (r10.Y != 0.0f) goto L45;
        if (r10.u(1) == true) goto L52;
    L13:
        if (r10.B() == true) goto L31;
        if (r11 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L31;
        ConstraintWidget$DimensionBehaviour r23 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r11 == r23) goto L19;
    L24:
        if (r11 == r23) goto L26;
    L30:
        r20 = false;
        goto L32
    L26:
        if (r10.f17421r != 1) goto L30;
        if (r10.v(0, r10.r()) == false) goto L30;
    L19:
        if (r10.f17421r != 0) goto L24;
        if (r10.Y != 0.0f) goto L24;
        if (r10.u(0) == true) goto L31;
    L5:
        r14 = null;
        goto L6
    }

    public static q b(hr.f r10, int r11, ArrayList r12, q r13) {
        if (r11 != 0) goto L4;
        int r5 = r10.f17423s0;
    L5:
        int r14 = 0;
        if (r5 == (-1)) goto L19;
        if (r13 != null) goto L9;
    L10:
        int r15 = 0;
    L12:
        if (r15 >= r12.size()) goto L22;
        q r16 = (q) r12.get(r15);
        if (r16.f12589b == r5) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        if (r13 == null) goto L17;
        r13.c(r11, r16);
        r12.remove(r13);
    L17:
        r13 = r16;
    L22:
        if (r13 == null) goto L24;
    L50:
        ArrayList r17 = r13.f12588a;
        if (r17.contains(r10) == true) goto L64;
        r17.add(r10);
        if ((r10 instanceof hr.k) == false) goto L59;
        hr.k r18 = (hr.k) r10;
        hr.d r19 = r18.f17459x0;
        if (r18.f17460y0 != 0) goto L58;
        r14 = 1;
    L58:
        r19.c(r14, r13, r12);
    L59:
        int r20 = r13.f12589b;
        if (r11 != 0) goto L62;
        r10.f17423s0 = r20;
        r10.J.c(r11, r13, r12);
        r10.L.c(r11, r13, r12);
    L63:
        r10.Q.c(r11, r13, r12);
        goto L64
    L62:
        r10.f17425t0 = r20;
        r10.K.c(r11, r13, r12);
        r10.N.c(r11, r13, r12);
        r10.M.c(r11, r13, r12);
    L64:
        return r13;
    L24:
        if ((r10 instanceof hr.l) == false) goto L47;
        hr.l r21 = (hr.l) r10;
        int r22 = 0;
    L27:
        if (r22 >= r21.f17463v0) goto L38;
        hr.f r23 = r21.f17462u0[r22];
        if (r11 != 0) goto L33;
        int r24 = r23.f17423s0;
        if (r24 == (-1)) goto L33;
    L39:
        if (r24 == (-1)) goto L47;
        int r25 = 0;
    L42:
        if (r25 >= r12.size()) goto L47;
        q r26 = (q) r12.get(r25);
        if (r26.f12589b == r24) goto L45;
        r25 = r25 + 1;
        goto L42
    L45:
        r13 = r26;
    L33:
        if (r11 != 1) goto L37;
        r24 = r23.f17425t0;
        if (r24 != (-1)) goto L39;
    L37:
        r22 = r22 + 1;
        goto L27
    L38:
        r24 = -1;
    L47:
        if (r13 != null) goto L49;
        r13 = new q();
        r13.f12588a = new ArrayList();
        r13.d = null;
        r13.e = -1;
        int r27 = q.f;
        q.f = r27 + 1;
        r13.f12589b = r27;
        r13.f12590c = r11;
    L49:
        r12.add(r13);
        goto L50
    L9:
        if (r5 != r13.f12589b) goto L10;
    L19:
        if (r5 == (-1)) goto L22;
        return r13;
    L4:
        r5 = r10.f17425t0;
        goto L5
    }

    public static void c(int r16, c r17, hr.f r18, boolean r19) {
        if (r18.f17411m == false) goto L6;
        return;
    L6:
        if ((r18 instanceof hr.g) == false) goto L8;
    L12:
        hr.d r5 = r18.j(ConstraintAnchor$Type.LEFT);
        hr.d r10 = r18.j(ConstraintAnchor$Type.RIGHT);
        int r11 = r5.d();
        int r12 = r10.d();
        HashSet r13 = r5.f17387a;
        char r14 = 0;
        if (r13 == null) goto L75;
        if (r5.f17389c == false) goto L75;
        Iterator r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L75;
        hr.d r20 = (hr.d) r15.next();
        hr.f r110 = r20.d;
        int r111 = r16 + 1;
        boolean r112 = a(r110);
        if (r110.A() == false) goto L23;
        if (r112 == false) goto L23;
        hr.g.W(r110, r17, new b());
    L23:
        hr.d r113 = r110.J;
        hr.d r21 = r110.L;
        if (r20 != r113) goto L29;
        hr.d r114 = r21.f;
        if (r114 == null) goto L29;
        if (r114.f17389c == false) goto L29;
    L34:
        char r115 = 1;
    L36:
        ConstraintWidget$DimensionBehaviour r116 = r110.U[r14];
        ConstraintWidget$DimensionBehaviour r22 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r116 != r22) goto L60;
        if (r112 == true) goto L60;
        if (r116 != r22) goto L61;
        if (r110.f17427v < 0) goto L61;
        if (r110.f17426u < 0) goto L61;
        if (r110.i0 == 8) goto L52;
        if (r110.f17421r != 0) goto L61;
        if (r110.Y != 0.0f) goto L61;
    L52:
        if (r110.y() == true) goto L61;
        if (r110.G == true) goto L61;
        if (r115 == 0) goto L61;
        if (r110.y() == true) goto L61;
        e(r111, r18, r17, r110, r19);
    L61:
        r14 = 0;
    L60:
        if (r110.A() == true) goto L61;
        if (r20 == r113) goto L64;
    L66:
        if (r20 == r21) goto L68;
    L70:
        if (r115 == 0) goto L61;
        if (r110.y() == true) goto L61;
        d(r111, r17, r110, r19);
        goto L61
    L68:
        if (r113.f != null) goto L70;
        int r23 = r11 - r21.e();
        r110.K(r23 - r110.r(), r23);
        c(r111, r17, r110, r19);
        goto L61
    L64:
        if (r21.f != null) goto L66;
        int r24 = r113.e() + r11;
        r110.K(r24, r110.r() + r24);
        c(r111, r17, r110, r19);
    L29:
        if (r20 != r21) goto L35;
        hr.d r117 = r113.f;
        if (r117 == null) goto L35;
        if (r117.f17389c == true) goto L34;
    L35:
        r115 = r14;
    L75:
        if ((r18 instanceof hr.k) == false) goto L77;
        return;
    L77:
        HashSet r25 = r10.f17387a;
        if (r25 != null) goto L80;
    L143:
        r18.f17411m = true;
        return;
    L80:
        if (r10.f17389c == false) goto L143;
        Iterator r26 = r25.iterator();
    L83:
        if (r26.hasNext() == false) goto L143;
        hr.d r27 = (hr.d) r26.next();
        hr.f r28 = r27.d;
        int r29 = r16 + 1;
        boolean r30 = a(r28);
        if (r28.A() == false) goto L88;
        if (r30 == false) goto L88;
        hr.g.W(r28, r17, new b());
    L88:
        hr.d r31 = r28.J;
        hr.d r118 = r28.L;
        if (r27 != r31) goto L94;
        hr.d r119 = r118.f;
        if (r119 == null) goto L94;
        if (r119.f17389c == false) goto L94;
    L99:
        boolean r120 = true;
    L101:
        ConstraintWidget$DimensionBehaviour r121 = r28.U[0];
        ConstraintWidget$DimensionBehaviour r122 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r121 != r122) goto L129;
        if (r30 == true) goto L129;
        if (r121 != r122) goto L83;
        if (r28.f17427v < 0) goto L83;
        if (r28.f17426u < 0) goto L83;
        if (r28.i0 == 8) goto L120;
        if (r28.f17421r != 0) goto L83;
        if (r28.Y != 0.0f) goto L83;
    L120:
        if (r28.y() == true) goto L83;
        if (r28.G == true) goto L83;
        if (r120 == false) goto L83;
        if (r28.y() == true) goto L83;
        e(r29, r18, r17, r28, r19);
    L129:
        if (r28.A() == true) goto L83;
        if (r27 != r31) goto L135;
        if (r118.f != null) goto L135;
        int r32 = r31.e() + r12;
        r28.K(r32, r28.r() + r32);
        c(r29, r17, r28, r19);
    L135:
        if (r27 != r118) goto L139;
        if (r31.f != null) goto L139;
        int r33 = r12 - r118.e();
        r28.K(r33 - r28.r(), r33);
        c(r29, r17, r28, r19);
    L139:
        if (r120 == false) goto L83;
        if (r28.y() == true) goto L83;
        d(r29, r17, r28, r19);
    L94:
        if (r27 != r118) goto L100;
        hr.d r123 = r31.f;
        if (r123 == null) goto L100;
        if (r123.f17389c == true) goto L99;
    L100:
        r120 = false;
        goto L101
    L8:
        if (r18.A() == false) goto L12;
        if (a(r18) == false) goto L12;
        hr.g.W(r18, r17, new b());
        goto L12
    }

    public static void d(int r10, c r11, hr.f r12, boolean r13) {
        float r5 = r12.f17402f0;
        hr.d r14 = r12.J;
        int r15 = r14.f.d();
        hr.d r16 = r12.L;
        int r17 = r16.f.d();
        int r18 = r14.e() + r15;
        int r19 = r17 - r16.e();
        if (r15 != r17) goto L5;
        r5 = 0.5f;
    L6:
        int r20 = r12.r();
        int r21 = (r17 - r15) - r20;
        if (r15 <= r17) goto L9;
        r21 = (r15 - r17) - r20;
    L9:
        if (r21 <= 0) goto L12;
        float r22 = (r5 * r21) + 0.5f;
    L13:
        int r23 = ((int) r22) + r15;
        int r24 = r23 + r20;
        if (r15 <= r17) goto L16;
        r24 = r23 - r20;
    L16:
        r12.K(r23, r24);
        c(r10 + 1, r11, r12, r13);
        return;
    L12:
        r22 = r5 * r21;
        goto L13
    L5:
        r15 = r18;
        r17 = r19;
        goto L6
    }

    public static void e(int r10, hr.f r11, c r12, hr.f r13, boolean r14) {
        float r5 = r13.f17402f0;
        hr.d r15 = r13.J;
        int r16 = r15.e() + r15.f.d();
        hr.d r17 = r13.L;
        int r18 = r17.f.d() - r17.e();
        if (r18 < r16) goto L20;
        int r19 = r13.r();
        if (r13.i0 == 8) goto L18;
        int r20 = r13.f17421r;
        if (r20 == 2) goto L9;
        if (r20 != 0) goto L15;
        r19 = r18 - r16;
    L15:
        r19 = Math.max(r13.f17426u, r19);
        int r21 = r13.f17427v;
        if (r21 <= 0) goto L18;
        r19 = Math.min(r21, r19);
        goto L18
    L9:
        if ((r11 instanceof hr.g) == false) goto L11;
        int r22 = r11.r();
    L12:
        r19 = (int) ((r13.f17402f0 * 0.5f) * r22);
        goto L15
    L11:
        r22 = r11.V.r();
    L18:
        int r23 = r16 + ((int) ((r5 * ((r18 - r16) - r19)) + 0.5f));
        r13.K(r23, r19 + r23);
        c(r10 + 1, r12, r13, r14);
        return;
    }

    public static void f(int r10, c r11, hr.f r12) {
        float r5 = r12.g0;
        hr.d r13 = r12.K;
        int r14 = r13.f.d();
        hr.d r15 = r12.M;
        int r16 = r15.f.d();
        int r17 = r13.e() + r14;
        int r18 = r16 - r15.e();
        if (r14 != r16) goto L5;
        r5 = 0.5f;
    L6:
        int r19 = r12.l();
        int r20 = (r16 - r14) - r19;
        if (r14 <= r16) goto L9;
        r20 = (r14 - r16) - r19;
    L9:
        if (r20 <= 0) goto L12;
        float r21 = (r5 * r20) + 0.5f;
    L11:
        int r22 = (int) r21;
        int r23 = r14 + r22;
        int r24 = r23 + r19;
        if (r14 <= r16) goto L16;
        r23 = r14 - r22;
        r24 = r23 - r19;
    L16:
        r12.L(r23, r24);
        i(r10 + 1, r11, r12);
        return;
    L12:
        r21 = r5 * r20;
        goto L11
    L5:
        r14 = r17;
        r16 = r18;
        goto L6
    }

    public static void g(int r10, hr.f r11, c r12, hr.f r13) {
        float r5 = r13.g0;
        hr.d r14 = r13.K;
        int r15 = r14.e() + r14.f.d();
        hr.d r16 = r13.M;
        int r17 = r16.f.d() - r16.e();
        if (r17 < r15) goto L20;
        int r18 = r13.l();
        if (r13.i0 == 8) goto L18;
        int r19 = r13.s;
        if (r19 == 2) goto L9;
        if (r19 != 0) goto L15;
        r18 = r17 - r15;
    L15:
        r18 = Math.max(r13.f17429x, r18);
        int r20 = r13.f17430y;
        if (r20 <= 0) goto L18;
        r18 = Math.min(r20, r18);
        goto L18
    L9:
        if ((r11 instanceof hr.g) == false) goto L11;
        int r21 = r11.l();
    L12:
        r18 = (int) ((r5 * 0.5f) * r21);
        goto L15
    L11:
        r21 = r11.V.l();
    L18:
        int r22 = r15 + ((int) ((r5 * ((r17 - r15) - r18)) + 0.5f));
        r13.L(r22, r18 + r22);
        i(r10 + 1, r12, r13);
        return;
    }

    public static boolean h(ConstraintWidget$DimensionBehaviour r5, ConstraintWidget$DimensionBehaviour r10, ConstraintWidget$DimensionBehaviour r11, ConstraintWidget$DimensionBehaviour r12) {
        ConstraintWidget$DimensionBehaviour r13 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r11 == r13) goto L11;
        ConstraintWidget$DimensionBehaviour r14 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r11 == r14) goto L11;
        if (r11 != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r5 != r14) goto L11;
    L10:
        boolean r15 = false;
    L12:
        if (r12 == r13) goto L20;
        ConstraintWidget$DimensionBehaviour r16 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r16) goto L20;
        if (r12 != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r10 != r16) goto L20;
    L19:
        boolean r17 = false;
    L21:
        if (r15 == true) goto L25;
        if (r17 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r17 = true;
    L11:
        r15 = true;
        goto L12
    }

    public static void i(int r16, c r17, hr.f r18) {
        if (r18.f17413n == false) goto L6;
        return;
    L6:
        if ((r18 instanceof hr.g) == false) goto L8;
    L12:
        hr.d r5 = r18.j(ConstraintAnchor$Type.TOP);
        hr.d r10 = r18.j(ConstraintAnchor$Type.BOTTOM);
        int r11 = r5.d();
        int r12 = r10.d();
        HashSet r13 = r5.f17387a;
        char r14 = 1;
        if (r13 == null) goto L75;
        if (r5.f17389c == false) goto L75;
        Iterator r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L75;
        hr.d r19 = (hr.d) r15.next();
        hr.f r110 = r19.d;
        int r111 = r16 + 1;
        boolean r112 = a(r110);
        if (r110.A() == false) goto L23;
        if (r112 == false) goto L23;
        hr.g.W(r110, r17, new b());
    L23:
        hr.d r113 = r110.K;
        hr.d r114 = r110.M;
        if (r19 != r113) goto L29;
        hr.d r20 = r114.f;
        if (r20 == null) goto L29;
        if (r20.f17389c == false) goto L29;
    L34:
        char r21 = r14;
    L36:
        ConstraintWidget$DimensionBehaviour r22 = r110.U[r14];
        ConstraintWidget$DimensionBehaviour r23 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r22 != r23) goto L60;
        if (r112 == true) goto L60;
        if (r22 != r23) goto L61;
        if (r110.f17430y < 0) goto L61;
        if (r110.f17429x < 0) goto L61;
        if (r110.i0 == 8) goto L52;
        if (r110.s != 0) goto L61;
        if (r110.Y != 0.0f) goto L61;
    L52:
        if (r110.z() == true) goto L61;
        if (r110.G == true) goto L61;
        if (r21 == 0) goto L61;
        if (r110.z() == true) goto L61;
        g(r111, r18, r17, r110);
    L61:
        r14 = 1;
    L60:
        if (r110.A() == true) goto L61;
        if (r19 == r113) goto L64;
    L66:
        if (r19 == r114) goto L68;
    L70:
        if (r21 == 0) goto L61;
        if (r110.z() == true) goto L61;
        f(r111, r17, r110);
        goto L61
    L68:
        if (r113.f != null) goto L70;
        int r24 = r11 - r114.e();
        r110.L(r24 - r110.l(), r24);
        i(r111, r17, r110);
        goto L61
    L64:
        if (r114.f != null) goto L66;
        int r25 = r113.e() + r11;
        r110.L(r25, r110.l() + r25);
        i(r111, r17, r110);
    L29:
        if (r19 != r114) goto L35;
        hr.d r26 = r113.f;
        if (r26 == null) goto L35;
        if (r26.f17389c == true) goto L34;
    L35:
        r21 = 0;
    L75:
        if ((r18 instanceof hr.k) == false) goto L77;
        return;
    L77:
        HashSet r27 = r10.f17387a;
        if (r27 != null) goto L80;
    L142:
        hr.d r28 = r18.j(ConstraintAnchor$Type.BASELINE);
        if (r28.f17387a != null) goto L145;
    L168:
        r18.f17413n = true;
        return;
    L145:
        if (r28.f17389c == false) goto L168;
        int r29 = r28.d();
        Iterator r30 = r28.f17387a.iterator();
    L148:
        if (r30.hasNext() == false) goto L168;
        hr.d r31 = (hr.d) r30.next();
        hr.f r32 = r31.d;
        int r33 = r16 + 1;
        boolean r34 = a(r32);
        if (r32.A() == false) goto L154;
        if (r34 == false) goto L154;
        hr.g.W(r32, r17, new b());
    L154:
        if (r32.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L159;
        if (r34 == false) goto L148;
    L159:
        if (r32.A() == true) goto L148;
        hr.d r35 = r32.N;
        if (r31 != r35) goto L148;
        int r36 = r31.e() + r29;
        if (r32.E == false) goto L167;
        int r37 = r36 - r32.f17399c0;
        int r38 = r32.X + r37;
        r32.f17397b0 = r37;
        r32.K.l(r37);
        r32.M.l(r38);
        r35.l(r36);
        r32.f17410l = true;
    L167:
        i(r33, r17, r32);
        goto L148
    L80:
        if (r10.f17389c == false) goto L142;
        Iterator r39 = r27.iterator();
    L83:
        if (r39.hasNext() == false) goto L142;
        hr.d r40 = (hr.d) r39.next();
        hr.f r41 = r40.d;
        int r42 = r16 + 1;
        boolean r43 = a(r41);
        if (r41.A() == false) goto L88;
        if (r43 == false) goto L88;
        hr.g.W(r41, r17, new b());
    L88:
        hr.d r44 = r41.K;
        hr.d r45 = r41.M;
        if (r40 != r44) goto L94;
        hr.d r115 = r45.f;
        if (r115 == null) goto L94;
        if (r115.f17389c == false) goto L94;
    L99:
        boolean r116 = true;
    L101:
        ConstraintWidget$DimensionBehaviour r117 = r41.U[1];
        ConstraintWidget$DimensionBehaviour r118 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r117 != r118) goto L128;
        if (r43 == true) goto L128;
        if (r117 != r118) goto L83;
        if (r41.f17430y < 0) goto L83;
        if (r41.f17429x < 0) goto L83;
        if (r41.i0 == 8) goto L120;
        if (r41.s != 0) goto L83;
        if (r41.Y != 0.0f) goto L83;
    L120:
        if (r41.z() == true) goto L83;
        if (r41.G == true) goto L83;
        if (r116 == false) goto L83;
        if (r41.z() == true) goto L83;
        g(r42, r18, r17, r41);
    L128:
        if (r41.A() == true) goto L83;
        if (r40 != r44) goto L134;
        if (r45.f != null) goto L134;
        int r46 = r44.e() + r12;
        r41.L(r46, r41.l() + r46);
        i(r42, r17, r41);
    L134:
        if (r40 != r45) goto L138;
        if (r44.f != null) goto L138;
        int r47 = r12 - r45.e();
        r41.L(r47 - r41.l(), r47);
        i(r42, r17, r41);
    L138:
        if (r116 == false) goto L83;
        if (r41.z() == true) goto L83;
        f(r42, r17, r41);
    L94:
        if (r40 != r45) goto L100;
        hr.d r119 = r44.f;
        if (r119 == null) goto L100;
        if (r119.f17389c == true) goto L99;
    L100:
        r116 = false;
        goto L101
    L8:
        if (r18.A() == false) goto L12;
        if (a(r18) == false) goto L12;
        hr.g.W(r18, r17, new b());
        goto L12
    }
}
