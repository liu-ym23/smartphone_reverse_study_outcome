package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H&¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/list/ChatMessageListUpdateObserver;", "", "onMessageListChanged", "", "sourceKey", "", "messageListProvider", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface ChatMessageListUpdateObserver {
    void b(String r1, td8.g r2);
}
