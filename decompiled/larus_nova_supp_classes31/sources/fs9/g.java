package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final String a;
    public final long b;
    public final long c;
    public final int d;
    public final h e;
    public final ic8.r f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        h r5 = this.e;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (r4 + r7) * 31;
        ic8.r r9 = this.f;
        if (r9 == null) goto L11;
        r6 = r9.hashCode();
    L11:
        return r8 + r6;
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoImageEditInitParams(imageUrl=" + this.a + ", imageWidth=" + this.b + ", imageHeight=" + this.c + ", imageBeautifyId=" + this.d + ", trackParams=" + this.e + ", driveInfo=" + this.f + ')';
    }

    public g(String r3, long r4, long r6, int r8, h r9, ic8.r r10, int r11) {
        if ((r11 & 16) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 32) == 0) goto L8;
        r10 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "imageUrl");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
        this.f = r10;
    }
}
