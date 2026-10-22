package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h2 {
    public final boolean a;
    public final DoraObricEnvironmentMemoryToastType b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h2) == true) goto L8;
        return false;
    L8:
        h2 r6 = (h2) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricEnvironmentMemoryCompletion(activateOverride=" + this.a + ", toastType=" + this.b + ')';
    }

    public h2(boolean r2, DoraObricEnvironmentMemoryToastType r3) {
        Intrinsics.checkNotNullParameter(r3, "toastType");
        this.a = r2;
        this.b = r3;
    }
}
