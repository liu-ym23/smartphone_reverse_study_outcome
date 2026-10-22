package com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;
import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.framework.larkwidget.c;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import hya.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jkb.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001e\u0010\u001e\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 \u0012\u0004\u0012\u00020!\u0018\u00010\u001fH\u0016J\f\u0010\u000f\u001a\u00060\"j\u0002`#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020%2\u0006\u0010,\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0018\u0010/\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u001a\u00105\u001a\u00020%2\u0006\u00100\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u000101H\u0016J$\u0010<\u001a\u00020%2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002030>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016J\u0010\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u000203H\u0016J \u0010D\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030E2\u000e\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030EH\u0016J\b\u0010G\u001a\u00020HH$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006J"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/BaseMessageSenderComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messengesender/IMessageSenderComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/MessageSender$IMessageSendListener;", "container", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "callbackListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messengesender/IMessageSenderComponent$IMessageSendResultCallback;", "messageSender", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/MessageSender;", "getMessageSender", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/MessageSender;", "messageSender$delegate", "Lkotlin/Lazy;", "chatWindowMessageTip", "Lcom/ss/android/lark/chat/core/api/ChatWindowMessageTip;", "getChatWindowMessageTip", "()Lcom/ss/android/lark/chat/core/api/ChatWindowMessageTip;", "chatWindowMessageTip$delegate", "messageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "getMessageListComponent", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "hasView", BuildConfig.FLAVOR, "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/IMessageSender;", "updateChat", BuildConfig.FLAVOR, "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "updateP2pChatter", "chatChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "addMessageSendResultCallback", "callback", "removeMessageSendResultCallback", "onPendingSendMsg", "onSendMsgSuccess", "preMsg", "Lcom/ss/android/lark/chat/entity/message/Message;", "messageId", BuildConfig.FLAVOR, "doMessageSendTour", "onSendMsgFailed", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onSendTerminal", "reason", "Lcom/ss/android/lark/im/sdk/core/pipeline/TerminateReason;", "preMessage", "onMsgUpdate", "key", "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", "updater", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "onAuditedFailed", "msg", "onInterceptMessageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", "params", "getMessageContentResolver", "Lcom/ss/android/lark/chat/chatwindow/chat/data/content/MessageContentResolver;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMessageSenderComponent extends ChatBaseComponent implements IMessageSenderComponent, j4b.a.c {
    public static final /* synthetic */ int p = 0;
    public final v l;
    public final CopyOnWriteArrayList<IMessageSenderComponent.a> m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public abstract MessageContentResolver E0();

    @Override // j4b.a.d
    public /* synthetic */ void R() {
    }

    @Override // j4b.a.d
    public void g(String r1, MessageParams r2) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
    }

    @Override // j4b.a.c
    public MessageParams.a<?, ?> j(MessageParams.a<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return r2;
    }

    public final boolean v0() {
        return false;
    }

    public final IMessageListComponent F0() {
        return (IMessageListComponent) a(IMessageListComponent.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent
    public q4b.a getMessageSender() {
        return (j4b.a) this.n.getValue();
    }

    public final Map<Class<? extends c>, c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IMessageSenderComponent.class, this));
    }

    @Override // j4b.a.c
    public final void o() {
        IMessageListComponent r0 = F0();
        if (r0 == null) goto L6;
        r0.N3();
        return;
    }

    public BaseMessageSenderComponent(v r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.l = r2;
        this.m = new CopyOnWriteArrayList();
        this.n = LazyKt.lazy(new BaseMessageSenderComponent$messageSender$2(this));
        this.o = LazyKt.lazy(BaseMessageSenderComponent$chatWindowMessageTip$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent
    public void VK(ChatChatter r2) {
        ((j4b.a) this.n.getValue()).f = r2;
    }

    @Override // j4b.a.c
    public final void onAuditedFailed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        IMessageListComponent r0 = F0();
        if (r0 == null) goto L6;
        r0.onAuditedFailed(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent
    public void updateChat(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        j4b.a r1 = (j4b.a) this.n.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "chat");
        r1.e = r3;
    }

    @Override // j4b.a.c
    public final void b(final Message r5, final String r6) {
        Intrinsics.checkNotNullParameter(r5, "preMsg");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Log.i(TitlebarViewModel.LOG_TAG, "send msg success: " + r6 + ", " + r5);
        IMessageListComponent r0 = F0();
        if (r0 == null) goto L5;
        r0.updateMsg(new BasePageStore.e(r5.getcId()), new b7c.a(SendStatus.SUCCESS));
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new BaseMessageSenderComponent$doMessageSendTour$1(this, r6, r5));
        Iterator<IMessageSenderComponent.a> r7 = this.m.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r7.next().a();
        goto L7
    }

    @Override // j4b.a.c
    public void g0(Message r3, ErrorResult r4) {
        Intrinsics.checkNotNullParameter(r3, "preMsg");
        IMessageListComponent r5 = F0();
        if (r5 == null) goto L5;
        r5.updateMsg(new BasePageStore.e(r3.getcId()), new b7c.a(SendStatus.FAIL));
    L5:
        Iterator<IMessageSenderComponent.a> r6 = this.m.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r6.next().c();
        goto L7
    }

    @Override // j4b.a.c
    public final void h0(b r2, com.ss.android.lark.chatbase.model.c.b r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "updater");
        IMessageListComponent r0 = F0();
        if (r0 == null) goto L6;
        r0.updateMsg(r2, r3);
        return;
    }

    @Override // j4b.a.c
    public final void q0(e r1, Message r2) {
        Intrinsics.checkNotNullParameter(r1, "reason");
        Iterator<IMessageSenderComponent.a> r3 = this.m.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().b();
        goto L4
    }
}
