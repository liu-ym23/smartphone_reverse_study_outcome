package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public boolean a;
    public String b;
    public String c;
    public int d;
    public long e;
    public String f;
    public int g;
    public boolean h;
    public long i;
    public final Map<String, String> j;
    public IMessageBoardInfo k;
    public long l;
    public long m;

    public d() {
        this(null);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L32;
        d r7 = (d) r6;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (((r7 + r9) * 31) + this.d) * 31;
        long r11 = this.e;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        String r13 = this.f;
        if (r13 == null) goto L16;
        int r14 = r13.hashCode();
    L17:
        int r15 = (((r12 + r14) * 31) + this.g) * 31;
        boolean r16 = this.h;
        if (r16 == true) goto L21;
        r1 = r16;
    L21:
        long r17 = this.i;
        int r18 = (((r15 + r1) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        Map<String, String> r19 = this.j;
        if (r19 == null) goto L24;
        int r20 = r19.hashCode();
    L25:
        int r21 = (r18 + r20) * 31;
        IMessageBoardInfo r22 = this.k;
        if (r22 == null) goto L28;
        r5 = r22.hashCode();
    L28:
        int r23 = (r21 + r5) * 31;
        long r24 = this.l;
        int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        long r26 = this.m;
        return r25 + ((int) ((r26 >>> 32) ^ r26));
    L24:
        r20 = 0;
        goto L25
    L16:
        r14 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "AudienceLogParams(isAutoApproved=" + this.a + ", connectionType=" + this.b + ", fromUserId=" + this.c + ", applySource=" + this.d + ", roomId=" + this.e + ", anchorId=" + this.f + ", initLinkType=" + this.g + ", isLinkMicQuickInvite=" + this.h + ", talkDuration=" + this.i + ", rechargeParam=" + this.j + ", messageBoardInfo=" + this.k + ", waitTime=" + this.l + ", watchDuration=" + this.m + ")";
    }

    public d(Object r6) {
        LinkedHashMap r7 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter("apply", "connectionType");
        Intrinsics.checkNotNullParameter("0", "fromUserId");
        Intrinsics.checkNotNullParameter("0", "anchorId");
        Intrinsics.checkNotNullParameter(r7, "rechargeParam");
        this.a = false;
        this.b = "apply";
        this.c = "0";
        this.d = 0;
        this.e = 0;
        this.f = "0";
        this.g = 2;
        this.h = false;
        this.i = 0;
        this.j = r7;
        this.k = null;
        this.l = 0;
        this.m = 0;
    }
}
