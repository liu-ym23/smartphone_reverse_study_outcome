package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$d implements s {
    private final e key;
    private final long now;
    private final String ownerId;
    private final int progress;
    private final int stage;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$d) == true) goto L8;
        return false;
    L8:
        s$d r9 = (s$d) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.stage == r9.stage) goto L18;
        return false;
    L18:
        if (this.progress == r9.progress) goto L21;
        return false;
    L21:
        if (this.now == r9.now) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.stage) * 31) + this.progress) * 31;
        long r1 = this.now;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "DeviceStage(key=" + this.key + ", ownerId=" + this.ownerId + ", stage=" + this.stage + ", progress=" + this.progress + ", now=" + this.now + ')';
    }

    public final e a() {
        return this.key;
    }

    public final long b() {
        return this.now;
    }

    public final String c() {
        return this.ownerId;
    }

    public final int d() {
        return this.progress;
    }

    public final int e() {
        return this.stage;
    }

    public s$d(e r2, String r3, int r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        this.key = r2;
        this.ownerId = r3;
        this.stage = r4;
        this.progress = r5;
        this.now = r6;
    }
}
