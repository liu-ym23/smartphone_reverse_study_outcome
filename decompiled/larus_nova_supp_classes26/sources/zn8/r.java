package zn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public final l a;
    public final q b;
    public final p c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "VideoGroupViewInput(sizeData=" + this.a + ", videoData=" + this.b + ", trackData=" + this.c + ", isOversea=" + this.d + ')';
    }

    public r(l r2, q r3, p r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "sizeData");
        Intrinsics.checkNotNullParameter(r3, "videoData");
        Intrinsics.checkNotNullParameter(r4, "trackData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
