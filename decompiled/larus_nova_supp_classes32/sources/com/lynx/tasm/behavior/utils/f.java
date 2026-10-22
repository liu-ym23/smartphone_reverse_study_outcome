package com.lynx.tasm.behavior.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {

    public static class a {
        public boolean a;
        public boolean b;
        public boolean c;

        public a() {
            this.a = false;
            this.b = false;
            this.c = false;
        }

        public final void a(StringBuilder r6, int r7) {
            if (r6.length() != 0) goto L5;
            return;
        L5:
            boolean r1 = true;
            if (Character.isHighSurrogate(r6.charAt(r6.length() - 1)) == false) goto L9;
            this.c = true;
            return;
        L9:
            int r0 = r6.length();
            if (this.c == false) goto L12;
            int r2 = 2;
        L13:
            int r3 = r0 - r2;
            int r4 = r6.codePointAt(r3);
            if (r7 != 1) goto L39;
            Character.UnicodeBlock r8 = Character.UnicodeBlock.of(r4);
            if (r8 != Character.UnicodeBlock.BASIC_LATIN) goto L18;
        L35:
            if (r1 == false) goto L37;
        L38:
            r6.delete(r3, r6.length());
            r6.append(8203);
            r6.appendCodePoint(r4);
            this.b = r1;
        L69:
            this.c = false;
            return;
        L37:
            if (this.b == false) goto L69;
        L18:
            if (r8 == Character.UnicodeBlock.LATIN_1_SUPPLEMENT) goto L35;
            if (r8 == Character.UnicodeBlock.LATIN_EXTENDED_A) goto L35;
            if (r8 == Character.UnicodeBlock.LATIN_EXTENDED_B) goto L35;
            if (r8 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L35;
            if (r8 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L35;
            if (r8 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L35;
            if (r8 == Character.UnicodeBlock.CURRENCY_SYMBOLS) goto L35;
            if (r8 == Character.UnicodeBlock.MATHEMATICAL_OPERATORS) goto L35;
            r1 = false;
            goto L35
        L39:
            if (r7 != 2) goto L69;
            Character.UnicodeBlock r9 = Character.UnicodeBlock.of(r4);
            if (r9 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L43;
        L62:
            boolean r10 = true;
        L63:
            if (r10 == true) goto L65;
            this.a = false;
            goto L69
        L65:
            if (this.a == false) goto L67;
            r6.delete(r3, r6.length());
            r6.append(8288);
            r6.appendCodePoint(r4);
            goto L69
        L67:
            this.a = true;
            goto L69
        L43:
            if (r9 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L62;
            if (r9 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) goto L62;
            if (r9 == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT) goto L62;
            if (r9 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L62;
            if (r9 == Character.UnicodeBlock.KATAKANA) goto L62;
            if (r9 == Character.UnicodeBlock.HIRAGANA) goto L62;
            if (r9 == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) goto L62;
            if (r9 == Character.UnicodeBlock.HANGUL_JAMO) goto L62;
            if (r9 == Character.UnicodeBlock.HANGUL_SYLLABLES) goto L62;
            r10 = false;
            goto L63
        L12:
            r2 = 1;
            goto L13
        }
    }

    public static String a(String r17, int r18) {
        a r2 = null;
        if (r17 != null) goto L5;
        return null;
    L5:
        char r3 = '&';
        if (r18 == 0) goto L8;
    L10:
        int r4 = r17.length();
        StringBuilder r5 = new StringBuilder(r4);
        if (r18 == 0) goto L13;
        r2 = new a();
    L13:
        int r7 = 0;
    L14:
        if (r7 >= r4) goto L304;
        byte r9 = 35;
        int r11 = -1;
        if (r17.charAt(r7) != r3) goto L40;
        int r8 = r7 + 1;
        if (r8 >= r4) goto L40;
        if (r17.charAt(r8) != '#') goto L40;
        int r10 = r7 + 2;
        int r12 = r10;
    L22:
        if (r12 >= r4) goto L29;
        if (r12 >= ((r10 + 10) + 1)) goto L29;
        if (r17.charAt(r12) == ';') goto L30;
        r12 = r12 + 1;
    L30:
        if (r12 != (-1)) goto L305;
        r5.append(r17.charAt(r7));
    L300:
        if (r18 == 0) goto L302;
        r2.a(r5, r18);
    L302:
        r7 = r7 + 1;
        r3 = '&';
        goto L14
    L305:
        if (r17.charAt(r10) != 'x') goto L35;
        int r13 = CastIntegerProtector.parseInt(r17.subSequence(r7 + 3, r12).toString(), 16);     // Catch: Exception -> L38
    L36:
        r5.appendCodePoint(r13);     // Catch: Exception -> L38
        r7 = r12;
        goto L300
    L35:
        r13 = CastIntegerProtector.parseInt(r17.subSequence(r10, r12).toString(), 10);     // Catch: Exception -> L38
    L38:
        r5.append(r17.charAt(r7));
    L29:
        r12 = -1;
    L40:
        if (r17.charAt(r7) != r3) goto L299;
        int r14 = r7 + 1;
        if (r14 >= r4) goto L299;
        int r15 = r14;
    L44:
        if (r15 >= r4) goto L60;
        if (r15 >= ((r7 + 7) + 1)) goto L60;
        char r6 = r17.charAt(r15);
        if (r6 == ';') goto L61;
        if (r6 < 'A') goto L55;
        if (r6 > 'Z') goto L55;
    L59:
        r15 = r15 + 1;
    L55:
        if (r6 < 'a') goto L60;
        if (r6 <= 'z') goto L59;
    L61:
        if (r15 != (-1)) goto L63;
        r5.append(r17.charAt(r7));
        goto L300
    L63:
        String r16 = r17.subSequence(r14, r15).toString();
        r16.getClass();
        switch(r16.hashCode()) {
            case -1419323836: goto L246;
            case -1368034367: goto L242;
            case -1339299958: goto L238;
            case -1220935388: goto L234;
            case -1196259461: goto L230;
            case -1190290628: goto L226;
            case -1093812015: goto L222;
            case -1074341375: goto L218;
            case -991722477: goto L214;
            case -922037109: goto L210;
            case -874702154: goto L206;
            case 3294: goto L202;
            case 3309: goto L198;
            case 3449: goto L194;
            case 3464: goto L190;
            case 96708: goto L186;
            case 107431: goto L182;
            case 113011: goto L178;
            case 121037: goto L174;
            case 3035411: goto L170;
            case 3059573: goto L166;
            case 3075965: goto L162;
            case 3117317: goto L158;
            case 3118278: goto L154;
            case 3354221: goto L150;
            case 3374865: goto L146;
            case 3482377: goto L142;
            case 3752377: goto L138;
            case 77382239: goto L134;
            case 92925156: goto L130;
            case 93596489: goto L126;
            case 94431411: goto L122;
            case 96619240: goto L118;
            case 97692206: goto L114;
            case 100313324: goto L110;
            case 102831699: goto L107;
            case 103278564: goto L103;
            case 103739775: goto L99;
            case 104663296: goto L95;
            case 105832675: goto L91;
            case 106934911: goto L87;
            case 108372825: goto L83;
            case 108819690: goto L79;
            case 109236764: goto L75;
            case 110364486: goto L71;
            case 2039534506: goto L67;
            default: goto L249;
        };
    L249:
        r9 = -1;
    L250:
        switch(r9) {
            case 0: goto L296;
            case 1: goto L295;
            case 2: goto L294;
            case 3: goto L293;
            case 4: goto L292;
            case 5: goto L291;
            case 6: goto L290;
            case 7: goto L289;
            case 8: goto L288;
            case 9: goto L287;
            case 10: goto L286;
            case 11: goto L285;
            case 12: goto L284;
            case 13: goto L283;
            case 14: goto L282;
            case 15: goto L281;
            case 16: goto L280;
            case 17: goto L279;
            case 18: goto L278;
            case 19: goto L277;
            case 20: goto L276;
            case 21: goto L275;
            case 22: goto L274;
            case 23: goto L273;
            case 24: goto L293;
            case 25: goto L272;
            case 26: goto L271;
            case 27: goto L270;
            case 28: goto L269;
            case 29: goto L268;
            case 30: goto L267;
            case 31: goto L266;
            case 32: goto L265;
            case 33: goto L264;
            case 34: goto L263;
            case 35: goto L262;
            case 36: goto L261;
            case 37: goto L260;
            case 38: goto L259;
            case 39: goto L258;
            case 40: goto L257;
            case 41: goto L256;
            case 42: goto L255;
            case 43: goto L254;
            case 44: goto L253;
            case 45: goto L252;
            default: goto L297;
        };
    L252:
        r11 = 8225;
        goto L297
    L253:
        r11 = SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_ENDED;
        goto L297
    L254:
        r11 = 8218;
        goto L297
    L255:
        r11 = 8217;
        goto L297
    L256:
        r11 = 8221;
        goto L297
    L257:
        r11 = 8242;
        goto L297
    L258:
        r11 = 8254;
        goto L297
    L259:
        r11 = 8211;
        goto L297
    L260:
        r11 = 8212;
        goto L297
    L261:
        r11 = 8216;
        goto L297
    L262:
        r11 = 8220;
        goto L297
    L263:
        r11 = 299;
        goto L297
    L264:
        r11 = 8260;
        goto L297
    L265:
        r11 = 275;
        goto L297
    L266:
        r11 = 711;
        goto L297
    L267:
        r11 = 8222;
        goto L297
    L268:
        r11 = 257;
        goto L297
    L269:
        r11 = 8243;
        goto L297
    L270:
        r11 = 8204;
        goto L297
    L271:
        r11 = 34;
        goto L297
    L272:
        r11 = 160;
        goto L297
    L273:
        r11 = 8194;
        goto L297
    L274:
        r11 = 8195;
        goto L297
    L275:
        r11 = 8595;
        goto L297
    L276:
        r11 = 169;
        goto L297
    L277:
        r11 = 8226;
        goto L297
    L278:
        r11 = 8205;
        goto L297
    L279:
        r11 = 8207;
        goto L297
    L280:
        r11 = 8206;
        goto L297
    L281:
        r11 = 38;
        goto L297
    L282:
        r11 = 60;
        goto L297
    L283:
        r11 = 8804;
        goto L297
    L284:
        r11 = 62;
        goto L297
    L285:
        r11 = 8805;
        goto L297
    L286:
        r11 = 8201;
        goto L297
    L287:
        r11 = 8250;
        goto L297
    L288:
        r11 = 8240;
        goto L297
    L289:
        r11 = 183;
        goto L297
    L290:
        r11 = 8249;
        goto L297
    L291:
        r11 = 236;
        goto L297
    L292:
        r11 = 237;
        goto L297
    L293:
        r11 = 8230;
        goto L297
    L294:
        r11 = 8224;
        goto L297
    L295:
        r11 = 263;
        goto L297
    L296:
        r11 = 224;
    L297:
        if (r11 <= 0) goto L300;
        r5.append((char) r11);
        r7 = r15;
        goto L300
    L67:
        if (r16.equals("Dagger") == false) goto L249;
        r9 = 45;
        goto L250
    L71:
        if (r16.equals("times") == false) goto L249;
        r9 = 44;
        goto L250
    L75:
        if (r16.equals("sbquo") == false) goto L249;
        r9 = 43;
        goto L250
    L79:
        if (r16.equals("rsquo") == false) goto L249;
        r9 = 42;
        goto L250
    L83:
        if (r16.equals("rdquo") == false) goto L249;
        r9 = 41;
        goto L250
    L87:
        if (r16.equals("prime") == false) goto L249;
        r9 = 40;
        goto L250
    L91:
        if (r16.equals("oline") == false) goto L249;
        r9 = 39;
        goto L250
    L95:
        if (r16.equals("ndash") == false) goto L249;
        r9 = 38;
        goto L250
    L99:
        if (r16.equals("mdash") == false) goto L249;
        r9 = 37;
        goto L250
    L103:
        if (r16.equals("lsquo") == false) goto L249;
        r9 = 36;
        goto L250
    L107:
        if (r16.equals("ldquo") == true) goto L250;
    L110:
        if (r16.equals("imacr") == false) goto L249;
        r9 = 34;
        goto L250
    L114:
        if (r16.equals("frasl") == false) goto L249;
        r9 = 33;
        goto L250
    L118:
        if (r16.equals("emacr") == false) goto L249;
        r9 = 32;
        goto L250
    L122:
        if (r16.equals("caron") == false) goto L249;
        r9 = 31;
        goto L250
    L126:
        if (r16.equals("bdquo") == false) goto L249;
        r9 = 30;
        goto L250
    L130:
        if (r16.equals("amacr") == false) goto L249;
        r9 = 29;
        goto L250
    L134:
        if (r16.equals("Prime") == false) goto L249;
        r9 = 28;
        goto L250
    L138:
        if (r16.equals("zwnj") == false) goto L249;
        r9 = 27;
        goto L250
    L142:
        if (r16.equals("quot") == false) goto L249;
        r9 = 26;
        goto L250
    L146:
        if (r16.equals("nbsp") == false) goto L249;
        r9 = 25;
        goto L250
    L150:
        if (r16.equals("mldr") == false) goto L249;
        r9 = 24;
        goto L250
    L154:
        if (r16.equals("ensp") == false) goto L249;
        r9 = 23;
        goto L250
    L158:
        if (r16.equals("emsp") == false) goto L249;
        r9 = 22;
        goto L250
    L162:
        if (r16.equals("darr") == false) goto L249;
        r9 = 21;
        goto L250
    L166:
        if (r16.equals("copy") == false) goto L249;
        r9 = 20;
        goto L250
    L170:
        if (r16.equals("bull") == false) goto L249;
        r9 = 19;
        goto L250
    L174:
        if (r16.equals("zwj") == false) goto L249;
        r9 = 18;
        goto L250
    L178:
        if (r16.equals("rlm") == false) goto L249;
        r9 = 17;
        goto L250
    L182:
        if (r16.equals("lrm") == false) goto L249;
        r9 = 16;
        goto L250
    L186:
        if (r16.equals("amp") == false) goto L249;
        r9 = 15;
        goto L250
    L190:
        if (r16.equals("lt") == false) goto L249;
        r9 = 14;
        goto L250
    L194:
        if (r16.equals("le") == false) goto L249;
        r9 = 13;
        goto L250
    L198:
        if (r16.equals("gt") == false) goto L249;
        r9 = 12;
        goto L250
    L202:
        if (r16.equals("ge") == false) goto L249;
        r9 = 11;
        goto L250
    L206:
        if (r16.equals("thinsp") == false) goto L249;
        r9 = 10;
        goto L250
    L210:
        if (r16.equals("rsaquo") == false) goto L249;
        r9 = 9;
        goto L250
    L214:
        if (r16.equals("permil") == false) goto L249;
        r9 = 8;
        goto L250
    L218:
        if (r16.equals("middot") == false) goto L249;
        r9 = 7;
        goto L250
    L222:
        if (r16.equals("lsaquo") == false) goto L249;
        r9 = 6;
        goto L250
    L226:
        if (r16.equals("igrave") == false) goto L249;
        r9 = 5;
        goto L250
    L230:
        if (r16.equals("iacute") == false) goto L249;
        r9 = 4;
        goto L250
    L234:
        if (r16.equals("hellip") == false) goto L249;
        r9 = 3;
        goto L250
    L238:
        if (r16.equals("dagger") == false) goto L249;
        r9 = 2;
        goto L250
    L242:
        if (r16.equals("cacute") == false) goto L249;
        r9 = 1;
        goto L250
    L246:
        if (r16.equals("agrave") == false) goto L249;
        r9 = 0;
    L60:
        r15 = -1;
    L299:
        r5.append(r17.charAt(r7));
        goto L300
    L304:
        return r5.toString();
    L8:
        if (r17.indexOf(38) >= 0) goto L10;
        return r17;
    }
}
