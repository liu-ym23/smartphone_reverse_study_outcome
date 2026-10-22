package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends o {
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public float N0;
    public float O0;
    public float P0;
    public float Q0;
    public float R0;
    public float S0;
    public int T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public final ArrayList f17452a1;
    public f[] b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public f[] f17453c1;
    public int[] d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public f[] f17454e1;
    public int f1;

    public i() {
        this.H0 = -1;
        this.I0 = -1;
        this.J0 = -1;
        this.K0 = -1;
        this.L0 = -1;
        this.M0 = -1;
        this.N0 = 0.5f;
        this.O0 = 0.5f;
        this.P0 = 0.5f;
        this.Q0 = 0.5f;
        this.R0 = 0.5f;
        this.S0 = 0.5f;
        this.T0 = 0;
        this.U0 = 0;
        this.V0 = 2;
        this.W0 = 2;
        this.X0 = 0;
        this.Y0 = -1;
        this.Z0 = 0;
        this.f17452a1 = new ArrayList();
        this.b1 = null;
        this.f17453c1 = null;
        this.d1 = null;
        this.f1 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hr.o
    public final void V(int r37, int r38, int r39, int r40) {
        if (this.f17463v0 <= 0) goto L34;
        f r5 = this.V;
        if (r5 == null) goto L7;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r10 = ((g) r5).f17436y0;
    L8:
        if (r10 != null) goto L11;
        this.D0 = 0;
        this.E0 = 0;
        this.C0 = false;
        return;
    L11:
        int r11 = 0;
    L13:
        if (r11 >= this.f17463v0) goto L34;
        f r12 = this.f17462u0[r11];
        if (r12 == null) goto L33;
        if ((r12 instanceof k) == true) goto L33;
        ConstraintWidget$DimensionBehaviour r13 = r12.k(0);
        ConstraintWidget$DimensionBehaviour r14 = r12.k(1);
        ConstraintWidget$DimensionBehaviour r15 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r15) goto L23;
    L28:
        if (r13 != r15) goto L30;
        r13 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
    L30:
        if (r14 != r15) goto L32;
        r14 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
    L32:
        com.obric.oui.constraintlayout.core.widgets.analyzer.b r16 = this.F0;
        r16.f12559a = r13;
        r16.f12560b = r14;
        r16.f12561c = r12.r();
        r16.d = r12.l();
        ((com.obric.oui.constraintlayout.widget.b) r10).b(r12, r16);
        r12.P(r16.e);
        r12.M(r16.f);
        r12.J(r16.g);
        goto L33
    L23:
        if (r12.f17421r == 1) goto L28;
        if (r14 != r15) goto L28;
        if (r12.s == 1) goto L28;
    L33:
        r11 = r11 + 1;
        goto L13
    L7:
        r10 = null;
    L34:
        int r17 = this.A0;
        int r18 = this.B0;
        int r19 = this.f17465w0;
        int r20 = this.f17466x0;
        int[] r21 = new int[2];
        int r22 = (r38 - r17) - r18;
        int r23 = this.Z0;
        if (r23 != 1) goto L38;
        r22 = (r40 - r19) - r20;
    L38:
        if (r23 != 0) goto L46;
        if (this.H0 != (-1)) goto L43;
        this.H0 = 0;
    L43:
        if (this.I0 != (-1)) goto L51;
        this.I0 = 0;
    L51:
        f[] r24 = this.f17462u0;
        int r25 = 0;
        int r110 = 0;
    L52:
        int r111 = this.f17463v0;
        if (r25 >= r111) goto L58;
        if (this.f17462u0[r25].i0 != 8) goto L57;
        r110 = r110 + 1;
    L57:
        r25 = r25 + 1;
        goto L52
    L58:
        if (r110 <= 0) goto L66;
        r24 = new f[r111 - r110];
        int r26 = 0;
        r111 = 0;
    L61:
        if (r26 >= this.f17463v0) goto L66;
        f r112 = this.f17462u0[r26];
        int r113 = r22;
        if (r112.i0 == 8) goto L65;
        r24[r111] = r112;
        r111 = r111 + 1;
    L65:
        r26 = r26 + 1;
        r22 = r113;
    L66:
        int r114 = r22;
        int r115 = r111;
        f[] r116 = r24;
        this.f17454e1 = r116;
        this.f1 = r115;
        int r27 = this.X0;
        ArrayList r28 = this.f17452a1;
        if (r27 == 0) goto L382;
        d r29 = this.K;
        d r30 = this.J;
        d r117 = this.L;
        d r118 = this.M;
        if (r27 != 1) goto L71;
        int[] r31 = r21;
        int r32 = r20;
        int r33 = r19;
        int r34 = r18;
        int r210 = r17;
        ArrayList r119 = r28;
        int r35 = this.Z0;
        if (r115 == 0) goto L75;
        r119.clear();
        h r120 = new h(this, r35, this.J, this.K, this.L, this.M, r114);
        r119.add(r120);
        if (r35 != 0) goto L318;
        int r36 = 0;
        int r41 = 0;
        int r121 = 0;
    L291:
        if (r121 >= r115) goto L317;
        f r42 = r116[r121];
        int r122 = Y(r42, r114);
        if (r42.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L295;
        r36 = r36 + 1;
    L295:
        int r123 = r36;
        if (r41 == r114) goto L300;
        if (((this.T0 + r41) + r122) > r114) goto L300;
    L302:
        boolean r43 = false;
    L303:
        if (r43 == true) goto L310;
        if (r121 <= 0) goto L310;
        int r44 = this.Y0;
        if (r44 <= 0) goto L310;
        if ((r121 % r44) != 0) goto L310;
        r43 = true;
    L310:
        if (r43 == false) goto L313;
        int r45 = r35;
        int r211 = r35;
        f r46 = r42;
        r120 = new h(this, r45, this.J, this.K, this.L, this.M, r114);
        r120.f17447n = r121;
        r119.add(r120);
    L312:
        r41 = r122;
    L316:
        r120.a(r46);
        r121 = r121 + 1;
        r36 = r123;
        r35 = r211;
        goto L291
    L313:
        r211 = r35;
        r46 = r42;
        if (r121 <= 0) goto L312;
        r41 = (this.T0 + r122) + r41;
    L300:
        if (r120.f17439b == null) goto L302;
        r43 = true;
        goto L303
    L317:
        int r212 = r35;
    L344:
        int r47 = r119.size();
        int r48 = this.A0;
        int r49 = this.f17465w0;
        int r50 = this.B0;
        int r51 = this.f17466x0;
        ConstraintWidget$DimensionBehaviour[] r52 = this.U;
        ConstraintWidget$DimensionBehaviour r53 = r52[0];
        ConstraintWidget$DimensionBehaviour r54 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r53 != r54) goto L347;
    L350:
        boolean r55 = true;
    L351:
        if (r36 <= 0) goto L360;
        if (r55 == false) goto L360;
        int r56 = 0;
    L354:
        if (r56 >= r47) goto L360;
        h r57 = (h) r119.get(r56);
        if (r212 != 0) goto L358;
        r57.e(r114 - r57.d());
    L359:
        r56 = r56 + 1;
        goto L354
    L358:
        r57.e(r114 - r57.c());
    L360:
        int r58 = r49;
        d r59 = r30;
        d r124 = r117;
        d r125 = r118;
        int r60 = 0;
        int r61 = 0;
        int r126 = 0;
        int r62 = r48;
        d r63 = r29;
    L361:
        if (r60 >= r47) goto L381;
        h r127 = (h) r119.get(r60);
        if (r212 == 0) goto L365;
        ArrayList r310 = r119;
        if (r60 >= (r47 - 1)) goto L375;
        r119 = r310;
        r124 = ((h) r119.get(r60 + 1)).f17439b.J;
        r50 = 0;
    L376:
        d r64 = r127.f17439b.L;
        r127.f(r212, r59, r63, r124, r125, r62, r58, r50, r51, r114);
        int r65 = r127.d() + r61;
        int r66 = Math.max(r126, r127.c());
        if (r60 <= 0) goto L379;
        r65 = r65 + this.T0;
    L379:
        r61 = r65;
        r59 = r64;
        r126 = r66;
        r62 = 0;
    L380:
        r60 = r60 + 1;
        r47 = r47;
        goto L361
    L375:
        r119 = r310;
        r50 = this.B0;
        r124 = r117;
        goto L376
    L365:
        if (r60 >= (r47 - 1)) goto L367;
        r125 = ((h) r119.get(r60 + 1)).f17439b.K;
        r51 = 0;
    L368:
        d r128 = r127.f17439b.M;
        r127.f(r212, r59, r63, r124, r125, r62, r58, r50, r51, r114);
        int r67 = Math.max(r61, r127.d());
        int r68 = r127.c() + r126;
        if (r60 <= 0) goto L371;
        r68 = r68 + this.U0;
    L371:
        r61 = r67;
        r126 = r68;
        r63 = r128;
        r119 = r119;
        r58 = 0;
        r47 = r47;
        goto L380
    L367:
        r51 = this.f17466x0;
        r125 = r118;
        goto L368
    L381:
        r31[0] = r61;
        r31[1] = r126;
        goto L75
    L347:
        if (r52[1] == r54) goto L350;
        r55 = false;
        goto L351
    L318:
        r212 = r35;
        r36 = 0;
        int r69 = 0;
        int r70 = 0;
    L319:
        if (r70 >= r115) goto L344;
        f r129 = r116[r70];
        int r130 = X(r129, r114);
        if (r129.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L323;
        r36 = r36 + 1;
    L323:
        int r131 = r36;
        if (r69 == r114) goto L328;
        if (((this.U0 + r69) + r130) > r114) goto L328;
    L330:
        boolean r71 = false;
    L331:
        if (r71 == true) goto L338;
        if (r70 <= 0) goto L338;
        int r72 = this.Y0;
        if (r72 <= 0) goto L338;
        if ((r70 % r72) != 0) goto L338;
        r71 = true;
    L338:
        if (r71 == false) goto L341;
        r120 = new h(this, r212, this.J, this.K, this.L, this.M, r114);
        r120.f17447n = r70;
        r119.add(r120);
    L340:
        r69 = r130;
    L343:
        r120.a(r129);
        r70 = r70 + 1;
        r36 = r131;
        goto L319
    L341:
        if (r70 <= 0) goto L340;
        r69 = (this.U0 + r130) + r69;
    L328:
        if (r120.f17439b == null) goto L330;
        r71 = true;
    L75:
        int r73 = 0;
        char r74 = 1;
    L393:
        int r75 = (r31[r73] + r210) + r34;
        int r76 = (r31[r74] + r33) + r32;
        if (r37 != 1073741824) goto L397;
        r75 = r38;
    L402:
        if (r39 != 1073741824(0x40000000, float:2.0)) goto L404;
        r76 = r40;
    L409:
        this.D0 = r75;
        this.E0 = r76;
        P(r75);
        M(r76);
        if (this.f17463v0 <= 0) goto L412;
        boolean r132 = r74;
    L413:
        this.C0 = r132;
        return;
    L412:
        r132 = r73;
        goto L413
    L404:
        if (r39 != (-2147483648(0xffffffff80000000, float:-0.0))) goto L406;
        r76 = Math.min(r76, r40);
        goto L409
    L406:
        if (r39 == 0) goto L409;
        r76 = r73;
        goto L409
    L397:
        if (r37 != Integer.MIN_VALUE) goto L399;
        r75 = Math.min(r75, r38);
        goto L402
    L399:
        if (r37 == 0) goto L402;
        r75 = r73;
        goto L402
    L71:
        if (r27 != 2) goto L73;
        r31 = r21;
        r32 = r20;
        r33 = r19;
        r34 = r18;
        r210 = r17;
        int r77 = this.Z0;
        if (r77 != 0) goto L190;
        int r78 = this.Y0;
        if (r78 > 0) goto L189;
        int r79 = 0;
        int r80 = 0;
        int r81 = 0;
    L177:
        if (r79 >= r115) goto L188;
        if (r79 <= 0) goto L180;
        r80 = r80 + this.T0;
    L180:
        f r82 = r116[r79];
        if (r82 == null) goto L187;
        int r83 = Y(r82, r114) + r80;
        if (r83 > r114) goto L188;
        r81 = r81 + 1;
        r80 = r83;
    L187:
        r79 = r79 + 1;
    L188:
        int r84 = 0;
    L207:
        if (this.d1 != null) goto L209;
        this.d1 = new int[2];
    L209:
        if (r84 == 0) goto L211;
    L212:
        if (r81 != 0) goto L215;
        if (r77 != 0) goto L215;
    L214:
        boolean r85 = true;
    L216:
        if (r85 == true) goto L284;
        if (r77 != 0) goto L219;
        r84 = (int) Math.ceil(r115 / r81);
    L220:
        f[] r86 = this.f17453c1;
        if (r86 != null) goto L223;
    L224:
        Object r87 = null;
        this.f17453c1 = new f[r81];
    L227:
        f[] r88 = this.b1;
        if (r88 != null) goto L230;
    L233:
        this.b1 = new f[r84];
    L234:
        int r89 = 0;
    L235:
        if (r89 >= r81) goto L259;
        int r90 = 0;
    L237:
        if (r90 >= r84) goto L258;
        int r91 = (r90 * r81) + r89;
        if (r77 != 1) goto L242;
        r91 = (r89 * r84) + r90;
    L242:
        if (r91 >= r116.length) goto L257;
        f r92 = r116[r91];
        if (r92 == null) goto L257;
        int r93 = Y(r92, r114);
        f r94 = this.f17453c1[r89];
        if (r94 != null) goto L250;
    L251:
        this.f17453c1[r89] = r92;
    L252:
        int r95 = X(r92, r114);
        f r96 = this.b1[r90];
        if (r96 != null) goto L255;
    L256:
        this.b1[r90] = r92;
        goto L257
    L255:
        if (r96.l() >= r95) goto L257;
    L250:
        if (r94.r() >= r93) goto L252;
    L257:
        r90 = r90 + 1;
        goto L237
    L258:
        r89 = r89 + 1;
        goto L235
    L259:
        int r97 = 0;
        int r98 = 0;
    L260:
        if (r97 >= r81) goto L267;
        f r99 = this.f17453c1[r97];
        if (r99 == null) goto L266;
        if (r97 <= 0) goto L265;
        r98 = r98 + this.T0;
    L265:
        r98 = Y(r99, r114) + r98;
    L266:
        r97 = r97 + 1;
        goto L260
    L267:
        int r100 = 0;
        int r101 = 0;
    L268:
        if (r100 >= r84) goto L275;
        f r102 = this.b1[r100];
        if (r102 == null) goto L274;
        if (r100 <= 0) goto L273;
        r101 = r101 + this.U0;
    L273:
        r101 = X(r102, r114) + r101;
    L274:
        r100 = r100 + 1;
        goto L268
    L275:
        r31[0] = r98;
        r31[1] = r101;
        if (r77 == 0) goto L277;
        if (r101 <= r114) goto L280;
        if (r84 <= 1) goto L280;
        r84 = r84 - 1;
    L280:
        r85 = true;
        goto L216
    L277:
        if (r98 <= r114) goto L280;
        if (r81 <= 1) goto L280;
        r81 = r81 - 1;
        goto L216
    L230:
        if (r88.length < r84) goto L233;
        Arrays.fill(r88, r87);
        goto L234
    L223:
        if (r86.length < r81) goto L224;
        r87 = null;
        Arrays.fill(r86, null);
        goto L227
    L219:
        r81 = (int) Math.ceil(r115 / r84);
        goto L220
    L284:
        int[] r103 = this.d1;
        r103[0] = r81;
        r103[1] = r84;
    L215:
        r85 = false;
        goto L216
    L211:
        if (r77 == 1) goto L214;
    L189:
        r81 = r78;
        goto L188
    L190:
        r84 = this.Y0;
        if (r84 > 0) goto L205;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L193:
        if (r104 >= r115) goto L204;
        if (r104 <= 0) goto L196;
        r105 = r105 + this.U0;
    L196:
        f r107 = r116[r104];
        if (r107 == null) goto L203;
        int r108 = X(r107, r114) + r105;
        if (r108 > r114) goto L204;
        r106 = r106 + 1;
        r105 = r108;
    L203:
        r104 = r104 + 1;
    L204:
        r84 = r106;
    L205:
        r81 = 0;
        goto L207
    L73:
        if (r27 == 3) goto L76;
    L74:
        r31 = r21;
        r32 = r20;
        r33 = r19;
        r34 = r18;
        r210 = r17;
        goto L75
    L76:
        int r109 = this.Z0;
        if (r115 == 0) goto L74;
        r28.clear();
        int r213 = r114;
        ArrayList r133 = r28;
        r31 = r21;
        r32 = r20;
        r33 = r19;
        r34 = r18;
        h r134 = new h(this, r109, this.J, this.K, this.L, this.M, r213);
        r133.add(r134);
        if (r109 != 0) goto L108;
        int r135 = 0;
        int r136 = 0;
        int r137 = 0;
        int r138 = 0;
    L82:
        if (r138 >= r115) goto L107;
        r135 = r135 + 1;
        f r139 = r116[r138];
        int r140 = r213;
        int r141 = Y(r139, r140);
        if (r139.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L86;
        r136 = r136 + 1;
    L86:
        int r214 = r136;
        if (r137 == r140) goto L91;
        if (((this.T0 + r137) + r141) > r140) goto L91;
    L93:
        boolean r142 = false;
    L94:
        if (r142 == true) goto L100;
        if (r138 <= 0) goto L100;
        int r143 = this.Y0;
        if (r143 <= 0) goto L100;
        if (r135 <= r143) goto L100;
        r142 = true;
    L100:
        if (r142 == false) goto L102;
        r213 = r140;
        f r144 = r139;
        int r145 = r138;
        h r146 = new h(this, r109, this.J, this.K, this.L, this.M, r213);
        r146.f17447n = r145;
        r133.add(r146);
        r134 = r146;
        r137 = r141;
        r135 = 1;
    L106:
        r134.a(r144);
        r138 = r145 + 1;
        r136 = r214;
        goto L82
    L102:
        r213 = r140;
        r145 = r138;
        r144 = r139;
        if (r145 <= 0) goto L105;
        r137 = (this.T0 + r141) + r137;
        goto L106
    L105:
        r137 = r141;
    L91:
        if (r134.f17439b == null) goto L93;
        r142 = true;
    L107:
        int r147 = r213;
        r210 = r17;
        int r148 = r133.size();
        int r149 = this.A0;
        int r150 = this.f17465w0;
        int r151 = this.B0;
        int r152 = this.f17466x0;
        ConstraintWidget$DimensionBehaviour[] r153 = this.U;
        ConstraintWidget$DimensionBehaviour r154 = r153[0];
        ConstraintWidget$DimensionBehaviour r155 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r154 != r155) goto L137;
    L140:
        boolean r156 = true;
    L141:
        if (r136 <= 0) goto L150;
        if (r156 == false) goto L150;
        int r157 = 0;
    L144:
        if (r157 >= r148) goto L150;
        h r158 = (h) r133.get(r157);
        if (r109 != 0) goto L148;
        r158.e(r147 - r158.d());
    L149:
        r157 = r157 + 1;
        goto L144
    L148:
        r158.e(r147 - r158.c());
    L150:
        int r159 = r150;
        d r160 = r29;
        d r161 = r117;
        d r162 = r118;
        int r163 = 0;
        int r164 = 0;
        int r165 = 0;
        int r166 = r149;
        d r167 = r30;
    L151:
        if (r163 >= r148) goto L171;
        h r168 = (h) r133.get(r163);
        if (r109 == 0) goto L155;
        ArrayList r311 = r133;
        if (r163 >= (r148 - 1)) goto L165;
        r133 = r311;
        r161 = ((h) r133.get(r163 + 1)).f17439b.J;
        r151 = 0;
    L166:
        d r169 = r168.f17439b.L;
        r168.f(r109, r167, r160, r161, r162, r166, r159, r151, r152, r147);
        int r170 = r168.d() + r164;
        int r171 = Math.max(r165, r168.c());
        if (r163 <= 0) goto L169;
        r170 = r170 + this.T0;
    L169:
        r164 = r170;
        r165 = r171;
        r166 = 0;
        r167 = r169;
    L170:
        r163 = r163 + 1;
        r148 = r148;
        goto L151
    L165:
        r133 = r311;
        r151 = this.B0;
        r161 = r117;
        goto L166
    L155:
        if (r163 >= (r148 - 1)) goto L157;
        r162 = ((h) r133.get(r163 + 1)).f17439b.K;
        r152 = 0;
    L158:
        d r172 = r168.f17439b.M;
        r168.f(r109, r167, r160, r161, r162, r166, r159, r151, r152, r147);
        int r173 = Math.max(r164, r168.d());
        int r174 = r168.c() + r165;
        if (r163 <= 0) goto L161;
        r174 = r174 + this.U0;
    L161:
        r164 = r173;
        r165 = r174;
        r160 = r172;
        r133 = r133;
        r159 = 0;
        r148 = r148;
        goto L170
    L157:
        r152 = this.f17466x0;
        r162 = r118;
        goto L158
    L171:
        r31[0] = r164;
        r31[1] = r165;
        goto L75
    L137:
        if (r153[1] == r155) goto L140;
        r156 = false;
        goto L141
    L108:
        int r175 = 0;
        r136 = 0;
        int r176 = 0;
        int r177 = 0;
    L109:
        if (r177 >= r115) goto L107;
        r175 = r175 + 1;
        f r178 = r116[r177];
        int r179 = r213;
        int r180 = X(r178, r179);
        if (r178.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L113;
        r136 = r136 + 1;
    L113:
        int r181 = r136;
        if (r176 == r179) goto L118;
        if (((this.U0 + r176) + r180) > r179) goto L118;
    L120:
        boolean r182 = false;
    L121:
        if (r182 == true) goto L127;
        if (r177 <= 0) goto L127;
        int r183 = this.Y0;
        if (r183 <= 0) goto L127;
        if (r175 <= r183) goto L127;
        r182 = true;
    L127:
        if (r182 == false) goto L129;
        int r215 = r17;
        h r184 = new h(this, r109, this.J, this.K, this.L, this.M, r179);
        r184.f17447n = r177;
        r133.add(r184);
        r134 = r184;
        r176 = r180;
        r175 = 1;
    L133:
        r134.a(r178);
        r177 = r177 + 1;
        r136 = r181;
        r17 = r215;
        r213 = r179;
        goto L109
    L129:
        r215 = r17;
        if (r177 <= 0) goto L132;
        r176 = (this.U0 + r180) + r176;
        goto L133
    L132:
        r176 = r180;
    L118:
        if (r134.f17439b == null) goto L120;
        r182 = true;
        goto L121
    L382:
        r31 = r21;
        r32 = r20;
        r33 = r19;
        r34 = r18;
        r210 = r17;
        int r185 = this.Z0;
        if (r115 == 0) goto L75;
        if (r28.size() != 0) goto L388;
        h r186 = new h(this, r185, this.J, this.K, this.L, this.M, r114);
        r28.add(r186);
    L389:
        int r187 = 0;
    L390:
        if (r187 >= r115) goto L392;
        r186.a(r116[r187]);
        r187 = r187 + 1;
        goto L390
    L392:
        r73 = 0;
        r31[0] = r186.d();
        r74 = 1;
        r31[1] = r186.c();
        goto L393
    L388:
        r186 = (h) r28.get(0);
        r186.f17440c = 0;
        r186.f17439b = null;
        r186.f17445l = 0;
        r186.f17446m = 0;
        r186.f17447n = 0;
        r186.f17448o = 0;
        r186.f17449p = 0;
        int r188 = this.A0;
        int r189 = this.f17465w0;
        int r190 = this.B0;
        int r191 = this.f17466x0;
        r186.f(r185, this.J, this.K, this.L, this.M, r188, r189, r190, r191, r114);
        goto L389
    L46:
        if (this.H0 != (-1)) goto L49;
        this.H0 = 0;
    L49:
        if (this.I0 != (-1)) goto L51;
        this.I0 = 0;
        goto L51
    }

    public final int X(f r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r5 = r10.s;
        if (r5 != 0) goto L11;
        return 0;
    L11:
        if (r5 != 2) goto L16;
        int r12 = (int) (r10.f17431z * r11);
        if (r12 == r10.l()) goto L15;
        r10.g = true;
        W(r10, r10.U[0], r10.r(), ConstraintWidget$DimensionBehaviour.FIXED, r12);
    L15:
        return r12;
    L16:
        if (r5 != 1) goto L20;
        return r10.l();
    L20:
        if (r5 != 3) goto L24;
        return (int) ((r10.r() * r10.Y) + 0.5f);
    L24:
        return r10.l();
    }

    public final int Y(f r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r5 = r10.f17421r;
        if (r5 != 0) goto L11;
        return 0;
    L11:
        if (r5 != 2) goto L16;
        int r12 = (int) (r10.f17428w * r11);
        if (r12 == r10.r()) goto L15;
        r10.g = true;
        W(r10, ConstraintWidget$DimensionBehaviour.FIXED, r12, r10.U[1], r10.l());
    L15:
        return r12;
    L16:
        if (r5 != 1) goto L20;
        return r10.r();
    L20:
        if (r5 != 3) goto L24;
        return (int) ((r10.l() * r10.Y) + 0.5f);
    L24:
        return r10.r();
    }

    @Override // hr.f
    public final void b(fr.c r12, boolean r13) {
        super.b(r12, r13);
        f r14 = this.V;
        if (r14 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        int r5 = this.X0;
        ArrayList r10 = this.f17452a1;
        if (r5 == 0) goto L104;
        if (r5 != 1) goto L12;
        int r11 = r10.size();
        int r16 = 0;
    L97:
        if (r16 >= r11) goto L106;
        h r17 = (h) r10.get(r16);
        if (r16 != (r11 - 1)) goto L101;
        boolean r18 = true;
    L102:
        r17.b(r15, r16, r18);
        r16 = r16 + 1;
        goto L97
    L101:
        r18 = false;
    L106:
        this.C0 = false;
        return;
    L12:
        if (r5 == 2) goto L24;
        if (r5 != 3) goto L106;
        int r19 = r10.size();
        int r20 = 0;
    L17:
        if (r20 >= r19) goto L106;
        h r21 = (h) r10.get(r20);
        if (r20 != (r19 - 1)) goto L21;
        boolean r22 = true;
    L22:
        r21.b(r15, r20, r22);
        r20 = r20 + 1;
        goto L17
    L21:
        r22 = false;
        goto L22
    L24:
        if (this.d1 == null) goto L106;
        if (this.f17453c1 == null) goto L106;
        if (this.b1 == null) goto L106;
        int r23 = 0;
    L32:
        if (r23 >= this.f1) goto L34;
        this.f17454e1[r23].E();
        r23 = r23 + 1;
        goto L32
    L34:
        int[] r24 = this.d1;
        int r25 = r24[0];
        int r26 = r24[1];
        float r27 = this.N0;
        f r28 = null;
        int r29 = 0;
    L36:
        if (r29 >= r25) goto L56;
        if (r15 == false) goto L39;
        int r30 = (r25 - r29) - 1;
        float r31 = 1.0f - this.N0;
    L40:
        f r32 = this.f17453c1[r30];
        if (r32 == null) goto L55;
        if (r32.i0 == 8) goto L55;
        d r33 = r32.J;
        if (r29 != 0) goto L49;
        r32.f(r33, this.J, this.A0);
        r32.l0 = this.H0;
        r32.f17402f0 = r31;
    L49:
        if (r29 != (r25 - 1)) goto L51;
        r32.f(r32.L, this.L, this.B0);
    L51:
        if (r29 <= 0) goto L54;
        if (r28 == null) goto L54;
        int r34 = this.T0;
        d r35 = r28.L;
        r32.f(r33, r35, r34);
        r28.f(r35, r33, 0);
    L54:
        r28 = r32;
    L55:
        r29 = r29 + 1;
        r27 = r31;
        goto L36
    L39:
        r31 = r27;
        r30 = r29;
        goto L40
    L56:
        int r110 = 0;
    L57:
        if (r110 >= r26) goto L74;
        f r36 = this.b1[r110];
        if (r36 == null) goto L73;
        if (r36.i0 == 8) goto L73;
        d r37 = r36.K;
        if (r110 != 0) goto L67;
        r36.f(r37, this.K, this.f17465w0);
        r36.f17412m0 = this.I0;
        r36.g0 = this.O0;
    L67:
        if (r110 != (r26 - 1)) goto L69;
        r36.f(r36.M, this.M, this.f17466x0);
    L69:
        if (r110 <= 0) goto L72;
        if (r28 == null) goto L72;
        int r38 = this.U0;
        d r39 = r28.M;
        r36.f(r37, r39, r38);
        r28.f(r39, r37, 0);
    L72:
        r28 = r36;
    L73:
        r110 = r110 + 1;
        goto L57
    L74:
        int r111 = 0;
    L75:
        if (r111 >= r25) goto L106;
        int r40 = 0;
    L77:
        if (r40 >= r26) goto L95;
        int r41 = (r40 * r25) + r111;
        if (this.Z0 != 1) goto L81;
        r41 = (r111 * r26) + r40;
    L81:
        f[] r42 = this.f17454e1;
        if (r41 >= r42.length) goto L94;
        f r43 = r42[r41];
        if (r43 == null) goto L94;
        if (r43.i0 == 8) goto L94;
        f r44 = this.f17453c1[r111];
        f r45 = this.b1[r40];
        if (r43 == r44) goto L92;
        r43.f(r43.J, r44.J, 0);
        r43.f(r43.L, r44.L, 0);
    L92:
        if (r43 == r45) goto L94;
        r43.f(r43.K, r45.K, 0);
        r43.f(r43.M, r45.M, 0);
    L94:
        r40 = r40 + 1;
        goto L77
    L95:
        r111 = r111 + 1;
        goto L75
    L104:
        if (r10.size() <= 0) goto L106;
        ((h) r10.get(0)).b(r15, 0, true);
        goto L106
    L5:
        if (((g) r14).f17437z0 == false) goto L7;
        r15 = true;
        goto L8
    }

    @Override // hr.l, hr.f
    public final void g(f r5, HashMap r10) {
        super.g(r5, r10);
        i r11 = (i) r5;
        this.H0 = r11.H0;
        this.I0 = r11.I0;
        this.J0 = r11.J0;
        this.K0 = r11.K0;
        this.L0 = r11.L0;
        this.M0 = r11.M0;
        this.N0 = r11.N0;
        this.O0 = r11.O0;
        this.P0 = r11.P0;
        this.Q0 = r11.Q0;
        this.R0 = r11.R0;
        this.S0 = r11.S0;
        this.T0 = r11.T0;
        this.U0 = r11.U0;
        this.V0 = r11.V0;
        this.W0 = r11.W0;
        this.X0 = r11.X0;
        this.Y0 = r11.Y0;
        this.Z0 = r11.Z0;
    }
}
