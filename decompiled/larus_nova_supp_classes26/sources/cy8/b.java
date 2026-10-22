package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Integer a;
    public final String b;
    public final Integer c;
    public final boolean d;
    public final a e;
    public final String f;

    public b() {
        this(null, null, null, false, null, null);
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
        if (this.d == r6.d) goto L21;
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
        Integer r0 = this.a;
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
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        a r12 = this.e;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 == null) goto L27;
        r1 = r15.hashCode();
    L27:
        return r14 + r1;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
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
        return "CanvasBlockModel(blockType=" + this.a + ", blockId=" + this.b + ", idx=" + this.c + ", isFinish=" + this.d + ", content=" + this.e + ", logId=" + this.f + ')';
    }

    public b(Integer r1, String r2, Integer r3, boolean r4, a r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
