package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: classes7.dex */
public class XmlWhitespace {
    public static String collapse(String r8, int r9) {
        if (r9 == 1) goto L74;
        if (r9 == 0) goto L74;
        if (r8.indexOf(10) < 0) goto L10;
        r8 = r8.replace('\n', ' ');
    L10:
        if (r8.indexOf(9) < 0) goto L13;
        r8 = r8.replace('\t', ' ');
    L13:
        if (r8.indexOf(13) < 0) goto L15;
        r8 = r8.replace('\r', ' ');
    L15:
        String r1 = r8;
        if (r9 != 2) goto L18;
        return r1;
    L18:
        int r10 = r1.length();
        if (r10 != 0) goto L22;
        return r1;
    L22:
        if (r1.charAt(0) == ' ') goto L42;
        int r4 = 2;
    L24:
        if (r4 >= r10) goto L37;
        if (r1.charAt(r4) != ' ') goto L36;
        if (r1.charAt(r4 - 1) == ' ') goto L40;
        if (r4 == (r10 - 1)) goto L40;
        r4 = r4 + 1;
        if (r1.charAt(r4) != ' ') goto L36;
    L40:
        int r11 = r4;
    L49:
        char[] r5 = r1.toCharArray();
    L50:
        r4 = r4 + 1;
        if (r4 >= r10) goto L63;
        if (r1.charAt(r4) == ' ') goto L50;
    L55:
        int r6 = r11 + 1;
        int r7 = r4 + 1;
        r5[r11] = r5[r4];
        if (r7 >= r10) goto L57;
        if (r5[r7] == ' ') goto L60;
        r11 = r6;
        r4 = r7;
        goto L55
    L60:
        r11 = r6 + 1;
        r4 = r7 + 1;
        r5[r6] = r5[r7];
        if (r4 >= r10) goto L63;
        if (r5[r4] != ' ') goto L55;
    L57:
        r11 = r6;
    L63:
        if (r11 == 0) goto L69;
        int r0 = r11 - 1;
        if (r5[r0] != ' ') goto L69;
        r11 = r0;
    L69:
        return new String(r5, 0, r11);
    L36:
        r4 = r4 + 2;
        goto L24
    L37:
        if (r4 == r10) goto L39;
    L41:
        return r1;
    L39:
        if (r1.charAt(r4 - 1) != ' ') goto L41;
    L42:
        r4 = 0;
    L43:
        int r12 = r4 + 1;
        if (r12 >= r1.length()) goto L48;
        if (r1.charAt(r12) != ' ') goto L48;
        r4 = r12;
    L48:
        r11 = 0;
    L74:
        return r8;
    }

    public static boolean isAllSpace(String r4) {
        int r0 = r4.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (isSpace(r4.charAt(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static boolean isSpace(char r1) {
        if (r1 != '\t') goto L5;
        return true;
    L5:
        if (r1 != '\n') goto L7;
        return true;
    L7:
        if (r1 != '\r') goto L9;
        return true;
    L9:
        if (r1 == ' ') goto L16;
        return false;
    L16:
        return true;
    }
}
