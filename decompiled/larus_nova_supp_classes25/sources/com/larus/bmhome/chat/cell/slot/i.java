package com.larus.bmhome.chat.cell.slot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements ei9.f {
    public final xc8.b a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MessageForkRelationSlotState(data=" + this.a + ')';
    }

    public i(xc8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }
}
