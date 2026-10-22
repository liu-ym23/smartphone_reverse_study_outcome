package lw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final boolean a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;

    public a() {
        this(true, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        Integer r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r2 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L12;
        int r8 = 0;
    L13:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L16;
        int r11 = 0;
    L17:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L20;
        int r14 = 0;
    L21:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L24;
        int r17 = 0;
    L25:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 != null) goto L28;
        int r20 = 0;
    L29:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 == null) goto L34;
        r4 = r22.hashCode();
    L34:
        return r21 + r4;
    L28:
        r20 = r19.hashCode();
        goto L29
    L24:
        r17 = r16.hashCode();
        goto L25
    L20:
        r14 = r13.hashCode();
        goto L21
    L16:
        r11 = r10.hashCode();
        goto L17
    L12:
        r8 = r7.hashCode();
        goto L13
    L8:
        r5 = r3.hashCode();
        goto L9
    }

    public final String toString() {
        return "BlockQuoteConfig(enableNewQuoteStyle=" + this.a + ", blockQuoteWidth=" + this.b + ", blockQuoteColor=" + this.c + ", lineCornerRadius=" + this.d + ", blockMargin=" + this.e + ", textColorInQuote=" + this.f + ", orderedListItemColorInQuote=" + this.g + ", bulletListItemColorInQuote=" + this.h + ')';
    }

    public a(boolean r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8) {
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
