package com.larus.e_commerce.api;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.api.ECommerceRouterInterceptor$handleSaasSharePanel$1", f = "ECommerceRouterInterceptor.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
final class ECommerceRouterInterceptor$handleSaasSharePanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ECommerceRouterInterceptor this$0;

    public ECommerceRouterInterceptor$handleSaasSharePanel$1(ECommerceRouterInterceptor r1, Context r2, Uri r3, Continuation<? super ECommerceRouterInterceptor$handleSaasSharePanel$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$uri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ECommerceRouterInterceptor$handleSaasSharePanel$1(this.this$0, this.$context, this.$uri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ECommerceRouterInterceptor r6 = this.this$0;
        Context r2 = this.$context;
        Uri r3 = this.$uri;
        this.label = 1;
        if (ECommerceRouterInterceptor.c(r6, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
