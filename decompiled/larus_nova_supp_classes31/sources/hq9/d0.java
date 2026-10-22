package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 {
    public final g4 a;

    public d0() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g4 r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CapabilitiesConfig(rtc=" + this.a + ')';
    }

    public d0(g4 r1) {
        this.a = r1;
    }
}
