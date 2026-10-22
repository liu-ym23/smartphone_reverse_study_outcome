package com.ss.android.lark.flow.threadwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q {
    public static final String a(String r3) {
        if (r3 == null) goto L13;
        boolean r1 = false;
        if (r3.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L11:
        if (r1 == false) goto L13;
        return r3;
    L9:
        if (Intrinsics.areEqual(r3, "null") == true) goto L11;
        r1 = true;
        goto L11
    L6:
        r0 = false;
    L13:
        return null;
    }
}
