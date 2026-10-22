package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    private boolean capabilityReady;
    private boolean deviceInfoReady;
    private boolean evaluated;
    private final long generation;
    private final e key;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r9 = (n) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (this.generation == r9.generation) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.key.hashCode() * 31;
        long r1 = this.generation;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "G2CapabilityConnection(key=" + this.key + ", generation=" + this.generation + ')';
    }

    public final boolean a() {
        return this.evaluated;
    }

    public final long b() {
        return this.generation;
    }

    public final e c() {
        return this.key;
    }

    public final Trigger e(boolean r4) {
        if (this.deviceInfoReady == false) goto L5;
        return null;
    L5:
        this.deviceInfoReady = true;
        if (this.capabilityReady == false) goto L13;
        this.evaluated = true;
        if (r4 == false) goto L10;
        Trigger r5 = Trigger.APP_FOREGROUND;
    L12:
        return r5;
    L10:
        r5 = Trigger.DEVICE_RECONNECTED;
        goto L12
    L13:
        return null;
    }

    public n(e r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.generation = r3;
    }

    public final Trigger d(boolean r4, boolean r5) {
        boolean r2 = true;
        if (this.capabilityReady == false) goto L13;
        Trigger r6 = Trigger.CONDITION_CHANGED;
        if (r4 == true) goto L7;
    L9:
        r2 = false;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r6;
    L7:
        if (this.evaluated == false) goto L9;
    L13:
        this.capabilityReady = true;
        if (this.deviceInfoReady == false) goto L23;
        this.evaluated = true;
        if (r5 == false) goto L19;
        Trigger r7 = Trigger.APP_FOREGROUND;
    L21:
        return r7;
    L19:
        r7 = Trigger.DEVICE_RECONNECTED;
        goto L21
    L23:
        return null;
    }
}
