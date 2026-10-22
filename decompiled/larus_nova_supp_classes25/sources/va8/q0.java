package va8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 {
    public final String a;
    public final String b;
    public final long c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r9 = (q0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.d;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "SearchLandingHighlightParams(targetMessageId=" + this.a + ", keyword=" + this.b + ", durationMs=" + this.c + ", sessionId=" + this.d + ')';
    }

    public q0(String r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "targetMessageId");
        Intrinsics.checkNotNullParameter(r3, "keyword");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
