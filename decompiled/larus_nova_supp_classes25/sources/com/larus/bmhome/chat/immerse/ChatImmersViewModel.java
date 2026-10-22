package com.larus.bmhome.chat.immerse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.network.http.AsyncThrowable;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010:\u001a\u0004\u0018\u00010\u00192\b\u0010;\u001a\u0004\u0018\u00010\"J\u001c\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@J\"\u0010A\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010CJ&\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010G0F0E2\b\u0010?\u001a\u0004\u0018\u00010@H\u0082@¢\u0006\u0002\u0010HJ$\u0010I\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u0010J\u001a\u00020G2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!0\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!0\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR'\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b-\u0010\u001bR(\u00100\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00070\u00070\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pageIndex", "", "isRefresh", "", "()Z", "setRefresh", "(Z)V", "isFirstLoading", "setFirstLoading", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "hasMore", "getHasMore", "setHasMore", "feedData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "getFeedData", "()Landroidx/lifecycle/MutableLiveData;", "dataLoading", "getDataLoading", "viewPagerState", "getViewPagerState", "currentPage", "Lkotlin/Pair;", "", "getCurrentPage", "slideDistance", "getSlideDistance", "listShown", "getListShown", "onClickBackEvent", "getOnClickBackEvent", "getData", "Lcom/larus/network/http/Async;", "", "getGetData", "getData$delegate", "Lkotlin/Lazy;", "allowVpOffset", "kotlin.jvm.PlatformType", "getAllowVpOffset", "setAllowVpOffset", "(Landroidx/lifecycle/MutableLiveData;)V", "firstBotId", "getFirstBotId", "()Ljava/lang/String;", "setFirstBotId", "(Ljava/lang/String;)V", "getCurrentRecommendBot", "botId", "loadFeedData", "", "scene", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "refreshFeedData", "callback", "Lkotlin/Function0;", "executeApiCall", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "(Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processData", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatImmersViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ChatImmersViewModel";
    private MutableLiveData<Boolean> allowVpOffset;
    private final MutableLiveData<Pair<Integer, String>> currentPage;
    private final MutableLiveData<Boolean> dataLoading;
    private long enterTime;
    private final MutableLiveData<List<RecommendBot>> feedData;
    private String firstBotId;
    private final Lazy getData$delegate;
    private boolean hasMore;
    private boolean isFirstLoading;
    private boolean isRefresh;
    private final MutableLiveData<Boolean> listShown;
    private final MutableLiveData<Boolean> onClickBackEvent;
    private int pageIndex;
    private final MutableLiveData<Pair<Integer, Integer>> slideDistance;
    private final MutableLiveData<Integer> viewPagerState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$executeApiCall$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/larus/bmhome/chat/bean/RecommendBotData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.immerse.ChatImmersViewModel$executeApiCall$2", f = "ChatImmersViewModel.kt", i = {0}, l = {138, DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends ic8.o0>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatImmersViewModel this$0;

        public AnonymousClass2(ChatImmersViewModel r1, DowngradeSource r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$downgradeSource = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$downgradeSource, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super Result<ic8.o0>> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r19);
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            FlowCollector r1 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r19);
            FlowCollector r2 = r1;
            Object r3 = r19;
        L14:
            Result r4 = Result.box-impl(Result.constructor-impl((ic8.o0) r3));
            this.L$0 = null;
            this.label = 2;
            if (r2.emit(r4, this) != r14) goto L18;
            return r14;
        L10:
            ResultKt.throwOnFailure(r19);
            FlowCollector r12 = (FlowCollector) this.L$0;
            RepoDispatcher.a.getClass();
            BotRepo r5 = RepoDispatcher.g;
            int r6 = ChatImmersViewModel.access$getPageIndex$p(this.this$0);
            String r10 = this.this$0.getFirstBotId();
            DowngradeSource r11 = this.$downgradeSource;
            this.L$0 = r12;
            this.label = 1;
            r3 = IBotRepoService.b.b(r5, 5, r6, 20, null, true, null, null, null, r10, r11, this, 224);
            if (r3 != r14) goto L13;
            return r14;
        L13:
            r2 = r12;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$executeApiCall$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.immerse.ChatImmersViewModel$executeApiCall$3", f = "ChatImmersViewModel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends ic8.o0>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super Result<ic8.o0>> r2, Throwable r3, Continuation<? super Unit> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(r4);
            r0.L$0 = r2;
            r0.L$1 = r3;
            return r0.invokeSuspend(Unit.INSTANCE);
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
            FlowCollector r6 = (FlowCollector) this.L$0;
            Throwable r2 = (Throwable) this.L$1;
            Result.Companion r3 = Result.Companion;
            Result r4 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r2)));
            this.L$0 = null;
            this.label = 1;
            if (r6.emit(r4, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$loadFeedData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.immerse.ChatImmersViewModel$loadFeedData$1", f = "ChatImmersViewModel.kt", i = {}, l = {68, 68}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        final /* synthetic */ String $scene;
        int label;
        final /* synthetic */ ChatImmersViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$loadFeedData$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatImmersViewModel a;
            public final /* synthetic */ String b;

            public a(ChatImmersViewModel r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r10, Continuation<? super Unit> r11) {
                Result r12 = (Result) r10;
                if (Result.isSuccess-impl(r12.unbox-impl()) == false) goto L22;
                Object r13 = r12.unbox-impl();
                ChatImmersViewModel r14 = this.a;
                Throwable r2 = Result.exceptionOrNull-impl(r13);
                if (r2 != null) goto L20;
                ic8.o0 r15 = (ic8.o0) r13;
                if (r15 == null) goto L9;
                ChatImmersViewModel.processData$default(this.a, this.b, r15, false, 4, null);
            L9:
                if (r15 == null) goto L19;
                List<RecommendBot> r16 = r15.b();
                if (r16 != null) goto L13;
            L15:
                boolean r17 = false;
            L16:
                if (r17 == true) goto L19;
                this.a.getGetData().postValue(new com.larus.network.http.y(null, null, 15));
                this.a.setFirstLoading(false);
            L23:
                this.a.getDataLoading().setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            L13:
                if (r16.size() != 0) goto L15;
                r17 = true;
            L19:
                MutableLiveData<com.larus.network.http.a<Object>> r18 = this.a.getGetData();
                AsyncThrowable.Companion.getClass();
                r18.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                goto L23
            L20:
                FLogger.a.e(ChatImmersViewModel.TAG, String.valueOf(r2));
                r14.getDataLoading().setValue(Boxing.boxBoolean(false));
                MutableLiveData<com.larus.network.http.a<Object>> r19 = r14.getGetData();
                AsyncThrowable.Companion.getClass();
                r19.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                return Unit.INSTANCE;
            L22:
                MutableLiveData<com.larus.network.http.a<Object>> r110 = this.a.getGetData();
                AsyncThrowable.Companion.getClass();
                r110.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                goto L23
            }
        }

        public AnonymousClass1(ChatImmersViewModel r1, DowngradeSource r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$downgradeSource = r2;
            this.$scene = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$downgradeSource, this.$scene, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L16:
            a r2 = new a(this.this$0, this.$scene);
            this.label = 2;
            if (((Flow) r8).collect(r2, this) != r0) goto L20;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            ic8.o0 r9 = u.a;
            if (r9 == null) goto L13;
            ChatImmersViewModel.processData$default(this.this$0, this.$scene, r9, false, 4, null);
            u.a = null;
            this.this$0.getDataLoading().setValue(Boxing.boxBoolean(false));
            this.this$0.setFirstLoading(false);
            this.this$0.getGetData().postValue(new com.larus.network.http.y(null, null, 15));
            goto L20
        L13:
            ChatImmersViewModel r10 = this.this$0;
            DowngradeSource r3 = this.$downgradeSource;
            this.label = 1;
            r8 = ChatImmersViewModel.access$executeApiCall(r10, r3, this);
            if (r8 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$refreshFeedData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.immerse.ChatImmersViewModel$refreshFeedData$1", f = "ChatImmersViewModel.kt", i = {}, l = {MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ String $scene;
        int label;
        final /* synthetic */ ChatImmersViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.immerse.ChatImmersViewModel$refreshFeedData$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ChatImmersViewModel a;
            public final /* synthetic */ Function0<Unit> b;
            public final /* synthetic */ String c;

            public a(ChatImmersViewModel r1, Function0<Unit> r2, String r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final Object emit(Object r6, Continuation<? super Unit> r7) {
                Result r8 = (Result) r6;
                int r0 = 0;
                if (Result.isSuccess-impl(r8.unbox-impl()) == false) goto L34;
                Object r9 = r8.unbox-impl();
                if (Result.isFailure-impl(r9) == false) goto L7;
                r9 = null;
            L7:
                if (r9 == null) goto L34;
                Object r10 = r8.unbox-impl();
                ChatImmersViewModel r11 = this.a;
                Function0<Unit> r2 = this.b;
                Throwable r3 = Result.exceptionOrNull-impl(r10);
                if (r3 != null) goto L29;
                ic8.o0 r12 = (ic8.o0) r10;
                if (r12 == null) goto L19;
                List<RecommendBot> r4 = r12.b();
                if (r4 == null) goto L15;
                int r5 = r4.size();
            L16:
                if (r5 < 1) goto L19;
                this.a.setFirstLoading(false);
                this.a.getGetData().postValue(new com.larus.network.http.y(null, null, 15));
            L23:
                if (r12 == null) goto L38;
                List<RecommendBot> r1 = r12.b();
                if (r1 == null) goto L27;
                r0 = r1.size();
            L27:
                if (r0 < 1) goto L38;
                ChatImmersViewModel.access$processData(this.a, this.c, r12, true);
            L38:
                return Unit.INSTANCE;
            L15:
                r5 = 0;
            L19:
                this.a.setRefresh(false);
                Function0<Unit> r13 = this.b;
                if (r13 == null) goto L22;
                r13.invoke();
            L22:
                MutableLiveData<com.larus.network.http.a<Object>> r14 = this.a.getGetData();
                AsyncThrowable.Companion.getClass();
                r14.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                goto L23
            L29:
                FLogger.a.e(ChatImmersViewModel.TAG, String.valueOf(r3));
                r11.setRefresh(false);
                MutableLiveData<com.larus.network.http.a<Object>> r15 = r11.getGetData();
                AsyncThrowable.Companion.getClass();
                r15.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                if (r2 == null) goto L33;
                r2.invoke();
            L33:
                return Unit.INSTANCE;
            L34:
                this.a.setRefresh(false);
                MutableLiveData<com.larus.network.http.a<Object>> r16 = this.a.getGetData();
                AsyncThrowable.Companion.getClass();
                r16.postValue(new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null));
                Function0<Unit> r17 = this.b;
                if (r17 == null) goto L38;
                r17.invoke();
                goto L38
            }
        }

        public C01551(ChatImmersViewModel r1, Function0<Unit> r2, String r3, Continuation<? super C01551> r4) {
            this.this$0 = r1;
            this.$callback = r2;
            this.$scene = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01551(this.this$0, this.$callback, this.$scene, r5);
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
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            a r2 = new a(this.this$0, this.$callback, this.$scene);
            this.label = 2;
            if (((Flow) r7).collect(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            ChatImmersViewModel r8 = this.this$0;
            DowngradeSource r3 = DowngradeSource.REFRESH;
            this.label = 1;
            r7 = ChatImmersViewModel.access$executeApiCall(r8, r3, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return getData_delegate$lambda$0();
    }

    private static final MutableLiveData getData_delegate$lambda$0() {
        return new MutableLiveData();
    }

    public final MutableLiveData<com.larus.network.http.a<Object>> getGetData() {
        return (MutableLiveData) this.getData$delegate.getValue();
    }

    public ChatImmersViewModel() {
        this.pageIndex = 1;
        this.isFirstLoading = true;
        this.hasMore = true;
        this.feedData = new MutableLiveData();
        this.dataLoading = new MutableLiveData();
        this.viewPagerState = new MutableLiveData();
        this.currentPage = new MutableLiveData();
        this.slideDistance = new MutableLiveData();
        this.listShown = new MutableLiveData();
        this.onClickBackEvent = new MutableLiveData();
        this.getData$delegate = LazyKt.lazy(new c0());
        this.allowVpOffset = new MutableLiveData(Boolean.TRUE);
    }

    public final MutableLiveData<Boolean> getAllowVpOffset() {
        return this.allowVpOffset;
    }

    public final MutableLiveData<Pair<Integer, String>> getCurrentPage() {
        return this.currentPage;
    }

    public final MutableLiveData<Boolean> getDataLoading() {
        return this.dataLoading;
    }

    public final long getEnterTime() {
        return this.enterTime;
    }

    public final MutableLiveData<List<RecommendBot>> getFeedData() {
        return this.feedData;
    }

    public final String getFirstBotId() {
        return this.firstBotId;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<Boolean> getListShown() {
        return this.listShown;
    }

    public final MutableLiveData<Boolean> getOnClickBackEvent() {
        return this.onClickBackEvent;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getSlideDistance() {
        return this.slideDistance;
    }

    public final MutableLiveData<Integer> getViewPagerState() {
        return this.viewPagerState;
    }

    public final boolean isFirstLoading() {
        return this.isFirstLoading;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public static final /* synthetic */ int access$getPageIndex$p(ChatImmersViewModel r0) {
        return r0.pageIndex;
    }

    public final RecommendBot getCurrentRecommendBot(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        List r2 = (List) this.feedData.getValue();
        if (r2 == null) goto L24;
        ListIterator r3 = r2.listIterator(r2.size());
    L15:
        if (r3.hasPrevious() == false) goto L20;
        Object r4 = r3.previous();
        if (Intrinsics.areEqual(((RecommendBot) r4).o(), r5) == false) goto L15;
        r1 = r4;
    L20:
        return (RecommendBot) r1;
    L24:
        return null;
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void setAllowVpOffset(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.allowVpOffset = r2;
    }

    public final void setEnterTime(long r1) {
        this.enterTime = r1;
    }

    public final void setFirstBotId(String r1) {
        this.firstBotId = r1;
    }

    public final void setFirstLoading(boolean r1) {
        this.isFirstLoading = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setRefresh(boolean r1) {
        this.isRefresh = r1;
    }

    private final Object executeApiCall(DowngradeSource r2, Continuation<? super Flow<Result<ic8.o0>>> r3) {
        return new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new kotlinx.coroutines.flow.c1(new AnonymousClass2(this, r2, null)), new AnonymousClass3(null));
    }

    public final void loadFeedData(String r10, DowngradeSource r11) {
        FLogger.a.d(TAG, "loadFeedData, scene = " + r10);
        this.dataLoading.setValue(Boolean.TRUE);
        getGetData().postValue(new com.larus.network.http.w(null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r11, r10, null), 3, null);
    }

    public final void refreshFeedData(String r10, Function0<Unit> r11) {
        if (this.isRefresh == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.dataLoading.getValue(), Boolean.TRUE) == true) goto L10;
        getGetData().postValue(new com.larus.network.http.w(null));
        this.isRefresh = true;
        this.pageIndex = 1;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01551(this, r11, r10, null), 3, null);
        return;
    }

    public static final /* synthetic */ Object access$executeApiCall(ChatImmersViewModel r0, DowngradeSource r1, Continuation r2) {
        return r0.executeApiCall(r1, r2);
    }

    private final void processData(String r6, ic8.o0 r7, boolean r8) {
        r7.i(r6);
        this.hasMore = r7.c();
        List<RecommendBot> r0 = r7.b();
        if (r0 == null) goto L37;
        Collection r1 = (List) this.feedData.getValue();
        if (r1 != null) goto L7;
        r1 = new ArrayList();
    L7:
        if (r8 == false) goto L20;
        ArrayList r9 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        i0 r4 = i0.a;
        if (i0.d((RecommendBot) r3) == false) goto L10;
        r9.add(r3);
        goto L10
    L14:
        HashSet r5 = new HashSet();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L32;
        Object r12 = r11.next();
        if (r5.add(((RecommendBot) r12).o()) == false) goto L16;
        r10.add(r12);
    L32:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("processData, scene = ");
        r14.append(r6);
        r14.append(", size = ");
        List<RecommendBot> r15 = r7.b();
        if (r15 == null) goto L35;
        Integer r16 = Integer.valueOf(r15.size());
    L36:
        r14.append(r16);
        r14.append(", newListSize = ");
        r14.append(r10.size());
        r13.d(TAG, r14.toString());
        this.feedData.postValue(r10);
        goto L37
    L35:
        r16 = null;
        goto L36
    L20:
        Collection r17 = r1;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r0.iterator();
    L22:
        if (r19.hasNext() == false) goto L26;
        Object r20 = r19.next();
        i0 r21 = i0.a;
        if (i0.d((RecommendBot) r20) == false) goto L22;
        r18.add(r20);
        goto L22
    L26:
        List r22 = CollectionsKt.plus(r17, r18);
        HashSet r23 = new HashSet();
        r10 = new ArrayList();
        Iterator r24 = r22.iterator();
    L28:
        if (r24.hasNext() == false) goto L32;
        Object r25 = r24.next();
        if (r23.add(((RecommendBot) r25).o()) == false) goto L28;
        r10.add(r25);
    L37:
        this.pageIndex++;
    }

    public static final /* synthetic */ void access$processData(ChatImmersViewModel r0, String r1, ic8.o0 r2, boolean r3) {
        r0.processData(r1, r2, r3);
    }

    public static /* synthetic */ void loadFeedData$default(ChatImmersViewModel r0, String r1, DowngradeSource r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.loadFeedData(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshFeedData$default(ChatImmersViewModel r0, String r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.refreshFeedData(r1, r2);
    }

    public static /* synthetic */ void processData$default(ChatImmersViewModel r0, String r1, ic8.o0 r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.processData(r1, r2, r3);
    }
}
