package ub8;

import kotlin.jvm.internal.Intrinsics;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final boolean a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        t r3 = r2.a;
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.a != true) goto L9;
        return true;
    L9:
        return false;
    }
}
