package com.larus.bot.impl.feature.edit.feature.quota;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/feature/edit/feature/quota/BotCreateQuota;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1", f = "BotCreateQuotaInterceptor.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotCreateQuota>>, Object> {
    int label;

    public BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1(Continuation<? super BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotCreateQuota>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: CancellationException -> L15
    L13:
        return (com.larus.network.http.a) r14;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();     // Catch: CancellationException -> L15
        this.label = 1;     // Catch: CancellationException -> L15
        r14 = HttpExtKt.k("Basic", BotCreateQuota.class, "/alice/bot/get_bot_create_quota", r4, null, null, true, null, null, null, this, 944);     // Catch: CancellationException -> L15
        if (r14 != r0) goto L13;
        return r0;
    L15:
        e = move-exception;
        FLogger.a.e("BotCreateQuotaInterceptor", "[fetchQuotaInfo] canceled, " + e);
        return new f(a.a, null);
    }
}
