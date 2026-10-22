package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.a;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$replaceTextOnModify$1", f = "ChatSender.kt", i = {0, 0}, l = {587}, m = "invokeSuspend", n = {"content", "resolvedChatPageContext"}, s = {"L$0", "L$1"})
public final class ChatSender$replaceTextOnModify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $attachmentEntityLocalMsgId;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ Message $message;
    final /* synthetic */ boolean $needReplaceTxtAndFile;
    final /* synthetic */ AttachmentInfo $newAttachmentInfo;
    final /* synthetic */ NestedFileContent $newNestedFileContent;
    final /* synthetic */ String $replaceText;
    final /* synthetic */ Long $sendClickTimestamp;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$replaceTextOnModify$1(Message r1, String r2, ChatPageContext r3, ChatSender r4, Map<String, String> r5, boolean r6, AttachmentInfo r7, NestedFileContent r8, String r9, Long r10, Continuation<? super ChatSender$replaceTextOnModify$1> r11) {
        this.$message = r1;
        this.$replaceText = r2;
        this.$chatPageContext = r3;
        this.this$0 = r4;
        this.$extras = r5;
        this.$needReplaceTxtAndFile = r6;
        this.$newAttachmentInfo = r7;
        this.$newNestedFileContent = r8;
        this.$attachmentEntityLocalMsgId = r9;
        this.$sendClickTimestamp = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        ChatSender$replaceTextOnModify$1 r12 = new ChatSender$replaceTextOnModify$1(this.$message, this.$replaceText, this.$chatPageContext, this.this$0, this.$extras, this.$needReplaceTxtAndFile, this.$newAttachmentInfo, this.$newNestedFileContent, this.$attachmentEntityLocalMsgId, this.$sendClickTimestamp, r15);
        r12.L$0 = r14;
        return r12;
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
        ChatPageContext r2 = (ChatPageContext) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        ChatPageContext r11 = r2;
        String r4 = r3;
    L21:
        wc9.e r5 = (wc9.e) r15;
        if (r5 == null) goto L31;
        Message r6 = this.$message;
        ChatSender r16 = this.this$0;
        Map<String, String> r7 = this.$extras;
        boolean r8 = this.$needReplaceTxtAndFile;
        AttachmentInfo r9 = this.$newAttachmentInfo;
        NestedFileContent r10 = this.$newNestedFileContent;
        String r12 = this.$attachmentEntityLocalMsgId;
        Long r13 = this.$sendClickTimestamp;
        if (r6.isNewBlockType() == false) goto L26;
    L29:
        int r14 = ChatSender.j;
        com.larus.bmhome.chat.model.strategy.g0.a.c(r16.A(), r5, r6, r4, false, r7, r8, r9, r10, null, r12, r11, r13, 256);
        goto L31
    L26:
        if (a.c0(r6) == true) goto L29;
        int r17 = ChatSender.j;
        com.larus.bmhome.chat.model.strategy.g0.a.c(r16.D(), r5, r6, r4, false, r7, r8, r9, r10, null, r12, r11, r13, 256);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        String r19 = this.$message.getConversationId();
        if (r19 != null) goto L12;
        FLogger.a.e("ChatSender", "replaceTextOnModify conversationId is null. Abort");
        return Unit.INSTANCE;
    L12:
        final String r20 = StringsKt.trim(this.$replaceText).toString();
        int r21 = l0.a;
        final ChatSender r22 = this.this$0;
        Function0 r23 = new h1(r22, r20);
        ChatPageContext r24 = null;
        r4 = (String) l0.a(null, r23);
        ChatPageContext r25 = this.$chatPageContext;
        if (r25 != null) goto L15;
    L17:
        ChatSender r26 = this.this$0;
        this.L$0 = r4;
        this.L$1 = r24;
        this.label = 1;
        r15 = ChatSender.y(r26, r19, this);
        if (r15 != r0) goto L20;
        return r0;
    L20:
        r11 = r24;
        goto L21
    L15:
        if (r25.isNotEmpty() == false) goto L17;
        r24 = r25;
        goto L17
    }
}
