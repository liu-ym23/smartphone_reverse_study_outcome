package com.larus.disk.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ o(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        boolean r0 = this.a;
        com.larus.disk.api.c r4 = (com.larus.disk.api.c) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return Long.valueOf(r4.b(r0));
    }
}
