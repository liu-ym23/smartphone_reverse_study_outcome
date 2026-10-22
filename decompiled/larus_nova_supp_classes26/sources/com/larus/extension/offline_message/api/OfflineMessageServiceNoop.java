package com.larus.extension.offline_message.api;

import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.im.bean.message.Message;
import java.util.List;
import k99.b;
import k99.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016Jh\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001c\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u001fJ.\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0096@¢\u0006\u0002\u0010$J,\u0010%\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010'\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010(J,\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0096@¢\u0006\u0002\u0010+J(\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101J\u001e\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105J\u0018\u0010'\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¨\u00068"}, d2 = {"Lcom/larus/extension/offline_message/api/OfflineMessageServiceNoop;", "Lcom/larus/extension/offline_message/api/IOfflineMessageService;", "<init>", "()V", "getRemoteCvsIdByLocalCvsId", "", "localCvsId", "getOfflineMessageSession", "Lcom/larus/extension/offline_message/api/model/OfflineMessageSession;", "session", "", "updateOfflineMessageSession", "", "updater", "Lkotlin/Function1;", "clearOfflineMessageSession", "registerOfflineMessageSessionListener", "listener", "Lcom/larus/extension/offline_message/api/IOfflineMessageSessionListener;", "unregisterOfflineMessageSessionListener", "handleOfflineMessages", "cvsId", "offlineMessages", "", "Lcom/larus/extension/offline_message/api/OfflineMessage;", "predicate", "Lcom/larus/im/bean/message/Message;", "", "anchorIndex", "fixLocalIndex", "scrollToMsgLocalId", "(JLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOfflineLocalMessage", "offlineMessageContext", "Lcom/larus/extension/offline_message/api/OfflineMessageContext;", "addLocalList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageByCmdUplink", "cmdUplinkList", "executeSingleChainAfterSync", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageBySendExt", "sendExtList", "(JLcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateLocalConversation", "Lcom/larus/extension/offline_message/api/LocalConversationResponse;", "botId", "query", "answer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceLocalConversation", "localConversationId", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cmdUplinkListSize", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineMessageServiceNoop implements IOfflineMessageService {
    public OfflineMessageServiceNoop() {
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localCvsId");
        return null;
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void c(long r1, ChatListComponent.f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void d(long r1) {
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object e(c r1, List<? extends b> r2, Continuation<? super List<Message>> r3) {
        return null;
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void f(long r1) {
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void h(long r1, ChatListComponent.f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object b(c r1, List r2, Continuation r3) {
        return Unit.INSTANCE;
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object g(long r1, c r3, List<? extends b> r4, Continuation<? super Unit> r5) {
        return Unit.INSTANCE;
    }
}
