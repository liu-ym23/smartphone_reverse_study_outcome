package com.larus.bmhome.chat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 {
    public static final boolean a(wh8.a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = r1.g;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.intValue() != 1) goto L8;
        return true;
    }

    public static final boolean b(wh8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Integer r0 = r2.g;
        if (r0 != null) goto L6;
    L7:
        Integer r3 = r2.g;
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (r3.intValue() != 10) goto L13;
    L14:
        return true;
    L6:
        if (r0.intValue() == 9) goto L14;
        goto L7
    }
}
