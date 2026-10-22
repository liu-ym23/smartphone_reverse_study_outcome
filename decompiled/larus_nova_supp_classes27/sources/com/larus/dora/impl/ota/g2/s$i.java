package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$i implements s {
    private final long bytes;
    private final e key;
    private final long now;
    private final long operationId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$i) == true) goto L8;
        return false;
    L8:
        s$i r9 = (s$i) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L15;
        return false;
    L15:
        if (this.bytes == r9.bytes) goto L18;
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
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.bytes;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.now;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    }

    public final String toString() {
        return "DownloadProgress(key=" + this.key + ", operationId=" + this.operationId + ", bytes=" + this.bytes + ", now=" + this.now + ')';
    }

    public final long a() {
        return this.bytes;
    }

    public final e b() {
        return this.key;
    }

    public final long c() {
        return this.now;
    }

    public final long d() {
        return this.operationId;
    }

    public s$i(e r2, long r3, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.operationId = r3;
        this.bytes = r5;
        this.now = r7;
    }
}
