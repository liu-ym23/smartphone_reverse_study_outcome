package com.larus.e_commerce.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ com.larus.e_commerce.api.h a;

    public /* synthetic */ l(com.larus.e_commerce.api.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        com.larus.e_commerce.api.h r0 = this.a;
        int r1 = ECommerceServiceImpl.d;
        Intrinsics.checkNotNullParameter((Throwable) r3, "it");
        r0.a();
        return Unit.INSTANCE;
    }
}
