package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s$i0 implements s {
    private final String eventId;
    private final long now;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s$i0) == true) goto L8;
        return false;
    L8:
        s$i0 r9 = (s$i0) r8;
        if (Intrinsics.areEqual(this.eventId, r9.eventId) == true) goto L12;
        return false;
    L12:
        if (this.now == r9.now) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.eventId.hashCode() * 31;
        long r1 = this.now;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "TerminalDispatched(eventId=" + this.eventId + ", now=" + this.now + ')';
    }

    public final String a() {
        return this.eventId;
    }

    public final long b() {
        return this.now;
    }

    public s$i0(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "eventId");
        this.eventId = r2;
        this.now = r3;
    }
}
