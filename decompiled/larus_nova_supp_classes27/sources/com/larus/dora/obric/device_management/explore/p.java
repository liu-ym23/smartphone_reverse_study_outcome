package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public final boolean a;
    public final List<o> b;

    public p() {
        boolean r1 = false;
        this(r1, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
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
        return "DoraObricExploreState(loading=" + this.a + ", sections=" + this.b + ')';
    }

    public /* synthetic */ p(boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        List r4 = CollectionsKt.emptyList();
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public p(boolean r2, List<o> r3) {
        Intrinsics.checkNotNullParameter(r3, "sections");
        this.a = r2;
        this.b = r3;
    }
}
