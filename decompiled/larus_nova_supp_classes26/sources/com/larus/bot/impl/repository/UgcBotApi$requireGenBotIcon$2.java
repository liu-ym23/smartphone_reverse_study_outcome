package com.larus.bot.impl.repository;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.o0;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotApi$requireGenBotIcon$2", f = "UgcBotApi.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
final class UgcBotApi$requireGenBotIcon$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotAvatarIconData>>, Object> {
    final /* synthetic */ UgcBotRepo.c $param;
    int label;

    public UgcBotApi$requireGenBotIcon$2(UgcBotRepo.c r1, Continuation<? super UgcBotApi$requireGenBotIcon$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcBotApi$requireGenBotIcon$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotAvatarIconData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L21:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        UgcBotRepo.c r5 = this.$param;
        r4.put("name", r5.a);
        if (r5.b.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L15;
        r4.put("bot_lang", r5.b);
    L15:
        if (o0.d(r5.c) == false) goto L17;
        r4.put("description", r5.c);
    L17:
        Unit r7 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", BotAvatarIconData.class, "/alice/bot/gen_icon", r4, null, null, true, null, null, null, this, 944);
        if (r14 != r0) goto L21;
        return r0;
    L11:
        r6 = false;
        goto L12
    }
}
