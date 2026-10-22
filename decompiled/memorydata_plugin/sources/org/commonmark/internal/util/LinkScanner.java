package org.commonmark.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class LinkScanner {
    public static int scanLinkDestination(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 < r6.length()) goto L6;
        return -1;
    L6:
        if (r6.charAt(r5) != '<') goto L24;
    L7:
        r5 = r5 + 1;
        if (r5 >= r6.length()) goto L22;
        char r0 = r6.charAt(r5);
        if (r0 == '\n') goto L22;
        if (r0 == '<') goto L22;
        if (r0 == '>') goto L21;
        if (r0 != '\\') goto L7;
        int r1 = r5 + 1;
        if (Parsing.isEscapable(r6, r1) == false) goto L7;
        r5 = r1;
        goto L7
    L21:
        return r5 + 1;
    L22:
        return -1;
    L24:
        return scanLinkDestinationWithBalancedParens(r6, r5);
    }

    private static int scanLinkDestinationWithBalancedParens(CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r1 = r7;
    L4:
        if (r1 >= r8.length()) goto L36;
        char r2 = r8.charAt(r1);
        if (r2 == 0) goto L31;
        if (r2 == ' ') goto L31;
        if (r2 != '\\') goto L12;
        int r3 = r1 + 1;
        if (Parsing.isEscapable(r8, r3) == false) goto L30;
        r1 = r3;
    L30:
        r1 = r1 + 1;
        goto L4
    L12:
        if (r2 != '(') goto L14;
        r0 = r0 + 1;
        if (r0 <= 32) goto L30;
        return -1;
    L14:
        if (r2 != ')') goto L16;
        if (r0 == 0) goto L22;
        r0 = r0 - 1;
        goto L30
    L22:
        return r1;
    L16:
        if (Character.isISOControl(r2) == false) goto L30;
        if (r1 == r7) goto L20;
        return r1;
    L20:
        return -1;
    L31:
        if (r1 == r7) goto L34;
        return r1;
    L34:
        return -1;
    L36:
        return r8.length();
    }

    public static int scanLinkLabelContent(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L4:
        if (r3 >= r4.length()) goto L16;
        switch(r4.charAt(r3)) {
            case 91: goto L12;
            case 92: goto L9;
            case 93: goto L8;
            default: goto L14;
        };
    L9:
        int r0 = r3 + 1;
        if (Parsing.isEscapable(r4, r0) == false) goto L14;
        r3 = r0;
        goto L14
    L8:
        return r3;
    L12:
        return -1;
    L14:
        r3 = r3 + 1;
        goto L4
    L16:
        return r4.length();
    }

    public static int scanLinkTitle(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 < r6.length()) goto L5;
        return -1;
    L5:
        char r0 = r6.charAt(r5);
        char r2 = '\'';
        if (r0 == '\"') goto L12;
        if (r0 != '\'') goto L9;
    L13:
        int r7 = scanLinkTitleContent(r6, r5 + 1, r2);
        if (r7 != (-1)) goto L17;
        return -1;
    L17:
        if (r7 < r6.length()) goto L19;
    L23:
        return -1;
    L19:
        if (r6.charAt(r7) != r2) goto L23;
        return r7 + 1;
    L9:
        if (r0 == '(') goto L11;
        return -1;
    L11:
        r2 = ')';
        goto L13
    L12:
        r2 = '\"';
        goto L13
    }

    public static int scanLinkTitleContent(CharSequence r3, int r4, char r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    L4:
        if (r4 >= r6.length()) goto L20;
        char r0 = r6.charAt(r4);
        if (r0 != '\\') goto L10;
        int r1 = r4 + 1;
        if (Parsing.isEscapable(r6, r1) == false) goto L10;
        r4 = r1;
    L18:
        r4 = r4 + 1;
    L10:
        if (r0 == r5) goto L11;
        if (r5 != ')') goto L18;
        if (r0 != '(') goto L18;
        return -1;
    L11:
        return r4;
    L20:
        return r6.length();
    }
}
