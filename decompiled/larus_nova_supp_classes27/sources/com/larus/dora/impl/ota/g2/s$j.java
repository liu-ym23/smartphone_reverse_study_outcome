package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$j implements s {
    private final long bytes;
    private final e key;
    private final long now;
    private final long operationId;
    private final boolean sufficient;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$j) == true) goto L8;
        return false;
    L8:
        s$j r9 = (s$j) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L15;
        return false;
    L15:
        if (this.bytes == r9.bytes) goto L18;
        return false;
    L18:
        if (this.sufficient == r9.sufficient) goto L21;
        return false;
    L21:
        if (this.now == r9.now) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.operationId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.bytes;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.sufficient == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r4 + r5) * 31;
        long r7 = this.now;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "DownloadSpaceChecked(key=" + this.key + ", operationId=" + this.operationId + ", bytes=" + this.bytes + ", sufficient=" + this.sufficient + ", now=" + this.now + ')';
    }

    public final e a() {
        return this.key;
    }

    public final long b() {
        return this.operationId;
    }

    public final boolean c() {
        return this.sufficient;
    }

    public s$j(e r2, long r3, long r5, boolean r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.operationId = r3;
        this.bytes = r5;
        this.sufficient = r7;
        this.now = r8;
    }
}
