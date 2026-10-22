package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingTerminateReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MmRecordingTerminateReason.values().length];
        r0[MmRecordingTerminateReason.HARDWARE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[MmRecordingTerminateReason.HARDWARE_DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[MmRecordingTerminateReason.PRIORITY_REPLACED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
