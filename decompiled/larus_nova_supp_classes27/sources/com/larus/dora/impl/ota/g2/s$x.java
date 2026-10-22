package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$x implements s {
    private final boolean active;
    private final e key;
    private final long now;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$x) == true) goto L8;
        return false;
    L8:
        s$x r9 = (s$x) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.active == r9.active) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        if (this.active == false) goto L5;
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
        return "LegacySilentChanged(key=" + this.key + ", active=" + this.active + ", now=" + this.now + ')';
    }

    public final boolean a() {
        return this.active;
    }

    public final e b() {
        return this.key;
    }

    public final long c() {
        return this.now;
    }

    public s$x(e r2, boolean r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.active = r3;
        this.now = r4;
    }
}
