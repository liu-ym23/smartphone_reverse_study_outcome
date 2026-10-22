package com.larus.dora.impl.bridge;

import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class DoraDeviceBridgePayloadHelper$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[GestureWakeupType.values().length];
        r0[GestureWakeupType.RADIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[GestureWakeupType.CLOSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
