package com.larus.bmhome.chat.trace;

import com.larus.bmhome.chat.api.IAiChatTraceService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016JB\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/trace/AiChatTraceImpl;", "Lcom/larus/bmhome/chat/api/IAiChatTraceService;", "<init>", "()V", "onEnterConversationPage", "", "onCreateNewBot", "pageName", "", "enterMethod", "createWay", "creationId", "reportConversationItemShow", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "index", "", "currentPage", "previousPage", "recommendFrom", "docEnterFrom", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiChatTraceImpl implements IAiChatTraceService {
    public AiChatTraceImpl() {
    }

    public final void a(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter("bot_list_profile", "pageName");
        Intrinsics.checkNotNullParameter(r11, "enterMethod");
        ChatControlTrace r1 = ChatControlTrace.b;
        tx9.c0.l("bot_list_profile", null, null, r11, r12, r13, null, null, null, 1933);
    }

    public final void b(wh8.a r1, int r2, String r3, String r4, String r5) {
        h0.a(r1, r2, "chat_list", r3, r4);
    }
}
