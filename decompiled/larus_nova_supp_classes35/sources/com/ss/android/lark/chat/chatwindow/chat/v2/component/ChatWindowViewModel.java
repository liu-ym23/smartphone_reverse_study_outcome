package com.ss.android.lark.chat.chatwindow.chat.v2.component;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.extension.chat_window.PageViewModelAttachImpl;
import com.ss.android.lark.biz.im.api.extension.chat_window.f;
import com.ss.android.lark.biz.im.api.extension.chat_window.i;
import com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.x;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import l3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001@B+\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0017J1\u00103\u001a\n\u0012\u0004\u0012\u0002H4\u0018\u00010\u001a\"\b\b\u0000\u00104*\u0002052\u0006\u00106\u001a\u00020'2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H408H\u0096\u0001J?\u00109\u001a\u000200\"\b\b\u0000\u00104*\u0002052\u0006\u00106\u001a\u00020'2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H4082\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H40=H\u0096\u0001J7\u0010>\u001a\u000200\"\b\b\u0000\u00104*\u0002052\u0006\u00106\u001a\u00020'2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H4082\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H40\u001aH\u0096\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001a¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001d¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/ChatWindowViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatHostViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDependenceViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/ITabDependeceViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/IPageViewModelAttach;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "messageService", "Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "getMessageService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "pluginInitData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getPluginInitData", "()Landroidx/lifecycle/MutableLiveData;", "initData", "getInitData", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "initErrorInfo", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getInitErrorInfo", "chatId", BuildConfig.FLAVOR, "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "getInitializeStateLiveData", "loadChatInitData", BuildConfig.FLAVOR, "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "getLiveData", "T", BuildConfig.FLAVOR, "key", "clazz", "Ljava/lang/Class;", "observeWhenAvailable", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setLiveData", "liveData", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowViewModel extends ViewModel implements g, ChatWindowOpenViewModel, f {
    public static final a Companion = null;
    public static final String LAUNCHER_TAG = "ChatLauncherV2";
    private final /* synthetic */ i $$delegate_0;
    private final MutableLiveData<Chat> chat;
    private final v chatAppContainer;
    private final fxa.b chatBundle;
    private String chatId;
    private final ImSdkChatService chatService;
    private final MutableLiveData<i7b.a> initData;
    private final MutableLiveData<ErrorResult> initErrorInfo;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    private final p messageService;
    private final MutableLiveData<i7b.a> pluginInitData;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel$loadChatInitData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel$loadChatInitData$1", f = "ChatWindowViewModel.kt", i = {0, 1, 2}, l = {69, 72, 73}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChatWindowOpenViewModel.b $callback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatWindowViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel$loadChatInitData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel$loadChatInitData$1$1", f = "ChatWindowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChatWindowOpenViewModel.b $callback;
            final /* synthetic */ Object $result;
            int label;
            final /* synthetic */ ChatWindowViewModel this$0;

            public C00561(Object r1, ChatWindowOpenViewModel.b r2, ChatWindowViewModel r3, Continuation<? super C00561> r4) {
                this.$result = r1;
                this.this$0 = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00561(this.$result, null, this.this$0, r5);
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
                PerfLog.end("chat_fetch_init_data", BuildConfig.FLAVOR);
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
                Log.e(TitlebarViewModel.LOG_TAG, "ChatWindowInitData is invalid");
                this.this$0.getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
            L34:
                return Unit.INSTANCE;
            L24:
                if (r7.a() == false) goto L26;
                this.this$0.getInitData().postValue(r7);
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
                PerfLog.end("chat_fetch_init_data", BuildConfig.FLAVOR);
                Throwable r8 = Result.exceptionOrNull-impl(this.$result);
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

        public AnonymousClass1(ChatWindowViewModel r1, ChatWindowOpenViewModel.b r2, Continuation<? super AnonymousClass1> r3) {
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L7;
            if (r1 == 2) goto L7;
            if (r1 == 3) goto L7;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L7:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L26:
            BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new C00561(r8, null, this.this$0, null), 2, null);
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            if (this.this$0.getChatBundle().a() == true) goto L15;
            com.ss.android.lark.chat.chatwindow.chat.perload.c r3 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;
            fxa.b r4 = this.this$0.getChatBundle();
            this.L$0 = r9;
            this.label = 1;
            Object r5 = ExtensionKt.a(r3, r4, this);
            if (r5 != r0) goto L25;
            return r0;
        L25:
            r2 = r9;
            r8 = r5;
            goto L26
        L15:
            Log.i(ChatWindowViewModel.LAUNCHER_TAG, "fetch chat window preload data use preload v2");
            v r6 = this.this$0.getChatAppContainer();
            if (r6 == null) goto L22;
            x r10 = r6.H();
            if (r10 == null) goto L22;
            fxa.b r11 = this.this$0.getChatBundle();
            this.L$0 = r9;
            this.label = 2;
            r5 = r10.c(r11, this);
            if (r5 != r0) goto L25;
            return r0;
        L22:
            com.ss.android.lark.chat.chatwindow.chat.perload.c r12 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;
            fxa.b r13 = this.this$0.getChatBundle();
            this.L$0 = r9;
            this.label = 3;
            r5 = ExtensionKt.a(r12, r13, this);
            if (r5 != r0) goto L25;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public <T> MutableLiveData<T> getLiveData(String r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        return this.$$delegate_0.getLiveData(r2, r3);
    }

    public MutableLiveData<Chat> getChat() {
        return this.chat;
    }

    public final v getChatAppContainer() {
        return this.chatAppContainer;
    }

    public fxa.b getChatBundle() {
        return this.chatBundle;
    }

    public String getChatId() {
        return this.chatId;
    }

    public final ImSdkChatService getChatService() {
        return this.chatService;
    }

    public MutableLiveData<i7b.a> getInitData() {
        return this.initData;
    }

    public final MutableLiveData<ErrorResult> getInitErrorInfo() {
        return this.initErrorInfo;
    }

    public MutableLiveData<ChatWindowOpenViewModel.InitializeState> getInitializeStateLiveData() {
        return this.initializeStateLiveData;
    }

    public final p getMessageService() {
        return this.messageService;
    }

    public final MutableLiveData<i7b.a> getPluginInitData() {
        return this.pluginInitData;
    }

    public void loadChatInitData(ChatWindowOpenViewModel.b r9) {
        if (getInitializeStateLiveData().getValue() == ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED) goto L5;
        return;
    L5:
        getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZING);
        setChatId(getChatBundle().getChatId());
        PerfLog.start("chat_fetch_init_data", BuildConfig.FLAVOR);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r9, null), 2, null);
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public <T> void setLiveData(String r5, Class<T> r6, MutableLiveData<T> r7) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "clazz");
        Intrinsics.checkNotNullParameter(r7, "liveData");
        i r3 = this.$$delegate_0;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "clazz");
        Intrinsics.checkNotNullParameter(r7, "liveData");
        ConcurrentHashMap r0 = r3.a;
        Object r1 = r0.get(r5);
        if (r1 != null) goto L8;
        r1 = new ConcurrentHashMap();
        Object r2 = r0.putIfAbsent(r5, r1);
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        ConcurrentHashMap r4 = (ConcurrentHashMap) r1;
        Intrinsics.checkNotNull(r4);
        r4.put(r6, r7);
        ConcurrentHashMap r8 = (ConcurrentHashMap) r3.b.get(r5);
        List r9 = null;
        if (r8 == null) goto L11;
        List r10 = (List) r8.remove(r6);
    L13:
        if (TypeIntrinsics.isMutableList(r10) == false) goto L15;
        r9 = r10;
    L15:
        List r11 = r9;
        if (r11 != null) goto L18;
    L21:
        boolean r12 = true;
    L22:
        if (r12 == true) goto L30;
        Iterator r13 = r9.iterator();
    L25:
        if (r13.hasNext() == false) goto L37;
        i.a r14 = (i.a) r13.next();
        if (r14.a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED) == false) goto L28;
        r7.observe(r14.a, r14.b);
        goto L25
    L28:
        r13.remove();
        goto L25
    L37:
        return;
    L30:
        return;
    L18:
        if (r11.isEmpty() == true) goto L21;
        r12 = false;
        goto L22
    L11:
        r10 = null;
        goto L13
    }

    public ChatWindowViewModel(fxa.b r2, ImSdkChatService r3, p r4, v r5) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        Intrinsics.checkNotNullParameter(r3, "chatService");
        Intrinsics.checkNotNullParameter(r4, "messageService");
        this.$$delegate_0 = new i();
        this.chatBundle = r2;
        this.chatService = r3;
        this.messageService = r4;
        this.chatAppContainer = r5;
        this.pluginInitData = new MutableLiveData();
        this.initData = new MutableLiveData();
        this.chat = new MutableLiveData();
        this.initErrorInfo = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
    }

    public <T> void observeWhenAvailable(String r6, Class<T> r7, LifecycleOwner r8, Observer<T> r9) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r9, "observer");
        i r4 = this.$$delegate_0;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r9, "observer");
        MutableLiveData r0 = r4.getLiveData(r6, r7);
        if (r0 == null) goto L5;
        r0.observe(r8, r9);
        return;
    L5:
        ConcurrentHashMap r1 = r4.b;
        Object r2 = r1.get(r6);
        if (r2 != null) goto L11;
        r2 = new ConcurrentHashMap();
        Object r3 = r1.putIfAbsent(r6, r2);
        if (r3 == null) goto L11;
        r2 = r3;
    L11:
        ConcurrentHashMap r5 = (ConcurrentHashMap) r2;
        Intrinsics.checkNotNull(r5);
        Object r10 = r5.get(r7);
        if (r10 != null) goto L17;
        r10 = new ArrayList();
        Object r11 = r5.putIfAbsent(r7, r10);
        if (r11 == null) goto L17;
        r10 = r11;
    L17:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ss.android.lark.biz.im.api.extension.chat_window.PageViewModelAttachImpl.Pending<T of com.ss.android.lark.biz.im.api.extension.chat_window.PageViewModelAttachImpl.observeWhenAvailable>>");
        TypeIntrinsics.asMutableList(r10).add(new i.a(r8, r9));
        r8.getLifecycle().addObserver(new PageViewModelAttachImpl.observeWhenAvailable.1(r5, r7, r4, r6));
    }

    public /* synthetic */ ChatWindowViewModel(fxa.b r1, ImSdkChatService r2, p r3, v r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}
