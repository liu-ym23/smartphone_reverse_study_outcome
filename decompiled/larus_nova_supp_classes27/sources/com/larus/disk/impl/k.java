package com.larus.disk.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Function1 {
    public /* synthetic */ k() {
    }

    public final Object invoke(Object r3) {
        com.larus.disk.api.c r4 = (com.larus.disk.api.c) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        AppDiskManager.a.getClass();
        return Long.valueOf(AppDiskManager.l0(r4));
    }
}
