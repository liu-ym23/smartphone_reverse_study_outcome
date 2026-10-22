package x29;

import com.larus.contextwindow.api.ContextWindowUsageParts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final ContextWindowUsageParts a;
    public final long b;
    public final Long c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.c;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "Success(parts=" + this.a + ", used=" + this.b + ", messageTotal=" + this.c + ')';
    }

    public c(ContextWindowUsageParts r2, long r3, Long r5) {
        Intrinsics.checkNotNullParameter(r2, "parts");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
