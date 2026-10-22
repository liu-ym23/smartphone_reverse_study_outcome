package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.platform.spi.IChatTraceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/ChatTraceServiceImpl;", "Lcom/larus/platform/spi/IChatTraceService;", "<init>", "()V", "getTraceChatBaseDataConversationIdWithTopMsg", "", "getTraceBotConversationTypeWithTopMsg", "", "()Ljava/lang/Integer;", "getTraceChatBaseDataBotIdWithTopMsg", "getChatTypeWithTopMsg", "getPreviousPageWithTopMsg", "getTraceChatBaseDataBotId", "chatKey", "", "getTraceChatBaseDataBotConversationType", "(J)Ljava/lang/Integer;", "getTraceChatBaseDataConversationId", "getChatType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatTraceServiceImpl implements IChatTraceService {
    public ChatTraceServiceImpl() {
    }

    public final String b() {
        ChatControlTrace r0 = ChatControlTrace.b;
        r0.getClass();
        return r0.h(ChatControlTrace.y);
    }

    public final String d() {
        ChatControlTrace r0 = ChatControlTrace.b;
        r0.getClass();
        com.larus.bmhome.chat.trace.a r1 = r0.gc(ChatControlTrace.y);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.g;
    }

    public final String e() {
        ChatControlTrace r0 = ChatControlTrace.b;
        r0.getClass();
        com.larus.bmhome.chat.trace.a r1 = r0.gc(ChatControlTrace.y);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a;
    }

    public final Integer f() {
        ChatControlTrace r0 = ChatControlTrace.b;
        r0.getClass();
        com.larus.bmhome.chat.trace.a r1 = r0.gc(ChatControlTrace.y);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.d;
    }

    public final String a(long r2) {
        com.larus.bmhome.chat.trace.a r3 = ChatControlTrace.b.gc(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.g;
    }

    public final String c(long r2) {
        com.larus.bmhome.chat.trace.a r3 = ChatControlTrace.b.gc(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    public final Integer g(long r2) {
        com.larus.bmhome.chat.trace.a r3 = ChatControlTrace.b.gc(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.d;
    }

    public final String h(long r2) {
        return ChatControlTrace.b.h(r2);
    }
}
