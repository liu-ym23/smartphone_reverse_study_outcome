package de8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final long a(c r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.n;
    }

    public static final String b(Boolean r1) {
        if (r1 == null) goto L7;
        r1.booleanValue();
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        return "1";
    L6:
        return "0";
    L7:
        return null;
    }
}
