package com.ss.android.lark.flow.mergeforward.page;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import fxa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0019\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0015R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "bundle", "Landroid/os/Bundle;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Landroid/os/Bundle;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getBundle", "()Landroid/os/Bundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "getInitializeStateLiveData", "messageContent", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "getMessageContent", "()Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "setMessageContent", "(Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;)V", "translatedMessageContent", "getTranslatedMessageContent", "setTranslatedMessageContent", "originMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "getOriginMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setOriginMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "fromType", "", "getFromType", "()I", "setFromType", "(I)V", "closePageInfo", "", "getClosePageInfo", "originDoubaoMsgId", "", "getOriginDoubaoMsgId", "()Ljava/lang/String;", "setOriginDoubaoMsgId", "(Ljava/lang/String;)V", "loadChatInitData", "", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMergeForwardViewModel extends ViewModel implements ChatWindowOpenViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String SERIALIZABLE_FROM_TYPE = "serializable_from_type";
    private static final String TAG = "FlowMergeForwardViewModel";
    private final Bundle bundle;
    private final MutableLiveData<Chat> chat;
    private final b chatBundle;
    private final v chatContainer;
    private final MutableLiveData<Boolean> closePageInfo;
    private int fromType;
    private final MutableLiveData<i7b.a> initData;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    private MergeForwardContent messageContent;
    private String originDoubaoMsgId;
    private Message originMessage;
    private MergeForwardContent translatedMessageContent;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public MutableLiveData<Chat> getChat() {
        return this.chat;
    }

    public b getChatBundle() {
        return this.chatBundle;
    }

    public final v getChatContainer() {
        return this.chatContainer;
    }

    public final MutableLiveData<Boolean> getClosePageInfo() {
        return this.closePageInfo;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public MutableLiveData<i7b.a> getInitData() {
        return this.initData;
    }

    public MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData() {
        return this.initializeStateLiveData;
    }

    public final MergeForwardContent getMessageContent() {
        return this.messageContent;
    }

    public final String getOriginDoubaoMsgId() {
        return this.originDoubaoMsgId;
    }

    public final Message getOriginMessage() {
        return this.originMessage;
    }

    public final MergeForwardContent getTranslatedMessageContent() {
        return this.translatedMessageContent;
    }

    public void loadChatInitData(ChatWindowOpenViewModel.b r4) {
        Bundle r5 = this.bundle;
        if (r5 != null) goto L6;
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L6:
        int r6 = r5.getInt(SERIALIZABLE_FROM_TYPE, 0);
        this.fromType = r6;
        if (r6 != 4) goto L9;
        this.originDoubaoMsgId = this.bundle.getString("key_origin_doubao_msg_id");
    L9:
        com.ss.android.lark.mergeforward.b.a r7 = com.ss.android.lark.mergeforward.b.a;
        com.ss.android.lark.mergeforward.b.a r8 = com.ss.android.lark.mergeforward.b.a;
        Chat r0 = null;
        if (r8 == null) goto L12;
        MergeForwardContent r1 = r8.a;
    L13:
        this.messageContent = r1;
        if (r8 == null) goto L16;
        MergeForwardContent r2 = r8.b;
    L17:
        this.translatedMessageContent = r2;
        if (r8 == null) goto L20;
        Message r9 = r8.c;
    L21:
        this.originMessage = r9;
        com.ss.android.lark.mergeforward.b.a = null;
        if (r1 != null) goto L25;
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L25:
        MutableLiveData<i7b.a> r10 = getInitData();
        i7b.a r3 = new i7b.a();
        MergeForwardContent r11 = this.messageContent;
        if (r11 == null) goto L28;
        Chat r12 = r11.getOriginChat();
    L29:
        r3.f = r12;
        r3.g = null;
        r3.h = null;
        r10.postValue(r3);
        MutableLiveData<Chat> r13 = getChat();
        MergeForwardContent r14 = this.messageContent;
        if (r14 == null) goto L32;
        r0 = r14.getOriginChat();
    L32:
        r13.postValue(r0);
        return;
    L28:
        r12 = null;
        goto L29
    L20:
        r9 = null;
        goto L21
    L16:
        r2 = null;
        goto L17
    L12:
        r1 = null;
        goto L13
    }

    public final void setFromType(int r1) {
        this.fromType = r1;
    }

    public final void setMessageContent(MergeForwardContent r1) {
        this.messageContent = r1;
    }

    public final void setOriginDoubaoMsgId(String r1) {
        this.originDoubaoMsgId = r1;
    }

    public final void setOriginMessage(Message r1) {
        this.originMessage = r1;
    }

    public final void setTranslatedMessageContent(MergeForwardContent r1) {
        this.translatedMessageContent = r1;
    }

    public <T> MutableLiveData<T> getLiveData(String r1, Class<T> r2) {
        ChatWindowOpenViewModel.a.a(r1, r2);
        return null;
    }

    public FlowMergeForwardViewModel(Bundle r2, b r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        this.bundle = r2;
        this.chatBundle = r3;
        this.chatContainer = r4;
        this.chat = new MutableLiveData();
        this.initData = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData();
        this.closePageInfo = new MutableLiveData();
    }

    public <T> void setLiveData(String r1, Class<T> r2, MutableLiveData<T> r3) {
        ChatWindowOpenViewModel.a.c(r1, r2, r3);
    }

    public <T> void observeWhenAvailable(String r1, Class<T> r2, LifecycleOwner r3, Observer<T> r4) {
        ChatWindowOpenViewModel.a.b(this, r1, r2, r3, r4);
    }
}
