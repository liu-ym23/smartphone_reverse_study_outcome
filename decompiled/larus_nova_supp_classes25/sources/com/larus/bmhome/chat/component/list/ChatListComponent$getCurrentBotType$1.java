package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent", f = "ChatListComponent.kt", i = {}, l = {3789}, m = "getCurrentBotType", n = {}, s = {})
final class ChatListComponent$getCurrentBotType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$getCurrentBotType$1(ChatListComponent r1, Continuation<? super ChatListComponent$getCurrentBotType$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatListComponent.z3(this.this$0, null, this);
    }
}
