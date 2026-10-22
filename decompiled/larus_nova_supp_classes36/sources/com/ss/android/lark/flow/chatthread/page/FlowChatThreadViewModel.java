package com.ss.android.lark.flow.chatthread.page;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import e7b.c;
import fxa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020 H\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006%"}, d2 = {"Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "bundle", "Landroid/os/Bundle;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Landroid/os/Bundle;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getBundle", "()Landroid/os/Bundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "getInitializeStateLiveData", "chatThreadInitData", "Lcom/ss/android/lark/chatthread/dto/ChatThreadInitData;", "getChatThreadInitData", "loadChatInitData", "", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "parseBundle", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatThreadViewModel extends ViewModel implements ChatWindowOpenViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String TAG = "FlowChatThreadViewModel";
    private final Bundle bundle;
    private final MutableLiveData<Chat> chat;
    private final b chatBundle;
    private final v chatContainer;
    private final MutableLiveData<c> chatThreadInitData;
    private final MutableLiveData<i7b.a> initData;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.flow.chatthread.page.FlowChatThreadViewModel$parseBundle$1, java.lang.Object] */
    private final void parseBundle() {
        f7b.b r0 = new f7b.b();
        Bundle r1 = this.bundle;
        ?? r2 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r2, "callback");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new f7b.a(r1, r0, r2));
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

    public final MutableLiveData<c> getChatThreadInitData() {
        return this.chatThreadInitData;
    }

    public MutableLiveData<i7b.a> getInitData() {
        return this.initData;
    }

    public MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData() {
        return this.initializeStateLiveData;
    }

    public void loadChatInitData(ChatWindowOpenViewModel.b r1) {
        parseBundle();
    }

    public <T> MutableLiveData<T> getLiveData(String r1, Class<T> r2) {
        ChatWindowOpenViewModel.a.a(r1, r2);
        return null;
    }

    public FlowChatThreadViewModel(Bundle r2, b r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        this.bundle = r2;
        this.chatBundle = r3;
        this.chatContainer = r4;
        this.chat = new MutableLiveData();
        this.initData = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData();
        this.chatThreadInitData = new MutableLiveData();
    }

    public <T> void setLiveData(String r1, Class<T> r2, MutableLiveData<T> r3) {
        ChatWindowOpenViewModel.a.c(r1, r2, r3);
    }

    public <T> void observeWhenAvailable(String r1, Class<T> r2, LifecycleOwner r3, Observer<T> r4) {
        ChatWindowOpenViewModel.a.b(this, r1, r2, r3, r4);
    }
}
