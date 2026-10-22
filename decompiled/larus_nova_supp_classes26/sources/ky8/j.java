package ky8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final Boolean f;

    public j() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
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
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "OriginImageInfo(uri=" + this.a + ", url=" + this.b + ", height=" + this.c + ", width=" + this.d + ", localFilePath=" + this.e + ", aiCreationImage=" + this.f + ')';
    }

    public static j a(j r7, String r8, Integer r9, Integer r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        String r1 = r8;
        if ((r11 & 2) == 0) goto L8;
        String r2 = r7.b;
    L10:
        if ((r11 & 4) == 0) goto L12;
        r9 = r7.c;
    L12:
        Integer r3 = r9;
        if ((r11 & 8) == 0) goto L15;
        r10 = r7.d;
    L15:
        Integer r4 = r10;
        if ((r11 & 16) == 0) goto L18;
        String r5 = r7.e;
    L20:
        if ((r11 & 32) == 0) goto L22;
        Boolean r6 = r7.f;
    L23:
        r7.getClass();
        return new j(r1, r2, r3, r4, r5, r6);
    L22:
        r6 = null;
        goto L23
    L18:
        r5 = null;
        goto L20
    L8:
        r2 = null;
        goto L10
    }

    public j(String r1, String r2, Integer r3, Integer r4, String r5, Boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ j(String r7, String r8, Integer r9, Integer r10, String r11, Boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        Integer r3 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Integer r4 = null;
    L19:
        if ((r13 & 16) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r13 & 32) == 0) goto L25;
        Boolean r14 = null;
    L26:
        this(r0, r2, r3, r4, r5, r14);
        return;
    L25:
        r14 = r12;
        goto L26
    L21:
        r5 = r11;
        goto L23
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }
}
