package com.ss.android.lark.flow.chat.page.flow;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.extension.PausableLiveData;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.x;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import l3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u0010*\u001a\u00020'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006,"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDependenceViewModel;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/extension/PausableLiveData;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/extension/PausableLiveData;", "pluginInitData", "getPluginInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "getInitializeStateLiveData", "initErrorInfo", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getInitErrorInfo", "loadChatInitData", "", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "initChatParamUtils", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatViewModel extends ViewModel implements ChatWindowOpenViewModel, g {
    public static final int $stable = 0;
    private static final String CHAT_FETCH_INIT_DATA = "flow_chat_fetch_init_data";
    public static final a Companion = null;
    private static final String TAG = "FlowChatViewModel";
    private final MutableLiveData<Chat> chat;
    private final fxa.b chatBundle;
    private final v chatContainer;
    private String chatId;
    private final PausableLiveData<i7b.a> initData;
    private final MutableLiveData<ErrorResult> initErrorInfo;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    private final MutableLiveData<i7b.a> pluginInitData;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel$loadChatInitData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel$loadChatInitData$1", f = "FlowChatViewModel.kt", i = {0, 1}, l = {64, 67}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChatWindowOpenViewModel.b $callback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FlowChatViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel$loadChatInitData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel$loadChatInitData$1$1", f = "FlowChatViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChatWindowOpenViewModel.b $callback;
            final /* synthetic */ Object $result;
            int label;
            final /* synthetic */ FlowChatViewModel this$0;

            public C00331(Object r1, ChatWindowOpenViewModel.b r2, FlowChatViewModel r3, Continuation<? super C00331> r4) {
                this.$result = r1;
                this.this$0 = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00331(this.$result, null, this.this$0, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L36;
                ResultKt.throwOnFailure(r5);
                Chat r2 = null;
                if (Result.isSuccess-impl(this.$result) == false) goto L27;
                Object r6 = this.$result;
                if (Result.isFailure-impl(r6) == false) goto L9;
                r6 = null;
            L9:
                i7b.a r7 = (i7b.a) r6;
                if (r7 == null) goto L12;
                r2 = r7.f;
            L12:
                PerfLog.end(FlowChatViewModel.CHAT_FETCH_INIT_DATA, "");
                Lazy r0 = ChatCoreModule.a;
                this.this$0.getChat().setValue(r2);
                boolean r1 = false;
                if (r2 != null) goto L15;
            L17:
                if (r1 == true) goto L19;
            L21:
                this.this$0.getPluginInitData().postValue(r7);
            L22:
                if (r7 != null) goto L24;
            L26:
                Log.e(FlowChatViewModel.TAG, "ChatWindowInitData is invalid");
                this.this$0.getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
            L34:
                return Unit.INSTANCE;
            L24:
                if (r7.a() == false) goto L26;
                this.this$0.m124getInitData().postValue(r7);
                this.this$0.getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZED);
                goto L34
            L19:
                if (r2.isSecret() == true) goto L21;
                this.this$0.getPluginInitData().postValue(r7);
                goto L22
            L15:
                if (r2.isFake() != true) goto L17;
                r1 = true;
                goto L17
            L27:
                PerfLog.end(FlowChatViewModel.CHAT_FETCH_INIT_DATA, "");
                Chat r8 = Result.exceptionOrNull-impl(this.$result);
                if ((r8 instanceof ErrorResult) == false) goto L30;
                r2 = (ErrorResult) r8;
            L30:
                if (r2 == null) goto L32;
                this.this$0.getInitErrorInfo().postValue(r2);
            L32:
                this.this$0.getInitializeStateLiveData().postValue(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
                goto L34
            L36:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(FlowChatViewModel r1, ChatWindowOpenViewModel.b r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, null, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L6;
            if (r1 == 2) goto L6;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L6:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L18:
            BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new C00331(r8, null, this.this$0, null), 2, null);
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            if (this.this$0.getChatBundle().a() == true) goto L14;
            com.ss.android.lark.chat.chatwindow.chat.perload.c r3 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;
            fxa.b r4 = this.this$0.getChatBundle();
            this.L$0 = r9;
            this.label = 1;
            Object r5 = ExtensionKt.a(r3, r4, this);
            if (r5 != r0) goto L17;
            return r0;
        L17:
            r2 = r9;
            r8 = r5;
            goto L18
        L14:
            Log.i("ChatLauncherV2", "fetch chat window preload data use preload v2");
            x r6 = this.this$0.getChatContainer().H();
            fxa.b r10 = this.this$0.getChatBundle();
            this.L$0 = r9;
            this.label = 2;
            r5 = r6.c(r10, this);
            if (r5 != r0) goto L17;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public /* bridge */ /* synthetic */ MutableLiveData getInitData() {
        return m124getInitData();
    }

    public final void initChatParamUtils() {
        String r0 = getChatBundle().getChatId();
        if (r0 == null) goto L25;
        Chat r1 = (Chat) getChat().getValue();
        i7b.a r2 = (i7b.a) m124getInitData().getValue();
        if (r2 == null) goto L7;
        ChatChatter r3 = r2.g;
    L8:
        ChatParamUtils.b = null;
        ChatParamUtils.a = null;
        ChatParamUtils.c = null;
        ChatParamUtils.d = null;
        ChatParamUtils.e = null;
        String r4 = ChatCoreModule.a().getLoginDependency().getUserId();
        Bundle r5 = getChatBundle().getExtraParams();
        if (r5 == null) goto L11;
        String r6 = r5.getString("key_event_common_scene");
    L12:
        Bundle r7 = getChatBundle().getExtraParams();
        if (r7 == null) goto L15;
        String r8 = r7.getString("key_event_common_app_name");
    L16:
        ChatParamUtils.j(r0, r4, null, r6, r8);
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r1, "chat");
        if (Intrinsics.areEqual(ChatParamUtils.a, r1.getId()) == false) goto L22;
        ChatParamUtils.b = r1;
    L22:
        if (r3 == null) goto L26;
        ChatParamUtils.l(r3);
        return;
    L26:
        return;
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public MutableLiveData<Chat> getChat() {
        return this.chat;
    }

    public fxa.b getChatBundle() {
        return this.chatBundle;
    }

    public final v getChatContainer() {
        return this.chatContainer;
    }

    public String getChatId() {
        return this.chatId;
    }

    public final MutableLiveData<ErrorResult> getInitErrorInfo() {
        return this.initErrorInfo;
    }

    public MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData() {
        return this.initializeStateLiveData;
    }

    public final MutableLiveData<i7b.a> getPluginInitData() {
        return this.pluginInitData;
    }

    /* JADX INFO: renamed from: getInitData, reason: collision with other method in class */
    public PausableLiveData<i7b.a> m124getInitData() {
        return this.initData;
    }

    public void loadChatInitData(ChatWindowOpenViewModel.b r9) {
        if (getInitializeStateLiveData().getValue() == ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED) goto L5;
        return;
    L5:
        getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZING);
        setChatId(getChatBundle().getChatId());
        PerfLog.start(CHAT_FETCH_INIT_DATA, "");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r9, null), 2, null);
        ChatCoreModule.a().getFeedDependency().b(getChatId(), FeedCard.EntityType.CHAT, false, UpdateUnreadStatusScene.HALF_SCREEN);
        initChatParamUtils();
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public FlowChatViewModel(fxa.b r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        Intrinsics.checkNotNullParameter(r3, "chatContainer");
        this.chatBundle = r2;
        this.chatContainer = r3;
        this.chat = new MutableLiveData();
        this.initData = new PausableLiveData();
        this.pluginInitData = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
        this.initErrorInfo = new MutableLiveData();
    }

    public <T> MutableLiveData<T> getLiveData(String r1, Class<T> r2) {
        ChatWindowOpenViewModel.a.a(r1, r2);
        return null;
    }

    public <T> void setLiveData(String r1, Class<T> r2, MutableLiveData<T> r3) {
        ChatWindowOpenViewModel.a.c(r1, r2, r3);
    }

    public <T> void observeWhenAvailable(String r1, Class<T> r2, LifecycleOwner r3, Observer<T> r4) {
        ChatWindowOpenViewModel.a.b(this, r1, r2, r3, r4);
    }
}
