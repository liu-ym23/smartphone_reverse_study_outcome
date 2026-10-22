package com.ss.android.lark.flow.replyinthread.pages.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.replyinthread.pages.c;
import com.ss.android.lark.replyinthread.pages.f;
import fxa.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020%H\u0002J\u0012\u00102\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/MergeForwardReplyInThreadViewModel;", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel;", "appContext", "Landroid/content/Context;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "kotlin.jvm.PlatformType", "getInitializeStateLiveData", "originMergeForwardMessageId", "getOriginMergeForwardMessageId", "setOriginMergeForwardMessageId", "messageThread", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent$MessageThread;", "rootMessageId", "parentMessageContent", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "getParentMessageContent", "()Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "setParentMessageContent", "(Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;)V", "topicMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "onCreate", "", "page", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "getTopicMessage", "content", "loadChatInitData", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "showChatName", "", "getMsgListRepoFactory", "Lcom/ss/android/lark/biz/im/api/MessageListRepositoryFactory;", "getOriginMergeForwardId", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MergeForwardReplyInThreadViewModel extends FlowBaseReplyInThreadViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String LOG_TAG = "MergeForwardReplyInThreadViewModel";
    private final Context appContext;
    private final MutableLiveData<Chat> chat;
    private final v chatAppContainer;
    private final b chatBundle;
    private String chatId;
    private final MutableLiveData<i7b.a> initData;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    private MergeForwardContent.MessageThread messageThread;
    private String originMergeForwardMessageId;
    public MergeForwardContent parentMessageContent;
    private String rootMessageId;
    private Message topicMessage;

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

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public z0 getMsgListRepoFactory() {
        return new com.ss.android.lark.flow.replyinthread.pages.repo.b(this);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public String getOriginMergeForwardId() {
        Message r0 = this.topicMessage;
        Message r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topicMessage");
        r0 = null;
    L5:
        String r2 = r0.getSourceId();
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L20;
        Message r4 = this.topicMessage;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topicMessage");
    L19:
        return r1.getSourceId();
    L17:
        r1 = r4;
        goto L19
    L20:
        return this.originMergeForwardMessageId;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final MergeForwardContent getParentMessageContent() {
        MergeForwardContent r0 = this.parentMessageContent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentMessageContent");
        return null;
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

    private final void getTopicMessage(MergeForwardContent r5) {
        List r6 = r5.getMessages();
        if (r6 == null) goto L11;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((Message) r1).getId(), this.rootMessageId) == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        Message r8 = (Message) CollectionsKt.firstOrNull(r0);
    L12:
        if (r8 != null) goto L14;
        return;
    L14:
        this.topicMessage = r8;
        return;
    L11:
        r8 = null;
        goto L12
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void onCreate(f r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        if ((r3 instanceof c) == true) goto L7;
        Log.e(LOG_TAG, "thread page info is invalidate");
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        return;
    L7:
        if (getInitializeStateLiveData().getValue() == ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED) goto L9;
        return;
    L9:
        getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZING);
        c r4 = (c) r3;
        this.originMergeForwardMessageId = r4.e;
        setThreadId(r4.c);
        this.rootMessageId = r4.d;
        setParentMessageContent(r4.f);
        if (getParentMessageContent().getOriginChat() != null) goto L13;
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        return;
    L13:
        Chat r5 = getParentMessageContent().getOriginChat();
        if (r5 == null) goto L17;
        String r6 = r5.getId();
        if (r6 == null) goto L17;
    L18:
        setChatId(r6);
        getChatData().postValue(getParentMessageContent().getOriginChat());
        Chat r7 = getParentMessageContent().getOriginChat();
        if (r7 == null) goto L21;
        getChat().postValue(r7);
    L21:
        MutableLiveData<i7b.a> r8 = getInitData();
        i7b.a r0 = new i7b.a();
        r0.f = getParentMessageContent().getOriginChat();
        r0.g = (ChatChatter) getP2pChatterData().getValue();
        r0.b = -1;
        r0.d = false;
        r8.postValue(r0);
        MutableLiveData<ThreadTopic> r9 = getThreadTopicLiveData();
        ThreadTopic r1 = new ThreadTopic();
        Boolean r2 = Boolean.TRUE;
        r1.setMock(r2);
        r9.postValue(r1);
        getTopicMessage(getParentMessageContent());
        getInitDataReady().postValue(r2);
        getInitializeStateLiveData().postValue(ChatWindowOpenViewModel.InitializeState.INITIALIZED);
        return;
    L17:
        r6 = "";
        goto L18
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public final void setOriginMergeForwardMessageId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originMergeForwardMessageId = r2;
    }

    public final void setParentMessageContent(MergeForwardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.parentMessageContent = r2;
    }

    public MergeForwardReplyInThreadViewModel(Context r2, b r3, v r4) {
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
        this.rootMessageId = "";
    }
}
