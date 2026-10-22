package i02;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final String a;
    public final List<e> b;
    public final int c;

    public d() {
        this(null, null, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<e> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.c;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SlotChangeEvent(sendTogetherId=" + this.a + ", slotList=" + this.b + ", currentCount=" + this.c + ")";
    }

    public d(String r1, List<e> r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
