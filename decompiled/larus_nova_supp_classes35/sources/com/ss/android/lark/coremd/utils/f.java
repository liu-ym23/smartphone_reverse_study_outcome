package com.ss.android.lark.coremd.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    static {
    }

    public static int a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "str");
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r3.length()) goto L7;
        if (r1 >= r4) goto L7;
        r0 = r0 + Character.charCount(r3.codePointAt(r0));
        r1 = r1 + 1;
    L7:
        if (r1 == r4) goto L13;
        return -1;
    L13:
        return r0;
    }
}
