package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$m0 implements s {
    private final e key;
    private final long now;
    private final long operationId;
    private final String ownerId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$m0) == true) goto L8;
        return false;
    L8:
        s$m0 r9 = (s$m0) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.operationId == r9.operationId) goto L18;
        return false;
    L18:
        if (this.now == r9.now) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
        long r1 = this.operationId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.now;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "UploadStartRequested(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", now=" + this.now + ')';
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

    public final String d() {
        return this.ownerId;
    }

    public s$m0(e r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        this.key = r2;
        this.ownerId = r3;
        this.operationId = r4;
        this.now = r6;
    }
}
