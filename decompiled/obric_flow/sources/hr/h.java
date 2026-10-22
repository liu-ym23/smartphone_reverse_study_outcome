package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f17439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17440c;
    public d d;
    public d e;
    public d f;
    public d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ i f17451r;

    public h(i r5, int r10, d r11, d r12, d r13, d r14, int r15) {
        this.f17451r = r5;
        this.f17439b = null;
        this.f17440c = 0;
        this.f17441h = 0;
        this.f17442i = 0;
        this.f17443j = 0;
        this.f17444k = 0;
        this.f17445l = 0;
        this.f17446m = 0;
        this.f17447n = 0;
        this.f17448o = 0;
        this.f17449p = 0;
        this.f17450q = 0;
        this.f17438a = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f17441h = r5.A0;
        this.f17442i = r5.f17465w0;
        this.f17443j = r5.B0;
        this.f17444k = r5.f17466x0;
        this.f17450q = r15;
    }

    public final void a(f r10) {
        int r5 = this.f17438a;
        int r11 = 0;
        i r12 = this.f17451r;
        if (r5 != 0) goto L16;
        int r13 = r12.Y(r10, this.f17450q);
        if (r10.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
        this.f17449p++;
        r13 = 0;
    L7:
        int r14 = r12.T0;
        if (r10.i0 == 8) goto L11;
        r11 = r14;
    L11:
        this.f17445l = (r13 + r11) + this.f17445l;
        int r15 = r12.X(r10, this.f17450q);
        if (this.f17439b != null) goto L14;
    L15:
        this.f17439b = r10;
        this.f17440c = r15;
        this.f17446m = r15;
    L28:
        this.f17448o++;
        return;
    L14:
        if (this.f17440c >= r15) goto L28;
    L16:
        int r16 = r12.Y(r10, this.f17450q);
        int r17 = r12.X(r10, this.f17450q);
        if (r10.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        this.f17449p++;
        r17 = 0;
    L19:
        int r18 = r12.U0;
        if (r10.i0 == 8) goto L23;
        r11 = r18;
    L23:
        this.f17446m = (r17 + r11) + this.f17446m;
        if (this.f17439b != null) goto L26;
    L27:
        this.f17439b = r10;
        this.f17440c = r16;
        this.f17445l = r16;
        goto L28
    L26:
        if (this.f17440c >= r16) goto L28;
        goto L27
    }

    public final void b(boolean r21, int r22, boolean r23) {
        int r5 = this.f17448o;
        int r10 = 0;
    L3:
        i r11 = this.f17451r;
        if (r10 >= r5) goto L12;
        int r12 = this.f17447n + r10;
        if (r12 >= r11.f1) goto L12;
        f r13 = r11.f17454e1[r12];
        if (r13 == null) goto L11;
        r13.E();
    L11:
        r10 = r10 + 1;
    L12:
        if (r5 != 0) goto L14;
        return;
    L14:
        if (this.f17439b == null) goto L234;
        if (r23 == false) goto L19;
        if (r22 != 0) goto L19;
        boolean r14 = true;
    L20:
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
    L21:
        if (r15 >= r5) goto L37;
        if (r21 == false) goto L24;
        int r18 = (r5 - 1) - r15;
    L25:
        int r19 = this.f17447n + r18;
        if (r19 >= r11.f1) goto L37;
        f r110 = r11.f17454e1[r19];
        if (r110 == null) goto L35;
        if (r110.i0 != 0) goto L35;
        if (r16 != (-1)) goto L34;
        r16 = r15;
    L34:
        r17 = r15;
    L35:
        r15 = r15 + 1;
        goto L21
    L24:
        r18 = r15;
    L37:
        if (this.f17438a != 0) goto L135;
        f r20 = this.f17439b;
        r20.f17412m0 = r11.I0;
        int r111 = this.f17442i;
        if (r22 <= 0) goto L41;
        r111 = r111 + r11.U0;
    L41:
        d r112 = this.e;
        d r113 = r20.K;
        r113.a(r112, r111);
        d r114 = r20.M;
        if (r23 == false) goto L44;
        r114.a(this.g, this.f17444k);
    L44:
        if (r22 <= 0) goto L47;
        this.e.d.M.a(r113, 0);
    L47:
        if (r11.W0 == 3) goto L49;
    L62:
        f r115 = r20;
    L63:
        int r116 = 0;
        f r117 = null;
    L64:
        if (r116 >= r5) goto L235;
        if (r21 == false) goto L67;
        int r118 = (r5 - 1) - r116;
    L68:
        int r119 = this.f17447n + r118;
        if (r119 >= r11.f1) goto L236;
        f r24 = r11.f17454e1[r119];
        if (r24 != null) goto L74;
        r5 = r5;
        char r25 = 3;
    L134:
        r116 = r116 + 1;
        r5 = r5;
        goto L64
    L74:
        d r120 = r24.J;
        if (r116 != 0) goto L77;
        r24.f(r120, this.d, this.f17441h);
    L77:
        if (r118 != 0) goto L100;
        int r26 = r11.H0;
        if (r21 == false) goto L81;
        float r27 = 1.0f - r11.N0;
    L83:
        if (this.f17447n != 0) goto L91;
        int r28 = r11.J0;
        if (r28 == (-1)) goto L91;
        if (r21 == false) goto L88;
        float r29 = 1.0f - r11.P0;
    L89:
        float r30 = r29;
        int r31 = r28;
    L98:
        r24.l0 = r31;
        r24.f17402f0 = r30;
        goto L100
    L88:
        r29 = r11.P0;
    L91:
        if (r23 == false) goto L97;
        r31 = r11.L0;
        if (r31 == (-1)) goto L97;
        if (r21 == false) goto L96;
        r30 = 1.0f - r11.R0;
        goto L98
    L96:
        r30 = r11.R0;
    L97:
        r31 = r26;
        r30 = r27;
        goto L98
    L81:
        r27 = r11.N0;
    L100:
        if (r116 != (r5 - 1)) goto L103;
        r24.f(r24.L, this.f, this.f17443j);
    L103:
        if (r117 == null) goto L114;
        int r32 = r11.T0;
        d r33 = r117.L;
        r120.a(r33, r32);
        if (r116 != r16) goto L109;
        int r34 = this.f17441h;
        if (r120.h() == false) goto L109;
        r120.f17390h = r34;
    L109:
        r33.a(r120, 0);
        if (r116 != (r17 + 1)) goto L114;
        int r35 = this.f17443j;
        if (r33.h() == false) goto L114;
        r33.f17390h = r35;
    L114:
        if (r24 == r20) goto L132;
        int r36 = r11.W0;
        r25 = 3;
        if (r36 == 3) goto L118;
    L123:
        d r37 = r24.K;
        if (r36 == 0) goto L131;
        d r121 = r24.M;
        if (r36 == 1) goto L130;
        if (r14 == false) goto L129;
        r37.a(this.e, this.f17442i);
        r121.a(this.g, this.f17444k);
    L133:
        r117 = r24;
        goto L134
    L129:
        r37.a(r113, 0);
        r121.a(r114, 0);
        goto L133
    L130:
        r121.a(r114, 0);
        goto L133
    L131:
        r37.a(r113, 0);
        goto L133
    L118:
        if (r115.E == false) goto L123;
        if (r24 == r115) goto L123;
        if (r24.E == false) goto L123;
        r24.N.a(r115.N, 0);
        goto L133
    L132:
        r25 = 3;
        goto L133
    L236:
        return;
    L67:
        r118 = r116;
        goto L68
    L235:
        return;
    L49:
        if (r20.E == true) goto L62;
        int r122 = 0;
    L51:
        if (r122 >= r5) goto L62;
        if (r21 == false) goto L54;
        int r123 = (r5 - 1) - r122;
    L55:
        int r124 = this.f17447n + r123;
        if (r124 >= r11.f1) goto L62;
        r115 = r11.f17454e1[r124];
        if (r115.E == true) goto L63;
        r122 = r122 + 1;
        goto L51
    L54:
        r123 = r122;
        goto L55
    L135:
        f r38 = this.f17439b;
        r38.l0 = r11.H0;
        int r39 = this.f17441h;
        if (r22 <= 0) goto L138;
        r39 = r39 + r11.T0;
    L138:
        d r40 = r38.J;
        d r41 = r38.L;
        if (r21 == false) goto L145;
        r41.a(this.f, r39);
        if (r23 == false) goto L143;
        r40.a(this.d, this.f17443j);
    L143:
        if (r22 <= 0) goto L150;
        this.f.d.J.a(r41, 0);
    L150:
        int r42 = 0;
        f r125 = null;
    L151:
        if (r42 >= r5) goto L237;
        int r126 = this.f17447n + r42;
        if (r126 >= r11.f1) goto L238;
        f r127 = r11.f17454e1[r126];
        if (r127 == null) goto L212;
        d r128 = r127.K;
        if (r42 != 0) goto L174;
        r127.f(r128, this.e, this.f17442i);
        int r129 = r11.I0;
        float r130 = r11.O0;
        if (this.f17447n != 0) goto L165;
        int r131 = r11.K0;
        int r132 = -1;
        if (r131 == (-1)) goto L166;
        r130 = r11.Q0;
    L171:
        r127.f17412m0 = r131;
        r127.g0 = r130;
    L166:
        if (r23 == false) goto L170;
        r131 = r11.M0;
        if (r131 == r132) goto L170;
        r130 = r11.S0;
    L170:
        r131 = r129;
        goto L171
    L165:
        r132 = -1;
    L174:
        if (r42 != (r5 - 1)) goto L176;
        r127.f(r127.M, this.g, this.f17444k);
    L176:
        if (r125 == null) goto L187;
        int r133 = r11.U0;
        d r134 = r125.M;
        r128.a(r134, r133);
        if (r42 != r16) goto L182;
        int r135 = this.f17442i;
        if (r128.h() == false) goto L182;
        r128.f17390h = r135;
    L182:
        r134.a(r128, 0);
        if (r42 != (r17 + 1)) goto L187;
        int r136 = this.f17444k;
        if (r134.h() == false) goto L187;
        r134.f17390h = r136;
    L187:
        if (r127 == r38) goto L211;
        d r137 = r127.L;
        d r138 = r127.J;
        if (r21 == false) goto L200;
        int r139 = r11.V0;
        if (r139 != 0) goto L193;
        r137.a(r41, 0);
        goto L211
    L193:
        if (r139 == 1) goto L197;
        if (r139 != 2) goto L211;
        r138.a(r40, 0);
        r137.a(r41, 0);
        goto L211
    L197:
        r138.a(r40, 0);
        goto L211
    L200:
        int r140 = r11.V0;
        if (r140 != 0) goto L203;
        r138.a(r40, 0);
        goto L211
    L203:
        if (r140 == 1) goto L209;
        if (r140 != 2) goto L211;
        if (r14 == false) goto L208;
        r138.a(this.d, this.f17441h);
        r137.a(this.f, this.f17443j);
        goto L211
    L208:
        r138.a(r40, 0);
        r137.a(r41, 0);
        goto L211
    L209:
        r137.a(r41, 0);
    L211:
        r125 = r127;
    L212:
        r42 = r42 + 1;
        goto L151
    L238:
        return;
    L237:
        return;
    L145:
        r40.a(this.d, r39);
        if (r23 == false) goto L148;
        r41.a(this.f, this.f17443j);
    L148:
        if (r22 <= 0) goto L150;
        this.d.d.L.a(r40, 0);
    L19:
        r14 = false;
        goto L20
    }

    public final int c() {
        if (this.f17438a != 1) goto L7;
        return this.f17446m - this.f17451r.U0;
    L7:
        return this.f17446m;
    }

    public final int d() {
        if (this.f17438a != 0) goto L7;
        return this.f17445l - this.f17451r.T0;
    L7:
        return this.f17445l;
    }

    public final void e(int r11) {
        int r5 = this.f17449p;
        if (r5 != 0) goto L5;
        return;
    L5:
        int r10 = this.f17448o;
        int r12 = r11 / r5;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L25;
        int r14 = this.f17447n;
        int r15 = r14 + r13;
        i r16 = this.f17451r;
        if (r15 >= r16.f1) goto L25;
        f r17 = r16.f17454e1[r14 + r13];
        if (this.f17438a != 0) goto L18;
        if (r17 == null) goto L24;
        ConstraintWidget$DimensionBehaviour[] r18 = r17.U;
        if (r18[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        if (r17.f17421r != 0) goto L24;
        r16.W(r17, ConstraintWidget$DimensionBehaviour.FIXED, r12, r18[1], r17.l());
    L24:
        r13 = r13 + 1;
        goto L6
    L18:
        if (r17 == null) goto L24;
        ConstraintWidget$DimensionBehaviour[] r19 = r17.U;
        if (r19[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        if (r17.s != 0) goto L24;
        r16.W(r17, r19[0], r17.r(), ConstraintWidget$DimensionBehaviour.FIXED, r12);
    L25:
        this.f17445l = 0;
        this.f17446m = 0;
        this.f17439b = null;
        this.f17440c = 0;
        int r110 = this.f17448o;
        int r20 = 0;
    L26:
        if (r20 >= r110) goto L49;
        int r21 = this.f17447n + r20;
        i r22 = this.f17451r;
        if (r21 >= r22.f1) goto L66;
        f r23 = r22.f17454e1[r21];
        if (this.f17438a != 0) goto L40;
        int r24 = r23.r();
        int r25 = r22.T0;
        if (r23.i0 != 8) goto L35;
        r25 = 0;
    L35:
        this.f17445l = (r24 + r25) + this.f17445l;
        int r26 = r22.X(r23, this.f17450q);
        if (this.f17439b != null) goto L38;
    L39:
        this.f17439b = r23;
        this.f17440c = r26;
        this.f17446m = r26;
    L48:
        r20 = r20 + 1;
        goto L26
    L38:
        if (this.f17440c >= r26) goto L48;
    L40:
        int r27 = r22.Y(r23, this.f17450q);
        int r28 = r22.X(r23, this.f17450q);
        int r29 = r22.U0;
        if (r23.i0 != 8) goto L43;
        r29 = 0;
    L43:
        this.f17446m = (r28 + r29) + this.f17446m;
        if (this.f17439b != null) goto L46;
    L47:
        this.f17439b = r23;
        this.f17440c = r27;
        this.f17445l = r27;
        goto L48
    L46:
        if (this.f17440c >= r27) goto L48;
    L66:
        return;
    }

    public final void f(int r5, d r10, d r11, d r12, d r13, int r14, int r15, int r16, int r17, int r18) {
        this.f17438a = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f17441h = r14;
        this.f17442i = r15;
        this.f17443j = r16;
        this.f17444k = r17;
        this.f17450q = r18;
    }
}
