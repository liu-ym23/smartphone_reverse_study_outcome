package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$y implements s {
    private final boolean debug;
    private final e key;
    private final long now;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$y) == true) goto L8;
        return false;
    L8:
        s$y r9 = (s$y) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.debug == r9.debug) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        if (this.debug == false) goto L5;
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
        return "ManualCheck(key=" + this.key + ", debug=" + this.debug + ", now=" + this.now + ')';
    }

    public final boolean a() {
        return this.debug;
    }

    public final e b() {
        return this.key;
    }

    public s$y(e r2, boolean r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.debug = r3;
        this.now = r4;
    }
}
