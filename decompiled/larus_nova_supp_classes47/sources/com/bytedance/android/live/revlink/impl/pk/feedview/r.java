package com.bytedance.android.live.revlink.impl.pk.feedview;

import com.bytedance.android.livesdk.link.model.f4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public f4 a;
    public Boolean b;
    public f4 c;
    public Boolean d;
    public Boolean e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L16;
        r r4 = (r) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        f4 r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        f4 r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Boolean r14 = this.e;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedPropCardData(leftEffectInfo=" + this.a + ", leftPropCardShowing=" + this.b + ", rightEffectInfo=" + this.c + ", rightPropCardShowing=" + this.d + ", isSelf=" + this.e + ")";
    }

    public r(Boolean r2, Boolean r3, Boolean r4) {
        this.a = null;
        this.b = r2;
        this.c = null;
        this.d = r3;
        this.e = r4;
    }
}
