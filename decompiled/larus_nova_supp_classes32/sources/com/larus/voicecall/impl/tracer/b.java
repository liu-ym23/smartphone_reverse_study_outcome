package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final int a;
    public final long b;
    public final Boolean c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Boolean r3 = this.c;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "CallRoundTraceEvent(eventType=" + this.a + ", eventTimeMillis=" + this.b + ", isTtsPlayFinished=" + this.c + ')';
    }

    public b(int r1, long r2, Boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
