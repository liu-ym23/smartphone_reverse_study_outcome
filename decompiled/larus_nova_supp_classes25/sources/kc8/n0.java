package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {
    public final m0 a;
    public final o0 b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockConfig(chatConfig=" + this.a + ", renderConfig=" + this.b + ')';
    }

    public n0(m0 r2, o0 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatConfig");
        Intrinsics.checkNotNullParameter(r3, "renderConfig");
        this.a = r2;
        this.b = r3;
    }
}
