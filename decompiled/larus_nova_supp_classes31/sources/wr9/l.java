package wr9;

import com.larus.power.state.api.ThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final d<ThermalLevel> a;
    public final d<ThermalLevel> b;
    public final d<ThermalLevel> c;
    public final d<Integer> d;
    public final d<Double> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ThermalState(effectiveStatus=" + this.a + ", batteryDerivedStatus=" + this.b + ", aospStatus=" + this.c + ", aospRawStatus=" + this.d + ", batteryTemperatureCelsius=" + this.e + ')';
    }

    public l(d<ThermalLevel> r2, d<ThermalLevel> r3, d<ThermalLevel> r4, d<Integer> r5, d<Double> r6) {
        Intrinsics.checkNotNullParameter(r2, "effectiveStatus");
        Intrinsics.checkNotNullParameter(r3, "batteryDerivedStatus");
        Intrinsics.checkNotNullParameter(r4, "aospStatus");
        Intrinsics.checkNotNullParameter(r5, "aospRawStatus");
        Intrinsics.checkNotNullParameter(r6, "batteryTemperatureCelsius");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
