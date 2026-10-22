package ah;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final int a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L18;
        d r11 = (d) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.c;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.d;
        ?? r17 = r16;
        if (r16 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r15 + r17) * 31;
        String r19 = this.e;
        if (r19 == null) goto L16;
        int r20 = r19.hashCode();
    L17:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f;
        if (r22 == null) goto L21;
        r10 = r22.hashCode();
    L21:
        return r21 + r10;
    L16:
        r20 = 0;
        goto L17
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "ECOpenShopEvent(tab=" + this.a + ", productTabParams=" + this.b + ", productTabPassThroughApi=" + this.c + ", smoothScroll=" + this.d + ", toastMsg=" + this.e + ", scene=" + this.f + ")";
    }

    public /* synthetic */ d(int r10, String r11) {
        this(r10, r11, null, true, null, null);
    }

    public d(int r1, String r10, String r11, boolean r12, String r13, String r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
