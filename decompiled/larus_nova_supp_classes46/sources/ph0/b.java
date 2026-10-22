package ph0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((r3 + r1) * 31) + this.c) * 31;
        boolean r6 = this.d;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RtsLinkTypeEvent(uid=" + this.a + ", interactId=" + this.b + ", linkType=" + this.c + ", forceResumeVideo=" + this.d + ")";
    }

    public b(String r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
