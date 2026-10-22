package com.larus.platform;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.tencent.open.log.TraceLevel;
import ic8.w;
import java.util.Map;
import kotlin.Metadata;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001(J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J:\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\nH&J:\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\b\u0002\u0010\b\u001a\u00020\u0005H&JD\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\b\u0002\u0010\b\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0002\u0010 JB\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005H&¨\u0006)"}, d2 = {"Lcom/larus/platform/IFlowMessageService;", "", "sendMessage", "", "cvsId", "", "strategy", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "scene", "callback", "Lcom/larus/im/callback/IIMCallback;", "Lcom/larus/im/bean/message/Message;", "batchSendMessage", "strategies", "", "reSendMessageThroughModify", "messageId", "isQuestion", "", "extras", "", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isQuestionShouldRemainInModify", "localMessageId", "getRemainInModifyQuestionLocalId", "isMessageReAnswerInModify", "markMessageReAnswerInModify", "toMessageRequest", "Lcom/larus/im/bean/message/MessageRequest;", "messageStatusLocal", "", "(Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageRequest;", "toMessageRequestV2FromBlockJson", "Lcom/larus/im/bean/message/MessageRequestV2;", "requests", "Lcom/larus/platform/model/BlockJsonMessageRequestItem;", "botId", "localConversationId", "localOnBoardingMessageId", "SendResultListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IFlowMessageService {
    boolean a(String r1);

    void b(String r1);

    f0 c(w r1, String r2, Integer r3);

    void d(String r1, boolean r2, Map<String, String> r3, String r4, ChatPageContext r5);

    String e();

    boolean f(String r1);

    void g(String r1, boolean r2, Map<String, String> r3, String r4);
}
