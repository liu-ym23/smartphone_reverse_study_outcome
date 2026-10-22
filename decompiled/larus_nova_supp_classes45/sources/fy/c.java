package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final int a;
    public final long b;
    public final long c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final String h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L22;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.e;
        if (r9 == null) goto L9;
        int r11 = r9.hashCode();
    L10:
        int r12 = (((r8 + r11) * 31) + this.f) * 31;
        String r13 = this.g;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        String r16 = this.h;
        if (r16 == null) goto L18;
        r6 = r16.hashCode();
    L18:
        return r15 + r6;
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
        return "CancelParams(scene=" + this.a + ", channelId=" + this.b + ", toRoomId=" + this.c + ", toUserId=" + this.d + ", secToUserId=" + this.e + ", cancelType=" + this.f + ", reqSrc=" + this.g + ", inviteeUserIds=" + this.h + ")";
    }

    public c(int r2, long r3, long r5, String r7, String r8, int r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r7, "toUserId");
        Intrinsics.checkNotNullParameter(r8, "secToUserId");
        Intrinsics.checkNotNullParameter(r11, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r12;
    }
}
