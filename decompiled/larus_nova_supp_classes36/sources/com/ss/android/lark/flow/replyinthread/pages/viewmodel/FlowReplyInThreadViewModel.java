package com.ss.android.lark.flow.replyinthread.pages.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.o0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.flow.replyinthread.pages.repo.c;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.replyinthread.pages.f;
import fxa.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020DH\u0002J\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001fH\u0002J\u0012\u0010J\u001a\u00020D2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010M\u001a\u00020!H\u0016J\b\u0010N\u001a\u00020!H\u0016J\b\u0010O\u001a\u00020!H\u0016J\b\u0010P\u001a\u00020!H\u0016J\u0018\u0010Q\u001a\u00020D2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020DH\u0016J\b\u0010V\u001a\u00020DH\u0016J\u0010\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b9\u0010:R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00101\u001a\u0004\b>\u0010?R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowReplyInThreadViewModel;", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel;", "appContext", "Landroid/content/Context;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getInitData", "initializeStateLiveData", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$InitializeState;", "kotlin.jvm.PlatformType", "getInitializeStateLiveData", "threadTopic", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "hasCreateThread", "", "showChatName", "loadFromFirstMessage", "jumpPosition", "", "getJumpPosition", "()I", "setJumpPosition", "(I)V", "forceShowKeyboardOnPageShow", "autoTranslateLanguageByForward", "threadService", "Lcom/ss/android/lark/biz/im/api/IThreadService;", "getThreadService", "()Lcom/ss/android/lark/biz/im/api/IThreadService;", "threadService$delegate", "Lkotlin/Lazy;", "chatService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "getChatService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "chatService$delegate", "chatterService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "getChatterService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "chatterService$delegate", "initLoader", "Lcom/ss/android/lark/flow/replyinthread/pages/loader/FlowReplyInThreadInitLoader;", "getInitLoader", "()Lcom/ss/android/lark/flow/replyinthread/pages/loader/FlowReplyInThreadInitLoader;", "initLoader$delegate", "startTimeSec", "", "onCreate", "", "page", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "loadInitData", "loadChat", IOfflineExtraParser.ParserType.THREAD, "loadChatInitData", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel$ISecretComponentReplaceCallback;", "inChat", "isThreadClosed", "needShowKeyBoard", "isFakeThreadTopic", "onUpdatePushThreadTopic", "Lkotlin/Function0;", "getMsgListRepoFactory", "Lcom/ss/android/lark/biz/im/api/MessageListRepositoryFactory;", "recordStartTime", "sendTimeDuration", "updateFeedCardReadStatus", "targetUnreadStatus", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowReplyInThreadViewModel extends FlowBaseReplyInThreadViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String LOG_TAG = "FlowReplyInThreadViewModel";
    private final Context appContext;
    private String autoTranslateLanguageByForward;
    private final MutableLiveData<Chat> chat;
    private final v chatAppContainer;
    private final b chatBundle;
    private String chatId;
    private final Lazy chatService$delegate;
    private final Lazy chatterService$delegate;
    private boolean forceShowKeyboardOnPageShow;
    private boolean hasCreateThread;
    private final MutableLiveData<i7b.a> initData;
    private final Lazy initLoader$delegate;
    private final MutableLiveData<ChatWindowOpenViewModel.InitializeState> initializeStateLiveData;
    private int jumpPosition;
    private boolean loadFromFirstMessage;
    private boolean showChatName;
    private long startTimeSec;
    private final Lazy threadService$delegate;
    private ThreadTopic threadTopic;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$1", f = "FlowReplyInThreadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ThreadTopic $thread;
        int label;
        final /* synthetic */ FlowReplyInThreadViewModel this$0;

        public AnonymousClass1(FlowReplyInThreadViewModel r1, ThreadTopic r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$thread = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$thread, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.getThreadTopicLiveData().setValue(this.$thread);
            this.this$0.getInitDataReady().setValue(Boxing.boxBoolean(true));
            this.this$0.getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZED);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$2", f = "FlowReplyInThreadViewModel.kt", i = {}, l = {141, 148}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ThreadTopic $thread;
        int label;
        final /* synthetic */ FlowReplyInThreadViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$loadChat$2$1", f = "FlowReplyInThreadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ aib.a.C0001a $data;
            final /* synthetic */ ThreadTopic $thread;
            int label;
            final /* synthetic */ FlowReplyInThreadViewModel this$0;

            public AnonymousClass1(FlowReplyInThreadViewModel r1, ThreadTopic r2, aib.a.C0001a r3, Continuation<? super AnonymousClass1> r4) {
                this.this$0 = r1;
                this.$thread = r2;
                this.$data = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass1(this.this$0, this.$thread, this.$data, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r5);
                this.this$0.getThreadTopicLiveData().setValue(this.$thread);
                this.this$0.getChatData().setValue(this.$data.a);
                this.this$0.getChat().setValue(this.$data.a);
                ChatChatter r6 = this.$data.b;
                if (r6 == null) goto L7;
                this.this$0.getP2pChatterData().setValue(r6);
            L7:
                ChatChatter r7 = this.$data.c;
                if (r7 == null) goto L10;
                this.this$0.getSelfChatterData().setValue(r7);
            L10:
                MutableLiveData<i7b.a> r8 = this.this$0.getInitData();
                i7b.a r0 = new i7b.a();
                aib.a.C0001a r1 = this.$data;
                FlowReplyInThreadViewModel r2 = this.this$0;
                r0.f = r1.a;
                r0.g = r1.b;
                r0.h = r1.c;
                r0.b = r2.getJumpPosition();
                r0.d = false;
                r8.setValue(r0);
                this.this$0.getInitDataReady().setValue(Boxing.boxBoolean(true));
                this.this$0.getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZED);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(FlowReplyInThreadViewModel r1, ThreadTopic r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$thread = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$thread, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L38:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L30:
            aib.a.C0001a r10 = (aib.a.C0001a) r9;
            if (r10.a != null) goto L34;
            MutableLiveData<Pair<FlowBaseReplyInThreadViewModel.ClosePageInfo, Object>> r11 = this.this$0.getClosePageInfo();
            FlowBaseReplyInThreadViewModel.ClosePageInfo r2 = FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE;
            Unit r3 = Unit.INSTANCE;
            r11.postValue(TuplesKt.to(r2, r3));
            Log.e(FlowReplyInThreadViewModel.LOG_TAG, "chat is null");
            return r3;
        L34:
            MainCoroutineDispatcher r5 = Dispatchers.getMain();
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$thread, r10, null);
            this.label = 2;
            if (BuildersKt.withContext(r5, r6, this) != r0) goto L38;
            return r0;
        L10:
            ResultKt.throwOnFailure(r9);
            aib.a r12 = FlowReplyInThreadViewModel.access$getInitLoader(this.this$0);
            String r7 = this.this$0.getChatId();
            String r8 = "";
            if (r7 != null) goto L13;
            r7 = "";
        L13:
            this.label = 1;
            Chat r13 = r12.a.we(r7);
            if (r13 != null) goto L16;
        L18:
            r4 = false;
        L19:
            if (r4 == false) goto L21;
            ChatChatter r14 = r12.b.He(r7, r13.getP2pChatterId());
        L22:
            h r15 = r12.b;
            String r16 = ChatCoreModule.a().getPassportDependency().userId();
            if (r16 == null) goto L26;
            r8 = r16;
        L26:
            aib.a.C0001a r17 = new aib.a.C0001a(r13, r14, r15.He(r7, r8));
            if (r17 != r0) goto L29;
            return r0;
        L29:
            r9 = r17;
            goto L30
        L21:
            r14 = null;
            goto L22
        L16:
            if (r13.isP2PChat() != true) goto L18;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$onUpdatePushThreadTopic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel$onUpdatePushThreadTopic$1", f = "FlowReplyInThreadViewModel.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;
        final /* synthetic */ FlowReplyInThreadViewModel this$0;

        public C03611(FlowReplyInThreadViewModel r1, Function0<Unit> r2, Continuation<? super C03611> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03611(this.this$0, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            ThreadTopic r5 = this.this$0.getThreadService().Vd(this.this$0.getThreadId());
            if (r5 == null) goto L14;
            this.this$0.getThreadTopicLiveData().postValue(r5);
        L14:
            Function0<Unit> r6 = this.$callback;
            if (r6 == null) goto L18;
            r6.invoke();
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void loadChatInitData(ChatWindowOpenViewModel.b r1) {
    }

    private final ImSdkChatService getChatService() {
        return (ImSdkChatService) this.chatService$delegate.getValue();
    }

    private final h getChatterService() {
        return (h) this.chatterService$delegate.getValue();
    }

    private final aib.a getInitLoader() {
        return (aib.a) this.initLoader$delegate.getValue();
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public z0 getMsgListRepoFactory() {
        return new c(this.chatAppContainer, this);
    }

    public final o0 getThreadService() {
        return (o0) this.threadService$delegate.getValue();
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean needShowKeyBoard() {
        if (this.hasCreateThread == true) goto L5;
    L8:
        return true;
    L5:
        if (this.forceShowKeyboardOnPageShow == true) goto L8;
        return false;
    }

    private final void loadInitData() {
        if (getThreadTopicLiveData().getValue() != null) goto L5;
        getThreadService().N6(getThreadId(), SyncDataStrategy.TRY_LOCAL, getCallbackManager().wrapAndAddCallback(new C03601(this)));
        return;
    L5:
        ThreadTopic r0 = (ThreadTopic) getThreadTopicLiveData().getValue();
        if (r0 == null) goto L10;
        loadChat(r0);
        return;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean inChat() {
        Chat r0 = (Chat) getChatData().getValue();
        if (r0 != null) goto L10;
        r0 = (Chat) getChat().getValue();
        if (r0 != null) goto L10;
        return true;
    L10:
        return r0.isMember();
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean isFakeThreadTopic() {
        ThreadTopic r0 = (ThreadTopic) getThreadTopicLiveData().getValue();
        if (r0 == null) goto L21;
        Boolean r2 = r0.isMock();
        if (r2 != null) goto L7;
        Chat r3 = (Chat) getChatData().getValue();
        if (r3 == null) goto L11;
        ChatDisplayModeSetting r4 = r3.getChatDisplayModeSetting();
    L13:
        if (r4 != ChatDisplayModeSetting.THREAD) goto L16;
        return false;
    L16:
        if (r0.getLastMsgPos() == (-1)) goto L22;
        return false;
    L22:
        return true;
    L11:
        r4 = null;
        goto L13
    L7:
        return r2.booleanValue();
    L21:
        return !this.hasCreateThread;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean isThreadClosed() {
        ThreadTopic r0 = (ThreadTopic) getThreadTopicLiveData().getValue();
        if (r0 == null) goto L7;
        ThreadStateInfo r1 = r0.getStateInfo();
        if (r1 == null) goto L7;
        ThreadStateInfo.ThreadState r2 = r1.getState();
    L9:
        if (r2 != ThreadStateInfo.ThreadState.CLOSED) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void recordStartTime() {
        this.startTimeSec = System.currentTimeMillis() / ((long) AudioViewModel.ASR_SESSION_IDLE);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void sendTimeDuration() {
        ChatCoreModule.a().getFeedDependency().f(Long.valueOf(this.startTimeSec), Long.valueOf(System.currentTimeMillis() / ((long) AudioViewModel.ASR_SESSION_IDLE)));
        this.startTimeSec = 0;
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

    public final int getJumpPosition() {
        return this.jumpPosition;
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public boolean showChatName() {
        return this.showChatName;
    }

    public static final /* synthetic */ v access$getChatAppContainer$p(FlowReplyInThreadViewModel r0) {
        return r0.chatAppContainer;
    }

    public static final /* synthetic */ ImSdkChatService access$getChatService(FlowReplyInThreadViewModel r0) {
        return r0.getChatService();
    }

    public static final /* synthetic */ h access$getChatterService(FlowReplyInThreadViewModel r0) {
        return r0.getChatterService();
    }

    public static final /* synthetic */ aib.a access$getInitLoader(FlowReplyInThreadViewModel r0) {
        return r0.getInitLoader();
    }

    private final void loadChat(ThreadTopic r18) {
        String r2 = getChatId();
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L16;
        Chat r5 = (Chat) getChatData().getValue();
        if (r5 == null) goto L14;
        String r6 = r5.getId();
        if (r6 == null) goto L14;
    L15:
        setChatId(r6);
    L14:
        r6 = r18.getChannel().getId();
    L16:
        String r7 = getChatId();
        if (r7 != null) goto L19;
    L22:
        if (r3 == false) goto L26;
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        return;
    L26:
        if (getChatData().getValue() == null) goto L29;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, r18, null), 2, null);
        return;
    L29:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(this, r18, null), 2, null);
        updateFeedCardReadStatus(false);
        return;
    L19:
        if (r7.length() == 0) goto L22;
        r3 = false;
        goto L22
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final void updateFeedCardReadStatus(boolean r5) {
        ChatCoreModule.a().getFeedDependency().b(getThreadId(), FeedCard.EntityType.THREAD, r5, UpdateUnreadStatusScene.HALF_SCREEN);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void onCreate(f r8) {
        Intrinsics.checkNotNullParameter(r8, "page");
        if ((r8 instanceof com.ss.android.lark.replyinthread.pages.b) == true) goto L7;
        Log.e(LOG_TAG, "thread page info is invalidate");
        getClosePageInfo().postValue(TuplesKt.to(FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE, Unit.INSTANCE));
        return;
    L7:
        if (getInitializeStateLiveData().getValue() == ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED) goto L9;
        return;
    L9:
        getInitializeStateLiveData().setValue(ChatWindowOpenViewModel.InitializeState.INITIALIZING);
        com.ss.android.lark.replyinthread.pages.b r9 = (com.ss.android.lark.replyinthread.pages.b) r8;
        setThreadId(r9.c);
        this.hasCreateThread = r9.d.getBoolean("key_params_has_create_thread", true);
        this.showChatName = r9.d.getBoolean("key_params_show_chat_name", true);
        String r0 = r9.d.getString("key_params_chat_id");
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        setChatId(r0);
        setCurrentFeedCardType(r9.d.getInt("key_params_feed_card_type", -1));
        this.loadFromFirstMessage = r9.d.getBoolean("key_params_load_from_start", false);
        this.jumpPosition = r9.d.getInt("key_params_jump_position", -100);
        setCurrentFeedCardType(r9.d.getInt("key_params_feed_card_type", -1));
        this.forceShowKeyboardOnPageShow = r9.d.getBoolean("key_params_show_keyboard", false);
        this.autoTranslateLanguageByForward = r9.d.getString("key_params_auto_translate_target_lang_by_card", "");
        loadInitData();
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void onUpdatePushThreadTopic(Function0<Unit> r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03611(this, r7, null), 2, null);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel
    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public final void setJumpPosition(int r1) {
        this.jumpPosition = r1;
    }

    public static final /* synthetic */ void access$loadChat(FlowReplyInThreadViewModel r0, ThreadTopic r1) {
        r0.loadChat(r1);
    }

    public static final /* synthetic */ void access$setThreadTopic$p(FlowReplyInThreadViewModel r0, ThreadTopic r1) {
        r0.threadTopic = r1;
    }

    public FlowReplyInThreadViewModel(Context r2, b r3, v r4) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        this.appContext = r2;
        this.chatBundle = r3;
        this.chatAppContainer = r4;
        this.chat = new MutableLiveData();
        this.initData = new MutableLiveData();
        this.initializeStateLiveData = new MutableLiveData(ChatWindowOpenViewModel.InitializeState.UN_INITIALIZED);
        this.hasCreateThread = true;
        this.showChatName = true;
        this.jumpPosition = -100;
        this.threadService$delegate = LazyKt.lazy(new FlowReplyInThreadViewModel$threadService$2(this));
        this.chatService$delegate = LazyKt.lazy(new FlowReplyInThreadViewModel$chatService$2(this));
        this.chatterService$delegate = LazyKt.lazy(new FlowReplyInThreadViewModel$chatterService$2(this));
        this.initLoader$delegate = LazyKt.lazy(new FlowReplyInThreadViewModel$initLoader$2(this));
    }
}
