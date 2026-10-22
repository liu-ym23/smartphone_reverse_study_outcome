package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12566l;

    public d(hr.f r5, int r10) {
        super(r5);
        this.f12565k = new ArrayList();
        this.f = r10;
        hr.f r11 = this.f12593b;
        hr.f r12 = r11.n(r10);
    L3:
        hr.f r13 = r12;
        hr.f r14 = r11;
        r11 = r13;
        if (r11 == null) goto L6;
        r12 = r11.n(this.f);
        goto L3
    L6:
        this.f12593b = r14;
        int r15 = this.f;
        if (r15 != 0) goto L9;
        s r16 = r14.d;
    L12:
        ArrayList r17 = this.f12565k;
        r17.add(r16);
        hr.f r18 = r14.m(this.f);
    L13:
        if (r18 == null) goto L21;
        int r19 = this.f;
        if (r19 != 0) goto L17;
        s r20 = r18.d;
    L20:
        r17.add(r20);
        r18 = r18.m(this.f);
        goto L13
    L17:
        if (r19 != 1) goto L19;
        r20 = r18.e;
        goto L20
    L19:
        r20 = null;
        goto L20
    L21:
        Iterator r21 = r17.iterator();
    L23:
        if (r21.hasNext() == false) goto L30;
        s r22 = (s) r21.next();
        int r23 = this.f;
        if (r23 == 0) goto L26;
        if (r23 != 1) goto L23;
        r22.f12593b.f17398c = this;
        goto L23
    L26:
        r22.f12593b.f17396b = this;
        goto L23
    L30:
        if (this.f != 0) goto L37;
        if (((hr.g) this.f12593b.V).f17437z0 == false) goto L37;
        if (r17.size() <= 1) goto L37;
        this.f12593b = ((s) androidx.constraintlayout.motion.widget.a.h(r17, 1)).f12593b;
    L37:
        if (this.f != 0) goto L39;
        int r24 = this.f12593b.l0;
    L40:
        this.f12566l = r24;
        return;
    L39:
        r24 = this.f12593b.f17412m0;
        goto L40
    L9:
        if (r15 != 1) goto L11;
        r16 = r14.e;
        goto L12
    L11:
        r16 = null;
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.e
    public final void a(e r27) {
        g r5 = this.f12595h;
        if (r5.f12576j == false) goto L282;
        g r10 = this.f12596i;
        if (r10.f12576j == false) goto L324;
        hr.f r11 = this.f12593b.V;
        if ((r11 instanceof hr.g) == false) goto L10;
        boolean r12 = ((hr.g) r11).f17437z0;
    L11:
        int r13 = r10.g - r5.g;
        ArrayList r14 = this.f12565k;
        int r15 = r14.size();
        int r16 = 0;
    L12:
        int r17 = -1;
        int r18 = 8;
        if (r16 >= r15) goto L17;
        if (((s) r14.get(r16)).f12593b.i0 != 8) goto L18;
        r16 = r16 + 1;
    L18:
        int r19 = r15 - 1;
        int r110 = r19;
    L19:
        if (r110 < 0) goto L24;
        if (((s) r14.get(r110)).f12593b.i0 != 8) goto L23;
        r110 = r110 - 1;
        goto L19
    L23:
        r17 = r110;
    L24:
        int r111 = 0;
    L26:
        if (r111 >= 2) goto L76;
        int r20 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        float r115 = 0.0f;
    L28:
        if (r20 >= r15) goto L70;
        s r116 = (s) r14.get(r20);
        hr.f r117 = r116.f12593b;
        ArrayList r21 = r14;
        if (r117.i0 != r18) goto L32;
        int r23 = r16;
    L69:
        r20 = r20 + 1;
        r14 = r21;
        r16 = r23;
        r18 = 8;
        goto L28
    L32:
        r114 = r114 + 1;
        if (r20 <= 0) goto L36;
        if (r20 < r16) goto L36;
        r112 = r112 + r116.f12595h.f;
    L36:
        h r22 = r116.e;
        int r118 = r22.g;
        r23 = r16;
        if (r116.d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r24 = true;
    L40:
        if (r24 == false) goto L53;
        int r25 = this.f;
        if (r25 != 0) goto L47;
        if (r117.d.e.f12576j == true) goto L47;
        return;
    L47:
        if (r25 != 1) goto L60;
        if (r117.e.e.f12576j == true) goto L60;
        return;
    L60:
        int r119 = r118;
    L61:
        if (r24 == true) goto L65;
        r113 = r113 + 1;
        float r26 = r117.f17414n0[this.f];
        if (r26 < 0.0f) goto L66;
        r115 = r115 + r26;
    L66:
        if (r20 >= r19) goto L69;
        if (r20 >= r17) goto L69;
        r112 = r112 + (-r116.f12596i.f);
        goto L69
    L65:
        r112 = r112 + r119;
        goto L66
    L53:
        if (r116.f12592a != 1) goto L58;
        if (r111 != 0) goto L58;
        r119 = r22.f12579m;
        r113 = r113 + 1;
    L56:
        r24 = true;
    L58:
        if (r22.f12576j == false) goto L60;
        r119 = r118;
        goto L56
    L39:
        r24 = false;
        goto L40
    L70:
        ArrayList r28 = r14;
        int r29 = r16;
        if (r112 < r13) goto L75;
        if (r113 == 0) goto L75;
        r111 = r111 + 1;
        r14 = r28;
        r16 = r29;
        r18 = 8;
    L75:
        int r30 = r113;
        int r31 = r114;
    L77:
        int r32 = r5.g;
        if (r12 == false) goto L81;
        r32 = r10.g;
    L81:
        if (r112 > r13) goto L83;
    L86:
        if (r30 <= 0) goto L138;
        float r33 = r13 - r112;
        int r120 = (int) ((r33 / r30) + 0.5f);
        int r121 = 0;
        int r122 = 0;
    L88:
        if (r121 >= r15) goto L115;
        ArrayList r123 = r28;
        s r34 = (s) r123.get(r121);
        int r124 = r120;
        hr.f r125 = r34.f12593b;
        int r210 = r112;
        int r211 = r32;
        if (r125.i0 != 8) goto L93;
    L91:
        r12 = r12;
    L114:
        r121 = r121 + 1;
        r120 = r124;
        r112 = r210;
        r32 = r211;
        r12 = r12;
        r33 = r33;
        r28 = r123;
        goto L88
    L93:
        if (r34.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L91;
        h r35 = r34.e;
        if (r35.f12576j == true) goto L91;
        if (r115 <= 0.0f) goto L99;
        int r36 = (int) (((r125.f17414n0[this.f] * r33) / r115) + 0.5f);
    L101:
        if (this.f != 0) goto L103;
        int r126 = r125.f17427v;
        int r127 = r125.f17426u;
    L105:
        if (r34.f12592a != 1) goto L107;
        int r37 = Math.min(r36, r35.f12579m);
    L108:
        int r38 = Math.max(r127, r37);
        if (r126 <= 0) goto L111;
        r38 = Math.min(r126, r38);
    L111:
        if (r38 == r36) goto L113;
        r122 = r122 + 1;
        r36 = r38;
    L113:
        r35.d(r36);
        goto L114
    L107:
        r37 = r36;
        goto L108
    L103:
        r126 = r125.f17430y;
        r127 = r125.f17429x;
        goto L105
    L99:
        r36 = r124;
        goto L101
    L115:
        int r212 = r32;
        boolean r213 = r12;
        ArrayList r128 = r28;
        int r214 = r112;
        if (r122 <= 0) goto L132;
        r30 = r30 - r122;
        int r39 = 0;
        r112 = 0;
    L118:
        if (r39 >= r15) goto L131;
        s r40 = (s) r128.get(r39);
        if (r40.f12593b.i0 != 8) goto L122;
        int r41 = r29;
    L130:
        r39 = r39 + 1;
        r29 = r41;
        goto L118
    L122:
        r41 = r29;
        if (r39 <= 0) goto L126;
        if (r39 < r41) goto L126;
        r112 = r112 + r40.f12595h.f;
    L126:
        r112 = r112 + r40.e.g;
        if (r39 >= r19) goto L130;
        if (r39 >= r17) goto L130;
        r112 = r112 + (-r40.f12596i.f);
        goto L130
    L131:
        int r42 = r29;
    L133:
        int r43 = 2;
        if (this.f12566l != 2) goto L137;
        if (r122 != 0) goto L137;
        int r44 = 0;
        this.f12566l = 0;
    L139:
        if (r112 <= r13) goto L141;
        this.f12566l = r43;
    L141:
        if (r31 <= 0) goto L145;
        if (r30 != 0) goto L145;
        if (r42 != r17) goto L145;
        this.f12566l = r43;
    L145:
        int r45 = this.f12566l;
        if (r45 != 1) goto L193;
        if (r31 <= 1) goto L149;
        int r46 = (r13 - r112) / (r31 - 1);
    L152:
        if (r30 <= 0) goto L154;
        r46 = r44;
    L154:
        int r47 = r44;
        int r48 = r212;
    L155:
        if (r47 >= r15) goto L325;
        if (r213 == false) goto L158;
        int r49 = r15 - (r47 + 1);
    L159:
        s r50 = (s) r128.get(r49);
        int r51 = r50.f12593b.i0;
        g r52 = r50.f12596i;
        g r53 = r50.f12595h;
        if (r51 != 8) goto L162;
        r53.d(r48);
        r52.d(r48);
    L192:
        r47 = r47 + 1;
        goto L155
    L162:
        if (r47 <= 0) goto L166;
        if (r213 == false) goto L165;
        r48 = r48 - r46;
        goto L166
    L165:
        r48 = r48 + r46;
    L166:
        if (r47 <= 0) goto L171;
        if (r47 < r42) goto L171;
        if (r213 == false) goto L170;
        r48 = r48 - r53.f;
        goto L171
    L170:
        r48 = r48 + r53.f;
    L171:
        if (r213 == false) goto L173;
        r52.d(r48);
    L174:
        h r54 = r50.e;
        int r129 = r54.g;
        if (r50.d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L177;
    L179:
        if (r213 == false) goto L181;
        r48 = r48 - r129;
    L182:
        if (r213 == false) goto L185;
        r53.d(r48);
    L186:
        r50.g = true;
        if (r47 >= r19) goto L192;
        if (r47 >= r17) goto L192;
        if (r213 == false) goto L191;
        r48 = r48 - (-r52.f);
        goto L192
    L191:
        r48 = r48 + (-r52.f);
        goto L192
    L185:
        r52.d(r48);
        goto L186
    L181:
        r48 = r48 + r129;
        goto L182
    L177:
        if (r50.f12592a != 1) goto L179;
        r129 = r54.f12579m;
        goto L179
    L173:
        r53.d(r48);
        goto L174
    L158:
        r49 = r47;
        goto L159
    L325:
        return;
    L149:
        if (r31 != 1) goto L151;
        r46 = (r13 - r112) / 2;
        goto L152
    L151:
        r46 = r44;
        goto L152
    L193:
        if (r45 != 0) goto L234;
        int r55 = (r13 - r112) / (r31 + 1);
        if (r30 <= 0) goto L197;
        r55 = r44;
    L197:
        int r56 = r44;
        int r57 = r212;
    L198:
        if (r56 >= r15) goto L326;
        if (r213 == false) goto L201;
        int r58 = r15 - (r56 + 1);
    L202:
        s r59 = (s) r128.get(r58);
        int r60 = r59.f12593b.i0;
        g r61 = r59.f12596i;
        g r62 = r59.f12595h;
        if (r60 != 8) goto L205;
        r62.d(r57);
        r61.d(r57);
    L232:
        r56 = r56 + 1;
        goto L198
    L205:
        if (r213 == false) goto L207;
        int r63 = r57 - r55;
    L208:
        if (r56 <= 0) goto L213;
        if (r56 < r42) goto L213;
        if (r213 == false) goto L212;
        r63 = r63 - r62.f;
        goto L213
    L212:
        r63 = r63 + r62.f;
    L213:
        if (r213 == false) goto L215;
        r61.d(r63);
    L216:
        h r64 = r59.e;
        int r130 = r64.g;
        if (r59.d == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L219;
    L221:
        if (r213 == false) goto L223;
        r57 = r63 - r130;
    L224:
        if (r213 == false) goto L226;
        r62.d(r57);
    L227:
        if (r56 >= r19) goto L232;
        if (r56 >= r17) goto L232;
        if (r213 == false) goto L231;
        r57 = r57 - (-r61.f);
        goto L232
    L231:
        r57 = r57 + (-r61.f);
        goto L232
    L226:
        r61.d(r57);
        goto L227
    L223:
        r57 = r63 + r130;
        goto L224
    L219:
        if (r59.f12592a != 1) goto L221;
        r130 = Math.min(r130, r64.f12579m);
        goto L221
    L215:
        r62.d(r63);
        goto L216
    L207:
        r63 = r57 + r55;
        goto L208
    L201:
        r58 = r56;
        goto L202
    L326:
        return;
    L234:
        if (r45 == 2) goto L236;
        return;
    L236:
        if (this.f != 0) goto L238;
        float r65 = this.f12593b.f17402f0;
    L239:
        if (r213 == false) goto L241;
        r65 = 1.0f - r65;
    L241:
        int r66 = (int) (((r13 - r112) * r65) + 0.5f);
        if (r66 < 0) goto L244;
        if (r30 > 0) goto L244;
    L245:
        if (r213 == false) goto L247;
        int r67 = r212 - r66;
    L248:
        int r68 = r44;
    L249:
        if (r68 >= r15) goto L327;
        if (r213 == false) goto L252;
        int r69 = r15 - (r68 + 1);
    L253:
        s r70 = (s) r128.get(r69);
        int r71 = r70.f12593b.i0;
        g r72 = r70.f12596i;
        g r73 = r70.f12595h;
        if (r71 != 8) goto L256;
        r73.d(r67);
        r72.d(r67);
    L281:
        r68 = r68 + 1;
        goto L249
    L256:
        if (r68 <= 0) goto L261;
        if (r68 < r42) goto L261;
        if (r213 == false) goto L260;
        r67 = r67 - r73.f;
        goto L261
    L260:
        r67 = r67 + r73.f;
    L261:
        if (r213 == false) goto L263;
        r72.d(r67);
    L264:
        h r74 = r70.e;
        int r131 = r74.g;
        if (r70.d != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L270;
        if (r70.f12592a != 1) goto L270;
        r131 = r74.f12579m;
    L270:
        if (r213 == false) goto L272;
        r67 = r67 - r131;
    L273:
        if (r213 == false) goto L275;
        r73.d(r67);
    L276:
        if (r68 >= r19) goto L281;
        if (r68 >= r17) goto L281;
        if (r213 == false) goto L280;
        r67 = r67 - (-r72.f);
        goto L281
    L280:
        r67 = r67 + (-r72.f);
        goto L281
    L275:
        r72.d(r67);
        goto L276
    L272:
        r67 = r67 + r131;
        goto L273
    L263:
        r73.d(r67);
        goto L264
    L252:
        r69 = r68;
        goto L253
    L327:
        return;
    L247:
        r67 = r212 + r66;
    L244:
        r66 = r44;
        goto L245
    L238:
        r65 = this.f12593b.g0;
    L137:
        r44 = 0;
        goto L139
    L132:
        r42 = r29;
        r112 = r214;
        goto L133
    L138:
        r212 = r32;
        r213 = r12;
        r128 = r28;
        r42 = r29;
        r44 = 0;
        r43 = 2;
        goto L139
    L83:
        if (r12 == false) goto L85;
        r32 = r32 + ((int) (((r112 - r13) / 2.0f) + 0.5f));
        goto L86
    L85:
        r32 = r32 - ((int) (((r112 - r13) / 2.0f) + 0.5f));
        goto L86
    L76:
        r28 = r14;
        r29 = r16;
        r30 = 0;
        r31 = 0;
        r112 = 0;
        r115 = 0.0f;
        goto L77
    L17:
        r16 = -1;
        goto L18
    L10:
        r12 = false;
        goto L11
    L324:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void d() {
        ArrayList r5 = this.f12565k;
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((s) r10.next()).d();
        goto L4
    L6:
        int r11 = r5.size();
        if (r11 >= 1) goto L9;
        return;
    L9:
        hr.f r12 = ((s) r5.get(0)).f12593b;
        hr.f r13 = ((s) r5.get(r11 - 1)).f12593b;
        int r14 = this.f;
        g r15 = this.f12596i;
        g r16 = this.f12595h;
        if (r14 != 0) goto L21;
        hr.d r17 = r12.J;
        hr.d r18 = r13.L;
        g r19 = s.i(r17, 0);
        int r20 = r17.e();
        hr.f r21 = m();
        if (r21 == null) goto L14;
        r20 = r21.J.e();
    L14:
        if (r19 == null) goto L16;
        s.b(r16, r19, r20);
    L16:
        g r22 = s.i(r18, 0);
        int r23 = r18.e();
        hr.f r24 = n();
        if (r24 == null) goto L19;
        r23 = r24.L.e();
    L19:
        if (r22 == null) goto L31;
        s.b(r15, r22, -r23);
    L31:
        r16.f12571a = this;
        r15.f12571a = this;
        return;
    L21:
        hr.d r25 = r12.K;
        hr.d r26 = r13.M;
        g r27 = s.i(r25, 1);
        int r28 = r25.e();
        hr.f r29 = m();
        if (r29 == null) goto L24;
        r28 = r29.K.e();
    L24:
        if (r27 == null) goto L26;
        s.b(r16, r27, r28);
    L26:
        g r30 = s.i(r26, 1);
        int r31 = r26.e();
        hr.f r32 = n();
        if (r32 == null) goto L29;
        r31 = r32.M.e();
    L29:
        if (r30 == null) goto L31;
        s.b(r15, r30, -r31);
        goto L31
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void e() {
        int r5 = 0;
    L3:
        ArrayList r10 = this.f12565k;
        if (r5 >= r10.size()) goto L6;
        ((s) r10.get(r5)).e();
        r5 = r5 + 1;
        goto L3
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final void f() {
        this.f12594c = null;
        Iterator r5 = this.f12565k.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((s) r5.next()).f();
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final long j() {
        ArrayList r10 = this.f12565k;
        int r5 = r10.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        s r13 = (s) r10.get(r12);
        long r14 = r11 + ((long) r13.f12595h.f);
        long r15 = r13.j() + r14;
        r11 = ((long) r13.f12596i.f) + r15;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.s
    public final boolean k() {
        ArrayList r5 = this.f12565k;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (((s) r5.get(r11)).k() == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final hr.f m() {
        int r5 = 0;
    L3:
        ArrayList r10 = this.f12565k;
        if (r5 >= r10.size()) goto L9;
        hr.f r11 = ((s) r10.get(r5)).f12593b;
        if (r11.i0 != 8) goto L7;
        r5 = r5 + 1;
        goto L3
    L7:
        return r11;
    L9:
        return null;
    }

    public final hr.f n() {
        ArrayList r5 = this.f12565k;
        int r10 = r5.size() - 1;
    L3:
        if (r10 < 0) goto L8;
        hr.f r11 = ((s) r5.get(r10)).f12593b;
        if (r11.i0 != 8) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return null;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ChainRun ");
        if (this.f != 0) goto L5;
        String r10 = "horizontal : ";
    L6:
        r5.append(r10);
        Iterator r11 = this.f12565k.iterator();
    L8:
        if (r11.hasNext() == false) goto L11;
        s r12 = (s) r11.next();
        r5.append("<");
        r5.append(r12);
        r5.append("> ");
        goto L8
    L11:
        return r5.toString();
    L5:
        r10 = "vertical : ";
        goto L6
    }
}
