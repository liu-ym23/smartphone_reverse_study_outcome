package com.ss.android.lark.picker.recommand;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.usearch.ClientType;
import com.ss.android.lark.pb.usearch.DoubaoSearchSceneMeta;
import com.ss.android.lark.pb.usearch.PullDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.UnKnownError;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.picker.plugin.SearchHistoryPlugin;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchCustomInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/recommand/HistoryRecommendDataPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "<init>", "()V", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getConfig", "()Lcom/ss/android/lark/picker/config/SearcherConfig;", "setConfig", "(Lcom/ss/android/lark/picker/config/SearcherConfig;)V", "search", "Lcom/ss/android/lark/picker/Searcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pullSearchQueryHistory", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "onLoadMore", "canLoadMore", "", "needHeader", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class HistoryRecommendDataPuller implements a {
    public static final Companion Companion = null;
    public static final String TAG = "HistoryRecommendDataPuller";
    private SearcherConfig config;
    private final transient CoroutineScope scope;
    private final transient Searcher search;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/recommand/HistoryRecommendDataPuller$Companion;", "", "<init>", "()V", "TAG", "", "toSearchBaseInfo", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mdigest", "mquery", "toHistoryBean", "Lcom/ss/android/lark/picker/plugin/SearchHistoryPlugin$SearchHistoryBean;", "info", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SearchHistoryPlugin.SearchHistoryBean toHistoryBean(SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "info");
            String r1 = r3.getTitle();
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            return new SearchHistoryPlugin.SearchHistoryBean(r1, r3.getId());
        }

        public final SearchBaseInfo toSearchBaseInfo(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "mdigest");
            Intrinsics.checkNotNullParameter(r3, "mquery");
            SearchCustomInfo r0 = new SearchCustomInfo();
            r0.setId(r2);
            r0.setType(6);
            r0.setTitle(r3);
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.HistoryRecommendDataPuller$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.HistoryRecommendDataPuller$loadData$1", f = "HistoryRecommendDataPuller.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ HistoryRecommendDataPuller this$0;

        public AnonymousClass1(HistoryRecommendDataPuller r1, IGetDataCallback<List<SearchBaseInfo>> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$callback, r4);
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
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7 ErrorResult -> L9
        L17:
            IGetDataCallback<List<SearchBaseInfo>> r2 = this.$callback;     // Catch: Throwable -> L7 ErrorResult -> L9
            r2.onSuccess((List) r4);     // Catch: Throwable -> L7 ErrorResult -> L9
        L25:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r4);
            HistoryRecommendDataPuller r5 = this.this$0;     // Catch: Throwable -> L7 ErrorResult -> L9
            this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
            r4 = HistoryRecommendDataPuller.access$pullSearchQueryHistory(r5, this);     // Catch: Throwable -> L7 ErrorResult -> L9
            if (r4 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            this.$callback.onError(e);
        L7:
            th = move-exception;
            IGetDataCallback<List<SearchBaseInfo>> r3 = this.$callback;
            String r6 = th.getMessage();
            if (r6 != null) goto L22;
            r6 = "";
        L22:
            r3.onError(new UnKnownError(r6));
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.HistoryRecommendDataPuller$onLoadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.HistoryRecommendDataPuller$onLoadMore$1", f = "HistoryRecommendDataPuller.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ HistoryRecommendDataPuller this$0;

        public C03751(HistoryRecommendDataPuller r1, IGetDataCallback<List<SearchBaseInfo>> r2, Continuation<? super C03751> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03751(this.this$0, this.$callback, r4);
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
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7 ErrorResult -> L9
        L17:
            this.$callback.onSuccess(((SearchResponse) r4).getInfoList());     // Catch: Throwable -> L7 ErrorResult -> L9
        L25:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r4);
            Searcher r5 = HistoryRecommendDataPuller.access$getSearch$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
            String r2 = qqb.a.c();     // Catch: Throwable -> L7 ErrorResult -> L9
            this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
            r4 = r5.loadMore(r2, this);     // Catch: Throwable -> L7 ErrorResult -> L9
            if (r4 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            this.$callback.onError(e);
        L7:
            th = move-exception;
            IGetDataCallback<List<SearchBaseInfo>> r3 = this.$callback;
            String r6 = th.getMessage();
            if (r6 != null) goto L22;
            r6 = "";
        L22:
            r3.onError(new UnKnownError(r6));
            goto L25
        }
    }

    static {
        Companion = new Companion(null);
    }

    public boolean canLoadMore() {
        return true;
    }

    public boolean needHeader() {
        return false;
    }

    public HistoryRecommendDataPuller() {
        PickerTracker r1 = null;
        this.search = new Searcher(r1, 1, r1);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final SearcherConfig getConfig() {
        return this.config;
    }

    public static final /* synthetic */ Searcher access$getSearch$p(HistoryRecommendDataPuller r0) {
        return r0.search;
    }

    private final Object pullSearchQueryHistory(Continuation<? super List<? extends SearchBaseInfo>> r7) {
        final j r0 = new j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        final String r1 = qqb.a.c();
        StringBuilder r2 = new StringBuilder("pullSearchQueryHistory start, contextId=");
        r2.append(r1);
        r2.append(", scene=");
        DoubaoSearchSceneMeta.DoubaoSearchScene r3 = DoubaoSearchSceneMeta.DoubaoSearchScene.PICKER;
        r2.append(r3);
        r2.append(", pickerScene=DOUBAO_SEARCH_DOCS, clientType=");
        ClientType r4 = ClientType.ANDROID;
        r2.append(r4);
        Log.i(TAG, r2.toString());
        PullDoubaoSearchQueryHistoryRequest.Builder r5 = new PullDoubaoSearchQueryHistoryRequest.Builder();
        r5.mscene_meta = new DoubaoSearchSceneMeta.Builder().scene(r3).picker_scene("DOUBAO_SEARCH_DOCS").m2636build();
        r5.client_type(r4);
        SdkSender.sendPassThroughRequest(Command.PULL_DOUBAO_SEARCH_QUERY_HISTORY, r5, new HistoryRecommendDataPuller$pullSearchQueryHistory$2$1(r1, r0), HistoryRecommendDataPuller$pullSearchQueryHistory$2$2.INSTANCE);
        Object r6 = r0.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r6;
    }

    public void loadData(IGetDataCallback<List<SearchBaseInfo>> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(this.scope, null, null, new C03751(this, r8, null), 3, null);
    }

    public final void setConfig(SearcherConfig r1) {
        this.config = r1;
    }

    public static final /* synthetic */ Object access$pullSearchQueryHistory(HistoryRecommendDataPuller r0, Continuation r1) {
        return r0.pullSearchQueryHistory(r1);
    }
}
