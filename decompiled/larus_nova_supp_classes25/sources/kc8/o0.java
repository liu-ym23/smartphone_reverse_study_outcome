package kc8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 {
    public final int a;
    public final Function0<Unit> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r6 = (o0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockRenderConfig(maxContentWidth=" + this.a + ", onCoverLongClick=" + this.b + ')';
    }

    public o0(int r2, cb8.r r3) {
        Intrinsics.checkNotNullParameter(r3, "onCoverLongClick");
        this.a = r2;
        this.b = r3;
    }
}
