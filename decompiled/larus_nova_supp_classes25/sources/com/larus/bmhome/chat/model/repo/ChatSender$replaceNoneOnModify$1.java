package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$replaceNoneOnModify$1", f = "ChatSender.kt", i = {0}, l = {639}, m = "invokeSuspend", n = {"resolvedChatPageContext"}, s = {"L$0"})
public final class ChatSender$replaceNoneOnModify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $scene;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$replaceNoneOnModify$1(Message r1, String r2, ChatPageContext r3, ChatSender r4, Map<String, String> r5, Continuation<? super ChatSender$replaceNoneOnModify$1> r6) {
        this.$message = r1;
        this.$scene = r2;
        this.$chatPageContext = r3;
        this.this$0 = r4;
        this.$extras = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ChatSender$replaceNoneOnModify$1 r7 = new ChatSender$replaceNoneOnModify$1(this.$message, this.$scene, this.$chatPageContext, this.this$0, this.$extras, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChatPageContext r2 = (ChatPageContext) this.L$0;
        ResultKt.throwOnFailure(r15);
        ChatPageContext r11 = r2;
    L28:
        wc9.e r3 = (wc9.e) r15;
        if (r3 == null) goto L41;
        Message r4 = this.$message;
        String r9 = this.$scene;
        ChatSender r16 = this.this$0;
        Map<String, String> r5 = this.$extras;
        String r6 = ObricActionBarSendServiceDelegate.b.w(r4, r9);
        if (r6 != null) goto L33;
        r6 = r4.getContent();
    L33:
        String r7 = r6;
        if (r4.isNewBlockType() == false) goto L36;
    L39:
        int r8 = ChatSender.j;
        com.larus.bmhome.chat.model.strategy.g0.a.c(r16.A(), r3, r4, r7, true, r5, false, null, null, r9, null, r11, null, 2784);
        goto L41
    L36:
        if (a.c0(r4) == true) goto L39;
        int r10 = ChatSender.j;
        com.larus.bmhome.chat.model.strategy.g0.a.c(r16.D(), r3, r4, r7, true, r5, false, null, null, r9, null, r11, null, 2784);
    L41:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        String r18 = this.$message.getConversationId();
        if (r18 != null) goto L12;
        FLogger.a.e("ChatSender", "replaceNoneOnModify conversationId is null. Abort");
        return Unit.INSTANCE;
    L12:
        int r12 = com.larus.utils.p0.a;
        if (com.larus.utils.p0.a(this.$scene) == null) goto L18;
        Message r13 = this.$message;
        String r14 = this.$scene;
        ChatControlTrace r19 = ChatControlTrace.b;
        String r20 = r13.getLocalMessageId();
        if (r20 != null) goto L17;
        r20 = "";
    L17:
        r19.Ma(r20, r14);
    L18:
        ChatPageContext r21 = this.$chatPageContext;
        if (r21 != null) goto L21;
    L23:
        r21 = null;
    L24:
        ChatSender r22 = this.this$0;
        this.L$0 = r21;
        this.label = 1;
        r15 = ChatSender.y(r22, r18, this);
        if (r15 != r0) goto L27;
        return r0;
    L27:
        r11 = r21;
        goto L28
    L21:
        if (r21.isNotEmpty() == false) goto L23;
        goto L23
    }
}
