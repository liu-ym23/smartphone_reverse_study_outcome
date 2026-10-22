package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$r implements s {
    private final e key;
    private final long now;
    private final long operationId;
    private final x4 result;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$r) == true) goto L8;
        return false;
    L8:
        s$r r9 = (s$r) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.result, r9.result) == true) goto L18;
        return false;
    L18:
        if (this.now == r9.now) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.operationId;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.result.hashCode()) * 31;
        long r3 = this.now;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "LatestChecked(key=" + this.key + ", operationId=" + this.operationId + ", result=" + this.result + ", now=" + this.now + ')';
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

    public final x4 d() {
        return this.result;
    }

    public s$r(e r2, long r3, x4 r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r5, "result");
        this.key = r2;
        this.operationId = r3;
        this.result = r5;
        this.now = r6;
    }
}
