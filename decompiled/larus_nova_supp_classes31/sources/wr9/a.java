package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final d<Integer> a;
    public final d<Boolean> b;
    public final d<Boolean> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "BatteryState(levelPercent=" + this.a + ", isCharging=" + this.b + ", isPowerSaveMode=" + this.c + ')';
    }

    public a(d<Integer> r2, d<Boolean> r3, d<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "levelPercent");
        Intrinsics.checkNotNullParameter(r3, "isCharging");
        Intrinsics.checkNotNullParameter(r4, "isPowerSaveMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
