package com.larus.e_commerce.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ com.larus.e_commerce.api.h a;

    public /* synthetic */ k(com.larus.e_commerce.api.h r1) {
        this.a = r1;
    }

    public final Object invoke() {
        com.larus.e_commerce.api.h r0 = this.a;
        int r1 = ECommerceServiceImpl.d;
        r0.onInitSuccess();
        return Unit.INSTANCE;
    }
}
