package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "", "getSupportedActions", "", "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "canShowAction", "", "actionType", "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", "context", "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IConversationFeedActionService {
    boolean a(ConversationFeedActionType r1, a r2, ConversationFeedActionScene r3);

    u b(i r1);

    List<ConversationFeedActionType> c(a r1, ConversationFeedActionScene r2);
}
