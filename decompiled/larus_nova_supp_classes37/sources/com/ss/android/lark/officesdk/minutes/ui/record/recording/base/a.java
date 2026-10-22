package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingInterruptionReason;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingSessionState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0061a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HardwareRecordingInterruptionReason.values().length];
            r0[HardwareRecordingInterruptionReason.AUDIO_MODE_SWITCHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[HardwareRecordingInterruptionReason.MIC_IN_USE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[HardwareRecordingInterruptionReason.BLUETOOTH_DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final int a(com.ss.android.lark.officesdk.minutes.service.recording.hardware.e r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        HardwareRecordingInterruptionReason r0 = r3.h;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 == (-1)) goto L18;
        if (r1 != 1) goto L10;
        return 2131893750;
    L10:
        if (r1 != 2) goto L12;
    L19:
        return 2131893901;
    L12:
        if (r1 != 3) goto L15;
    L20:
        return 2131893772;
    L15:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r3.e != HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L20;
    L5:
        r1 = C0061a.a[r0.ordinal()];
        goto L6
    }
}
