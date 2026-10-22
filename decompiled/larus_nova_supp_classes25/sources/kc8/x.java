package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public final Integer a;

    public x() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((x) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "GenericToolConfig(rootBackgroundRes=" + this.a + ')';
    }

    public x(Integer r1) {
        this.a = r1;
    }
}
