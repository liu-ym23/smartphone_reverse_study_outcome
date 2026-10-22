package com.larus.bmhome.block.holder.content.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final boolean a(String r3, String r4, String r5, String r6) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L20;
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L20;
        if (Intrinsics.areEqual(r3, r5) == false) goto L20;
        boolean r8 = true;
    L21:
        if (r4 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L38;
        if (r6 != null) goto L30;
    L33:
        boolean r10 = true;
    L34:
        if (r10 == true) goto L38;
        if (Intrinsics.areEqual(r4, r6) == false) goto L38;
        boolean r11 = true;
    L39:
        if (r8 == true) goto L41;
        if (r11 == true) goto L41;
        return false;
    L41:
        return true;
    L30:
        if (r6.length() == 0) goto L33;
        r10 = false;
    L38:
        r11 = false;
        goto L39
    L23:
        if (r4.length() == 0) goto L26;
        r9 = false;
        goto L27
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
    L20:
        r8 = false;
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
