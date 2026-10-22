package com.larus.profile.impl.mine;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larus.account.base.api.IAccountService;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatService;
import com.larus.profile.api.IProfileApi;
import com.larus.profile.impl.ProfileRepo;
import com.larus.profile.impl.ProfileRequestSource;
import com.larus.settings.value.e10;
import com.larus.settings.value.ic;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001:\u0018\u0000 i2\u00020\u0001:\u0001iB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010<\u001a\u00020)2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0$H\u0082@¢\u0006\u0002\u0010?J\u000e\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XJ\u0016\u0010Y\u001a\u00020\u00102\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0006\u0010[\u001a\u00020\u0010J\u0006\u0010\\\u001a\u00020VJ\u001e\u0010]\u001a\u00020)2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0082@¢\u0006\u0002\u0010?J\u0018\u0010_\u001a\u0004\u0018\u00010\t2\u0006\u0010`\u001a\u00020%H\u0086@¢\u0006\u0002\u0010aJ\u000e\u0010b\u001a\u00020)2\u0006\u0010`\u001a\u00020%J\u000e\u0010c\u001a\u00020)2\u0006\u0010`\u001a\u00020%J\u0016\u0010d\u001a\u00020)2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tJ\u0006\u0010g\u001a\u00020)J\b\u0010h\u001a\u00020)H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0\u001a¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u001a¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\t02X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010R\"\u0004\bS\u0010T¨\u0006j"}, d2 = {"Lcom/larus/profile/impl/mine/MineTabViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/profile/impl/ProfileRepo;", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "index", "hasBoundDoraVision", "", "getHasBoundDoraVision", "()Ljava/lang/Boolean;", "setHasBoundDoraVision", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "_userInfoState", "Lcom/larus/network/http/AsyncLiveData;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "userInfoState", "Landroidx/lifecycle/LiveData;", "Lcom/larus/network/http/Async;", "getUserInfoState", "()Landroidx/lifecycle/LiveData;", "_loadMoreState", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "loadMoreState", "getLoadMoreState", "_profileBotsLive", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/profile/api/bean/ProfileBot;", "profileBotsLive", "getProfileBotsLive", "_showBindPhoneEvent", "", "showBindPhoneEvent", "getShowBindPhoneEvent", "firstPageBotList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "needUpdateBotList", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "updatedBotSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "Lkotlin/Lazy;", "onConversationChangedObserver", "com/larus/profile/impl/mine/MineTabViewModel$onConversationChangedObserver$1", "Lcom/larus/profile/impl/mine/MineTabViewModel$onConversationChangedObserver$1;", "handleConvChange", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botDeleteObserver", "Landroidx/lifecycle/Observer;", "botUpdateObserver", "Lcom/larus/im/bean/bot/BotModel;", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfo", "()Lcom/larus/account/base/model/profile/UserInfo;", "setUserInfo", "(Lcom/larus/account/base/model/profile/UserInfo;)V", "botsCount", "", "getBotsCount", "()I", "setBotsCount", "(I)V", "isRequestingUserInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRequestingUserInfo", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "queryUserInfo", "Lkotlinx/coroutines/Job;", "source", "Lcom/larus/profile/impl/ProfileRequestSource;", "checkRefreshFirstBotsPage", "currentBotList", "needRefreshBotList", "queryLoadMoreList", "updateProfileBots", "profileBots", "createLocalConversation", "bot", "(Lcom/larus/profile/api/bean/ProfileBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversationByBot", "updateCreateScene", "removeConversationByBot", "conversationId", "botId", "checkReusedNumber", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MineTabViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String REUSE_IGNORE_DELETED = "reuse_ignore_deleted";
    private static final String TAG = "MineTabViewModel";
    private static final long USER_NOT_EXISTS = 710012014;
    private static final int VALUE_LIMIT = 10;
    private final AsyncLiveData<fs9.r> _loadMoreState;
    private final MutableLiveData<List<fs9.n>> _profileBotsLive;
    private final MutableLiveData<Unit> _showBindPhoneEvent;
    private final AsyncLiveData<fs9.u> _userInfoState;
    private final Observer<String> botDeleteObserver;
    private final Observer<BotModel> botUpdateObserver;
    private int botsCount;
    private final CopyOnWriteArrayList<fs9.n> firstPageBotList;
    private Boolean hasBoundDoraVision;
    private String index;
    private AtomicBoolean isRequestingUserInfo;
    private final LiveData<com.larus.network.http.a<fs9.r>> loadMoreState;
    private final kotlinx.coroutines.sync.a mutex;
    private boolean needUpdateBotList;
    private final b onConversationChangedObserver;
    private final LiveData<List<fs9.n>> profileBotsLive;
    private final ProfileRepo repo;
    private final Lazy service$delegate;
    private final LiveData<Unit> showBindPhoneEvent;
    private final CopyOnWriteArraySet<String> updatedBotSet;
    private String userId;
    private r38.b userInfo;
    private final LiveData<com.larus.network.http.a<fs9.u>> userInfoState;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.im.service.z<List<? extends wc9.e>> {
        public final /* synthetic */ MineTabViewModel a;

        public b(MineTabViewModel r1) {
            this.a = r1;
        }

        public final void c(Object r8) {
            List r9 = (List) r8;
            Intrinsics.checkNotNullParameter(r9, SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new MineTabViewModel$onConversationChangedObserver$1$onChange$1(this.a, r9, null), 3, null);
        }
    }

    public static final class c implements IIMCallback<Boolean> {
        public final /* synthetic */ String a;

        public final boolean mustInMain() {
            return true;
        }

        public c(String r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            IAIChatService.a.Y7().a(this.a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$checkReusedNumber$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$checkReusedNumber$1", f = "MineTabViewModel.kt", i = {}, l = {423}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MineTabViewModel this$0;

        public AnonymousClass1(MineTabViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            com.larus.profile.impl.bind_phone.c r6 = com.larus.profile.impl.bind_phone.c.a;
            r r3 = new r(this.this$0);
            this.label = 1;
            if (r6.a(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$createConversationByBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$createConversationByBot$1", f = "MineTabViewModel.kt", i = {}, l = {387}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        int label;

        public C00981(String r1, Continuation<? super C00981> r2) {
            this.$botId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00981(this.$botId, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L11:
            wc9.e r2 = (wc9.e) r1;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            IConversationRepoService r3 = RepoDispatcherDelegate.b.f();
            String r4 = this.$botId;
            this.label = 1;
            r1 = IConversationRepoService.a.a(r3, r4, 2, null, null, false, null, null, null, null, this, 508);
            if (r1 != r12) goto L11;
            return r12;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$handleConvChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel", f = "MineTabViewModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3}, l = {441, 115, 128, 144}, m = "handleConvChange", n = {SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newConversation", "currentList", "profileBotByConversationId", "profileBot", "$this$withLock_u24default$iv", "newConversation", "currentList", "profileBotByConversationId", "profileBot", "$this$withLock_u24default$iv", "newConversation", "currentList"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2"})
    public static final class C00991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MineTabViewModel this$0;

        public C00991(MineTabViewModel r1, Continuation<? super C00991> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MineTabViewModel.access$handleConvChange(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$queryLoadMoreList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$queryLoadMoreList$1", f = "MineTabViewModel.kt", i = {0, 1, 2, 2, 2}, l = {441, 336, 340}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "profileBotListResult", "profileBots"}, s = {"L$0", "L$0", "L$0", "L$2", "L$3"})
    public static final class C01001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MineTabViewModel this$0;

        public C01001(MineTabViewModel r1, Continuation<? super C01001> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01001(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v4, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            ?? r3 = 2;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            List<fs9.n> r2 = (List) this.L$3;
            com.larus.network.http.a r4 = (com.larus.network.http.a) this.L$2;
            MineTabViewModel r5 = (MineTabViewModel) this.L$1;
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
            ?? r7 = r6;
        L46:
            if (r2 == null) goto L59;
            List r11 = (List) MineTabViewModel.access$get_profileBotsLive$p(r5).getValue();     // Catch: Throwable -> L15
            if (r11 == null) goto L59;
            List r12 = CollectionsKt.toMutableList(r11);     // Catch: Throwable -> L15
            if (r12 == null) goto L59;
            r12.addAll(r2);     // Catch: Throwable -> L15
            HashSet r8 = new HashSet();     // Catch: Throwable -> L15
            ArrayList r9 = new ArrayList();     // Catch: Throwable -> L15
            Iterator r13 = r12.iterator();     // Catch: Throwable -> L15
        L54:
            if (r13.hasNext() == false) goto L58;
            Object r14 = r13.next();     // Catch: Throwable -> L15
            if (r8.add(((fs9.n) r14).e()) == false) goto L54;
            r9.add(r14);     // Catch: Throwable -> L15
            goto L54
        L58:
            MineTabViewModel.access$get_profileBotsLive$p(r5).setValue(r9);     // Catch: Throwable -> L15
        L59:
            com.larus.network.http.a r15 = r4;
            MineTabViewModel r16 = r5;
            r3 = r7;
        L60:
            MineTabViewModel.access$get_loadMoreState$p(r16).setValue(r15);     // Catch: Throwable -> L15
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
            r3.unlock(null);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r16 = (MineTabViewModel) this.L$1;
            kotlinx.coroutines.sync.a r18 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
            ?? r19 = r18;
        L31:
            r15 = (com.larus.network.http.a) r10;     // Catch: Throwable -> L15
            r3 = r19;
            if ((r15 instanceof com.larus.network.http.y) == false) goto L60;
            fs9.r r20 = (fs9.r) ((com.larus.network.http.a) ((com.larus.network.http.y) r15)).b;     // Catch: Throwable -> L15
            if (r20 == null) goto L37;
            String r21 = r20.b();     // Catch: Throwable -> L15
            if (r21 == null) goto L37;
        L38:
            MineTabViewModel.access$setIndex$p(r16, r21);     // Catch: Throwable -> L15
            fs9.r r22 = (fs9.r) ((com.larus.network.http.a) ((com.larus.network.http.y) r15)).b;     // Catch: Throwable -> L15
            if (r22 == null) goto L41;
            List<fs9.n> r23 = r22.c();     // Catch: Throwable -> L15
        L42:
            this.L$0 = r19;     // Catch: Throwable -> L15
            this.L$1 = r16;     // Catch: Throwable -> L15
            this.L$2 = r15;     // Catch: Throwable -> L15
            this.L$3 = r23;     // Catch: Throwable -> L15
            this.label = 3;     // Catch: Throwable -> L15
            if (MineTabViewModel.access$updateProfileBots(r16, r23, this) != r0) goto L45;
            return r0;
        L45:
            r5 = r16;
            r2 = r23;
            r4 = r15;
            r7 = r19;
            goto L46
        L41:
            r23 = null;
        L37:
            r21 = "";
            goto L38
        L17:
            r16 = (MineTabViewModel) this.L$1;
            kotlinx.coroutines.sync.a r24 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);
            ?? r25 = r24;
        L69:
        L64:
            th = th;
        L65:
            r25.unlock(null);
            throw th;
        L23:
            if ((MineTabViewModel.access$get_loadMoreState$p(r16).getValue() instanceof com.larus.network.http.w) == false) goto L27;
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L64
            r25.unlock(null);
            return r110;
        L27:
            MineTabViewModel.access$get_loadMoreState$p(r16).setValue(new com.larus.network.http.w(null));     // Catch: Throwable -> L64
            ProfileRepo r111 = MineTabViewModel.access$getRepo$p(r16);     // Catch: Throwable -> L64
            String r26 = r16.getUserId();     // Catch: Throwable -> L64
            String r27 = MineTabViewModel.access$getIndex$p(r16);     // Catch: Throwable -> L64
            ProfileRequestSource r28 = ProfileRequestSource.LOAD_MORE;     // Catch: Throwable -> L64
            this.L$0 = r25;     // Catch: Throwable -> L64
            this.L$1 = r16;     // Catch: Throwable -> L64
            this.label = 2;     // Catch: Throwable -> L64
            r111.getClass();     // Catch: Throwable -> L64
            r10 = ProfileRepo.c(r26, r27, r28, false, this);     // Catch: Throwable -> L64
            if (r10 != r0) goto L30;
            return r0;
        L30:
            r19 = r25;
            goto L31
        L18:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.sync.a r112 = MineTabViewModel.access$getMutex$p(this.this$0);
            r16 = this.this$0;
            this.L$0 = r112;
            this.L$1 = r16;
            this.label = 1;
            if (r112.a(null, this) != r0) goto L21;
            return r0;
        L21:
            r25 = r112;
        L15:
            th = th;
            r25 = r3;
            goto L65
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$queryUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$queryUserInfo$1", f = "MineTabViewModel.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3}, l = {233, 236, 241, 265, 296}, m = "invokeSuspend", n = {"cache", "getProfileBotsJob", "cache", "userInfoResult", "cache", "userInfoResult", "profileBotsResult", "profileBots", "userInfoResult", "profileOverviewData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    public static final class C01011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProfileRequestSource $source;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MineTabViewModel this$0;

        public C01011(MineTabViewModel r1, ProfileRequestSource r2, Continuation<? super C01011> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01011 r0 = new C01011(this.this$0, this.$source, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r27) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            String r5 = "";
            if (r0 == 0) goto L16;
            if (r0 == 1) goto L15;
            if (r0 == 2) goto L14;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 != 5) goto L11;
            ResultKt.throwOnFailure(r27);
            Object r1 = r27;
        L143:
            if ((((com.larus.network.http.a) r1) instanceof com.larus.network.http.y) == false) goto L145;
            FLogger.a.i(MineTabViewModel.TAG, "updateDefaultProfile success");
            this.this$0.queryUserInfo(ProfileRequestSource.LAZY_LOAD);
        L146:
            this.this$0.isRequestingUserInfo().set(false);
            return Unit.INSTANCE;
        L145:
            FLogger.a.i(MineTabViewModel.TAG, "updateDefaultProfile fail");
            goto L146
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            fs9.u r3 = (fs9.u) this.L$1;
            com.larus.network.http.a r6 = (com.larus.network.http.a) this.L$0;
            ResultKt.throwOnFailure(r27);
        L107:
            AsyncLiveData r4 = MineTabViewModel.access$get_userInfoState$p(this.this$0);
            if (r3 == null) goto L110;
            r38.b r14 = r3.f();
        L111:
            if (r3 == null) goto L113;
            fs9.o r15 = r3.c();
        L114:
            r4.postValue(new com.larus.network.http.y(new fs9.u(r14, r15, false, false, 124), null, 14));
            if (r3 == null) goto L134;
            r38.b r7 = r3.f();
            if (r7 == null) goto L134;
            Boxing.boxBoolean(IProfileApi.a.b().tryEmit(r7));
        L134:
            if ((r6 instanceof com.larus.network.http.f) == false) goto L146;
            if (((com.larus.network.http.f) r6).d.getCode() != MineTabViewModel.USER_NOT_EXISTS) goto L146;
            if (this.$source != ProfileRequestSource.REFRESH) goto L146;
            FLogger.a.i(MineTabViewModel.TAG, "queryUserInfo fail with USER_NOT_EXISTS, try to update default profile");
            ProfileRepo r8 = MineTabViewModel.access$getRepo$p(this.this$0);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 5;
            r8.getClass();
            r1 = ProfileRepo.g(this);
            if (r1 != r2) goto L143;
            return r2;
        L113:
            r15 = null;
            goto L114
        L110:
            r14 = null;
            goto L111
        L13:
            List<fs9.n> r9 = (List) this.L$3;
            com.larus.network.http.a r10 = (com.larus.network.http.a) this.L$2;
            com.larus.network.http.a r11 = (com.larus.network.http.a) this.L$1;
            fs9.u r12 = (fs9.u) this.L$0;
            ResultKt.throwOnFailure(r27);
        L72:
            if (MineTabViewModel.access$checkRefreshFirstBotsPage(this.this$0, r9) == false) goto L81;
            MineTabViewModel r13 = this.this$0;
            fs9.r r16 = (fs9.r) ((com.larus.network.http.a) ((com.larus.network.http.y) r10)).b;
            if (r16 == null) goto L76;
            String r17 = r16.b();
        L77:
            if (r17 == null) goto L80;
            r5 = r17;
        L80:
            MineTabViewModel.access$setIndex$p(r13, r5);
            MineTabViewModel.access$get_profileBotsLive$p(this.this$0).postValue(r9);
            goto L81
        L76:
            r17 = null;
        L81:
            MineTabViewModel.access$getFirstPageBotList$p(this.this$0).clear();
            MineTabViewModel.access$getFirstPageBotList$p(this.this$0).addAll(r9);
            r38.b r18 = this.this$0.getUserInfo();
            if (r18 == null) goto L86;
            ProfileRequestSource r19 = this.$source;
            String r20 = r18.f();
            AccountService r21 = AccountService.a;
            if (Intrinsics.areEqual(r20, r21.getUserId()) == false) goto L86;
            IAccountService.Companion r22 = IAccountService.a;
            r22.l(r18);
            r22.o(r21.getUserId(), r18.c(), r19.getValue());
        L86:
            com.larus.network.http.a r23 = r10;
        L88:
            r6 = r11;
        L91:
            if ((r6 instanceof com.larus.network.http.y) == true) goto L93;
        L119:
            if (r12 != null) goto L121;
            AsyncLiveData r24 = MineTabViewModel.access$get_userInfoState$p(this.this$0);
            AsyncThrowable.Companion.getClass();
            r24.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
            goto L134
        L121:
            MutableLiveData r25 = MineTabViewModel.access$get_profileBotsLive$p(this.this$0);
            fs9.o r26 = r12.c();
            if (r26 == null) goto L127;
            List<fs9.n> r28 = r26.a();
            if (r28 == null) goto L127;
            List r29 = CollectionsKt.filterNotNull(r28);
            if (r29 == null) goto L127;
        L128:
            r25.postValue(r29);
            if ((r6 instanceof com.larus.network.http.f) == false) goto L134;
            if (((com.larus.network.http.f) r6).d.getCode() != (-555)) goto L134;
            MineTabViewModel.access$get_userInfoState$p(this.this$0).postValue(new com.larus.network.http.y(new fs9.u(r12.f(), r12.c(), true, true, 28), null, 14));
        L127:
            r29 = CollectionsKt.emptyList();
            goto L128
        L93:
            if ((r23 instanceof com.larus.network.http.y) == false) goto L119;
            r3 = (fs9.u) ((com.larus.network.http.a) ((com.larus.network.http.y) r6)).b;
            fs9.r r30 = (fs9.r) ((com.larus.network.http.a) ((com.larus.network.http.y) r23)).b;
            if (r3 != null) goto L97;
        L104:
            ProfileRepo r31 = MineTabViewModel.access$getRepo$p(this.this$0);
            this.L$0 = r6;
            this.L$1 = r3;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 4;
            if (r31.f(r3, this) != r2) goto L107;
            return r2;
        L97:
            if (r30 == null) goto L99;
            int r32 = r30.d();
        L100:
            if (r30 == null) goto L102;
            List<fs9.n> r33 = r30.c();
        L103:
            r3.g(new fs9.o(r32, r33));
            goto L104
        L102:
            r33 = null;
            goto L103
        L99:
            r32 = 0;
            goto L100
        L14:
            com.larus.network.http.a r34 = (com.larus.network.http.a) this.L$1;
            fs9.u r110 = (fs9.u) this.L$0;
            ResultKt.throwOnFailure(r27);
            r12 = r110;
            r11 = r34;
            Object r35 = r27;
        L51:
            com.larus.network.http.a r36 = (com.larus.network.http.a) r35;
            if ((r36 instanceof com.larus.network.http.y) == false) goto L87;
            MineTabViewModel r37 = this.this$0;
            fs9.u r38 = (fs9.u) ((com.larus.network.http.a) ((com.larus.network.http.y) r11)).b;
            if (r38 == null) goto L56;
            r38.b r39 = r38.f();
        L57:
            r37.setUserInfo(r39);
            MineTabViewModel r40 = this.this$0;
            com.larus.network.http.y r41 = (com.larus.network.http.y) r36;
            fs9.r r111 = (fs9.r) ((com.larus.network.http.a) r41).b;
            if (r111 == null) goto L60;
            int r112 = r111.d();
        L61:
            r40.setBotsCount(r112);
            fs9.r r42 = (fs9.r) ((com.larus.network.http.a) r41).b;
            if (r42 == null) goto L64;
            List<fs9.n> r43 = r42.c();
        L65:
            if (r43 != null) goto L67;
            r43 = CollectionsKt.emptyList();
        L67:
            MineTabViewModel r44 = this.this$0;
            this.L$0 = r12;
            this.L$1 = r11;
            this.L$2 = r36;
            this.L$3 = r43;
            this.label = 3;
            if (MineTabViewModel.access$updateProfileBots(r44, r43, this) != r2) goto L70;
            return r2;
        L70:
            r10 = r36;
            r9 = r43;
            goto L72
        L64:
            r43 = null;
            goto L65
        L60:
            r112 = 0;
            goto L61
        L56:
            r39 = null;
            goto L57
        L87:
            r23 = r36;
            goto L88
        L15:
            Deferred r45 = (Deferred) this.L$1;
            r12 = (fs9.u) this.L$0;
            ResultKt.throwOnFailure(r27);
            Object r46 = r27;
        L45:
            com.larus.network.http.a r47 = (com.larus.network.http.a) r46;
            AsyncThrowable.Companion.getClass();
            r23 = new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
            if ((r47 instanceof com.larus.network.http.y) == false) goto L89;
            this.L$0 = r12;
            this.L$1 = r47;
            this.label = 2;
            r35 = r45.await(this);
            if (r35 != r2) goto L50;
            return r2;
        L50:
            r11 = r47;
            goto L51
        L89:
            r6 = r47;
            goto L91
        L16:
            ResultKt.throwOnFailure(r27);
            CoroutineScope r113 = (CoroutineScope) this.L$0;
            if (this.this$0.isRequestingUserInfo().get() == true) goto L19;
            this.this$0.isRequestingUserInfo().set(true);
            if ((MineTabViewModel.access$get_userInfoState$p(this.this$0).getValue() instanceof com.larus.network.http.w) == true) goto L23;
            e10 r48 = e10.a;
            if (Intrinsics.areEqual(e10.s0().e(), Boxing.boxBoolean(true)) == false) goto L37;
            String r49 = ((Keva) MineTabViewModel.access$getRepo$p(this.this$0).a.getValue()).getString("key_profile_overview_data", "");
            Intrinsics.checkNotNull(r49);
            if (r49.length() <= 0) goto L29;
            boolean r114 = true;
        L30:
            if (r114 == false) goto L37;
            fs9.u r50 = fs9.u.a((fs9.u) GsonProtectorUtils.fromJson(new Gson(), r49, fs9.u.class));     // Catch: NullPointerException -> L33 JsonSyntaxException -> L35
        L38:
            if (r50 != null) goto L40;
            MineTabViewModel.access$get_userInfoState$p(this.this$0).postValue(new com.larus.network.http.w(null));
        L41:
            Deferred r115 = BuildersKt.async$default(r113, null, null, new MineTabViewModel$queryUserInfo$1$getUserInfoJob$1(this.this$0, this.$source, r50, null), 3, null);
            Deferred r51 = BuildersKt.async$default(r113, null, null, new MineTabViewModel$queryUserInfo$1$getProfileBotsJob$1(this.this$0, this.$source, r50, null), 3, null);
            this.L$0 = r50;
            this.L$1 = r51;
            this.label = 1;
            r46 = r115.await(this);
            if (r46 != r2) goto L44;
            return r2;
        L44:
            r12 = r50;
            r45 = r51;
            goto L45
        L40:
            MineTabViewModel.access$get_userInfoState$p(this.this$0).postValue(new com.larus.network.http.y(new fs9.u(r50.f(), r50.c(), true, false, 92), null, 14));
            goto L41
        L35:
            e = move-exception;
            com.larus.platform.service.g.a.ensureNotReachHere(e);
        L33:
            e = move-exception;
            FLogger.a.e("ProfileRepo", "getDiscoverFirstPageData error e=" + e.getMessage());
            goto L37
        L29:
            r114 = false;
        L37:
            r50 = null;
            goto L38
        L23:
            return Unit.INSTANCE;
        L19:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$updateCreateScene$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$updateCreateScene$1", f = "MineTabViewModel.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        int label;

        public C01021(String r1, Continuation<? super C01021> r2) {
            this.$conversationId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01021(this.$conversationId, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IConversationRepoService r5 = RepoDispatcherDelegate.b.f();
            String r2 = this.$conversationId;
            this.label = 1;
            if (r5.s(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.MineTabViewModel$updateProfileBots$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$updateProfileBots$2", f = "MineTabViewModel.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<fs9.n> $profileBots;
        int label;
        final /* synthetic */ MineTabViewModel this$0;

        public AnonymousClass2(List<fs9.n> r1, MineTabViewModel r2, Continuation<? super AnonymousClass2> r3) {
            this.$profileBots = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$profileBots, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L37:
            FLogger.a.i(MineTabViewModel.TAG, "updateProfileBots");
        L39:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            List<fs9.n> r11 = this.$profileBots;
            List r2 = null;
            if (r11 == null) goto L24;
            ArrayList r3 = new ArrayList();
            Iterator<T> r12 = r11.iterator();
        L12:
            if (r12.hasNext() == false) goto L23;
            String r4 = ((fs9.n) r12.next()).e();
            if (r4 != null) goto L16;
        L20:
            r4 = null;
        L21:
            if (r4 == null) goto L12;
            r3.add(r4);
            goto L12
        L16:
            if (r4.length() != 0) goto L18;
            boolean r5 = true;
        L19:
            if (r5 == false) goto L21;
        L18:
            r5 = false;
            goto L19
        L23:
            r2 = r3;
        L24:
            if (r2 != null) goto L26;
            r2 = CollectionsKt.emptyList();
        L26:
            MineTabViewModel r13 = this.this$0;
            ArrayList r6 = new ArrayList();
            Iterator r7 = r2.iterator();
        L28:
            if (r7.hasNext() == false) goto L33;
            Object r8 = r7.next();
            if (MineTabViewModel.access$getUpdatedBotSet$p(r13).contains((String) r8) == true) goto L28;
            r6.add(r8);
            goto L28
        L33:
            if ((!r6.isEmpty()) == false) goto L39;
            MineTabViewModel.access$getUpdatedBotSet$p(this.this$0).addAll(r6);
            IBotRepoService r9 = RepoDispatcherDelegate.b.b();
            this.label = 1;
            if (r9.i1(r6, true, "default", true, this) != r0) goto L37;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ com.larus.im.service.q Mo() {
        return service_delegate$lambda$0();
    }

    public static /* synthetic */ void No(MineTabViewModel r0, String r1) {
        botDeleteObserver$lambda$8(r0, r1);
    }

    public static /* synthetic */ void yo(MineTabViewModel r0, BotModel r1) {
        botUpdateObserver$lambda$9(r0, r1);
    }

    private final com.larus.im.service.q getService() {
        return (com.larus.im.service.q) this.service$delegate.getValue();
    }

    public final void checkReusedNumber() {
        com.larus.profile.impl.bind_phone.c r0 = com.larus.profile.impl.bind_phone.c.a;
        if ((!AppHost.a.isOversea()) == false) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        return;
    }

    private static final com.larus.im.service.q service_delegate$lambda$0() {
        return com.larus.im.d.c();
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        getService().unRegisterConversationChangeListener(this.onConversationChangedObserver);
        RepoDispatcherDelegate r0 = RepoDispatcherDelegate.b;
        r0.b().r1().removeObserver(this.botDeleteObserver);
        r0.b().n1().removeObserver(this.botUpdateObserver);
    }

    public final Job queryLoadMoreList() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01001(this, null), 3, null);
    }

    public final int getBotsCount() {
        return this.botsCount;
    }

    public final Boolean getHasBoundDoraVision() {
        return this.hasBoundDoraVision;
    }

    public final LiveData<com.larus.network.http.a<fs9.r>> getLoadMoreState() {
        return this.loadMoreState;
    }

    public final LiveData<List<fs9.n>> getProfileBotsLive() {
        return this.profileBotsLive;
    }

    public final LiveData<Unit> getShowBindPhoneEvent() {
        return this.showBindPhoneEvent;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final r38.b getUserInfo() {
        return this.userInfo;
    }

    public final LiveData<com.larus.network.http.a<fs9.u>> getUserInfoState() {
        return this.userInfoState;
    }

    public final AtomicBoolean isRequestingUserInfo() {
        return this.isRequestingUserInfo;
    }

    public final boolean needRefreshBotList() {
        return this.needUpdateBotList;
    }

    public MineTabViewModel(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        super(r4);
        Lazy<ProfileRepo> r5 = ProfileRepo.b;
        this.repo = ProfileRepo.a.a();
        this.userId = "";
        this.index = "";
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L7;
        com.larus.home.impl.sdk.s r7 = r6.s0();
        if (r7 == null) goto L7;
        Boolean r8 = r7.E();
    L8:
        this.hasBoundDoraVision = r8;
        AsyncLiveData<fs9.u> r9 = new AsyncLiveData();
        this._userInfoState = r9;
        this.userInfoState = r9;
        AsyncLiveData<fs9.r> r10 = new AsyncLiveData();
        this._loadMoreState = r10;
        this.loadMoreState = r10;
        MutableLiveData<List<fs9.n>> r11 = new MutableLiveData();
        this._profileBotsLive = r11;
        this.profileBotsLive = r11;
        MutableLiveData<Unit> r12 = new MutableLiveData();
        this._showBindPhoneEvent = r12;
        this.showBindPhoneEvent = r12;
        this.firstPageBotList = new CopyOnWriteArrayList();
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.updatedBotSet = new CopyOnWriteArraySet();
        this.service$delegate = LazyKt.lazy(new o());
        b r13 = new b(this);
        this.onConversationChangedObserver = r13;
        Observer<String> r0 = new p(this);
        this.botDeleteObserver = r0;
        Observer<BotModel> r1 = new q(this);
        this.botUpdateObserver = r1;
        getService().registerConversationChangeListener(r13);
        RepoDispatcherDelegate r14 = RepoDispatcherDelegate.b;
        r14.b().r1().observeForever(r0);
        r14.b().n1().observeForever(r1);
        this.isRequestingUserInfo = new AtomicBoolean(false);
        return;
    L7:
        r8 = null;
        goto L8
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getFirstPageBotList$p(MineTabViewModel r0) {
        return r0.firstPageBotList;
    }

    public static final /* synthetic */ String access$getIndex$p(MineTabViewModel r0) {
        return r0.index;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(MineTabViewModel r0) {
        return r0.mutex;
    }

    public static final /* synthetic */ ProfileRepo access$getRepo$p(MineTabViewModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getUpdatedBotSet$p(MineTabViewModel r0) {
        return r0.updatedBotSet;
    }

    public static final /* synthetic */ AsyncLiveData access$get_loadMoreState$p(MineTabViewModel r0) {
        return r0._loadMoreState;
    }

    public static final /* synthetic */ MutableLiveData access$get_profileBotsLive$p(MineTabViewModel r0) {
        return r0._profileBotsLive;
    }

    public static final /* synthetic */ MutableLiveData access$get_showBindPhoneEvent$p(MineTabViewModel r0) {
        return r0._showBindPhoneEvent;
    }

    public static final /* synthetic */ AsyncLiveData access$get_userInfoState$p(MineTabViewModel r0) {
        return r0._userInfoState;
    }

    private final boolean checkRefreshFirstBotsPage(List<fs9.n> r9) {
        boolean r1 = true;
        if (this.firstPageBotList.isEmpty() == true) goto L5;
    L7:
        CopyOnWriteArrayList<fs9.n> r0 = this.firstPageBotList;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L8:
        String r5 = null;
        if (r3.hasNext() == false) goto L15;
        fs9.n r4 = (fs9.n) r3.next();
        if (r4 == null) goto L13;
        r5 = r4.e();
    L13:
        if (r5 == null) goto L8;
        r2.add(r5);
        goto L8
    L15:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r0.iterator();
    L17:
        if (r7.hasNext() == false) goto L24;
        fs9.n r8 = (fs9.n) r7.next();
        if (r8 == null) goto L21;
        String r10 = r8.d();
    L22:
        if (r10 == null) goto L17;
        r6.add(r10);
        goto L17
    L21:
        r10 = null;
        goto L22
    L24:
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r0.iterator();
    L26:
        if (r12.hasNext() == false) goto L33;
        fs9.n r13 = (fs9.n) r12.next();
        if (r13 == null) goto L30;
        String r14 = r13.l();
    L31:
        if (r14 == null) goto L26;
        r11.add(r14);
        goto L26
    L30:
        r14 = null;
        goto L31
    L33:
        List<fs9.n> r15 = r9;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L35:
        if (r17.hasNext() == false) goto L39;
        String r18 = ((fs9.n) r17.next()).e();
        if (r18 == null) goto L35;
        r16.add(r18);
        goto L35
    L39:
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r15.iterator();
    L41:
        if (r20.hasNext() == false) goto L45;
        String r21 = ((fs9.n) r20.next()).l();
        if (r21 == null) goto L41;
        r19.add(r21);
        goto L41
    L45:
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r15.iterator();
    L47:
        if (r23.hasNext() == false) goto L52;
        String r24 = ((fs9.n) r23.next()).d();
        if (r24 == null) goto L47;
        r22.add(r24);
        goto L47
    L52:
        if (Intrinsics.areEqual(r2, r16) == true) goto L54;
    L59:
        this.needUpdateBotList = r1;
        FLogger.a.d(TAG, "needRefreshBotList(" + r1 + ')');
        return r1;
    L54:
        if (Intrinsics.areEqual(r11, r19) == false) goto L59;
        if (Intrinsics.areEqual(r6, r22) == false) goto L59;
        r1 = false;
        goto L59
    L5:
        if (r9.isEmpty() == false) goto L7;
        return true;
    }

    public final void createConversationByBot(fs9.n r8) {
        Intrinsics.checkNotNullParameter(r8, "bot");
        String r9 = r8.e();
        if (r9 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C00981(r9, null), 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final Job queryUserInfo(ProfileRequestSource r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01011(this, r8, null), 2, null);
    }

    public final void setBotsCount(int r1) {
        this.botsCount = r1;
    }

    public final void setHasBoundDoraVision(Boolean r1) {
        this.hasBoundDoraVision = r1;
    }

    public final void setRequestingUserInfo(AtomicBoolean r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isRequestingUserInfo = r2;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public final void setUserInfo(r38.b r1) {
        this.userInfo = r1;
    }

    public final void updateCreateScene(fs9.n r8) {
        Intrinsics.checkNotNullParameter(r8, "bot");
        String r9 = r8.i();
        if (r9 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01021(r9, null), 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static final /* synthetic */ boolean access$checkRefreshFirstBotsPage(MineTabViewModel r0, List r1) {
        return r0.checkRefreshFirstBotsPage(r1);
    }

    public static final /* synthetic */ void access$setIndex$p(MineTabViewModel r0, String r1) {
        r0.index = r1;
    }

    private static final void botDeleteObserver$lambda$8(MineTabViewModel r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        List r0 = (List) r4._profileBotsLive.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        List r1 = CollectionsKt.toMutableList(r0);
        int r2 = r4.botsCount;
        if (r2 <= 0) goto L8;
        r4.botsCount = r2 - 1;
    L8:
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        fs9.n r6 = (fs9.n) r3.next();
        if (Intrinsics.areEqual(r6.e(), r5) == false) goto L10;
        r1.remove(r6);
    L14:
        r4._profileBotsLive.postValue(r1);
    }

    private static final void botUpdateObserver$lambda$9(MineTabViewModel r5, BotModel r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        List r0 = (List) r5._profileBotsLive.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        List r1 = CollectionsKt.toMutableList(r0);
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        fs9.n r3 = (fs9.n) r2.next();
        if (Intrinsics.areEqual(r3.e(), r6.getBotId()) == false) goto L7;
        r3.w(r6.getIconImage());
        r3.u(r6.getBgImgUrl());
        r3.t(r6.getBgImgUri());
        r3.r(r6.getBgImgColor());
        r3.s(r6.getBgImgInfo());
        r3.x(r6.getName());
        r3.y(r6.getPrivateStatus());
    L11:
        r5._profileBotsLive.postValue(r1);
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0090: MOVE (r2 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:33554576), block:B:28:0x0090 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x0264 -> B:223:0x010a). Please report as a decompilation issue!!! */
    private final Object handleConvChange(List<wc9.e> r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof C00991) == false) goto L7;
        C00991 r2 = (C00991) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 2;
        boolean r7 = true;
        if (r5 == 0) goto L31;
        if (r5 != 1) goto L227;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r2.L$1;
        List<wc9.e> r11 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);
        List<wc9.e> r1 = r11;
    L220:
        List r12 = (List) this._profileBotsLive.getValue();     // Catch: Throwable -> L213
        if (r12 != null) goto L39;
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L213
        r8.unlock(null);
        return r9;
    L39:
        wc9.e r10 = (wc9.e) CollectionsKt.getOrNull(r1, 0);     // Catch: Throwable -> L213
        if (r10 != null) goto L44;
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L213
        r8.unlock(null);
        return r13;
    L44:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L213
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L213
    L46:
        if (r15.hasNext() == false) goto L52;
        Object r16 = r15.next();     // Catch: Throwable -> L213
        if (Intrinsics.areEqual(((fs9.n) r16).i(), r10.a) == false) goto L46;
        r14.add(r16);     // Catch: Throwable -> L213
        goto L46
    L52:
        MineTabViewModel r18 = this;
        Iterator r17 = r14.iterator();     // Catch: Throwable -> L213
        List r19 = r14;
        wc9.e r20 = r10;
        C00991 r23 = r2;
        kotlinx.coroutines.sync.a r24 = r8;
        Object r25 = r4;
        List r26 = r12;
    L223:
    L211:
        Throwable th = th;
        r8 = r24;
    L214:
        r24 = r8;
    L215:
        Object r27 = null;
    L216:
        r24.unlock(r27);
        throw th;
    L54:
        if (r17.hasNext() == false) goto L150;
        fs9.n r110 = (fs9.n) r17.next();     // Catch: Throwable -> L211
        Integer r111 = r20.t;     // Catch: Throwable -> L206
        String r112 = "";
        if (r111 != null) goto L61;
    L59:
        List r113 = r19;
        Iterator r28 = r17;
        String r114 = r110.e();     // Catch: Throwable -> L206
        if (r114 == null) goto L108;
        BotStatusCacheDelegate.b.a(r114, r7);     // Catch: Throwable -> L206
    L108:
        IBotRepoService r115 = RepoDispatcherDelegate.b.b();     // Catch: Throwable -> L206
        String r116 = r110.e();     // Catch: Throwable -> L206
        if (r116 == null) goto L112;
        r112 = r116;
    L112:
        r23.L$0 = r24;     // Catch: Throwable -> L206
        r23.L$1 = r20;     // Catch: Throwable -> L206
        r23.L$2 = r26;     // Catch: Throwable -> L206
        r23.L$3 = r113;     // Catch: Throwable -> L206
        r23.L$4 = r28;     // Catch: Throwable -> L206
        r23.L$5 = r110;     // Catch: Throwable -> L206
        r23.label = 3;     // Catch: Throwable -> L206
        Object r117 = IBotRepoService.b.a(r115, r112, false, null, false, r23, 30);     // Catch: Throwable -> L206
        if (r117 != r25) goto L115;
        return r25;
    L115:
        kotlinx.coroutines.sync.a r118 = r24;
        List r119 = r26;
        r4 = r25;
        wc9.e r120 = r20;
        fs9.n r29 = r110;
        List r121 = r113;
        r2 = r23;
        r0 = r117;
        Iterator r122 = r28;
    L218:
        BotModel r30 = (BotModel) r0;     // Catch: Throwable -> L103
        if (r30 == null) goto L119;
        BotIconImage r31 = r30.getIconImage();     // Catch: Throwable -> L103
    L120:
        r29.w(r31);     // Catch: Throwable -> L103
        if (r30 == null) goto L123;
        String r32 = r30.getBgImgUrl();     // Catch: Throwable -> L103
    L124:
        r29.u(r32);     // Catch: Throwable -> L103
        if (r30 == null) goto L127;
        String r33 = r30.getBgImgUri();     // Catch: Throwable -> L103
    L128:
        r29.t(r33);     // Catch: Throwable -> L103
        if (r30 == null) goto L131;
        String r34 = r30.getBgImgColor();     // Catch: Throwable -> L103
    L132:
        r29.r(r34);     // Catch: Throwable -> L103
        if (r30 == null) goto L135;
        BgImageInfo r35 = r30.getBgImgInfo();     // Catch: Throwable -> L103
    L136:
        r29.s(r35);     // Catch: Throwable -> L103
        if (r30 == null) goto L139;
        String r36 = r30.getName();     // Catch: Throwable -> L103
    L140:
        r29.x(r36);     // Catch: Throwable -> L103
        if (r30 == null) goto L143;
        Integer r37 = r30.getPrivateStatus();     // Catch: Throwable -> L103
    L144:
        r29.y(r37);     // Catch: Throwable -> L103
    L102:
        r23 = r2;
        r25 = r4;
        r26 = r119;
        r20 = r120;
        r24 = r118;
        r17 = r122;
        r19 = r121;
        r6 = 2;
        r7 = true;
        goto L223
    L143:
        r37 = null;
        goto L144
    L139:
        r36 = null;
        goto L140
    L135:
        r35 = null;
        goto L136
    L131:
        r34 = null;
        goto L132
    L127:
        r33 = null;
        goto L128
    L123:
        r32 = null;
        goto L124
    L119:
        r31 = null;
    L103:
        th = th;
        r24 = r118;
        goto L215
    L61:
        if (r111.intValue() != r6) goto L59;
        String r123 = r110.e();     // Catch: Throwable -> L206
        if (r123 == null) goto L65;
        BotStatusCacheDelegate.b.a(r123, false);     // Catch: Throwable -> L206
    L65:
        r110.v("");     // Catch: Throwable -> L206
        IBotRepoService r124 = RepoDispatcherDelegate.b.b();     // Catch: Throwable -> L206
        String r125 = r110.e();     // Catch: Throwable -> L206
        if (r125 == null) goto L69;
        r112 = r125;
    L69:
        r23.L$0 = r24;     // Catch: Throwable -> L206
        r23.L$1 = r20;     // Catch: Throwable -> L206
        r23.L$2 = r26;     // Catch: Throwable -> L206
        r23.L$3 = r19;     // Catch: Throwable -> L206
        r23.L$4 = r17;     // Catch: Throwable -> L206
        r23.L$5 = r110;     // Catch: Throwable -> L206
        r23.label = r6;     // Catch: Throwable -> L206
        List r126 = r19;
        Iterator r38 = r17;
        Object r127 = IBotRepoService.b.a(r124, r112, false, null, false, r23, 30);     // Catch: Throwable -> L206
        if (r127 != r25) goto L72;
        return r25;
    L72:
        r118 = r24;
        r119 = r26;
        r4 = r25;
        r120 = r20;
        r121 = r126;
        fs9.n r39 = r110;
        r2 = r23;
        r0 = r127;
        r122 = r38;
    L73:
        BotModel r40 = (BotModel) r0;     // Catch: Throwable -> L103
        if (r40 == null) goto L76;
        BotIconImage r41 = r40.getIconImage();     // Catch: Throwable -> L103
    L77:
        r39.w(r41);     // Catch: Throwable -> L103
        if (r40 == null) goto L80;
        String r42 = r40.getBgImgUrl();     // Catch: Throwable -> L103
    L81:
        r39.u(r42);     // Catch: Throwable -> L103
        if (r40 == null) goto L84;
        String r43 = r40.getBgImgUri();     // Catch: Throwable -> L103
    L85:
        r39.t(r43);     // Catch: Throwable -> L103
        if (r40 == null) goto L88;
        String r44 = r40.getBgImgColor();     // Catch: Throwable -> L103
    L89:
        r39.r(r44);     // Catch: Throwable -> L103
        if (r40 == null) goto L92;
        BgImageInfo r45 = r40.getBgImgInfo();     // Catch: Throwable -> L103
    L93:
        r39.s(r45);     // Catch: Throwable -> L103
        if (r40 == null) goto L96;
        String r46 = r40.getName();     // Catch: Throwable -> L103
    L97:
        r39.x(r46);     // Catch: Throwable -> L103
        if (r40 == null) goto L100;
        Integer r47 = r40.getPrivateStatus();     // Catch: Throwable -> L103
    L101:
        r39.y(r47);     // Catch: Throwable -> L103
        goto L102
    L100:
        r47 = null;
        goto L101
    L96:
        r46 = null;
        goto L97
    L92:
        r45 = null;
        goto L93
    L88:
        r44 = null;
        goto L89
    L84:
        r43 = null;
        goto L85
    L80:
        r42 = null;
        goto L81
    L76:
        r41 = null;
    L206:
        th = th;
        goto L215
    L150:
        if (r19.isEmpty() == false) goto L208;
        Integer r48 = r20.j;     // Catch: Throwable -> L206
        if (r48 == null) goto L208;
        if (r48.intValue() != 3) goto L208;
        IBotRepoService r49 = RepoDispatcherDelegate.b.b();     // Catch: Throwable -> L206
        String r50 = r20.a;     // Catch: Throwable -> L206
        r23.L$0 = r24;     // Catch: Throwable -> L206
        r23.L$1 = r20;     // Catch: Throwable -> L206
        r23.L$2 = r26;     // Catch: Throwable -> L206
        r23.L$3 = null;     // Catch: Throwable -> L206
        r23.L$4 = null;     // Catch: Throwable -> L206
        r23.L$5 = null;     // Catch: Throwable -> L206
        r23.label = 4;     // Catch: Throwable -> L206
        r0 = r49.j1(r50, false, r23);     // Catch: Throwable -> L206
        if (r0 != r25) goto L159;
        return r25;
    L159:
        wc9.e r51 = r20;
    L160:
        BotModel r52 = (BotModel) r0;     // Catch: Throwable -> L206
        Iterator r53 = r26.iterator();     // Catch: Throwable -> L206
    L162:
        if (r53.hasNext() == false) goto L170;
        Object r54 = r53.next();     // Catch: Throwable -> L206
        String r55 = ((fs9.n) r54).e();     // Catch: Throwable -> L206
        if (r52 == null) goto L166;
        String r56 = r52.getBotId();     // Catch: Throwable -> L206
    L168:
        if (Intrinsics.areEqual(r55, r56) == false) goto L162;
    L171:
        fs9.n r57 = (fs9.n) r54;     // Catch: Throwable -> L206
        if (r57 == null) goto L208;
        String r58 = r57.e();     // Catch: Throwable -> L206
        if (r58 == null) goto L176;
        BotStatusCacheDelegate.b.a(r58, true);     // Catch: Throwable -> L206
    L176:
        r57.v(r51.a);     // Catch: Throwable -> L206
        if (r52 == null) goto L179;
        BotIconImage r59 = r52.getIconImage();     // Catch: Throwable -> L206
    L180:
        r57.w(r59);     // Catch: Throwable -> L206
        if (r52 == null) goto L183;
        String r60 = r52.getBgImgUrl();     // Catch: Throwable -> L206
    L184:
        r57.u(r60);     // Catch: Throwable -> L206
        if (r52 == null) goto L187;
        String r61 = r52.getBgImgUri();     // Catch: Throwable -> L206
    L188:
        r57.t(r61);     // Catch: Throwable -> L206
        if (r52 == null) goto L191;
        String r62 = r52.getBgImgColor();     // Catch: Throwable -> L206
    L192:
        r57.r(r62);     // Catch: Throwable -> L206
        if (r52 == null) goto L195;
        BgImageInfo r63 = r52.getBgImgInfo();     // Catch: Throwable -> L206
    L196:
        r57.s(r63);     // Catch: Throwable -> L206
        if (r52 == null) goto L199;
        String r64 = r52.getName();     // Catch: Throwable -> L206
    L200:
        r57.x(r64);     // Catch: Throwable -> L206
        if (r52 == null) goto L203;
        Integer r65 = r52.getPrivateStatus();     // Catch: Throwable -> L206
    L204:
        r57.y(r65);     // Catch: Throwable -> L206
        goto L208
    L203:
        r65 = null;
        goto L204
    L199:
        r64 = null;
        goto L200
    L195:
        r63 = null;
        goto L196
    L191:
        r62 = null;
        goto L192
    L187:
        r61 = null;
        goto L188
    L183:
        r60 = null;
        goto L184
    L179:
        r59 = null;
        goto L180
    L166:
        r56 = null;
        goto L168
    L170:
        r54 = null;
    L208:
        r18._profileBotsLive.postValue(r26);     // Catch: Throwable -> L206
        Unit r66 = Unit.INSTANCE;     // Catch: Throwable -> L206
        r24.unlock(null);
        return Unit.INSTANCE;
    L213:
        th = th;
        goto L214
    L227:
        if (r5 == 2) goto L24;
        if (r5 == 3) goto L21;
        if (r5 != 4) goto L20;
        r26 = (List) r2.L$2;
        r51 = (wc9.e) r2.L$1;
        r24 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L17
        r18 = this;
    L17:
        th = th;
    L29:
        r27 = null;
        goto L216
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r29 = (fs9.n) r2.L$5;
        r122 = (Iterator) r2.L$4;
        r121 = (List) r2.L$3;
        r119 = (List) r2.L$2;
        r120 = (wc9.e) r2.L$1;
        r118 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L27
        r18 = this;
        goto L218
    L24:
        r39 = (fs9.n) r2.L$5;
        r122 = (Iterator) r2.L$4;
        r121 = (List) r2.L$3;
        r119 = (List) r2.L$2;
        r120 = (wc9.e) r2.L$1;
        r118 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L27
        r18 = this;
    L27:
        th = th;
        r24 = r15;
        goto L29
    L31:
        ResultKt.throwOnFailure(r0);
        r8 = this.mutex;
        r1 = r21;
        r2.L$0 = r1;
        r2.L$1 = r8;
        r2.label = 1;
        if (r8.a(null, r2) != r4) goto L220;
        return r4;
    L7:
        r2 = new C00991(this, r22);
        goto L8
    }

    private final Object updateProfileBots(List<fs9.n> r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object createLocalConversation(fs9.n r5, Continuation<? super String> r6) {
        Map r0 = MapsKt.mutableMapOf(new Pair[]{new Pair("is_from_local_discovery", "1")});
        e10 r1 = e10.a;
        int r2 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new ic())).booleanValue() == false) goto L6;
        r0.put(REUSE_IGNORE_DELETED, "true");
    L6:
        return IConversationRepoService.a.b(RepoDispatcherDelegate.b.f(), r5.z(), r0, r6, 4);
    }

    public final void removeConversationByBot(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        com.larus.im.d.d().deleteConversation(r4, ConversationDeleteMode.DeleteMode_RealDelete, r5, new c(r4));
    }

    public static final /* synthetic */ Object access$handleConvChange(MineTabViewModel r0, List r1, Continuation r2) {
        return r0.handleConvChange(r1, r2);
    }

    public static final /* synthetic */ Object access$updateProfileBots(MineTabViewModel r0, List r1, Continuation r2) {
        return r0.updateProfileBots(r1, r2);
    }
}
