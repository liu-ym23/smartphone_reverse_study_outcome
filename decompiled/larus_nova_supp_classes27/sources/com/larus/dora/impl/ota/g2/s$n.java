package com.larus.dora.impl.ota.g2;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$n implements s {
    private final e key;
    private final OtaMode mode;
    private final long now;
    private final String traceId;
    private final Trigger trigger;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$n) == true) goto L8;
        return false;
    L8:
        s$n r9 = (s$n) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.trigger == r9.trigger) goto L15;
        return false;
    L15:
        if (this.mode == r9.mode) goto L18;
        return false;
    L18:
        if (this.now == r9.now) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceId, r9.traceId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.key.hashCode() * 31) + this.trigger.hashCode()) * 31) + this.mode.hashCode()) * 31;
        long r1 = this.now;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.traceId.hashCode();
    }

    public final String toString() {
        return "EvaluatePredownload(key=" + this.key + ", trigger=" + this.trigger + ", mode=" + this.mode + ", now=" + this.now + ", traceId=" + this.traceId + ')';
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
        return this.traceId;
    }

    public final Trigger e() {
        return this.trigger;
    }

    public s$n(e r2, Trigger r3, OtaMode r4, long r5, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = OtaMode.SILENT_G2;
    L6:
        if ((r7 & 16) == 0) goto L8;
        String r8 = UUID.randomUUID().toString();
    L9:
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "trigger");
        Intrinsics.checkNotNullParameter(r4, "mode");
        Intrinsics.checkNotNullParameter(r8, "traceId");
        this.key = r2;
        this.trigger = r3;
        this.mode = r4;
        this.now = r5;
        this.traceId = r8;
        return;
    L8:
        r8 = null;
        goto L9
    }
}
