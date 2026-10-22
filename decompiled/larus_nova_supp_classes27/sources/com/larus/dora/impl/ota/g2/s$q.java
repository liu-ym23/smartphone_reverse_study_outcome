package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$q implements s {
    private final e key;
    private final OtaMode mode;
    private final long now;
    private final String ownerId;
    private final boolean success;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$q) == true) goto L8;
        return false;
    L8:
        s$q r9 = (s$q) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerId, r9.ownerId) == true) goto L15;
        return false;
    L15:
        if (this.mode == r9.mode) goto L18;
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
        int r0 = ((((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.mode.hashCode()) * 31;
        if (this.success == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.now;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "InstallTypeDeclared(key=" + this.key + ", ownerId=" + this.ownerId + ", mode=" + this.mode + ", success=" + this.success + ", now=" + this.now + ')';
    }

    public final e a() {
        return this.key;
    }

    public final OtaMode b() {
        return this.mode;
    }

    public final long c() {
        return this.now;
    }

    public final String d() {
        return this.ownerId;
    }

    public final boolean e() {
        return this.success;
    }

    public s$q(e r2, String r3, OtaMode r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        Intrinsics.checkNotNullParameter(r4, "mode");
        this.key = r2;
        this.ownerId = r3;
        this.mode = r4;
        this.success = r5;
        this.now = r6;
    }
}
