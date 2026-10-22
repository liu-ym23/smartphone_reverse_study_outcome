package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$t implements s {
    private final e key;
    private final long now;
    private final boolean queuedWake;
    private final String requestId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$t) == true) goto L8;
        return false;
    L8:
        s$t r9 = (s$t) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r9.requestId) == true) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L18;
        return false;
    L18:
        if (this.queuedWake == r9.queuedWake) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.requestId.hashCode()) * 31;
        long r1 = this.now;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.queuedWake == false) goto L5;
        int r3 = 1231;
    L7:
        return r2 + r3;
    L5:
        r3 = 1237;
        goto L7
    }

    public final String toString() {
        return "LegacyDownloadRequested(key=" + this.key + ", requestId=" + this.requestId + ", now=" + this.now + ", queuedWake=" + this.queuedWake + ')';
    }

    public final e a() {
        return this.key;
    }

    public final long b() {
        return this.now;
    }

    public final boolean c() {
        return this.queuedWake;
    }

    public final String d() {
        return this.requestId;
    }

    public s$t(e r2, String r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        this.key = r2;
        this.requestId = r3;
        this.now = r4;
        this.queuedWake = r6;
    }
}
