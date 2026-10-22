package com.obric.assistant.wakeup.bluetooth_headset.impl;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    public final Object invoke(Object r4) {
        byte r5 = ((Byte) r4).byteValue();
        int r0 = BluetoothHeadSetImpl.b;
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r5)}, 1));
    }
}
