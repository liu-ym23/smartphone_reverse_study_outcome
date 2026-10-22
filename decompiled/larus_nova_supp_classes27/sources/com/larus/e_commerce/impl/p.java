package com.larus.e_commerce.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ ECommerceServiceImpl a;
    public final /* synthetic */ com.larus.e_commerce.api.b b;
    public final /* synthetic */ Function3 c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ p(ECommerceServiceImpl r1, com.larus.e_commerce.api.b r2, Function3 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        ECommerceServiceImpl r0 = this.a;
        com.larus.e_commerce.api.b r1 = this.b;
        Function3 r2 = this.c;
        Function1 r3 = this.d;
        int r4 = ECommerceServiceImpl.d;
        r0.r(r1, r2, r3);
        return Unit.INSTANCE;
    }
}
