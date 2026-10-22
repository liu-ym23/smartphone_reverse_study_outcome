package com.larus.bot.impl.feature.edit.feature.quota;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/feature/edit/feature/quota/BotCreateQuota;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1", f = "BotCreateQuotaInterceptor.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotCreateQuota>>, Object> {
    final /* synthetic */ Deferred<com.larus.network.http.a<BotCreateQuota>> $httpJob;
    int label;

    public BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1(Deferred<? extends com.larus.network.http.a<BotCreateQuota>> r1, Continuation<? super BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1> r2) {
        this.$httpJob = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1(this.$httpJob, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotCreateQuota>> r2) {
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
        Deferred<com.larus.network.http.a<BotCreateQuota>> r5 = this.$httpJob;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
