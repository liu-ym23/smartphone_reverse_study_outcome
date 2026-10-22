package com.larus.bmhome.bot;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultActiveModelSettingItem;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.UserConfigActiveModeMenu;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.im.bean.bot.ModelItem;
import com.larus.platform.model.UserConfigItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u001dJ\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\rJ\u000e\u00107\u001a\u00020\u001d2\u0006\u0010+\u001a\u000208J\u0006\u00109\u001a\u00020\rJ\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\rJ\u0016\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u0004\u0018\u00010AJ\b\u0010E\u001a\u0004\u0018\u00010FJ\b\u0010G\u001a\u0004\u0018\u00010HJ\b\u0010I\u001a\u0004\u0018\u00010JJ\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020M\u0018\u00010Lj\u0004\u0018\u0001`NJ\u000e\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020HJ&\u0010Q\u001a\u00020\r2\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020M0Lj\u0002`NH\u0086@¢\u0006\u0002\u0010SJ\b\u0010T\u001a\u0004\u0018\u00010UJ\b\u0010V\u001a\u0004\u0018\u00010JR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR$\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000fR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000f¨\u0006W"}, d2 = {"Lcom/larus/bmhome/bot/AppSettingModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "voiceModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/bot/ModelItem;", "kotlin.jvm.PlatformType", "personalizedRecommend", "", "getPersonalizedRecommend", "()Landroidx/lifecycle/MutableLiveData;", "pictureLocation", "getPictureLocation", "relatedVideoEnableLiveData", "getRelatedVideoEnableLiveData", "defaultReplyModeLiveData", "getDefaultReplyModeLiveData", "defaultActiveModeLiveData", "getDefaultActiveModeLiveData", "userConfigsUpdatedLiveData", "", "Lcom/larus/platform/model/UserConfigItem;", "getUserConfigsUpdatedLiveData", "bindObservers", "", "isStreamMode", "toggleStream", "toggle", "answerWithSuggestLiveData", "getAnswerWithSuggestLiveData", "isPromptEnabled", "togglePromptEnabled", "isPromptStyleVertical", "togglePromptStyleVertical", "isInterruptEnabled", "toggleInterruptEnabled", "enable", "updateUserConfigs", "value", "realtimeCallEnabled", "getRealtimeCallEnabled", "()Z", "setRealtimeCallEnabled", "(Z)V", "highlightEngineEnableLiveData", "getHighlightEngineEnableLiveData", "isHighlightEnabled", "setHighlightEnable", "answerWithVideoLiveData", "getAnswerWithVideoLiveData", "saveAnswerWithVideo", "", "isRelatedVideoEnabled", "saveRelatedVideoEnabled", "saveDefaultModelItemKey", "itemKey", "itemId", "", "saveDefaultReplyOption", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getDefaultModelItemKey", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getDefaultReplyOption", "getDefaultActiveModeMenu", "Lcom/larus/bmhome/chat/model/api/UserConfigActiveModeMenu;", "getDefaultActiveModeSettingValue", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModeSettingValue;", "getDefaultActiveModelMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "getDefaultActiveModelSettingItem", "", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItem;", "Lcom/larus/bmhome/chat/model/api/DefaultActiveModelSettingItemMap;", "saveDefaultActiveMode", "defaultActiveModeSettingValue", "saveDefaultActiveModelSettingItemMap", "defaultActiveModelSettingItemMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultModelItemMenu", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuData;", "getDefaultReplyMenuDataV2", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AppSettingModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> answerWithSuggestLiveData;
    private final MutableLiveData<Boolean> answerWithVideoLiveData;
    private final MutableLiveData<Boolean> defaultActiveModeLiveData;
    private final MutableLiveData<Boolean> defaultReplyModeLiveData;
    private final MutableLiveData<Boolean> highlightEngineEnableLiveData;
    private final MutableLiveData<Boolean> personalizedRecommend;
    private final MutableLiveData<Boolean> pictureLocation;
    private final MutableLiveData<Boolean> relatedVideoEnableLiveData;
    private final ISettingRepoService repo;
    private final MutableLiveData<List<UserConfigItem>> userConfigsUpdatedLiveData;
    private final MutableLiveData<ModelItem> voiceModel;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$bindObservers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$bindObservers$1", f = "AppSettingViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AppSettingModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$bindObservers$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ AppSettingModel a;

            /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$bindObservers$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0035a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[UserConfigKey.values().length];
                    r0[UserConfigKey.PERSONAL_RECOMMEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
                L21:
                    r0[UserConfigKey.PICTURE_LOCATION_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
                L31:
                    r0[UserConfigKey.RELATED_VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
                L23:
                    r0[UserConfigKey.DEFAULT_REPLY_MODE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
                L25:
                    r0[UserConfigKey.DEFAULT_MODEL_ITEM_KEY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
                L19:
                    r0[UserConfigKey.DEFAULT_REPLY_OPTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
                L27:
                    r0[UserConfigKey.DEFAULT_ACTIVE_MODE_APP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
                L10:
                    a = r0;
                }
            }

            public a(AppSettingModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                switch(C0035a.a[((UserConfigKey) r1).ordinal()]) {
                    case 1: goto L9;
                    case 2: goto L8;
                    case 3: goto L7;
                    case 4: goto L6;
                    case 5: goto L6;
                    case 6: goto L6;
                    case 7: goto L5;
                    default: goto L11;
                };
            L5:
                this.a.getDefaultActiveModeLiveData().postValue(Boxing.boxBoolean(true));
                goto L11
            L6:
                this.a.getDefaultReplyModeLiveData().postValue(Boxing.boxBoolean(true));
                goto L11
            L7:
                this.a.getRelatedVideoEnableLiveData().postValue(Boxing.boxBoolean(true));
                goto L11
            L8:
                this.a.getPictureLocation().postValue(Boxing.boxBoolean(true));
                goto L11
            L9:
                this.a.getPersonalizedRecommend().postValue(Boxing.boxBoolean(true));
            L11:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(AppSettingModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            kotlinx.coroutines.flow.d1 r6 = UserSettingDelegate.b.i();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$saveAnswerWithVideo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$saveAnswerWithVideo$1", f = "AppSettingViewModel.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $value;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01301(String r1, AppSettingModel r2, Continuation<? super C01301> r3) {
            this.$value = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01301(this.$value, this.this$0, r4);
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
            this.this$0.getAnswerWithVideoLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            UserSettingDelegate r6 = UserSettingDelegate.b;
            String r2 = this.$value;
            this.label = 1;
            r4 = r6.d(r2, true, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$saveDefaultActiveMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$saveDefaultActiveMode$1", f = "AppSettingViewModel.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DefaultActiveModeSettingValue $defaultActiveModeSettingValue;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01311(AppSettingModel r1, DefaultActiveModeSettingValue r2, Continuation<? super C01311> r3) {
            this.this$0 = r1;
            this.$defaultActiveModeSettingValue = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01311(this.this$0, this.$defaultActiveModeSettingValue, r4);
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
            this.this$0.getDefaultActiveModeLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = AppSettingModel.access$getRepo$p(this.this$0);
            DefaultActiveModeSettingValue r2 = this.$defaultActiveModeSettingValue;
            this.label = 1;
            r4 = r6.G(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$saveDefaultModelItemKey$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$saveDefaultModelItemKey$1", f = "AppSettingViewModel.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $itemId;
        final /* synthetic */ String $itemKey;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01321(AppSettingModel r1, String r2, int r3, Continuation<? super C01321> r4) {
            this.this$0 = r1;
            this.$itemKey = r2;
            this.$itemId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01321(this.this$0, this.$itemKey, this.$itemId, r5);
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
            boolean r6 = ((Boolean) r5).booleanValue();
            this.this$0.getDefaultReplyModeLiveData().postValue(Boxing.boxBoolean(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ISettingRepoService r7 = AppSettingModel.access$getRepo$p(this.this$0);
            String r2 = this.$itemKey;
            int r3 = this.$itemId;
            this.label = 1;
            r5 = r7.C(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$saveDefaultReplyOption$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$saveDefaultReplyOption$1", f = "AppSettingViewModel.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_USER_TIMER_START}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReplyOption $replyOption;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01331(AppSettingModel r1, ReplyOption r2, Continuation<? super C01331> r3) {
            this.this$0 = r1;
            this.$replyOption = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01331(this.this$0, this.$replyOption, r4);
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
            this.this$0.getDefaultReplyModeLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = AppSettingModel.access$getRepo$p(this.this$0);
            ReplyOption r2 = this.$replyOption;
            this.label = 1;
            r4 = r6.o0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$saveRelatedVideoEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$saveRelatedVideoEnabled$1", f = "AppSettingViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01341(AppSettingModel r1, boolean r2, Continuation<? super C01341> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01341(this.this$0, this.$enable, r4);
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
            this.this$0.getRelatedVideoEnableLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = AppSettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$enable;
            this.label = 1;
            r4 = r6.n0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$setHighlightEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$setHighlightEnable$1", f = "AppSettingViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01351(AppSettingModel r1, boolean r2, Continuation<? super C01351> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01351(this.this$0, this.$enable, r4);
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
            ISettingRepoService r6 = AppSettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$enable;
            this.label = 1;
            r4 = r6.l(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$togglePromptEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$togglePromptEnabled$1", f = "AppSettingViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01361(AppSettingModel r1, boolean r2, Continuation<? super C01361> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01361(this.this$0, this.$toggle, r4);
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
            ISettingRepoService r3 = AppSettingModel.access$getRepo$p(this.this$0);
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

    /* JADX INFO: renamed from: com.larus.bmhome.bot.AppSettingModel$updateUserConfigs$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.AppSettingModel$updateUserConfigs$1", f = "AppSettingViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AppSettingModel this$0;

        public C01371(AppSettingModel r1, Continuation<? super C01371> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01371(this.this$0, r3);
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
            hq9.y4 r6 = (hq9.y4) r5;
            if (r6 == null) goto L14;
            ArrayList r7 = r6.a();
        L15:
            if (r7 == null) goto L18;
            AppSettingModel r2 = this.this$0;
            UserSettingDelegate.b.c(r7);
            r2.getUserConfigsUpdatedLiveData().setValue(r7);
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
            List r3 = UserConfigKey.a.b();
            int r4 = UserConfigPullReason.STARTUP.getValue();
            this.label = 1;
            r5 = r8.e(r3, r4, "settings_page", this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public final UserConfigActiveModeMenu getDefaultActiveModeMenu() {
        return this.repo.T();
    }

    public final DefaultActiveModeSettingValue getDefaultActiveModeSettingValue() {
        return this.repo.p0();
    }

    public final DefaultReplyMenuDataV2 getDefaultActiveModelMenu() {
        return this.repo.e0();
    }

    public final Map<String, DefaultActiveModelSettingItem> getDefaultActiveModelSettingItem() {
        return this.repo.L();
    }

    public final ModelItemIdentity getDefaultModelItemKey() {
        return this.repo.O0();
    }

    public final DefaultReplyMenuData getDefaultModelItemMenu() {
        return this.repo.L0();
    }

    public final DefaultReplyMenuDataV2 getDefaultReplyMenuDataV2() {
        return this.repo.y();
    }

    public final ReplyOption getDefaultReplyOption() {
        return this.repo.S();
    }

    public final boolean getRealtimeCallEnabled() {
        return this.repo.g();
    }

    public final boolean isHighlightEnabled() {
        return this.repo.o();
    }

    public final boolean isInterruptEnabled() {
        return this.repo.E();
    }

    public final boolean isPromptEnabled() {
        return this.repo.i();
    }

    public final boolean isPromptStyleVertical() {
        Integer r0 = (Integer) this.repo.w().getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final boolean isRelatedVideoEnabled() {
        return this.repo.q0();
    }

    public final boolean isStreamMode() {
        return this.repo.I();
    }

    private final void bindObservers() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void updateUserConfigs() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01371(this, null), 3, null);
    }

    public final MutableLiveData<Boolean> getAnswerWithSuggestLiveData() {
        return this.answerWithSuggestLiveData;
    }

    public final MutableLiveData<Boolean> getAnswerWithVideoLiveData() {
        return this.answerWithVideoLiveData;
    }

    public final MutableLiveData<Boolean> getDefaultActiveModeLiveData() {
        return this.defaultActiveModeLiveData;
    }

    public final MutableLiveData<Boolean> getDefaultReplyModeLiveData() {
        return this.defaultReplyModeLiveData;
    }

    public final MutableLiveData<Boolean> getHighlightEngineEnableLiveData() {
        return this.highlightEngineEnableLiveData;
    }

    public final MutableLiveData<Boolean> getPersonalizedRecommend() {
        return this.personalizedRecommend;
    }

    public final MutableLiveData<Boolean> getPictureLocation() {
        return this.pictureLocation;
    }

    public final MutableLiveData<Boolean> getRelatedVideoEnableLiveData() {
        return this.relatedVideoEnableLiveData;
    }

    public final MutableLiveData<List<UserConfigItem>> getUserConfigsUpdatedLiveData() {
        return this.userConfigsUpdatedLiveData;
    }

    public AppSettingModel(Application r12) {
        Intrinsics.checkNotNullParameter(r12, "application");
        super(r12);
        ISettingRepoService r13 = RepoDispatcherDelegate.b.c();
        this.repo = r13;
        ModelItem r10 = new ModelItem(null, 0, null, null, null, null, 63, null);
        r10.setModelName(r13.Z(r13.r0()));
        this.voiceModel = new MutableLiveData(r10);
        this.personalizedRecommend = new MutableLiveData();
        this.pictureLocation = new MutableLiveData();
        this.relatedVideoEnableLiveData = new MutableLiveData();
        this.defaultReplyModeLiveData = new MutableLiveData();
        this.defaultActiveModeLiveData = new MutableLiveData();
        this.userConfigsUpdatedLiveData = new MutableLiveData();
        bindObservers();
        this.answerWithSuggestLiveData = new MutableLiveData();
        this.highlightEngineEnableLiveData = new MutableLiveData();
        this.answerWithVideoLiveData = new MutableLiveData();
    }

    public static final /* synthetic */ ISettingRepoService access$getRepo$p(AppSettingModel r0) {
        return r0.repo;
    }

    public final void saveAnswerWithVideo(String r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01301(r8, this, null), 3, null);
    }

    public final void saveDefaultActiveMode(DefaultActiveModeSettingValue r8) {
        Intrinsics.checkNotNullParameter(r8, "defaultActiveModeSettingValue");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01311(this, r8, null), 3, null);
    }

    public final void saveDefaultReplyOption(ReplyOption r8) {
        Intrinsics.checkNotNullParameter(r8, "replyOption");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01331(this, r8, null), 3, null);
    }

    public final void saveRelatedVideoEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01341(this, r7, null), 3, null);
    }

    public final void setHighlightEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01351(this, r7, null), 3, null);
    }

    public final void setRealtimeCallEnabled(boolean r3) {
        if (FeatureKitDelegate.b.A0().b() == false) goto L5;
        this.repo.I0(r3);
        return;
    L5:
        EnsureManager.ensureNotReachHere("set realtime call enable error! value:" + r3);
        this.repo.I0(false);
    }

    public final void toggleInterruptEnabled(boolean r2) {
        this.repo.z(r2);
    }

    public final void togglePromptEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01361(this, r7, null), 3, null);
    }

    public final void togglePromptStyleVertical(boolean r2) {
        MutableLiveData r0 = this.repo.w();
        if (r2 == false) goto L5;
        int r3 = 1;
    L6:
        r0.postValue(Integer.valueOf(r3));
        return;
    L5:
        r3 = 2;
        goto L6
    }

    public final void toggleStream(boolean r2) {
        this.repo.a0(r2);
    }

    public final Object saveDefaultActiveModelSettingItemMap(Map<String, DefaultActiveModelSettingItem> r2, Continuation<? super Boolean> r3) {
        return this.repo.H0(r2, r3);
    }

    public final void saveDefaultModelItemKey(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "itemKey");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01321(this, r8, r9, null), 3, null);
    }
}
