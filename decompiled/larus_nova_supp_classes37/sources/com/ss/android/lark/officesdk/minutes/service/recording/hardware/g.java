package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final nvb.a a;
    public final HardwareRecordingDeviceType b;
    public final String c;
    public final Long d;
    public final HardwarePlaybackState e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        nvb.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.e.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "HardwareRecordingStartRequest(hardwareDeviceId=" + this.a + ", deviceType=" + this.b + ", sceneInstanceId=" + this.c + ", timestampSeconds=" + this.d + ", initialPlaybackState=" + this.e + ')';
    }

    public g() {
        HardwareRecordingDeviceType r0 = HardwareRecordingDeviceType.UNKNOWN;
        HardwarePlaybackState r1 = HardwarePlaybackState.OTHER;
        Intrinsics.checkNotNullParameter(r0, "deviceType");
        Intrinsics.checkNotNullParameter(r1, "initialPlaybackState");
        this.a = null;
        this.b = r0;
        this.c = null;
        this.d = null;
        this.e = r1;
    }
}
