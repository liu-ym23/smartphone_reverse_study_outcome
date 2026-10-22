package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.obric.oui.constraintlayout.core.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [com.obric.oui.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.obric.oui.constraintlayout.core.widgets.ConstraintWidget] */
    static void a(d r38, com.obric.oui.constraintlayout.core.d r39, int r40, int r41, c r42) {
        int r10 = r40;
        ConstraintWidget r11 = r42.f13636a;
        ConstraintWidget r12 = r42.c;
        ConstraintWidget r13 = r42.f13637b;
        ConstraintWidget r14 = r42.d;
        ConstraintWidget r2 = r42.e;
        float r3 = r42.k;
        ConstraintWidget r4 = r42.f;
        ConstraintWidget r5 = r42.g;
        if (r38.L[r10] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r6 = true;
    L7:
        if (r10 != 0) goto L20;
        if (r2.ao != 0) goto L11;
        boolean r8 = true;
    L13:
        if (r2.ao != 1) goto L15;
        boolean r15 = true;
    L17:
        if (r2.ao == 2) goto L29;
    L30:
        boolean r7 = false;
    L31:
        boolean r17 = r15;
        boolean r9 = false;
        boolean r16 = r8;
        ?? r18 = r11;
    L32:
        Object r22 = null;
        if (r9 == true) goto L90;
        ConstraintAnchor r19 = r18.f13606J[r41];
        if (r7 == false) goto L37;
        int r20 = 1;
    L38:
        int r24 = r19.i();
        float r25 = r3;
        boolean r26 = r9;
        if (r18.L[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L41;
    L43:
        boolean r21 = false;
    L45:
        if (r19.c == null) goto L48;
        if (r18 == r11) goto L48;
        r24 = r24 + r19.c.i();
    L48:
        int r23 = r24;
        if (r7 == false) goto L55;
        if (r18 == r11) goto L55;
        if (r18 == r13) goto L55;
        r20 = 8;
    L55:
        if (r19.c == null) goto L69;
        if (r18 != r13) goto L58;
        r39.a(r19.f, r19.c.f, r23, 6);
    L59:
        if (r21 == false) goto L62;
        if (r7 == true) goto L62;
        r20 = 5;
    L62:
        if (r18 != r13) goto L67;
        if (r7 == false) goto L67;
        if (r18.j(r10) == false) goto L67;
        int r27 = 5;
    L68:
        r39.c(r19.f, r19.c.f, r23, r27);
    L70:
        if (r6 == true) goto L72;
    L78:
        ConstraintAnchor r28 = r18.f13606J[r41 + 1].c;
        if (r28 == null) goto L86;
        ConstraintWidget r29 = r28.f13603a;
        if (r29.f13606J[r41].c == null) goto L86;
        if (r29.f13606J[r41].c.f13603a != r18) goto L86;
        r22 = r29;
    L86:
        if (r22 == null) goto L88;
        r18 = r22;
        r9 = r26;
    L89:
        r16 = r16;
        r3 = r25;
        r2 = r2;
        r11 = r11;
        r18 = r18;
        goto L32
    L88:
        r9 = true;
        goto L89
    L72:
        if (r18.B() != 8) goto L74;
    L76:
        int r30 = 0;
    L77:
        r39.a(r18.f13606J[r41].f, r38.f13606J[r41].f, r30, 8);
        goto L78
    L74:
        if (r18.L[r10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        r30 = 0;
        r39.a(r18.f13606J[r41 + 1].f, r18.f13606J[r41].f, 0, 5);
    L67:
        r27 = r20;
        goto L68
    L58:
        r39.a(r19.f, r19.c.f, r23, 8);
        goto L59
    L69:
        r2 = r2;
        r11 = r11;
        goto L70
    L41:
        if (r18.p[r10] != 0) goto L43;
        r21 = true;
        goto L45
    L37:
        r20 = 4;
        goto L38
    L90:
        ConstraintWidget r210 = r2;
        float r211 = r3;
        ConstraintWidget r212 = r11;
        boolean r213 = r16;
        if (r14 == null) goto L112;
        int r31 = r41 + 1;
        if (r12.f13606J[r31].c == null) goto L112;
        ConstraintAnchor r32 = r14.f13606J[r31];
        if (r14.L[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
    L99:
        boolean r33 = false;
    L100:
        if (r33 == false) goto L106;
        if (r7 == true) goto L106;
        if (r32.c.f13603a != r38) goto L106;
        r39.c(r32.f, r32.c.f, -r32.i(), 5);
    L110:
        r39.b(r32.f, r12.f13606J[r31].c.f, -r32.i(), 6);
    L106:
        if (r7 == false) goto L110;
        if (r32.c.f13603a != r38) goto L110;
        r39.c(r32.f, r32.c.f, -r32.i(), 4);
        goto L110
    L97:
        if (r14.p[r10] != 0) goto L99;
        r33 = true;
    L112:
        if (r6 == false) goto L114;
        int r34 = r41 + 1;
        r39.a(r38.f13606J[r34].f, r12.f13606J[r34].f, r12.f13606J[r34].i(), 8);
    L114:
        ArrayList<ConstraintWidget> r0 = r42.h;
        if (r0 == null) goto L143;
        int r35 = r0.size();
        if (r35 <= 1) goto L143;
        if (r42.p == true) goto L121;
    L123:
        float r36 = r211;
    L124:
        float r37 = 0.0f;
        float r310 = 0.0f;
        ConstraintWidget r43 = null;
        int r44 = 0;
    L125:
        if (r44 >= r35) goto L143;
        ConstraintWidget r45 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.get(r44), ConstraintWidget.class, "com.obric.memorydata.plugin");
        float r110 = r45.as[r10];
        if (r110 >= r37) goto L134;
        if (r42.r == false) goto L131;
        r39.c(r45.f13606J[r41 + 1].f, r45.f13606J[r41].f, 0, 4);
    L136:
        r0 = r0;
        r35 = r35;
    L142:
        r44 = r44 + 1;
        r35 = r35;
        r0 = r0;
        r37 = 0.0f;
        goto L125
    L131:
        r110 = 1.0f;
        r37 = 0.0f;
    L134:
        if (r110 != r37) goto L138;
        r39.c(r45.f13606J[r41 + 1].f, r45.f13606J[r41].f, 0, 8);
        goto L136
    L138:
        if (r43 == null) goto L141;
        SolverVariable r46 = r43.f13606J[r41].f;
        int r111 = r41 + 1;
        SolverVariable r47 = r43.f13606J[r111].f;
        SolverVariable r112 = r45.f13606J[r41].f;
        SolverVariable r1 = r45.f13606J[r111].f;
        com.obric.oui.constraintlayout.core.b r48 = r39.c();
        r48.a(r310, r36, r110, r46, r47, r112, r1);
        r39.a(r48);
    L141:
        r43 = r45;
        r310 = r110;
        goto L142
    L121:
        if (r42.r == true) goto L123;
        r36 = r42.j;
    L143:
        if (r13 == null) goto L165;
        if (r13 == r14) goto L146;
        if (r7 == false) goto L165;
    L146:
        ConstraintAnchor r49 = r212.f13606J[r41];
        int r50 = r41 + 1;
        ConstraintAnchor r51 = r12.f13606J[r50];
        if (r49.c == null) goto L149;
        SolverVariable r52 = r49.c.f;
    L151:
        if (r51.c == null) goto L153;
        SolverVariable r53 = r51.c.f;
    L154:
        ConstraintAnchor r54 = r13.f13606J[r41];
        if (r14 == null) goto L157;
        r51 = r14.f13606J[r50];
    L157:
        if (r52 == null) goto L297;
        if (r53 == null) goto L297;
        if (r10 != 0) goto L162;
        float r55 = r210.ab;
    L163:
        int r56 = r54.i();
        SolverVariable r57 = r52;
        r39.a(r54.f, r57, r56, r55, r53, r51.f, r51.i(), 7);
        goto L297
    L162:
        r55 = r210.ac;
    L297:
        if (r213 == true) goto L299;
        if (r17 == true) goto L299;
        return;
    L299:
        if (r13 == null) goto L341;
        if (r13 == r14) goto L342;
        ConstraintAnchor r58 = r13.f13606J[r41];
        if (r14 != null) goto L304;
        r14 = r13;
    L304:
        int r59 = r41 + 1;
        ConstraintAnchor r60 = r14.f13606J[r59];
        if (r58.c == null) goto L307;
        SolverVariable r61 = r58.c.f;
    L309:
        if (r60.c == null) goto L311;
        SolverVariable r62 = r60.c.f;
    L312:
        if (r12 == r14) goto L317;
        ConstraintAnchor r63 = r12.f13606J[r59];
        if (r63.c == null) goto L316;
        r22 = r63.c.f;
    L316:
        ?? r64 = r22;
    L318:
        if (r13 != r14) goto L320;
        r58 = r13.f13606J[r41];
        r60 = r13.f13606J[r59];
    L320:
        if (r61 == null) goto L343;
        if (r64 == 0) goto L344;
        int r65 = r58.i();
        int r66 = r14.f13606J[r59].i();
        r39.a(r58.f, r61, r65, 0.5f, r64, r60.f, r66, 5);
        return;
    L344:
        return;
    L343:
        return;
    L317:
        r64 = r62;
        goto L318
    L311:
        r62 = null;
        goto L312
    L307:
        r61 = null;
        goto L309
    L342:
        return;
    L341:
        return;
    L153:
        r53 = null;
        goto L154
    L149:
        r52 = null;
    L165:
        if (r213 == false) goto L230;
        if (r13 == null) goto L230;
        if (r42.j > 0) goto L170;
    L172:
        boolean r113 = false;
    L173:
        ConstraintWidget r67 = r13;
        ConstraintWidget r114 = r67;
    L174:
        if (r114 == null) goto L297;
        ConstraintWidget r68 = r114.au[r10];
    L176:
        if (r68 == null) goto L181;
        if (r68.B() != 8) goto L181;
        r68 = r68.au[r10];
    L181:
        if (r68 != null) goto L186;
        if (r114 == r14) goto L186;
    L226:
        if (r114.B() != 8) goto L229;
        r114 = r67;
    L229:
        r67 = r114;
        r114 = r68;
    L186:
        ConstraintAnchor r69 = r114.f13606J[r41];
        SolverVariable r70 = r69.f;
        if (r69.c == null) goto L189;
        SolverVariable r71 = r69.c.f;
    L190:
        if (r67 == r114) goto L193;
        ConstraintAnchor r72 = r67.f13606J[r41 + 1];
    L192:
        r71 = r72.f;
    L198:
        int r73 = r69.i();
        int r74 = r41 + 1;
        int r75 = r114.f13606J[r74].i();
        if (r68 == null) goto L202;
        ConstraintAnchor r76 = r68.f13606J[r41];
    L201:
        SolverVariable r77 = r76.f;
    L206:
        SolverVariable r78 = r114.f13606J[r74].f;
        if (r76 == null) goto L209;
        r75 = r75 + r76.i();
    L209:
        int r79 = r73 + r67.f13606J[r74].i();
        if (r70 == null) goto L226;
        if (r71 == null) goto L226;
        if (r77 == null) goto L226;
        if (r78 == null) goto L226;
        if (r114 != r13) goto L216;
        r79 = r13.f13606J[r41].i();
    L216:
        int r80 = r79;
        if (r114 != r14) goto L219;
        int r115 = r14.f13606J[r74].i();
    L220:
        if (r113 == false) goto L222;
        int r116 = 8;
    L223:
        r68 = r68;
        r39.a(r70, r71, r80, 0.5f, r77, r78, r115, r116);
        goto L226
    L222:
        r116 = 5;
        goto L223
    L219:
        r115 = r75;
        goto L220
    L202:
        r76 = r12.f13606J[r74].c;
        if (r76 != null) goto L201;
        r77 = null;
        goto L206
    L193:
        if (r114 != r13) goto L198;
        if (r212.f13606J[r41].c == null) goto L197;
        r72 = r212.f13606J[r41].c;
        goto L192
    L197:
        r71 = null;
        goto L198
    L189:
        r71 = null;
        goto L190
    L170:
        if (r42.i != r42.j) goto L172;
        r113 = true;
    L230:
        int r81 = 8;
        if (r17 == false) goto L297;
        if (r13 == null) goto L297;
        if (r42.j > 0) goto L236;
    L238:
        boolean r117 = false;
    L239:
        ConstraintWidget r82 = r13;
        ConstraintWidget r118 = r82;
    L240:
        if (r118 == null) goto L286;
        ConstraintWidget r83 = r118.au[r10];
    L242:
        if (r83 == null) goto L246;
        if (r83.B() != r81) goto L246;
        r83 = r83.au[r10];
    L246:
        if (r118 == r13) goto L280;
        if (r118 == r14) goto L280;
        if (r83 == null) goto L280;
        if (r83 != r14) goto L251;
        ConstraintWidget r84 = null;
    L252:
        ConstraintAnchor r85 = r118.f13606J[r41];
        SolverVariable r86 = r85.f;
        if (r85.c == null) goto L255;
        SolverVariable r87 = r85.c.f;
    L255:
        int r88 = r41 + 1;
        SolverVariable r89 = r82.f13606J[r88].f;
        int r90 = r85.i();
        int r91 = r118.f13606J[r88].i();
        if (r84 == null) goto L262;
        ConstraintAnchor r92 = r84.f13606J[r41];
        SolverVariable r93 = r92.f;
        if (r92.c == null) goto L260;
        SolverVariable r94 = r92.c.f;
    L261:
        SolverVariable r95 = r94;
        SolverVariable r96 = r93;
    L267:
        if (r92 == null) goto L269;
        r91 = r91 + r92.i();
    L269:
        int r119 = r91;
        int r97 = r82.f13606J[r88].i() + r90;
        if (r117 == false) goto L272;
        int r120 = 8;
    L273:
        if (r86 == null) goto L278;
        if (r89 == null) goto L278;
        if (r96 == null) goto L278;
        if (r95 == null) goto L278;
        int r121 = 8;
        r39.a(r86, r89, r97, 0.5f, r96, r95, r119, r120);
    L279:
        r83 = r84;
    L282:
        if (r118.B() == r121) goto L284;
        r82 = r118;
    L285:
        r118 = r83;
        r81 = r121;
        r10 = r40;
        goto L240
    L284:
        r82 = r82;
    L278:
        r121 = 8;
        goto L279
    L272:
        r120 = 4;
        goto L273
    L260:
        r94 = null;
        goto L261
    L262:
        r92 = r14.f13606J[r41];
        if (r92 == null) goto L265;
        r96 = r92.f;
    L266:
        r95 = r118.f13606J[r88].f;
        goto L267
    L265:
        r96 = null;
        goto L266
    L251:
        r84 = r83;
    L280:
        r82 = r82;
        r121 = r81;
        goto L282
    L286:
        ConstraintAnchor r98 = r13.f13606J[r41];
        ConstraintAnchor r99 = r212.f13606J[r41].c;
        int r100 = r41 + 1;
        ConstraintAnchor r122 = r14.f13606J[r100];
        ConstraintAnchor r123 = r12.f13606J[r100].c;
        if (r99 == null) goto L293;
        if (r13 == r14) goto L290;
        int r124 = 5;
        r39.c(r98.f, r99.f, r98.i(), 5);
    L294:
        if (r123 == null) goto L297;
        if (r13 == r14) goto L297;
        r39.c(r122.f, r123.f, -r122.i(), r124);
        goto L297
    L290:
        r124 = 5;
        if (r123 == null) goto L294;
        r39.a(r98.f, r99.f, r98.i(), 0.5f, r122.f, r123.f, r122.i(), 5);
        goto L294
    L293:
        r124 = 5;
        goto L294
    L236:
        if (r42.i != r42.j) goto L238;
        r117 = true;
    L29:
        r7 = true;
        goto L31
    L15:
        r15 = false;
        goto L17
    L11:
        r8 = false;
        goto L13
    L20:
        if (r2.ap != 0) goto L22;
        r8 = true;
    L24:
        if (r2.ap != 1) goto L26;
        r15 = true;
    L28:
        if (r2.ap != 2) goto L30;
    L26:
        r15 = false;
        goto L28
    L22:
        r8 = false;
        goto L24
    L5:
        r6 = false;
        goto L7
    }

    public static void a(d r7, com.obric.oui.constraintlayout.core.d r8, ArrayList<ConstraintWidget> r9, int r10) {
        int r0 = 0;
        if (r10 != 0) goto L5;
        int r1 = r7.aH;
        c[] r3 = r7.aK;
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L13;
        c r4 = r3[r0];
        r4.a();
        if (r9 != null) goto L10;
    L11:
        a(r7, r8, r10, r2, r4);
    L12:
        r0 = r0 + 1;
        goto L6
    L10:
        if (r9.contains(r4.f13636a) == false) goto L12;
    L13:
        return;
    L5:
        int r5 = r7.aI;
        r3 = r7.aJ;
        r2 = 2;
        r1 = r5;
        goto L6
    }
}
