package com.larus.bot.impl.feature.discover;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.banner.BannerApi;
import com.larus.bmhome.banner.BannerResponse;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bot.impl.common.util.RecommendBotHelper;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.community.api.ICommunityService;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.bean.conversation.UpdateConversationLocalOption;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import nuc.v2;
import tx9.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010(\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00106\u001a\u0004\u0018\u000107J\u0006\u0010+\u001a\u000202J0\u00108\u001a\u0004\u0018\u0001042\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00109\u001a\u0004\u0018\u000107H\u0082@¢\u0006\u0002\u0010:J&\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u0010@J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020)0\u00182\u0006\u0010=\u001a\u00020>J\u0016\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020)H\u0086@¢\u0006\u0002\u0010DJ \u0010E\u001a\u0004\u0018\u00010\u00132\u0006\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u00192\u0006\u0010C\u001a\u00020)H\u0086@¢\u0006\u0002\u0010DJ\u0018\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010G\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010LJ \u0010M\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010\u00192\u0006\u0010C\u001a\u00020)H\u0086@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020<H\u0002J\u0012\u0010P\u001a\u00020<2\n\b\u0002\u00109\u001a\u0004\u0018\u000107R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00180$¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R+\u0010+\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00180,0$¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010/\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u00180$¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'¨\u0006R"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotDiscoverListModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "botRepo", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "ugcBotRepo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "conversationRepo", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "chatRepo", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pageIndex", "", "hasMore", "", "isLoadMore", "isRefresh", "filterAddedBotsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "getFilterAddedBotsFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "cachedConversationIdList", "tabTag", "Lcom/larus/platform/api/creation/TabTag;", "getTabTag", "()Lcom/larus/platform/api/creation/TabTag;", "setTabTag", "(Lcom/larus/platform/api/creation/TabTag;)V", "conversationIdChangeEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "getConversationIdChangeEvent", "()Landroidx/lifecycle/MutableLiveData;", "refreshData", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "getRefreshData", "loadMoreData", "Lkotlin/Pair;", "getLoadMoreData", "isRequestBanner", "bannerData", "Lcom/larus/bmhome/banner/BannerModel;", "getBannerData", "Lkotlinx/coroutines/Job;", "exist", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "triggerType", MusicAppletPage.KEY_SOURCE, "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "getBotRecommendData", "downgradeSource", "(ILjava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRecommendBotList", "", "tagId", "", "recommendBotList", "(JLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedRecommendBotList", "createConversationByBot", "bot", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeConversationByBot", "conversationId", "botId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalConversation", "findConversationByBot", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalConversationFirstMet", "(Ljava/lang/String;Lcom/larus/bmhome/chat/bean/RecommendBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindObservers", "requestBannerData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverListModel extends AndroidViewModel {
    public static final a Companion = null;
    public static final int PAGE_SIZE = 20;
    private static final String TAG = "BotDiscoverListModel";
    private final MutableLiveData<List<bb8.i>> bannerData;
    private final IBotRepoService botRepo;
    private volatile List<String> cachedConversationIdList;
    private final IChatRepoService chatRepo;
    private final MutableLiveData<te8.a> conversationIdChangeEvent;
    private final IConversationRepoService conversationRepo;
    private final MutableSharedFlow<List<String>> filterAddedBotsFlow;
    private boolean hasMore;
    private boolean isLoadMore;
    private boolean isRefresh;
    private boolean isRequestBanner;
    private final MutableLiveData<Pair<Integer, List<RecommendBot>>> loadMoreData;
    private int pageIndex;
    private final MutableLiveData<List<RecommendBot>> refreshData;
    private final CoroutineScope scope;
    private zp9.w tabTag;
    private final UgcBotRepo ugcBotRepo;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IIMCallback<Boolean> {
        public final /* synthetic */ Continuation<String> a;
        public final /* synthetic */ wc9.e b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Continuation<String> r3 = this.a;
            Result.Companion r0 = Result.Companion;
            r3.resumeWith(Result.constructor-impl(this.b.a));
        }

        public final void onSuccess(Object r2) {
            ((Boolean) r2).booleanValue();
            Continuation<String> r3 = this.a;
            Result.Companion r0 = Result.Companion;
            r3.resumeWith(Result.constructor-impl(this.b.a));
        }

        public b(SafeContinuation r1, wc9.e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$bindObservers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$bindObservers$1", f = "BotDiscoverListModel.kt", i = {0}, l = {248}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public AnonymousClass1(BotDiscoverListModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<String> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            List r2 = (List) this.L$1;
            BotDiscoverListModel r3 = (BotDiscoverListModel) this.L$0;
            ResultKt.throwOnFailure(r5);
        L16:
            List r6 = r2;
        L17:
            BotDiscoverListModel.access$setCachedConversationIdList$p(r3, r6);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            r6 = (List) this.L$0;
            if (r6 == null) goto L19;
            r3 = this.this$0;
            if (BotDiscoverListModel.access$getCachedConversationIdList$p(r3) != null) goto L17;
            MutableSharedFlow<List<String>> r4 = r3.getFilterAddedBotsFlow();
            this.L$0 = r3;
            this.L$1 = r6;
            this.label = 1;
            if (r4.emit(r6, this) != r0) goto L15;
            return r0;
        L15:
            r2 = r6;
            goto L16
        }
    }

    public static final class c implements IIMCallback<Boolean> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public c(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$createConversationByBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel", f = "BotDiscoverListModel.kt", i = {}, l = {176}, m = "createConversationByBot", n = {}, s = {})
    public static final class C01901 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01901(BotDiscoverListModel r1, Continuation<? super C01901> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createConversationByBot(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$createLocalConversation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel", f = "BotDiscoverListModel.kt", i = {0, 0, 1, 1}, l = {206, 208, 229}, m = "createLocalConversation", n = {"bot", "bizExtra", "bizExtra", "conversation"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C01911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01911(BotDiscoverListModel r1, Continuation<? super C01911> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createLocalConversation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$findConversationByBot$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$findConversationByBot$2", f = "BotDiscoverListModel.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
        final /* synthetic */ String $botId;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public AnonymousClass2(BotDiscoverListModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$botId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super wc9.e> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IConversationRepoService r5 = BotDiscoverListModel.access$getConversationRepo$p(this.this$0);
            String r2 = this.$botId;
            this.label = 1;
            r4 = r5.a(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$getBotRecommendData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel", f = "BotDiscoverListModel.kt", i = {}, l = {152, 163}, m = "getBotRecommendData", n = {}, s = {})
    public static final class C01921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01921(BotDiscoverListModel r1, Continuation<? super C01921> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BotDiscoverListModel.access$getBotRecommendData(this.this$0, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$loadMoreData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$loadMoreData$1", f = "BotDiscoverListModel.kt", i = {0}, l = {131}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C01931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01931(BotDiscoverListModel r1, Continuation<? super C01931> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01931 r0 = new C01931(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            CoroutineScope r1 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            Object r2 = r13;
        L20:
            ic8.o0 r3 = (ic8.o0) r2;
            if (r3 != null) goto L24;
            BotDiscoverListModel r4 = this.this$0;
            FLogger.a.e(BotDiscoverListModel.TAG, "load more error");
            r4.getLoadMoreData().postValue(new Pair(Boxing.boxInt(-1), null));
            BotDiscoverListModel.access$setLoadMore$p(r4, false);
            return Unit.INSTANCE;
        L24:
            BotDiscoverListModel.access$setHasMore$p(this.this$0, r3.c());
            if (ICommunityService.a.f1().f() == true) goto L27;
            this.this$0.getLoadMoreData().postValue(new Pair(Boxing.boxInt(0), r3.b()));
        L31:
            int r5 = BotDiscoverListModel.access$getPageIndex$p(this.this$0);
            BotDiscoverListModel.access$setPageIndex$p(this.this$0, r5 + 1);
            BotDiscoverListModel.access$setLoadMore$p(this.this$0, false);
            return Unit.INSTANCE;
        L27:
            if (BotDiscoverListModel.access$getHasMore$p(this.this$0) == false) goto L29;
            this.this$0.getLoadMoreData().postValue(new Pair(Boxing.boxInt(0), r3.b()));
            goto L31
        L29:
            this.this$0.getLoadMoreData().postValue(new Pair(Boxing.boxInt(2), r3.b()));
            goto L31
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            if (BotDiscoverListModel.access$getHasMore$p(this.this$0) == false) goto L34;
            if (BotDiscoverListModel.access$isLoadMore$p(this.this$0) == true) goto L34;
            if (NetworkUtils.isNetworkAvailable(this.this$0.getApplication()) == true) goto L17;
            FLogger.a.e(BotDiscoverListModel.TAG, "network not available");
            this.this$0.getLoadMoreData().postValue(new Pair(Boxing.boxInt(-1), null));
            return Unit.INSTANCE;
        L17:
            BotDiscoverListModel.access$setLoadMore$p(this.this$0, true);
            this.this$0.getLoadMoreData().postValue(new Pair(Boxing.boxInt(1), null));
            BotDiscoverListModel r8 = this.this$0;
            int r9 = BotDiscoverListModel.access$getPageIndex$p(r8);
            this.L$0 = r6;
            this.label = 1;
            r2 = BotDiscoverListModel.getBotRecommendData$default(r8, r9, "load_more", null, this, 4, null);
            if (r2 != r7) goto L20;
            return r7;
        L34:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$refreshData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$refreshData$1", f = "BotDiscoverListModel.kt", i = {}, l = {97, 115}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ic8.o0 $exist;
        final /* synthetic */ DowngradeSource $source;
        final /* synthetic */ String $triggerType;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01941(BotDiscoverListModel r1, ic8.o0 r2, String r3, DowngradeSource r4, Continuation<? super C01941> r5) {
            this.this$0 = r1;
            this.$exist = r2;
            this.$triggerType = r3;
            this.$source = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01941(this.this$0, this.$exist, this.$triggerType, this.$source, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L65:
            BotDiscoverListModel.access$setRefresh$p(this.this$0, false);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
        L19:
            ic8.o0 r14 = (ic8.o0) r13;
        L20:
            BotDiscoverListModel.access$getUgcBotRepo$p(this.this$0).b = r14;
            MutableLiveData<List<RecommendBot>> r2 = this.this$0.getRefreshData();
            List r5 = null;
            if (r14 == null) goto L23;
            List r6 = r14.b();
        L24:
            r2.postValue(r6);
            BotDiscoverListModel r3 = this.this$0;
            if (r14 == null) goto L27;
            boolean r7 = r14.c();
        L28:
            BotDiscoverListModel.access$setHasMore$p(r3, r7);
            if (r14 == null) goto L31;
            BotDiscoverListModel.access$setPageIndex$p(this.this$0, BotDiscoverListModel.access$getPageIndex$p(this.this$0) + 1);
        L31:
            long r8 = 1;
            if (this.$exist != null) goto L47;
            long r9 = 0;
            if (r14 == null) goto L36;
            long r10 = 1;
        L37:
            if (r14 == null) goto L43;
            List r11 = r14.b();
            if (r11 == null) goto L43;
            if ((!r11.isEmpty()) != true) goto L43;
            boolean r12 = true;
        L44:
            if (r12 == false) goto L46;
            r9 = 1;
        L46:
            e3.a(Boxing.boxLong(r10), Boxing.boxLong(r9));
        L43:
            r12 = false;
            goto L44
        L36:
            r10 = 0;
        L47:
            if (r14 == null) goto L49;
            List r15 = r14.b();
        L50:
            List r16 = r15;
            if (r16 != null) goto L53;
        L56:
            if (r4 == true) goto L65;
            BotDiscoverListModel r17 = this.this$0;
            zp9.w r18 = r17.getTabTag();
            if (r18 == null) goto L60;
            r8 = r18.a;
        L60:
            if (r14 == null) goto L62;
            r5 = r14.b();
        L62:
            this.label = 2;
            if (BotDiscoverListModel.access$saveRecommendBotList(r17, r8, r5, this) != r0) goto L65;
            return r0;
        L53:
            if (r16.isEmpty() == true) goto L56;
            r4 = false;
            goto L56
        L49:
            r15 = null;
            goto L50
        L27:
            r7 = false;
            goto L28
        L23:
            r6 = null;
            goto L24
        L10:
            ResultKt.throwOnFailure(r13);
            if (BotDiscoverListModel.access$isRefresh$p(this.this$0) == true) goto L13;
            BotDiscoverListModel.access$setRefresh$p(this.this$0, true);
            BotDiscoverListModel.access$setPageIndex$p(this.this$0, 1);
            r14 = this.$exist;
            if (r14 != null) goto L20;
            BotDiscoverListModel r19 = this.this$0;
            int r20 = BotDiscoverListModel.access$getPageIndex$p(r19);
            String r21 = this.$triggerType;
            DowngradeSource r22 = this.$source;
            this.label = 1;
            r13 = BotDiscoverListModel.access$getBotRecommendData(r19, r20, r21, r22, this);
            if (r13 != r0) goto L19;
            return r0;
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$requestBannerData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$requestBannerData$1", f = "BotDiscoverListModel.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01951(DowngradeSource r1, BotDiscoverListModel r2, Continuation<? super C01951> r3) {
            this.$downgradeSource = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01951(this.$downgradeSource, this.this$0, r4);
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
        L11:
            com.larus.network.http.y r7 = (com.larus.network.http.a) r6;
            if ((r7 instanceof com.larus.network.http.y) == false) goto L30;
            com.larus.network.http.y r8 = r7;
            Long r2 = r8.g;
            if (r2 == null) goto L30;
            if (r2.longValue() != 0) goto L30;
            BannerResponse r9 = (BannerResponse) ((com.larus.network.http.a) r8).b;
            MutableLiveData<List<bb8.i>> r3 = this.this$0.getBannerData();
            List r4 = null;
            if (r9 == null) goto L23;
            List r5 = r9.getBanners();
            if (r5 == null) goto L23;
            List r10 = CollectionsKt.filterNotNull(r5);
        L24:
            r3.postValue(r10);
            HashMap r11 = bb8.m.a;
            if (r9 == null) goto L29;
            List r12 = r9.getBanners();
            if (r12 == null) goto L29;
            r4 = CollectionsKt.filterNotNull(r12);
        L29:
            bb8.m.b(r4);
        L23:
            r10 = null;
        L30:
            BotDiscoverListModel.access$setRequestBanner$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BannerApi.a r13 = BannerApi.a;
            DowngradeSource r14 = this.$downgradeSource;
            this.label = 1;
            r13.getClass();
            r6 = BannerApi.a.a(2, r14, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverListModel$updateLocalConversationFirstMet$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListModel$updateLocalConversationFirstMet$2", f = "BotDiscoverListModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RecommendBot $bot;
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ BotDiscoverListModel this$0;

        public C01962(BotDiscoverListModel r1, String r2, RecommendBot r3, Continuation<? super C01962> r4) {
            this.this$0 = r1;
            this.$conversationId = r2;
            this.$bot = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01962(this.this$0, this.$conversationId, this.$bot, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            BotDiscoverListModel.access$getConversationRepo$p(this.this$0).i(this.$conversationId, this.$bot);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final void bindObservers() {
        if (FeatureKitDelegate.b.r0().b() == false) goto L6;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.conversationRepo.y(), new AnonymousClass1(this, null)), ViewModelKt.getViewModelScope(this));
        return;
    }

    public final Job loadMoreData() {
        return BuildersKt.launch$default(this.scope, null, null, new C01931(this, null), 3, null);
    }

    public final MutableLiveData<List<bb8.i>> getBannerData() {
        return this.bannerData;
    }

    public final MutableLiveData<te8.a> getConversationIdChangeEvent() {
        return this.conversationIdChangeEvent;
    }

    public final MutableSharedFlow<List<String>> getFilterAddedBotsFlow() {
        return this.filterAddedBotsFlow;
    }

    public final MutableLiveData<Pair<Integer, List<RecommendBot>>> getLoadMoreData() {
        return this.loadMoreData;
    }

    public final MutableLiveData<List<RecommendBot>> getRefreshData() {
        return this.refreshData;
    }

    public final zp9.w getTabTag() {
        return this.tabTag;
    }

    public BotDiscoverListModel(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        super(r4);
        RepoDispatcherDelegate r5 = RepoDispatcherDelegate.b;
        this.botRepo = r5.b();
        Lazy<UgcBotRepo> r0 = UgcBotRepo.d;
        this.ugcBotRepo = UgcBotRepo.a.a();
        this.conversationRepo = r5.f();
        IChatRepoService r6 = r5.e();
        this.chatRepo = r6;
        this.scope = CoroutineScopeKt.MainScope();
        this.pageIndex = 1;
        this.filterAddedBotsFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.conversationIdChangeEvent = r6.H1();
        this.refreshData = new MutableLiveData();
        this.loadMoreData = new MutableLiveData();
        this.bannerData = new MutableLiveData();
        bindObservers();
    }

    public static final /* synthetic */ List access$getCachedConversationIdList$p(BotDiscoverListModel r0) {
        return r0.cachedConversationIdList;
    }

    public static final /* synthetic */ IConversationRepoService access$getConversationRepo$p(BotDiscoverListModel r0) {
        return r0.conversationRepo;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(BotDiscoverListModel r0) {
        return r0.hasMore;
    }

    public static final /* synthetic */ int access$getPageIndex$p(BotDiscoverListModel r0) {
        return r0.pageIndex;
    }

    public static final /* synthetic */ UgcBotRepo access$getUgcBotRepo$p(BotDiscoverListModel r0) {
        return r0.ugcBotRepo;
    }

    public static final /* synthetic */ boolean access$isLoadMore$p(BotDiscoverListModel r0) {
        return r0.isLoadMore;
    }

    public static final /* synthetic */ boolean access$isRefresh$p(BotDiscoverListModel r0) {
        return r0.isRefresh;
    }

    public final List<RecommendBot> getCachedRecommendBotList(long r9) {
        UgcBotRepo r0 = this.ugcBotRepo;
        String r1 = r0.e().getString("key_recommend_bot_data_" + r9, "");
        Intrinsics.checkNotNull(r1);
        boolean r4 = false;
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L42;
        List<RecommendBot> r3 = CollectionsKt.emptyList();
    L36:
        List<RecommendBot> r5 = r3;
        Iterator r10 = r5.iterator();
    L38:
        if (r10.hasNext() == false) goto L41;
        ((RecommendBot) r10.next()).c = true;
        goto L38
    L41:
        return r5;
    L42:
        r3 = (List) GsonProtectorUtils.fromJson(new Gson(), r1, new com.larus.bot.impl.repository.e().getType());     // Catch: JsonSyntaxException -> L33
        Intrinsics.checkNotNull(r3);     // Catch: JsonSyntaxException -> L33
        List<RecommendBot> r6 = r3;     // Catch: JsonSyntaxException -> L33
        if ((r6 instanceof Collection) == true) goto L10;
    L12:
        Iterator r7 = r6.iterator();     // Catch: JsonSyntaxException -> L33
    L14:
        if (r7.hasNext() == false) goto L30;
        BotIconImage r8 = ((RecommendBot) r7.next()).O();     // Catch: JsonSyntaxException -> L33
        if (r8 == null) goto L18;
        String r11 = r8.getTinyUrl();     // Catch: JsonSyntaxException -> L33
    L19:
        if (r11 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == false) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L14;
        r4 = true;
        goto L30
    L27:
        boolean r14 = com.larus.image.loader.b0.a;     // Catch: JsonSyntaxException -> L33
        r13 = com.larus.image.loader.b0.c(com.larus.utils.y0.j(r11));     // Catch: JsonSyntaxException -> L33
        goto L28
    L21:
        if (r11.length() == 0) goto L24;
        r12 = false;
        goto L25
    L18:
        r11 = null;
    L30:
        if (r4 == false) goto L36;
        r0.e().erase("key_recommend_bot_data_" + r9);     // Catch: JsonSyntaxException -> L33
        r3 = CollectionsKt.emptyList();     // Catch: JsonSyntaxException -> L33
        goto L36
    L10:
        if (r6.isEmpty() == false) goto L12;
    L33:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        r3 = CollectionsKt.emptyList();
        goto L36
    L5:
        r2 = false;
        goto L6
    }

    public final void requestBannerData(DowngradeSource r9) {
        zp9.w r0 = this.tabTag;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L10:
        if (r2 == false) goto L13;
        return;
    L13:
        if (this.isRequestBanner == false) goto L15;
        return;
    L15:
        this.isRequestBanner = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01951(r9, this, null), 2, null);
        return;
    L5:
        if (r0.a != 1) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        r2 = true;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public final void setTabTag(zp9.w r1) {
        this.tabTag = r1;
    }

    public static final /* synthetic */ void access$setCachedConversationIdList$p(BotDiscoverListModel r0, List r1) {
        r0.cachedConversationIdList = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(BotDiscoverListModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLoadMore$p(BotDiscoverListModel r0, boolean r1) {
        r0.isLoadMore = r1;
    }

    public static final /* synthetic */ void access$setPageIndex$p(BotDiscoverListModel r0, int r1) {
        r0.pageIndex = r1;
    }

    public static final /* synthetic */ void access$setRefresh$p(BotDiscoverListModel r0, boolean r1) {
        r0.isRefresh = r1;
    }

    public static final /* synthetic */ void access$setRequestBanner$p(BotDiscoverListModel r0, boolean r1) {
        r0.isRequestBanner = r1;
    }

    public final Object createConversationByBot(RecommendBot r17, Continuation<? super Boolean> r18) {
        if ((r18 instanceof C01901) == false) goto L7;
        C01901 r2 = (C01901) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        C01901 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        boolean r15 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L20:
        if (r1 != null) goto L24;
        r15 = false;
    L24:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        IConversationRepoService r6 = this.conversationRepo;
        String r7 = r17.o();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r13.label = 1;
        r1 = IConversationRepoService.a.a(r6, r7, 2, null, null, false, null, null, null, null, r13, 508);
        if (r1 != r4) goto L20;
        return r4;
    L7:
        r2 = new C01901(this, r18);
        goto L8
    }

    public final Object createLocalConversation(RecommendBot r12, Continuation<? super String> r13) {
        if ((r13 instanceof C01911) == false) goto L7;
        C01911 r0 = (C01911) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r5 = "";
        boolean r6 = true;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r14);
    L49:
        String r15 = (String) r14;
        if (r15 != null) goto L53;
        return "";
    L53:
        return r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r16 = (wc9.e) r0.L$1;
        Map r17 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L42:
        return r14;
    L17:
        Map r18 = (Map) r0.L$1;
        RecommendBot r4 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r14);
        Map r19 = r18;
        r12 = r4;
        Object r7 = r14;
    L24:
        wc9.e r8 = (wc9.e) r7;
        if (r8 == null) goto L31;
        String r9 = r8.a;
        if (r9 == null) goto L31;
        if (com.larus.utils.o0.d(r9) != true) goto L31;
    L32:
        if (r6 == false) goto L43;
        r0.L$0 = r19;
        r0.L$1 = r8;
        r0.label = 2;
        SafeContinuation r110 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        NativeConversationServiceImpl r10 = com.larus.im.d.d();
        String r11 = r8.a;
        UpdateConversationLocalOption r20 = UpdateConversationLocalOption.REPLACE_BIZ_EXT;
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        kuc.a.f(r21);
        v2 r22 = v2.a;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        String r111 = zd9.i.c(r19, kuc.a.c(r22, r22));
        if (r111 == null) goto L37;
        r5 = r111;
    L37:
        r10.updateConversationLocal(r11, MapsKt.mapOf(TuplesKt.to(r20, r5)), new b(r110, r8));
        r14 = r110.getOrThrow();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L40:
        if (r14 != r2) goto L42;
        return r2;
    L43:
        IConversationRepoService r23 = this.conversationRepo;
        if (r12.j0() == false) goto L46;
        r19 = null;
    L46:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        r14 = r23.u(r12, r19, r0);
        if (r14 != r2) goto L49;
        return r2;
    L31:
        r6 = false;
        goto L32
    L18:
        ResultKt.throwOnFailure(r14);
        r19 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
        IConversationRepoService r24 = this.conversationRepo;
        String r25 = r12.o();
        if (r25 != null) goto L21;
        r25 = "";
    L21:
        r0.L$0 = r12;
        r0.L$1 = r19;
        r0.label = 1;
        r7 = r24.a(r25, r0);
        if (r7 != r2) goto L24;
        return r2;
    L7:
        r0 = new C01911(this, r13);
        goto L8
    }

    public final Object findConversationByBot(String r4, Continuation<? super wc9.e> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r4, null), r5);
    }

    private final Object saveRecommendBotList(long r2, List<RecommendBot> r4, Continuation<? super Unit> r5) {
        Object r3 = this.ugcBotRepo.l(r2, r4, r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final Job refreshData(ic8.o0 r11, String r12, DowngradeSource r13) {
        return BuildersKt.launch$default(this.scope, null, null, new C01941(this, r11, r12, r13, null), 3, null);
    }

    public final Object removeConversationByBot(String r3, String r4, Continuation<? super Boolean> r5) {
        Lazy r0 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.im.j.f(r3) == false) goto L8;
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r6.C();
        com.larus.im.d.a().deleteSelectionBot(r4, new c(r6));
        Object r7 = r6.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L7:
        return r7;
    L8:
        Object r8 = this.conversationRepo.l(r3, ConversationDeleteMode.DeleteMode_RealDelete, r4, r5);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r8;
    L12:
        return (Boolean) r8;
    }

    public final Object updateLocalConversationFirstMet(String r4, RecommendBot r5, Continuation<? super Unit> r6) {
        Object r7 = BuildersKt.withContext(Dispatchers.getIO(), new C01962(this, r4, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$saveRecommendBotList(BotDiscoverListModel r0, long r1, List r3, Continuation r4) {
        return r0.saveRecommendBotList(r1, r3, r4);
    }

    private final Object getBotRecommendData(int r18, String r19, DowngradeSource r20, Continuation<? super ic8.o0> r21) {
        if ((r21 instanceof C01921) == false) goto L7;
        C01921 r2 = (C01921) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ic8.o0 r5 = (ic8.o0) r2.L$1;
        Object r6 = r2.L$0;
        ResultKt.throwOnFailure(r1);
    L40:
        r5.h((List) r1);
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        Object r7 = r1;
        Object r8 = r15;
    L27:
        ic8.o0 r9 = (ic8.o0) r7;
        if (r9 == null) goto L42;
        List<RecommendBot> r10 = r9.b();
        if (r10 != null) goto L32;
        return r7;
    L32:
        if (FeatureKitDelegate.b.r0().b() == false) goto L44;
        RecommendBotHelper r11 = RecommendBotHelper.a;
        List<String> r12 = this.cachedConversationIdList;
        if (r12 != null) goto L36;
        r12 = CollectionsKt.emptyList();
    L36:
        r2.L$0 = r7;
        r2.L$1 = r9;
        r2.label = 2;
        Object r13 = r11.a(r10, r12, r2);
        if (r13 != r8) goto L39;
        return r8;
    L39:
        r1 = r13;
        r6 = r7;
        r5 = r9;
        goto L40
    L44:
        return r7;
    L42:
        return r7;
    L16:
        ResultKt.throwOnFailure(r1);
        IBotRepoService r14 = this.botRepo;
        zp9.w r16 = this.tabTag;
        if (r16 == null) goto L19;
        Long r17 = Boxing.boxLong(r16.a);
    L20:
        zp9.w r22 = this.tabTag;
        if (r22 == null) goto L23;
        String r110 = r22.b;
    L24:
        r2.label = 1;
        r8 = r15;
        r7 = IBotRepoService.b.b(r14, 2, r18, 20, r17, false, null, r19, r110, null, r20, r2, 304);
        if (r7 != r8) goto L27;
        return r8;
    L23:
        r110 = null;
        goto L24
    L19:
        r17 = null;
    L7:
        r2 = new C01921(this, r21);
        goto L8
    }

    public static /* synthetic */ void requestBannerData$default(BotDiscoverListModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.requestBannerData(r1);
    }

    public static final /* synthetic */ Object access$getBotRecommendData(BotDiscoverListModel r0, int r1, String r2, DowngradeSource r3, Continuation r4) {
        return r0.getBotRecommendData(r1, r2, r3, r4);
    }

    public static /* synthetic */ Job refreshData$default(BotDiscoverListModel r1, ic8.o0 r2, String r3, DowngradeSource r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        return r1.refreshData(r2, r3, r4);
    }

    public static /* synthetic */ Object getBotRecommendData$default(BotDiscoverListModel r1, int r2, String r3, DowngradeSource r4, Continuation r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.getBotRecommendData(r2, r3, r4, r5);
    }
}
