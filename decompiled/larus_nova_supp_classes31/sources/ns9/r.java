package ns9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r {
    public final Map<String, String> a;
    public final Map<String, String> b;

    public r() {
        Map r0 = null;
        this(r0, r0, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
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
        return "ReachPayload(passThrough=" + this.a + ", extra=" + this.b + ')';
    }

    public r(Map<String, String> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "passThrough");
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.a = r2;
        this.b = r3;
    }

    public /* synthetic */ r(Map r2, Map r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = MapsKt.emptyMap();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        this(r2, r3);
    }
}
