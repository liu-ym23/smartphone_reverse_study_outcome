package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$z implements s {
    private final boolean debug;
    private final e key;
    private final long now;
    private final boolean onlyWifi;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$z) == true) goto L8;
        return false;
    L8:
        s$z r9 = (s$z) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.debug == r9.debug) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L18;
        return false;
    L18:
        if (this.onlyWifi == r9.onlyWifi) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        int r2 = 1231;
        if (this.debug == false) goto L5;
        int r1 = 1231;
    L6:
        long r4 = this.now;
        int r3 = (((r0 + r1) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (this.onlyWifi == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManualDownload(key=" + this.key + ", debug=" + this.debug + ", now=" + this.now + ", onlyWifi=" + this.onlyWifi + ')';
    }

    public final boolean a() {
        return this.debug;
    }

    public final e b() {
        return this.key;
    }

    public final boolean c() {
        return this.onlyWifi;
    }

    public s$z(e r2, boolean r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.debug = r3;
        this.now = r4;
        this.onlyWifi = r6;
    }
}
