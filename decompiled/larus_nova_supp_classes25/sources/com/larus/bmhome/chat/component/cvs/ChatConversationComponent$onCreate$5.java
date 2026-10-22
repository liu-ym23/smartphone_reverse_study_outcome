package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ChatConversationComponent$onCreate$5 extends PropertyReference1Impl {
    public static final ChatConversationComponent$onCreate$5 INSTANCE = null;

    static {
        INSTANCE = new ChatConversationComponent$onCreate$5();
    }

    public ChatConversationComponent$onCreate$5() {
        super(ChatConversationVMState.class, "conversation", "getConversation()Lcom/larus/im/bean/conversation/Conversation;", 0);
    }

    public Object get(Object r1) {
        return ((ChatConversationVMState) r1).getConversation();
    }
}
