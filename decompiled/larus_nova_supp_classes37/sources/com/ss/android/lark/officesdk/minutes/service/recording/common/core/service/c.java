package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MinutesForegroundService.ForegroundServiceType.values().length];
        r0[MinutesForegroundService.ForegroundServiceType.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[MinutesForegroundService.ForegroundServiceType.HARDWARE_LIVE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[MinutesForegroundService.ForegroundServiceType.DATA_SYNC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
