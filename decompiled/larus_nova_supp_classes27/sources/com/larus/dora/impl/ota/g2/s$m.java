package com.larus.dora.impl.ota.g2;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$m implements s {
    private final String attemptId;
    private final boolean debug;
    private final e key;
    private final OtaMode mode;
    private final long now;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$m) == true) goto L8;
        return false;
    L8:
        s$m r9 = (s$m) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.mode == r9.mode) goto L15;
        return false;
    L15:
        if (this.now == r9.now) goto L18;
        return false;
    L18:
        if (this.debug == r9.debug) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attemptId, r9.attemptId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.mode.hashCode()) * 31;
        long r1 = this.now;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.debug == false) goto L5;
        int r3 = 1231;
    L7:
        return ((r2 + r3) * 31) + this.attemptId.hashCode();
    L5:
        r3 = 1237;
        goto L7
    }

    public final String toString() {
        return "EvaluateInstall(key=" + this.key + ", mode=" + this.mode + ", now=" + this.now + ", debug=" + this.debug + ", attemptId=" + this.attemptId + ')';
    }

    public final String a() {
        return this.attemptId;
    }

    public final boolean b() {
        return this.debug;
    }

    public final e c() {
        return this.key;
    }

    public final OtaMode d() {
        return this.mode;
    }

    public final long e() {
        return this.now;
    }

    public s$m(e r2, OtaMode r3, long r4, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r3 = OtaMode.SILENT_G2;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r7 & 16) == 0) goto L11;
        String r8 = UUID.randomUUID().toString();
    L12:
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r8, "attemptId");
        this.key = r2;
        this.mode = r3;
        this.now = r4;
        this.debug = r6;
        this.attemptId = r8;
        return;
    L11:
        r8 = null;
        goto L12
    }
}
