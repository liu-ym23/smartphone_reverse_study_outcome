package uk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final rk8.a a;
    public final kc8.b b;
    public final b c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        kc8.b r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ElapsedBlockVMData(blockModel=" + this.a + ", blockDependConfig=" + this.b + ", headerModel=" + this.c + ')';
    }

    public d(rk8.a r2, kc8.b r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        Intrinsics.checkNotNullParameter(r4, "headerModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
