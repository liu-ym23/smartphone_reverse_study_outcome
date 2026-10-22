package com.larus.search.impl.combine.recommend;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bot.api.IUgcBotRepoService;
import com.larus.platform.model.RecommendFrom;
import com.larus.search.impl.combine.c0;
import com.tencent.open.log.TraceLevel;
import ic8.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.i3;
import ws9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010\u001a\u001a\u00020\u0018J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u0002R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/search/impl/combine/recommend/SearchRecommendBotModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "recommendBotDataLv", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/search/impl/combine/CombineSearchResult;", "getRecommendBotDataLv", "()Landroidx/lifecycle/MutableLiveData;", "recommendBotList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "Lkotlin/collections/ArrayList;", "hasMore", "", "currentPageIndex", "", "loadingMore", "trackNode", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "loadFirstPageData", "", "loadFirstPageFromNet", "loadMore", "loadDataFromNet", "pageIndex", "generateSearchResult", "isFirstPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SearchRecommendBotModel extends AndroidViewModel {
    private int currentPageIndex;
    private boolean hasMore;
    private boolean loadingMore;
    private final MutableLiveData<List<c0>> recommendBotDataLv;
    private final ArrayList<RecommendBot> recommendBotList;
    private com.larus.trace.tracknode.a trackNode;

    /* JADX INFO: renamed from: com.larus.search.impl.combine.recommend.SearchRecommendBotModel$loadDataFromNet$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.recommend.SearchRecommendBotModel$loadDataFromNet$1", f = "SearchRecommendBotModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        int label;
        final /* synthetic */ SearchRecommendBotModel this$0;

        public AnonymousClass1(int r1, SearchRecommendBotModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$pageIndex = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$pageIndex, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r28) {
            Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r28);
            Object r1 = r28;
        L11:
            o0 r2 = (o0) r1;
            SearchRecommendBotModel.access$setLoadingMore$p(this.this$0, false);
            if (r2 == null) goto L24;
            List r3 = r2.b();
            if (r3 == null) goto L19;
            Iterator r4 = r3.iterator();
        L17:
            if (r4.hasNext() == false) goto L19;
            ((RecommendBot) r4.next()).a = new RecommendFrom("chat_list_discover_search_rcmd", r2.d(), "chat_list_discover_search_rcmd");
        L19:
            ArrayList r5 = SearchRecommendBotModel.access$getRecommendBotList$p(this.this$0);
            List r6 = r2.b();
            if (r6 != null) goto L22;
            r6 = CollectionsKt.emptyList();
        L22:
            r5.addAll(r6);
            SearchRecommendBotModel.access$setHasMore$p(this.this$0, r2.c());
            SearchRecommendBotModel.access$generateSearchResult(this.this$0, true);
        L26:
            if (r2 == null) goto L28;
            String r7 = "1";
        L29:
            String r24 = r7;
            if (r2 == null) goto L32;
            String r8 = r2.d();
        L33:
            i3.c(null, "auto", null, null, null, null, null, null, "chat_list_discover_search_rcmd", r8, r24, SearchRecommendBotModel.access$getTrackNode$p(this.this$0), 4605);
            return Unit.INSTANCE;
        L32:
            r8 = null;
            goto L33
        L28:
            r7 = "0";
            goto L29
        L24:
            if (SearchRecommendBotModel.access$getCurrentPageIndex$p(this.this$0) <= 1) goto L26;
            SearchRecommendBotModel.access$setCurrentPageIndex$p(this.this$0, SearchRecommendBotModel.access$getCurrentPageIndex$p(this.this$0) - 1);
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r28);
            IBotRepoService r9 = RepoDispatcherDelegate.b.b();
            int r10 = this.$pageIndex;
            DowngradeSource r11 = DowngradeSource.ENTER_PAGE;
            this.label = 1;
            r1 = IBotRepoService.b.b(r9, 2, r10, 20, null, false, null, null, null, null, r11, this, 504);
            if (r1 != r14) goto L11;
            return r14;
        }
    }

    /* JADX INFO: renamed from: com.larus.search.impl.combine.recommend.SearchRecommendBotModel$loadFirstPageData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.recommend.SearchRecommendBotModel$loadFirstPageData$1", f = "SearchRecommendBotModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SearchRecommendBotModel this$0;

        public C01131(SearchRecommendBotModel r1, Continuation<? super C01131> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01131(this.this$0, r3);
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
            o0 r6 = (o0) r5;
            if (r6 == null) goto L14;
            List r2 = r6.b();
        L15:
            if (r2 == null) goto L30;
            List r3 = r6.b();
            if (r3 == null) goto L26;
            Iterator r4 = r3.iterator();
        L20:
            if (r4.hasNext() == false) goto L26;
            RecommendFrom r7 = ((RecommendBot) r4.next()).a;
            if (r7 == null) goto L24;
            r7.c = "chat_list_discover_search_rcmd";
        L24:
            if (r7 == null) goto L20;
            r7.a = "chat_list_discover_search_rcmd";
        L26:
            ArrayList r8 = SearchRecommendBotModel.access$getRecommendBotList$p(this.this$0);
            List r9 = r6.b();
            if (r9 != null) goto L29;
            r9 = CollectionsKt.emptyList();
        L29:
            r8.addAll(r9);
            SearchRecommendBotModel.access$setHasMore$p(this.this$0, r6.c());
            SearchRecommendBotModel.access$generateSearchResult(this.this$0, true);
        L32:
            return Unit.INSTANCE;
        L30:
            SearchRecommendBotModel.access$loadFirstPageFromNet(this.this$0);
            goto L32
        L14:
            r2 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            int r10 = com.larus.search.impl.common.a.a;
            this.label = 1;
            r5 = IUgcBotRepoService.Impl.b.a(this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    private final void loadFirstPageFromNet() {
        loadDataFromNet(1);
    }

    public final void loadMore() {
        int r0 = this.currentPageIndex;
        this.currentPageIndex = r0 + 1;
        loadDataFromNet(r0);
    }

    public final MutableLiveData<List<c0>> getRecommendBotDataLv() {
        return this.recommendBotDataLv;
    }

    public SearchRecommendBotModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.recommendBotDataLv = new MutableLiveData();
        this.recommendBotList = new ArrayList();
        this.hasMore = true;
        this.currentPageIndex = 1;
    }

    public static final /* synthetic */ int access$getCurrentPageIndex$p(SearchRecommendBotModel r0) {
        return r0.currentPageIndex;
    }

    public static final /* synthetic */ ArrayList access$getRecommendBotList$p(SearchRecommendBotModel r0) {
        return r0.recommendBotList;
    }

    public static final /* synthetic */ com.larus.trace.tracknode.a access$getTrackNode$p(SearchRecommendBotModel r0) {
        return r0.trackNode;
    }

    public static final /* synthetic */ void access$loadFirstPageFromNet(SearchRecommendBotModel r0) {
        r0.loadFirstPageFromNet();
    }

    private final void generateSearchResult(boolean r24) {
        ArrayList r1 = new ArrayList();
        ArrayList<RecommendBot> r2 = this.recommendBotList;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        RecommendBot r5 = (RecommendBot) r4.next();
        String r6 = r5.o();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r3.add(new c0(r6, 16, true, null, null, null, null, null, null, 0, null, null, null, new b(r5, 6), 65528));
        goto L4
    L9:
        boolean r7 = !r3.isEmpty();
        r1.addAll(r3);
        if (r7 == true) goto L12;
    L14:
        this.recommendBotDataLv.postValue(r1);
        return;
    L12:
        if (this.hasMore == false) goto L14;
        r1.add(new c0("32", 32, true, null, null, null, null, null, null, 0, null, null, null, null, 131064));
        goto L14
    }

    private final void loadDataFromNet(int r8) {
        if (this.loadingMore == false) goto L5;
        return;
    L5:
        this.loadingMore = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r8, this, null), 3, null);
    }

    public final void loadFirstPageData(com.larus.trace.tracknode.a r8) {
        Intrinsics.checkNotNullParameter(r8, "trackNode");
        this.trackNode = r8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01131(this, null), 3, null);
    }

    public static final /* synthetic */ void access$generateSearchResult(SearchRecommendBotModel r0, boolean r1) {
        r0.generateSearchResult(r1);
    }

    public static final /* synthetic */ void access$setCurrentPageIndex$p(SearchRecommendBotModel r0, int r1) {
        r0.currentPageIndex = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(SearchRecommendBotModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLoadingMore$p(SearchRecommendBotModel r0, boolean r1) {
        r0.loadingMore = r1;
    }
}
