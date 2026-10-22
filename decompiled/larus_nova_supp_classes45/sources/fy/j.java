package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final String e;
    public final String f;
    public final Boolean g;
    public final Integer h;
    public final a i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof j) == false) goto L24;
        j r7 = (j) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
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
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L9;
        int r11 = r9.hashCode();
    L10:
        int r12 = (r8 + r11) * 31;
        Boolean r13 = this.g;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.h;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (r15 + r17) * 31;
        a r19 = this.i;
        if (r19 == null) goto L22;
        r6 = r19.hashCode();
    L22:
        return r18 + r6;
    L17:
        r17 = 0;
        goto L18
    L13:
        r14 = 0;
        goto L14
    L9:
        r11 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplyParams(scene=" + this.a + ", channelId=" + this.b + ", roomId=" + this.c + ", replyStats=" + this.d + ", inviteUserId=" + this.e + ", secInviteUserId=" + this.f + ", auto=" + this.g + ", multiPkMode=" + this.h + ", anchorParams=" + this.i + ")";
    }

    public j(int r2, long r3, long r5, int r7, String r8, String r9, Boolean r11, Integer r12, a r13) {
        Intrinsics.checkNotNullParameter(r8, "inviteUserId");
        Intrinsics.checkNotNullParameter(r13, "anchorParams");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r12;
        this.i = r13;
    }
}
