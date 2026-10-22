package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$k implements s {
    private final e key;
    private final long now;
    private final long operationId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$k) == true) goto L8;
        return false;
    L8:
        s$k r9 = (s$k) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.operationId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.now;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "DownloadSucceeded(key=" + this.key + ", operationId=" + this.operationId + ", now=" + this.now + ')';
    }

    public final e a() {
        return this.key;
    }

    public final long b() {
        return this.now;
    }

    public final long c() {
        return this.operationId;
    }

    public s$k(e r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.operationId = r3;
        this.now = r5;
    }
}
