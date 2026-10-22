package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public final VoiceCallTraceReplyType a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "PendingReplyTraceEvent(kind=" + this.a + ", millis=" + this.b + ')';
    }

    public p(VoiceCallTraceReplyType r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        this.a = r2;
        this.b = r3;
    }
}
