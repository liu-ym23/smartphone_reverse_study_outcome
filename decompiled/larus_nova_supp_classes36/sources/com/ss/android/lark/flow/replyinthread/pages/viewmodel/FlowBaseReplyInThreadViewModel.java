package com.ss.android.lark.flow.replyinthread.pages.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.replyinthread.pages.f;
import fxa.b;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l3c.g;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u0018H\u0016J\b\u00104\u001a\u00020\u0018H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\u001a\u00106\u001a\u00020,2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020,\u0018\u000108H\u0016J\u0006\u00109\u001a\u00020\u000bJ\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020>H&J\b\u0010?\u001a\u00020,H\u0016J\b\u0010@\u001a\u00020,H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR%\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006B"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDependenceViewModel;", "<init>", "()V", "callbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "getCallbackManager", "()Lcom/larksuite/framework/callback/CallbackManager;", "currentFeedCardType", "", "getCurrentFeedCardType", "()I", "setCurrentFeedCardType", "(I)V", "closePageInfo", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel$ClosePageInfo;", "", "getClosePageInfo", "()Landroidx/lifecycle/MutableLiveData;", "initDataReady", "", "getInitDataReady", "threadTopicLiveData", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "getThreadTopicLiveData", "chatData", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatData", "selfChatterData", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getSelfChatterData", "p2pChatterData", "getP2pChatterData", "threadId", "", "getThreadId", "()Ljava/lang/String;", "setThreadId", "(Ljava/lang/String;)V", "onCreate", "", "page", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "isFakeThreadTopic", "showChatName", "inChat", "isThreadClosed", "canReply", "needShowKeyBoard", "getThreadReadPosition", "onUpdatePushThreadTopic", "callback", "Lkotlin/Function0;", "getFeedCardType", "getParentMergeForwardMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "getOriginMergeForwardId", "getMsgListRepoFactory", "Lcom/ss/android/lark/biz/im/api/MessageListRepositoryFactory;", "recordStartTime", "sendTimeDuration", "ClosePageInfo", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class FlowBaseReplyInThreadViewModel extends ViewModel implements ChatWindowOpenViewModel, g {
    public static final int $stable = 8;
    private final CallbackManager callbackManager;
    private final MutableLiveData<Chat> chatData;
    private final MutableLiveData<Pair<ClosePageInfo, Object>> closePageInfo;
    private int currentFeedCardType;
    private final MutableLiveData<Boolean> initDataReady;
    private final MutableLiveData<ChatChatter> p2pChatterData;
    private final MutableLiveData<ChatChatter> selfChatterData;
    private String threadId;
    private final MutableLiveData<ThreadTopic> threadTopicLiveData;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel$ClosePageInfo;", "", "<init>", "(Ljava/lang/String;I)V", "INIT_DATA_INVALIDATE", "THREAD_IS_DELETE", "GET_THREAD_IS_FORBIDDEN", "THREAD_IS_RECALLED", "REMOTE_BY_OTHERS", "NORMAL_FINISH_HIDE_FEED", "GROUP_IS_DISSOLVED_REMOTE", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ClosePageInfo extends Enum<ClosePageInfo> {
        public static final ClosePageInfo GET_THREAD_IS_FORBIDDEN = null;
        public static final ClosePageInfo GROUP_IS_DISSOLVED_REMOTE = null;
        public static final ClosePageInfo INIT_DATA_INVALIDATE = null;
        public static final ClosePageInfo NORMAL_FINISH_HIDE_FEED = null;
        public static final ClosePageInfo REMOTE_BY_OTHERS = null;
        public static final ClosePageInfo THREAD_IS_DELETE = null;
        public static final ClosePageInfo THREAD_IS_RECALLED = null;
        public static final /* synthetic */ ClosePageInfo[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ClosePageInfo> getEntries() {
            return b;
        }

        static {
            ClosePageInfo r0 = new ClosePageInfo("INIT_DATA_INVALIDATE", 0);
            INIT_DATA_INVALIDATE = r0;
            ClosePageInfo r1 = new ClosePageInfo("THREAD_IS_DELETE", 1);
            THREAD_IS_DELETE = r1;
            ClosePageInfo r3 = new ClosePageInfo("GET_THREAD_IS_FORBIDDEN", 2);
            GET_THREAD_IS_FORBIDDEN = r3;
            ClosePageInfo r5 = new ClosePageInfo("THREAD_IS_RECALLED", 3);
            THREAD_IS_RECALLED = r5;
            ClosePageInfo r7 = new ClosePageInfo("REMOTE_BY_OTHERS", 4);
            REMOTE_BY_OTHERS = r7;
            ClosePageInfo r9 = new ClosePageInfo("NORMAL_FINISH_HIDE_FEED", 5);
            NORMAL_FINISH_HIDE_FEED = r9;
            ClosePageInfo r11 = new ClosePageInfo("GROUP_IS_DISSOLVED_REMOTE", 6);
            GROUP_IS_DISSOLVED_REMOTE = r11;
            ClosePageInfo[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static ClosePageInfo[] values() {
            return (ClosePageInfo[]) a.clone();
        }

        public static ClosePageInfo valueOf(String r1) {
            return (ClosePageInfo) a.a(ClosePageInfo.class, r1);
        }

        public ClosePageInfo(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract /* synthetic */ MutableLiveData<Chat> getChat();

    public abstract /* synthetic */ b getChatBundle();

    public abstract /* synthetic */ String getChatId();

    public abstract /* synthetic */ MutableLiveData<i7b.a> getInitData();

    public abstract /* synthetic */ MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData();

    public abstract z0 getMsgListRepoFactory();

    public String getOriginMergeForwardId() {
        return "";
    }

    public Message getParentMergeForwardMessage() {
        return null;
    }

    public int getThreadReadPosition() {
        return -1;
    }

    public boolean inChat() {
        return false;
    }

    public boolean isFakeThreadTopic() {
        return false;
    }

    public boolean isThreadClosed() {
        return false;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "later remove")
    public abstract /* synthetic */ void loadChatInitData(ChatWindowOpenViewModel.b r1);

    public boolean needShowKeyBoard() {
        return false;
    }

    public void onCreate(f r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
    }

    public void onUpdatePushThreadTopic(Function0<Unit> r1) {
    }

    public void recordStartTime() {
    }

    public void sendTimeDuration() {
    }

    public abstract /* synthetic */ void setChatId(String r1);

    public boolean showChatName() {
        return false;
    }

    public FlowBaseReplyInThreadViewModel() {
        this.callbackManager = new CallbackManager();
        this.currentFeedCardType = -1;
        this.closePageInfo = new MutableLiveData();
        this.initDataReady = new MutableLiveData();
        this.threadTopicLiveData = new MutableLiveData();
        this.chatData = new MutableLiveData();
        this.selfChatterData = new MutableLiveData();
        this.p2pChatterData = new MutableLiveData();
        this.threadId = "";
    }

    public boolean canReply() {
        if (inChat() == true) goto L5;
    L7:
        return false;
    L5:
        if (isThreadClosed() == true) goto L7;
        return true;
    }

    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public final MutableLiveData<Chat> getChatData() {
        return this.chatData;
    }

    public final MutableLiveData<Pair<ClosePageInfo, Object>> getClosePageInfo() {
        return this.closePageInfo;
    }

    public final int getCurrentFeedCardType() {
        return this.currentFeedCardType;
    }

    public final int getFeedCardType() {
        return this.currentFeedCardType;
    }

    public final MutableLiveData<Boolean> getInitDataReady() {
        return this.initDataReady;
    }

    public final MutableLiveData<ChatChatter> getP2pChatterData() {
        return this.p2pChatterData;
    }

    public final MutableLiveData<ChatChatter> getSelfChatterData() {
        return this.selfChatterData;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final MutableLiveData<ThreadTopic> getThreadTopicLiveData() {
        return this.threadTopicLiveData;
    }

    public final void setCurrentFeedCardType(int r1) {
        this.currentFeedCardType = r1;
    }

    public final void setThreadId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threadId = r2;
    }

    public <T> MutableLiveData<T> getLiveData(String r1, Class<T> r2) {
        ChatWindowOpenViewModel.a.a(r1, r2);
        return null;
    }

    public <T> void setLiveData(String r1, Class<T> r2, MutableLiveData<T> r3) {
        ChatWindowOpenViewModel.a.c(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onUpdatePushThreadTopic$default(FlowBaseReplyInThreadViewModel r0, Function0 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.onUpdatePushThreadTopic(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdatePushThreadTopic");
    }

    public <T> void observeWhenAvailable(String r1, Class<T> r2, LifecycleOwner r3, Observer<T> r4) {
        ChatWindowOpenViewModel.a.b(this, r1, r2, r3, r4);
    }
}
