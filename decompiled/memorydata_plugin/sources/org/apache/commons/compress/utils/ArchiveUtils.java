package org.apache.commons.compress.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class ArchiveUtils {
    public static String sanitize(String r6) {
        char[] r7 = r6.toCharArray();
        if (r7.length > 255) goto L5;
        char[] r0 = r7;
    L7:
        if (r7.length <= 255) goto L11;
        int r8 = 252;
    L9:
        if (r8 >= 255) goto L11;
        r0[r8] = '.';
        r8 = r8 + 1;
    L11:
        StringBuilder r9 = new StringBuilder();
        int r1 = r0.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L23;
        char r3 = r0[r2];
        if (Character.isISOControl(r3) == true) goto L20;
        Character.UnicodeBlock r4 = Character.UnicodeBlock.of(r3);
        if (r4 == null) goto L20;
        if (r4 == Character.UnicodeBlock.SPECIALS) goto L20;
    L21:
        r9.append(r3);
        r2 = r2 + 1;
    L20:
        r3 = '?';
        goto L21
    L23:
        return r9.toString();
    L5:
        r0 = Arrays.copyOf(r7, 255);
        goto L7
    }
}
