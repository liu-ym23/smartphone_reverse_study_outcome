package s;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(f r40, p.d r41, ArrayList<e> r42, int r43) {
        f r8 = r40;
        if (r43 != 0) goto L5;
        int r14 = r8.B0;
        c[] r15 = r8.E0;
        int r16 = 0;
    L6:
        int r10 = 0;
    L7:
        if (r10 >= r14) goto L425;
        c r11 = r15[r10];
        boolean r12 = r11.f11829q;
        int r13 = 8;
        int r17 = 1;
        e r18 = r11.f11813a;
        p.h r19 = null;
        if (r12 == true) goto L88;
        int r20 = r11.f11824l;
        int r21 = r20 * 2;
        e r110 = r18;
        e r111 = r110;
        boolean r22 = false;
    L11:
        if (r22 == true) goto L69;
        r11.f11821i += r17;
        r110.f11878p0[r20] = null;
        r110.f11876o0[r20] = null;
        int r23 = r110.f11866j0;
        d[] r24 = r110.S;
        if (r23 == r13) goto L54;
        r110.k(r20);
        e.a r25 = e.a.f11893m;
        r24[r21].e();
        int r26 = r21 + 1;
        r24[r26].e();
        r24[r21].e();
        r24[r26].e();
        if (r11.f11814b != null) goto L17;
        r11.f11814b = r110;
    L17:
        r11.f11816d = r110;
        e.a r27 = r110.V[r20];
        if (r27 != r25) goto L54;
        int r112 = r110.f11885u[r20];
        boolean r28 = r22;
        if (r112 == 0) goto L26;
        if (r112 == 3) goto L26;
        if (r112 == 2) goto L26;
    L25:
        r10 = r10;
    L55:
        e r29 = r111;
        if (r29 == r110) goto L58;
        r29.f11878p0[r20] = r110;
    L58:
        d r30 = r24[r21 + 1].f11835f;
        if (r30 == null) goto L64;
        e r31 = r30.f11833d;
        d r32 = r31.S[r21].f11835f;
        if (r32 == null) goto L64;
        if (r32.f11833d != r110) goto L64;
    L65:
        if (r31 == null) goto L67;
        r22 = r28;
    L68:
        r111 = r110;
        r10 = r10;
        r14 = r14;
        r17 = 1;
        r13 = 8;
        r110 = r31;
        goto L11
    L67:
        r31 = r110;
        r22 = true;
    L64:
        r31 = null;
    L26:
        r11.f11822j++;
        float r33 = r110.f11874n0[r20];
        if (r33 <= 0.0f) goto L31;
        r11.f11823k += r33;
    L31:
        if (r110.f11866j0 == 8) goto L37;
        if (r27 != r25) goto L37;
        if (r112 != 0) goto L35;
    L36:
        boolean r34 = true;
    L38:
        if (r34 == false) goto L48;
        if (r33 >= 0.0f) goto L42;
        r11.f11826n = true;
    L44:
        if (r11.f11820h != null) goto L46;
        r11.f11820h = new ArrayList();
    L46:
        r11.f11820h.add(r110);
        goto L48
    L42:
        r11.f11827o = true;
    L48:
        if (r11.f11818f != null) goto L50;
        r11.f11818f = r110;
    L50:
        e r35 = r11.f11819g;
        if (r35 == null) goto L53;
        r35.f11876o0[r20] = r110;
    L53:
        r11.f11819g = r110;
        goto L55
    L35:
        if (r112 == 3) goto L36;
    L37:
        r34 = false;
    L54:
        r28 = r22;
        goto L25
    L69:
        int r210 = r10;
        int r211 = r14;
        e r36 = r11.f11814b;
        if (r36 == null) goto L72;
        r36.S[r21].e();
    L72:
        e r37 = r11.f11816d;
        if (r37 == null) goto L75;
        r37.S[r21 + 1].e();
    L75:
        r11.f11815c = r110;
        if (r20 == 0) goto L78;
    L80:
        r11.f11817e = r18;
    L82:
        if (r11.f11827o == true) goto L84;
    L86:
        boolean r38 = false;
    L87:
        r11.f11828p = r38;
        boolean r39 = true;
    L89:
        r11.f11829q = r39;
        if (r42 != 0) goto L92;
    L95:
        e r113 = r11.f11815c;
        e r114 = r11.f11814b;
        e r115 = r11.f11816d;
        e r44 = r11.f11817e;
        float r45 = r11.f11823k;
        if (r8.V[r43] != e.a.f11892b) goto L98;
        boolean r46 = true;
    L99:
        if (r43 != 0) goto L111;
        int r47 = r44.f11870l0;
        if (r47 != 0) goto L103;
        boolean r212 = true;
    L104:
        if (r47 != 1) goto L106;
        boolean r48 = true;
    L108:
        if (r47 != 2) goto L110;
        boolean r49 = r212;
    L120:
        boolean r116 = r49;
        boolean r213 = r48;
        boolean r50 = true;
    L123:
        e r51 = r18;
        boolean r52 = false;
    L124:
        d[] r53 = r8.S;
        if (r52 == true) goto L181;
        float r214 = r45;
        d r54 = r51.S[r16];
        if (r50 == false) goto L129;
        int r215 = 1;
    L130:
        int r310 = r54.e();
        boolean r311 = r52;
        e.a[] r55 = r51.V;
        e.a r117 = r55[r43];
        c[] r312 = r15;
        e.a r118 = e.a.f11893m;
        if (r117 == r118) goto L133;
    L135:
        boolean r119 = false;
    L136:
        d r56 = r54.f11835f;
        if (r56 == null) goto L140;
        if (r51 == r18) goto L140;
        r310 = r56.e() + r310;
    L140:
        int r57 = r310;
        if (r50 == false) goto L146;
        if (r51 == r18) goto L146;
        if (r51 == r114) goto L146;
        r215 = 8;
    L146:
        d r58 = r54.f11835f;
        c r313 = r11;
        if (r58 == null) goto L161;
        if (r51 != r114) goto L150;
        r41.f(r54.f11838i, r58.f11838i, r57, 6);
    L151:
        if (r119 == false) goto L154;
        if (r50 == true) goto L154;
        r215 = 5;
    L154:
        if (r51 != r114) goto L159;
        if (r50 == false) goto L159;
        if (r51.U[r43] == false) goto L159;
        int r59 = 5;
    L160:
        r41.e(r54.f11838i, r54.f11835f.f11838i, r57, r59);
    L159:
        r59 = r215;
        goto L160
    L150:
        r41.f(r54.f11838i, r58.f11838i, r57, 8);
    L161:
        d[] r60 = r51.S;
        if (r46 == true) goto L164;
    L170:
        d r61 = r60[r16 + 1].f11835f;
        if (r61 == null) goto L176;
        e r62 = r61.f11833d;
        d r63 = r62.S[r16].f11835f;
        if (r63 == null) goto L176;
        if (r63.f11833d != r51) goto L176;
    L177:
        if (r62 == null) goto L179;
        r51 = r62;
        r52 = r311;
    L180:
        r8 = r40;
        r45 = r214;
        r18 = r18;
        r15 = r312;
        r44 = r44;
        r11 = r313;
        goto L124
    L179:
        r52 = true;
    L176:
        r62 = null;
        goto L177
    L164:
        if (r51.f11866j0 != 8) goto L166;
    L168:
        int r64 = 0;
    L169:
        r41.f(r60[r16].f11838i, r53[r16].f11838i, r64, 8);
        goto L170
    L166:
        if (r55[r43] != r118) goto L168;
        r64 = 0;
        r41.f(r60[r16 + 1].f11838i, r60[r16].f11838i, 0, 5);
        goto L169
    L133:
        if (r51.f11885u[r43] != 0) goto L135;
        r119 = true;
        goto L136
    L129:
        r215 = 4;
        goto L130
    L181:
        c r314 = r11;
        e r315 = r44;
        float r216 = r45;
        e r316 = r18;
        c[] r317 = r15;
        if (r115 == null) goto L204;
        int r65 = r16 + 1;
        if (r113.S[r65].f11835f == null) goto L204;
        d r66 = r115.S[r65];
        if (r115.V[r43] == e.a.f11893m) goto L188;
    L190:
        boolean r67 = false;
    L191:
        if (r67 == false) goto L197;
        if (r50 == true) goto L197;
        d r68 = r66.f11835f;
        f r120 = r40;
        if (r68.f11833d != r120) goto L198;
        r41.e(r66.f11838i, r68.f11838i, -r66.e(), 5);
    L202:
        r41.g(r66.f11838i, r113.S[r65].f11835f.f11838i, -r66.e(), 6);
    L198:
        if (r50 == false) goto L202;
        d r69 = r66.f11835f;
        if (r69.f11833d != r120) goto L202;
        r41.e(r66.f11838i, r69.f11838i, -r66.e(), 4);
    L197:
        r120 = r40;
        goto L198
    L188:
        if (r115.f11885u[r43] != 0) goto L190;
        r67 = true;
    L204:
        if (r46 == false) goto L206;
        int r70 = r16 + 1;
        p.h r71 = r53[r70].f11838i;
        d r72 = r113.S[r70];
        r41.f(r71, r72.f11838i, r72.e(), 8);
    L206:
        ArrayList<e> r73 = r314.f11820h;
        if (r73 == null) goto L250;
        int r74 = r73.size();
        if (r74 <= 1) goto L250;
        if (r314.f11826n == true) goto L213;
    L215:
        e r75 = null;
        float r76 = 0.0f;
        int r77 = 0;
    L216:
        if (r77 >= r74) goto L250;
        e r78 = r73.get(r77);
        float r79 = r78.f11874n0[r43];
        d[] r121 = r78.S;
        if (r79 < 0.0f) goto L220;
        float r217 = 0.0f;
    L225:
        if (r79 != r217) goto L229;
        p.h r80 = r121[r16 + 1].f11838i;
        p.h r81 = r121[r16].f11838i;
        boolean r122 = false;
        r41.e(r80, r81, 0, 8);
    L227:
        r73 = r73;
        r74 = r74;
    L248:
        r77 = r77 + 1;
        r74 = r74;
        r73 = r73;
        goto L216
    L229:
        if (r75 == null) goto L246;
        d[] r82 = r75.S;
        p.h r83 = r82[r16].f11838i;
        int r318 = r16 + 1;
        p.h r84 = r82[r318].f11838i;
        p.h r85 = r121[r16].f11838i;
        p.h r123 = r121[r318].f11838i;
        p.b r86 = r41.m();
        r86.f9862b = 0.0f;
        if (r216 != 0.0f) goto L233;
    L243:
        r86.f9864d.e(r83, 1.0f);
        r86.f9864d.e(r84, -1.0f);
        r86.f9864d.e(r123, 1.0f);
        p.b.a r87 = r86.f9864d;
        float r88 = -1.0f;
    L244:
        r87.e(r85, r88);
    L245:
        r41.c(r86);
    L247:
        r76 = r79;
        r75 = r78;
        goto L248
    L233:
        if (r76 == r79) goto L243;
        if (r76 != 0.0f) goto L240;
        r86.f9864d.e(r83, 1.0f);
        r86.f9864d.e(r84, -1.0f);
    L238:
        r79 = r79;
        goto L245
    L240:
        if (r79 != r217) goto L242;
        r86.f9864d.e(r85, 1.0f);
        r86.f9864d.e(r123, -1.0f);
        goto L238
    L242:
        float r89 = (r76 / r216) / (r79 / r216);
        r86.f9864d.e(r83, 1.0f);
        r86.f9864d.e(r84, -1.0f);
        r86.f9864d.e(r123, r89);
        r87 = r86.f9864d;
        r88 = -r89;
        goto L244
    L246:
        r79 = r79;
        goto L247
    L220:
        if (r314.f11828p == false) goto L222;
        p.h r90 = r121[r16 + 1].f11838i;
        p.h r91 = r121[r16].f11838i;
        r122 = false;
        r41.e(r90, r91, 0, 4);
        goto L227
    L222:
        r79 = 1.0f;
        r217 = 0.0f;
        goto L225
    L213:
        if (r314.f11828p == true) goto L215;
        r216 = r314.f11822j;
    L250:
        if (r114 == null) goto L272;
        if (r114 == r115) goto L253;
        if (r50 == false) goto L272;
    L253:
        d r92 = r316.S[r16];
        int r93 = r16 + 1;
        d r94 = r113.S[r93];
        d r95 = r92.f11835f;
        if (r95 == null) goto L256;
        p.h r96 = r95.f11838i;
    L257:
        d r97 = r94.f11835f;
        if (r97 == null) goto L260;
        p.h r98 = r97.f11838i;
    L261:
        d r99 = r114.S[r16];
        if (r115 == null) goto L264;
        r94 = r115.S[r93];
    L264:
        if (r96 == null) goto L271;
        if (r98 == null) goto L271;
        if (r43 != 0) goto L269;
        float r100 = r315.f11860g0;
    L270:
        int r101 = r99.e();
        r41.b(r99.f11838i, r96, r101, r100, r98, r94.f11838i, r94.e(), 7);
    L398:
        if (r116 == true) goto L400;
        if (r213 == true) goto L400;
    L424:
        r10 = r210 + 1;
        r8 = r40;
        r14 = r211;
        r15 = r317;
    L400:
        if (r114 == null) goto L424;
        if (r114 == r115) goto L424;
        d[] r102 = r114.S;
        d r103 = r102[r16];
        if (r115 != null) goto L405;
        r115 = r114;
    L405:
        int r104 = r16 + 1;
        d r105 = r115.S[r104];
        d r106 = r103.f11835f;
        if (r106 == null) goto L408;
        p.h r107 = r106.f11838i;
    L409:
        d r108 = r105.f11835f;
        if (r108 == null) goto L412;
        p.h r109 = r108.f11838i;
    L413:
        if (r113 == r115) goto L418;
        d r124 = r113.S[r104].f11835f;
        if (r124 == null) goto L417;
        r19 = r124.f11838i;
    L417:
        p.h r125 = r19;
    L419:
        if (r114 != r115) goto L421;
        r105 = r102[r104];
    L421:
        if (r107 == null) goto L424;
        if (r125 == null) goto L424;
        int r126 = r103.e();
        int r127 = r115.S[r104].e();
        r41.b(r103.f11838i, r107, r126, 0.5f, r125, r105.f11838i, r127, 5);
        goto L424
    L418:
        r125 = r109;
        goto L419
    L412:
        r109 = null;
        goto L413
    L408:
        r107 = null;
        goto L409
    L269:
        r100 = r315.f11862h0;
    L271:
        r210 = r210;
    L397:
        r210 = r210;
        goto L398
    L260:
        r98 = null;
        goto L261
    L256:
        r96 = null;
    L272:
        r210 = r210;
        e r128 = r316;
        if (r116 == false) goto L334;
        if (r114 == null) goto L334;
        int r129 = r314.f11822j;
        if (r129 > 0) goto L278;
    L280:
        boolean r218 = false;
    L281:
        e r130 = r114;
        e r131 = r130;
    L282:
        if (r130 == null) goto L397;
        e r132 = r130.f11878p0[r43];
    L284:
        if (r132 == null) goto L289;
        if (r132.f11866j0 != 8) goto L289;
        r132 = r132.f11878p0[r43];
    L289:
        if (r132 != null) goto L294;
        if (r130 == r115) goto L294;
        e r319 = r128;
    L330:
        if (r130.f11866j0 != 8) goto L333;
        r130 = r131;
    L333:
        r131 = r130;
        r130 = r132;
        r128 = r319;
    L294:
        d[] r133 = r130.S;
        d r134 = r133[r16];
        p.h r135 = r134.f11838i;
        d r136 = r134.f11835f;
        if (r136 == null) goto L297;
        p.h r137 = r136.f11838i;
    L298:
        if (r131 == r130) goto L300;
        d r138 = r131.S[r16 + 1];
    L303:
        r137 = r138.f11838i;
    L305:
        int r139 = r134.e();
        int r140 = r16 + 1;
        int r219 = r133[r140].e();
        if (r132 == null) goto L308;
        d r141 = r132.S[r16];
        e r320 = r128;
    L310:
        p.h r142 = r141.f11838i;
    L312:
        p.h r143 = r133[r140].f11838i;
        if (r141 == null) goto L315;
        r219 = r141.e() + r219;
    L315:
        int r144 = r131.S[r140].e() + r139;
        if (r135 == null) goto L328;
        if (r137 == null) goto L328;
        if (r142 == null) goto L328;
        if (r143 == null) goto L328;
        if (r130 != r114) goto L322;
        r144 = r114.S[r16].e();
    L322:
        if (r130 != r115) goto L324;
        r219 = r115.S[r140].e();
    L324:
        if (r218 == false) goto L326;
        int r220 = 8;
    L327:
        r319 = r320;
        r132 = r132;
        int r145 = r219;
        r131 = r131;
        r41.b(r135, r137, r144, 0.5f, r142, r143, r145, r220);
        goto L330
    L326:
        r220 = 5;
    L328:
        r319 = r320;
        goto L330
    L308:
        r141 = r113.S[r140].f11835f;
        r320 = r128;
        if (r141 != null) goto L310;
        r142 = null;
        goto L312
    L300:
        if (r130 != r114) goto L305;
        r138 = r128.S[r16].f11835f;
        if (r138 != null) goto L303;
        r137 = null;
        goto L305
    L297:
        r137 = null;
        goto L298
    L278:
        if (r314.f11821i != r129) goto L280;
        r218 = true;
    L334:
        int r146 = 8;
        if (r213 == false) goto L397;
        if (r114 == null) goto L397;
        int r147 = r314.f11822j;
        if (r147 > 0) goto L340;
    L342:
        boolean r221 = false;
    L343:
        e r148 = r114;
        e r149 = r148;
    L344:
        if (r148 == null) goto L387;
        e r150 = r148.f11878p0[r43];
    L346:
        if (r150 == null) goto L350;
        if (r150.f11866j0 != r146) goto L350;
        r150 = r150.f11878p0[r43];
    L350:
        if (r148 == r114) goto L381;
        if (r148 == r115) goto L381;
        if (r150 == null) goto L381;
        if (r150 != r115) goto L355;
        e r151 = null;
    L356:
        d[] r152 = r148.S;
        d r153 = r152[r16];
        p.h r154 = r153.f11838i;
        int r155 = r16 + 1;
        p.h r156 = r149.S[r155].f11838i;
        int r157 = r153.e();
        int r158 = r152[r155].e();
        if (r151 == null) goto L362;
        d r159 = r151.S[r16];
        p.h r160 = r159.f11838i;
        d r161 = r159.f11835f;
        if (r161 == null) goto L361;
        p.h r162 = r161.f11838i;
    L367:
        if (r159 == null) goto L369;
        int r222 = r159.e() + r158;
    L370:
        int r163 = r149.S[r155].e() + r157;
        if (r221 == false) goto L373;
        int r223 = 8;
    L374:
        if (r154 == null) goto L379;
        if (r156 == null) goto L379;
        if (r160 == null) goto L379;
        if (r162 == null) goto L379;
        p.h r164 = r162;
        e r165 = r149;
        int r166 = r222;
        e r224 = r165;
        int r167 = 8;
        r41.b(r154, r156, r163, 0.5f, r160, r164, r166, r223);
    L380:
        r150 = r151;
    L383:
        if (r148.f11866j0 == r167) goto L385;
        r149 = r148;
    L386:
        r148 = r150;
        r146 = r167;
        goto L344
    L385:
        r149 = r224;
    L379:
        r224 = r149;
        r167 = 8;
        goto L380
    L373:
        r223 = 4;
        goto L374
    L369:
        r222 = r158;
        goto L370
    L361:
        r162 = null;
        goto L367
    L362:
        d r168 = r115.S[r16];
        if (r168 == null) goto L365;
        p.h r169 = r168.f11838i;
    L366:
        p.h r321 = r169;
        r162 = r152[r155].f11838i;
        r159 = r168;
        r160 = r321;
        goto L367
    L365:
        r169 = null;
        goto L366
    L355:
        r151 = r150;
    L381:
        r224 = r149;
        r167 = r146;
        goto L383
    L387:
        d r170 = r114.S[r16];
        d r171 = r128.S[r16].f11835f;
        int r172 = r16 + 1;
        d r173 = r115.S[r172];
        d r174 = r113.S[r172].f11835f;
        if (r171 == null) goto L394;
        if (r114 == r115) goto L391;
        r41.e(r170.f11838i, r171.f11838i, r170.e(), 5);
        goto L394
    L391:
        if (r174 == null) goto L394;
        r41.b(r170.f11838i, r171.f11838i, r170.e(), 0.5f, r173.f11838i, r174.f11838i, r173.e(), 5);
    L394:
        if (r174 == 0) goto L398;
        if (r114 == r115) goto L398;
        r41.e(r173.f11838i, r174.f11838i, -r173.e(), 5);
        goto L398
    L340:
        if (r314.f11821i != r147) goto L342;
        r221 = true;
        goto L343
    L110:
        boolean r175 = r212;
    L122:
        r116 = r175;
        r213 = r48;
        r50 = false;
        goto L123
    L106:
        r48 = false;
        goto L108
    L103:
        r212 = false;
        goto L104
    L111:
        int r176 = r44.f11872m0;
        if (r176 != 0) goto L114;
        boolean r177 = true;
    L115:
        if (r176 != 1) goto L117;
        boolean r178 = true;
    L118:
        if (r176 != 2) goto L121;
        r49 = r177;
        r48 = r178;
        goto L120
    L121:
        r175 = r177;
        r48 = r178;
        goto L122
    L117:
        r178 = false;
        goto L118
    L114:
        r177 = false;
        goto L115
    L98:
        r46 = false;
        goto L99
    L92:
        if (r42.contains(r18) == true) goto L95;
        r317 = r15;
        goto L424
    L84:
        if (r11.f11826n == false) goto L86;
        r38 = true;
        goto L87
    L78:
        if (r11.f11825m == false) goto L80;
        r11.f11817e = r110;
        goto L82
    L88:
        r210 = r10;
        r211 = r14;
        r39 = true;
        goto L89
    L425:
        return;
    L5:
        r14 = r8.C0;
        r15 = r8.D0;
        r16 = 2;
        goto L6
    }
}
