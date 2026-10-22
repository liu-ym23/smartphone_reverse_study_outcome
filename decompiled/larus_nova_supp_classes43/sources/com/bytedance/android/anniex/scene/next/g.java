package com.bytedance.android.anniex.scene.next;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements a {
    public final String a;
    public final double b;
    public final Map<String, Pair<Integer, Double>> c;
    public final Map<String, Object> d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r11.b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = Double.doubleToLongBits(this.b);
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Map<String, Pair<Integer, Double>> r11 = this.c;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Map<String, Object> r15 = this.d;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "SceneSwitchInput(currentSceneId=" + this.a + ", avgDuration=" + this.b + ", transitions=" + this.c + ", extraParams=" + this.d + ')';
    }

    public g(String r10, double r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "currentSceneId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = null;
    }
}
