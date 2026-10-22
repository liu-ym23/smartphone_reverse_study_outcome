package zo0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final String a;
    public final long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L10;
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "TimePoint(event=" + this.a + ", timestamp=" + this.b + ")";
    }

    public e(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a = r2;
        this.b = r3;
    }
}
