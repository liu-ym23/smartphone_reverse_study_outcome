package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$b0 implements s {
    private final e key;
    private final long manualRearmDelayMs;
    private final long now;
    private final String sessionId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$b0) == true) goto L8;
        return false;
    L8:
        s$b0 r9 = (s$b0) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L18;
        return false;
    L18:
        if (this.manualRearmDelayMs == r9.manualRearmDelayMs) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.sessionId.hashCode()) * 31;
        long r1 = this.now;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.manualRearmDelayMs;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "ManualPageExited(key=" + this.key + ", sessionId=" + this.sessionId + ", now=" + this.now + ", manualRearmDelayMs=" + this.manualRearmDelayMs + ')';
    }

    public final e a() {
        return this.key;
    }

    public final long b() {
        return this.manualRearmDelayMs;
    }

    public final long c() {
        return this.now;
    }

    public final String d() {
        return this.sessionId;
    }

    public s$b0(e r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        this.key = r2;
        this.sessionId = r3;
        this.now = r4;
        this.manualRearmDelayMs = r6;
    }
}
