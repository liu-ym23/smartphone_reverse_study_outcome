package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a1 {
    public final g a;

    public static final class a {
    }

    static {
    }

    public a1() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a1) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "DoraXLinkCommonConfig(android=" + this.a + ')';
    }

    public a1(g r1) {
        this.a = r1;
    }
}
