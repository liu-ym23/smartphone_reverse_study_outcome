package bn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Integer a;
    public final Float b;
    public final String c;
    public final float d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Float r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Float.floatToIntBits(this.d)) * 31;
        int r10 = 1231;
        if (this.e == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        if (this.g == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.h == true) goto L31;
        r10 = 1237;
    L31:
        return r16 + r10;
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReplyTextLoadingViewInput(textColorRes=" + this.a + ", textSize=" + this.b + ", textContent=" + this.c + ", fontScale=" + this.d + ", isImmersive=" + this.e + ", icon=" + this.f + ", needShimmer=" + this.g + ", needThreeLoading=" + this.h + ')';
    }

    public a(Integer r1, Float r2, String r3, float r4, boolean r5, String r6, boolean r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
