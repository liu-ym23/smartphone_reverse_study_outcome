package com.ss.android.lark.compose.groupinfo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final boolean a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(r2.a, r2.c) == true) goto L5;
        return true;
    L5:
        if (r2.e.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r3 = false;
        goto L8
    }
}
