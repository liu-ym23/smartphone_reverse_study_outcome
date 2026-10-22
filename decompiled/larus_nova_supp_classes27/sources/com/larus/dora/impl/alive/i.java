package com.larus.dora.impl.alive;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public final String a;
    public final List<j> b;
    public final List<j> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraKeepAliveEntry(manufacturer=" + this.a + ", lockAppItems=" + this.b + ", autoStartItems=" + this.c + ')';
    }

    public i(String r2, List<j> r3, List<j> r4) {
        Intrinsics.checkNotNullParameter(r3, "lockAppItems");
        Intrinsics.checkNotNullParameter(r4, "autoStartItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
