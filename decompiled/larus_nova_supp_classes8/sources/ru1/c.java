package ru1;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import su1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final List<e> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<e> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "OperationSet(operations=" + this.a + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends e> r2) {
        Intrinsics.checkNotNullParameter(r2, "operations");
        this.a = r2;
    }
}
