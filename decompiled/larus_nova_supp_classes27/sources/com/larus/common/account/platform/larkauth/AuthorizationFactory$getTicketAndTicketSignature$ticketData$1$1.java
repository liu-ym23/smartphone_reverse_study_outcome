package com.larus.common.account.platform.larkauth;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dpop/DPoPTicketData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1", f = "AuthorizationFactory.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
final class AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.dpop.f>, Object> {
    final /* synthetic */ String $authorization;
    final /* synthetic */ com.bytedance.dpop.c $generator;
    final /* synthetic */ String $url;
    int label;

    public AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1(com.bytedance.dpop.c r1, String r2, String r3, Continuation<? super AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1> r4) {
        this.$generator = r1;
        this.$authorization = r2;
        this.$url = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1(this.$generator, this.$authorization, this.$url, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.bytedance.dpop.f> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L12:
        if (Result.isFailure-impl(r6) == false) goto L15;
        return null;
    L15:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.bytedance.dpop.e r7 = new com.bytedance.dpop.e(this.$generator);
        String r2 = this.$authorization;
        String r3 = this.$url;
        this.label = 1;
        r6 = r7.c(r2, r3);
        if (r6 != r0) goto L12;
        return r0;
    }
}
