package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final String b;
    public final HardwareRecordingDeviceType c;
    public final long d;
    public final HardwareRecordingSessionState e;
    public final String f;
    public final RecordingPriorityStartMode g;
    public final HardwareRecordingInterruptionReason h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        HardwareRecordingInterruptionReason r3 = this.h;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "HardwareRecordingSession(sceneInstanceId=" + this.a + ", hardwareDeviceId=" + this.b + ", deviceType=" + this.c + ", startTimestampSeconds=" + this.d + ", state=" + this.e + ", recordingId=" + this.f + ", startMode=" + this.g + ", interruptionReason=" + this.h + ')';
    }

    public static e a(e r12, HardwareRecordingSessionState r13, String r14, int r15) {
        HardwareRecordingInterruptionReason r1 = null;
        if ((r15 & 1) == 0) goto L5;
        String r3 = r12.a;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = r12.b;
    L11:
        if ((r15 & 4) == 0) goto L13;
        HardwareRecordingDeviceType r5 = r12.c;
    L15:
        if ((r15 & 8) == 0) goto L17;
        long r6 = r12.d;
    L19:
        if ((r15 & 16) == 0) goto L21;
        r13 = r12.e;
    L21:
        HardwareRecordingSessionState r8 = r13;
        if ((r15 & 32) == 0) goto L24;
        r14 = r12.f;
    L24:
        String r9 = r14;
        if ((r15 & 64) == 0) goto L27;
        RecordingPriorityStartMode r10 = r12.g;
    L29:
        if ((r15 & 128) == 0) goto L31;
        r1 = r12.h;
    L31:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r3, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r4, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r5, "deviceType");
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "recordingId");
        Intrinsics.checkNotNullParameter(r10, "startMode");
        return new e(r3, r4, r5, r6, r8, r9, r10, r1);
    L27:
        r10 = null;
        goto L29
    L17:
        r6 = 0;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public e(String r2, String r3, HardwareRecordingDeviceType r4, long r5, HardwareRecordingSessionState r7, String r8, RecordingPriorityStartMode r9, HardwareRecordingInterruptionReason r10) {
        Intrinsics.checkNotNullParameter(r2, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r3, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r4, "deviceType");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        Intrinsics.checkNotNullParameter(r9, "startMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
