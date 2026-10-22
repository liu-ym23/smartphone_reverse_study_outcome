package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.o9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 {
    public final long a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final o9 h;
    public final boolean i;
    public final long j;
    public final boolean k;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d0) == false) goto L30;
        d0 r7 = (d0) r6;
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
        if (this.e == r7.e) goto L16;
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
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(null, null) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        int r4 = (r1 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.e) * 31;
        String r8 = this.f;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r12 = this.g;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r10 + r13) * 31;
        o9 r15 = this.h;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.i;
        ?? r19 = 1;
        ?? r20 = r18;
        if (r18 == false) goto L25;
        r20 = 1;
    L25:
        long r22 = this.j;
        int r23 = (((r17 + r20) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31;
        boolean r24 = this.k;
        if (r24 == true) goto L30;
        r19 = r24;
    L30:
        return ((r23 + r19) * 31) + 0;
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "PkToMultiLinkParams(channelID=" + this.a + ", matchType=" + this.b + ", linkerID=" + this.c + ", guestLinkMicId=" + this.d + ", inviteType=" + this.e + ", linkConnectionType=" + this.f + ", rtcInfo=" + this.g + ", switchSceneData=" + this.h + ", isRealOrgnizer=" + this.i + ", linkStartTime=" + this.j + ", linkFromPkMultiInvite=" + this.k + ", linkPunishInfo=null)";
    }

    public d0(long r2, int r4, String r5, String r6, int r7, String r8, String r9, o9 r10, boolean r12, long r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "linkerID");
        Intrinsics.checkNotNullParameter(r6, "guestLinkMicId");
        Intrinsics.checkNotNullParameter(r8, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r10, "switchSceneData");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }
}
