package org.apache.xmlbeans.impl.regex;

import okio.Utf8;

/* JADX INFO: loaded from: classes7.dex */
public final class REUtil {
    static final RegularExpression[] regexCache = null;

    static {
        regexCache = new RegularExpression[20];
    }

    static final int composeFromSurrogates(int r1, int r2) {
        return ((((r1 - 55296) << 10) + 65536) + r2) - Utf8.LOG_SURROGATE_HEADER;
    }

    static final String createOptionString(int r2) {
        StringBuilder r0 = new StringBuilder(9);
        if ((r2 & 256) == 0) goto L6;
        r0.append('F');
    L6:
        if ((r2 & 128) == 0) goto L9;
        r0.append('H');
    L9:
        if ((r2 & 512) == 0) goto L12;
        r0.append('X');
    L12:
        if ((r2 & 2) == 0) goto L15;
        r0.append('i');
    L15:
        if ((r2 & 8) == 0) goto L18;
        r0.append('m');
    L18:
        if ((r2 & 4) == 0) goto L21;
        r0.append('s');
    L21:
        if ((r2 & 32) == 0) goto L24;
        r0.append('u');
    L24:
        if ((r2 & 64) == 0) goto L27;
        r0.append('w');
    L27:
        if ((r2 & 16) == 0) goto L30;
        r0.append('x');
    L30:
        if ((r2 & 1024) == 0) goto L33;
        r0.append(',');
    L33:
        return r0.toString().intern();
    }

    static final String decomposeToSurrogates(int r3) {
        int r4 = r3 - 65536;
        return new String(new char[]{(char) ((r4 >> 10) + 55296), (char) ((r4 & 1023) + Utf8.LOG_SURROGATE_HEADER)});
    }

    static final int getOptionValue(int r1) {
        if (r1 != 44) goto L5;
        return 1024;
    L5:
        if (r1 != 70) goto L7;
        return 256;
    L7:
        if (r1 != 72) goto L9;
        return 128;
    L9:
        if (r1 != 88) goto L11;
        return 512;
    L11:
        if (r1 != 105) goto L13;
        return 2;
    L13:
        if (r1 != 109) goto L15;
        return 8;
    L15:
        if (r1 != 115) goto L17;
        return 4;
    L17:
        if (r1 != 117) goto L19;
        return 32;
    L19:
        if (r1 != 119) goto L21;
        return 64;
    L21:
        if (r1 == 120) goto L23;
        return 0;
    L23:
        return 16;
    }

    static final boolean isHighSurrogate(int r1) {
        if ((r1 & 64512) != 55296) goto L5;
        return true;
    L5:
        return false;
    }

    static final boolean isLowSurrogate(int r1) {
        if ((r1 & 64512) != 56320) goto L5;
        return true;
    L5:
        return false;
    }

    static final int parseOptions(String r4) {
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = 0;
    L7:
        if (r0 >= r4.length()) goto L13;
        int r2 = getOptionValue(r4.charAt(r0));
        if (r2 == 0) goto L12;
        r1 = r1 | r2;
        r0 = r0 + 1;
        goto L7
    L12:
        throw new ParseException("Unknown Option: " + r4.substring(r0), -1);
    L13:
        return r1;
    }

    public static String quoteMeta(String r6) {
        int r0 = r6.length();
        StringBuilder r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        char r4 = r6.charAt(r3);
        if (".*+?{[()|\\^$".indexOf(r4) < 0) goto L12;
        if (r2 != null) goto L10;
        r2 = new StringBuilder(((r0 - r3) * 2) + r3);
        if (r3 <= 0) goto L10;
        r2.append(r6.substring(0, r3));
    L10:
        r2.append('\\');
    L11:
        r2.append(r4);
    L14:
        r3 = r3 + 1;
        goto L3
    L12:
        if (r2 == null) goto L14;
    L15:
        if (r2 != null) goto L17;
        return r6;
    L17:
        return r2.toString();
    }

    static String stripExtendedComment(String r11) {
        int r0 = r11.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L39;
        int r3 = r2 + 1;
        char r4 = r11.charAt(r2);
        if (r4 == '\t') goto L37;
        if (r4 == '\n') goto L37;
        if (r4 == '\f') goto L37;
        if (r4 == '\r') goto L37;
        if (r4 == ' ') goto L37;
        if (r4 != '#') goto L24;
    L17:
        r2 = r3;
        if (r2 >= r0) goto L3;
        r3 = r2 + 1;
        char r5 = r11.charAt(r2);
        if (r5 == '\r') goto L37;
        if (r5 != '\n') goto L17;
    L24:
        if (r4 != '\\') goto L36;
        if (r3 >= r0) goto L36;
        char r6 = r11.charAt(r3);
        if (r6 == '#') goto L35;
        if (r6 == '\t') goto L35;
        if (r6 == '\n') goto L35;
        if (r6 == '\f') goto L35;
        if (r6 == '\r') goto L35;
        if (r6 == ' ') goto L35;
        r1.append('\\');
    L35:
        r1.append(r6);
        r3 = r3 + 1;
    L36:
        r1.append(r4);
    L37:
        r2 = r3;
        goto L3
    L39:
        return r1.toString();
    }
}
