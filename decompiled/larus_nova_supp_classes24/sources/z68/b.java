package z68;

import da9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final long a;
    public final String b;
    public final e c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "PendingScreenShareStart(startElapsedMs=" + this.a + ", startSource=" + this.b + ", policy=" + this.c + ')';
    }

    public b(long r2, String r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, "startSource");
        Intrinsics.checkNotNullParameter(r5, "policy");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
