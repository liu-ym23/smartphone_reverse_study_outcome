package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$ChatMessageTtsPlayer", f = "ChatListComponentViewModel.kt", i = {0, 0}, l = {1733}, m = "obricCanStartTts", n = {"msg", "waitCount"}, s = {"L$0", "I$0"})
final class ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatListComponentViewModel$a this$0;

    public ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1(ChatListComponentViewModel$a r1, Continuation<? super ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return ChatListComponentViewModel$a.b(this.this$0, null, false, this);
    }
}
