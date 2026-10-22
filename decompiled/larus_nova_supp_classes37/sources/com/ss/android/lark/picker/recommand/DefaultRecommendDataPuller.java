package com.ss.android.lark.picker.recommand;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.UnKnownError;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/recommand/DefaultRecommendDataPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "<init>", "()V", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getConfig", "()Lcom/ss/android/lark/picker/config/SearcherConfig;", "setConfig", "(Lcom/ss/android/lark/picker/config/SearcherConfig;)V", "search", "Lcom/ss/android/lark/picker/Searcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onLoadMore", "canLoadMore", "", "needHeader", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DefaultRecommendDataPuller implements a {
    private SearcherConfig config;
    private final transient CoroutineScope scope;
    private final transient Searcher search;

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$loadData$1", f = "DefaultRecommendDataPuller.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_JUMP_TAB_UNFOLD}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ DefaultRecommendDataPuller this$0;

        public AnonymousClass1(DefaultRecommendDataPuller r1, IGetDataCallback<List<SearchBaseInfo>> r2, Continuation<? super AnonymousClass1> r3) {
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

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L7 ErrorResult -> L9
        L17:
            this.$callback.onSuccess(((SearchResponse) r13).getInfoList());     // Catch: Throwable -> L7 ErrorResult -> L9
        L25:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r13);
            Searcher r3 = DefaultRecommendDataPuller.access$getSearch$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
            String r4 = qqb.a.c();     // Catch: Throwable -> L7 ErrorResult -> L9
            SearcherConfig r6 = this.this$0.getConfig();     // Catch: Throwable -> L7 ErrorResult -> L9
            this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
            r13 = Searcher.search$default(r3, r4, "", r6, false, false, this, 24, null);     // Catch: Throwable -> L7 ErrorResult -> L9
            if (r13 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            this.$callback.onError(e);
        L7:
            th = move-exception;
            IGetDataCallback<List<SearchBaseInfo>> r2 = this.$callback;
            String r14 = th.getMessage();
            if (r14 != null) goto L22;
            r14 = "";
        L22:
            r2.onError(new UnKnownError(r14));
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$onLoadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$onLoadMore$1", f = "DefaultRecommendDataPuller.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_LOADING_FOOTER}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ DefaultRecommendDataPuller this$0;

        public C03741(DefaultRecommendDataPuller r1, IGetDataCallback<List<SearchBaseInfo>> r2, Continuation<? super C03741> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03741(this.this$0, this.$callback, r4);
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
            Searcher r5 = DefaultRecommendDataPuller.access$getSearch$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
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

    public boolean canLoadMore() {
        return true;
    }

    public boolean needHeader() {
        return false;
    }

    public DefaultRecommendDataPuller() {
        PickerTracker r1 = null;
        this.search = new Searcher(r1, 1, r1);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final SearcherConfig getConfig() {
        return this.config;
    }

    public static final /* synthetic */ Searcher access$getSearch$p(DefaultRecommendDataPuller r0) {
        return r0.search;
    }

    public void loadData(IGetDataCallback<List<SearchBaseInfo>> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(this.scope, null, null, new C03741(this, r8, null), 3, null);
    }

    public final void setConfig(SearcherConfig r1) {
        this.config = r1;
    }
}
