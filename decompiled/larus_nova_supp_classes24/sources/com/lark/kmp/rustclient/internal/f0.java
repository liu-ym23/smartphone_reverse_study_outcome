package com.lark.kmp.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f0 {
    public static final boolean a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L25;
        int r1 = r7.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L8:
        if (r3 > r1) goto L24;
        if (r4 == true) goto L11;
        int r5 = r3;
    L13:
        if (Intrinsics.compare(r7.charAt(r5), 32) > 0) goto L15;
        boolean r6 = true;
    L16:
        if (r4 == false) goto L17;
        if (r6 == false) goto L24;
        r1 = r1 - 1;
        goto L8
    L17:
        if (r6 == false) goto L18;
        r3 = r3 + 1;
        goto L8
    L18:
        r4 = true;
        goto L8
    L15:
        r6 = false;
        goto L16
    L11:
        r5 = r1;
    L24:
        if (Intrinsics.areEqual(r7.subSequence(r3, r1 + 1).toString(), "0") == true) goto L25;
        return false;
    L25:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
