package com.bytedance.badger.network;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 {
    public final AtomicInteger a;
    public final a0 b;
    public final int c;
    public final int d;
    public final Function6 e;
    public final long f;

    public p0(a0 r1, int r2, int r3, Function6 r4, long r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new AtomicInteger(r3);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L27:
        return true;
    L5:
        if ((r8 instanceof p0) == false) goto L26;
        p0 r9 = (p0) r8;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L26;
        if (this.c != r9.c) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L26;
        if (this.d != r9.d) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L26;
        if (Intrinsics.areEqual(this.e, r9.e) == false) goto L26;
        if (this.f != r9.f) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L26;
    L23:
        r10 = false;
        goto L24
    L16:
        r2 = false;
        goto L17
    L11:
        r1 = false;
    L26:
        return false;
    }

    public final int hashCode() {
        a0 r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.c) * 31) + this.d) * 31;
        Function6 r4 = this.e;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.f;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DelayedRetryTask(requestBundle=" + this.b + ", immediateRetryCount=" + this.c + ", retryCount=" + this.d + ", callback=" + this.e + ", addedTime=" + this.f + ")";
    }
}
