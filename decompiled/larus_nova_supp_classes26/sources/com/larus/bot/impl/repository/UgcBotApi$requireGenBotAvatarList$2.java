package com.larus.bot.impl.repository;

import com.larus.bot.impl.bean.BotGenAvatarByPromptResult;
import com.larus.network.http.HttpExtKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotGenAvatarByPromptResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotApi$requireGenBotAvatarList$2", f = "UgcBotApi.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
final class UgcBotApi$requireGenBotAvatarList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotGenAvatarByPromptResult>>, Object> {
    final /* synthetic */ UgcBotRepo.b $param;
    int label;

    public UgcBotApi$requireGenBotAvatarList$2(UgcBotRepo.b r1, Continuation<? super UgcBotApi$requireGenBotAvatarList$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcBotApi$requireGenBotAvatarList$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotGenAvatarByPromptResult>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        UgcBotRepo.b r5 = this.$param;
        r4.put("prompt", r5.a);
        r4.put("num", r5.b);
        Unit r6 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", BotGenAvatarByPromptResult.class, "/alice/bot/gen_icon_by_prompt", r4, null, null, true, null, null, null, this, 944);
        if (r14 != r0) goto L12;
        return r0;
    }
}
