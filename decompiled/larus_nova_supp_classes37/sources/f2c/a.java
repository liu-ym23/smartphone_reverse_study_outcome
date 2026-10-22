package f2c;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import com.ss.android.lark.qrcode.zxing.EncodeHintType;
import com.ss.android.lark.qrcode.zxing.WriterException;
import com.ss.android.lark.qrcode.zxing.common.CharacterSetECI;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.Mode;
import d2c.b;
import g2c.c;
import g2c.d;
import g2c.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static b a(String r37, BarcodeFormat r38, int r39, int r40, Map r41) throws WriterException {
        int r2 = r39;
        int r3 = r40;
        if (r37.isEmpty() == true) goto L504;
        if (r38 != BarcodeFormat.QR_CODE) goto L502;
        if (r2 < 0) goto L500;
        if (r3 < 0) goto L500;
        ErrorCorrectionLevel r1 = ErrorCorrectionLevel.L;
        EncodeHintType r4 = EncodeHintType.ERROR_CORRECTION;
        EnumMap r5 = (EnumMap) r41;
        if (r5.containsKey(r4) == false) goto L11;
        r1 = ErrorCorrectionLevel.valueOf(r5.get(r4).toString());
    L11:
        EncodeHintType r6 = EncodeHintType.MARGIN;
        if (r5.containsKey(r6) == false) goto L14;
        int r7 = CastIntegerProtector.parseInt(r5.get(r6).toString());
    L15:
        EncodeHintType r8 = EncodeHintType.CHARACTER_SET;
        if (((EnumMap) r41).containsKey(r8) == false) goto L18;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
        String r10 = ((EnumMap) r41).get(r8).toString();
    L23:
        boolean r12 = "Shift_JIS".equals(r10);
        int[] r13 = c.a;
        char r14 = '`';
        if (r12 == true) goto L509;
    L46:
        int r11 = 0;
        boolean r15 = false;
        boolean r16 = false;
    L48:
        if (r11 >= r37.length()) goto L62;
        char r17 = r37.charAt(r11);
        if (r17 >= '0') goto L52;
    L54:
        if (r17 >= '`') goto L56;
        int r18 = r13[r17];
    L58:
        if (r18 == (-1)) goto L61;
        r15 = true;
    L60:
        r11 = r11 + 1;
        goto L48
    L61:
        Mode r19 = Mode.BYTE;
    L67:
        d2c.a r20 = new d2c.a();
        if (r19 != Mode.BYTE) goto L75;
        if (r9 == false) goto L71;
    L72:
        CharacterSetECI r21 = CharacterSetECI.getCharacterSetECIByName(r10);
        if (r21 == null) goto L75;
        r20.b(Mode.ECI.getBits(), 4);
        r20.b(r21.getValue(), 8);
        goto L75
    L71:
        if ("ISO-8859-1".equals(r10) == false) goto L72;
    L75:
        EncodeHintType r22 = EncodeHintType.GS1_FORMAT;
        if (((EnumMap) r41).containsKey(r22) == false) goto L78;
        boolean r23 = true;
    L79:
        if (r23 == true) goto L81;
    L83:
        int r24 = 4;
    L84:
        r20.b(r19.getBits(), r24);
        d2c.a r25 = new d2c.a();
        int r26 = c.a.a[r19.ordinal()];
        if (r26 == 1) goto L146;
        if (r26 != 2) goto L88;
        int r27 = r37.length();
        int r28 = 0;
    L124:
        if (r28 >= r27) goto L155;
        char r110 = r37.charAt(r28);
        if (r110 >= r14) goto L128;
        int r111 = r13[r110];
    L130:
        if (r111 == (-1)) goto L145;
        int r112 = r28 + 1;
        if (r112 >= r27) goto L142;
        char r113 = r37.charAt(r112);
        if (r113 >= r14) goto L136;
        int r114 = r13[r113];
    L138:
        if (r114 == (-1)) goto L141;
        r25.b((r111 * 45) + r114, 11);
        r28 = r28 + 2;
    L143:
        r14 = '`';
        goto L124
    L141:
        throw new WriterException();
    L136:
        r114 = -1;
        goto L138
    L142:
        r25.b(r111, 6);
        r28 = r112;
        goto L143
    L145:
        throw new WriterException();
    L128:
        r111 = -1;
    L155:
        EncodeHintType r29 = EncodeHintType.QR_VERSION;
        EnumMap r30 = (EnumMap) r41;
        if (r30.containsKey(r29) == false) goto L168;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r31 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(CastIntegerProtector.parseInt(r30.get(r29).toString()));
        int r32 = (r20.b + r19.getCharacterCountBits(r31)) + r25.b;
        int r115 = r31.c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r116 = r31.b[r1.ordinal()];
        int r117 = r116.a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C0122a[] r118 = r116.b;
        int r119 = r118.length;
        int r120 = 0;
        int r210 = 0;
    L158:
        if (r120 >= r119) goto L161;
        r210 = r210 + r118[r120].a;
        r120 = r120 + 1;
        goto L158
    L161:
        if ((r115 - (r117 * r210)) < ((r32 + 7) / 8)) goto L163;
        boolean r33 = true;
    L164:
        if (r33 == false) goto L167;
    L190:
        d2c.a r0 = new d2c.a();
        int r34 = r20.b;
        r0.c(r0.b + r34);
        int r121 = 0;
    L191:
        if (r121 >= r34) goto L194;
        r0.a(r20.d(r121));
        r121 = r121 + 1;
        goto L191
    L194:
        if (r19 != Mode.BYTE) goto L196;
        int r35 = (r25.b + 7) / 8;
    L197:
        int r36 = r19.getCharacterCountBits(r31);
        int r122 = 1 << r36;
        if (r35 >= r122) goto L492;
        r0.b(r35, r36);
        int r42 = r25.b;
        r0.c(r0.b + r42);
        int r43 = 0;
    L200:
        if (r43 >= r42) goto L202;
        r0.a(r25.d(r43));
        r43 = r43 + 1;
        goto L200
    L202:
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r44 = r31.b[r1.ordinal()];
        int r45 = r31.c;
        int r46 = r44.a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C0122a[] r47 = r44.b;
        int r123 = r47.length;
        int r124 = 0;
        int r125 = 0;
    L203:
        if (r124 >= r123) goto L205;
        r125 = r125 + r47[r124].a;
        r124 = r124 + 1;
        goto L203
    L205:
        int r48 = r45 - (r46 * r125);
        int r49 = r48 * 8;
        if (r0.b > r49) goto L490;
        int r50 = 0;
    L209:
        if (r50 >= 4) goto L213;
        if (r0.b >= r49) goto L213;
        r0.a(false);
        r50 = r50 + 1;
    L213:
        boolean r126 = false;
        int r51 = r0.b & 7;
        if (r51 <= 0) goto L217;
    L215:
        if (r51 >= 8) goto L217;
        r0.a(r126);
        r51 = r51 + 1;
        r126 = false;
    L217:
        int r52 = r48 - ((r0.b + 7) / 8);
        int r127 = 0;
    L218:
        if (r127 >= r52) goto L225;
        if ((r127 & 1) != 0) goto L222;
        int r128 = 236;
    L223:
        r0.b(r128, 8);
        r127 = r127 + 1;
        goto L218
    L222:
        r128 = 17;
        goto L223
    L225:
        if (r0.b != r49) goto L488;
        int r53 = r31.c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C0122a[] r54 = r44.b;
        int r55 = r54.length;
        int r129 = 0;
        int r130 = 0;
    L227:
        if (r129 >= r55) goto L230;
        r130 = r130 + r54[r129].a;
        r129 = r129 + 1;
        goto L227
    L230:
        if (((r0.b + 7) / 8) != r48) goto L486;
        ArrayList r56 = new ArrayList(r130);
        int r57 = 0;
        int r131 = 0;
        int r132 = 0;
        int r133 = 0;
    L232:
        if (r57 >= r130) goto L327;
        int[] r134 = new int[1];
        int[] r58 = new int[1];
        if (r57 >= r130) goto L326;
        int r135 = r53 % r130;
        int r59 = r130 - r135;
        int r211 = r53 / r130;
        int r212 = r211 + 1;
        int r213 = r48 / r130;
        int r214 = r213 + 1;
        int r215 = r7;
        int r60 = r211 - r213;
        ErrorCorrectionLevel r216 = r1;
        int r61 = r212 - r214;
        if (r60 != r61) goto L324;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r217 = r31;
        if (r130 != (r59 + r135)) goto L322;
        if (r53 != (((r213 + r60) * r59) + ((r214 + r61) * r135))) goto L320;
        if (r57 >= r59) goto L243;
        char r62 = 0;
        r134[0] = r213;
        r58[0] = r60;
    L244:
        int r63 = r134[r62];
        byte[] r64 = new byte[r63];
        int r65 = r133 * 8;
        int r66 = 0;
    L245:
        if (r66 >= r63) goto L253;
        int r218 = r53;
        int r410 = r130;
        int r67 = 8;
        int r136 = 0;
        int r137 = r65;
        int r68 = 0;
    L247:
        if (r68 >= r67) goto L252;
        if (r0.d(r137) == false) goto L251;
        r136 = (1 << (7 - r68)) | r136;
    L251:
        r137 = r137 + 1;
        r68 = r68 + 1;
        r67 = 8;
        goto L247
    L252:
        r64[r66 + 0] = (byte) r136;
        r66 = r66 + 1;
        r65 = r137;
        r53 = r218;
        r130 = r410;
        goto L245
    L253:
        int r219 = r53;
        int r411 = r130;
        int r69 = r58[0];
        int r70 = r63 + r69;
        int[] r71 = new int[r70];
        int r72 = 0;
    L254:
        if (r72 >= r63) goto L256;
        r71[r72] = r64[r72] & 255;
        r72 = r72 + 1;
        goto L254
    L256:
        e2c.c r73 = new e2c.c(e2c.a.g);
        if (r69 == 0) goto L318;
        int r74 = r70 - r69;
        if (r74 <= 0) goto L316;
        if (r69 < ((ArrayList) r73.b).size()) goto L283;
        List<e2c.b> r138 = r73.b;
        e2c.b r75 = (e2c.b) ListProtector.get(r138, ((ArrayList) r138).size() - 1);
        int r139 = ((ArrayList) r73.b).size();
    L263:
        if (r139 > r69) goto L283;
        int r220 = r48;
        int r221 = r57;
        e2c.a r76 = r73.a;
        int[] r222 = r134;
        int r223 = r133;
        int r224 = r131;
        e2c.b r77 = new e2c.b(r76, new int[]{1, r76.a[(r139 - 1) + r76.f]});
        if (r75.a.equals(r76) == false) goto L281;
        if (r75.b() == false) goto L269;
    L278:
        ArrayList r310 = r56;
        r75 = r75.a.c;
    L279:
        ((ArrayList) r73.b).add(r75);
        r139 = r139 + 1;
        r48 = r220;
        r57 = r221;
        r133 = r223;
        r134 = r222;
        r131 = r224;
        r132 = r132;
        r56 = r310;
        goto L263
    L269:
        if (r77.b() == true) goto L278;
        int[] r78 = r75.b;
        int r140 = r78.length;
        int[] r79 = r77.b;
        int r141 = r79.length;
        int[] r142 = new int[(r140 + r141) - 1];
        int r143 = 0;
    L272:
        if (r143 >= r140) goto L277;
        int r311 = r140;
        int r144 = r78[r143];
        int[] r312 = r78;
        int r80 = 0;
    L274:
        if (r80 >= r141) goto L276;
        int r313 = r143 + r80;
        r142[r313] = r75.a.a(r144, r79[r80]) ^ r142[r313];
        r80 = r80 + 1;
        r141 = r141;
        r56 = r56;
        goto L274
    L276:
        r143 = r143 + 1;
        r140 = r311;
        r78 = r312;
        goto L272
    L277:
        r310 = r56;
        r75 = new e2c.b(r75.a, r142);
        goto L279
    L281:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    L283:
        ArrayList r314 = r56;
        int r225 = r48;
        int r226 = r57;
        int r227 = r131;
        int[] r228 = r134;
        int r315 = r132;
        int r229 = r133;
        e2c.b r81 = (e2c.b) ListProtector.get(r73.b, r69);
        int[] r82 = new int[r74];
        System.arraycopy(r71, 0, r82, 0, r74);
        e2c.b r83 = new e2c.b(r73.a, r82).c(r69, 1);
        if (r83.a.equals(r81.a) == false) goto L314;
        if (r81.b() == true) goto L312;
        e2c.a r84 = r83.a;
        e2c.b r85 = r84.c;
        int[] r86 = r81.b;
        int r145 = -1;
        int r87 = r86[(r86.length - 1) - (r86.length - 1)];
        if (r87 == 0) goto L309;
        int r88 = r84.a[(r84.d - r84.b[r87]) - 1];
        e2c.b r89 = r83;
    L291:
        if ((r89.b.length + r145) < (r81.b.length + r145)) goto L302;
        if (r89.b() == true) goto L302;
        int[] r146 = r89.b;
        int r147 = (r146.length + r145) - (r81.b.length + r145);
        int r148 = r83.a.a(r146[(r146.length + r145) - (r146.length + r145)], r88);
        e2c.b r149 = r81.c(r147, r148);
        e2c.a r150 = r83.a;
        r150.getClass();
        if (r147 < 0) goto L301;
        if (r148 != 0) goto L298;
        e2c.b r151 = r150.c;
    L299:
        r85 = r85.a(r151);
        r89 = r89.a(r149);
        r145 = -1;
        goto L291
    L298:
        int[] r152 = new int[r147 + 1];
        r152[0] = r148;
        r151 = new e2c.b(r150, r152);
        goto L299
    L301:
        throw new IllegalArgumentException();
    L302:
        int[] r90 = r89.b;
        int r91 = r69 - r90.length;
        int r92 = 0;
    L303:
        if (r92 >= r91) goto L305;
        r71[r74 + r92] = 0;
        r92 = r92 + 1;
        goto L303
    L305:
        System.arraycopy(r90, 0, r71, r74 + r91, r90.length);
        byte[] r93 = new byte[r69];
        int r94 = 0;
    L306:
        if (r94 >= r69) goto L308;
        r93[r94] = (byte) r71[r63 + r94];
        r94 = r94 + 1;
        goto L306
    L308:
        r314.add(new g2c.a(r64, r93));
        r132 = Math.max(r315, r63);
        r131 = Math.max(r227, r69);
        r133 = r229 + r228[0];
        r57 = r226 + 1;
        r130 = r411;
        r56 = r314;
        r1 = r216;
        r31 = r217;
        r53 = r219;
        r48 = r225;
        r7 = r215;
        r0 = r0;
        goto L232
    L309:
        r84.getClass();
        throw new ArithmeticException();
    L312:
        throw new IllegalArgumentException("Divide by 0");
    L314:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    L316:
        throw new IllegalArgumentException("No data bytes provided");
    L318:
        throw new IllegalArgumentException("No error correction bytes");
    L243:
        r62 = 0;
        r134[0] = r214;
        r58[0] = r61;
        goto L244
    L320:
        throw new WriterException("Total bytes mismatch");
    L322:
        throw new WriterException("RS blocks mismatch");
    L324:
        throw new WriterException("EC bytes mismatch");
    L326:
        throw new WriterException("Block ID too large");
    L327:
        ErrorCorrectionLevel r230 = r1;
        int r231 = r7;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r232 = r31;
        ArrayList r95 = r56;
        int r233 = r53;
        int r96 = r131;
        int r97 = r132;
        if (r48 != r133) goto L484;
        d2c.a r98 = new d2c.a();
        int r99 = 0;
    L330:
        if (r99 >= r97) goto L338;
        Iterator r100 = r95.iterator();
    L333:
        if (r100.hasNext() == false) goto L337;
        byte[] r101 = ((g2c.a) r100.next()).a;
        if (r99 >= r101.length) goto L333;
        r98.b(r101[r99], 8);
        goto L333
    L337:
        r99 = r99 + 1;
        goto L330
    L338:
        int r102 = 0;
    L339:
        if (r102 >= r96) goto L347;
        Iterator r103 = r95.iterator();
    L342:
        if (r103.hasNext() == false) goto L346;
        byte[] r104 = ((g2c.a) r103.next()).b;
        if (r102 >= r104.length) goto L342;
        r98.b(r104[r102], 8);
        goto L342
    L346:
        r102 = r102 + 1;
        goto L339
    L347:
        int r105 = 8;
        if (r233 != ((r98.b + 7) / 8)) goto L482;
        int r106 = (r232.a * 4) + 17;
        g2c.b r107 = new g2c.b(r106, r106);
        int r108 = Integer.MAX_VALUE;
        int r153 = 0;
        int r154 = -1;
    L350:
        if (r153 >= r105) goto L452;
        ErrorCorrectionLevel r109 = r230;
        e.a(r98, r109, r232, r153, r107);
        int r155 = d.a(r107, true) + d.a(r107, false);
        byte[][] r156 = r107.a;
        int r157 = r107.b;
        int r158 = r107.c;
        int r159 = 0;
        int r160 = 0;
    L353:
        if (r159 >= (r158 - 1)) goto L366;
        byte[] r161 = r156[r159];
        int r162 = r158;
        int r163 = r160;
        int r164 = 0;
    L356:
        if (r164 >= (r157 - 1)) goto L365;
        byte r165 = r161[r164];
        int r166 = r164 + 1;
        if (r165 != r161[r166]) goto L364;
        byte[] r167 = r156[r159 + 1];
        if (r165 != r167[r164]) goto L364;
        if (r165 != r167[r166]) goto L364;
        r163 = r163 + 1;
    L364:
        r164 = r166;
        goto L356
    L365:
        r159 = r159 + 1;
        r160 = r163;
        r158 = r162;
        goto L353
    L366:
        int r168 = r155 + (r160 * 3);
        byte[][] r169 = r107.a;
        int r170 = r107.b;
        int r171 = r107.c;
        int r172 = 0;
        int r173 = 0;
    L367:
        if (r172 >= r171) goto L439;
        int r174 = r173;
        int r175 = 0;
    L369:
        if (r175 >= r170) goto L438;
        byte[] r176 = r169[r172];
        int r177 = r175 + 6;
        if (r177 >= r170) goto L403;
        int r178 = r170;
        ErrorCorrectionLevel r234 = r109;
        byte r179 = 1;
        if (r176[r175] == 1) goto L375;
    L404:
        int r180 = r172 + 6;
        if (r180 >= r171) goto L437;
        byte r181 = 1;
        if (r169[r172][r175] != 1) goto L437;
        if (r169[r172 + 1][r175] != 0) goto L437;
        if (r169[r172 + 2][r175] != 1) goto L437;
        if (r169[r172 + 3][r175] != 1) goto L437;
        if (r169[r172 + 4][r175] != 1) goto L437;
        if (r169[r172 + 5][r175] != 0) goto L437;
        if (r169[r180][r175] != 1) goto L437;
        int r182 = Math.max(r172 - 4, 0);
        int r183 = Math.min(r172, r169.length);
    L421:
        if (r182 >= r183) goto L426;
        if (r169[r182][r175] == r181) goto L424;
        r182 = r182 + 1;
        r181 = 1;
        goto L421
    L424:
        boolean r184 = false;
    L427:
        if (r184 == true) goto L436;
        int r185 = Math.max(r172 + 7, 0);
        int r186 = Math.min(r172 + 11, r169.length);
    L429:
        if (r185 >= r186) goto L434;
        if (r169[r185][r175] == 1) goto L432;
        r185 = r185 + 1;
        goto L429
    L432:
        boolean r187 = false;
    L435:
        if (r187 == false) goto L437;
    L434:
        r187 = true;
    L436:
        r174 = r174 + 1;
        goto L437
    L426:
        r184 = true;
    L437:
        r175 = r175 + 1;
        r170 = r178;
        r109 = r234;
        goto L369
    L375:
        if (r176[r175 + 1] != 0) goto L404;
        if (r176[r175 + 2] != 1) goto L404;
        if (r176[r175 + 3] != 1) goto L404;
        if (r176[r175 + 4] != 1) goto L404;
        if (r176[r175 + 5] != 0) goto L404;
        if (r176[r177] != 1) goto L404;
        int r188 = Math.max(r175 - 4, 0);
        int r189 = Math.min(r175, r176.length);
    L387:
        if (r188 >= r189) goto L392;
        int r316 = r189;
        if (r176[r188] == r179) goto L390;
        r188 = r188 + 1;
        r189 = r316;
        r179 = 1;
        goto L387
    L390:
        boolean r190 = false;
    L393:
        if (r190 == true) goto L402;
        int r191 = Math.max(r175 + 7, 0);
        int r192 = Math.min(r175 + 11, r176.length);
    L395:
        if (r191 >= r192) goto L400;
        int r317 = r192;
        if (r176[r191] == 1) goto L398;
        r191 = r191 + 1;
        r192 = r317;
        goto L395
    L398:
        boolean r193 = false;
    L401:
        if (r193 == false) goto L404;
    L400:
        r193 = true;
    L402:
        r174 = r174 + 1;
        goto L404
    L392:
        r190 = true;
        goto L393
    L403:
        r234 = r109;
        r178 = r170;
        goto L404
    L438:
        r172 = r172 + 1;
        r173 = r174;
        goto L367
    L439:
        r230 = r109;
        int r194 = r168 + (r173 * 40);
        byte[][] r195 = r107.a;
        int r196 = r107.b;
        int r197 = r107.c;
        int r198 = 0;
        int r199 = 0;
    L440:
        if (r198 >= r197) goto L448;
        byte[] r1100 = r195[r198];
        int r1101 = 0;
    L442:
        if (r1101 >= r196) goto L447;
        if (r1100[r1101] != 1) goto L446;
        r199 = r199 + 1;
    L446:
        r1101 = r1101 + 1;
        goto L442
    L447:
        r198 = r198 + 1;
        goto L440
    L448:
        int r200 = r107.c * r107.b;
        int r201 = r194 + (((Math.abs((r199 * 2) - r200) * 10) / r200) * 10);
        if (r201 >= r108) goto L451;
        r108 = r201;
        r154 = r153;
    L451:
        r153 = r153 + 1;
        r105 = 8;
        goto L350
    L452:
        e.a(r98, r230, r232, r154, r107);
        int r202 = r107.b;
        int r203 = r107.c;
        int r204 = r231 * 2;
        int r205 = r202 + r204;
        int r206 = r204 + r203;
        int r207 = Math.max(r39, r205);
        int r208 = Math.max(r40, r206);
        int r209 = Math.min(r207 / r205, r208 / r206);
        int r235 = (r207 - (r202 * r209)) / 2;
        int r236 = (r208 - (r203 * r209)) / 2;
        b r237 = new b(r207, r208);
        int r1102 = 0;
    L453:
        if (r1102 >= r203) goto L480;
        int r238 = r235;
        int r239 = 0;
    L455:
        if (r239 >= r202) goto L479;
        if (r107.a(r239, r1102) != 1) goto L478;
        if (r236 < 0) goto L477;
        if (r238 < 0) goto L477;
        if (r209 < 1) goto L475;
        if (r209 < 1) goto L475;
        int r240 = r209 + r238;
        int r1103 = r209 + r236;
        if (r1103 > r237.b) goto L473;
        if (r240 > r237.a) goto L473;
        int r1104 = r236;
    L467:
        if (r1104 >= r1103) goto L478;
        int r1105 = r237.c * r1104;
        int r1106 = r238;
    L469:
        if (r1106 >= r240) goto L471;
        int[] r1107 = r237.d;
        int r1108 = (r1106 / 32) + r1105;
        r1107[r1108] = r1107[r1108] | (1 << (r1106 & 31));
        r1106 = r1106 + 1;
        goto L469
    L471:
        r1104 = r1104 + 1;
    L473:
        throw new IllegalArgumentException("The region must fit inside the matrix");
    L475:
        throw new IllegalArgumentException("Height and width must be at least 1");
    L477:
        throw new IllegalArgumentException("Left and top must be nonnegative");
    L478:
        r239 = r239 + 1;
        r238 = r238 + r209;
        goto L455
    L479:
        r1102 = r1102 + 1;
        r236 = r236 + r209;
        goto L453
    L480:
        return r237;
    L482:
        throw new WriterException("Interleaving error: " + r233 + " and " + ((r98.b + 7) / 8) + " differ.");
    L484:
        throw new WriterException("Data bytes does not match offset");
    L486:
        throw new WriterException("Number of bits and data bytes does not match");
    L488:
        throw new WriterException("Bits size does not equal capacity");
    L490:
        throw new WriterException("data bits cannot fit in the QR Code" + r0.b + " > " + r49);
    L492:
        throw new WriterException(r35 + " is bigger than " + (r122 - 1));
    L196:
        r35 = r37.length();
        goto L197
    L167:
        throw new WriterException("Data too big for requested version");
    L163:
        r33 = false;
        goto L164
    L168:
        int r241 = (r20.b + r19.getCharacterCountBits(com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(1))) + r25.b;
        int r1109 = 1;
    L170:
        if (r1109 > 40) goto L498;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r1110 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(r1109);
        int r1111 = r1110.c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r1112 = r1110.b[r1.ordinal()];
        int r1113 = r1112.a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C0122a[] r1114 = r1112.b;
        int r1115 = r1114.length;
        int r242 = 0;
        int r243 = 0;
    L172:
        if (r242 >= r1115) goto L175;
        r243 = r243 + r1114[r242].a;
        r242 = r242 + 1;
        r1115 = r1115;
        goto L172
    L175:
        if ((r1111 - (r1113 * r243)) < ((r241 + 7) / 8)) goto L177;
        boolean r244 = true;
    L178:
        if (r244 == true) goto L179;
        r1109 = r1109 + 1;
        r1 = r1;
        r2 = r2;
        r3 = r3;
        r7 = r7;
        goto L170
    L179:
        int r245 = (r20.b + r19.getCharacterCountBits(r1110)) + r25.b;
        int r246 = 40;
        int r1116 = 1;
    L180:
        if (r1116 > r246) goto L495;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r1117 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(r1116);
        int r1118 = r1117.c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r1119 = r1117.b[r1.ordinal()];
        int r1120 = r1119.a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C0122a[] r1121 = r1119.b;
        int r1122 = r1121.length;
        int r247 = 0;
        int r248 = 0;
    L182:
        if (r247 >= r1122) goto L184;
        r248 = r248 + r1121[r247].a;
        r247 = r247 + 1;
        r1117 = r1117;
        goto L182
    L184:
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r249 = r1117;
        if ((r1118 - (r1120 * r248)) < ((r245 + 7) / 8)) goto L187;
        boolean r250 = true;
    L188:
        if (r250 == true) goto L189;
        r1116 = r1116 + 1;
        r1 = r1;
        r2 = r2;
        r3 = r3;
        r7 = r7;
        r246 = 40;
        goto L180
    L189:
        r31 = r249;
        goto L190
    L187:
        r250 = false;
        goto L188
    L495:
        throw new WriterException("Data too big");
    L177:
        r244 = false;
        goto L178
    L498:
        throw new WriterException("Data too big");
    L88:
        if (r26 != 3) goto L90;
        byte[] r251 = r37.getBytes(r10);     // Catch: UnsupportedEncodingException -> L120
        int r252 = r251.length;
        int r1123 = 0;
    L118:
        if (r1123 >= r252) goto L155;
        r25.b(r251[r1123], 8);
        r1123 = r1123 + 1;
    L120:
        e = move-exception;
        throw new WriterException(e);
    L90:
        if (r26 != 4) goto L115;
        byte[] r253 = r37.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L111
        int r254 = r253.length;
        int r1124 = 0;
    L93:
        if (r1124 >= r254) goto L155;
        int r1125 = ((r253[r1124] & 255) << 8) | (r253[r1124 + 1] & 255);
        int r1126 = 33088;
        if (r1125 < 33088) goto L100;
        if (r1125 > 40956) goto L100;
    L104:
        int r1127 = r1125 - r1126;
    L107:
        if (r1127 == (-1)) goto L110;
        r25.b(((r1127 >> 8) * 192) + (r1127 & 255), 13);
        r1124 = r1124 + 2;
        goto L93
    L110:
        throw new WriterException("Invalid byte sequence");
    L100:
        if (r1125 >= 57408) goto L102;
    L105:
        r1127 = -1;
        goto L107
    L102:
        if (r1125 > 60351) goto L105;
        r1126 = 49472;
    L111:
        e = move-exception;
        throw new WriterException(e);
    L115:
        throw new WriterException("Invalid mode: " + r19);
    L146:
        int r255 = r37.length();
        int r256 = 0;
    L147:
        if (r256 >= r255) goto L155;
        int r1128 = r37.charAt(r256) - '0';
        int r1129 = r256 + 2;
        if (r1129 < r255) goto L150;
        r256 = r256 + 1;
        if (r256 < r255) goto L153;
        r25.b(r1128, 4);
        goto L147
    L153:
        r25.b((r1128 * 10) + (r37.charAt(r256) - '0'), 7);
        r256 = r1129;
        goto L147
    L150:
        r25.b(((r1128 * 100) + ((r37.charAt(r256 + 1) - '0') * 10)) + (r37.charAt(r1129) - '0'), 10);
        r256 = r256 + 3;
        goto L147
    L81:
        if (Boolean.valueOf(((EnumMap) r41).get(r22).toString()).booleanValue() == false) goto L83;
        r24 = 4;
        r20.b(Mode.FNC1_FIRST_POSITION.getBits(), 4);
        goto L84
    L78:
        r23 = false;
        goto L79
    L56:
        r18 = -1;
        goto L58
    L52:
        if (r17 > '9') goto L54;
        r16 = true;
        goto L60
    L62:
        if (r15 == false) goto L64;
        r19 = Mode.ALPHANUMERIC;
        goto L67
    L64:
        if (r16 == false) goto L66;
        r19 = Mode.NUMERIC;
        goto L67
    L66:
        r19 = Mode.BYTE;
        goto L67
    L509:
        byte[] r1130 = r37.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L42
        int r257 = r1130.length;
        if ((r257 % 2) != 0) goto L43;
        int r258 = 0;
    L30:
        if (r258 >= r257) goto L41;
        int r259 = r1130[r258] & 255;
        if (r259 < 129) goto L36;
        if (r259 > 159) goto L36;
    L40:
        r258 = r258 + 2;
    L36:
        if (r259 < 224) goto L43;
        if (r259 <= 235) goto L40;
    L41:
        boolean r260 = true;
    L44:
        if (r260 == false) goto L46;
        r19 = Mode.KANJI;
    L43:
        r260 = false;
        goto L44
    L22:
        r10 = "ISO-8859-1";
        goto L23
    L18:
        r9 = false;
        goto L20
    L14:
        r7 = 4;
    L500:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r2 + 'x' + r3);
    L502:
        throw new IllegalArgumentException("Can only encode QR_CODE, but got " + r38);
    L504:
        throw new IllegalArgumentException("Found empty contents");
    }
}
