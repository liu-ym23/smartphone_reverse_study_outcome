package com.larus.dora.impl;

import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$handleAtomicFuncCallbackPayload$2", f = "DoraServiceImpl.kt", i = {}, l = {875}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$handleAtomicFuncCallbackPayload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bodyEtpBase64;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $wDid;
    int label;

    public DoraServiceImpl$handleAtomicFuncCallbackPayload$2(String r1, String r2, String r3, Continuation<? super DoraServiceImpl$handleAtomicFuncCallbackPayload$2> r4) {
        this.$productId = r1;
        this.$wDid = r2;
        this.$bodyEtpBase64 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraServiceImpl$handleAtomicFuncCallbackPayload$2(this.$productId, this.$wDid, this.$bodyEtpBase64, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L11:
        String r2 = this.$productId;
        if (Result.isSuccess-impl(r9) == false) goto L14;
        ((Boolean) r9).booleanValue();
        FLogger.a.i("DoraServiceImpl", "atomicFuncCallback: upload success, productId=" + r2);
    L14:
        String r3 = this.$productId;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L18;
        FLogger.a.e("DoraServiceImpl", "atomicFuncCallback: upload failed, productId=" + r3, r10);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        DoraNetworkApi r4 = DoraNetworkApi.a;
        String r11 = this.$productId;
        String r5 = this.$wDid;
        String r6 = this.$bodyEtpBase64;
        Intrinsics.checkNotNull(r6);
        this.label = 1;
        r9 = r4.c(r11, r5, r6, null, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
