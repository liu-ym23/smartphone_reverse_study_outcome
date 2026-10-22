package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final long a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public o() {
        this(0, null, 0, null, null, null, 127);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o) == false) goto L20;
        o r7 = (o) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
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
        long r5 = this.c;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L13;
        int r12 = r10.hashCode();
    L14:
        int r13 = (r9 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 == null) goto L22;
        r3 = r17.hashCode();
    L22:
        return r16 + r3;
    L17:
        r15 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "ReserveReplyParms(roomId=" + this.a + ", inviteUserId=" + this.b + ", inviteRoomId=" + this.c + ", clientAttachedInfo=" + this.d + ", battleAttachedInfo=" + this.e + ", reserveId=" + this.f + ", inviteOpenId=" + this.g + ")";
    }

    public o(long r5, String r7, long r8, String r10, String r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r7 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r8 = 0;
    L12:
        if ((r14 & 8) == 0) goto L14;
        String r0 = "";
    L16:
        if ((r14 & 16) == 0) goto L19;
        r10 = "";
    L19:
        if ((r14 & 32) == 0) goto L22;
        r12 = "";
    L22:
        if ((r14 & 64) == 0) goto L24;
        r13 = "";
    L24:
        Intrinsics.checkNotNullParameter(r7, "inviteUserId");
        Intrinsics.checkNotNullParameter(r0, "clientAttachedInfo");
        Intrinsics.checkNotNullParameter(r10, "battleAttachedInfo");
        Intrinsics.checkNotNullParameter(r12, "reserveId");
        Intrinsics.checkNotNullParameter(r13, "inviteOpenId");
        this.a = r5;
        this.b = r7;
        this.c = r8;
        this.d = r0;
        this.e = r10;
        this.f = r12;
        this.g = r13;
        return;
    L14:
        r0 = null;
        goto L16
    }
}
