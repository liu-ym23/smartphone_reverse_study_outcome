package com.larus.extension.offline_message.api;

import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import k99.b;
import k99.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0096A¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fH\u0096\u0001Jh\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u001c\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0096A¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0096\u0001J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0096A¢\u0006\u0002\u0010)J.\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u00192\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096A¢\u0006\u0002\u0010.J,\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\b\u001a\u00020\u001eH\u0096A¢\u0006\u0002\u00101J,\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096A¢\u0006\u0002\u00104J\u0019\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0096\u0001J%\u00106\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001cH\u0096\u0001¨\u00068"}, d2 = {"Lcom/larus/extension/offline_message/api/OfflineMessageServiceDelegate;", "Lcom/larus/extension/offline_message/api/IOfflineMessageService;", "<init>", "()V", "clearOfflineMessageSession", "", "session", "", "executeSingleChainAfterSync", "cmdUplinkListSize", "", "cvsId", "", "generateLocalConversation", "Lcom/larus/extension/offline_message/api/LocalConversationResponse;", "botId", "query", "answer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflineMessageSession", "Lcom/larus/extension/offline_message/api/model/OfflineMessageSession;", "getRemoteCvsIdByLocalCvsId", "localCvsId", "handleOfflineMessages", "offlineMessages", "", "Lcom/larus/extension/offline_message/api/OfflineMessage;", "predicate", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "anchorIndex", "fixLocalIndex", "scrollToMsgLocalId", "(JLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOfflineMessageSessionListener", "listener", "Lcom/larus/extension/offline_message/api/IOfflineMessageSessionListener;", "replaceLocalConversation", "localConversationId", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOfflineLocalMessage", "offlineMessageContext", "Lcom/larus/extension/offline_message/api/OfflineMessageContext;", "addLocalList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageByCmdUplink", "cmdUplinkList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageBySendExt", "sendExtList", "(JLcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterOfflineMessageSessionListener", "updateOfflineMessageSession", "updater", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineMessageServiceDelegate implements IOfflineMessageService {
    public static final OfflineMessageServiceDelegate b = null;
    public final /* synthetic */ IOfflineMessageService a;

    static {
        b = new OfflineMessageServiceDelegate();
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localCvsId");
        return this.a.a(r2);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object b(c r2, List r3, Continuation r4) {
        return this.a.b(r2, r3, r4);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void c(long r2, ChatListComponent.f r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a.c(r2, r4);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void d(long r2) {
        this.a.d(r2);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object e(c r2, List<? extends b> r3, Continuation<? super List<Message>> r4) {
        return this.a.e(r2, r3, r4);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void f(long r2) {
        this.a.f(r2);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object g(long r7, c r9, List<? extends b> r10, Continuation<? super Unit> r11) {
        return this.a.g(r7, r9, r10, r11);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void h(long r2, ChatListComponent.f r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a.h(r2, r4);
    }

    private OfflineMessageServiceDelegate() {
        IOfflineMessageService r0 = (IOfflineMessageService) ServiceManager.get().getService(IOfflineMessageService.class);
        if (r0 != null) goto L5;
        r0 = new OfflineMessageServiceNoop();
    L5:
        this.a = r0;
    }
}
