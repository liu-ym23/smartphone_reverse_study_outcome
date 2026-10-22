package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.network.http.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$requireBotActionCard$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1042}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$requireBotActionCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ OnboardingActionCardData.CardScene $scene;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    public ChatListComponentViewModel$requireBotActionCard$1(String r1, OnboardingActionCardData.CardScene r2, ChatListComponentViewModel r3, String r4, Continuation<? super ChatListComponentViewModel$requireBotActionCard$1> r5) {
        this.$botId = r1;
        this.$scene = r2;
        this.this$0 = r3;
        this.$messageId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatListComponentViewModel$requireBotActionCard$1(this.$botId, this.$scene, this.this$0, this.$messageId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L21
    L16:
        a r9 = (a) r8;     // Catch: Throwable -> L21
        ChatListComponentViewModel r3 = this.this$0;     // Catch: Throwable -> L21
        final String r4 = this.$messageId;     // Catch: Throwable -> L21
        ChatListComponentViewModel.access$setState(r3, new r7(r4));     // Catch: Throwable -> L21
        if ((r9 instanceof com.larus.network.http.f) == false) goto L19;
        ChatListComponentViewModel.access$getOnBoardingActionCardData$p(this.this$0).put(this.$scene, new Pair(Boxing.boxBoolean(true), null));     // Catch: Throwable -> L21
        FLogger.a.e("ChatListComponentViewModel", "requireBotActionCard fail");     // Catch: Throwable -> L21
    L23:
        ChatListComponentViewModel.access$setRequireBotActionCardRunning$p(this.this$0, false);
        return Unit.INSTANCE;
    L19:
        ChatListComponentViewModel.access$getOnBoardingActionCardData$p(this.this$0).put(this.$scene, new Pair(Boxing.boxBoolean(true), r9.b));     // Catch: Throwable -> L21
        goto L23
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        RepoDispatcher.a.getClass();     // Catch: Throwable -> L21
        BotRepo r10 = RepoDispatcher.g;     // Catch: Throwable -> L21
        String r5 = this.$botId;     // Catch: Throwable -> L21
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        OnboardingActionCardData.CardScene r6 = this.$scene;     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r10.getClass();     // Catch: Throwable -> L21
        BotRepo.a().getClass();     // Catch: Throwable -> L21
        r8 = BotApi.c(r5, r6, this);     // Catch: Throwable -> L21
        if (r8 != r1) goto L16;
        return r1;
    L21:
        th = move-exception;
        FLogger.a.e("ChatListComponentViewModel", "requireBotActionCard err. msg=" + th.getMessage());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ChatListComponentViewModel.access$setRequireBotActionCardRunning$p(this.this$0, false);
        throw th;
    }
}
