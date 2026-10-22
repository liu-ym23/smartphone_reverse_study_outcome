package com.larus.voice_setting.voice.utils;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.utils.OpenBotHelper$findOrCreateConversationId$2", f = "OpenBotHelper.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
final class OpenBotHelper$findOrCreateConversationId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ String $conversationId;
    int label;

    public OpenBotHelper$findOrCreateConversationId$2(String r1, BotModel r2, Continuation<? super OpenBotHelper$findOrCreateConversationId$2> r3) {
        this.$conversationId = r1;
        this.$botModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OpenBotHelper$findOrCreateConversationId$2(this.$conversationId, this.$botModel, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L20:
        return (String) r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (o0.d(this.$conversationId) == false) goto L16;
        OpenBotHelper r7 = OpenBotHelper.a;
        String r3 = this.$botModel.getBotId();
        if (r3 != null) goto L13;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r7.getClass();
        if (OpenBotHelper.c(r3) == true) goto L16;
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: use params [conversationId]");
        return this.$conversationId;
    L16:
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: findConversationIdByBot(" + this.$botModel.getBotId() + ')');
        OpenBotHelper r8 = OpenBotHelper.a;
        BotModel r2 = this.$botModel;
        this.label = 1;
        r6 = r8.b(r2, false, this);
        if (r6 != r0) goto L20;
        return r0;
    }
}
