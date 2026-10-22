package ch0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public final String a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L16;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (((((r2 + r5) * 31) + this.c) * 31) + this.d) * 31;
        boolean r7 = this.e;
        if (r7 == true) goto L14;
        r4 = r7;
    L14:
        return r6 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "SeiLinkerInfo(interactId=" + this.a + ", isTalking=" + this.b + ", mediaType=" + this.c + ", positionOnSei=" + this.d + ", isVisible=" + this.e + ")";
    }

    public j(String r2, boolean r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static j a(j r5, boolean r6, int r7, int r8, boolean r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        String r0 = r5.a;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = r5.b;
    L9:
        boolean r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        r7 = r5.c;
    L12:
        int r2 = r7;
        if ((r10 & 8) == 0) goto L15;
        r8 = r5.d;
    L15:
        int r3 = r8;
        if ((r10 & 16) == 0) goto L18;
        r9 = r5.e;
    L18:
        Intrinsics.checkNotNullParameter(r0, "interactId");
        String r11 = r0;
        return new j(r11, r1, r2, r3, r9);
    L5:
        r0 = null;
        goto L7
    }
}
