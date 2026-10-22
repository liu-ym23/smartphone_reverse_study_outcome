package com.larus.dora.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraRouterInterceptor$b {
    public final Boolean a;
    public final Integer b;

    public DoraRouterInterceptor$b() {
        this(null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraRouterInterceptor$b) == true) goto L8;
        return false;
    L8:
        DoraRouterInterceptor$b r6 = (DoraRouterInterceptor$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxVolumeSettingsInitData(isAdaptiveEnabled=" + this.a + ", cueToneVolumeRaw=" + this.b + ')';
    }

    public DoraRouterInterceptor$b(Boolean r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }
}
