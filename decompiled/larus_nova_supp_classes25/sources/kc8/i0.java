package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 {
    public final String a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "PromotedBlockSourceContext(sourceParentBlockId=" + this.a + ", sourceParentBlockType=" + this.b + ')';
    }

    public i0(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "sourceParentBlockId");
        this.a = r2;
        this.b = r3;
    }
}
