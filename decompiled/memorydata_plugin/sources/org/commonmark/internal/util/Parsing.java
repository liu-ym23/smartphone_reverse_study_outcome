package org.commonmark.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.Utf8;

/* JADX INFO: loaded from: classes7.dex */
public class Parsing {
    public static int CODE_BLOCK_INDENT = 4;

    static {
    }

    public static int columnsToNextTabStop(int r0) {
        return 4 - (r0 % 4);
    }

    public static int find(char r2, CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
    L3:
        if (r4 >= r0) goto L8;
        if (r5.charAt(r4) == r2) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return -1;
    }

    public static int findLineBreak(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
    L3:
        if (r4 >= r0) goto L10;
        char r1 = r5.charAt(r4);
        if (r1 == '\n') goto L9;
        if (r1 == '\r') goto L9;
        r4 = r4 + 1;
    L9:
        return r4;
    L10:
        return -1;
    }

    private static int findNonSpace(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
    L3:
        if (r4 >= r0) goto L9;
        char r1 = r5.charAt(r4);
        if (r1 == ' ') goto L8;
        switch(r1) {
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            default: goto L7;
        };
    L7:
        return r4;
    L8:
        r4 = r4 + 1;
        goto L3
    L9:
        return -1;
    }

    public static boolean hasNonSpace(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r4.length();
        if (skip(' ', r4, 0, r0) == r0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isBlank(CharSequence r2) {
        if (findNonSpace((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), 0) != (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isEscapable(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 >= r4.length()) goto L12;
        char r5 = r4.charAt(r3);
        switch(r5) {
            case 33: goto L10;
            case 34: goto L10;
            case 35: goto L10;
            case 36: goto L10;
            case 37: goto L10;
            case 38: goto L10;
            case 39: goto L10;
            case 40: goto L10;
            case 41: goto L10;
            case 42: goto L10;
            case 43: goto L10;
            case 44: goto L10;
            case 45: goto L10;
            case 46: goto L10;
            case 47: goto L10;
            default: goto L6;
        };
    L6:
        switch(r5) {
            case 58: goto L14;
            case 59: goto L14;
            case 60: goto L14;
            case 61: goto L14;
            case 62: goto L14;
            case 63: goto L14;
            case 64: goto L14;
            default: goto L7;
        };
    L7:
        switch(r5) {
            case 91: goto L15;
            case 92: goto L15;
            case 93: goto L15;
            case 94: goto L15;
            case 95: goto L15;
            case 96: goto L15;
            default: goto L8;
        };
    L8:
        switch(r5) {
            case 123: goto L16;
            case 124: goto L16;
            case 125: goto L16;
            case 126: goto L16;
            default: goto L17;
        };
    L16:
        return true;
    L17:
        return false;
    L15:
        return true;
    L14:
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    public static boolean isLetter(CharSequence r2, int r3) {
        return Character.isLetter(Character.codePointAt((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3));
    }

    public static boolean isSpaceOrTab(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 >= r4.length()) goto L11;
        char r5 = r4.charAt(r3);
        if (r5 != '\t') goto L7;
        return true;
    L7:
        if (r5 != ' ') goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    public static CharSequence prepareLine(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r6.length();
        StringBuilder r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L13;
        char r4 = r6.charAt(r3);
        if (r4 == 0) goto L8;
        if (r2 == null) goto L12;
    L11:
        r2.append(r4);
    L12:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r2 != null) goto L10;
        r2 = new StringBuilder(r0);
        r2.append(r6, 0, r3);
    L10:
        r4 = Utf8.REPLACEMENT_CHARACTER;
        goto L11
    L13:
        if (r2 != null) goto L15;
        return r6;
    L15:
        return r2.toString();
    }

    public static int skip(char r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    L3:
        if (r4 >= r5) goto L8;
        if (r6.charAt(r4) != r2) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return r5;
    }

    public static int skipBackwards(char r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    L3:
        if (r4 < r5) goto L9;
        if (r6.charAt(r4) != r2) goto L6;
        r4 = r4 - 1;
        goto L3
    L6:
        return r4;
    L9:
        return r5 - 1;
    }

    public static int skipSpaceTab(CharSequence r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L3:
        if (r3 >= r4) goto L10;
        char r0 = r5.charAt(r3);
        if (r0 == '\t') goto L9;
        if (r0 == ' ') goto L9;
        return r3;
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        return r4;
    }

    public static int skipSpaceTabBackwards(CharSequence r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L3:
        if (r3 < r4) goto L11;
        char r0 = r5.charAt(r3);
        if (r0 == '\t') goto L9;
        if (r0 == ' ') goto L9;
        return r3;
    L9:
        r3 = r3 - 1;
        goto L3
    L11:
        return r4 - 1;
    }
}
