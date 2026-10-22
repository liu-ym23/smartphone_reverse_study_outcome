package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.im.v1.ClearChatMessagesResponse;
import com.lark.kmp.pb.im.v1.DeleteChatChattersResponse;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import com.lark.kmp.server.pb.feed.PatchFeedCardPinResponse;
import com.ss.android.lark.compose.chatsetting.common.platform.AndroidChatSettingPlatformEffects;
import com.ss.android.lark.compose.chatsetting.common.platform.ChatSettingTrackEvent;
import com.ss.android.lark.compose.chatsetting.common.platform.d;
import com.ss.android.lark.compose.chatsetting.common.platform.e;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.ss.android.lark.compose.chatsetting.groupmanage.FlowGroupManageActivity;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0017\u0010\u001f\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010%\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010&\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010'\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010(\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u001f\u0010)\u001a\u00020\b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010.\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u0010/\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u00100\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u00101\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u00102\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#J\u0017\u00103\u001a\u00020\u001a2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0002\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00065"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/main/viewmodel/ChatSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "userId", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "isEnterpriseAccount", BuildConfig.FLAVOR, "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;ZLcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;)V", "getChatId", "()Ljava/lang/String;", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "hasLoggedDoubaoSetting", "viewModelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/chatsetting/main/viewmodel/ChatSettingState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchAndObserveChat", BuildConfig.FLAVOR, "observeQuit", "updateChatState", "newChat", "Lcom/lark/kmp/pb/basic/v1/Chat;", "toggleUseDoubaoInChat", "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "(Landroid/content/Context;)V", "toggleDoubaoProactiveReply", "back", "routeToGroupInfo", "routeToQrCode", "routeToGroupManage", "checkFunctionDisableAndShowDialog", "function", "Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;", "(Landroid/content/Context;Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;)Z", "toggleMute", "togglePin", "toggleSearch", "clearHistory", "disbandGroup", "exitGroup", "report", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSettingViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final String chatId;
    private boolean hasLoggedDoubaoSetting;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;
    private final i1<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> uiState;
    private final String userId;
    private final z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> viewModelState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$clearHistory$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$clearHistory$1", f = "ChatSettingViewModel.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public AnonymousClass1(ChatSettingViewModel r1, Context r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$context, r4);
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
            Object r5 = ((Result) r4).unbox-impl();
        L11:
            ChatSettingViewModel r2 = this.this$0;
            Context r3 = this.$context;
            if (Result.isSuccess-impl(r5) == false) goto L14;
            ClearChatMessagesResponse r6 = (ClearChatMessagesResponse) r5;
            ChatSettingViewModel.access$getPlatformEffects$p(r2).n(r3, com.ss.android.lark.compose.chatsetting.common.platform.c.C0129c.a);
        L14:
            ChatSettingViewModel r7 = this.this$0;
            Context r8 = this.$context;
            Throwable r9 = Result.exceptionOrNull-impl(r5);
            if (r9 == null) goto L18;
            ChatSettingViewModel.access$getPlatformEffects$p(r7).m(r8, r9);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ChatSettingRepository r10 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r11 = this.this$0.getChatId();
            this.label = 1;
            r5 = r10.c(r11, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$disbandGroup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$disbandGroup$1", f = "ChatSettingViewModel.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public C03881(ChatSettingViewModel r1, Context r2, Continuation<? super C03881> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03881(this.this$0, this.$context, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            ChatSettingViewModel r2 = this.this$0;
            Context r3 = this.$context;
            if (Result.isSuccess-impl(r7) == false) goto L14;
            UpdateChatResponse r4 = (UpdateChatResponse) r7;
            r2.back(r3);
        L14:
            ChatSettingViewModel r5 = this.this$0;
            Context r8 = this.$context;
            Throwable r9 = Result.exceptionOrNull-impl(r7);
            if (r9 == null) goto L18;
            ChatSettingViewModel.access$getPlatformEffects$p(r5).j(r5.getChatId(), false);
            ChatSettingViewModel.access$getPlatformEffects$p(r5).m(r8, r9);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ChatSettingRepository r10 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r11 = this.this$0.getChatId();
            this.label = 1;
            r7 = r10.d(r11, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$exitGroup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$exitGroup$1", f = "ChatSettingViewModel.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public C03891(ChatSettingViewModel r1, Context r2, Continuation<? super C03891> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03891(this.this$0, this.$context, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            ChatSettingViewModel r2 = this.this$0;
            Context r3 = this.$context;
            if (Result.isSuccess-impl(r7) == false) goto L14;
            DeleteChatChattersResponse r4 = (DeleteChatChattersResponse) r7;
            r2.back(r3);
        L14:
            ChatSettingViewModel r5 = this.this$0;
            Context r8 = this.$context;
            Throwable r9 = Result.exceptionOrNull-impl(r7);
            if (r9 == null) goto L18;
            ChatSettingViewModel.access$getPlatformEffects$p(r5).l(r5.getChatId(), false);
            ChatSettingViewModel.access$getPlatformEffects$p(r5).m(r8, r9);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ChatSettingRepository r10 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r11 = this.this$0.getChatId();
            String r12 = ChatSettingViewModel.access$getUserId$p(this.this$0);
            this.label = 1;
            r7 = r10.h(r11, r12, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$fetchAndObserveChat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$fetchAndObserveChat$1", f = "ChatSettingViewModel.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$fetchAndObserveChat$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatSettingViewModel a;

            public a(ChatSettingViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                ChatSettingViewModel r3 = this.a;
                ChatSettingViewModel.access$updateChatState(r3, (Chat) r1);
                return Unit.INSTANCE;
            }
        }

        public C03901(ChatSettingViewModel r1, Continuation<? super C03901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03901(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            c1 r6 = com.ss.android.lark.compose.chatsetting.common.repository.a.b(ChatSettingViewModel.access$getRepository$p(this.this$0), this.this$0.getChatId());
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$observeQuit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$observeQuit$1", f = "ChatSettingViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$observeQuit$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatSettingViewModel a;

            public a(ChatSettingViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r23, Continuation r24) {
                Unit r0 = (Unit) r23;
                z0 r1 = ChatSettingViewModel.access$getViewModelState$p(this.a);
            L3:
                Object r2 = r1.getValue();
                if (r1.compareAndSet(r2, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r2, null, null, null, null, 0, false, false, false, false, false, null, null, null, null, null, true, false, 196607)) == false) goto L3;
                return Unit.INSTANCE;
            }
        }

        public C03911(ChatSettingViewModel r1, Continuation<? super C03911> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03911(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            c1 r6 = com.ss.android.lark.compose.chatsetting.common.repository.a.c(ChatSettingViewModel.access$getRepository$p(this.this$0), this.this$0.getChatId(), ChatSettingViewModel.access$getUserId$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleDoubaoProactiveReply$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleDoubaoProactiveReply$2", f = "ChatSettingViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $currentState;
        final /* synthetic */ boolean $targetEnabled;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public AnonymousClass2(ChatSettingViewModel r1, boolean r2, Context r3, com.ss.android.lark.compose.foundation.widget.a r4, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$targetEnabled = r2;
            this.$context = r3;
            this.$currentState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.this$0, this.$targetEnabled, this.$context, this.$currentState, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r28) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r28);
            Object r3 = ((Result) r28).unbox-impl();
        L12:
            ChatSettingViewModel r4 = this.this$0;
            Context r5 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r6 = this.$currentState;
            Throwable r7 = Result.exceptionOrNull-impl(r3);
            if (r7 == null) goto L19;
            int r8 = c8b.a.a;
            c8b.a.a("[ChatSettingViewModel.toggleDoubaoProactiveReply] error: " + r7.getMessage());
            z0 r9 = ChatSettingViewModel.access$getViewModelState$p(r4);
        L15:
            Object r10 = r9.getValue();
            if (r9.compareAndSet(r10, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r10, null, null, null, null, 0, false, false, false, false, false, null, null, null, com.ss.android.lark.compose.foundation.widget.a.a(r6, false, false, 1), null, false, false, 253951)) == false) goto L15;
            ChatSettingViewModel.access$getPlatformEffects$p(r4).m(r5, r7);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r28);
            ChatSettingRepository r11 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r12 = this.this$0.getChatId();
            Boolean r13 = Boxing.boxBoolean(this.$targetEnabled);
            this.label = 1;
            Object r14 = r11.t(r12, null, r13, this);
            if (r14 != r1) goto L11;
            return r1;
        L11:
            r3 = r14;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleMute$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleMute$2", f = "ChatSettingViewModel.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $currentMuteState;
        final /* synthetic */ boolean $isMute;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public C03922(ChatSettingViewModel r1, boolean r2, Context r3, com.ss.android.lark.compose.foundation.widget.a r4, Continuation<? super C03922> r5) {
            this.this$0 = r1;
            this.$isMute = r2;
            this.$context = r3;
            this.$currentMuteState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03922(this.this$0, this.$isMute, this.$context, this.$currentMuteState, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r30);
            Object r3 = ((Result) r30).unbox-impl();
        L12:
            ChatSettingViewModel r4 = this.this$0;
            Context r5 = this.$context;
            if (Result.isSuccess-impl(r3) == false) goto L20;
            boolean r6 = ((Boolean) r3).booleanValue();
            z0 r7 = ChatSettingViewModel.access$getViewModelState$p(r4);
        L15:
            Object r8 = r7.getValue();
            if (r7.compareAndSet(r8, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r8, null, null, null, null, 0, false, false, false, false, false, new com.ss.android.lark.compose.foundation.widget.a(!r6, false), null, null, null, null, false, false, 261119)) == false) goto L15;
            if (r6 == true) goto L20;
            ChatSettingViewModel.access$getPlatformEffects$p(r4).n(r5, com.ss.android.lark.compose.chatsetting.common.platform.c.g.a);
        L20:
            ChatSettingViewModel r9 = this.this$0;
            Context r10 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r11 = this.$currentMuteState;
            Throwable r12 = Result.exceptionOrNull-impl(r3);
            if (r12 == null) goto L27;
            int r13 = c8b.a.a;
            c8b.a.a("[ChatSettingViewModel.toggleMute] error: " + r12.getMessage());
            z0 r14 = ChatSettingViewModel.access$getViewModelState$p(r9);
        L23:
            Object r15 = r14.getValue();
            if (r14.compareAndSet(r15, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r15, null, null, null, null, 0, false, false, false, false, false, com.ss.android.lark.compose.foundation.widget.a.a(r11, false, false, 1), null, null, null, null, false, false, 261119)) == false) goto L23;
            ChatSettingViewModel.access$getPlatformEffects$p(r9).m(r10, r12);
        L27:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r30);
            ChatSettingRepository r16 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r17 = this.this$0.getChatId();
            boolean r18 = this.$isMute;
            this.label = 1;
            Object r19 = r16.s(r17, r18, this);
            if (r19 != r1) goto L11;
            return r1;
        L11:
            r3 = r19;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$togglePin$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$togglePin$2", f = "ChatSettingViewModel.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $currentPinState;
        final /* synthetic */ boolean $targetPinned;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public C03932(ChatSettingViewModel r1, boolean r2, Context r3, com.ss.android.lark.compose.foundation.widget.a r4, Continuation<? super C03932> r5) {
            this.this$0 = r1;
            this.$targetPinned = r2;
            this.$context = r3;
            this.$currentPinState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03932(this.this$0, this.$targetPinned, this.$context, this.$currentPinState, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r46) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r46);
            Object r3 = ((Result) r46).unbox-impl();
        L12:
            ChatSettingViewModel r4 = this.this$0;
            boolean r5 = this.$targetPinned;
            if (Result.isSuccess-impl(r3) == false) goto L19;
            PatchFeedCardPinResponse r6 = (PatchFeedCardPinResponse) r3;
            z0 r7 = ChatSettingViewModel.access$getViewModelState$p(r4);
        L15:
            Object r8 = r7.getValue();
            if (r7.compareAndSet(r8, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r8, null, null, null, null, 0, false, false, false, false, false, null, new com.ss.android.lark.compose.foundation.widget.a(r5, false), null, null, null, false, false, 260095)) == false) goto L15;
        L19:
            ChatSettingViewModel r9 = this.this$0;
            Context r10 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r11 = this.$currentPinState;
            Throwable r12 = Result.exceptionOrNull-impl(r3);
            if (r12 == null) goto L26;
            int r13 = c8b.a.a;
            c8b.a.a("[ChatSettingViewModel.togglePin] error: " + r12.getMessage());
            z0 r14 = ChatSettingViewModel.access$getViewModelState$p(r9);
        L22:
            Object r15 = r14.getValue();
            if (r14.compareAndSet(r15, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r15, null, null, null, null, 0, false, false, false, false, false, null, com.ss.android.lark.compose.foundation.widget.a.a(r11, false, false, 1), null, null, null, false, false, 260095)) == false) goto L22;
            ChatSettingViewModel.access$getPlatformEffects$p(r9).m(r10, r12);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r46);
            ChatSettingRepository r16 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r17 = this.this$0.getChatId();
            boolean r18 = this.$targetPinned;
            this.label = 1;
            Object r19 = r16.m(r17, r18, this);
            if (r19 != r1) goto L11;
            return r1;
        L11:
            r3 = r19;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleUseDoubaoInChat$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel$toggleUseDoubaoInChat$2", f = "ChatSettingViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $currentUseState;
        final /* synthetic */ boolean $targetEnabled;
        int label;
        final /* synthetic */ ChatSettingViewModel this$0;

        public C03942(ChatSettingViewModel r1, boolean r2, Context r3, com.ss.android.lark.compose.foundation.widget.a r4, Continuation<? super C03942> r5) {
            this.this$0 = r1;
            this.$targetEnabled = r2;
            this.$context = r3;
            this.$currentUseState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03942(this.this$0, this.$targetEnabled, this.$context, this.$currentUseState, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r29) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r29);
            Object r3 = ((Result) r29).unbox-impl();
        L16:
            ChatSettingViewModel r4 = this.this$0;
            Context r5 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r6 = this.$currentUseState;
            Throwable r7 = Result.exceptionOrNull-impl(r3);
            if (r7 == null) goto L23;
            int r8 = c8b.a.a;
            c8b.a.a("[ChatSettingViewModel.toggleUseDoubaoInChat] error: " + r7.getMessage());
            z0 r9 = ChatSettingViewModel.access$getViewModelState$p(r4);
        L19:
            Object r10 = r9.getValue();
            if (r9.compareAndSet(r10, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r10, null, null, null, null, 0, false, false, false, false, false, null, null, com.ss.android.lark.compose.foundation.widget.a.a(r6, false, false, 1), null, null, false, false, 258047)) == false) goto L19;
            ChatSettingViewModel.access$getPlatformEffects$p(r4).m(r5, r7);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r29);
            ChatSettingRepository r11 = ChatSettingViewModel.access$getRepository$p(this.this$0);
            String r12 = this.this$0.getChatId();
            Boolean r13 = Boxing.boxBoolean(this.$targetEnabled);
            if (this.$targetEnabled == false) goto L11;
            Boolean r14 = null;
        L12:
            this.label = 1;
            Object r15 = r11.t(r12, r13, r14, this);
            if (r15 != r1) goto L15;
            return r1;
        L15:
            r3 = r15;
            goto L16
        L11:
            r14 = Boxing.boxBoolean(false);
            goto L12
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final void fetchAndObserveChat() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03901(this, null), 3, null);
    }

    private final void observeQuit() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03911(this, null), 3, null);
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final i1<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(ChatSettingViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(ChatSettingViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ String access$getUserId$p(ChatSettingViewModel r0) {
        return r0.userId;
    }

    public static final /* synthetic */ z0 access$getViewModelState$p(ChatSettingViewModel r0) {
        return r0.viewModelState;
    }

    private final void updateChatState(Chat r31) {
        ChatSettingViewModel r0 = this;
        Boolean r1 = r31.is_remind();
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        com.ss.android.lark.compose.foundation.widget.a r15 = new com.ss.android.lark.compose.foundation.widget.a(!r2, false);
        Boolean r3 = r31.is_temp_top_feed();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        com.ss.android.lark.compose.foundation.widget.a r12 = new com.ss.android.lark.compose.foundation.widget.a(r4, false);
        Chat.DoubaoSetting r5 = r31.getDoubao_setting();
        if (r5 == null) goto L15;
        Boolean r6 = r5.getDoubao_using_enabled();
        if (r6 == null) goto L15;
        boolean r11 = r6.booleanValue();
    L16:
        if (r11 == false) goto L24;
        if (r5 == null) goto L21;
        Boolean r7 = r5.getDoubao_proactive_reply_enabled();
        if (r7 == null) goto L21;
        boolean r8 = r7.booleanValue();
    L22:
        if (r8 == false) goto L24;
        boolean r10 = true;
    L25:
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r9 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r0.viewModelState.getValue();
        if (r0.hasLoggedDoubaoSetting == true) goto L28;
    L31:
        int r13 = c8b.a.a;
        c8b.a.b("[ChatSettingViewModel.updateChatState] apply Doubao setting, using=" + r11 + ", proactiveReply=" + r10);
        r0.hasLoggedDoubaoSetting = true;
    L32:
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r14 = r0.viewModelState;
    L33:
        Object r16 = r14.getValue();
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r17 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r16;
        Chat.Type r18 = r31.getType();
        String r19 = r31.getAvatar_key();
        if (r19 != null) goto L36;
        r19 = BuildConfig.FLAVOR;
    L36:
        String r20 = r31.getName();
        if (r20 != null) goto L39;
        r20 = BuildConfig.FLAVOR;
    L39:
        String r21 = r31.getChatter_id();
        if (r21 != null) goto L42;
        r21 = BuildConfig.FLAVOR;
    L42:
        Integer r22 = r31.getUser_count();
        if (r22 == null) goto L45;
        int r23 = r22.intValue();
    L46:
        boolean r110 = Intrinsics.areEqual(r31.getOwner_id(), r0.userId);
        Boolean r111 = r31.is_admin();
        if (r111 == null) goto L49;
        boolean r112 = r111.booleanValue();
    L50:
        Boolean r113 = r31.getOff_edit_group_chat_info();
        if (r113 == null) goto L53;
        boolean r114 = r113.booleanValue();
    L55:
        if (r31.getShare_card_permission() != Chat.ShareCardPermission.Enum.ALLOWED) goto L57;
        boolean r24 = true;
    L59:
        if (r31.getAdd_member_permission() != Chat.AddMemberPermission.Enum.ALL_MEMBERS) goto L61;
        boolean r25 = true;
    L62:
        com.ss.android.lark.compose.foundation.widget.a r26 = new com.ss.android.lark.compose.foundation.widget.a(r11, false);
        com.ss.android.lark.compose.foundation.widget.a r27 = new com.ss.android.lark.compose.foundation.widget.a(r10, false);
        String r115 = r31.getOwner_id();
        if (r115 != null) goto L66;
        r115 = BuildConfig.FLAVOR;
    L66:
        if (r31.getChat_mode() != Chat.ChatMode.THREAD_V2) goto L68;
        boolean r28 = true;
    L69:
        boolean r29 = r112;
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r116 = r14;
        boolean r210 = r10;
        boolean r117 = r24;
        boolean r211 = r11;
        boolean r118 = r25;
        com.ss.android.lark.compose.foundation.widget.a r212 = r12;
        com.ss.android.lark.compose.foundation.widget.a r213 = r15;
        if (r116.compareAndSet(r16, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a(r17, r18, r19, r20, r21, r23, r110, r29, r114, r117, r118, r15, r212, r26, r27, r115, false, r28, 81920)) == true) goto L71;
        r0 = this;
        r14 = r116;
        r15 = r213;
        r11 = r211;
        r12 = r212;
        r10 = r210;
        goto L33
    L71:
        this.platformEffects.h(r31);
        return;
    L68:
        r28 = false;
        goto L69
    L61:
        r25 = false;
        goto L62
    L57:
        r24 = false;
        goto L59
    L53:
        r114 = true;
        goto L55
    L49:
        r112 = false;
        goto L50
    L45:
        r23 = 0;
        goto L46
    L28:
        if (r9.m.a != r11) goto L31;
        if (r9.n.a == r10) goto L32;
    L21:
        r8 = false;
    L24:
        r10 = false;
    L15:
        r11 = true;
        goto L16
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = true;
        goto L6
    }

    public final void back(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        d8b.a.a(r2);
    }

    public final void clearHistory(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.platformEffects.o(ChatSettingTrackEvent.CLEAR_HISTORY_CONFIRM, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r10, null), 3, null);
    }

    public final void disbandGroup(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        this.platformEffects.o(ChatSettingTrackEvent.DISMISS_GROUP_CONFIRM, null);
        this.platformEffects.j(this.chatId, true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03881(this, r11, null), 3, null);
    }

    public final void exitGroup(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        this.platformEffects.o(ChatSettingTrackEvent.QUIT_GROUP_CONFIRM, null);
        this.platformEffects.l(this.chatId, true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03891(this, r11, null), 3, null);
    }

    public final void report(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.platformEffects.o(ChatSettingTrackEvent.REPORT, null);
        Throwable r0 = Result.exceptionOrNull-impl(this.platformEffects.k(r4, this.chatId, ViewModelKt.getViewModelScope(this)));
        if (r0 == null) goto L6;
        int r1 = c8b.a.a;
        c8b.a.a("[ChatSettingViewModel.report] error: " + r0.getMessage());
        this.platformEffects.m(r4, r0);
        return;
    }

    public final void routeToGroupInfo(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r0 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        boolean r2 = false;
        if (r0.b.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        if (r0.c.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L38;
        this.platformEffects.o(ChatSettingTrackEvent.EDIT_GROUP_INFO, null);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r4 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.f == false) goto L16;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        this.platformEffects.n(r10, com.ss.android.lark.compose.chatsetting.common.platform.c.f.a);
        return;
    L25:
        com.ss.android.lark.compose.chatsetting.common.platform.b r6 = this.platformEffects;
        String r7 = this.chatId;
        String r8 = r0.c;
        String r9 = r0.b;
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r11 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11.f == false) goto L28;
    L31:
        r2 = true;
    L32:
        Throwable r12 = Result.exceptionOrNull-impl(r6.i(r10, new d(r7, r8, r9, r2)));
        if (r12 == null) goto L37;
        int r13 = c8b.a.a;
        c8b.a.a("[ChatSettingViewModel.routeToGroupInfo] error: " + r12.getMessage());
        this.platformEffects.m(r10, r12);
        return;
    L37:
        return;
    L28:
        if (r11.g == true) goto L31;
        if (r11.h == true) goto L32;
    L16:
        if (r4.g == true) goto L21;
        if (r4.h == false) goto L21;
        r5 = false;
        goto L22
    L38:
        return;
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public final void routeToGroupManage(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.platformEffects.o(ChatSettingTrackEvent.GROUP_MANAGE, null);
        int r1 = d8b.a.a;
        String r2 = this.chatId;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intent r0 = new Intent(r5, FlowGroupManageActivity.class).putExtra("chat_id", r2);
        PassportcConvention.e(r0, LarkContext.getApplication());
        r5.startActivity(r0);
    }

    public final void routeToQrCode(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r0 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.f == false) goto L5;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        this.platformEffects.n(r7, com.ss.android.lark.compose.chatsetting.common.platform.c.e.a);
        return;
    L16:
        this.platformEffects.o(ChatSettingTrackEvent.GROUP_QR_CODE, null);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r2 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        Throwable r3 = Result.exceptionOrNull-impl(this.platformEffects.e(r7, new e(this.chatId, r2.b, r2.c, r2.p)));
        if (r3 == null) goto L20;
        int r4 = c8b.a.a;
        c8b.a.a("[ChatSettingViewModel.routeToQrCode] error: " + r3.getMessage());
        this.platformEffects.m(r7, r3);
        return;
    L20:
        return;
    L5:
        if (r0.g == true) goto L12;
        if (r0.i == true) goto L9;
    L11:
        r1 = false;
        goto L13
    L9:
        if (r0.j == false) goto L11;
        goto L11
    }

    public final void toggleDoubaoProactiveReply(Context r27) {
        Intrinsics.checkNotNullParameter(r27, "context");
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r0 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        if (b.a(r0) == true) goto L5;
        return;
    L5:
        if (r0.m.a == false) goto L15;
        com.ss.android.lark.compose.foundation.widget.a r4 = r0.n;
        boolean r5 = !r4.a;
        this.platformEffects.b(r0.a, true, r5);
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r1 = this.viewModelState;
    L8:
        Object r2 = r1.getValue();
        if (r1.compareAndSet(r2, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r2, null, null, null, null, 0, false, false, false, false, false, null, null, null, com.ss.android.lark.compose.foundation.widget.a.a(r4, false, true, 1), null, false, false, 253951)) == false) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r5, r27, r4, null), 3, null);
        return;
    }

    public final void toggleMute(Context r27) {
        Intrinsics.checkNotNullParameter(r27, "context");
        com.ss.android.lark.compose.foundation.widget.a r4 = ((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue()).k;
        boolean r2 = r4.a;
        this.platformEffects.o(ChatSettingTrackEvent.MUTE_TOGGLE, Boolean.valueOf(!r2));
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r0 = this.viewModelState;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r1, null, null, null, null, 0, false, false, false, false, false, com.ss.android.lark.compose.foundation.widget.a.a(r4, false, true, 1), null, null, null, null, false, false, 261119)) == false) goto L3;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03922(this, r2, r27, r4, null), 3, null);
    }

    public final void togglePin(Context r27) {
        Intrinsics.checkNotNullParameter(r27, "context");
        com.ss.android.lark.compose.foundation.widget.a r4 = ((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue()).l;
        boolean r2 = !r4.a;
        this.platformEffects.o(ChatSettingTrackEvent.PIN_TOGGLE, Boolean.valueOf(r2));
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r0 = this.viewModelState;
    L3:
        Object r5 = r0.getValue();
        if (r0.compareAndSet(r5, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r5, null, null, null, null, 0, false, false, false, false, false, null, com.ss.android.lark.compose.foundation.widget.a.a(r4, false, true, 1), null, null, null, false, false, 260095)) == false) goto L3;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03932(this, r2, r27, r4, null), 3, null);
    }

    public final void toggleSearch(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.platformEffects.o(ChatSettingTrackEvent.SEARCH, null);
        int r1 = d8b.a.a;
        String r2 = this.chatId;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        ((tza.a) LarkContext.spiByDwarf(tza.a.class)).R0(r5, r2);
    }

    public final void toggleUseDoubaoInChat(Context r28) {
        Intrinsics.checkNotNullParameter(r28, "context");
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r0 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) this.viewModelState.getValue();
        if (b.a(r0) == true) goto L5;
        return;
    L5:
        com.ss.android.lark.compose.foundation.widget.a r4 = r0.m;
        boolean r5 = !r4.a;
        this.platformEffects.b(r0.a, false, r5);
        z0<com.ss.android.lark.compose.chatsetting.main.viewmodel.a> r1 = this.viewModelState;
    L6:
        Object r2 = r1.getValue();
        if (r1.compareAndSet(r2, com.ss.android.lark.compose.chatsetting.main.viewmodel.a.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r2, null, null, null, null, 0, false, false, false, false, false, null, null, com.ss.android.lark.compose.foundation.widget.a.a(r4, false, true, 1), null, null, false, false, 258047)) == false) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03942(this, r5, r28, r4, null), 3, null);
    }

    public static final /* synthetic */ void access$updateChatState(ChatSettingViewModel r0, Chat r1) {
        r0.updateChatState(r1);
    }

    public final boolean checkFunctionDisableAndShowDialog(Context r2, ChatSettingFunction r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "function");
        return this.platformEffects.a(r2, r3);
    }

    public ChatSettingViewModel(String r2, String r3, com.lark.kmp.rustclient.api.d r4, boolean r5, com.ss.android.lark.compose.chatsetting.common.platform.b r6) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        Intrinsics.checkNotNullParameter(r6, "platformEffects");
        this.chatId = r2;
        this.userId = r3;
        this.platformEffects = r6;
        this.repository = new ChatSettingRepository(r4);
        StateFlowImpl r7 = j1.a(new com.ss.android.lark.compose.chatsetting.main.viewmodel.a(r5, 245759));
        this.viewModelState = r7;
        this.uiState = kotlinx.coroutines.flow.e.b(r7);
        fetchAndObserveChat();
        observeQuit();
    }

    public ChatSettingViewModel(String r7, String r8, com.lark.kmp.rustclient.api.d r9, boolean r10, com.ss.android.lark.compose.chatsetting.common.platform.b r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = new AndroidChatSettingPlatformEffects(null);
    L9:
        this(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
