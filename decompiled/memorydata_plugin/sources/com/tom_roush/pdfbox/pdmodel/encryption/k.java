package com.tom_roush.pdfbox.pdmodel.encryption;

import java.nio.CharBuffer;
import java.text.Normalizer;

/* JADX INFO: loaded from: classes6.dex */
class k {
    static String a(String r1) {
        return a(r1, true);
    }

    private static String a(String r9, boolean r10) {
        char[] r0 = r9.toCharArray();
        int r2 = 0;
    L4:
        if (r2 >= r9.length()) goto L9;
        if (b(r9.charAt(r2)) == false) goto L8;
        r0[r2] = ' ';
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r3 >= r9.length()) goto L16;
        char r5 = r0[r3];
        if (c(r5) == true) goto L15;
        r0[r4] = r5;
        r4 = r4 + 1;
    L15:
        r3 = r3 + 1;
        goto L11
    L16:
        String r11 = Normalizer.normalize(CharBuffer.wrap(r0, 0, r4), Normalizer.Form.NFKC);
        int r1 = 0;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
    L18:
        if (r1 >= r11.length()) goto L54;
        int r12 = r11.codePointAt(r1);
        if (a(r12) == true) goto L53;
        byte r13 = Character.getDirectionality(r12);
        boolean r14 = true;
        if (r13 != 1) goto L24;
    L27:
        boolean r15 = true;
    L28:
        r6 = r6 | r15;
        if (r13 != 0) goto L31;
        boolean r16 = true;
    L32:
        r7 = r7 | r16;
        if (r1 != 0) goto L36;
        if (r15 == false) goto L36;
    L37:
        r8 = r8 | r14;
        if (r10 == false) goto L40;
    L44:
        r1 = r1 + Character.charCount(r12);
        if (r8 == false) goto L18;
        if (r1 < r11.length()) goto L18;
        if (r15 == true) goto L18;
        throw new IllegalArgumentException("First character is RandALCat, but last character is not");
    L40:
        if (Character.isDefined(r12) == true) goto L44;
        throw new IllegalArgumentException("Character at position " + r1 + " is unassigned");
    L36:
        r14 = false;
        goto L37
    L31:
        r16 = false;
        goto L32
    L24:
        if (r13 == 2) goto L27;
        r15 = false;
        goto L28
    L53:
        throw new IllegalArgumentException("Prohibited character " + r12 + " at position " + r1);
    L54:
        if (r6 == false) goto L59;
        if (r7 == false) goto L59;
        throw new IllegalArgumentException("Contains both RandALCat characters and LCat characters");
    L59:
        return r11;
    }

    private static boolean a(char r1) {
        if (r1 < 0) goto L6;
        if (r1 > 31) goto L6;
    L7:
        return true;
    L6:
        if (r1 == 127) goto L7;
        return false;
    }

    static boolean a(int r2) {
        char r0 = (char) r2;
        if (b(r0) == false) goto L5;
    L24:
        return true;
    L5:
        if (a(r0) == true) goto L24;
        if (i(r2) == true) goto L24;
        if (h(r2) == true) goto L24;
        if (g(r2) == true) goto L24;
        if (f(r2) == true) goto L24;
        if (e(r2) == true) goto L24;
        if (d(r2) == true) goto L24;
        if (c(r2) == true) goto L24;
        if (b(r2) == true) goto L24;
        return false;
    }

    private static boolean b(char r1) {
        if (r1 != 160) goto L5;
    L18:
        return true;
    L5:
        if (r1 == 5760) goto L18;
        if (8192 > r1) goto L11;
        if (r1 <= 8203) goto L18;
    L11:
        if (r1 == 8239) goto L18;
        if (r1 == 8287) goto L18;
        if (r1 == 12288) goto L18;
        return false;
    }

    private static boolean b(int r1) {
        if (r1 != 917505) goto L5;
    L10:
        return true;
    L5:
        if (917536 <= r1) goto L7;
    L9:
        return false;
    L7:
        if (r1 > 917631) goto L9;
        goto L9
    }

    private static boolean c(char r1) {
        if (r1 != 173) goto L5;
    L30:
        return true;
    L5:
        if (r1 == 847) goto L30;
        if (r1 == 6150) goto L30;
        if (r1 == 6155) goto L30;
        if (r1 == 6156) goto L30;
        if (r1 == 6157) goto L30;
        if (r1 == 8203) goto L30;
        if (r1 == 8204) goto L30;
        if (r1 == 8205) goto L30;
        if (r1 == 8288) goto L30;
        if (65024 > r1) goto L27;
        if (r1 <= 65039) goto L30;
    L27:
        if (r1 == 65279) goto L30;
        return false;
    }

    private static boolean c(int r1) {
        if (r1 != 832) goto L5;
    L34:
        return true;
    L5:
        if (r1 == 833) goto L34;
        if (r1 == 8206) goto L34;
        if (r1 == 8207) goto L34;
        if (r1 == 8234) goto L34;
        if (r1 == 8235) goto L34;
        if (r1 == 8236) goto L34;
        if (r1 == 8237) goto L34;
        if (r1 == 8238) goto L34;
        if (r1 == 8298) goto L34;
        if (r1 == 8299) goto L34;
        if (r1 == 8300) goto L34;
        if (r1 == 8301) goto L34;
        if (r1 == 8302) goto L34;
        if (r1 == 8303) goto L34;
        return false;
    }

    private static boolean d(int r1) {
        if (12272 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 12283) goto L7;
        return true;
    }

    private static boolean e(int r1) {
        if (r1 != 65529) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 65530) goto L14;
        if (r1 == 65531) goto L14;
        if (r1 == 65532) goto L14;
        if (r1 == 65533) goto L14;
        return false;
    }

    private static boolean f(int r1) {
        if (55296 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 57343) goto L7;
        return true;
    }

    private static boolean g(int r1) {
        if (64976 > r1) goto L7;
        if (r1 > 65007) goto L7;
    L74:
        return true;
    L7:
        if (65534 > r1) goto L11;
        if (r1 <= 65535) goto L74;
    L11:
        if (131070 > r1) goto L15;
        if (r1 <= 131071) goto L74;
    L15:
        if (196606 > r1) goto L19;
        if (r1 <= 196607) goto L74;
    L19:
        if (262142 > r1) goto L23;
        if (r1 <= 262143) goto L74;
    L23:
        if (327678 > r1) goto L27;
        if (r1 <= 327679) goto L74;
    L27:
        if (393214 > r1) goto L31;
        if (r1 <= 393215) goto L74;
    L31:
        if (458750 > r1) goto L35;
        if (r1 <= 458751) goto L74;
    L35:
        if (524286 > r1) goto L39;
        if (r1 <= 524287) goto L74;
    L39:
        if (589822 > r1) goto L43;
        if (r1 <= 589823) goto L74;
    L43:
        if (655358 > r1) goto L47;
        if (r1 <= 655359) goto L74;
    L47:
        if (720894 > r1) goto L51;
        if (r1 <= 720895) goto L74;
    L51:
        if (786430 > r1) goto L55;
        if (r1 <= 786431) goto L74;
    L55:
        if (851966 > r1) goto L59;
        if (r1 <= 851967) goto L74;
    L59:
        if (917502 > r1) goto L63;
        if (r1 <= 917503) goto L74;
    L63:
        if (983038 > r1) goto L67;
        if (r1 <= 983039) goto L74;
    L67:
        if (1048574 > r1) goto L71;
        if (r1 <= 1048575) goto L74;
    L71:
        if (1114110 <= r1) goto L73;
    L75:
        return false;
    L73:
        if (r1 > 1114111) goto L75;
        goto L74
    }

    private static boolean h(int r1) {
        if (57344 > r1) goto L7;
        if (r1 > 63743) goto L7;
    L14:
        return true;
    L7:
        if (983040 > r1) goto L11;
        if (r1 <= 1048573) goto L14;
    L11:
        if (1048576 <= r1) goto L13;
    L15:
        return false;
    L13:
        if (r1 > 1114109) goto L15;
        goto L14
    }

    private static boolean i(int r1) {
        if (128 > r1) goto L7;
        if (r1 > 159) goto L7;
    L44:
        return true;
    L7:
        if (r1 == 1757) goto L44;
        if (r1 == 1807) goto L44;
        if (r1 == 6158) goto L44;
        if (r1 == 8204) goto L44;
        if (r1 == 8205) goto L44;
        if (r1 == 8232) goto L44;
        if (r1 == 8233) goto L44;
        if (r1 == 8288) goto L44;
        if (r1 == 8289) goto L44;
        if (r1 == 8290) goto L44;
        if (r1 == 8291) goto L44;
        if (8298 > r1) goto L33;
        if (r1 <= 8303) goto L44;
    L33:
        if (r1 == 65279) goto L44;
        if (65529 > r1) goto L39;
        if (r1 <= 65532) goto L44;
    L39:
        if (119155 <= r1) goto L41;
    L43:
        return false;
    L41:
        if (r1 > 119162) goto L43;
        goto L43
    }
}
