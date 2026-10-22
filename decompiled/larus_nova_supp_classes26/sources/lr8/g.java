package lr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final int a;
    public final Integer b;
    public final String c;
    public final Boolean d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Integer r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "StepResult(stepCode=" + this.a + ", statusCode=" + this.b + ", mainUrl=" + this.c + ", isEncrypted=" + this.d + ", decryptionKey=" + this.e + ", downloadErrorCode=" + this.f + ", downloadErrorMessage=" + this.g + ", downloadFilePath=" + this.h + ", decryptFilePath=" + this.i + ')';
    }

    public g(int r3, Integer r4, String r5, Boolean r6, String r7, Integer r8, String r9, String r10, String r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r12 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r12 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r12 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r12 & 64) == 0) goto L21;
        r9 = null;
    L21:
        if ((r12 & 128) == 0) goto L24;
        r10 = null;
    L24:
        if ((r12 & 256) == 0) goto L26;
        r11 = null;
    L26:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
