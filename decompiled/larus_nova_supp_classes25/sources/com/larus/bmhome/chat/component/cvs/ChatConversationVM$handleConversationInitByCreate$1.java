package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationVM$handleConversationInitByCreate$1", f = "ChatConversationVM.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationVM$handleConversationInitByCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $caseId;
    final /* synthetic */ String $caseName;
    final /* synthetic */ String $collectionId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ Function1<String, Unit> $onCreated;
    int label;
    final /* synthetic */ ChatConversationVM this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatConversationVM$handleConversationInitByCreate$1(ChatConversationVM r1, String r2, String r3, String r4, String r5, String r6, String r7, Function1<? super String, Unit> r8, Continuation<? super ChatConversationVM$handleConversationInitByCreate$1> r9) {
        this.this$0 = r1;
        this.$botId = r2;
        this.$conversationId = r3;
        this.$messageId = r4;
        this.$collectionId = r5;
        this.$caseId = r6;
        this.$caseName = r7;
        this.$onCreated = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ChatConversationVM$handleConversationInitByCreate$1(this.this$0, this.$botId, this.$conversationId, this.$messageId, this.$collectionId, this.$caseId, this.$caseName, this.$onCreated, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L11:
        e r2 = (e) r1;
        FLogger.a.i("ChatConversationViewModel", "init by create " + r2);
        if (r2 == null) goto L19;
        String r3 = r2.a;
        if (r3 == null) goto L19;
        ChatConversationVM r4 = this.this$0;
        String r6 = this.$botId;
        Function1<String, Unit> r5 = this.$onCreated;
        ChatConversationVM.handleConversationIdInit$default(r4, r3, r6, null, false, null, 28, null);
        if (r5 == null) goto L19;
        r5.invoke(r3);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        ConversationRepo r7 = ChatConversationVM.access$getConversationRepo$p(this.this$0);
        String r8 = this.$botId;
        String r9 = this.$conversationId;
        String r10 = this.$messageId;
        String r11 = this.$collectionId;
        String r13 = this.$caseId;
        String r15 = this.$caseName;
        this.label = 1;
        r1 = IConversationRepoService$a.a(r7, r8, 3, r9, r10, false, r11, r13, r15, null, this, 272);
        if (r1 != r12) goto L11;
        return r12;
    }
}
