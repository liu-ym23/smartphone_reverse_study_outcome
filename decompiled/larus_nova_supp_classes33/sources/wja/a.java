package wja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final String b;
    public final long c;
    public final int d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "TransferableFile(base=" + this.a + ", originRelativePath=" + this.b + ", size=" + this.c + ", retryTimes=" + this.d + ", newRelativePath=" + this.e + ")";
    }

    public a(String r2, String r3, long r4, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "base");
        Intrinsics.checkNotNullParameter(r3, "originRelativePath");
        Intrinsics.checkNotNullParameter(r7, "newRelativePath");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
