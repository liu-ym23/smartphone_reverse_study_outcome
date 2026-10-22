package sf0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final long a;
    public final String b;
    public final String c;
    public final int d;
    public int e;
    public final int f;

    public e() {
        this(0, null, null, 0, 0, 63, 0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L18;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        return ((((((r5 + r3) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplyParams(roomId=" + this.a + ", secToUserId=" + this.b + ", toUserIdString=" + this.c + ", replyType=" + this.d + ", linkType=" + this.e + ", layout=" + this.f + ")";
    }

    public e(long r2, String r4, String r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "secToUserId");
        Intrinsics.checkNotNullParameter(r5, "toUserIdString");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ e(long r8, String r10, String r11, int r12, int r13, int r14, int r15) {
        if ((r14 & 1) == 0) goto L5;
        long r0 = 0;
    L6:
        String r3 = "";
        if ((r14 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r14 & 4) != 0) goto L14;
        r3 = r11;
    L14:
        int r5 = 0;
        if ((r14 & 8) == 0) goto L17;
        int r4 = 0;
    L19:
        if ((r14 & 16) != 0) goto L22;
        r5 = r13;
    L22:
        this(r0, r2, r3, r4, r5, 0);
        return;
    L17:
        r4 = r12;
        goto L19
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r8;
        goto L6
    }
}
