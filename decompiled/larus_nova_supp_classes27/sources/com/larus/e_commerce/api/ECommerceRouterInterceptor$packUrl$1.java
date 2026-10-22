package com.larus.e_commerce.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.api.ECommerceRouterInterceptor", f = "ECommerceRouterInterceptor.kt", i = {0}, l = {347}, m = "packUrl", n = {"longUrl"}, s = {"L$0"})
public final class ECommerceRouterInterceptor$packUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECommerceRouterInterceptor this$0;

    public ECommerceRouterInterceptor$packUrl$1(ECommerceRouterInterceptor r1, Continuation<? super ECommerceRouterInterceptor$packUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ECommerceRouterInterceptor r3 = this.this$0;
        int r0 = ECommerceRouterInterceptor.c;
        return r3.j(null, null, null, this);
    }
}
