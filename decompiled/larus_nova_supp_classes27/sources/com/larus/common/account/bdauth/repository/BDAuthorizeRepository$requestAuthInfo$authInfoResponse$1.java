package com.larus.common.account.bdauth.repository;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/sdk/account/bdplatform/model/AuthInfoResponseV2;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1", f = "BDAuthorizeRepository.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
public final class BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super za7.c>, Object> {
    final /* synthetic */ fb7.c $request;
    int label;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1(BDAuthorizeRepository r1, fb7.c r2, Continuation<? super BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super za7.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        vz8.a r5 = this.this$0.b;
        fb7.c r2 = this.$request;
        this.label = 1;
        r4 = r5.a(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
