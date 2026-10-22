package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import b38.b;
import c38.c;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.ChatReadable;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.h;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jdb.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u000278B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020)H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/ChatP2PReadableViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/BaseStrangerRelationViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/UserScopeServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/IChatP2PReadableService;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "p2pChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/larksuite/rucket/Rucket;)V", "chatReadableFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "getChatReadableFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "chatChangeToReadable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getChatChangeToReadable", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "bannerFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", "getBannerFlow", "tagFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "getTagFlow", "closeBannerActionFlow", BuildConfig.FLAVOR, "getCloseBannerActionFlow", "chatReadableLiveData", "Landroidx/lifecycle/MutableLiveData;", "isInWhiteList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pushSourceJob", "Lcom/larksuite/rucket/job/RucketJob;", "Lcom/bytedance/lark/pb/basic/v1/Entity;", "create", BuildConfig.FLAVOR, "setupInitData", "setupPush", "destroy", "onCleared", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "scopedRucket", "getScopedRucket", "()Lcom/larksuite/rucket/Rucket;", "setScopedRucket", "(Lcom/larksuite/rucket/Rucket;)V", "Companion", "P2PStrangerViewModelFactory", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatP2PReadableViewModel extends BaseStrangerRelationViewModel implements CoroutineScope, c<com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a> {
    public static final a Companion = null;
    private static final String TAG = "ChatP2PReadableViewModel";
    private final z0<StrangerBannerType> bannerFlow;
    private final MutableSharedFlow<Integer> chatChangeToReadable;
    private final z0<Integer> chatReadableFlow;
    private final MutableLiveData<Integer> chatReadableLiveData;
    private final MutableSharedFlow<Boolean> closeBannerActionFlow;
    private final CoroutineContext coroutineContext;
    private final g fgService;
    private final Chat initChat;
    private final AtomicBoolean isInWhiteList;
    private final Chatter p2pChatter;
    private RucketJob<Entity> pushSourceJob;
    private b scopedRucket;
    private final z0<StrangerTagType> tagFlow;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0014\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/ChatP2PReadableViewModel$P2PStrangerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/larksuite/rucket/Rucket;)V", "getInitChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatter", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getRucket", "()Lcom/larksuite/rucket/Rucket;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class P2PStrangerViewModelFactory implements ViewModelProvider.Factory {
        public final Chat a;
        public final Chatter b;
        public final g c;
        public final b d;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final <T extends ViewModel> T create(Class<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "modelClass");
            return new ChatP2PReadableViewModel(this.a, this.b, this.c, this.d);
        }

        public P2PStrangerViewModelFactory(Chat r2, Chatter r3, g r4, b r5) {
            Intrinsics.checkNotNullParameter(r2, "initChat");
            Intrinsics.checkNotNullParameter(r4, "fgService");
            Intrinsics.checkNotNullParameter(r5, "rucket");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(MutableLiveData r3, int r4, MutableSharedFlow r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Integer r0 = (Integer) r3.getValue();
            if (r0 != null) goto L6;
        L8:
            Integer r1 = (Integer) r3.getValue();
            if (r1 != null) goto L12;
        L15:
            Integer r2 = (Integer) r3.getValue();
            if (r2 != null) goto L19;
        L23:
            if (r6 == false) goto L25;
            r3.setValue(Integer.valueOf(r4));
            return;
        L25:
            r3.postValue(Integer.valueOf(r4));
            return;
        L19:
            if (r2.intValue() != 2) goto L23;
            if (r4 != 1) goto L23;
            if (r5 == null) goto L23;
            r5.tryEmit(-1);
            goto L23
        L12:
            if (r1.intValue() != 1) goto L15;
            if (r4 == 1) goto L15;
            return;
        L6:
            if (r0.intValue() != r4) goto L8;
        }

        public static /* synthetic */ void b(a r0, MutableLiveData r1, int r2, boolean r3) {
            r0.getClass();
            a(r1, r2, null, r3);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00781<T> implements FlowCollector {
            public final /* synthetic */ ChatP2PReadableViewModel a;

            public C00781(ChatP2PReadableViewModel r1) {
                this.a = r1;
            }

            public final Object a(Integer r5, Continuation<? super Unit> r6) {
                if ((r6 instanceof ChatP2PReadableViewModel$create$1$1$emit$1) == false) goto L7;
                ChatP2PReadableViewModel$create$1$1$emit$1 r0 = (ChatP2PReadableViewModel$create$1$1$emit$1) r6;
                int r1 = r0.label;
                if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
                r0.label = r1 - PluginList.LEVEL_NOT_SET;
            L8:
                Object r7 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                StrangerBannerType r8 = (StrangerBannerType) r0.L$0;
                ResultKt.throwOnFailure(r7);
            L22:
                if (r8 != StrangerBannerType.NONE) goto L25;
                this.a.getCloseBannerActionFlow().tryEmit(Boxing.boxBoolean(true));
            L25:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r7);
                Log.i(ChatP2PReadableViewModel.TAG, "chat readable live data update, try emit chat readable flow " + r5);
                z0<Integer> r9 = this.a.getChatReadableFlow();
                Intrinsics.checkNotNull(r5);
                r9.tryEmit(r5);
                this.a.getChatChangeToReadable().tryEmit(r5);
                if (r5.intValue() != 2) goto L17;
                r8 = StrangerBannerType.STRANGER;
            L18:
                z0<StrangerBannerType> r10 = this.a.getBannerFlow();
                r0.L$0 = r8;
                r0.label = 1;
                if (r10.emit(r8, r0) != r2) goto L22;
                return r2;
            L17:
                r8 = StrangerBannerType.NONE;
            L7:
                r0 = new ChatP2PReadableViewModel$create$1$1$emit$1(this, r6);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((Integer) r1, r2);
            }
        }

        public AnonymousClass1(ChatP2PReadableViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            Flow r6 = FlowLiveDataConversions.asFlow(ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0));
            C00781 r2 = new C00781(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupInitData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupInitData$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        public C03701(ChatP2PReadableViewModel r1, Chat r2, Continuation<? super C03701> r3) {
            this.this$0 = r1;
            this.$chat = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03701(this.this$0, this.$chat, r4);
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
        L11:
            com.larksuite.rucket.job.base.b.c r6 = (com.larksuite.rucket.job.base.b) r5;
            if ((r6 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L19;
            Boolean r7 = ((GetP2PChatUnfamiliarStrategyResponse) r6.b).hit_strategy;
            AtomicBoolean r2 = ChatP2PReadableViewModel.access$isInWhiteList$p(this.this$0);
            Intrinsics.checkNotNull(r7);
            r2.set(r7.booleanValue());
            if (r7.booleanValue() == true) goto L17;
            a.b(ChatP2PReadableViewModel.Companion, ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0), 1, false);
            return Unit.INSTANCE;
        L17:
            a r8 = ChatP2PReadableViewModel.Companion;
            MutableLiveData r3 = ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0);
            ChatReadable.a r4 = ChatReadable.Companion;
            Chat r9 = this.$chat;
            r4.getClass();
            a.b(r8, r3, ChatReadable.a.a(r9), false);
        L27:
            return Unit.INSTANCE;
        L19:
            if ((r6 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L29;
            ErrorResult r10 = ((com.larksuite.rucket.job.base.b.b) r6).a();
            if (r10 == null) goto L24;
            String r11 = r10.getMessage();
            if (r11 == null) goto L24;
        L25:
            Log.e(ChatP2PReadableViewModel.TAG, "fetch chat p2p white list failed ".concat(r11));
            a.b(ChatP2PReadableViewModel.Companion, ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0), 1, false);
        L24:
            r11 = "unknown";
            goto L25
        L29:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            GetP2PChatUnfamiliarStrategyRequest r12 = new GetP2PChatUnfamiliarStrategyRequest.Builder().strategy(GetP2PChatUnfamiliarStrategyRequest.SyncStrategy.TRY_LOCAL).build();
            com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a r13 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a.class);
            Intrinsics.checkNotNull(r12);
            RucketJob<GetP2PChatUnfamiliarStrategyResponse> r14 = r13.getP2PChatUnFamiliarStrategy(r12);
            this.label = 1;
            r5 = r14.awaitGet(this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupPush$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        public C03711(ChatP2PReadableViewModel r1, Continuation<? super C03711> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03711(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0057 -> B:16:0x005c). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r9);
            com.larksuite.rucket.job.extension.a r3 = r2;
            Object r4 = r0;
            C03711 r5 = this;
        L17:
            if (((Boolean) r9).booleanValue() == false) goto L26;
            com.larksuite.rucket.job.base.b r10 = r3.a();
            Map r11 = h.d(((Entity) r10.b()).chats, null, ((Entity) r10.b()).mail_setting);
            HashMap r12 = (HashMap) r11;
            Chat r13 = (Chat) r12.get(ChatP2PReadableViewModel.access$getInitChat$p(r5.this$0).getId());
            if (r13 != null) goto L22;
        L24:
            C03711 r14 = r5;
            r0 = r4;
            com.larksuite.rucket.job.extension.a r6 = r3;
        L12:
            r14.L$0 = r6;
            r14.label = 1;
            Object r7 = r6.hasNext(r14);
            if (r7 != r0) goto L15;
            return r0;
        L15:
            Object r8 = r0;
            r5 = r14;
            r9 = r7;
            r3 = r6;
            r4 = r8;
            goto L17
        L22:
            if (ChatP2PReadableViewModel.access$isInWhiteList$p(r5.this$0).get() == false) goto L24;
            a r15 = ChatP2PReadableViewModel.Companion;
            MutableLiveData r16 = ChatP2PReadableViewModel.access$getChatReadableLiveData$p(r5.this$0);
            ChatReadable.Companion.getClass();
            int r17 = ChatReadable.a.a(r13);
            MutableSharedFlow<Integer> r18 = r5.this$0.getChatChangeToReadable();
            r15.getClass();
            a.a(r16, r17, r18, false);
            goto L24
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            RucketJob<Entity> r19 = ((com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a.class)).chatsPush();
            if (ChatP2PReadableViewModel.access$getFgService$p(this.this$0).isEnable("im.chat.memory.disable_push_cancel") == true) goto L11;
            ChatP2PReadableViewModel.access$setPushSourceJob$p(this.this$0, r19);
        L11:
            r6 = r19.iterator();
            r14 = this;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    private final void setupPush() {
        BuildersKt.launch$default(this, null, null, new C03711(this, null), 3, null);
    }

    @JvmStatic
    public static final void updateChatReadableValue(MutableLiveData<Integer> r1, int r2, MutableSharedFlow<Integer> r3, boolean r4) {
        Companion.getClass();
        a.a(r1, r2, r3, r4);
    }

    public void destroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        RucketJob<Entity> r0 = this.pushSourceJob;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.pushSourceJob = null;
    }

    private final void setupInitData() {
        Chat r0 = this.initChat;
        if (r0.isP2PChat() == true) goto L5;
    L29:
        a.b(Companion, this.chatReadableLiveData, 1, true);
        return;
    L5:
        if (r0.isSecret() == true) goto L29;
        if (r0.isAIChat() == true) goto L29;
        Chatter r1 = this.p2pChatter;
        boolean r3 = false;
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L29;
        if (r0.isP2PChat() == false) goto L24;
        Chatter r4 = this.p2pChatter;
        if (r4 == null) goto L21;
        boolean r5 = r4.isBot();
    L22:
        if (r5 == false) goto L24;
        r3 = true;
        goto L24
    L21:
        r5 = false;
    L24:
        if (r3 == false) goto L27;
        a.b(Companion, this.chatReadableLiveData, 1, true);
        return;
    L27:
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new C03701(this, r0, null), 2, null);
        return;
    L11:
        if (r1.isDimission() != true) goto L13;
        r2 = true;
        goto L14
    }

    public void create() {
        g r0 = this.fgService;
        int r1 = l4b.a.a;
        Intrinsics.checkNotNullParameter(r0, "fgService");
        if (r0.isEnable("im.message.stranger") == false) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == true) goto L9;
        return;
    L9:
        if (this.fgService.isEnable("im.chat.readable_update") == false) goto L11;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
    L12:
        BuildersKt.launch$default(this, r3, null, new AnonymousClass1(this, null), 2, null);
        setupInitData();
        setupPush();
        return;
    L11:
        r3 = Dispatchers.getMain().getImmediate();
        goto L12
    L5:
        r2 = r0.isEnable("im.message.strangerchat");
        goto L6
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        RucketJob<Entity> r0 = this.pushSourceJob;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.pushSourceJob = null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<StrangerBannerType> getBannerFlow() {
        return this.bannerFlow;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public MutableSharedFlow<Integer> getChatChangeToReadable() {
        return this.chatChangeToReadable;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<Integer> getChatReadableFlow() {
        return this.chatReadableFlow;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public MutableSharedFlow<Boolean> getCloseBannerActionFlow() {
        return this.closeBannerActionFlow;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public b getScopedRucket() {
        return this.scopedRucket;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<StrangerTagType> getTagFlow() {
        return this.tagFlow;
    }

    public static final /* synthetic */ MutableLiveData access$getChatReadableLiveData$p(ChatP2PReadableViewModel r0) {
        return r0.chatReadableLiveData;
    }

    public static final /* synthetic */ g access$getFgService$p(ChatP2PReadableViewModel r0) {
        return r0.fgService;
    }

    public static final /* synthetic */ Chat access$getInitChat$p(ChatP2PReadableViewModel r0) {
        return r0.initChat;
    }

    public static final /* synthetic */ AtomicBoolean access$isInWhiteList$p(ChatP2PReadableViewModel r0) {
        return r0.isInWhiteList;
    }

    public void setScopedRucket(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scopedRucket = r2;
    }

    public static final /* synthetic */ void access$setPushSourceJob$p(ChatP2PReadableViewModel r0, RucketJob r1) {
        r0.pushSourceJob = r1;
    }

    public ChatP2PReadableViewModel(Chat r3, Chatter r4, g r5, b r6) {
        Intrinsics.checkNotNullParameter(r3, "initChat");
        Intrinsics.checkNotNullParameter(r5, "fgService");
        Intrinsics.checkNotNullParameter(r6, "rucket");
        this.initChat = r3;
        this.p2pChatter = r4;
        this.fgService = r5;
        this.chatReadableFlow = j1.a(0);
        this.chatChangeToReadable = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.bannerFlow = j1.a(StrangerBannerType.UNKNOWN);
        this.tagFlow = j1.a(StrangerTagType.NONE);
        this.closeBannerActionFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.chatReadableLiveData = new MutableLiveData();
        this.isInWhiteList = new AtomicBoolean(false);
        this.coroutineContext = Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        this.scopedRucket = r6;
    }
}
