package com.larus.dora.o.impl.memory;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements b0 {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((z) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "OMemoryEventGroup(timeString=" + this.a + ')';
    }

    public z(String r1) {
        this.a = r1;
    }
}
