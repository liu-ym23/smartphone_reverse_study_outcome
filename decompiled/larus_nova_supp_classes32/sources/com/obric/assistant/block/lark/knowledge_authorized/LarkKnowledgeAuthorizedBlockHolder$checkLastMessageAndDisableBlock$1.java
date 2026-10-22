package com.obric.assistant.block.lark.knowledge_authorized;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.lark.knowledge_authorized.LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1", f = "LarkKnowledgeAuthorizedBlockHolder.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
public final class LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $blockMessage;
    int label;
    final /* synthetic */ LarkKnowledgeAuthorizedBlockHolder this$0;

    public LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1(LarkKnowledgeAuthorizedBlockHolder r1, Message r2, Continuation<? super LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1> r3) {
        this.this$0 = r1;
        this.$blockMessage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LarkKnowledgeAuthorizedBlockHolder$checkLastMessageAndDisableBlock$1(this.this$0, this.$blockMessage, r4);
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
    L14:
        Message r5 = (Message) r4;
        if (r5 == null) goto L28;
        if (Intrinsics.areEqual(r5.getReplyId(), this.$blockMessage.getReplyId()) == false) goto L25;
        Map r2 = this.$blockMessage.getExt();
        if (r2 == null) goto L21;
        String r3 = (String) r2.get("o_knowledge_ai_auth");
    L23:
        if (Intrinsics.areEqual(r3, "1") == true) goto L28;
    L21:
        r3 = null;
    L25:
        if (Intrinsics.areEqual(r5.getMessageId(), this.$blockMessage.getMessageId()) == true) goto L28;
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "is not last message, disable all buttons");
        LarkKnowledgeAuthorizedBlockHolder r6 = this.this$0;
        int r7 = LarkKnowledgeAuthorizedBlockHolder.k;
        r6.l();
        this.this$0.m();
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        LarkKnowledgeAuthorizedBlockHolder r8 = this.this$0;
        String r9 = this.$blockMessage.getConversationId();
        if (r9 != null) goto L11;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        this.label = 1;
        r4 = LarkKnowledgeAuthorizedBlockHolder.j(r8, r9, this);
        if (r4 != r0) goto L14;
        return r0;
    }
}
