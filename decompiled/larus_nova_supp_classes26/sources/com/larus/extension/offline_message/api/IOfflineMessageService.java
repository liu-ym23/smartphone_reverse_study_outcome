package com.larus.extension.offline_message.api;

import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.im.bean.message.Message;
import java.util.List;
import k99.b;
import k99.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J$\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&Jl\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u001c\u0010\u0017\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0019\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001b\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u001dJ.\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H¦@¢\u0006\u0002\u0010\"J.\u0010#\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010%\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010&J,\u0010'\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H¦@¢\u0006\u0002\u0010)J(\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010/J\u001e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H¦@¢\u0006\u0002\u00103J\u0018\u0010%\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u0003H&¨\u00066"}, d2 = {"Lcom/larus/extension/offline_message/api/IOfflineMessageService;", "", "getRemoteCvsIdByLocalCvsId", "", "localCvsId", "getOfflineMessageSession", "Lcom/larus/extension/offline_message/api/model/OfflineMessageSession;", "session", "", "updateOfflineMessageSession", "", "updater", "Lkotlin/Function1;", "clearOfflineMessageSession", "registerOfflineMessageSessionListener", "listener", "Lcom/larus/extension/offline_message/api/IOfflineMessageSessionListener;", "unregisterOfflineMessageSessionListener", "handleOfflineMessages", "cvsId", "offlineMessages", "", "Lcom/larus/extension/offline_message/api/OfflineMessage;", "predicate", "Lcom/larus/im/bean/message/Message;", "", "anchorIndex", "fixLocalIndex", "scrollToMsgLocalId", "(JLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOfflineLocalMessage", "offlineMessageContext", "Lcom/larus/extension/offline_message/api/OfflineMessageContext;", "addLocalList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageByCmdUplink", "cmdUplinkList", "executeSingleChainAfterSync", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageBySendExt", "sendExtList", "(JLcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateLocalConversation", "Lcom/larus/extension/offline_message/api/LocalConversationResponse;", "botId", "query", "answer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceLocalConversation", "localConversationId", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cmdUplinkListSize", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfflineMessageService {
    String a(String r1);

    Object b(c r1, List r2, Continuation r3);

    void c(long r1, ChatListComponent.f r3);

    void d(long r1);

    Object e(c r1, List<? extends b> r2, Continuation<? super List<Message>> r3);

    void f(long r1);

    Object g(long r1, c r3, List<? extends b> r4, Continuation<? super Unit> r5);

    void h(long r1, ChatListComponent.f r3);
}
