package com.larus.dora.impl.ota.g2;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i4 implements Function1 {
    public /* synthetic */ i4() {
    }

    public final Object invoke(Object r4) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Byte) r4).byteValue())}, 1));
    }
}
