package com.larus.bmhome.taskskill.network;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final List<Integer> a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "RemotePcAuthorizationMeta(availableModeValues=" + this.a + ", selectedModeValue=" + this.b + ')';
    }

    public g(List<Integer> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "availableModeValues");
        this.a = r2;
        this.b = r3;
    }
}
