package com.larus.e_commerce.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements Function0 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ q(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Function1 r0 = this.a;
        int r1 = ECommerceServiceImpl.d;
        r0.invoke(new com.larus.e_commerce.api.c(false, false, null, false));
        return Unit.INSTANCE;
    }
}
