package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public final PointF a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final Integer f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L18;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        PointF r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((((r2 * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
        Integer r4 = this.f;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "offset:" + this.a + ",dW:" + this.b + ",dH:" + this.c + ",aW:" + this.d + ",aH:" + this.e;
    }

    public n(PointF r2, int r3, int r4, float r5, float r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "mp4Offset");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
