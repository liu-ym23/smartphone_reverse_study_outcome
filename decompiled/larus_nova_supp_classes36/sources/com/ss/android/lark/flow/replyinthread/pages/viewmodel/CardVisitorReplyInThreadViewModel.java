package com.ss.android.lark.flow.replyinthread.pages.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.b0;
import com.ss.android.lark.replyinthread.pages.f;
import fxa.b;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u000202H\u0016J\n\u00103\u001a\u0004\u0018\u00010\"H\u0016J\b\u00104\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/CardVisitorReplyInThreadViewModel;", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel;", "appContext", "Landroid/content/Context;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "kotlin.jvm.PlatformType", "getInitializeStateLiveData", "originMergeForwardMessageId", "getOriginMergeForwardMessageId", "setOriginMergeForwardMessageId", "mergeForwardMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMergeForwardMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMergeForwardMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "onCreate", "", "page", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "handleInitData", "", "loadChatInitData", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "showChatName", "getMsgListRepoFactory", "Lcom/ss/android/lark/biz/im/api/MessageListRepositoryFactory;", "getParentMergeForwardMessage", "getOriginMergeForwardId", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CardVisitorReplyInThreadViewModel extends FlowBaseReplyInThreadViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String LOG_TAG = "FlowReplyInThreadViewModel";
    private final Context appContext;
    private final MutableLiveData<Chat> chat;
    private final v chatAppContainer;
    private final b chatBundle;
    private String chatId;
    private final MutableLiveData<i7b.a> initData;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    public Message mergeForwardMessage;
    private String originMergeForwardMessageId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void loadChatInitData(ChatWindowOpenViewModel.b r1) {
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean showChatName() {
        return false;
    }

    public final Message getMergeForwardMessage() {
        Message r0 = this.mergeForwardMessage;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mergeForwardMessage");
        return null;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public z0 getMsgListRepoFactory() {
        return new com.ss.android.lark.flow.replyinthread.pages.repo.a(this);
    }

    private final boolean handleInitData() {
        MergeForwardContent r0 = getMergeForwardMessage().getContent();
        if (r0.isFromPrivateTopic() == true) goto L7;
        Log.e(LOG_TAG, "not from privateTopic, origin merge message id " + this.originMergeForwardMessageId);
        return false;
    L7:
        if (r0.getOriginChat() != null) goto L10;
        Log.e(LOG_TAG, "origin chat is null, origin merge message id " + this.originMergeForwardMessageId);
        return false;
    L10:
        Chat r1 = r0.getOriginChat();
        if (r1 == null) goto L14;
        String r2 = r1.getId();
        if (r2 == null) goto L14;
    L15:
        setChatId(r2);
        getChatData().postValue(r0.getOriginChat());
        Chat r3 = r0.getOriginChat();
        if (r3 == null) goto L18;
        getChat().postValue(r3);
    L18:
        getThreadTopicLiveData().postValue(b0.a(r0.getThread()));
        MutableLiveData<i7b.a> r4 = getInitData();
        i7b.a r5 = new i7b.a();
        r5.f = r0.getOriginChat();
        r5.g = (ChatChatter) getP2pChatterData().getValue();
        r5.b = -1;
        r5.d = false;
        r4.postValue(r5);
        return true;
    L14:
        r2 = "";
        goto L15
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public String getOriginMergeForwardId() {
        String r0 = getMergeForwardMessage().getSourceId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return this.originMergeForwardMessageId;
    L12:
        return getMergeForwardMessage().getSourceId();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public Message getParentMergeForwardMessage() {
        return getMergeForwardMessage();
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public MutableLiveData<Chat> getChat() {
        return this.chat;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public b getChatBundle() {
        return this.chatBundle;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public String getChatId() {
        return this.chatId;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public MutableLiveData<i7b.a> getInitData() {
        return this.initData;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData() {
        return this.initializeStateLiveData;
    }

    public final String getOriginMergeForwardMessageId() {
        return this.originMergeForwardMessageId;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void onCreate(f r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        if ((r3 instanceof com.ss.android.lark.replyinthread.pages.a) == true) goto L7;
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        Log.e(LOG_TAG, "thread page info is invalidate");
        return;
    L7:
        if (getInitializeStateLiveData().getValue() == ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED) goto L9;
        return;
    L9:
        getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZING);
        com.ss.android.lark.replyinthread.pages.a r4 = (com.ss.android.lark.replyinthread.pages.a) r3;
        this.originMergeForwardMessageId = r4.d;
        Message r0 = r4.e;
        if (r0 == null) goto L12;
        setMergeForwardMessage(r0);
    L12:
        setThreadId(r4.c);
        if (handleInitData() == true) goto L16;
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        return;
    L16:
        getInitDataReady().postValue(Boolean.TRUE);
        getInitializeStateLiveData().postValue(ChatWindowOpenViewModel.InitializeState.INITIALIZED);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public final void setMergeForwardMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mergeForwardMessage = r2;
    }

    public final void setOriginMergeForwardMessageId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originMergeForwardMessageId = r2;
    }

    public CardVisitorReplyInThreadViewModel(Context r2, b r3, v r4) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        this.appContext = r2;
        this.chatBundle = r3;
        this.chatAppContainer = r4;
        this.chat = new MutableLiveData();
        this.initData = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
        this.originMergeForwardMessageId = "";
    }
}
