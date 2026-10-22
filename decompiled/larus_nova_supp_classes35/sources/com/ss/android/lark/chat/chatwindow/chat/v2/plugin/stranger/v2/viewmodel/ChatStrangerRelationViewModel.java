package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import a2b.l;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UserStrangerRelation;
import com.bytedance.lark.pb.contact.v2.GetUserBlockStatusRequest;
import com.bytedance.lark.pb.contact.v2.PushContactApplicationBannerAffectEvent;
import com.bytedance.lark.pb.contact.v2.PushUserBlockStatusChangeEvent;
import com.bytedance.lark.pb.im.v1.GetCanSetStrangerRequest;
import com.bytedance.lark.pb.im.v1.GetUserStrangerRelationRequest;
import com.bytedance.lark.pb.im.v1.PushUserStrangerRelation;
import com.bytedance.lark.pb.im.v1.PushUserStrangerRelationEntity;
import com.bytedance.lark.pb.im.v1.PutStrangerRelationSource;
import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingRequest;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import jdb.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
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
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0005JKLMNB1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0002J\u001a\u00105\u001a\u0002032\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000203\u0018\u000107H\u0002J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000203H\u0002J\u000e\u0010;\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\u0018\u0010C\u001a\u0004\u0018\u00010\u001c2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\b\u0010D\u001a\u000203H\u0016J\b\u0010E\u001a\u000203H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020,0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0014\u0010F\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I¨\u0006O"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/ChatStrangerRelationViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/BaseStrangerRelationViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/UserScopeServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/IStrangerRelationService;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "p2pChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "strangerActionUploader", "Lcom/ss/android/lark/chat/api/service/IStrangerActionUploader;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/ss/android/lark/chat/api/service/IStrangerActionUploader;Lcom/larksuite/rucket/Rucket;)V", "scopedRucket", "getScopedRucket", "()Lcom/larksuite/rucket/Rucket;", "setScopedRucket", "(Lcom/larksuite/rucket/Rucket;)V", "isStrangerAvailable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_strangerRelationLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/ChatStrangerRelationViewModel$UserStrangerRelationWrapper;", "_userBlockStatusLiveData", BuildConfig.FLAVOR, "_userCanSetStrangerLiveData", "chatReadableLiveData", BuildConfig.FLAVOR, "chatReadableFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getChatReadableFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "chatChangeToReadable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getChatChangeToReadable", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "bannerFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", "getBannerFlow", "tagFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "getTagFlow", "closeBannerActionFlow", "getCloseBannerActionFlow", "calculateChatReadable", "isStranger", "create", BuildConfig.FLAVOR, "initBannerAndTagType", "setupInitData", "doOnNext", "Lkotlin/Function0;", "setupPush", "fetchData", "triggerReadableDataChange", "fetchUniversalUserSetting", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserStrangerRelation", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/ChatStrangerRelationViewModel$UserStrangerRelation;", "userId", BuildConfig.FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserBlockStatus", "fetchCanSetStranger", "destroy", "onCleared", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "UserStrangerRelation", "UserStrangerRelationWrapper", "StrangerRelationSource", "ChatStrangerRelationViewModelFactory", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatStrangerRelationViewModel extends BaseStrangerRelationViewModel implements CoroutineScope, c38.c<com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a> {
    public static final a Companion = null;
    private static final String TAG = "ChatStrangerRelationVM";
    public static final String USER_PRIVACY_AVAILABLE = "USER_PRIVACY_AVAILABLE";
    private final MutableLiveData<c> _strangerRelationLiveData;
    private final MutableLiveData<Boolean> _userBlockStatusLiveData;
    private final MutableLiveData<Boolean> _userCanSetStrangerLiveData;
    private final z0<StrangerBannerType> bannerFlow;
    private final MutableSharedFlow<Integer> chatChangeToReadable;
    private final z0<Integer> chatReadableFlow;
    private final MutableLiveData<Integer> chatReadableLiveData;
    private final MutableSharedFlow<Boolean> closeBannerActionFlow;
    private final CoroutineContext coroutineContext;
    private final g fgService;
    private final Chat initChat;
    private final AtomicBoolean isStrangerAvailable;
    private final Chatter p2pChatter;
    private b38.b scopedRucket;
    private final l strangerActionUploader;
    private final z0<StrangerTagType> tagFlow;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0018\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/ChatStrangerRelationViewModel$ChatStrangerRelationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "strangerActionUploader", "Lcom/ss/android/lark/chat/api/service/IStrangerActionUploader;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/ss/android/lark/chat/api/service/IStrangerActionUploader;Lcom/larksuite/rucket/Rucket;)V", "getInitChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatter", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getStrangerActionUploader", "()Lcom/ss/android/lark/chat/api/service/IStrangerActionUploader;", "getRucket", "()Lcom/larksuite/rucket/Rucket;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatStrangerRelationViewModelFactory implements ViewModelProvider.Factory {
        public final Chat a;
        public final Chatter b;
        public final g c;
        public final l d;
        public final b38.b e;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final <T extends ViewModel> T create(Class<T> r8) {
            Intrinsics.checkNotNullParameter(r8, "modelClass");
            return new ChatStrangerRelationViewModel(this.a, this.b, this.c, this.d, this.e);
        }

        public ChatStrangerRelationViewModelFactory(Chat r2, Chatter r3, g r4, l r5, b38.b r6) {
            Intrinsics.checkNotNullParameter(r2, "initChat");
            Intrinsics.checkNotNullParameter(r4, "fgService");
            Intrinsics.checkNotNullParameter(r5, "strangerActionUploader");
            Intrinsics.checkNotNullParameter(r6, "rucket");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v2/viewmodel/ChatStrangerRelationViewModel$StrangerRelationSource;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SOURCE_FETCH", "SOURCE_UNKNOWN", "SOURCE_PROFILE", "SOURCE_MESSAGE", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StrangerRelationSource extends Enum<StrangerRelationSource> {
        public static final a Companion = null;
        public static final StrangerRelationSource SOURCE_FETCH = null;
        public static final StrangerRelationSource SOURCE_MESSAGE = null;
        public static final StrangerRelationSource SOURCE_PROFILE = null;
        public static final StrangerRelationSource SOURCE_UNKNOWN = null;
        public static final /* synthetic */ StrangerRelationSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {

            /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$StrangerRelationSource$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0079a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[PutStrangerRelationSource.values().length];
                    r0[PutStrangerRelationSource.SOURCE_UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[PutStrangerRelationSource.SOURCE_PROFILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[PutStrangerRelationSource.SOURCE_MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    a = r0;
                }
            }

            public a() {
            }

            @JvmStatic
            public static StrangerRelationSource a(PutStrangerRelationSource r1) {
                Intrinsics.checkNotNullParameter(r1, "<this>");
                int r2 = C0079a.a[r1.ordinal()];
                if (r2 == 1) goto L13;
                if (r2 == 2) goto L15;
                if (r2 != 3) goto L10;
                return StrangerRelationSource.SOURCE_MESSAGE;
            L10:
                throw new NoWhenBranchMatchedException();
            L15:
                return StrangerRelationSource.SOURCE_PROFILE;
            L13:
                return StrangerRelationSource.SOURCE_UNKNOWN;
            }
        }

        public static EnumEntries<StrangerRelationSource> getEntries() {
            return b;
        }

        @JvmStatic
        public static final StrangerRelationSource parse(PutStrangerRelationSource r1) {
            Companion.getClass();
            return a.a(r1);
        }

        static {
            StrangerRelationSource r0 = new StrangerRelationSource("SOURCE_FETCH", 0, -1);
            SOURCE_FETCH = r0;
            StrangerRelationSource r1 = new StrangerRelationSource("SOURCE_UNKNOWN", 1, 0);
            SOURCE_UNKNOWN = r1;
            StrangerRelationSource r3 = new StrangerRelationSource("SOURCE_PROFILE", 2, 1);
            SOURCE_PROFILE = r3;
            StrangerRelationSource r5 = new StrangerRelationSource("SOURCE_MESSAGE", 3, 2);
            SOURCE_MESSAGE = r5;
            StrangerRelationSource[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static StrangerRelationSource[] values() {
            return (StrangerRelationSource[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StrangerRelationSource valueOf(String r1) {
            return (StrangerRelationSource) r27.a.a(StrangerRelationSource.class, r1);
        }

        public StrangerRelationSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(MutableLiveData r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Integer r0 = (Integer) r1.getValue();
            if (r0 != null) goto L6;
        L8:
            if (r3 == false) goto L10;
            r1.setValue(Integer.valueOf(r2));
            return;
        L10:
            r1.postValue(Integer.valueOf(r2));
            return;
        L6:
            if (r0.intValue() != r2) goto L8;
        }

        @JvmStatic
        public static void b(MutableLiveData r5, c r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r6, "newValue");
            if (Intrinsics.areEqual(r5.getValue(), r6) == false) goto L5;
            return;
        L5:
            c r0 = (c) r5.getValue();
            if (r0 == null) goto L10;
            b r1 = r0.a;
            if (r1 == null) goto L10;
            long r2 = r1.c;
        L12:
            if (r2 <= r6.a.c) goto L14;
            return;
        L14:
            if (r7 == false) goto L16;
            r5.setValue(r6);
            return;
        L16:
            r5.postValue(r6);
            return;
        L10:
            r2 = 0;
            goto L12
        }
    }

    public static final class b {
        public static final /* synthetic */ int d = 0;
        public final long a;
        public final boolean b;
        public final long c;

        public static final class a {
            @JvmStatic
            public static b a(UserStrangerRelation r7) {
                Intrinsics.checkNotNullParameter(r7, "<this>");
                return new b(r7.user_id.longValue(), r7.is_stranger.booleanValue(), r7.update_time.longValue());
            }
        }

        static {
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L6:
            long r3 = this.c;
            return ((r1 + r2) * 31) + ((int) (r3 ^ (r3 >>> 32)));
        L5:
            r2 = 1237;
            goto L6
        }

        public final String toString() {
            return "UserStrangerRelation(userId=" + this.a + ", isStranger=" + this.b + ", updateTime=" + this.c + ')';
        }

        public final String a() {
            return "UserStrangerRelation(userId=" + this.a + ", isStranger=" + this.b + ", updateTime=" + this.c + ')';
        }

        public b(long r1, boolean r3, long r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final b a;
        public final StrangerRelationSource b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "UserStrangerRelationWrapper(relation=" + this.a + ", source=" + this.b + ", isOnlinePush=" + this.c + ')';
        }

        public c(b r2, StrangerRelationSource r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "relation");
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ MediatorLiveData<Integer> a;
        public final /* synthetic */ ChatStrangerRelationViewModel b;

        public d(MediatorLiveData<Integer> r1, ChatStrangerRelationViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            c r6 = (c) r5;
            Integer r0 = (Integer) this.a.getValue();
            int r1 = ChatStrangerRelationViewModel.access$calculateChatReadable(this.b, r6.a.b);
            if (r0 != null) goto L6;
        L19:
            if (r0 != null) goto L22;
        L23:
            Log.i(ChatStrangerRelationViewModel.TAG, "chat readable live data value update to " + r1 + ", current value is " + r0);
        L24:
            this.a.setValue(Integer.valueOf(r1));
            return;
        L22:
            if (r0.intValue() == r1) goto L24;
        L6:
            if (r0.intValue() != 2) goto L19;
            if (r1 != 1) goto L19;
            if (r6.b == StrangerRelationSource.SOURCE_MESSAGE) goto L12;
        L18:
            this.b.getCloseBannerActionFlow().tryEmit(Boolean.TRUE);
            goto L19
        L12:
            if (r6.c == false) goto L18;
            if (Intrinsics.areEqual(ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(this.b).getValue(), Boolean.TRUE) == false) goto L16;
            int r7 = 2131891137;
        L17:
            this.b.getChatChangeToReadable().tryEmit(Integer.valueOf(r7));
            goto L18
        L16:
            r7 = 2131891195;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$fetchData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$fetchData$1", f = "ChatStrangerRelationViewModel.kt", i = {1, 2}, l = {261, 271, 274, 277}, m = "invokeSuspend", n = {"userId", "userId"}, s = {"J$0", "J$0"})
    public static final class C03721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        public C03721(ChatStrangerRelationViewModel r1, Continuation<? super C03721> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03721(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r11);
        L33:
            MutableLiveData r2 = ChatStrangerRelationViewModel.access$get_userCanSetStrangerLiveData$p(this.this$0);
            r2.postValue((Boolean) r11);
        L36:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            long r3 = this.J$0;
            ResultKt.throwOnFailure(r11);
        L30:
            ChatStrangerRelationViewModel r4 = this.this$0;
            boolean r12 = ((Boolean) r11).booleanValue();
            ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(r4).postValue(Boxing.boxBoolean(r12));
            ChatStrangerRelationViewModel r13 = this.this$0;
            this.label = 4;
            r11 = ChatStrangerRelationViewModel.access$fetchCanSetStranger(r13, r3, this);
            if (r11 != r0) goto L33;
            return r0;
        L12:
            r3 = this.J$0;
            ResultKt.throwOnFailure(r11);
        L24:
            b r14 = (b) r11;
            if (r14 == null) goto L27;
            ChatStrangerRelationViewModel r5 = this.this$0;
            a r6 = ChatStrangerRelationViewModel.Companion;
            MutableLiveData r7 = ChatStrangerRelationViewModel.access$get_strangerRelationLiveData$p(r5);
            c r8 = new c(r14, StrangerRelationSource.SOURCE_FETCH, false);
            r6.getClass();
            a.b(r7, r8, false);
        L27:
            ChatStrangerRelationViewModel r15 = this.this$0;
            this.J$0 = r3;
            this.label = 3;
            r11 = ChatStrangerRelationViewModel.access$fetchUserBlockStatus(r15, r3, this);
            if (r11 != r0) goto L30;
            return r0;
        L13:
            ResultKt.throwOnFailure(r11);
        L17:
            boolean r16 = ((Boolean) r11).booleanValue();
            ChatStrangerRelationViewModel.access$isStrangerAvailable$p(this.this$0).set(r16);
            Long r17 = StringsKt.toLongOrNull(ChatStrangerRelationViewModel.access$getInitChat$p(this.this$0).getP2pChatterId());
            if (r17 == null) goto L37;
            r3 = r17.longValue();
            if (ChatStrangerRelationViewModel.access$isStrangerAvailable$p(this.this$0).get() == false) goto L34;
            ChatStrangerRelationViewModel r18 = this.this$0;
            this.J$0 = r3;
            this.label = 2;
            r11 = ChatStrangerRelationViewModel.access$fetchUserStrangerRelation(r18, r3, this);
            if (r11 != r0) goto L24;
            return r0;
        L34:
            ChatStrangerRelationViewModel.access$triggerReadableDataChange(this.this$0);
            goto L36
        L37:
            Log.e(ChatStrangerRelationViewModel.TAG, "userId can't transform to Long!");
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r11);
            Log.i(ChatStrangerRelationViewModel.TAG, "fetch user settings start");
            ChatStrangerRelationViewModel r19 = this.this$0;
            this.label = 1;
            r11 = ChatStrangerRelationViewModel.access$fetchUniversalUserSetting(r19, this);
            if (r11 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$1", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatStrangerRelationViewModel a;

            public a(ChatStrangerRelationViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                Integer r6 = (Integer) r4;
                Log.i(ChatStrangerRelationViewModel.TAG, "chat readable live data update, try emit chat readable flow " + r6);
                z0<Integer> r7 = this.a.getChatReadableFlow();
                Intrinsics.checkNotNull(r6);
                r7.tryEmit(r6);
                if (r6.intValue() != 2) goto L5;
                l r8 = ChatStrangerRelationViewModel.access$getStrangerActionUploader$p(this.a);
                Chat r1 = ChatStrangerRelationViewModel.access$getInitChat$p(this.a);
                ChatStrangerRelationViewModel.access$getP2pChatter$p(this.a);
                r8.a(r1);
            L5:
                Boolean r9 = (Boolean) ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(this.a).getValue();
                if (r9 == null) goto L8;
                boolean r10 = r9.booleanValue();
            L9:
                int r2 = r6.intValue();
                int r3 = com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.b.a;
                if (r10 == false) goto L12;
                StrangerBannerType r0 = StrangerBannerType.TOTAL_BLOCK;
            L15:
                this.a.getBannerFlow().tryEmit(r0);
                this.a.getTagFlow().tryEmit(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.b.a((Boolean) ChatStrangerRelationViewModel.access$get_userCanSetStrangerLiveData$p(this.a).getValue(), r10, r6.intValue()));
                return Unit.INSTANCE;
            L12:
                if (r2 != 2) goto L14;
                r0 = StrangerBannerType.STRANGER;
                goto L15
            L14:
                r0 = StrangerBannerType.NONE;
                goto L15
            L8:
                r10 = false;
                goto L9
            }
        }

        public C03731(ChatStrangerRelationViewModel r1, Continuation<? super C03731> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03731(this.this$0, r3);
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
            Flow r6 = FlowLiveDataConversions.asFlow(ChatStrangerRelationViewModel.access$getChatReadableLiveData$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$2", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatStrangerRelationViewModel a;

            public a(ChatStrangerRelationViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                Boolean r5 = (Boolean) r3;
                Integer r6 = (Integer) ChatStrangerRelationViewModel.access$getChatReadableLiveData$p(this.a).getValue();
                if (r6 == null) goto L5;
                int r7 = r6.intValue();
            L6:
                Intrinsics.checkNotNull(r5);
                boolean r0 = r5.booleanValue();
                int r1 = com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.b.a;
                if (r0 == false) goto L10;
                StrangerBannerType r2 = StrangerBannerType.TOTAL_BLOCK;
            L13:
                this.a.getBannerFlow().tryEmit(r2);
                StrangerTagType r8 = com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.b.a((Boolean) ChatStrangerRelationViewModel.access$get_userCanSetStrangerLiveData$p(this.a).getValue(), r5.booleanValue(), r7);
                this.a.getTagFlow().tryEmit(r8);
                return Unit.INSTANCE;
            L10:
                if (r7 != 2) goto L12;
                r2 = StrangerBannerType.STRANGER;
                goto L13
            L12:
                r2 = StrangerBannerType.NONE;
                goto L13
            L5:
                r7 = 0;
                goto L6
            }
        }

        public AnonymousClass2(ChatStrangerRelationViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            Flow r6 = FlowLiveDataConversions.asFlow(ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$3", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$initBannerAndTagType$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatStrangerRelationViewModel a;

            public a(ChatStrangerRelationViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                Boolean r5 = (Boolean) r3;
                Integer r6 = (Integer) ChatStrangerRelationViewModel.access$getChatReadableLiveData$p(this.a).getValue();
                boolean r0 = false;
                if (r6 == null) goto L5;
                int r7 = r6.intValue();
            L6:
                Boolean r1 = (Boolean) ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(this.a).getValue();
                if (r1 == null) goto L9;
                r0 = r1.booleanValue();
            L9:
                StrangerTagType r8 = com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.b.a(r5, r0, r7);
                this.a.getTagFlow().tryEmit(r8);
                return Unit.INSTANCE;
            L5:
                r7 = 0;
                goto L6
            }
        }

        public AnonymousClass3(ChatStrangerRelationViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            Flow r6 = FlowLiveDataConversions.asFlow(ChatStrangerRelationViewModel.access$get_userCanSetStrangerLiveData$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$setupPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$setupPush$1", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $userId;
        Object L$0;
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        public C03741(ChatStrangerRelationViewModel r1, long r2, Continuation<? super C03741> r4) {
            this.this$0 = r1;
            this.$userId = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03741(this.this$0, this.$userId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0062 -> B:13:0x0068). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r2 = ChatStrangerRelationViewModel.TAG;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r3 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r13);
            String r4 = ChatStrangerRelationViewModel.TAG;
            com.larksuite.rucket.job.extension.a r5 = r3;
            Object r6 = r0;
            C03741 r7 = this;
        L14:
            if (((Boolean) r13).booleanValue() == false) goto L47;
            PushUserStrangerRelationEntity r14 = (PushUserStrangerRelationEntity) ((PushUserStrangerRelation) r5.a().b()).stranger_relations.get(Boxing.boxLong(r7.$userId));
            if (r14 == null) goto L21;
            PutStrangerRelationSource r8 = r14.source;
            if (r8 == null) goto L21;
            StrangerRelationSource.Companion.getClass();
            StrangerRelationSource r9 = StrangerRelationSource.a.a(r8);
            if (r9 == null) goto L21;
        L22:
            if (r14 == null) goto L26;
            UserStrangerRelation r10 = r14.relation;
            if (r10 == null) goto L26;
            int r11 = b.d;
            b r12 = b.a.a(r10);
        L27:
            StringBuilder r15 = new StringBuilder("push user stranger relation: ");
            if (r12 == null) goto L31;
            String r16 = r12.a();
            if (r16 == null) goto L31;
        L32:
            r15.append(r16);
            r15.append(", source: ");
            r15.append(r9);
            r15.append(", is_online: ");
            if (r14 == null) goto L37;
            Boolean r17 = r14.is_online_push;
            if (r17 == null) goto L37;
            boolean r18 = r17.booleanValue();
        L38:
            r15.append(r18);
            Log.i(r4, r15.toString());
            if (r12 == null) goto L45;
            ChatStrangerRelationViewModel r19 = r7.this$0;
            a r20 = ChatStrangerRelationViewModel.Companion;
            MutableLiveData r21 = ChatStrangerRelationViewModel.access$get_strangerRelationLiveData$p(r19);
            Boolean r110 = r14.is_online_push;
            if (r110 == null) goto L43;
            boolean r111 = r110.booleanValue();
        L44:
            c r112 = new c(r12, r9, r111);
            r20.getClass();
            a.b(r21, r112, false);
            goto L45
        L43:
            r111 = false;
        L45:
            C03741 r113 = r7;
            r0 = r6;
            com.larksuite.rucket.job.extension.a r22 = r5;
            r2 = r4;
        L9:
            r113.L$0 = r22;
            r113.label = 1;
            Object r23 = r22.hasNext(r113);
            if (r23 != r0) goto L12;
            return r0;
        L12:
            Object r114 = r0;
            r7 = r113;
            r13 = r23;
            r4 = r2;
            r5 = r22;
            r6 = r114;
        L37:
            r18 = false;
        L31:
            r16 = "nil";
        L26:
            r12 = null;
        L21:
            r9 = StrangerRelationSource.SOURCE_UNKNOWN;
            goto L22
        L47:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            Log.i(ChatStrangerRelationViewModel.TAG, "user stranger setup push chatId: " + ChatStrangerRelationViewModel.access$getInitChat$p(this.this$0).getId());
            r22 = ((com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class)).pushUserStrangerRelation().iterator();
            r113 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$setupPush$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$setupPush$2", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $userId;
        Object L$0;
        int label;
        final /* synthetic */ ChatStrangerRelationViewModel this$0;

        public C03752(ChatStrangerRelationViewModel r1, long r2, Continuation<? super C03752> r4) {
            this.this$0 = r1;
            this.$userId = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03752(this.this$0, this.$userId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0062 -> B:13:0x0068). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r2 = ChatStrangerRelationViewModel.TAG;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r3 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r12);
            String r4 = ChatStrangerRelationViewModel.TAG;
            com.larksuite.rucket.job.extension.a r5 = r3;
            Object r6 = r0;
            C03752 r7 = this;
        L14:
            if (((Boolean) r12).booleanValue() == false) goto L22;
            Object r13 = r5.a().b();
            long r8 = r7.$userId;
            ChatStrangerRelationViewModel r9 = r7.this$0;
            PushUserBlockStatusChangeEvent r14 = (PushUserBlockStatusChangeEvent) r13;
            if (r14.event_type == PushContactApplicationBannerAffectEvent.AffectEventType.Block) goto L18;
        L20:
            C03752 r15 = r7;
            r0 = r6;
            com.larksuite.rucket.job.extension.a r10 = r5;
            r2 = r4;
        L9:
            r15.L$0 = r10;
            r15.label = 1;
            Object r11 = r10.hasNext(r15);
            if (r11 != r0) goto L12;
            return r0;
        L12:
            Object r16 = r0;
            r7 = r15;
            r12 = r11;
            r4 = r2;
            r5 = r10;
            r6 = r16;
            goto L14
        L18:
            if (Intrinsics.areEqual(r14.block_user_id, String.valueOf(r8)) == false) goto L20;
            Log.i(r4, "push user block status uid = " + r8 + ", block status = " + r14.block_status);
            ChatStrangerRelationViewModel.access$get_userBlockStatusLiveData$p(r9).postValue(r14.block_status);
            goto L20
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Log.i(ChatStrangerRelationViewModel.TAG, "user block setup push chatId: " + ChatStrangerRelationViewModel.access$getInitChat$p(this.this$0).getId());
            r10 = ((com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class)).pushUserBlockStatus().iterator();
            r15 = this;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final void updateReadable(MutableLiveData<Integer> r1, int r2, boolean r3) {
        Companion.getClass();
        a.a(r1, r2, r3);
    }

    @JvmStatic
    public static final void updateRelation(MutableLiveData<c> r1, c r2, boolean r3) {
        Companion.getClass();
        a.b(r1, r2, r3);
    }

    private final void initBannerAndTagType() {
        if (this.fgService.isEnable("im.chat.readable_update") == false) goto L5;
        MainCoroutineDispatcher r0 = Dispatchers.getMain();
    L6:
        BuildersKt.launch$default(this, r0, null, new C03731(this, null), 2, null);
        BuildersKt.launch$default(this, null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt.launch$default(this, null, null, new AnonymousClass3(this, null), 3, null);
        return;
    L5:
        r0 = Dispatchers.getMain().getImmediate();
        goto L6
    }

    private final void setupPush() {
        Long r0 = StringsKt.toLongOrNull(this.initChat.getP2pChatterId());
        if (r0 == null) goto L6;
        long r1 = r0.longValue();
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new C03741(this, r1, null), 2, null);
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new C03752(this, r1, null), 2, null);
        return;
    L6:
        Log.e(TAG, "userId can't transform to Long!");
    }

    private final void triggerReadableDataChange() {
        c r0 = (c) this._strangerRelationLiveData.getValue();
        if (r0 == null) goto L7;
        b r1 = r0.a;
        if (r1 == null) goto L7;
        boolean r2 = r1.b;
    L8:
        this.chatReadableLiveData.postValue(Integer.valueOf(calculateChatReadable(r2)));
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void create() {
        g r0 = this.fgService;
        int r1 = l4b.a.a;
        Intrinsics.checkNotNullParameter(r0, "fgService");
        if (r0.isEnable("im.message.stranger") == true) goto L5;
        return;
    L5:
        initBannerAndTagType();
        setupInitData(new AnonymousClass1(this));
    }

    public void destroy() {
        this.strangerActionUploader.reset(this.initChat.getId());
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    private final void fetchData() {
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new C03721(this, null), 2, null);
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
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

    public b38.b getScopedRucket() {
        return this.scopedRucket;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<StrangerTagType> getTagFlow() {
        return this.tagFlow;
    }

    public static final /* synthetic */ void access$fetchData(ChatStrangerRelationViewModel r0) {
        r0.fetchData();
    }

    public static final /* synthetic */ MutableLiveData access$getChatReadableLiveData$p(ChatStrangerRelationViewModel r0) {
        return r0.chatReadableLiveData;
    }

    public static final /* synthetic */ Chat access$getInitChat$p(ChatStrangerRelationViewModel r0) {
        return r0.initChat;
    }

    public static final /* synthetic */ Chatter access$getP2pChatter$p(ChatStrangerRelationViewModel r0) {
        return r0.p2pChatter;
    }

    public static final /* synthetic */ l access$getStrangerActionUploader$p(ChatStrangerRelationViewModel r0) {
        return r0.strangerActionUploader;
    }

    public static final /* synthetic */ MutableLiveData access$get_strangerRelationLiveData$p(ChatStrangerRelationViewModel r0) {
        return r0._strangerRelationLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userBlockStatusLiveData$p(ChatStrangerRelationViewModel r0) {
        return r0._userBlockStatusLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userCanSetStrangerLiveData$p(ChatStrangerRelationViewModel r0) {
        return r0._userCanSetStrangerLiveData;
    }

    public static final /* synthetic */ AtomicBoolean access$isStrangerAvailable$p(ChatStrangerRelationViewModel r0) {
        return r0.isStrangerAvailable;
    }

    public static final /* synthetic */ void access$setupPush(ChatStrangerRelationViewModel r0) {
        r0.setupPush();
    }

    public static final /* synthetic */ void access$triggerReadableDataChange(ChatStrangerRelationViewModel r0) {
        r0.triggerReadableDataChange();
    }

    private final int calculateChatReadable(boolean r3) {
        if (this.isStrangerAvailable.get() == true) goto L5;
        return 1;
    L5:
        if (r3 == false) goto L8;
        return 2;
    L8:
        return 1;
    }

    private final Object fetchUniversalUserSetting(Continuation<? super Boolean> r6) {
        final j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        GetUniversalUserSettingRequest r1 = new GetUniversalUserSettingRequest.Builder().strategy(SyncDataStrategy.TRY_LOCAL).key(CollectionsKt.mutableListOf(new String[]{USER_PRIVACY_AVAILABLE})).build();
        com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class);
        Intrinsics.checkNotNull(r1);
        RucketJob.error$default(RucketJob.map$default(r3.fetchUserStrangerRelationSetting(r1), null, new ChatStrangerRelationViewModel$fetchUniversalUserSetting$2$1(r0), 1, null), null, new ChatStrangerRelationViewModel$fetchUniversalUserSetting$2$2(r0, null), 1, null);
        Object r2 = r0.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r2;
    }

    private final void setupInitData(Function0<Unit> r5) {
        Chat r0 = this.initChat;
        if (r0.isP2PChat() == true) goto L5;
    L30:
        a r6 = Companion;
        MutableLiveData<Integer> r1 = this.chatReadableLiveData;
        r6.getClass();
        a.a(r1, 1, true);
        return;
    L5:
        if (r0.isSecret() == true) goto L30;
        if (r0.isAIChat() == true) goto L30;
        Chatter r2 = this.p2pChatter;
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L30;
        if (r0.isP2PChat() == false) goto L24;
        Chatter r7 = this.p2pChatter;
        if (r7 == null) goto L21;
        boolean r8 = r7.isBot();
    L22:
        if (r8 == false) goto L24;
        r3 = true;
        goto L24
    L21:
        r8 = false;
    L24:
        if (r3 == false) goto L27;
        a r9 = Companion;
        MutableLiveData<Integer> r10 = this.chatReadableLiveData;
        r9.getClass();
        a.a(r10, 1, true);
        return;
    L27:
        if (r5 == null) goto L32;
        r5.invoke();
        return;
    L32:
        return;
    L11:
        if (r2.isDimission() != true) goto L13;
        r4 = true;
        goto L14
    }

    public void setScopedRucket(b38.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scopedRucket = r2;
    }

    public static final /* synthetic */ int access$calculateChatReadable(ChatStrangerRelationViewModel r0, boolean r1) {
        return r0.calculateChatReadable(r1);
    }

    public static final /* synthetic */ Object access$fetchUniversalUserSetting(ChatStrangerRelationViewModel r0, Continuation r1) {
        return r0.fetchUniversalUserSetting(r1);
    }

    private final Object fetchCanSetStranger(final long r7, Continuation<? super Boolean> r9) {
        final j r0 = new j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        GetCanSetStrangerRequest r1 = new GetCanSetStrangerRequest.Builder().strategy(GetCanSetStrangerRequest.SyncStrategy.TRY_LOCAL).user_ids(CollectionsKt.mutableListOf(new Long[]{Boxing.boxLong(r7)})).build();
        com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class);
        Intrinsics.checkNotNull(r1);
        RucketJob.error$default(RucketJob.map$default(r3.fetchCanSetStranger(r1), null, new ChatStrangerRelationViewModel$fetchCanSetStranger$2$1(r7, r0), 1, null), null, new ChatStrangerRelationViewModel$fetchCanSetStranger$2$2(r7, r0, null), 1, null);
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r8;
    }

    private final Object fetchUserBlockStatus(final long r12, Continuation<? super Boolean> r14) {
        final j r6 = new j(IntrinsicsKt.intercepted(r14), 1);
        r6.C();
        GetUserBlockStatusRequest r0 = new GetUserBlockStatusRequest.Builder().block_user_id(String.valueOf(r12)).strategy(SyncDataStrategy.FORCE_SERVER).build();
        com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class);
        Intrinsics.checkNotNull(r0);
        RucketJob.error$default(RucketJob.map$default(r1.fetchUserBlockStatus(r0), null, new ChatStrangerRelationViewModel$fetchUserBlockStatus$2$1(r12, r6), 1, null), null, new ChatStrangerRelationViewModel$fetchUserBlockStatus$2$2(r12, this, r6, null), 1, null);
        Object r13 = r6.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L5:
        return r13;
    }

    private final Object fetchUserStrangerRelation(final long r7, Continuation<? super b> r9) {
        final j r0 = new j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        GetUserStrangerRelationRequest r1 = new GetUserStrangerRelationRequest.Builder().strategy(GetUserStrangerRelationRequest.SyncStrategy.TRY_LOCAL).user_ids(CollectionsKt.mutableListOf(new Long[]{Boxing.boxLong(r7)})).build();
        com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a r3 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a) getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.a.class);
        Intrinsics.checkNotNull(r1);
        RucketJob.error$default(RucketJob.map$default(r3.getUserStrangerRelation(r1), null, new ChatStrangerRelationViewModel$fetchUserStrangerRelation$2$1(r7, r0), 1, null), null, new ChatStrangerRelationViewModel$fetchUserStrangerRelation$2$2(r7, r0, null), 1, null);
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r8;
    }

    public static final /* synthetic */ Object access$fetchCanSetStranger(ChatStrangerRelationViewModel r0, long r1, Continuation r3) {
        return r0.fetchCanSetStranger(r1, r3);
    }

    public static final /* synthetic */ Object access$fetchUserBlockStatus(ChatStrangerRelationViewModel r0, long r1, Continuation r3) {
        return r0.fetchUserBlockStatus(r1, r3);
    }

    public static final /* synthetic */ Object access$fetchUserStrangerRelation(ChatStrangerRelationViewModel r0, long r1, Continuation r3) {
        return r0.fetchUserStrangerRelation(r1, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setupInitData$default(ChatStrangerRelationViewModel r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.setupInitData(r1);
    }

    public ChatStrangerRelationViewModel(Chat r2, Chatter r3, g r4, l r5, b38.b r6) {
        Intrinsics.checkNotNullParameter(r2, "initChat");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        Intrinsics.checkNotNullParameter(r5, "strangerActionUploader");
        Intrinsics.checkNotNullParameter(r6, "rucket");
        this.initChat = r2;
        this.p2pChatter = r3;
        this.fgService = r4;
        this.strangerActionUploader = r5;
        this.scopedRucket = r6;
        this.isStrangerAvailable = new AtomicBoolean(false);
        MutableLiveData<c> r7 = new MutableLiveData();
        this._strangerRelationLiveData = r7;
        this._userBlockStatusLiveData = new MutableLiveData();
        this._userCanSetStrangerLiveData = new MutableLiveData();
        MediatorLiveData r8 = new MediatorLiveData();
        r8.addSource(r7, new d(r8, this));
        this.chatReadableLiveData = r8;
        this.chatReadableFlow = j1.a(0);
        this.chatChangeToReadable = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.bannerFlow = j1.a(StrangerBannerType.UNKNOWN);
        this.tagFlow = j1.a(StrangerTagType.NONE);
        this.closeBannerActionFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.coroutineContext = Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
    }
}
