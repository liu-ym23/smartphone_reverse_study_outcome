package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class ChatListComponent$observeStateChange$3 extends PropertyReference1Impl {
    public static final ChatListComponent$observeStateChange$3 INSTANCE = null;

    static {
        INSTANCE = new ChatListComponent$observeStateChange$3();
    }

    public ChatListComponent$observeStateChange$3() {
        super(ChatListComponentState.class, "actionCardPositionMessageId", "getActionCardPositionMessageId()Ljava/lang/String;", 0);
    }

    public Object get(Object r1) {
        return ((ChatListComponentState) r1).getActionCardPositionMessageId();
    }
}
