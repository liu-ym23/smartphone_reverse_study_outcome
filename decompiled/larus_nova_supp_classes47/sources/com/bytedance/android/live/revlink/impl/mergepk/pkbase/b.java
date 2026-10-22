package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final long a;
    public final x2 b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L10;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        x2 r2 = this.b;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "CompatSkinConfig(skinType=" + this.a + ", skinConfig=" + this.b + ")";
    }

    public /* synthetic */ b(int r3) {
        this(0, null);
    }

    public b(long r1, x2 r3) {
        this.a = r1;
        this.b = r3;
    }
}
