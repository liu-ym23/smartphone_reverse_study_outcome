package t;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<p> f12149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12150l;

    public c(int r8, s.e r10) {
        super(r10);
        this.f12149k = new ArrayList();
        this.f12198f = r8;
        s.e r11 = this.f12194b;
    L3:
        int r12 = this.f12198f;
        if (r12 != 0) goto L10;
        s.d r13 = r11.K;
        s.d r14 = r13.f11835f;
        if (r14 != null) goto L8;
    L17:
        s.e r15 = null;
    L18:
        if (r15 == null) goto L20;
        r11 = r15;
        goto L3
    L20:
        this.f12194b = r11;
        int r16 = this.f12198f;
        if (r16 != 0) goto L23;
        p r17 = r11.f11854d;
    L26:
        ArrayList<p> r18 = this.f12149k;
    L27:
        r18.add(r17);
        r11 = r11.m(this.f12198f);
        if (r11 == null) goto L35;
        int r19 = this.f12198f;
        if (r19 == 0) goto L31;
        if (r19 == 1) goto L33;
        r17 = null;
        goto L27
    L33:
        r17 = r11.f11855e;
        goto L27
    L31:
        r17 = r11.f11854d;
        goto L27
    L35:
        Iterator<p> r20 = r18.iterator();
    L37:
        if (r20.hasNext() == false) goto L44;
        p r21 = r20.next();
        int r22 = this.f12198f;
        if (r22 == 0) goto L40;
        if (r22 != 1) goto L37;
        r21.f12194b.f11852c = this;
        goto L37
    L40:
        r21.f12194b.f11850b = this;
        goto L37
    L44:
        if (this.f12198f == 0) goto L46;
    L48:
        boolean r23 = false;
    L49:
        if (r23 == false) goto L54;
        if (r18.size() <= 1) goto L54;
        this.f12194b = r18.get(r18.size() - 1).f12194b;
    L54:
        if (this.f12198f != 0) goto L56;
        int r24 = this.f12194b.f11870l0;
    L57:
        this.f12150l = r24;
        return;
    L56:
        r24 = this.f12194b.f11872m0;
        goto L57
    L46:
        if (((s.f) this.f12194b.W).f11900x0 == false) goto L48;
        r23 = true;
        goto L49
    L23:
        if (r16 != 1) goto L25;
        r17 = r11.f11855e;
        goto L26
    L25:
        r17 = null;
        goto L26
    L8:
        if (r14.f11835f != r13) goto L17;
    L9:
        r15 = r14.f11833d;
        goto L18
    L10:
        if (r12 != 1) goto L16;
        s.d r25 = r11.L;
        r14 = r25.f11835f;
        if (r14 == null) goto L17;
        if (r14.f11835f != r25) goto L17;
    L16:
        r11.getClass();
        goto L17
    }

    @Override // t.p, t.d
    public final void a(d r27) {
        f r8 = this.f12200h;
        if (r8.f12168j == false) goto L288;
        f r10 = this.f12201i;
        if (r10.f12168j == false) goto L330;
        s.e r11 = this.f12194b.W;
        if ((r11 instanceof s.f) == false) goto L10;
        boolean r12 = ((s.f) r11).f11900x0;
    L11:
        int r13 = r10.f12165g - r8.f12165g;
        ArrayList<p> r14 = this.f12149k;
        int r15 = r14.size();
        int r16 = 0;
    L12:
        int r17 = -1;
        if (r16 >= r15) goto L17;
        if (r14.get(r16).f12194b.f11866j0 != 8) goto L18;
        r16 = r16 + 1;
    L18:
        int r18 = r15 - 1;
        int r19 = r18;
    L19:
        if (r19 < 0) goto L24;
        if (r14.get(r19).f12194b.f11866j0 != 8) goto L23;
        r19 = r19 - 1;
        goto L19
    L23:
        r17 = r19;
    L24:
        int r110 = 0;
    L26:
        if (r110 >= 2) goto L76;
        int r20 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        float r114 = 0.0f;
    L28:
        if (r20 >= r15) goto L70;
        p r115 = r14.get(r20);
        s.e r116 = r115.f12194b;
        ArrayList<p> r21 = r14;
        if (r116.f11866j0 != 8) goto L32;
        int r23 = r16;
    L69:
        r20 = r20 + 1;
        r14 = r21;
        r16 = r23;
        goto L28
    L32:
        r113 = r113 + 1;
        if (r20 <= 0) goto L36;
        if (r20 < r16) goto L36;
        r111 = r111 + r115.f12200h.f12164f;
    L36:
        g r22 = r115.f12197e;
        int r117 = r22.f12165g;
        r23 = r16;
        if (r115.f12196d == s.e.a.f11893m) goto L39;
        boolean r24 = true;
    L40:
        if (r24 == false) goto L53;
        int r25 = this.f12198f;
        if (r25 != 0) goto L47;
        if (r116.f11854d.f12197e.f12168j == true) goto L47;
        return;
    L47:
        if (r25 != 1) goto L60;
        if (r116.f11855e.f12197e.f12168j == true) goto L60;
        return;
    L60:
        int r118 = r117;
    L61:
        if (r24 == true) goto L65;
        r112 = r112 + 1;
        float r26 = r116.f11874n0[this.f12198f];
        if (r26 < 0.0f) goto L66;
        r114 = r114 + r26;
    L66:
        if (r20 >= r18) goto L69;
        if (r20 >= r17) goto L69;
        r111 = r111 + (-r115.f12201i.f12164f);
        goto L69
    L65:
        r111 = r111 + r118;
        goto L66
    L53:
        if (r115.f12193a != 1) goto L57;
        if (r110 != 0) goto L57;
        r118 = r22.f12180m;
        r112 = r112 + 1;
    L59:
        r24 = true;
    L57:
        if (r22.f12168j == false) goto L60;
        r118 = r117;
        goto L59
    L39:
        r24 = false;
        goto L40
    L70:
        ArrayList<p> r28 = r14;
        int r29 = r16;
        if (r111 < r13) goto L75;
        if (r112 == 0) goto L75;
        r110 = r110 + 1;
        r14 = r28;
        r16 = r29;
    L75:
        int r30 = r112;
        int r31 = r113;
    L77:
        int r32 = r8.f12165g;
        if (r12 == false) goto L81;
        r32 = r10.f12165g;
    L81:
        if (r111 <= r13) goto L86;
        int r33 = (int) (((r111 - r13) / 2.0f) + 0.5f);
        if (r12 == false) goto L85;
        r32 = r32 + r33;
        goto L86
    L85:
        r32 = r32 - r33;
    L86:
        if (r30 <= 0) goto L139;
        float r34 = r13 - r111;
        int r119 = (int) ((r34 / r30) + 0.5f);
        int r120 = 0;
        int r121 = 0;
    L88:
        if (r120 >= r15) goto L116;
        ArrayList<p> r122 = r28;
        p r35 = r122.get(r120);
        int r123 = r119;
        s.e r124 = r35.f12194b;
        int r210 = r111;
        int r211 = r32;
        if (r124.f11866j0 != 8) goto L93;
    L114:
        r12 = r12;
    L115:
        r120 = r120 + 1;
        r119 = r123;
        r111 = r210;
        r32 = r211;
        r12 = r12;
        r34 = r34;
        r28 = r122;
        goto L88
    L93:
        if (r35.f12196d != s.e.a.f11893m) goto L114;
        g r36 = r35.f12197e;
        if (r36.f12168j == true) goto L114;
        if (r114 <= 0.0f) goto L99;
        int r37 = (int) (((r124.f11874n0[this.f12198f] * r34) / r114) + 0.5f);
    L101:
        if (this.f12198f != 0) goto L103;
        int r125 = r124.f11887w;
        int r126 = r124.f11886v;
    L105:
        if (r35.f12193a != 1) goto L107;
        int r38 = Math.min(r37, r36.f12180m);
    L108:
        int r39 = Math.max(r126, r38);
        if (r125 <= 0) goto L111;
        r39 = Math.min(r125, r39);
    L111:
        if (r39 == r37) goto L113;
        r121 = r121 + 1;
        r37 = r39;
    L113:
        r36.d(r37);
        goto L115
    L107:
        r38 = r37;
        goto L108
    L103:
        r125 = r124.f11890z;
        r126 = r124.f11889y;
        goto L105
    L99:
        r37 = r123;
        goto L101
    L116:
        int r212 = r32;
        boolean r213 = r12;
        ArrayList<p> r127 = r28;
        int r214 = r111;
        if (r121 <= 0) goto L133;
        r30 = r30 - r121;
        int r40 = 0;
        int r41 = 0;
    L119:
        if (r40 >= r15) goto L132;
        p r42 = r127.get(r40);
        if (r42.f12194b.f11866j0 != 8) goto L123;
        int r43 = r29;
    L131:
        r40 = r40 + 1;
        r29 = r43;
        goto L119
    L123:
        r43 = r29;
        if (r40 <= 0) goto L127;
        if (r40 < r43) goto L127;
        r41 = r41 + r42.f12200h.f12164f;
    L127:
        r41 = r41 + r42.f12197e.f12165g;
        if (r40 >= r18) goto L131;
        if (r40 >= r17) goto L131;
        r41 = r41 + (-r42.f12201i.f12164f);
        goto L131
    L132:
        int r44 = r29;
        r111 = r41;
    L134:
        int r45 = 2;
        if (this.f12150l != 2) goto L138;
        if (r121 != 0) goto L138;
        int r46 = 0;
        this.f12150l = 0;
    L140:
        if (r111 <= r13) goto L142;
        this.f12150l = r45;
    L142:
        if (r31 <= 0) goto L146;
        if (r30 != 0) goto L146;
        if (r44 != r17) goto L146;
        this.f12150l = r45;
    L146:
        int r47 = this.f12150l;
        if (r47 != 1) goto L195;
        if (r31 <= 1) goto L150;
        int r48 = (r13 - r111) / (r31 - 1);
    L153:
        if (r30 <= 0) goto L155;
        r48 = r46;
    L155:
        int r49 = r46;
        int r50 = r212;
    L156:
        if (r49 >= r15) goto L331;
        if (r213 == false) goto L159;
        int r51 = r15 - (r49 + 1);
    L160:
        p r52 = r127.get(r51);
        int r53 = r52.f12194b.f11866j0;
        f r54 = r52.f12201i;
        f r55 = r52.f12200h;
        if (r53 != 8) goto L163;
        r55.d(r50);
        r54.d(r50);
    L194:
        r49 = r49 + 1;
        goto L156
    L163:
        if (r49 <= 0) goto L167;
        if (r213 == false) goto L166;
        r50 = r50 - r48;
        goto L167
    L166:
        r50 = r50 + r48;
    L167:
        if (r49 <= 0) goto L173;
        if (r49 < r44) goto L173;
        int r56 = r55.f12164f;
        if (r213 == false) goto L172;
        r50 = r50 - r56;
        goto L173
    L172:
        r50 = r50 + r56;
    L173:
        if (r213 == false) goto L175;
        r54.d(r50);
    L176:
        g r57 = r52.f12197e;
        int r128 = r57.f12165g;
        if (r52.f12196d == s.e.a.f11893m) goto L179;
    L181:
        if (r213 == false) goto L183;
        r50 = r50 - r128;
    L184:
        if (r213 == false) goto L186;
        r55.d(r50);
    L187:
        r52.f12199g = true;
        if (r49 >= r18) goto L194;
        if (r49 >= r17) goto L194;
        int r58 = -r54.f12164f;
        if (r213 == false) goto L193;
        r50 = r50 - r58;
        goto L194
    L193:
        r50 = r50 + r58;
        goto L194
    L186:
        r54.d(r50);
        goto L187
    L183:
        r50 = r50 + r128;
        goto L184
    L179:
        if (r52.f12193a != 1) goto L181;
        r128 = r57.f12180m;
        goto L181
    L175:
        r55.d(r50);
        goto L176
    L159:
        r51 = r49;
        goto L160
    L331:
        return;
    L150:
        if (r31 != 1) goto L152;
        r48 = (r13 - r111) / 2;
        goto L153
    L152:
        r48 = r46;
        goto L153
    L195:
        if (r47 != 0) goto L238;
        int r59 = (r13 - r111) / (r31 + 1);
        if (r30 <= 0) goto L199;
        r59 = r46;
    L199:
        int r60 = r46;
        int r61 = r212;
    L200:
        if (r60 >= r15) goto L332;
        if (r213 == false) goto L203;
        int r62 = r15 - (r60 + 1);
    L204:
        p r63 = r127.get(r62);
        int r64 = r63.f12194b.f11866j0;
        f r65 = r63.f12201i;
        f r66 = r63.f12200h;
        if (r64 != 8) goto L207;
        r66.d(r61);
        r65.d(r61);
    L236:
        r60 = r60 + 1;
        goto L200
    L207:
        if (r213 == false) goto L209;
        int r67 = r61 - r59;
    L210:
        if (r60 <= 0) goto L216;
        if (r60 < r44) goto L216;
        int r68 = r66.f12164f;
        if (r213 == false) goto L215;
        r67 = r67 - r68;
        goto L216
    L215:
        r67 = r67 + r68;
    L216:
        if (r213 == false) goto L218;
        r65.d(r67);
    L219:
        g r69 = r63.f12197e;
        int r129 = r69.f12165g;
        if (r63.f12196d == s.e.a.f11893m) goto L222;
    L224:
        if (r213 == false) goto L226;
        r61 = r67 - r129;
    L227:
        if (r213 == false) goto L229;
        r66.d(r61);
    L230:
        if (r60 >= r18) goto L236;
        if (r60 >= r17) goto L236;
        int r70 = -r65.f12164f;
        if (r213 == false) goto L235;
        r61 = r61 - r70;
        goto L236
    L235:
        r61 = r61 + r70;
        goto L236
    L229:
        r65.d(r61);
        goto L230
    L226:
        r61 = r67 + r129;
        goto L227
    L222:
        if (r63.f12193a != 1) goto L224;
        r129 = Math.min(r129, r69.f12180m);
        goto L224
    L218:
        r66.d(r67);
        goto L219
    L209:
        r67 = r61 + r59;
        goto L210
    L203:
        r62 = r60;
        goto L204
    L332:
        return;
    L238:
        if (r47 != 2) goto L329;
        int r71 = this.f12198f;
        s.e r72 = this.f12194b;
        if (r71 != 0) goto L242;
        float r73 = r72.f11860g0;
    L243:
        if (r213 == false) goto L245;
        r73 = 1.0f - r73;
    L245:
        int r74 = (int) (((r13 - r111) * r73) + 0.5f);
        if (r74 < 0) goto L248;
        if (r30 > 0) goto L248;
    L249:
        if (r213 == false) goto L251;
        int r75 = r212 - r74;
    L252:
        int r76 = r46;
    L253:
        if (r76 >= r15) goto L333;
        if (r213 == false) goto L256;
        int r77 = r15 - (r76 + 1);
    L257:
        p r78 = r127.get(r77);
        int r79 = r78.f12194b.f11866j0;
        f r80 = r78.f12201i;
        f r81 = r78.f12200h;
        if (r79 != 8) goto L260;
        r81.d(r75);
        r80.d(r75);
    L287:
        r76 = r76 + 1;
        goto L253
    L260:
        if (r76 <= 0) goto L266;
        if (r76 < r44) goto L266;
        int r82 = r81.f12164f;
        if (r213 == false) goto L265;
        r75 = r75 - r82;
        goto L266
    L265:
        r75 = r75 + r82;
    L266:
        if (r213 == false) goto L268;
        r80.d(r75);
    L269:
        g r83 = r78.f12197e;
        int r130 = r83.f12165g;
        if (r78.f12196d != s.e.a.f11893m) goto L275;
        if (r78.f12193a != 1) goto L275;
        r130 = r83.f12180m;
    L275:
        if (r213 == false) goto L277;
        r75 = r75 - r130;
    L278:
        if (r213 == false) goto L280;
        r81.d(r75);
    L281:
        if (r76 >= r18) goto L287;
        if (r76 >= r17) goto L287;
        int r84 = -r80.f12164f;
        if (r213 == false) goto L286;
        r75 = r75 - r84;
        goto L287
    L286:
        r75 = r75 + r84;
        goto L287
    L280:
        r80.d(r75);
        goto L281
    L277:
        r75 = r75 + r130;
        goto L278
    L268:
        r81.d(r75);
        goto L269
    L256:
        r77 = r76;
        goto L257
    L333:
        return;
    L251:
        r75 = r212 + r74;
    L248:
        r74 = r46;
        goto L249
    L242:
        r73 = r72.f11862h0;
        goto L243
    L329:
        return;
    L138:
        r46 = 0;
        goto L140
    L133:
        r44 = r29;
        r111 = r214;
        goto L134
    L139:
        r212 = r32;
        r213 = r12;
        r127 = r28;
        r44 = r29;
        r46 = 0;
        r45 = 2;
        goto L140
    L76:
        r28 = r14;
        r29 = r16;
        r30 = 0;
        r31 = 0;
        r111 = 0;
        r114 = 0.0f;
        goto L77
    L17:
        r16 = -1;
        goto L18
    L10:
        r12 = false;
        goto L11
    L330:
        return;
    }

    @Override // t.p
    public final void d() {
        ArrayList<p> r8 = this.f12149k;
        Iterator<p> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().d();
        goto L4
    L6:
        int r11 = r8.size();
        if (r11 >= 1) goto L9;
        return;
    L9:
        s.e r12 = r8.get(0).f12194b;
        s.e r13 = r8.get(r11 - 1).f12194b;
        int r14 = this.f12198f;
        f r15 = this.f12201i;
        f r16 = this.f12200h;
        if (r14 != 0) goto L21;
        s.d r17 = r12.K;
        s.d r18 = r13.M;
        f r19 = p.i(r17, 0);
        int r20 = r17.e();
        s.e r21 = m();
        if (r21 == null) goto L14;
        r20 = r21.K.e();
    L14:
        if (r19 == null) goto L16;
        p.b(r16, r19, r20);
    L16:
        f r22 = p.i(r18, 0);
        int r23 = r18.e();
        s.e r24 = n();
        if (r24 == null) goto L19;
        r23 = r24.M.e();
    L19:
        if (r22 != null) goto L30;
    L31:
        r16.f12159a = this;
        r15.f12159a = this;
        return;
    L30:
        p.b(r15, r22, -r23);
        goto L31
    L21:
        s.d r25 = r12.L;
        s.d r26 = r13.N;
        f r27 = p.i(r25, 1);
        int r28 = r25.e();
        s.e r29 = m();
        if (r29 == null) goto L24;
        r28 = r29.L.e();
    L24:
        if (r27 == null) goto L26;
        p.b(r16, r27, r28);
    L26:
        r22 = p.i(r26, 1);
        r23 = r26.e();
        s.e r30 = n();
        if (r30 == null) goto L29;
        r23 = r30.N.e();
    L29:
        if (r22 == null) goto L31;
        goto L30
    }

    @Override // t.p
    public final void e() {
        int r8 = 0;
    L3:
        ArrayList<p> r10 = this.f12149k;
        if (r8 >= r10.size()) goto L6;
        r10.get(r8).e();
        r8 = r8 + 1;
        goto L3
    }

    @Override // t.p
    public final void f() {
        this.f12195c = null;
        Iterator<p> r8 = this.f12149k.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().f();
        goto L4
    }

    @Override // t.p
    public final long j() {
        ArrayList<p> r8 = this.f12149k;
        int r10 = r8.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        p r13 = r8.get(r12);
        long r14 = r11 + ((long) r13.f12200h.f12164f);
        long r15 = r13.j() + r14;
        r11 = ((long) r13.f12201i.f12164f) + r15;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // t.p
    public final boolean k() {
        ArrayList<p> r8 = this.f12149k;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (r8.get(r11).k() == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final s.e m() {
        int r8 = 0;
    L3:
        ArrayList<p> r10 = this.f12149k;
        if (r8 >= r10.size()) goto L9;
        s.e r11 = r10.get(r8).f12194b;
        if (r11.f11866j0 != 8) goto L7;
        r8 = r8 + 1;
        goto L3
    L7:
        return r11;
    L9:
        return null;
    }

    public final s.e n() {
        ArrayList<p> r8 = this.f12149k;
        int r10 = r8.size() - 1;
    L3:
        if (r10 < 0) goto L8;
        s.e r11 = r8.get(r10).f12194b;
        if (r11.f11866j0 != 8) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return null;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("ChainRun ");
        if (this.f12198f != 0) goto L5;
        String r10 = "horizontal : ";
    L6:
        r8.append(r10);
        Iterator<p> r11 = this.f12149k.iterator();
    L8:
        if (r11.hasNext() == false) goto L11;
        p r12 = r11.next();
        r8.append("<");
        r8.append(r12);
        r8.append("> ");
        goto L8
    L11:
        return r8.toString();
    L5:
        r10 = "vertical : ";
        goto L6
    }
}
