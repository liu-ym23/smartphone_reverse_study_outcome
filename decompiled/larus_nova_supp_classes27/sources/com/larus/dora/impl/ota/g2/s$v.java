package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$v implements s {
    private final e key;
    private final long now;
    private final String ownerId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$v) == true) goto L8;
        return false;
    L8:
        s$v r9 = (s$v) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
        long r1 = this.now;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "LegacyInstallReleased(key=" + this.key + ", ownerId=" + this.ownerId + ", now=" + this.now + ')';
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

    public s$v(e r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        this.key = r2;
        this.ownerId = r3;
        this.now = r4;
    }
}
