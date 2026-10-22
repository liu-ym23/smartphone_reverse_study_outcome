package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final d<Double> a;
    public final d<Double> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CpuState(appUsagePercent=" + this.a + ", appSpeedPercent=" + this.b + ')';
    }

    public b(d<Double> r2, d<Double> r3) {
        Intrinsics.checkNotNullParameter(r2, "appUsagePercent");
        Intrinsics.checkNotNullParameter(r3, "appSpeedPercent");
        this.a = r2;
        this.b = r3;
    }
}
