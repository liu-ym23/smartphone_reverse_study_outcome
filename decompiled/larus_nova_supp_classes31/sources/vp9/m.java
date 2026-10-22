package vp9;

import com.facebook.drawee.generic.RoundingParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public RoundingParams a;
    public int b;
    public boolean c;
    public int d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.d) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaListStateData(cornerRadius=" + this.a + ", lastCornersRadius=" + this.b + ", isSelectable=" + this.c + ", selectViewType=" + this.d + ", useCompactSelectionHitTarget=" + this.e + ')';
    }

    public m(RoundingParams r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "cornerRadius");
        this.a = r2;
        this.b = r3;
        this.c = true;
        this.d = r4;
        this.e = r5;
    }
}
