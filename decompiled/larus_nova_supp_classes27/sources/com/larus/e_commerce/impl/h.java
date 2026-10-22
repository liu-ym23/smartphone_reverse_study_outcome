package com.larus.e_commerce.impl;

import android.content.Context;
import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ ECommerceServiceImpl a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Uri c;

    public /* synthetic */ h(ECommerceServiceImpl r1, Context r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ECommerceServiceImpl r0 = this.a;
        Context r1 = this.b;
        Uri r2 = this.c;
        int r3 = ECommerceServiceImpl.d;
        r0.c(r1, r2);
        return Unit.INSTANCE;
    }
}
