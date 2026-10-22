package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016JB\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/api/AiChatTraceServiceNoop;", "Lcom/larus/bmhome/chat/api/IAiChatTraceService;", "<init>", "()V", "onEnterConversationPage", "", "onCreateNewBot", "pageName", "", "enterMethod", "createWay", "creationId", "reportConversationItemShow", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "index", "", "currentPage", "previousPage", "recommendFrom", "docEnterFrom", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AiChatTraceServiceNoop implements IAiChatTraceService {
    public AiChatTraceServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.api.IAiChatTraceService
    public final void a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter("bot_list_profile", "pageName");
        Intrinsics.checkNotNullParameter(r1, "enterMethod");
    }

    @Override // com.larus.bmhome.chat.api.IAiChatTraceService
    public final void b(a r1, int r2, String r3, String r4, String r5) {
    }
}
