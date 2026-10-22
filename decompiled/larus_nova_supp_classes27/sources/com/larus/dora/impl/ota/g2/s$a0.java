package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$a0 implements s {
    private final boolean debug;
    private final e key;
    private final long manualRearmDelayMs;
    private final long now;
    private final String sessionId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$a0) == true) goto L8;
        return false;
    L8:
        s$a0 r9 = (s$a0) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.now == r9.now) goto L15;
        return false;
    L15:
        if (this.debug == r9.debug) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L21;
        return false;
    L21:
        if (this.manualRearmDelayMs == r9.manualRearmDelayMs) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.now;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.debug == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (((r2 + r3) * 31) + this.sessionId.hashCode()) * 31;
        long r5 = this.manualRearmDelayMs;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManualPageEntered(key=" + this.key + ", now=" + this.now + ", debug=" + this.debug + ", sessionId=" + this.sessionId + ", manualRearmDelayMs=" + this.manualRearmDelayMs + ')';
    }

    public final boolean a() {
        return this.debug;
    }

    public final e b() {
        return this.key;
    }

    public final long c() {
        return this.manualRearmDelayMs;
    }

    public final long d() {
        return this.now;
    }

    public final String e() {
        return this.sessionId;
    }

    public s$a0(e r2, long r3, boolean r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r6, "sessionId");
        this.key = r2;
        this.now = r3;
        this.debug = r5;
        this.sessionId = r6;
        this.manualRearmDelayMs = r7;
    }
}
