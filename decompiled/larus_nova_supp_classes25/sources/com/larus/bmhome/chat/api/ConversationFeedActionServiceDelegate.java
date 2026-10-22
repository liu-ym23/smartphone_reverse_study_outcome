package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionServiceDelegate;", "Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "<init>", "()V", "canShowAction", "", "actionType", "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", "context", "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "getSupportedActions", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationFeedActionServiceDelegate implements IConversationFeedActionService {
    public static final ConversationFeedActionServiceDelegate b = null;
    public final /* synthetic */ IConversationFeedActionService a;

    static {
        b = new ConversationFeedActionServiceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final boolean a(ConversationFeedActionType r2, a r3, ConversationFeedActionScene r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r4, "scene");
        return this.a.a(r2, r3, r4);
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final u b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.b(r2);
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final List<ConversationFeedActionType> c(a r2, ConversationFeedActionScene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        return this.a.c(r2, r3);
    }

    private ConversationFeedActionServiceDelegate() {
        IConversationFeedActionService r0 = (IConversationFeedActionService) ServiceManager.get().getService(IConversationFeedActionService.class);
        if (r0 != null) goto L5;
        r0 = EmptyConversationFeedActionService.a;
    L5:
        this.a = r0;
    }
}
