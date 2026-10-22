package ko0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final String a;
    public final long b;
    public final int c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L12;
        f r7 = (f) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformPopupInfo(text=" + this.a + ", durationMillis=" + this.b + ", priorityLevel=" + this.c + ")";
    }

    public f(String r2, long r3, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 5000;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 1;
    L8:
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
