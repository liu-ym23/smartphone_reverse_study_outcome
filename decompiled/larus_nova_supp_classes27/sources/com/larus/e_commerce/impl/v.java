package com.larus.e_commerce.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v implements com.larus.e_commerce.api.h {
    public final /* synthetic */ ECommerceServiceImpl a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        ECommerceServiceImpl r0 = this.a;
        final Function0<Unit> r1 = this.c;
        Runnable r2 = new u(r1);
        int r3 = ECommerceServiceImpl.d;
        r0.e(r2);
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        ECommerceServiceImpl r0 = this.a;
        final Function0<Unit> r1 = this.b;
        Runnable r2 = new t(r1);
        int r3 = ECommerceServiceImpl.d;
        r0.e(r2);
    }

    public v(ECommerceServiceImpl r1, Function0<Unit> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
