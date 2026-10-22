package com.larus.platform.spi;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/spi/IChatTraceService;", "", "getTraceChatBaseDataConversationIdWithTopMsg", "", "getTraceBotConversationTypeWithTopMsg", "", "()Ljava/lang/Integer;", "getTraceChatBaseDataBotIdWithTopMsg", "getChatTypeWithTopMsg", "getPreviousPageWithTopMsg", "getTraceChatBaseDataBotId", "chatKey", "", "getTraceChatBaseDataBotConversationType", "(J)Ljava/lang/Integer;", "getTraceChatBaseDataConversationId", "getChatType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IChatTraceService {
    String a(long r1);

    String b();

    String c(long r1);

    String d();

    String e();

    Integer f();

    Integer g(long r1);

    String h(long r1);
}
