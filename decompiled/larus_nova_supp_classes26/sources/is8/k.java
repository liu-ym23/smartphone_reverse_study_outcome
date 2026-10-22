package is8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final long a;
    public final long b;
    public final Map<String, String> c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "UploadTraceSnapshot(startTimeMs=" + this.a + ", endTimeMs=" + this.b + ", attributes=" + this.c + ')';
    }

    public k(long r2, long r4, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "attributes");
        this.a = r2;
        this.b = r4;
        this.c = r6;
    }
}
