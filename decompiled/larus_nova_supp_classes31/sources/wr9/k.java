package wr9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final d<Integer> a;
    public final d<List<Long>> b;
    public final d<Integer> c;
    public final d<Integer> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        return "StaticCpuProfile(logicalCoreCount=" + this.a + ", coreMaxFrequencyKhz=" + this.b + ", littleCoreCount=" + this.c + ", bigCoreCount=" + this.d + ')';
    }

    public k(d<Integer> r2, d<List<Long>> r3, d<Integer> r4, d<Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "logicalCoreCount");
        Intrinsics.checkNotNullParameter(r3, "coreMaxFrequencyKhz");
        Intrinsics.checkNotNullParameter(r4, "littleCoreCount");
        Intrinsics.checkNotNullParameter(r5, "bigCoreCount");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
