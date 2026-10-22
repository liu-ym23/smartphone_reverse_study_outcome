package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f17464a = null;

    static {
        f17464a = new boolean[3];
    }

    public static void a(g r38, fr.c r39, ArrayList r40, int r41) {
        g r5 = r38;
        if (r41 != 0) goto L5;
        int r14 = r5.D0;
        b[] r15 = r5.G0;
        int r16 = 0;
    L6:
        int r10 = 0;
    L7:
        if (r10 >= r14) goto L431;
        b r11 = r15[r10];
        boolean r12 = r11.f17385q;
        f r13 = r11.f17373a;
        int r17 = 1;
        int r18 = 8;
        fr.e r19 = null;
        if (r12 == true) goto L98;
        int r20 = r11.f17380l;
        int r21 = r20 * 2;
        f r110 = r13;
        f r111 = r110;
        boolean r22 = false;
    L11:
        if (r22 == true) goto L79;
        r11.f17377i += r17;
        r110.f17418p0[r20] = null;
        r110.f17416o0[r20] = null;
        int r23 = r110.i0;
        d[] r24 = r110.R;
        if (r23 == r18) goto L65;
        r110.k(r20);
        ConstraintWidget$DimensionBehaviour r25 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        r24[r21].e();
        int r26 = r21 + 1;
        r24[r26].e();
        r24[r21].e();
        r24[r26].e();
        if (r11.f17374b != null) goto L17;
        r11.f17374b = r110;
    L17:
        r11.d = r110;
        ConstraintWidget$DimensionBehaviour r27 = r110.U[r20];
        if (r27 != r25) goto L65;
        int r112 = r110.f17424t[r20];
        boolean r28 = r22;
        if (r112 == 0) goto L26;
        if (r112 == 3) goto L26;
        if (r112 == 2) goto L26;
        r10 = r10;
    L51:
        if (r20 != 0) goto L59;
        if (r110.f17421r == 0) goto L56;
    L64:
        f r29 = r111;
        if (r29 == r110) goto L68;
        r29.f17418p0[r20] = r110;
    L68:
        d r30 = r24[r21 + 1].f;
        if (r30 == null) goto L74;
        f r31 = r30.d;
        d r32 = r31.R[r21].f;
        if (r32 == null) goto L74;
        if (r32.d != r110) goto L74;
    L75:
        if (r31 == null) goto L77;
        r22 = r28;
    L78:
        r111 = r110;
        r10 = r10;
        r14 = r14;
        r18 = 8;
        r110 = r31;
        r17 = 1;
        goto L11
    L77:
        r31 = r110;
        r22 = true;
    L74:
        r31 = null;
        goto L75
    L56:
        if (r110.f17426u != 0) goto L64;
        int r33 = r110.f17427v;
        goto L64
    L59:
        if (r110.s != 0) goto L64;
        if (r110.f17429x != 0) goto L64;
        int r34 = r110.f17430y;
    L26:
        r11.f17378j++;
        float r35 = r110.f17414n0[r20];
        if (r35 <= 0.0f) goto L31;
        r11.f17379k += r35;
    L31:
        if (r110.i0 == 8) goto L45;
        if (r27 != r25) goto L45;
        if (r112 == 0) goto L37;
        if (r112 != 3) goto L45;
    L37:
        if (r35 >= 0.0f) goto L39;
        r11.f17382n = true;
    L41:
        if (r11.f17376h != null) goto L43;
        r11.f17376h = new ArrayList();
    L43:
        r11.f17376h.add(r110);
        goto L45
    L39:
        r11.f17383o = true;
    L45:
        if (r11.f != null) goto L47;
        r11.f = r110;
    L47:
        f r36 = r11.g;
        if (r36 == null) goto L50;
        r36.f17416o0[r20] = r110;
    L50:
        r11.g = r110;
    L65:
        r28 = r22;
        r10 = r10;
        r14 = r14;
        goto L64
    L79:
        int r210 = r10;
        int r211 = r14;
        f r37 = r11.f17374b;
        if (r37 == null) goto L82;
        r37.R[r21].e();
    L82:
        f r42 = r11.d;
        if (r42 == null) goto L85;
        r42.R[r21 + 1].e();
    L85:
        r11.f17375c = r110;
        if (r20 == 0) goto L88;
    L90:
        r11.e = r13;
    L92:
        if (r11.f17383o == true) goto L94;
    L96:
        boolean r43 = false;
    L97:
        r11.f17384p = r43;
        boolean r44 = true;
    L99:
        r11.f17385q = r44;
        if (r40 != 0) goto L102;
    L105:
        f r113 = r11.f17375c;
        f r114 = r11.f17374b;
        f r115 = r11.d;
        f r45 = r11.e;
        float r46 = r11.f17379k;
        if (r5.U[r41] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L108;
        boolean r47 = true;
    L109:
        if (r41 != 0) goto L123;
        int r48 = r45.l0;
        if (r48 != 0) goto L113;
        boolean r212 = true;
    L114:
        if (r48 != 1) goto L117;
        boolean r49 = true;
    L118:
        if (r48 != 2) goto L120;
        boolean r50 = true;
    L121:
        boolean r116 = r49;
        boolean r213 = r212;
    L122:
        boolean r51 = false;
    L134:
        d[] r52 = r5.R;
        float r214 = r46;
        if (r51 == true) goto L192;
        d r53 = r13.R[r16];
        if (r50 == false) goto L139;
        int r215 = 1;
    L140:
        int r310 = r53.e();
        boolean r311 = r51;
        ConstraintWidget$DimensionBehaviour r54 = r13.U[r41];
        ConstraintWidget$DimensionBehaviour r117 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r54 == r117) goto L143;
    L145:
        boolean r55 = false;
    L146:
        d r118 = r53.f;
        if (r118 == null) goto L150;
        if (r13 == r13) goto L150;
        r310 = r118.e() + r310;
    L150:
        int r119 = r310;
        if (r50 == false) goto L156;
        if (r13 == r13) goto L156;
        if (r13 == r114) goto L156;
        r215 = 8;
    L156:
        d r56 = r53.f;
        if (r56 == null) goto L171;
        if (r13 != r114) goto L160;
        r39.f(r53.f17391i, r56.f17391i, r119, 6);
    L161:
        if (r55 == false) goto L164;
        if (r50 == true) goto L164;
        r215 = 5;
    L164:
        if (r13 != r114) goto L169;
        if (r50 == false) goto L169;
        if (r13.T[r41] == false) goto L169;
        int r57 = 5;
    L170:
        r39.e(r53.f17391i, r53.f.f17391i, r119, r57);
    L172:
        d[] r58 = r13.R;
        if (r47 == true) goto L175;
    L181:
        d r59 = r58[r16 + 1].f;
        if (r59 == null) goto L187;
        f r60 = r59.d;
        d r61 = r60.R[r16].f;
        if (r61 == null) goto L187;
        if (r61.d != r13) goto L187;
    L188:
        if (r60 == null) goto L190;
        r13 = r60;
        r51 = r311;
    L191:
        r46 = r214;
        r45 = r45;
        r15 = r15;
        r13 = r13;
        r11 = r11;
        goto L134
    L190:
        r51 = true;
    L187:
        r60 = null;
        goto L188
    L175:
        if (r13.i0 != 8) goto L177;
    L179:
        int r62 = 0;
    L180:
        r39.f(r58[r16].f17391i, r52[r16].f17391i, r62, 8);
        goto L181
    L177:
        if (r13.U[r41] != r117) goto L179;
        r62 = 0;
        r39.f(r58[r16 + 1].f17391i, r58[r16].f17391i, 0, 5);
    L169:
        r57 = r215;
        goto L170
    L160:
        r39.f(r53.f17391i, r56.f17391i, r119, 8);
        goto L161
    L171:
        r11 = r11;
        r13 = r13;
        goto L172
    L143:
        if (r13.f17424t[r41] != 0) goto L145;
        r55 = true;
        goto L146
    L139:
        r215 = 4;
        goto L140
    L192:
        b r312 = r11;
        f r313 = r45;
        f r314 = r13;
        b[] r315 = r15;
        if (r115 == null) goto L211;
        int r63 = r16 + 1;
        if (r113.R[r63].f == null) goto L211;
        d r64 = r115.R[r63];
        if (r115.U[r41] != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L205;
        if (r115.f17424t[r41] != 0) goto L205;
        if (r50 == true) goto L205;
        d r65 = r64.f;
        if (r65.d != r5) goto L205;
        r39.e(r64.f17391i, r65.f17391i, -r64.e(), 5);
    L209:
        r39.g(r64.f17391i, r113.R[r63].f.f17391i, -r64.e(), 6);
    L205:
        if (r50 == false) goto L209;
        d r66 = r64.f;
        if (r66.d != r5) goto L209;
        r39.e(r64.f17391i, r66.f17391i, -r64.e(), 4);
    L211:
        if (r47 == false) goto L213;
        int r67 = r16 + 1;
        fr.e r68 = r52[r67].f17391i;
        d r69 = r113.R[r67];
        r39.f(r68, r69.f17391i, r69.e(), 8);
    L213:
        ArrayList r70 = r312.f17376h;
        if (r70 == null) goto L258;
        int r71 = r70.size();
        if (r71 <= 1) goto L258;
        if (r312.f17382n == true) goto L220;
    L222:
        float r72 = r214;
    L223:
        f r120 = null;
        int r73 = 0;
        float r74 = 0.0f;
    L224:
        if (r73 >= r71) goto L258;
        f r121 = (f) r70.get(r73);
        float r75 = r121.f17414n0[r41];
        d[] r76 = r121.R;
        if (r75 >= 0.0f) goto L234;
        if (r312.f17384p == false) goto L230;
        fr.e r77 = r76[r16 + 1].f17391i;
        fr.e r78 = r76[r16].f17391i;
        boolean r79 = false;
        r39.e(r77, r78, 0, 4);
    L236:
        r70 = r70;
        r71 = r71;
    L256:
        r73 = r73 + 1;
        r71 = r71;
        r70 = r70;
        goto L224
    L230:
        r75 = 1.0f;
    L234:
        if (r75 != 0.0f) goto L238;
        fr.e r80 = r76[r16 + 1].f17391i;
        fr.e r81 = r76[r16].f17391i;
        r79 = false;
        r39.e(r80, r81, 0, 8);
        goto L236
    L238:
        if (r120 == null) goto L254;
        d[] r122 = r120.R;
        fr.e r82 = r122[r16].f17391i;
        int r316 = r16 + 1;
        fr.e r123 = r122[r316].f17391i;
        fr.e r83 = r76[r16].f17391i;
        fr.e r84 = r76[r316].f17391i;
        fr.b r85 = r39.l();
        r85.f16982b = 0.0f;
        if (r72 == 0.0f) goto L252;
        if (r74 == r75) goto L252;
        if (r74 != 0.0f) goto L249;
        r85.d.g(r82, 1.0f);
        r85.d.g(r123, -1.0f);
    L253:
        r39.c(r85);
    L255:
        r74 = r75;
        r120 = r121;
        goto L256
    L249:
        if (r75 != 0.0f) goto L251;
        r85.d.g(r83, 1.0f);
        r85.d.g(r84, -1.0f);
        goto L253
    L251:
        float r86 = (r74 / r72) / (r75 / r72);
        r85.d.g(r82, 1.0f);
        r85.d.g(r123, -1.0f);
        r85.d.g(r84, r86);
        r85.d.g(r83, -r86);
    L252:
        r85.d.g(r82, 1.0f);
        r85.d.g(r123, -1.0f);
        r85.d.g(r84, 1.0f);
        r85.d.g(r83, -1.0f);
        goto L253
    L254:
        r75 = r75;
        goto L255
    L220:
        if (r312.f17384p == true) goto L222;
        r72 = r312.f17378j;
    L258:
        if (r114 == null) goto L262;
        if (r114 == r115) goto L263;
        if (r50 == false) goto L262;
    L263:
        d r87 = r314.R[r16];
        int r88 = r16 + 1;
        d r89 = r113.R[r88];
        d r90 = r87.f;
        if (r90 == null) goto L266;
        fr.e r91 = r90.f17391i;
    L267:
        d r92 = r89.f;
        if (r92 == null) goto L270;
        fr.e r93 = r92.f17391i;
    L271:
        d r94 = r114.R[r16];
        if (r115 == null) goto L274;
        r89 = r115.R[r88];
    L274:
        if (r91 == null) goto L281;
        if (r93 == null) goto L281;
        if (r41 != 0) goto L279;
        float r95 = r313.f17402f0;
    L278:
        float r96 = r95;
        int r124 = r210;
        r39.b(r94.f17391i, r91, r94.e(), r96, r93, r89.f17391i, r89.e(), 7);
    L282:
        int r216 = r124;
    L405:
        if (r213 == true) goto L407;
        if (r116 == true) goto L407;
    L430:
        r10 = r216 + 1;
        r5 = r38;
        r14 = r211;
        r15 = r315;
    L407:
        if (r114 == null) goto L430;
        if (r114 == r115) goto L430;
        d[] r97 = r114.R;
        d r98 = r97[r16];
        if (r115 != null) goto L412;
        r115 = r114;
    L412:
        int r99 = r16 + 1;
        d[] r100 = r115.R;
        d r101 = r100[r99];
        d r102 = r98.f;
        if (r102 == null) goto L415;
        fr.e r103 = r102.f17391i;
    L416:
        d r104 = r101.f;
        if (r104 == null) goto L419;
        fr.e r105 = r104.f17391i;
    L420:
        if (r113 == r115) goto L425;
        d r106 = r113.R[r99].f;
        if (r106 == null) goto L424;
        r19 = r106.f17391i;
    L424:
        r105 = r19;
    L425:
        if (r114 != r115) goto L427;
        r101 = r97[r99];
    L427:
        if (r103 == null) goto L430;
        if (r105 == null) goto L430;
        int r107 = r98.e();
        int r108 = r100[r99].e();
        r39.b(r98.f17391i, r103, r107, 0.5f, r105, r101.f17391i, r108, 5);
        goto L430
    L419:
        r105 = null;
        goto L420
    L415:
        r103 = null;
        goto L416
    L279:
        r95 = r313.g0;
    L281:
        r124 = r210;
        goto L282
    L270:
        r93 = null;
        goto L271
    L266:
        r91 = null;
    L262:
        r124 = r210;
        if (r213 == false) goto L342;
        if (r114 == null) goto L342;
        int r109 = r312.f17378j;
        if (r109 > 0) goto L288;
    L290:
        boolean r217 = false;
    L291:
        f r125 = r114;
        f r126 = r125;
    L292:
        if (r126 == null) goto L282;
        f r127 = r126.f17418p0[r41];
    L294:
        if (r127 == null) goto L299;
        if (r127.i0 != 8) goto L299;
        r127 = r127.f17418p0[r41];
    L299:
        if (r127 != null) goto L303;
        if (r126 == r115) goto L303;
    L302:
        f r218 = r127;
    L338:
        if (r126.i0 == 8) goto L340;
        r125 = r126;
    L341:
        r126 = r218;
        goto L292
    L340:
        r125 = r125;
    L303:
        d[] r128 = r126.R;
        d r129 = r128[r16];
        fr.e r130 = r129.f17391i;
        d r131 = r129.f;
        if (r131 == null) goto L306;
        fr.e r132 = r131.f17391i;
    L307:
        if (r125 == r126) goto L309;
        r132 = r125.R[r16 + 1].f17391i;
    L314:
        int r133 = r129.e();
        int r134 = r16 + 1;
        int r219 = r128[r134].e();
        if (r127 == null) goto L317;
        d r135 = r127.R[r16];
        fr.e r136 = r135.f17391i;
    L321:
        fr.e r137 = r128[r134].f17391i;
        if (r135 == null) goto L324;
        r219 = r135.e() + r219;
    L324:
        int r138 = r125.R[r134].e() + r133;
        if (r130 == null) goto L302;
        if (r132 == null) goto L302;
        if (r136 == null) goto L302;
        if (r137 == null) goto L302;
        if (r126 != r114) goto L331;
        r138 = r114.R[r16].e();
    L331:
        if (r126 != r115) goto L333;
        r219 = r115.R[r134].e();
    L333:
        if (r217 == false) goto L335;
        int r220 = 8;
    L336:
        int r139 = r219;
        r218 = r127;
        r39.b(r130, r132, r138, 0.5f, r136, r137, r139, r220);
        goto L338
    L335:
        r220 = 5;
        goto L336
    L317:
        r135 = r113.R[r134].f;
        if (r135 == null) goto L320;
        r136 = r135.f17391i;
        goto L321
    L320:
        r136 = null;
        goto L321
    L309:
        if (r126 != r114) goto L314;
        d r140 = r314.R[r16].f;
        if (r140 == null) goto L313;
        r132 = r140.f17391i;
        goto L314
    L313:
        r132 = null;
        goto L314
    L306:
        r132 = null;
        goto L307
    L288:
        if (r312.f17377i != r109) goto L290;
        r217 = true;
    L342:
        int r141 = 8;
        if (r116 == false) goto L282;
        if (r114 == null) goto L282;
        int r142 = r312.f17378j;
        if (r142 > 0) goto L348;
    L350:
        boolean r221 = false;
    L351:
        f r143 = r114;
        f r144 = r143;
    L352:
        if (r144 == null) goto L395;
        f r145 = r144.f17418p0[r41];
    L354:
        if (r145 == null) goto L358;
        if (r145.i0 != r141) goto L358;
        r145 = r145.f17418p0[r41];
    L358:
        if (r144 == r114) goto L389;
        if (r144 == r115) goto L389;
        if (r145 == null) goto L389;
        if (r145 != r115) goto L363;
        f r146 = null;
    L364:
        d[] r147 = r144.R;
        d r148 = r147[r16];
        fr.e r149 = r148.f17391i;
        int r150 = r16 + 1;
        fr.e r151 = r143.R[r150].f17391i;
        int r152 = r148.e();
        int r153 = r147[r150].e();
        if (r146 == null) goto L370;
        d r154 = r146.R[r16];
        fr.e r155 = r154.f17391i;
        f r222 = r146;
        d r156 = r154.f;
        if (r156 == null) goto L369;
        fr.e r157 = r156.f17391i;
    L375:
        if (r154 == null) goto L377;
        int r223 = r154.e() + r153;
    L378:
        int r158 = r143.R[r150].e() + r152;
        if (r221 == false) goto L381;
        int r224 = 8;
    L382:
        if (r149 == null) goto L387;
        if (r151 == null) goto L387;
        if (r155 == null) goto L387;
        if (r157 == null) goto L387;
        int r159 = 8;
        r39.b(r149, r151, r158, 0.5f, r155, r157, r223, r224);
    L388:
        r145 = r222;
    L391:
        if (r144.i0 == r159) goto L393;
        r143 = r144;
    L394:
        r144 = r145;
        r141 = r159;
        r124 = r124;
        goto L352
    L393:
        r143 = r143;
    L387:
        r159 = 8;
        goto L388
    L381:
        r224 = 4;
        goto L382
    L377:
        r223 = r153;
        goto L378
    L369:
        r157 = null;
        goto L375
    L370:
        r222 = r146;
        d r160 = r115.R[r16];
        if (r160 == null) goto L373;
        r155 = r160.f17391i;
    L374:
        r157 = r147[r150].f17391i;
        r154 = r160;
        goto L375
    L373:
        r155 = null;
        goto L374
    L363:
        r146 = r145;
    L389:
        r143 = r143;
        r124 = r124;
        r159 = r141;
        goto L391
    L395:
        r216 = r124;
        d r161 = r114.R[r16];
        d r162 = r314.R[r16].f;
        int r163 = r16 + 1;
        d r164 = r115.R[r163];
        d r165 = r113.R[r163].f;
        if (r162 == null) goto L402;
        if (r114 == r115) goto L400;
        r39.e(r161.f17391i, r162.f17391i, r161.e(), 5);
        goto L402
    L400:
        if (r165 == null) goto L402;
        r39.b(r161.f17391i, r162.f17391i, r161.e(), 0.5f, r164.f17391i, r165.f17391i, r164.e(), 5);
    L402:
        if (r165 == null) goto L405;
        if (r114 == r115) goto L405;
        r39.e(r164.f17391i, r165.f17391i, -r164.e(), 5);
        goto L405
    L348:
        if (r312.f17377i != r142) goto L350;
        r221 = true;
        goto L351
    L120:
        r50 = false;
        goto L121
    L117:
        r49 = false;
        goto L118
    L113:
        r212 = false;
        goto L114
    L123:
        int r166 = r45.f17412m0;
        if (r166 != 0) goto L126;
        boolean r167 = true;
    L127:
        if (r166 != 1) goto L129;
        boolean r168 = true;
    L130:
        if (r166 != 2) goto L132;
        r50 = true;
    L133:
        r116 = r168;
        r213 = r167;
        goto L122
    L132:
        r50 = false;
        goto L133
    L129:
        r168 = false;
        goto L130
    L126:
        r167 = false;
        goto L127
    L108:
        r47 = false;
        goto L109
    L102:
        if (r40.contains(r13) == true) goto L105;
        r315 = r15;
        r216 = r210;
        goto L430
    L94:
        if (r11.f17382n == false) goto L96;
        r43 = true;
        goto L97
    L88:
        if (r11.f17381m == false) goto L90;
        r11.e = r110;
        goto L92
    L98:
        r210 = r10;
        r211 = r14;
        r44 = true;
        goto L99
    L431:
        return;
    L5:
        r14 = r5.E0;
        r15 = r5.F0;
        r16 = 2;
        goto L6
    }

    public static void b(g r10, fr.c r11, f r12) {
        r12.f17415o = -1;
        r12.f17417p = -1;
        ConstraintWidget$DimensionBehaviour r5 = r10.U[0];
        ConstraintWidget$DimensionBehaviour r13 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r5 == r13) goto L10;
        if (r12.U[0] != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L10;
        d r14 = r12.J;
        int r15 = r14.g;
        int r16 = r10.r();
        d r17 = r12.L;
        int r18 = r16 - r17.g;
        r14.f17391i = r11.k(r14);
        r17.f17391i = r11.k(r17);
        r11.d(r14.f17391i, r15);
        r11.d(r17.f17391i, r18);
        r12.f17415o = 2;
        r12.f17395a0 = r15;
        int r19 = r18 - r15;
        r12.W = r19;
        int r20 = r12.f17400d0;
        if (r19 >= r20) goto L10;
        r12.W = r20;
    L10:
        if (r10.U[1] != r13) goto L12;
        return;
    L12:
        if (r12.U[1] != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L23;
        d r21 = r12.K;
        int r22 = r21.g;
        int r23 = r10.l();
        d r24 = r12.M;
        int r25 = r23 - r24.g;
        r21.f17391i = r11.k(r21);
        r24.f17391i = r11.k(r24);
        r11.d(r21.f17391i, r22);
        r11.d(r24.f17391i, r25);
        if (r12.f17399c0 <= 0) goto L16;
    L17:
        d r26 = r12.N;
        r26.f17391i = r11.k(r26);
        r11.d(r26.f17391i, r12.f17399c0 + r22);
    L18:
        r12.f17417p = 2;
        r12.f17397b0 = r22;
        int r27 = r25 - r22;
        r12.X = r27;
        int r28 = r12.f17401e0;
        if (r27 >= r28) goto L24;
        r12.X = r28;
        return;
    L24:
        return;
    L16:
        if (r12.i0 != 8) goto L18;
    }

    public static final boolean c(int r5, int r10) {
        if ((r5 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }
}
