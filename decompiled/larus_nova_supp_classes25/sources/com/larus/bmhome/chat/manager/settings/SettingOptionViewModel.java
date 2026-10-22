package com.larus.bmhome.chat.manager.settings;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.setting.SettingRepo;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import hq9.y4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0016\u00105\u001a\u00020\u00142\u0006\u00101\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b3\u0010\u0019¨\u00067"}, d2 = {"Lcom/larus/bmhome/chat/manager/settings/SettingOptionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "settingRepo", "Lcom/larus/bmhome/setting/SettingRepo;", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "Lkotlin/Lazy;", "conversationService", "Lcom/larus/im/service/IConversationService;", "getConversationService", "()Lcom/larus/im/service/IConversationService;", "conversationService$delegate", "updateUserConfigs", "Lkotlinx/coroutines/Job;", "answerWithSuggestLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getAnswerWithSuggestLiveData", "()Landroidx/lifecycle/MutableLiveData;", "isPromptEnabled", "togglePromptEnabled", "toggle", "inputSuggestEnableLiveData", "getInputSuggestEnableLiveData", "isInputSuggestEnable", "setInputSuggestEnable", "highlightEngineEnableLiveData", "getHighlightEngineEnableLiveData", "isHighlightEnabled", "setHighlightEnable", "enable", "personalizedRecommendLiveData", "getPersonalizedRecommendLiveData", "isPersonalizedRecommendEnable", "togglePersonalizedRecommendEnable", "findConversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBot", "Lcom/larus/im/bean/bot/BotModel;", "botId", "messagePushLiveData", "getMessagePushLiveData", "messagePushLiveData$delegate", "updateMessagePush", "messagePush", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SettingOptionViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> answerWithSuggestLiveData;
    private final Lazy botService$delegate;
    private final Lazy conversationService$delegate;
    private final MutableLiveData<Boolean> highlightEngineEnableLiveData;
    private final MutableLiveData<Boolean> inputSuggestEnableLiveData;
    private final Lazy messagePushLiveData$delegate;
    private final MutableLiveData<Boolean> personalizedRecommendLiveData;
    private final SettingRepo settingRepo;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setHighlightEnable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setHighlightEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public AnonymousClass1(SettingOptionViewModel r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$enable, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getHighlightEngineEnableLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            SettingRepo r6 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r2 = this.$enable;
            this.label = 1;
            r4 = r6.l(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setInputSuggestEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setInputSuggestEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C01561(SettingOptionViewModel r1, boolean r2, Continuation<? super C01561> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01561(this.this$0, this.$toggle, r4);
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
            MutableLiveData<Boolean> r2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.postValue(r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableLiveData<Boolean> r6 = this.this$0.getInputSuggestEnableLiveData();
            SettingRepo r3 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r4 = this.$toggle;
            this.L$0 = r6;
            this.label = 1;
            Object r7 = r3.R(r4, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePersonalizedRecommendEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePersonalizedRecommendEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C01571(SettingOptionViewModel r1, boolean r2, Continuation<? super C01571> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01571(this.this$0, this.$toggle, r4);
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
            MutableLiveData<Boolean> r2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.postValue(r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableLiveData<Boolean> r6 = this.this$0.getPersonalizedRecommendLiveData();
            SettingRepo r3 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r4 = this.$toggle;
            this.L$0 = r6;
            this.label = 1;
            r3.getClass();
            Object r7 = UserSettingCacheManager.n(UserSettingCacheManager.a, r4, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePromptEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePromptEnabled$1", f = "SettingOptionViewModel.kt", i = {}, l = {MessageCellStateTransformerType.DEVICE_OR_RUNTIME_CHANGED}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C01581(SettingOptionViewModel r1, boolean r2, Continuation<? super C01581> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01581(this.this$0, this.$toggle, r4);
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
            MutableLiveData<Boolean> r2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.postValue(r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableLiveData<Boolean> r6 = this.this$0.getAnswerWithSuggestLiveData();
            SettingRepo r3 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r4 = this.$toggle;
            this.L$0 = r6;
            this.label = 1;
            Object r7 = r3.Q(r4, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1", f = "SettingOptionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ boolean $messagePush;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1$a */
        public static final class a implements IIMCallback<uc9.t> {
            public final /* synthetic */ SettingOptionViewModel a;

            public final boolean mustInMain() {
                return !y0.a();
            }

            public a(SettingOptionViewModel r1) {
                this.a = r1;
            }

            public final void onFailure(IIMError r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a.getMessagePushLiveData().postValue(Boolean.FALSE);
            }

            public final void onSuccess(Object r2) {
                Intrinsics.checkNotNullParameter((uc9.t) r2, "result");
                this.a.getMessagePushLiveData().postValue(Boolean.TRUE);
            }
        }

        public C01591(SettingOptionViewModel r1, String r2, boolean r3, Continuation<? super C01591> r4) {
            this.this$0 = r1;
            this.$botId = r2;
            this.$messagePush = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01591(this.this$0, this.$botId, this.$messagePush, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            SettingOptionViewModel.access$getBotService(this.this$0).modifyMessagePush(this.$botId, this.$messagePush, new a(this.this$0));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateUserConfigs$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateUserConfigs$1", f = "SettingOptionViewModel.kt", i = {}, l = {MessageCellStateTransformerType.AWEME_POST_LIST}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C01601(Continuation<? super C01601> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01601(r2);
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
            y4 r6 = (y4) r5;
            if (r6 == null) goto L14;
            ArrayList r7 = r6.a();
        L15:
            if (r7 == null) goto L18;
            UserSettingDelegate.b.c(r7);
        L18:
            return Unit.INSTANCE;
        L14:
            r7 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IUserSettingRepoService r8 = RepoDispatcherDelegate.b.h();
            UserConfigKey.Companion.getClass();
            List r2 = UserConfigKey.a.b();
            int r3 = UserConfigPullReason.STARTUP.getValue();
            this.label = 1;
            r5 = r8.e(r2, r3, "settings_page", this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ com.larus.im.service.o Mo() {
        return botService_delegate$lambda$0();
    }

    public static /* synthetic */ com.larus.im.service.r No() {
        return conversationService_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return messagePushLiveData_delegate$lambda$2();
    }

    private final com.larus.im.service.o getBotService() {
        return (com.larus.im.service.o) this.botService$delegate.getValue();
    }

    private final com.larus.im.service.r getConversationService() {
        return (com.larus.im.service.r) this.conversationService$delegate.getValue();
    }

    private static final MutableLiveData messagePushLiveData_delegate$lambda$2() {
        return new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getMessagePushLiveData() {
        return (MutableLiveData) this.messagePushLiveData$delegate.getValue();
    }

    public final boolean isHighlightEnabled() {
        return this.settingRepo.o();
    }

    public final boolean isInputSuggestEnable() {
        return this.settingRepo.p();
    }

    public final boolean isPersonalizedRecommendEnable() {
        return this.settingRepo.R0();
    }

    public final boolean isPromptEnabled() {
        return this.settingRepo.i();
    }

    private static final com.larus.im.service.o botService_delegate$lambda$0() {
        return com.larus.im.d.a();
    }

    private static final com.larus.im.service.r conversationService_delegate$lambda$1() {
        return com.larus.im.d.d();
    }

    public final Job updateUserConfigs() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01601(null), 3, null);
    }

    public final MutableLiveData<Boolean> getAnswerWithSuggestLiveData() {
        return this.answerWithSuggestLiveData;
    }

    public final MutableLiveData<Boolean> getHighlightEngineEnableLiveData() {
        return this.highlightEngineEnableLiveData;
    }

    public final MutableLiveData<Boolean> getInputSuggestEnableLiveData() {
        return this.inputSuggestEnableLiveData;
    }

    public final MutableLiveData<Boolean> getPersonalizedRecommendLiveData() {
        return this.personalizedRecommendLiveData;
    }

    public SettingOptionViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        RepoDispatcher.a.getClass();
        this.settingRepo = RepoDispatcher.e;
        this.botService$delegate = LazyKt.lazy(new q());
        this.conversationService$delegate = LazyKt.lazy(new r());
        this.answerWithSuggestLiveData = new MutableLiveData();
        this.inputSuggestEnableLiveData = new MutableLiveData();
        this.highlightEngineEnableLiveData = new MutableLiveData();
        this.personalizedRecommendLiveData = new MutableLiveData();
        this.messagePushLiveData$delegate = LazyKt.lazy(new s());
    }

    public static final /* synthetic */ com.larus.im.service.o access$getBotService(SettingOptionViewModel r0) {
        return r0.getBotService();
    }

    public static final /* synthetic */ SettingRepo access$getSettingRepo$p(SettingOptionViewModel r0) {
        return r0.settingRepo;
    }

    public final Job setHighlightEnable(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    public final Job setInputSuggestEnable(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01561(this, r7, null), 3, null);
    }

    public final Job togglePersonalizedRecommendEnable(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01571(this, r7, null), 3, null);
    }

    public final Job togglePromptEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01581(this, r7, null), 3, null);
    }

    public final Object findBot(String r9, Continuation<? super BotModel> r10) {
        RepoDispatcher.a.getClass();
        return IBotRepoService.b.a(RepoDispatcher.g, r9, true, null, false, r10, 28);
    }

    public final Object findConversation(String r8, Continuation<? super wc9.e> r9) {
        RepoDispatcher.a.getClass();
        return IConversationRepoService$a.c(RepoDispatcher.f, r8, false, null, r9, 6);
    }

    public final Job updateMessagePush(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01591(this, r8, r9, null), 2, null);
    }
}
