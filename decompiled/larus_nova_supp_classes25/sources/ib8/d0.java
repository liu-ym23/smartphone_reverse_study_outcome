package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public final boolean a;
    public final String b;

    public d0() {
        this(false, "");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "FoldOrExpandAnimation(forceFoldOrExpandAnimation=" + this.a + ", triggerFoldOrExpandTitle=" + this.b + ')';
    }

    public d0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "triggerFoldOrExpandTitle");
        this.a = r2;
        this.b = r3;
    }
}
