package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class c extends WidgetRun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<WidgetRun> f13619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13620b;

    public c(ConstraintWidget r1, int r2) {
        super(r1);
        this.f13619a = new ArrayList();
        this.h = r2;
        h();
    }

    private void h() {
        ConstraintWidget r0 = this.d;
    L3:
        ConstraintWidget r1 = r0;
        r0 = r0.y(this.h);
        if (r0 != null) goto L3;
        this.d = r1;
        this.f13619a.add(r1.c(this.h));
        ConstraintWidget r2 = r1.z(this.h);
    L7:
        if (r2 == null) goto L9;
        this.f13619a.add(r2.c(this.h));
        r2 = r2.z(this.h);
        goto L7
    L9:
        Iterator<WidgetRun> r3 = this.f13619a.iterator();
    L11:
        if (r3.hasNext() == false) goto L19;
        WidgetRun r4 = (WidgetRun) ZeusTransformUtils.preCheckCast(r3.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (this.h == 0) goto L14;
        if (this.h != 1) goto L11;
        r4.d.e = this;
        goto L11
    L14:
        r4.d.d = this;
        goto L11
    L19:
        if (this.h == 0) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L29;
        if (this.f13619a.size() <= 1) goto L29;
        ArrayList<WidgetRun> r6 = this.f13619a;
        this.d = ((WidgetRun) ZeusTransformUtils.preCheckCast(r6.get(r6.size() - 1), WidgetRun.class, "com.obric.memorydata.plugin")).d;
    L29:
        if (this.h != 0) goto L31;
        int r7 = this.d.W();
    L32:
        this.f13620b = r7;
        return;
    L31:
        r7 = this.d.X();
        goto L32
    L21:
        if (((com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(this.d.A(), com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin")).ag() == false) goto L23;
        r5 = true;
        goto L24
    }

    private ConstraintWidget i() {
        int r0 = 0;
    L4:
        if (r0 >= this.f13619a.size()) goto L10;
        WidgetRun r1 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r0), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r1.d.B() != 8) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.d;
    L10:
        return null;
    }

    private ConstraintWidget j() {
        int r0 = this.f13619a.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        WidgetRun r1 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r0), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r1.d.B() != 8) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.d;
    L9:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        int r0 = this.f13619a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r2), WidgetRun.class, "com.obric.memorydata.plugin")).a() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public long b() {
        int r0 = this.f13619a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        WidgetRun r4 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r3), WidgetRun.class, "com.obric.memorydata.plugin");
        r1 = ((r1 + ((long) r4.j.f)) + r4.b()) + ((long) r4.k.f);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.e = null;
        Iterator<WidgetRun> r3 = this.f13619a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r3.next(), WidgetRun.class, "com.obric.memorydata.plugin")).c();
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        int r0 = 0;
    L4:
        if (r0 >= this.f13619a.size()) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r0), WidgetRun.class, "com.obric.memorydata.plugin")).e();
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        Iterator<WidgetRun> r0 = this.f13619a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r0.next(), WidgetRun.class, "com.obric.memorydata.plugin")).f();
        goto L4
    L6:
        int r1 = this.f13619a.size();
        if (r1 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r3 = ((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(0), WidgetRun.class, "com.obric.memorydata.plugin")).d;
        ConstraintWidget r2 = ((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r1 - 1), WidgetRun.class, "com.obric.memorydata.plugin")).d;
        if (this.h != 0) goto L21;
        ConstraintAnchor r4 = r3.B;
        ConstraintAnchor r5 = r2.D;
        DependencyNode r6 = a(r4, 0);
        int r7 = r4.i();
        ConstraintWidget r8 = i();
        if (r8 == null) goto L14;
        r7 = r8.B.i();
    L14:
        if (r6 == null) goto L16;
        a(this.j, r6, r7);
    L16:
        DependencyNode r9 = a(r5, 0);
        int r10 = r5.i();
        ConstraintWidget r11 = j();
        if (r11 == null) goto L19;
        r10 = r11.D.i();
    L19:
        if (r9 != null) goto L30;
    L31:
        this.j.f13612a = this;
        this.k.f13612a = this;
        return;
    L30:
        a(this.k, r9, -r10);
        goto L31
    L21:
        ConstraintAnchor r12 = r3.C;
        ConstraintAnchor r13 = r2.E;
        DependencyNode r14 = a(r12, 1);
        int r15 = r12.i();
        ConstraintWidget r16 = i();
        if (r16 == null) goto L24;
        r15 = r16.C.i();
    L24:
        if (r14 == null) goto L26;
        a(this.j, r14, r15);
    L26:
        r9 = a(r13, 1);
        r10 = r13.i();
        ConstraintWidget r17 = j();
        if (r17 == null) goto L29;
        r10 = r17.E.i();
    L29:
        if (r9 == null) goto L31;
        goto L30
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChainRun ");
        if (this.h != 0) goto L5;
        String r1 = "horizontal : ";
    L6:
        r0.append(r1);
        Iterator<WidgetRun> r4 = this.f13619a.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        WidgetRun r2 = (WidgetRun) ZeusTransformUtils.preCheckCast(r4.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        r0.append("<");
        r0.append(r2);
        r0.append("> ");
        goto L8
    L11:
        return r0.toString();
    L5:
        r1 = "vertical : ";
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r25) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r25, d.class, "com.obric.memorydata.plugin");
        if (this.j.j == true) goto L5;
        return;
    L5:
        if (this.k.j == false) goto L327;
        ConstraintWidget r2 = this.d.A();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.core.widgets.d.class) == false) goto L10;
        boolean r3 = ((com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin")).ag();
    L11:
        int r4 = this.k.g - this.j.g;
        int r5 = this.f13619a.size();
        int r6 = 0;
    L12:
        int r7 = -1;
        int r8 = 8;
        if (r6 >= r5) goto L17;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r6), WidgetRun.class, "com.obric.memorydata.plugin")).d.B() != 8) goto L18;
        r6 = r6 + 1;
    L18:
        int r9 = r5 - 1;
        int r10 = r9;
    L19:
        if (r10 < 0) goto L24;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r10), WidgetRun.class, "com.obric.memorydata.plugin")).d.B() != 8) goto L23;
        r10 = r10 - 1;
        goto L19
    L23:
        r7 = r10;
    L24:
        int r11 = 0;
    L26:
        if (r11 >= 2) goto L72;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        float r18 = 0.0f;
    L28:
        if (r14 >= r5) goto L67;
        WidgetRun r12 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r14), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r12.d.B() == r8) goto L66;
        r17 = r17 + 1;
        if (r14 <= 0) goto L36;
        if (r14 < r6) goto L36;
        r15 = r15 + r12.j.f;
    L36:
        int r13 = r12.g.g;
        if (r12.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r19 = true;
    L40:
        if (r19 == false) goto L52;
        if (this.h != 0) goto L47;
        if (r12.d.f.g.j == true) goto L47;
        return;
    L47:
        if (this.h == 1) goto L49;
    L58:
        if (r19 == true) goto L62;
        r16 = r16 + 1;
        float r20 = r12.d.as[this.h];
        if (r20 < 0.0f) goto L63;
        r18 = r18 + r20;
    L63:
        if (r14 >= r9) goto L66;
        if (r14 >= r7) goto L66;
        r15 = r15 + (-r12.k.f);
        goto L66
    L62:
        r15 = r15 + r13;
        goto L63
    L49:
        if (r12.d.g.g.j == true) goto L58;
        return;
    L52:
        if (r12.c != 1) goto L56;
        if (r11 != 0) goto L56;
        r13 = r12.g.m;
        r16 = r16 + 1;
    L57:
        r19 = true;
    L56:
        if (r12.g.j == false) goto L58;
    L39:
        r19 = false;
    L66:
        r14 = r14 + 1;
        r8 = 8;
        goto L28
    L67:
        if (r15 < r4) goto L71;
        if (r16 == 0) goto L71;
        r11 = r11 + 1;
        r8 = 8;
    L71:
        int r21 = r16;
        int r22 = r17;
    L73:
        int r110 = this.j.g;
        if (r3 == false) goto L77;
        r110 = this.k.g;
    L77:
        if (r15 <= r4) goto L82;
        int r111 = (int) (((r15 - r4) / 2.0f) + 0.5f);
        if (r3 == false) goto L81;
        r110 = r110 + r111;
        goto L82
    L81:
        r110 = r110 - r111;
    L82:
        if (r21 <= 0) goto L134;
        float r112 = r4 - r15;
        int r113 = (int) ((r112 / r21) + 0.5f);
        int r114 = 0;
        int r115 = 0;
    L84:
        if (r114 >= r5) goto L112;
        int r116 = r113;
        WidgetRun r117 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r114), WidgetRun.class, "com.obric.memorydata.plugin");
        int r23 = r15;
        if (r117.d.B() != 8) goto L89;
    L110:
        r112 = r112;
    L111:
        r114 = r114 + 1;
        r113 = r116;
        r15 = r23;
        r112 = r112;
        r110 = r110;
        r3 = r3;
        goto L84
    L89:
        if (r117.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L110;
        if (r117.g.j == true) goto L110;
        if (r18 <= 0.0f) goto L95;
        int r118 = (int) (((r117.d.as[this.h] * r112) / r18) + 0.5f);
    L97:
        if (this.h != 0) goto L99;
        int r119 = r117.d.r;
        int r120 = r117.d.q;
    L101:
        if (r117.c != 1) goto L103;
        int r24 = Math.min(r118, r117.g.m);
    L104:
        int r26 = Math.max(r120, r24);
        if (r119 <= 0) goto L107;
        r26 = Math.min(r119, r26);
    L107:
        if (r26 == r118) goto L109;
        r115 = r115 + 1;
        r118 = r26;
    L109:
        r117.g.a(r118);
        goto L111
    L103:
        r24 = r118;
        goto L104
    L99:
        r119 = r117.d.u;
        r120 = r117.d.t;
        goto L101
    L95:
        r118 = r116;
        goto L97
    L112:
        boolean r27 = r3;
        int r28 = r110;
        int r29 = r15;
        if (r115 <= 0) goto L128;
        r21 = r21 - r115;
        int r30 = 0;
        int r121 = 0;
    L115:
        if (r30 >= r5) goto L127;
        WidgetRun r122 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r30), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r122.d.B() == 8) goto L126;
        if (r30 <= 0) goto L122;
        if (r30 < r6) goto L122;
        r121 = r121 + r122.j.f;
    L122:
        r121 = r121 + r122.g.g;
        if (r30 >= r9) goto L126;
        if (r30 >= r7) goto L126;
        r121 = r121 + (-r122.k.f);
    L126:
        r30 = r30 + 1;
        goto L115
    L127:
        r15 = r121;
    L129:
        int r123 = 2;
        if (this.f13620b != 2) goto L133;
        if (r115 != 0) goto L133;
        int r31 = 0;
        this.f13620b = 0;
    L135:
        if (r15 <= r4) goto L137;
        this.f13620b = r123;
    L137:
        if (r22 <= 0) goto L141;
        if (r21 != 0) goto L141;
        if (r6 != r7) goto L141;
        this.f13620b = r123;
    L141:
        int r124 = this.f13620b;
        if (r124 != 1) goto L190;
        if (r22 <= 1) goto L145;
        int r32 = (r4 - r15) / (r22 - 1);
    L148:
        if (r21 <= 0) goto L150;
        r32 = r31;
    L150:
        int r33 = r31;
        int r125 = r28;
    L151:
        if (r33 >= r5) goto L328;
        if (r27 == false) goto L154;
        int r34 = r5 - (r33 + 1);
    L155:
        WidgetRun r35 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r34), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r35.d.B() != 8) goto L158;
        r35.j.a(r125);
        r35.k.a(r125);
    L189:
        r33 = r33 + 1;
        goto L151
    L158:
        if (r33 <= 0) goto L162;
        if (r27 == false) goto L161;
        r125 = r125 - r32;
        goto L162
    L161:
        r125 = r125 + r32;
    L162:
        if (r33 <= 0) goto L168;
        if (r33 < r6) goto L168;
        int r36 = r35.j.f;
        if (r27 == false) goto L167;
        r125 = r125 - r36;
        goto L168
    L167:
        r125 = r125 + r36;
    L168:
        if (r27 == false) goto L170;
        DependencyNode r37 = r35.k;
    L171:
        r37.a(r125);
        int r38 = r35.g.g;
        if (r35.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L174;
    L176:
        if (r27 == false) goto L178;
        r125 = r125 - r38;
    L179:
        if (r27 == false) goto L181;
        DependencyNode r39 = r35.j;
    L182:
        r39.a(r125);
        r35.i = true;
        if (r33 >= r9) goto L189;
        if (r33 >= r7) goto L189;
        int r40 = -r35.k.f;
        if (r27 == false) goto L188;
        r125 = r125 - r40;
        goto L189
    L188:
        r125 = r125 + r40;
        goto L189
    L181:
        r39 = r35.k;
        goto L182
    L178:
        r125 = r125 + r38;
        goto L179
    L174:
        if (r35.c != 1) goto L176;
        r38 = r35.g.m;
        goto L176
    L170:
        r37 = r35.j;
        goto L171
    L154:
        r34 = r33;
        goto L155
    L328:
        return;
    L145:
        if (r22 != 1) goto L147;
        r32 = (r4 - r15) / 2;
        goto L148
    L147:
        r32 = r31;
        goto L148
    L190:
        if (r124 != 0) goto L234;
        int r41 = (r4 - r15) / (r22 + 1);
        if (r21 <= 0) goto L194;
        r41 = r31;
    L194:
        int r42 = r31;
        int r126 = r28;
    L195:
        if (r42 >= r5) goto L329;
        if (r27 == false) goto L198;
        int r43 = r5 - (r42 + 1);
    L199:
        WidgetRun r44 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r43), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r44.d.B() != 8) goto L202;
        r44.j.a(r126);
        r44.k.a(r126);
    L232:
        r42 = r42 + 1;
        goto L195
    L202:
        if (r27 == false) goto L204;
        int r127 = r126 - r41;
    L205:
        if (r42 <= 0) goto L211;
        if (r42 < r6) goto L211;
        int r45 = r44.j.f;
        if (r27 == false) goto L210;
        r127 = r127 - r45;
        goto L211
    L210:
        r127 = r127 + r45;
    L211:
        if (r27 == false) goto L213;
        DependencyNode r46 = r44.k;
    L214:
        r46.a(r127);
        int r47 = r44.g.g;
        if (r44.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L217;
    L219:
        if (r27 == false) goto L221;
        r126 = r127 - r47;
    L222:
        if (r27 == false) goto L224;
        DependencyNode r48 = r44.j;
    L225:
        r48.a(r126);
        if (r42 >= r9) goto L232;
        if (r42 >= r7) goto L232;
        int r49 = -r44.k.f;
        if (r27 == false) goto L231;
        r126 = r126 - r49;
        goto L232
    L231:
        r126 = r126 + r49;
        goto L232
    L224:
        r48 = r44.k;
        goto L225
    L221:
        r126 = r127 + r47;
        goto L222
    L217:
        if (r44.c != 1) goto L219;
        r47 = Math.min(r47, r44.g.m);
        goto L219
    L213:
        r46 = r44.j;
        goto L214
    L204:
        r127 = r126 + r41;
        goto L205
    L198:
        r43 = r42;
        goto L199
    L329:
        return;
    L234:
        if (r124 == 2) goto L236;
        return;
    L236:
        if (this.h != 0) goto L238;
        float r50 = this.d.P();
    L239:
        if (r27 == false) goto L241;
        r50 = 1.0f - r50;
    L241:
        int r51 = (int) (((r4 - r15) * r50) + 0.5f);
        if (r51 < 0) goto L244;
        if (r21 > 0) goto L244;
    L245:
        if (r27 == false) goto L247;
        int r128 = r28 - r51;
    L248:
        int r52 = r31;
    L249:
        if (r52 >= r5) goto L330;
        if (r27 == false) goto L252;
        int r53 = r5 - (r52 + 1);
    L253:
        WidgetRun r54 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.f13619a.get(r53), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r54.d.B() != 8) goto L256;
        r54.j.a(r128);
        r54.k.a(r128);
    L284:
        r52 = r52 + 1;
        goto L249
    L256:
        if (r52 <= 0) goto L262;
        if (r52 < r6) goto L262;
        int r55 = r54.j.f;
        if (r27 == false) goto L261;
        r128 = r128 - r55;
        goto L262
    L261:
        r128 = r128 + r55;
    L262:
        if (r27 == false) goto L264;
        DependencyNode r56 = r54.k;
    L265:
        r56.a(r128);
        int r57 = r54.g.g;
        if (r54.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L271;
        if (r54.c != 1) goto L271;
        r57 = r54.g.m;
    L271:
        if (r27 == false) goto L273;
        r128 = r128 - r57;
    L274:
        if (r27 == false) goto L276;
        DependencyNode r58 = r54.j;
    L277:
        r58.a(r128);
        if (r52 >= r9) goto L284;
        if (r52 >= r7) goto L284;
        int r59 = -r54.k.f;
        if (r27 == false) goto L283;
        r128 = r128 - r59;
        goto L284
    L283:
        r128 = r128 + r59;
        goto L284
    L276:
        r58 = r54.k;
        goto L277
    L273:
        r128 = r128 + r57;
        goto L274
    L264:
        r56 = r54.j;
        goto L265
    L252:
        r53 = r52;
        goto L253
    L330:
        return;
    L247:
        r128 = r28 + r51;
    L244:
        r51 = r31;
        goto L245
    L238:
        r50 = this.d.Q();
    L133:
        r31 = 0;
        goto L135
    L128:
        r15 = r29;
        goto L129
    L134:
        r27 = r3;
        r28 = r110;
        r31 = 0;
        r123 = 2;
        goto L135
    L72:
        r21 = 0;
        r22 = 0;
        r15 = 0;
        r18 = 0.0f;
        goto L73
    L17:
        r6 = -1;
        goto L18
    L10:
        r3 = false;
        goto L11
    }
}
