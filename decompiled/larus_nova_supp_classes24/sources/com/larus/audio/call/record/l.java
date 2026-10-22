package com.larus.audio.call.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public final CaptureBackTraceReadScene a;
    public final long b;
    public final String c;
    public final int d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "CaptureBackTraceReadRequest(scene=" + this.a + ", wantedStartTimeMs=" + this.b + ", reason=" + this.c + ", wakeupId=" + this.d + ')';
    }

    public l(CaptureBackTraceReadScene r2, long r3, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
