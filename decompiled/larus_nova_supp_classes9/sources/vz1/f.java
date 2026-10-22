package vz1;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final k a;

    public f() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((f) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        k r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "GiftBottomLabelInfo(bottomLabel=" + this.a + ")";
    }

    public f(k r1) {
        this.a = r1;
    }
}
