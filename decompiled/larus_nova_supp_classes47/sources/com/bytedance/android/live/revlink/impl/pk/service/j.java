package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.live.revlink.impl.jsb.f0;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.j8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final b0 e;
    public final f41.a f;
    public final String g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L20;
        j r4 = (j) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.d) * 31;
        b0 r8 = this.e;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        f41.a r12 = this.f;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r10 + r13) * 31;
        String r15 = this.g;
        if (r15 == null) goto L22;
        r2 = r15.hashCode();
    L22:
        return r14 + r2;
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
        return "StartAutoMatchParams(matchType=" + this.a + ", activityType=" + this.b + ", source=" + this.c + ", matchStyleType=" + this.d + ", autoMatchInfo=" + this.e + ", jsbInvitePkCallback=" + this.f + ", gameAppId=" + this.g + ")";
    }

    public j(int r2, String r3, String r4, int r5, j8 r6, f0 r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "activityType");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r6, "autoMatchInfo");
        Intrinsics.checkNotNullParameter(r7, "jsbInvitePkCallback");
        Intrinsics.checkNotNullParameter(r8, "gameAppId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
