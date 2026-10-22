package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$p implements s {
    private final long effectId;
    private final e key;
    private final long now;
    private final boolean success;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$p) == true) goto L8;
        return false;
    L8:
        s$p r9 = (s$p) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.effectId == r9.effectId) goto L15;
        return false;
    L15:
        if (this.success == r9.success) goto L18;
        return false;
    L18:
        if (this.now == r9.now) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.effectId;
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
        return "FilesCleaned(key=" + this.key + ", effectId=" + this.effectId + ", success=" + this.success + ", now=" + this.now + ')';
    }

    public final long a() {
        return this.effectId;
    }

    public final e b() {
        return this.key;
    }

    public final long c() {
        return this.now;
    }

    public final boolean d() {
        return this.success;
    }

    public s$p(e r2, long r3, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.effectId = r3;
        this.success = r5;
        this.now = r6;
    }
}
