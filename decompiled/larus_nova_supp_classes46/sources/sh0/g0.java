package sh0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 {
    public final zj0.c a;
    public final List<Integer> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g0) == false) goto L10;
        g0 r4 = (g0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        zj0.c r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateLinkWindowLayoutConfigInfo(switchType=" + this.a + ", playModes=" + this.b + ")";
    }

    public g0(zj0.c.b r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "switchType");
        this.a = r2;
        this.b = r3;
    }
}
