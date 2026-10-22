package com.larus.search.impl.global.view.aggregate.kmp;

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
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
final class KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    int label;

    public KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1(RecommendBot r1, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1> r2) {
        this.$bot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1(this.$bot, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ConversationRepoManager r5 = ConversationRepoManager.a;
        RecommendBot r6 = this.$bot;
        this.label = 1;
        if (ConversationRepoManager.a(r6, this) != r0) goto L12;
        return r0;
    }
}
