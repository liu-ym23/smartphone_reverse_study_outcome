package ty1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final int a;
    public final long b;
    public final String c;
    public final a d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final long i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L24;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v24 */
    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        a r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r13 = (r9 + r11) * 31;
        String r14 = this.f;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 == null) goto L21;
        r4 = r17.hashCode();
    L21:
        int r18 = (r16 + r4) * 31;
        boolean r19 = this.h;
        ?? r20 = r19;
        if (r19 == false) goto L24;
        r20 = 1;
    L24:
        int r21 = (r18 + r20) * 31;
        long r23 = this.i;
        return r21 + ((int) (r23 ^ (r23 >>> 32)));
    L17:
        r15 = 0;
        goto L18
    L13:
        r11 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "GroupContainerItem(type=" + this.a + ", priority=" + this.b + ", containerPayload=" + this.c + ", position=" + this.d + ", url=" + this.e + ", foldUrl=" + this.f + ", horizontalUrl=" + this.g + ", canAdjustPosition=" + this.h + ", timestamp=" + this.i + ")";
    }

    public final int getType() {
        return this.a;
    }

    public b(int r2, long r3, String r5, a r6, String r7, String r8, String r9, boolean r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "containerPayload");
        Intrinsics.checkNotNullParameter(r6, "position");
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "foldUrl");
        Intrinsics.checkNotNullParameter(r9, "horizontalUrl");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
