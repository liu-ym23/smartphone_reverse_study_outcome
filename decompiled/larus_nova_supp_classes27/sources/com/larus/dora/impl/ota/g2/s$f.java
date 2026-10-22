package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$f implements s {
    private final Integer downloadId;
    private final e key;
    private final long now;
    private final long operationId;
    private final FailureReason reason;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$f) == true) goto L8;
        return false;
    L8:
        s$f r9 = (s$f) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L15;
        return false;
    L15:
        if (this.reason == r9.reason) goto L18;
        return false;
    L18:
        if (this.now == r9.now) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.downloadId, r9.downloadId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.operationId;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.reason.hashCode()) * 31;
        long r3 = this.now;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Integer r5 = this.downloadId;
        if (r5 != null) goto L5;
        int r6 = 0;
    L7:
        return r4 + r6;
    L5:
        r6 = r5.hashCode();
        goto L7
    }

    public final String toString() {
        return "DownloadFailed(key=" + this.key + ", operationId=" + this.operationId + ", reason=" + this.reason + ", now=" + this.now + ", downloadId=" + this.downloadId + ')';
    }

    public final Integer a() {
        return this.downloadId;
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

    public final FailureReason e() {
        return this.reason;
    }

    public s$f(e r2, long r3, FailureReason r5, long r6, Integer r8) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.key = r2;
        this.operationId = r3;
        this.reason = r5;
        this.now = r6;
        this.downloadId = r8;
    }
}
