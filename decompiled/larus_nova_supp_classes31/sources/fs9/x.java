package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public final int a;
    public final String b;
    public final String c;
    public final Integer d;
    public final String e;
    public final String f;
    public final Integer g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
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
        Integer r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.g;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
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
        return "RequestCreationGroupData(pageSize=" + this.a + ", visitId=" + this.b + ", cursor=" + this.c + ", privateStatus=" + this.d + ", downgradeSource=" + this.e + ", visitLarkId=" + this.f + ", from=" + this.g + ')';
    }

    public x(int r3, String r4, String r5, Integer r6, String r7, String r8, Integer r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = "";
    L9:
        if ((r10 & 16) == 0) goto L12;
        r7 = null;
    L12:
        if ((r10 & 32) == 0) goto L15;
        r8 = null;
    L15:
        if ((r10 & 64) == 0) goto L17;
        r9 = 0;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
