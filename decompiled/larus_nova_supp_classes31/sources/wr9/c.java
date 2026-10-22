package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final d<Long> a;
    public final d<Long> b;
    public final d<Long> c;
    public final d<Boolean> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "MemoryState(totalBytes=" + this.a + ", availableBytes=" + this.b + ", processPssBytes=" + this.c + ", isLowMemory=" + this.d + ')';
    }

    public c(d<Long> r2, d<Long> r3, d<Long> r4, d<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "totalBytes");
        Intrinsics.checkNotNullParameter(r3, "availableBytes");
        Intrinsics.checkNotNullParameter(r4, "processPssBytes");
        Intrinsics.checkNotNullParameter(r5, "isLowMemory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
