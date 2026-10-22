package com.larus.disk.impl;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function1 {
    public /* synthetic */ c() {
    }

    public final Object invoke(Object r4) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Byte) r4).byteValue())}, 1));
    }
}
