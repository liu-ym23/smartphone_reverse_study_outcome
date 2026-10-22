package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public final ReplyAudioEventType a;
    public final long b;
    public final String c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof v) == true) goto L8;
        return false;
    L8:
        v r9 = (v) r8;
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
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ReplyAudioTraceEvent(eventType=" + this.a + ", millis=" + this.b + ", endType=" + this.c + ')';
    }

    public v(ReplyAudioEventType r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r5, "endType");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
