package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements sc0.c {
    public final long a;
    public final String b;
    public final PkAnchorLaunchType c;
    public final v3 d;
    public final p0 e;
    public final m f;
    public final String g;

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        PkAnchorLaunchType r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        v3 r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r12 = (r8 + r10) * 31;
        p0 r13 = this.e;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r12 + r14) * 31;
        m r16 = this.f;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L26;
        r3 = r19.hashCode();
    L26:
        return r18 + r3;
    L21:
        r17 = 0;
        goto L22
    L17:
        r14 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PkAnchorLaunchContext(channelID=" + this.a + ", guestUid=" + this.b + ", launchType=" + this.c + ", clientAttachedInfo=" + this.d + ", battleAttachedInfo=" + this.e + ", layoutInfo=" + this.f + ", eventTrackingInfo=" + this.g + ")";
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L20;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
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
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public c(long r1, String r3, PkAnchorLaunchType r4, p0 r5, m r6, String r7) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
