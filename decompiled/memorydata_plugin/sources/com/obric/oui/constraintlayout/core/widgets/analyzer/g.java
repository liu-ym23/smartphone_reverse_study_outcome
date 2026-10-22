package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b.a f13623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f13624b;
    private static int c;

    static {
        f13623a = new b.a();
        f13624b = 0;
        c = 0;
    }

    private static void a(int r16, ConstraintWidget r17, b.InterfaceC0736b r18) {
        b.InterfaceC0736b r1 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r18, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        if (r17.k() == false) goto L5;
        return;
    L5:
        boolean r4 = true;
        c++;
        if (ZeusTransformUtils.instanceOf(r17, com.obric.oui.constraintlayout.core.widgets.d.class) == false) goto L8;
    L12:
        ConstraintAnchor r3 = r17.a(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r5 = r17.a(ConstraintAnchor.Type.BOTTOM);
        int r6 = r3.d();
        int r7 = r5.d();
        if (r3.a() == null) goto L80;
        if (r3.f() == false) goto L80;
        Iterator<ConstraintAnchor> r8 = r3.a().iterator();
    L18:
        if (r8.hasNext() == false) goto L80;
        ConstraintAnchor r9 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r8.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r12 = r9.f13603a;
        int r13 = r16 + 1;
        boolean r14 = a(r13, r12);
        if (r12.t() == false) goto L24;
        if (r14 == false) goto L24;
        com.obric.oui.constraintlayout.core.widgets.d.a(r13, r12, r1, new b.a(), b.a.f13617a);
    L24:
        if (r9 != r12.C) goto L30;
        if (r12.E.c == null) goto L30;
        if (r12.E.c.f() == false) goto L30;
    L35:
        boolean r11 = r4;
    L38:
        if (r12.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r14 == true) goto L62;
        if (r12.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
        if (r12.u < 0) goto L63;
        if (r12.t < 0) goto L63;
        if (r12.B() == 8) goto L54;
        if (r12.o != 0) goto L63;
        if (r12.U() != 0.0f) goto L63;
    L54:
        if (r12.ad() == true) goto L63;
        if (r12.p() == true) goto L63;
        if (r11 == false) goto L63;
        if (r12.ad() == true) goto L63;
        a(r13, r17, r1, r12);
    L63:
        r4 = true;
    L62:
        if (r12.t() == true) goto L63;
        if (r9 != r12.C) goto L71;
        if (r12.E.c != null) goto L71;
        int r10 = r12.C.i() + r6;
        r12.b(r10, r12.G() + r10);
    L69:
        a(r13, r12, r1);
    L71:
        if (r9 == r12.E) goto L73;
    L75:
        if (r11 == false) goto L63;
        if (r12.ad() == true) goto L63;
        a(r13, r1, r12);
        goto L63
    L73:
        if (r12.C.c != null) goto L75;
        int r15 = r6 - r12.E.i();
        r12.b(r15 - r12.G(), r15);
    L30:
        if (r9 == r12.E) goto L32;
    L36:
        r11 = false;
        goto L38
    L32:
        if (r12.C.c == null) goto L36;
        if (r12.C.c.f() == false) goto L36;
    L80:
        if (ZeusTransformUtils.instanceOf(r17, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L83;
        return;
    L83:
        if (r5.a() != null) goto L85;
    L149:
        ConstraintAnchor r19 = r17.a(ConstraintAnchor.Type.BASELINE);
        if (r19.a() != null) goto L152;
    L169:
        r17.m();
        return;
    L152:
        if (r19.f() == false) goto L169;
        int r20 = r19.d();
        Iterator<ConstraintAnchor> r21 = r19.a().iterator();
    L155:
        if (r21.hasNext() == false) goto L169;
        ConstraintAnchor r22 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r21.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r23 = r22.f13603a;
        int r24 = r16 + 1;
        boolean r25 = a(r24, r23);
        if (r23.t() == false) goto L161;
        if (r25 == false) goto L161;
        com.obric.oui.constraintlayout.core.widgets.d.a(r24, r23, r1, new b.a(), b.a.f13617a);
    L161:
        if (r23.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L164;
        if (r25 == false) goto L155;
    L164:
        if (r23.t() == true) goto L155;
        if (r22 != r23.F) goto L155;
        r23.f(r22.i() + r20);
        a(r24, r23, r1);
        goto L155
    L85:
        if (r5.f() == false) goto L149;
        Iterator<ConstraintAnchor> r26 = r5.a().iterator();
    L88:
        if (r26.hasNext() == false) goto L149;
        ConstraintAnchor r27 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r26.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r28 = r27.f13603a;
        int r29 = r16 + 1;
        boolean r30 = a(r29, r28);
        if (r28.t() == false) goto L94;
        if (r30 == false) goto L94;
        com.obric.oui.constraintlayout.core.widgets.d.a(r29, r28, r1, new b.a(), b.a.f13617a);
    L94:
        if (r27 != r28.C) goto L100;
        if (r28.E.c == null) goto L100;
        if (r28.E.c.f() == false) goto L100;
    L105:
        boolean r110 = true;
    L108:
        if (r28.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L132;
        if (r30 == true) goto L132;
        if (r28.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L88;
        if (r28.u < 0) goto L88;
        if (r28.t < 0) goto L88;
        if (r28.B() == 8) goto L124;
        if (r28.o != 0) goto L88;
        if (r28.U() != 0.0f) goto L88;
    L124:
        if (r28.ad() == true) goto L88;
        if (r28.p() == true) goto L88;
        if (r110 == false) goto L88;
        if (r28.ad() == true) goto L88;
        a(r29, r17, r1, r28);
    L132:
        if (r28.t() == true) goto L88;
        if (r27 != r28.C) goto L141;
        if (r28.E.c != null) goto L141;
        int r31 = r28.C.i() + r7;
        r28.b(r31, r28.G() + r31);
    L139:
        a(r29, r28, r1);
    L141:
        if (r27 != r28.E) goto L145;
        if (r28.C.c != null) goto L145;
        int r32 = r7 - r28.E.i();
        r28.b(r32 - r28.G(), r32);
    L145:
        if (r110 == false) goto L88;
        if (r28.ad() == true) goto L88;
        a(r29, r1, r28);
    L100:
        if (r27 == r28.E) goto L102;
    L106:
        r110 = false;
        goto L108
    L102:
        if (r28.C.c == null) goto L106;
        if (r28.C.c.f() == false) goto L106;
    L8:
        if (r17.t() == false) goto L12;
        int r33 = r16 + 1;
        if (a(r33, r17) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.a(r33, r17, r1, new b.a(), b.a.f13617a);
        goto L12
    }

    private static void a(int r7, ConstraintWidget r8, b.InterfaceC0736b r9, ConstraintWidget r10) {
        b.InterfaceC0736b r11 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r9, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        float r0 = r10.Q();
        int r1 = r10.C.c.d() + r10.C.i();
        int r2 = r10.E.c.d() - r10.E.i();
        if (r2 < r1) goto L21;
        int r3 = r10.G();
        if (r10.B() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.b(r4, r3 + r4);
        a(r7 + 1, r10, r11);
        return;
    L7:
        if (r10.o != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.constraintlayout.core.widgets.d.class) == true) goto L12;
        r8 = r8.A();
    L12:
        r3 = (int) ((r0 * 0.5f) * r8.G());
    L16:
        r3 = Math.max(r10.t, r3);
        if (r10.u <= 0) goto L19;
        r3 = Math.min(r10.u, r3);
        goto L19
    L14:
        if (r10.o != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static void a(int r7, ConstraintWidget r8, b.InterfaceC0736b r9, ConstraintWidget r10, boolean r11) {
        b.InterfaceC0736b r12 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r9, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        float r0 = r10.P();
        int r1 = r10.B.c.d() + r10.B.i();
        int r2 = r10.D.c.d() - r10.D.i();
        if (r2 < r1) goto L21;
        int r3 = r10.F();
        if (r10.B() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.a(r4, r3 + r4);
        a(r7 + 1, r10, r12, r11);
        return;
    L7:
        if (r10.n != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.constraintlayout.core.widgets.d.class) == true) goto L12;
        r8 = r8.A();
    L12:
        r3 = (int) ((r10.P() * 0.5f) * r8.F());
    L16:
        r3 = Math.max(r10.q, r3);
        if (r10.r <= 0) goto L19;
        r3 = Math.min(r10.r, r3);
        goto L19
    L14:
        if (r10.n != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static void a(int r17, ConstraintWidget r18, b.InterfaceC0736b r19, boolean r20) {
        b.InterfaceC0736b r2 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r19, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        if (r18.i_() == false) goto L5;
        return;
    L5:
        f13624b++;
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.constraintlayout.core.widgets.d.class) == false) goto L8;
    L12:
        ConstraintAnchor r4 = r18.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r6 = r18.a(ConstraintAnchor.Type.RIGHT);
        int r7 = r4.d();
        int r8 = r6.d();
        if (r4.a() == null) goto L80;
        if (r4.f() == false) goto L80;
        Iterator<ConstraintAnchor> r5 = r4.a().iterator();
    L18:
        if (r5.hasNext() == false) goto L80;
        ConstraintAnchor r9 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r5.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r13 = r9.f13603a;
        int r14 = r17 + 1;
        boolean r15 = a(r14, r13);
        if (r13.t() == false) goto L24;
        if (r15 == false) goto L24;
        com.obric.oui.constraintlayout.core.widgets.d.a(r14, r13, r2, new b.a(), b.a.f13617a);
    L24:
        if (r9 != r13.B) goto L30;
        if (r13.D.c == null) goto L30;
        if (r13.D.c.f() == false) goto L30;
    L35:
        boolean r10 = true;
    L38:
        if (r13.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r15 == true) goto L62;
        if (r13.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        if (r13.r < 0) goto L18;
        if (r13.q < 0) goto L18;
        if (r13.B() == 8) goto L54;
        if (r13.n != 0) goto L18;
        if (r13.U() != 0.0f) goto L18;
    L54:
        if (r13.ac() == true) goto L18;
        if (r13.p() == true) goto L18;
        if (r10 == false) goto L18;
        if (r13.ac() == true) goto L18;
        a(r14, r18, r2, r13, r20);
    L62:
        if (r13.t() == true) goto L18;
        if (r9 != r13.B) goto L71;
        if (r13.D.c != null) goto L71;
        int r11 = r13.B.i() + r7;
        r13.a(r11, r13.F() + r11);
    L69:
        a(r14, r13, r2, r20);
    L71:
        if (r9 == r13.D) goto L73;
    L75:
        if (r10 == false) goto L18;
        if (r13.ac() == true) goto L18;
        a(r14, r2, r13, r20);
        goto L18
    L73:
        if (r13.B.c != null) goto L75;
        int r12 = r7 - r13.D.i();
        r13.a(r12 - r13.F(), r12);
    L30:
        if (r9 == r13.D) goto L32;
    L36:
        r10 = false;
        goto L38
    L32:
        if (r13.B.c == null) goto L36;
        if (r13.B.c.f() == false) goto L36;
    L80:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L83;
        return;
    L83:
        if (r6.a() != null) goto L85;
    L152:
        r18.l();
        return;
    L85:
        if (r6.f() == false) goto L152;
        Iterator<ConstraintAnchor> r16 = r6.a().iterator();
    L88:
        if (r16.hasNext() == false) goto L152;
        ConstraintAnchor r21 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r16.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r22 = r21.f13603a;
        int r23 = r17 + 1;
        boolean r110 = a(r23, r22);
        if (r22.t() == false) goto L94;
        if (r110 == false) goto L94;
        com.obric.oui.constraintlayout.core.widgets.d.a(r23, r22, r2, new b.a(), b.a.f13617a);
    L94:
        if (r21 != r22.B) goto L100;
        if (r22.D.c == null) goto L100;
        if (r22.D.c.f() == false) goto L100;
    L105:
        boolean r111 = true;
    L108:
        if (r22.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L135;
        if (r110 == true) goto L135;
        if (r22.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L88;
        if (r22.r < 0) goto L88;
        if (r22.q < 0) goto L88;
        if (r22.B() == 8) goto L126;
        if (r22.n != 0) goto L88;
        if (r22.U() != 0.0f) goto L88;
    L126:
        if (r22.ac() == true) goto L88;
        if (r22.p() == true) goto L88;
        if (r111 == false) goto L88;
        if (r22.ac() == true) goto L88;
        a(r23, r18, r2, r22, r20);
    L135:
        if (r22.t() == true) goto L88;
        if (r21 != r22.B) goto L144;
        if (r22.D.c != null) goto L144;
        int r24 = r22.B.i() + r8;
        r22.a(r24, r22.F() + r24);
    L142:
        a(r23, r22, r2, r20);
    L144:
        if (r21 != r22.D) goto L148;
        if (r22.B.c != null) goto L148;
        int r25 = r8 - r22.D.i();
        r22.a(r25 - r22.F(), r25);
    L148:
        if (r111 == false) goto L88;
        if (r22.ac() == true) goto L88;
        a(r23, r2, r22, r20);
    L100:
        if (r21 == r22.D) goto L102;
    L106:
        r111 = false;
        goto L108
    L102:
        if (r22.B.c == null) goto L106;
        if (r22.B.c.f() == false) goto L106;
    L8:
        if (r18.t() == false) goto L12;
        int r26 = r17 + 1;
        if (a(r26, r18) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.a(r26, r18, r2, new b.a(), b.a.f13617a);
        goto L12
    }

    private static void a(int r2, com.obric.oui.constraintlayout.core.widgets.a r3, b.InterfaceC0736b r4, int r5, boolean r6) {
        b.InterfaceC0736b r7 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r4, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        if (r3.i() == false) goto L9;
        int r8 = r2 + 1;
        if (r5 != 0) goto L7;
        a(r8, r3, r7, r6);
        return;
    L7:
        a(r8, r3, r7);
        return;
    }

    private static void a(int r6, b.InterfaceC0736b r7, ConstraintWidget r8) {
        b.InterfaceC0736b r9 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r7, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        float r0 = r8.Q();
        int r1 = r8.C.c.d();
        int r2 = r8.E.c.d();
        int r3 = r8.C.i() + r1;
        int r4 = r2 - r8.E.i();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.G();
        int r10 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r10 = (r1 - r2) - r5;
    L9:
        if (r10 <= 0) goto L11;
        float r11 = (r0 * r10) + 0.5f;
    L12:
        int r12 = (int) r11;
        int r13 = r1 + r12;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r13 = r1 - r12;
        r14 = r13 - r5;
    L15:
        r8.b(r13, r14);
        a(r6 + 1, r8, r9);
        return;
    L11:
        r11 = r0 * r10;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void a(int r6, b.InterfaceC0736b r7, ConstraintWidget r8, boolean r9) {
        b.InterfaceC0736b r10 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r7, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        float r0 = r8.P();
        int r1 = r8.B.c.d();
        int r2 = r8.D.c.d();
        int r3 = r8.B.i() + r1;
        int r4 = r2 - r8.D.i();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.F();
        int r11 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r11 = (r1 - r2) - r5;
    L9:
        if (r11 <= 0) goto L11;
        float r12 = (r0 * r11) + 0.5f;
    L12:
        int r13 = ((int) r12) + r1;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r14 = r13 - r5;
    L15:
        r8.a(r13, r14);
        a(r6 + 1, r8, r10, r9);
        return;
    L11:
        r12 = r0 * r11;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    public static void a(com.obric.oui.constraintlayout.core.widgets.d r14, b.InterfaceC0736b r15) {
        b.InterfaceC0736b r16 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r15, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        ConstraintWidget.DimensionBehaviour r0 = r14.aa();
        ConstraintWidget.DimensionBehaviour r2 = r14.ab();
        f13624b = 0;
        c = 0;
        r14.n();
        ArrayList<ConstraintWidget> r4 = r14.ak();
        int r5 = r4.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin")).n();
        r6 = r6 + 1;
        goto L3
    L5:
        boolean r7 = r14.ag();
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r14.a(0, r14.F());
    L9:
        int r1 = 0;
        boolean r8 = false;
        boolean r9 = false;
    L11:
        if (r1 >= r5) goto L35;
        ConstraintWidget r12 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L30;
        com.obric.oui.constraintlayout.core.widgets.f r13 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r12, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        if (r13.c() != 1) goto L34;
        if (r13.g() == (-1)) goto L21;
        int r10 = r13.g();
    L19:
        r13.B(r10);
    L28:
        r8 = true;
        goto L34
    L21:
        if (r13.h() == (-1)) goto L26;
        if (r14.d() == false) goto L26;
        r10 = r14.F() - r13.h();
    L26:
        if (r14.d() == false) goto L28;
        r10 = (int) ((r13.f() * r14.F()) + 0.5f);
    L34:
        r1 = r1 + 1;
        goto L11
    L30:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L34;
        if (((com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r12, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin")).h() != 0) goto L34;
        r9 = true;
        goto L34
    L35:
        if (r8 == false) goto L44;
        int r3 = 0;
    L37:
        if (r3 >= r5) goto L44;
        ConstraintWidget r11 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L43;
        com.obric.oui.constraintlayout.core.widgets.f r17 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r11, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        if (r17.c() != 1) goto L43;
        a(0, r17, r16, r7);
    L43:
        r3 = r3 + 1;
    L44:
        a(0, r14, r16, r7);
        if (r9 == false) goto L55;
        int r18 = 0;
    L47:
        if (r18 >= r5) goto L55;
        ConstraintWidget r19 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r18), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L53;
        com.obric.oui.constraintlayout.core.widgets.a r20 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r19, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        if (r20.h() != 0) goto L53;
        a(0, r20, r16, 0, r7);
    L53:
        r18 = r18 + 1;
    L55:
        if (r2 != ConstraintWidget.DimensionBehaviour.FIXED) goto L57;
        r14.b(0, r14.G());
    L58:
        int r21 = 0;
        boolean r22 = false;
        boolean r23 = false;
    L59:
        if (r21 >= r5) goto L83;
        ConstraintWidget r24 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r21), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r24, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L78;
        com.obric.oui.constraintlayout.core.widgets.f r25 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r24, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        if (r25.c() != 0) goto L82;
        if (r25.g() == (-1)) goto L69;
        int r26 = r25.g();
    L67:
        r25.B(r26);
    L76:
        r22 = true;
        goto L82
    L69:
        if (r25.h() == (-1)) goto L74;
        if (r14.e() == false) goto L74;
        r26 = r14.G() - r25.h();
    L74:
        if (r14.e() == false) goto L76;
        r26 = (int) ((r25.f() * r14.G()) + 0.5f);
    L82:
        r21 = r21 + 1;
        goto L59
    L78:
        if (ZeusTransformUtils.instanceOf(r24, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L82;
        if (((com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r24, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin")).h() != 1) goto L82;
        r23 = true;
        goto L82
    L83:
        if (r22 == false) goto L92;
        int r27 = 0;
    L85:
        if (r27 >= r5) goto L92;
        ConstraintWidget r28 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r27), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r28, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L91;
        com.obric.oui.constraintlayout.core.widgets.f r29 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r28, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        if (r29.c() != 0) goto L91;
        a(1, r29, r16);
    L91:
        r27 = r27 + 1;
    L92:
        a(0, r14, r16);
        if (r23 == false) goto L102;
        int r110 = 0;
    L95:
        if (r110 >= r5) goto L102;
        ConstraintWidget r30 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r110), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r30, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L101;
        com.obric.oui.constraintlayout.core.widgets.a r31 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r30, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        if (r31.h() != 1) goto L101;
        a(0, r31, r16, 1, r7);
    L101:
        r110 = r110 + 1;
    L102:
        int r111 = 0;
    L103:
        if (r111 >= r5) goto L117;
        ConstraintWidget r32 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r111), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r32.t() == false) goto L116;
        if (a(0, r32) == false) goto L116;
        com.obric.oui.constraintlayout.core.widgets.d.a(0, r32, r16, f13623a, b.a.f13617a);
        if (ZeusTransformUtils.instanceOf(r32, com.obric.oui.constraintlayout.core.widgets.f.class) == true) goto L111;
        a(0, r32, r16, r7);
    L115:
        a(0, r32, r16);
        goto L116
    L111:
        if (((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r32, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin")).c() == 0) goto L115;
        a(0, r32, r16, r7);
    L116:
        r111 = r111 + 1;
        goto L103
    L117:
        return;
    L57:
        r14.e(0);
        goto L58
    L8:
        r14.d(0);
        goto L9
    }

    private static boolean a(int r5, ConstraintWidget r6) {
        ConstraintWidget.DimensionBehaviour r7 = r6.aa();
        ConstraintWidget.DimensionBehaviour r0 = r6.ab();
        if (r6.A() == null) goto L5;
        com.obric.oui.constraintlayout.core.widgets.d r1 = (com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(r6.A(), com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.aa();
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r1 == null) goto L11;
        r1.ab();
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
    L11:
        if (r7 != ConstraintWidget.DimensionBehaviour.FIXED) goto L13;
    L32:
        boolean r8 = true;
    L34:
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
    L55:
        boolean r4 = true;
    L57:
        if (r6.P <= 0.0f) goto L61;
        if (r8 == true) goto L60;
        if (r4 == false) goto L61;
    L60:
        return true;
    L61:
        if (r8 == false) goto L65;
        if (r4 == true) goto L64;
        return false;
    L64:
        return true;
    L65:
        return false;
    L36:
        if (r6.e() == true) goto L55;
        if (r0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L55;
        if (r0 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r6.o != 0) goto L48;
        if (r6.P != 0.0f) goto L48;
        if (r6.g(1) == true) goto L55;
    L48:
        if (r0 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L50;
    L54:
        r4 = false;
        goto L57
    L50:
        if (r6.o != 1) goto L54;
        if (r6.c(1, r6.G()) == false) goto L54;
    L13:
        if (r6.d() == true) goto L32;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
        if (r6.n != 0) goto L25;
        if (r6.P != 0.0f) goto L25;
        if (r6.g(0) == true) goto L32;
    L25:
        if (r7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
    L31:
        r8 = false;
        goto L34
    L27:
        if (r6.n != 1) goto L31;
        if (r6.c(0, r6.F()) == false) goto L31;
    L5:
        r1 = null;
        goto L6
    }
}
