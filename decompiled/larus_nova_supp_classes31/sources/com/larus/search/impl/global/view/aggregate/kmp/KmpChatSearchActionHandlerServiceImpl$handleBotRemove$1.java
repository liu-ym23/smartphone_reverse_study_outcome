package com.larus.search.impl.global.view.aggregate.kmp;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.search.impl.common.ConversationRepoManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {0, 1}, l = {312, 314}, m = "invokeSuspend", n = {"botId", "botId"}, s = {"L$0", "L$0"})
final class KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    Object L$0;
    int label;

    public KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1(RecommendBot r1, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1> r2) {
        this.$bot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1(this.$bot, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L32:
        BotStatusCacheDelegate.b.a(r2, false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L27:
        String r8 = (String) r7;
    L28:
        ConversationRepoManager r4 = ConversationRepoManager.a;
        this.L$0 = r3;
        this.label = 2;
        if (ConversationRepoManager.e(r8, r3, this) != r0) goto L31;
        return r0;
    L31:
        r2 = r3;
        goto L32
    L10:
        ResultKt.throwOnFailure(r7);
        r3 = this.$bot.o();
        if (r3 == null) goto L13;
        r8 = this.$bot.E();
        if (r8 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L23;
    L24:
        ConversationRepoManager r9 = ConversationRepoManager.a;
        this.L$0 = r3;
        this.label = 1;
        r7 = ConversationRepoManager.d(r3, this);
        if (r7 != r0) goto L27;
        return r0;
    L23:
        if (wf9.a.a(r8) == false) goto L28;
    L17:
        if (r8.length() == 0) goto L20;
        r5 = false;
        goto L21
    L13:
        return Unit.INSTANCE;
    }
}
