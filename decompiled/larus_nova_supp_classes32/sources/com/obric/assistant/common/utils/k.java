package com.obric.assistant.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "str");
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return "#";
    L9:
        char r5 = r4.charAt(0);
        if (19968 <= r5) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L26;
        String r6 = ru7.c.c(r5);     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L30
        if (r6.length() > 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L22;
        return "#";
    L22:
        if (Character.isLetter(r6.charAt(0)) == false) goto L34;
        return String.valueOf(Character.toUpperCase(r6.charAt(0)));
    L34:
        return "#";
    L37:
        return "#";
    L26:
        if (Character.isLetter(r5) == true) goto L35;
        Character.isDigit(r5);
        return "#";
    L35:
        return String.valueOf(Character.toUpperCase(r5));
    L12:
        if (r5 >= 40870) goto L14;
        r2 = true;
        goto L15
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean b(String r3) {
        if (r3.length() != 1) goto L13;
        char r4 = r3.charAt(0);
        if ('A' <= r4) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r4 >= '[') goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }
}
