package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender", f = "ChatSender.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {474, 476}, m = "sendTextInternalNew", n = {"localMessageId", "content", "textTags", "ext", "status", "callback", "referenceInfo", "sendFuncChannel", "chatPageContext", "needInterrupt", "localMessageId", "content", "textTags", "ext", "status", "callback", "referenceInfo", "sendFuncChannel", "chatPageContext", "cvs", "needInterrupt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0"})
public final class ChatSender$sendTextInternalNew$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendTextInternalNew$1(ChatSender r1, Continuation<? super ChatSender$sendTextInternalNew$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r18) {
        this.result = r18;
        this.label |= Integer.MIN_VALUE;
        ChatSender r0 = this.this$0;
        int r16 = ChatSender.j;
        return r0.K(null, null, null, null, null, null, false, null, null, false, null, null, null, null, this);
    }
}
