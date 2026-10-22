package com.ctc.wstx.io;

import com.bytedance.rpc.internal.RpcUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static String a(String r16) {
        String r0 = r16;
        if (r0 != null) goto L5;
    L225:
        return r0;
    L5:
        if (r16.length() < 3) goto L225;
        boolean r1 = false;
        char r2 = r0.charAt(0);
        if (r2 == 'c') goto L10;
        if (r2 == 'C') goto L10;
    L15:
        if (r2 == 'A') goto L223;
        if (r2 == 'C') goto L213;
        if (r2 == 'E') goto L141;
        if (r2 == 'S') goto L138;
        if (r2 == 'U') goto L77;
        if (r2 == 'a') goto L223;
        if (r2 == 'c') goto L213;
        if (r2 == 'e') goto L141;
        if (r2 == 's') goto L138;
        if (r2 == 'u') goto L77;
        if (r2 == 'I') goto L45;
        if (r2 == 'J') goto L42;
        if (r2 == 'i') goto L45;
        if (r2 != 'j') goto L225;
    L42:
        if (com.ctc.wstx.util.i.a(r0, "JIS_Encoding") == false) goto L225;
        return "Shift_JIS";
    L45:
        if (com.ctc.wstx.util.i.a(r0, "ISO-8859-1") == false) goto L47;
    L75:
        return "ISO-8859-1";
    L47:
        if (com.ctc.wstx.util.i.a(r0, "ISO-Latin1") == true) goto L75;
        if (com.ctc.wstx.util.i.b(r0, "ISO-10646") == false) goto L73;
        String r3 = r0.substring(r0.indexOf("10646") + 5);
        if (com.ctc.wstx.util.i.a(r3, "UCS-Basic") == false) goto L55;
        return "US-ASCII";
    L55:
        if (com.ctc.wstx.util.i.a(r3, "Unicode-Latin1") == false) goto L58;
        return "ISO-8859-1";
    L58:
        if (com.ctc.wstx.util.i.a(r3, "UCS-2") == false) goto L61;
        return "UTF-16";
    L61:
        if (com.ctc.wstx.util.i.a(r3, "UCS-4") == false) goto L64;
        return "UTF-32";
    L64:
        if (com.ctc.wstx.util.i.a(r3, "UTF-1") == false) goto L67;
        return "US-ASCII";
    L67:
        if (com.ctc.wstx.util.i.a(r3, "J-1") == false) goto L70;
        return "US-ASCII";
    L70:
        if (com.ctc.wstx.util.i.a(r3, "US-ASCII") == false) goto L225;
        return "US-ASCII";
    L73:
        if (com.ctc.wstx.util.i.b(r0, "IBM") == false) goto L225;
        return r0;
    L77:
        if (r0.length() < 2) goto L225;
        char r4 = r0.charAt(1);
        if (r4 == 'C') goto L132;
        if (r4 == 'N') goto L121;
        if (r4 == 'c') goto L132;
        if (r4 == 'n') goto L121;
        if (r4 == 'S') goto L119;
        if (r4 == 'T') goto L95;
        if (r4 == 's') goto L119;
        if (r4 != 't') goto L225;
    L95:
        if (com.ctc.wstx.util.i.a(r0, RpcUtils.CHARSET_UTF8) == false) goto L98;
        return RpcUtils.CHARSET_UTF8;
    L98:
        if (com.ctc.wstx.util.i.a(r0, "UTF-16BE") == false) goto L101;
        return "UTF-16BE";
    L101:
        if (com.ctc.wstx.util.i.a(r0, "UTF-16LE") == false) goto L104;
        return "UTF-16LE";
    L104:
        if (com.ctc.wstx.util.i.a(r0, "UTF-16") == false) goto L107;
        return "UTF-16";
    L107:
        if (com.ctc.wstx.util.i.a(r0, "UTF-32BE") == false) goto L110;
        return "UTF-32BE";
    L110:
        if (com.ctc.wstx.util.i.a(r0, "UTF-32LE") == false) goto L113;
        return "UTF-32LE";
    L113:
        if (com.ctc.wstx.util.i.a(r0, "UTF-32") == false) goto L116;
        return "UTF-32";
    L116:
        if (com.ctc.wstx.util.i.a(r0, "UTF") == false) goto L225;
        return "UTF-16";
    L119:
        if (com.ctc.wstx.util.i.a(r0, "US-ASCII") == false) goto L225;
        return "US-ASCII";
    L121:
        if (r1 == false) goto L225;
        if (com.ctc.wstx.util.i.a(r0, "Unicode") == false) goto L126;
        return "UTF-16";
    L126:
        if (com.ctc.wstx.util.i.a(r0, "UnicodeAscii") == false) goto L129;
        return "ISO-8859-1";
    L129:
        if (com.ctc.wstx.util.i.a(r0, "UnicodeAscii") == false) goto L225;
        return "US-ASCII";
    L132:
        if (com.ctc.wstx.util.i.a(r0, "UCS-2") == false) goto L135;
        return "UTF-16";
    L135:
        if (com.ctc.wstx.util.i.a(r0, "UCS-4") == false) goto L225;
        return "UTF-32";
    L138:
        if (com.ctc.wstx.util.i.a(r0, "Shift_JIS") == false) goto L225;
        return "Shift_JIS";
    L141:
        if (r0.startsWith("EBCDIC-CP-") == false) goto L143;
    L144:
        String r5 = com.ctc.wstx.util.i.a(r0, true).substring(8);
        if (r5.equals("US") == false) goto L147;
    L211:
        return "IBM037";
    L147:
        if (r5.equals("CA") == true) goto L211;
        if (r5.equals(com.tom_roush.pdfbox.pdmodel.a.d.i.S) == true) goto L211;
        if (r5.equals("NL") == true) goto L211;
        if (r5.equals("DK") == false) goto L156;
        return "IBM277";
    L156:
        if (r5.equals("NO") == false) goto L159;
        return "IBM277";
    L159:
        if (r5.equals("FI") == false) goto L161;
        return "IBM278";
    L161:
        if (r5.equals("SE") == false) goto L164;
        return "IBM278";
    L164:
        if (r5.equals("ROECE") == false) goto L166;
        return "IBM870";
    L166:
        if (r5.equals("YU") == false) goto L169;
        return "IBM870";
    L169:
        if (r5.equals("IT") == false) goto L173;
        return "IBM280";
    L173:
        if (r5.equals("ES") == false) goto L177;
        return "IBM284";
    L177:
        if (r5.equals("GB") == false) goto L181;
        return "IBM285";
    L181:
        if (r5.equals("FR") == false) goto L185;
        return "IBM297";
    L185:
        if (r5.equals("AR1") == false) goto L189;
        return "IBM420";
    L189:
        if (r5.equals("AR2") == false) goto L193;
        return "IBM918";
    L193:
        if (r5.equals("HE") == false) goto L197;
        return "IBM424";
    L197:
        if (r5.equals("CH") == false) goto L201;
        return "IBM500";
    L201:
        if (r5.equals("IS") == false) goto L204;
        return "IBM871";
    L204:
        return "IBM037";
    L143:
        if (r0.startsWith("ebcdic-cp-") == false) goto L225;
    L213:
        if (com.ctc.wstx.util.i.b(r0, "cp") == false) goto L217;
        return "IBM" + com.ctc.wstx.util.i.a(r0, true).substring(2);
    L217:
        if (com.ctc.wstx.util.i.b(r0, "cs") == false) goto L225;
        if (com.ctc.wstx.util.i.b(r0, "csIBM") == false) goto L225;
        return com.ctc.wstx.util.i.a(r0, true).substring(2);
    L223:
        if (com.ctc.wstx.util.i.a(r0, "ASCII") == false) goto L225;
        return "US-ASCII";
    L10:
        char r9 = r0.charAt(1);
        if (r9 == 's') goto L13;
        if (r9 != 'S') goto L15;
    L13:
        r0 = r0.substring(2);
        r2 = r0.charAt(0);
        r1 = true;
        goto L15
    }
}
