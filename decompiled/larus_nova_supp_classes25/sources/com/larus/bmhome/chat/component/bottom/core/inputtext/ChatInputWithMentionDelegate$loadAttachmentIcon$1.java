package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {418}, m = "loadAttachmentIcon", n = {}, s = {})
final class ChatInputWithMentionDelegate$loadAttachmentIcon$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatInputWithMentionDelegate this$0;

    public ChatInputWithMentionDelegate$loadAttachmentIcon$1(ChatInputWithMentionDelegate r1, Continuation<? super ChatInputWithMentionDelegate$loadAttachmentIcon$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatInputWithMentionDelegate.c(this.this$0, null, this);
    }
}
