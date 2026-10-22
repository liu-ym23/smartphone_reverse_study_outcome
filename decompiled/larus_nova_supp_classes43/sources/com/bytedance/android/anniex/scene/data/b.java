package com.bytedance.android.anniex.scene.data;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final int a;
    public final int b;
    public final double c;
    public final Map<String, Pair<Integer, Double>> d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r11.c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = Double.doubleToLongBits(this.c);
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "SceneQueryInfo(currentCount=" + this.a + ", repeatCount=" + this.b + ", avgDuration=" + this.c + ", transitions=" + this.d + ')';
    }

    public b(int r10, int r11, double r12, Map<String, Pair<Integer, Double>> r13) {
        Intrinsics.checkNotNullParameter(r13, "transitions");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
