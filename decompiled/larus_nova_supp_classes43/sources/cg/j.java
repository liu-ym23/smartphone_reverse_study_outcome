package cg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final int a;
    public final float b;
    public final boolean c;
    public final String d;
    public final boolean e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof j) == false) goto L16;
        j r11 = (j) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r11.b) == 0) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + Float.floatToIntBits(this.b)) * 31;
        boolean r1 = this.c;
        ?? r10 = 1;
        ?? r11 = r1;
        if (r1 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = (r0 + r11) * 31;
        String r13 = this.d;
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L9:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.e;
        if (r16 == true) goto L14;
        r10 = r16;
    L14:
        return r15 + r10;
    L8:
        r14 = 0;
        goto L9
    }

    public final String toString() {
        return "SpecTitleVO(groupTitleColor=" + this.a + ", groupTitleTextSize=" + this.b + ", isBold=" + this.c + ", specTitle=" + this.d + ", needMargin=" + this.e + ")";
    }

    public j(int r10, float r11, boolean r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "specTitle");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
