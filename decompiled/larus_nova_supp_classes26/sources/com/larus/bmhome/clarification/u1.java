package com.larus.bmhome.clarification;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u1 {
    public static final String b(h2 r1) {
        if (Intrinsics.areEqual(r1, h2.c.a) == false) goto L6;
        return null;
    L6:
        if ((r1 instanceof h2.b) == false) goto L9;
        return ((h2.b) r1).a;
    L9:
        if ((r1 instanceof h2.a) == false) goto L13;
        return ((h2.a) r1).a;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final String c(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        return "unknown";
    L15:
        if (r2.intValue() != 3) goto L17;
        return "free_text";
    L10:
        if (r2.intValue() != 2) goto L12;
        return "multi_select";
    L5:
        if (r2.intValue() != 1) goto L7;
        return "single_select";
    }

    public static final boolean a(d2 r2, d2 r3) {
        if (Intrinsics.areEqual(r2.a, r3.a) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.b, r3.b) == false) goto L11;
        if (Intrinsics.areEqual(r2.c, r3.c) == false) goto L11;
        if (Intrinsics.areEqual(r2.d, r3.d) == false) goto L11;
        return true;
    }
}
