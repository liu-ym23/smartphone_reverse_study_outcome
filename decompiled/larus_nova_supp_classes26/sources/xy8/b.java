package xy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final boolean f;
    public final String g;
    public final String h;
    public final int i;
    public final int j;

    public b() {
        this(null, null, null, null, null, false, null, 0, 0, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.f == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        String r18 = this.g;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 == null) goto L35;
        r1 = r21.hashCode();
    L35:
        return ((((r20 + r1) * 31) + this.i) * 31) + this.j;
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
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
        return "ImageContent(uri=" + this.a + ", thumbUri=" + this.b + ", originUri=" + this.c + ", rawUri=" + this.d + ", aiCreationImage=" + this.e + ", noWatermarkSelected=" + this.f + ", noWatermarkDownloadUri=" + this.g + ", resourceKey=" + this.h + ", width=" + this.i + ", height=" + this.j + ')';
    }

    public b(String r4, String r5, String r6, String r7, Boolean r8, boolean r9, String r10, int r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r9 = false;
    L21:
        if ((r13 & 128) == 0) goto L24;
        r10 = null;
    L24:
        if ((r13 & 256) == 0) goto L27;
        r11 = 0;
    L27:
        if ((r13 & 512) == 0) goto L29;
        r12 = 0;
    L29:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = null;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
