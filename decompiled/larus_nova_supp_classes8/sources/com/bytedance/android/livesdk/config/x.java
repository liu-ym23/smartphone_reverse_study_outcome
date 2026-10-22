package com.bytedance.android.livesdk.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x {
    public final String a;
    public final int b;
    public final long c;
    public final int d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof x) == false) goto L14;
        x r7 = (x) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        long r3 = this.c;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorBwProbeResolutionResult(lastProbeResolution=" + this.a + ", probeTimes=" + this.b + ", probeTimestamp=" + this.c + ", expireTime=" + this.d + ")";
    }

    public x() {
        Intrinsics.checkNotNullParameter("", "lastProbeResolution");
        this.a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }
}
