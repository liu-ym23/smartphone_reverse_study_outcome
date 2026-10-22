package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$o0 implements s {
    private final e key;
    private final long now;
    private final long operationId;
    private final String ownerId;
    private final boolean success;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$o0) == true) goto L8;
        return false;
    L8:
        s$o0 r9 = (s$o0) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.operationId == r9.operationId) goto L18;
        return false;
    L18:
        if (this.success == r9.success) goto L21;
        return false;
    L21:
        if (this.now == r9.now) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
        long r1 = this.operationId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.success == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        long r5 = this.now;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "WifiEnableResult(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", success=" + this.success + ", now=" + this.now + ')';
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

    public final boolean e() {
        return this.success;
    }

    public s$o0(e r2, String r3, long r4, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        this.key = r2;
        this.ownerId = r3;
        this.operationId = r4;
        this.success = r6;
        this.now = r7;
    }
}
