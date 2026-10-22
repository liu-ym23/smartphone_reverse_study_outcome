package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public final long a;
    public final String b;
    public final String c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof l) == false) goto L12;
        l r11 = (l) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r10 = this.b;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = (r1 + r12) * 31;
        String r14 = this.c;
        if (r14 == null) goto L10;
        r11 = r14.hashCode();
    L10:
        return r13 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public final String toString() {
        return "IMOptional(promotionSource=" + this.a + ", sourcePage=" + this.b + ", enterMethod=" + this.c + ")";
    }

    public l() {
        this(0, null, null);
    }

    public l(long r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
