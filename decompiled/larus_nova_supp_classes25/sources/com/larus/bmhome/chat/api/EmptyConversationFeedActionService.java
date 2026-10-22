package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/api/EmptyConversationFeedActionService;", "Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "<init>", "()V", "getSupportedActions", "", "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "canShowAction", "", "actionType", "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", "context", "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EmptyConversationFeedActionService implements IConversationFeedActionService {
    public static final EmptyConversationFeedActionService a = null;

    static {
        a = new EmptyConversationFeedActionService();
    }

    private EmptyConversationFeedActionService() {
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final boolean a(ConversationFeedActionType r1, a r2, ConversationFeedActionScene r3) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r3, "scene");
        return false;
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final u b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return p.a;
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final List<ConversationFeedActionType> c(a r1, ConversationFeedActionScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return CollectionsKt.emptyList();
    }
}
