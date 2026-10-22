package com.larus.profile.impl.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.larus.account.base.api.IAccountService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import com.larus.im.service.q;
import com.larus.im.service.z;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.f;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatService;
import com.larus.profile.impl.ProfileRepo;
import com.larus.profile.impl.ProfileRequestSource;
import com.tencent.open.log.TraceLevel;
import fs9.n;
import fs9.o;
import fs9.r;
import fs9.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013*\u00010\u0018\u0000 ]2\u00020\u0001:\u0001]B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020EJ \u0010J\u001a\u0004\u0018\u00010K2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0082@¢\u0006\u0002\u0010MJ\u0016\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010PJ\u0016\u0010Q\u001a\u00020K2\u0006\u0010O\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010PJ\u0018\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010S\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010PJ\u0016\u0010T\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010PJ\u0016\u0010U\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010PJ\u001e\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u00020KH\u0014J\u0010\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020\u001eH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@¨\u0006^"}, d2 = {"Lcom/larus/profile/impl/viewmodel/ProfileInfoViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", ProfileInfoViewModel.KEY_INDEX, "botListLoadSuccess", "", "_userInfoState", "Lcom/larus/network/http/AsyncLiveData;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "userInfoState", "Landroidx/lifecycle/LiveData;", "Lcom/larus/network/http/Async;", "getUserInfoState", "()Landroidx/lifecycle/LiveData;", "_loadMoreState", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "loadMoreState", "getLoadMoreState", "_profileBotsLive", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/profile/api/bean/ProfileBot;", "profileBotsLive", "getProfileBotsLive", "_profileStatusLive", "", "profileStatusLive", "getProfileStatusLive", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "Lkotlin/Lazy;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "repo", "Lcom/larus/profile/impl/ProfileRepo;", "onConversationChangedObserver", "com/larus/profile/impl/viewmodel/ProfileInfoViewModel$onConversationChangedObserver$1", "Lcom/larus/profile/impl/viewmodel/ProfileInfoViewModel$onConversationChangedObserver$1;", "botDeleteObserver", "Landroidx/lifecycle/Observer;", "botUpdateObserver", "Lcom/larus/im/bean/bot/BotModel;", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfo", "()Lcom/larus/account/base/model/profile/UserInfo;", "setUserInfo", "(Lcom/larus/account/base/model/profile/UserInfo;)V", "botsCount", "getBotsCount", "()I", "setBotsCount", "(I)V", "blockListType", "getBlockListType", "setBlockListType", "queryUserInfo", "Lkotlinx/coroutines/Job;", "forceUpdateBotList", "source", "Lcom/larus/profile/impl/ProfileRequestSource;", "queryLoadMoreList", "updateProfileBots", "", "profileBots", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBotReviewInfo", "profileBot", "(Lcom/larus/profile/api/bean/ProfileBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBotTTSInfo", "createLocalConversation", "bot", "createConversationByBot", "updateCreateScene", "removeConversationByBot", "conversationId", "botId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "getBotType", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileInfoViewModel extends AndroidViewModel {
    public static final int BLOCK_LIST_TYPE_BLOCK = 1;
    public static final int BLOCK_LIST_TYPE_BLOCKED = 2;
    public static final int BLOCK_LIST_TYPE_NONE = 0;
    public static final int BLOCK_LIST_TYPE_NOT_ALLOW = 3;
    public static final int BLOCK_LIST_TYPE_NOT_INIT = -1;
    public static final a Companion = null;
    private static final String KEY_INDEX = "index";
    private static final String KEY_LIMIT = "limit";
    private static final String KEY_VISIT_ID = "visit_id";
    public static final int PROFILE_STATUS_NORMAL = 0;
    public static final int PROFILE_STATUS_USER_BANNED = 1;
    private static final int VALUE_LIMIT = 10;
    private final AsyncLiveData<r> _loadMoreState;
    private final MutableLiveData<List<n>> _profileBotsLive;
    private final MutableLiveData<Integer> _profileStatusLive;
    private final AsyncLiveData<u> _userInfoState;
    private volatile int blockListType;
    private final Observer<String> botDeleteObserver;
    private boolean botListLoadSuccess;
    private final Observer<BotModel> botUpdateObserver;
    private int botsCount;
    private String index;
    private final LiveData<com.larus.network.http.a<r>> loadMoreState;
    private final kotlinx.coroutines.sync.a mutex;
    private final b onConversationChangedObserver;
    private final LiveData<List<n>> profileBotsLive;
    private final LiveData<Integer> profileStatusLive;
    private final ProfileRepo repo;
    private final Lazy service$delegate;
    private String userId;
    private r38.b userInfo;
    private final LiveData<com.larus.network.http.a<u>> userInfoState;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements z<List<? extends e>> {
        public final /* synthetic */ ProfileInfoViewModel a;

        public b(ProfileInfoViewModel r1) {
            this.a = r1;
        }

        public final void c(Object r8) {
            List r9 = (List) r8;
            Intrinsics.checkNotNullParameter(r9, SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1(this.a, r9, null), 3, null);
        }
    }

    public static final class c implements IIMCallback<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ CompletableDeferred<Boolean> b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            this.b.complete(Boolean.FALSE);
            Intrinsics.checkNotNullParameter(r4, "error");
        }

        public final void onSuccess(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            IAIChatService.a.Y7().a(this.a);
        L5:
            this.b.complete(Boolean.TRUE);
        }

        public c(String r1, CompletableDeferred<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileInfoViewModel$createConversationByBot$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel", f = "ProfileInfoViewModel.kt", i = {}, l = {385}, m = "createConversationByBot", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProfileInfoViewModel this$0;

        public AnonymousClass1(ProfileInfoViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createConversationByBot(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileInfoViewModel$queryLoadMoreList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel$queryLoadMoreList$1", f = "ProfileInfoViewModel.kt", i = {0, 1}, l = {484, 229}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class C01061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ProfileInfoViewModel this$0;

        public C01061(ProfileInfoViewModel r1, Continuation<? super C01061> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01061(this.this$0, r3);
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
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            ProfileInfoViewModel r2 = (ProfileInfoViewModel) this.L$1;
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L9
        L26:
            y r10 = (com.larus.network.http.a) r9;     // Catch: Throwable -> L9
            if ((r10 instanceof y) == false) goto L50;
            r r4 = (r) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L9
            if (r4 == null) goto L32;
            String r5 = r4.b();     // Catch: Throwable -> L9
            if (r5 == null) goto L32;
        L33:
            ProfileInfoViewModel.access$setIndex$p(r2, r5);     // Catch: Throwable -> L9
            r r6 = (r) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L9
            if (r6 == null) goto L36;
            List<n> r7 = r6.c();     // Catch: Throwable -> L9
        L37:
            if (r7 == null) goto L50;
            List r8 = (List) ProfileInfoViewModel.access$get_profileBotsLive$p(r2).getValue();     // Catch: Throwable -> L9
            if (r8 == null) goto L50;
            List r11 = CollectionsKt.toMutableList(r8);     // Catch: Throwable -> L9
            if (r11 == null) goto L50;
            r11.addAll(r7);     // Catch: Throwable -> L9
            HashSet r12 = new HashSet();     // Catch: Throwable -> L9
            ArrayList r13 = new ArrayList();     // Catch: Throwable -> L9
            Iterator r14 = r11.iterator();     // Catch: Throwable -> L9
        L45:
            if (r14.hasNext() == false) goto L49;
            Object r15 = r14.next();     // Catch: Throwable -> L9
            if (r12.add(((n) r15).e()) == false) goto L45;
            r13.add(r15);     // Catch: Throwable -> L9
            goto L45
        L49:
            ProfileInfoViewModel.access$get_profileBotsLive$p(r2).setValue(r13);     // Catch: Throwable -> L9
            goto L50
        L36:
            r7 = null;
        L32:
            r5 = "";
        L50:
            ProfileInfoViewModel.access$get_loadMoreState$p(r2).setValue(r10);     // Catch: Throwable -> L9
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r3.unlock(null);
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            th = th;
            kotlinx.coroutines.sync.a r17 = r3;
        L55:
            r17.unlock(null);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ProfileInfoViewModel r18 = (ProfileInfoViewModel) this.L$1;
            kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r9);
            r17 = r19;
        L57:
        L54:
            th = th;
            goto L55
        L18:
            if ((ProfileInfoViewModel.access$get_loadMoreState$p(r18).getValue() instanceof w) == false) goto L22;
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L54
            r17.unlock(null);
            return r20;
        L22:
            ProfileInfoViewModel.access$get_loadMoreState$p(r18).setValue(new w(null));     // Catch: Throwable -> L54
            ProfileRepo r21 = ProfileInfoViewModel.access$getRepo$p(r18);     // Catch: Throwable -> L54
            String r22 = r18.getUserId();     // Catch: Throwable -> L54
            String r23 = ProfileInfoViewModel.access$getIndex$p(r18);     // Catch: Throwable -> L54
            ProfileRequestSource r24 = ProfileRequestSource.LOAD_MORE;     // Catch: Throwable -> L54
            this.L$0 = r17;     // Catch: Throwable -> L54
            this.L$1 = r18;     // Catch: Throwable -> L54
            this.label = 2;     // Catch: Throwable -> L54
            r21.getClass();     // Catch: Throwable -> L54
            Object r25 = ProfileRepo.c(r22, r23, r24, false, this);     // Catch: Throwable -> L54
            if (r25 != r0) goto L25;
            return r0;
        L25:
            r2 = r18;
            r3 = r17;
            r9 = r25;
            goto L26
        L14:
            ResultKt.throwOnFailure(r9);
            r17 = ProfileInfoViewModel.access$getMutex$p(this.this$0);
            r18 = this.this$0;
            this.L$0 = r17;
            this.L$1 = r18;
            this.label = 1;
            if (r17.a(null, this) != r0) goto L57;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileInfoViewModel$queryUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel$queryUserInfo$1", f = "ProfileInfoViewModel.kt", i = {0, 1, 1}, l = {191, 195}, m = "invokeSuspend", n = {"getProfileBotsJob", "userInfoResult", "profileBotsResult"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceUpdateBotList;
        final /* synthetic */ ProfileRequestSource $source;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ProfileInfoViewModel this$0;

        public C01071(ProfileInfoViewModel r1, boolean r2, ProfileRequestSource r3, Continuation<? super C01071> r4) {
            this.this$0 = r1;
            this.$forceUpdateBotList = r2;
            this.$source = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C01071 r0 = new C01071(this.this$0, this.$forceUpdateBotList, this.$source, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            int r3 = -1;
            int r4 = 0;
            List<n> r7 = null;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$2;
            Ref.ObjectRef r6 = (Ref.ObjectRef) this.L$1;
            com.larus.network.http.a r8 = (com.larus.network.http.a) this.L$0;
            ResultKt.throwOnFailure(r18);
            com.larus.network.http.a r9 = r8;
            Object r10 = r18;
        L29:
            r5.element = r10;
            if ((r6.element instanceof y) == false) goto L66;
            ProfileInfoViewModel r11 = this.this$0;
            y r12 = (y) r9;
            u r13 = (u) ((com.larus.network.http.a) r12).b;
            if (r13 == null) goto L34;
            r38.b r14 = r13.f();
        L35:
            r11.setUserInfo(r14);
            ProfileInfoViewModel r15 = this.this$0;
            r r16 = (r) ((com.larus.network.http.a) ((y) r6.element)).b;
            if (r16 == null) goto L38;
            int r17 = r16.d();
        L39:
            r15.setBotsCount(r17);
            ProfileInfoViewModel r19 = this.this$0;
            u r20 = (u) ((com.larus.network.http.a) r12).b;
            if (r20 == null) goto L44;
            fs9.b r21 = r20.b();
            if (r21 == null) goto L44;
            r3 = r21.a();
        L44:
            r19.setBlockListType(r3);
            r r22 = (r) ((com.larus.network.http.a) ((y) r6.element)).b;
            if (r22 == null) goto L47;
            List<n> r23 = r22.c();
        L48:
            if (r23 != null) goto L51;
            r23 = CollectionsKt.emptyList();
        L51:
            if (ProfileInfoViewModel.access$getBotListLoadSuccess$p(this.this$0) == true) goto L53;
        L54:
            ProfileInfoViewModel r24 = this.this$0;
            r r25 = (r) ((com.larus.network.http.a) ((y) r6.element)).b;
            if (r25 == null) goto L57;
            String r26 = r25.b();
        L58:
            if (r26 != null) goto L60;
            r26 = "";
        L60:
            ProfileInfoViewModel.access$setIndex$p(r24, r26);
            ProfileInfoViewModel.access$get_profileBotsLive$p(this.this$0).postValue(r23);
            ProfileInfoViewModel.access$setBotListLoadSuccess$p(this.this$0, true);
        L61:
            r38.b r27 = this.this$0.getUserInfo();
            if (r27 == null) goto L66;
            ProfileRequestSource r28 = this.$source;
            String r29 = r27.f();
            AccountService r30 = AccountService.a;
            if (Intrinsics.areEqual(r29, r30.getUserId()) == false) goto L66;
            IAccountService.Companion r31 = IAccountService.a;
            r31.l(r27);
            r31.o(r30.getUserId(), r27.c(), r28.getValue());
            goto L66
        L57:
            r26 = null;
            goto L58
        L53:
            if (this.$forceUpdateBotList == false) goto L61;
        L47:
            r23 = null;
            goto L48
        L38:
            r17 = 0;
            goto L39
        L34:
            r14 = null;
        L66:
            Ref.ObjectRef r32 = r6;
            com.larus.network.http.a r33 = r9;
        L68:
            if ((r33 instanceof y) == true) goto L70;
        L81:
            AsyncLiveData r34 = ProfileInfoViewModel.access$get_userInfoState$p(this.this$0);
            AsyncThrowable.Companion.getClass();
            r34.postValue(new f(AsyncThrowable.access$getDEFAULT$cp(), null));
        L83:
            return Unit.INSTANCE;
        L70:
            if ((r32.element instanceof y) == false) goto L81;
            AsyncLiveData r35 = ProfileInfoViewModel.access$get_userInfoState$p(this.this$0);
            u r36 = (u) ((com.larus.network.http.a) ((y) r33)).b;
            if (r36 == null) goto L80;
            r r37 = (r) ((com.larus.network.http.a) ((y) r32.element)).b;
            if (r37 == null) goto L76;
            r4 = r37.d();
        L76:
            r r38 = (r) ((com.larus.network.http.a) ((y) r32.element)).b;
            if (r38 == null) goto L79;
            r7 = r38.c();
        L79:
            r36.g(new o(r4, r7));
        L80:
            r35.postValue(r33);
            goto L83
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Deferred r39 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r18);
            Deferred r40 = r39;
            Object r41 = r18;
        L17:
            r33 = (com.larus.network.http.a) r41;
            r32 = new Ref.ObjectRef();
            AsyncThrowable.Companion.getClass();
            r32.element = new f(AsyncThrowable.access$getDEFAULT$cp(), null);
            if ((r33 instanceof y) == false) goto L68;
            MutableLiveData r110 = ProfileInfoViewModel.access$get_profileStatusLive$p(this.this$0);
            u r111 = (u) ((com.larus.network.http.a) ((y) r33)).b;
            if (r111 == null) goto L24;
            Integer r112 = r111.d();
            if (r112 == null) goto L24;
            int r113 = r112.intValue();
        L25:
            r110.postValue(Boxing.boxInt(r113));
            this.L$0 = r33;
            this.L$1 = r32;
            this.L$2 = r32;
            this.label = 2;
            r10 = r40.await(this);
            if (r10 != r1) goto L28;
            return r1;
        L28:
            r9 = r33;
            r5 = r32;
            r6 = r5;
        L24:
            r113 = 0;
            goto L25
        L10:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r42 = (CoroutineScope) this.L$0;
            if ((ProfileInfoViewModel.access$get_userInfoState$p(this.this$0).getValue() instanceof w) == true) goto L13;
            ProfileInfoViewModel.access$get_userInfoState$p(this.this$0).postValue(new w(null));
            this.this$0.setBlockListType(-1);
            Deferred r114 = BuildersKt.async$default(r42, null, null, new ProfileInfoViewModel$queryUserInfo$1$getUserInfoJob$1(this.this$0, this.$source, null), 3, null);
            r40 = BuildersKt.async$default(r42, null, null, new ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1(this.this$0, this.$source, null), 3, null);
            this.L$0 = r40;
            this.label = 1;
            r41 = r114.await(this);
            if (r41 != r1) goto L17;
            return r1;
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileInfoViewModel$updateProfileBots$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel$updateProfileBots$2", f = "ProfileInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<n> $profileBots;
        int label;

        public AnonymousClass2(List<n> r1, Continuation<? super AnonymousClass2> r2) {
            this.$profileBots = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$profileBots, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            List<n> r4 = this.$profileBots;
            if (r4 == null) goto L11;
            Iterator<T> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L16;
            BotModel r0 = ((n) r5.next()).z();
            RepoDispatcherDelegate.b.b().e1(r0);
            goto L8
        L16:
            return Unit.INSTANCE;
        L11:
            return null;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void Mo(ProfileInfoViewModel r0, String r1) {
        botDeleteObserver$lambda$1(r0, r1);
    }

    public static /* synthetic */ void No(ProfileInfoViewModel r0, BotModel r1) {
        botUpdateObserver$lambda$2(r0, r1);
    }

    public static /* synthetic */ q yo() {
        return service_delegate$lambda$0();
    }

    private final q getService() {
        return (q) this.service$delegate.getValue();
    }

    private static final q service_delegate$lambda$0() {
        return d.c();
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        getService().unRegisterConversationChangeListener(this.onConversationChangedObserver);
        RepoDispatcherDelegate r0 = RepoDispatcherDelegate.b;
        r0.b().r1().removeObserver(this.botDeleteObserver);
        r0.b().n1().removeObserver(this.botUpdateObserver);
    }

    public final Job queryLoadMoreList() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01061(this, null), 3, null);
    }

    public final int getBlockListType() {
        return this.blockListType;
    }

    public final int getBotsCount() {
        return this.botsCount;
    }

    public final LiveData<com.larus.network.http.a<r>> getLoadMoreState() {
        return this.loadMoreState;
    }

    public final LiveData<List<n>> getProfileBotsLive() {
        return this.profileBotsLive;
    }

    public final LiveData<Integer> getProfileStatusLive() {
        return this.profileStatusLive;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final r38.b getUserInfo() {
        return this.userInfo;
    }

    public final LiveData<com.larus.network.http.a<u>> getUserInfoState() {
        return this.userInfoState;
    }

    public ProfileInfoViewModel(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        super(r4);
        this.userId = "";
        this.index = "";
        AsyncLiveData<u> r5 = new AsyncLiveData();
        this._userInfoState = r5;
        this.userInfoState = r5;
        AsyncLiveData<r> r6 = new AsyncLiveData();
        this._loadMoreState = r6;
        this.loadMoreState = r6;
        MutableLiveData<List<n>> r7 = new MutableLiveData();
        this._profileBotsLive = r7;
        this.profileBotsLive = r7;
        MutableLiveData<Integer> r8 = new MutableLiveData();
        this._profileStatusLive = r8;
        this.profileStatusLive = r8;
        this.service$delegate = LazyKt.lazy(new com.larus.profile.impl.viewmodel.a());
        this.mutex = kotlinx.coroutines.sync.b.a();
        Lazy<ProfileRepo> r9 = ProfileRepo.b;
        this.repo = ProfileRepo.a.a();
        b r10 = new b(this);
        this.onConversationChangedObserver = r10;
        Observer<String> r0 = new com.larus.profile.impl.viewmodel.b(this);
        this.botDeleteObserver = r0;
        Observer<BotModel> r1 = new com.larus.profile.impl.viewmodel.c(this);
        this.botUpdateObserver = r1;
        getService().registerConversationChangeListener(r10);
        RepoDispatcherDelegate r11 = RepoDispatcherDelegate.b;
        r11.b().r1().observeForever(r0);
        r11.b().n1().observeForever(r1);
        this.blockListType = -1;
    }

    public static final /* synthetic */ boolean access$getBotListLoadSuccess$p(ProfileInfoViewModel r0) {
        return r0.botListLoadSuccess;
    }

    public static final /* synthetic */ String access$getIndex$p(ProfileInfoViewModel r0) {
        return r0.index;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(ProfileInfoViewModel r0) {
        return r0.mutex;
    }

    public static final /* synthetic */ ProfileRepo access$getRepo$p(ProfileInfoViewModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ AsyncLiveData access$get_loadMoreState$p(ProfileInfoViewModel r0) {
        return r0._loadMoreState;
    }

    public static final /* synthetic */ MutableLiveData access$get_profileBotsLive$p(ProfileInfoViewModel r0) {
        return r0._profileBotsLive;
    }

    public static final /* synthetic */ MutableLiveData access$get_profileStatusLive$p(ProfileInfoViewModel r0) {
        return r0._profileStatusLive;
    }

    public static final /* synthetic */ AsyncLiveData access$get_userInfoState$p(ProfileInfoViewModel r0) {
        return r0._userInfoState;
    }

    private final int getBotType(n r2) {
        int r3 = r2.h();
        if (r3 != 0) goto L5;
        return 0;
    L5:
        if (r3 == 1) goto L9;
        return 2;
    L9:
        return 1;
    }

    public final void setBlockListType(int r1) {
        this.blockListType = r1;
    }

    public final void setBotsCount(int r1) {
        this.botsCount = r1;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public final void setUserInfo(r38.b r1) {
        this.userInfo = r1;
    }

    public static final /* synthetic */ void access$setBotListLoadSuccess$p(ProfileInfoViewModel r0, boolean r1) {
        r0.botListLoadSuccess = r1;
    }

    public static final /* synthetic */ void access$setIndex$p(ProfileInfoViewModel r0, String r1) {
        r0.index = r1;
    }

    private static final void botDeleteObserver$lambda$1(ProfileInfoViewModel r4, String r5) {
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
        n r6 = (n) r3.next();
        if (Intrinsics.areEqual(r6.e(), r5) == false) goto L10;
        r1.remove(r6);
    L14:
        r4._profileBotsLive.postValue(r1);
    }

    private static final void botUpdateObserver$lambda$2(ProfileInfoViewModel r5, BotModel r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        List r0 = (List) r5._profileBotsLive.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        List r1 = CollectionsKt.toMutableList(r0);
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        n r3 = (n) r2.next();
        if (Intrinsics.areEqual(r3.e(), r6.getBotId()) == false) goto L7;
        r3.w(r6.getIconImage());
        r3.x(r6.getName());
        r3.y(r6.getPrivateStatus());
    L11:
        r5._profileBotsLive.postValue(r1);
    }

    private final Object updateBotReviewInfo(n r1, Continuation<? super Unit> r2) {
        BotModel r3 = r1.z();
        RepoDispatcherDelegate.b.b().e1(r3);
        return Unit.INSTANCE;
    }

    private final Object updateBotTTSInfo(n r1, Continuation<? super Unit> r2) {
        BotModel r3 = r1.z();
        RepoDispatcherDelegate.b.b().e1(r3);
        return Unit.INSTANCE;
    }

    private final Object updateProfileBots(List<n> r4, Continuation<? super Unit> r5) {
        return RepoDispatcherDelegate.b.d(new AnonymousClass2(r4, null), r5);
    }

    public final Object createConversationByBot(n r18, Continuation<? super Boolean> r19) {
        if ((r19 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        boolean r15 = false;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L28:
        if (((e) r0) == null) goto L31;
        r15 = true;
    L31:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r5 = r18.e();
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L23;
        IConversationRepoService r7 = RepoDispatcherDelegate.b.f();
        r13.label = 1;
        r0 = IConversationRepoService.a.a(r7, r5, 2, null, null, false, null, null, null, null, r13, 508);
        if (r0 != r3) goto L28;
        return r3;
    L23:
        return Boxing.boxBoolean(false);
    L17:
        if (StringsKt.isBlank(r5) == true) goto L20;
        r6 = false;
    L7:
        r1 = new AnonymousClass1(this, r19);
        goto L8
    }

    public final Object createLocalConversation(n r4, Continuation<? super String> r5) {
        Map r0 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
        return IConversationRepoService.a.b(RepoDispatcherDelegate.b.f(), r4.z(), r0, r5, 4);
    }

    public final Job queryUserInfo(boolean r8, ProfileRequestSource r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01071(this, r8, r9, null), 2, null);
    }

    public final Object updateCreateScene(n r3, Continuation<? super Boolean> r4) {
        String r5 = r3.i();
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        return RepoDispatcherDelegate.b.f().s(r5, r4);
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ Object access$updateBotReviewInfo(ProfileInfoViewModel r0, n r1, Continuation r2) {
        return r0.updateBotReviewInfo(r1, r2);
    }

    public static final /* synthetic */ Object access$updateBotTTSInfo(ProfileInfoViewModel r0, n r1, Continuation r2) {
        return r0.updateBotTTSInfo(r1, r2);
    }

    public static final /* synthetic */ Object access$updateProfileBots(ProfileInfoViewModel r0, List r1, Continuation r2) {
        return r0.updateProfileBots(r1, r2);
    }

    public final Object removeConversationByBot(String r5, String r6, Continuation<? super Boolean> r7) {
        CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        d.d().deleteConversation(r5, ConversationDeleteMode.DeleteMode_RealDelete, r6, new c(r5, r0));
        return r0.await(r7);
    }

    public static /* synthetic */ Job queryUserInfo$default(ProfileInfoViewModel r0, boolean r1, ProfileRequestSource r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.queryUserInfo(r1, r2);
    }
}
