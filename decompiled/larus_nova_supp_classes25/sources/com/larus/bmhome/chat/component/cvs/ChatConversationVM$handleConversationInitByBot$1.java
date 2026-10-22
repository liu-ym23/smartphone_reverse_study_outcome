package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationVM$handleConversationInitByBot$1", f = "ChatConversationVM.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationVM$handleConversationInitByBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    int label;
    final /* synthetic */ ChatConversationVM this$0;

    public ChatConversationVM$handleConversationInitByBot$1(String r1, ChatConversationVM r2, Continuation<? super ChatConversationVM$handleConversationInitByBot$1> r3) {
        this.$botId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatConversationVM$handleConversationInitByBot$1(this.$botId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        e r10 = (e) r9;
        if (r10 == null) goto L15;
        ChatConversationVM r2 = this.this$0;
        String r3 = this.$botId;
        FLogger.a.i("ChatConversationViewModel", "init by bot " + r10);
        ChatConversationVM.handleConversationIdInit$default(r2, r10.a, r3, null, false, null, 28, null);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        RepoDispatcher.a.getClass();
        ConversationRepo r11 = RepoDispatcher.f;
        String r4 = this.$botId;
        this.label = 1;
        r9 = r11.a(r4, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
