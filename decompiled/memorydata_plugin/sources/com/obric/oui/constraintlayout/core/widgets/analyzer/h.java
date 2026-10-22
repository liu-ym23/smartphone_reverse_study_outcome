package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class h {
    public static n a(ConstraintWidget r7, int r8, ArrayList<n> r9, n r10) {
        if (r8 != 0) goto L4;
        int r0 = r7.ax;
    L5:
        int r1 = 0;
        if (r0 == (-1)) goto L19;
        if (r10 != null) goto L9;
    L10:
        int r4 = 0;
    L12:
        if (r4 >= r9.size()) goto L21;
        n r5 = (n) ZeusTransformUtils.preCheckCast(r9.get(r4), n.class, "com.obric.memorydata.plugin");
        if (r5.b() == r0) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        if (r10 == null) goto L17;
        r10.a(r8, r5);
        r9.remove(r10);
    L17:
        r10 = r5;
    L21:
        if (r10 != null) goto L37;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.core.widgets.h.class) == false) goto L33;
        int r2 = ((com.obric.oui.constraintlayout.core.widgets.h) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.constraintlayout.core.widgets.h.class, "com.obric.memorydata.plugin")).L(r8);
        if (r2 == (-1)) goto L33;
        int r3 = 0;
    L28:
        if (r3 >= r9.size()) goto L33;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r9.get(r3), n.class, "com.obric.memorydata.plugin");
        if (r6.b() == r2) goto L31;
        r3 = r3 + 1;
        goto L28
    L31:
        r10 = r6;
    L33:
        if (r10 != null) goto L35;
        r10 = new n(r8);
    L35:
        r9.add(r10);
    L37:
        if (r10.a(r7) == true) goto L39;
    L49:
        return r10;
    L39:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L44;
        com.obric.oui.constraintlayout.core.widgets.f r11 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        ConstraintAnchor r12 = r11.b();
        if (r11.c() != 0) goto L43;
        r1 = 1;
    L43:
        r12.a(r1, r9, r10);
    L44:
        int r13 = r10.b();
        if (r8 != 0) goto L47;
        r7.ax = r13;
        r7.B.a(r8, r9, r10);
        ConstraintAnchor r14 = r7.D;
    L48:
        r14.a(r8, r9, r10);
        r7.I.a(r8, r9, r10);
        goto L49
    L47:
        r7.ay = r13;
        r7.C.a(r8, r9, r10);
        r7.F.a(r8, r9, r10);
        r14 = r7.E;
        goto L48
    L9:
        if (r0 != r10.b()) goto L10;
    L19:
        if (r0 == (-1)) goto L21;
        return r10;
    L4:
        r0 = r7.ay;
        goto L5
    }

    private static n a(ArrayList<n> r5, int r6) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        n r2 = (n) ZeusTransformUtils.preCheckCast(r5.get(r1), n.class, "com.obric.memorydata.plugin");
        if (r6 == r2.b()) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static boolean a(ConstraintWidget.DimensionBehaviour r3, ConstraintWidget.DimensionBehaviour r4, ConstraintWidget.DimensionBehaviour r5, ConstraintWidget.DimensionBehaviour r6) {
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L5;
    L12:
        boolean r7 = true;
    L14:
        if (r6 != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L23:
        boolean r8 = true;
    L24:
        if (r7 == true) goto L28;
        if (r8 == true) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L23;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
    L22:
        r8 = false;
        goto L24
    L20:
        if (r4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L22;
    L5:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L12;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L9;
    L11:
        r7 = false;
        goto L14
    L9:
        if (r3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
        goto L11
    }

    public static boolean a(com.obric.oui.constraintlayout.core.widgets.d r17, b.InterfaceC0736b r18) {
        b.InterfaceC0736b r1 = (b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r18, b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        ArrayList<ConstraintWidget> r3 = r17.ak();
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        ConstraintWidget r7 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (a(r17.aa(), r17.ab(), r7.aa(), r7.ab()) == false) goto L6;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.core.widgets.e.class) == true) goto L9;
        r6 = r6 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L12:
        if (r17.aB == null) goto L14;
        r17.aB.G++;
    L14:
        int r8 = 0;
        ArrayList r9 = null;
        ArrayList r10 = null;
        ArrayList r11 = null;
        ArrayList r12 = null;
        ArrayList r13 = null;
        ArrayList r14 = null;
    L15:
        if (r8 >= r4) goto L76;
        ConstraintWidget r15 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.get(r8), ConstraintWidget.class, "com.obric.memorydata.plugin");
        ArrayList<ConstraintWidget> r16 = r3;
        if (a(r17.aa(), r17.ab(), r15.aa(), r15.ab()) == true) goto L20;
        com.obric.oui.constraintlayout.core.widgets.d.a(0, r15, r1, r17.aT, b.a.f13617a);
    L20:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.f.class) == false) goto L32;
        com.obric.oui.constraintlayout.core.widgets.f r5 = (com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin");
        if (r5.c() != 0) goto L27;
        if (r11 != null) goto L25;
        r11 = new ArrayList();
    L25:
        r11.add(r5);
    L27:
        if (r5.c() != 1) goto L32;
        if (r9 != null) goto L30;
        r9 = new ArrayList();
    L30:
        r9.add(r5);
    L32:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.h.class) == false) goto L52;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.a.class) == false) goto L44;
        com.obric.oui.constraintlayout.core.widgets.a r19 = (com.obric.oui.constraintlayout.core.widgets.a) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.core.widgets.a.class, "com.obric.memorydata.plugin");
        if (r19.h() != 0) goto L40;
        if (r10 != null) goto L39;
        r10 = new ArrayList();
    L39:
        r10.add(r19);
    L40:
        int r20 = r19.h();
        Object r21 = r19;
        if (r20 != 1) goto L52;
        if (r12 != null) goto L50;
        r12 = new ArrayList();
        r21 = r19;
    L50:
        r12.add(r21);
        goto L52
    L44:
        com.obric.oui.constraintlayout.core.widgets.h r22 = (com.obric.oui.constraintlayout.core.widgets.h) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.core.widgets.h.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L47;
        r10 = new ArrayList();
    L47:
        r10.add(r22);
        r21 = r22;
        if (r12 != null) goto L50;
        r12 = new ArrayList();
        r21 = r22;
    L52:
        if (r15.B.c != null) goto L63;
        if (r15.D.c != null) goto L63;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.f.class) == true) goto L63;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.a.class) == true) goto L63;
        if (r13 != null) goto L61;
        r13 = new ArrayList();
    L61:
        r13.add(r15);
    L63:
        if (r15.C.c != null) goto L75;
        if (r15.E.c != null) goto L75;
        if (r15.F.c != null) goto L75;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.f.class) == true) goto L75;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.core.widgets.a.class) == true) goto L75;
        if (r14 != null) goto L74;
        r14 = new ArrayList();
    L74:
        r14.add(r15);
    L75:
        r8 = r8 + 1;
        r3 = r16;
        goto L15
    L76:
        ArrayList<ConstraintWidget> r110 = r3;
        ArrayList<n> r2 = new ArrayList();
        if (r9 == null) goto L82;
        Iterator r23 = r9.iterator();
    L80:
        if (r23.hasNext() == false) goto L82;
        a((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin"), 0, r2, null);
    L82:
        if (r10 == null) goto L87;
        Iterator r24 = r10.iterator();
    L85:
        if (r24.hasNext() == false) goto L87;
        com.obric.oui.constraintlayout.core.widgets.h r25 = (com.obric.oui.constraintlayout.core.widgets.h) ZeusTransformUtils.preCheckCast(r24.next(), com.obric.oui.constraintlayout.core.widgets.h.class, "com.obric.memorydata.plugin");
        n r26 = a(r25, 0, r2, null);
        r25.a(r2, 0, r26);
        r26.a(r2);
    L87:
        ConstraintAnchor r27 = r17.a(ConstraintAnchor.Type.LEFT);
        if (r27.a() == null) goto L93;
        Iterator<ConstraintAnchor> r28 = r27.a().iterator();
    L91:
        if (r28.hasNext() == false) goto L93;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r28.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 0, r2, null);
    L93:
        ConstraintAnchor r29 = r17.a(ConstraintAnchor.Type.RIGHT);
        if (r29.a() == null) goto L99;
        Iterator<ConstraintAnchor> r30 = r29.a().iterator();
    L97:
        if (r30.hasNext() == false) goto L99;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r30.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 0, r2, null);
    L99:
        ConstraintAnchor r31 = r17.a(ConstraintAnchor.Type.CENTER);
        if (r31.a() == null) goto L105;
        Iterator<ConstraintAnchor> r32 = r31.a().iterator();
    L103:
        if (r32.hasNext() == false) goto L105;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r32.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 0, r2, null);
    L105:
        if (r13 == null) goto L110;
        Iterator r33 = r13.iterator();
    L108:
        if (r33.hasNext() == false) goto L110;
        a((ConstraintWidget) ZeusTransformUtils.preCheckCast(r33.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), 0, r2, null);
    L110:
        if (r11 == null) goto L115;
        Iterator r34 = r11.iterator();
    L113:
        if (r34.hasNext() == false) goto L115;
        a((com.obric.oui.constraintlayout.core.widgets.f) ZeusTransformUtils.preCheckCast(r34.next(), com.obric.oui.constraintlayout.core.widgets.f.class, "com.obric.memorydata.plugin"), 1, r2, null);
    L115:
        if (r12 == null) goto L120;
        Iterator r35 = r12.iterator();
    L118:
        if (r35.hasNext() == false) goto L120;
        com.obric.oui.constraintlayout.core.widgets.h r36 = (com.obric.oui.constraintlayout.core.widgets.h) ZeusTransformUtils.preCheckCast(r35.next(), com.obric.oui.constraintlayout.core.widgets.h.class, "com.obric.memorydata.plugin");
        n r37 = a(r36, 1, r2, null);
        r36.a(r2, 1, r37);
        r37.a(r2);
    L120:
        ConstraintAnchor r38 = r17.a(ConstraintAnchor.Type.TOP);
        if (r38.a() == null) goto L126;
        Iterator<ConstraintAnchor> r39 = r38.a().iterator();
    L124:
        if (r39.hasNext() == false) goto L126;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r39.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 1, r2, null);
    L126:
        ConstraintAnchor r40 = r17.a(ConstraintAnchor.Type.BASELINE);
        if (r40.a() == null) goto L132;
        Iterator<ConstraintAnchor> r41 = r40.a().iterator();
    L130:
        if (r41.hasNext() == false) goto L132;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r41.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 1, r2, null);
    L132:
        ConstraintAnchor r42 = r17.a(ConstraintAnchor.Type.BOTTOM);
        if (r42.a() == null) goto L138;
        Iterator<ConstraintAnchor> r43 = r42.a().iterator();
    L136:
        if (r43.hasNext() == false) goto L138;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r43.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 1, r2, null);
    L138:
        ConstraintAnchor r44 = r17.a(ConstraintAnchor.Type.CENTER);
        if (r44.a() == null) goto L144;
        Iterator<ConstraintAnchor> r45 = r44.a().iterator();
    L142:
        if (r45.hasNext() == false) goto L144;
        a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r45.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, 1, r2, null);
    L144:
        if (r14 == null) goto L149;
        Iterator r46 = r14.iterator();
    L147:
        if (r46.hasNext() == false) goto L149;
        a((ConstraintWidget) ZeusTransformUtils.preCheckCast(r46.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), 1, r2, null);
    L149:
        int r47 = 0;
    L150:
        if (r47 >= r4) goto L159;
        ArrayList<ConstraintWidget> r48 = r110;
        ConstraintWidget r49 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r48.get(r47), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r49.x() == false) goto L157;
        n r50 = a(r2, r49.ax);
        n r51 = a(r2, r49.ay);
        if (r50 == null) goto L157;
        if (r51 == null) goto L157;
        r50.a(0, r51);
        r51.a(2);
        r2.remove(r50);
    L157:
        r47 = r47 + 1;
        r110 = r48;
        goto L150
    L159:
        if (r2.size() > 1) goto L163;
        return false;
    L163:
        if (r17.aa() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L175;
        Iterator<n> r52 = r2.iterator();
        n r53 = null;
        int r111 = 0;
    L166:
        if (r52.hasNext() == false) goto L173;
        n r54 = (n) ZeusTransformUtils.preCheckCast(r52.next(), n.class, "com.obric.memorydata.plugin");
        if (r54.a() == 1) goto L166;
        r54.a(false);
        int r55 = r54.a(r17.aj(), 0);
        if (r55 <= r111) goto L166;
        r53 = r54;
        r111 = r55;
        goto L166
    L173:
        if (r53 == null) goto L175;
        r17.a(ConstraintWidget.DimensionBehaviour.FIXED);
        r17.q(r111);
        r53.a(true);
    L177:
        if (r17.ab() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L190;
        Iterator<n> r56 = r2.iterator();
        n r57 = null;
        int r112 = 0;
    L180:
        if (r56.hasNext() == false) goto L187;
        n r58 = (n) ZeusTransformUtils.preCheckCast(r56.next(), n.class, "com.obric.memorydata.plugin");
        if (r58.a() == 0) goto L180;
        r58.a(false);
        int r59 = r58.a(r17.aj(), 1);
        if (r59 <= r112) goto L180;
        r57 = r58;
        r112 = r59;
        goto L180
    L187:
        boolean r60 = false;
        boolean r61 = true;
        if (r57 == null) goto L191;
        r17.b(ConstraintWidget.DimensionBehaviour.FIXED);
        r17.r(r112);
        r57.a(true);
    L192:
        if (r53 != null) goto L197;
        if (r57 != null) goto L197;
        return r60;
    L197:
        return r61;
    L191:
        r57 = null;
        goto L192
    L190:
        r60 = false;
        r61 = true;
    L175:
        r53 = null;
        goto L177
    }
}
