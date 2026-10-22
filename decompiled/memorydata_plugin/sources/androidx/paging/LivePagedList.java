package androidx.paging;

import androidx.lifecycle.LiveData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00050\u0004BY\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f\u0012\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0014J$\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/paging/LivePagedList;", "Key", "", "Value", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initialKey", "config", "Landroidx/paging/PagedList$Config;", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;Landroidx/paging/PagedList$Config;Landroidx/paging/PagedList$BoundaryCallback;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "callback", "", "currentData", "currentJob", "Lkotlinx/coroutines/Job;", "refreshRetryCallback", "Ljava/lang/Runnable;", "invalidate", "force", "", "onActive", "onItemUpdate", "previous", "next", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {
    private final PagedList.BoundaryCallback<Value> boundaryCallback;
    private final Function0<Unit> callback;
    private final PagedList.Config config;
    private final al coroutineScope;
    private PagedList<Value> currentData;
    private bx currentJob;
    private final ah fetchDispatcher;
    private final ah notifyDispatcher;
    private final Function0<PagingSource<Key, Value>> pagingSourceFactory;
    private final Runnable refreshRetryCallback;

    /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", i = {0, 1, 1}, l = {82, 90}, m = "invokeSuspend", n = {"pagingSource", "pagingSource", "lastKey"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LivePagedList<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.LivePagedList$invalidate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.LivePagedList$invalidate$1$1", f = "LivePagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00341 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LivePagedList<Key, Value> this$0;

            C00341(LivePagedList<Key, Value> r3, Continuation<? super C00341> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00341(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C00341) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00341.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                LivePagedList.access$getCurrentData$p(this.this$0).setInitialLoadState(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(LivePagedList<Key, Value> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$1;
            PagingSource r3 = (PagingSource) ZeusTransformUtils.preCheckCast(this.L$0, PagingSource.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
            Object r13 = r2;
            PagingSource r6 = r3;
        L21:
            PagingSource.LoadResult r16 = (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r15, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r16, PagingSource.LoadResult.Invalid.class) == false) goto L25;
            LivePagedList.access$getCurrentData$p(this.this$0).setInitialLoadState(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(new LoadState.NotLoading(false), LoadState.class, "com.obric.memorydata.plugin"));
            r6.invalidate();
        L31:
            return Unit.INSTANCE;
        L25:
            if (ZeusTransformUtils.instanceOf(r16, PagingSource.LoadResult.Error.class) == false) goto L28;
            LivePagedList.access$getCurrentData$p(this.this$0).setInitialLoadState(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(new LoadState.Error(((PagingSource.LoadResult.Error) ZeusTransformUtils.preCheckCast(r16, PagingSource.LoadResult.Error.class, "com.obric.memorydata.plugin")).getThrowable()), LoadState.class, "com.obric.memorydata.plugin"));
            goto L31
        L28:
            if (ZeusTransformUtils.instanceOf(r16, PagingSource.LoadResult.Page.class) == false) goto L31;
            PagedList r17 = PagedList.Companion.create(r6, (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r16, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin"), LivePagedList.access$getCoroutineScope$p(this.this$0), LivePagedList.access$getNotifyDispatcher$p(this.this$0), LivePagedList.access$getFetchDispatcher$p(this.this$0), LivePagedList.access$getBoundaryCallback$p(this.this$0), LivePagedList.access$getConfig$p(this.this$0), r13);
            LivePagedList<Key, Value> r4 = this.this$0;
            LivePagedList.access$onItemUpdate(r4, LivePagedList.access$getCurrentData$p(r4), r17);
            LivePagedList.access$setCurrentData$p(this.this$0, r17);
            LivePagedList.access$postValue(this.this$0, r17);
            goto L31
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            PagingSource r5 = (PagingSource) ZeusTransformUtils.preCheckCast(this.L$0, PagingSource.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L17:
            Object r18 = LivePagedList.access$getCurrentData$p(this.this$0).getLastKey();
            PagingSource.LoadParams<Key> r7 = PagingSourceKt.toRefreshLoadParams(LivePagedList.access$getConfig$p(this.this$0), r18);
            Continuation<? super PagingSource.LoadResult<Key, Value>> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r5;
            this.L$1 = r18;
            this.label = 2;
            Object r9 = r5.load(r7, r8);
            if (r9 != r0) goto L20;
            return r0;
        L20:
            r13 = r18;
            r6 = r5;
            r15 = r9;
            goto L21
        L10:
            ResultKt.throwOnFailure(r15);
            LivePagedList.access$getCurrentData$p(this.this$0).getPagingSource().unregisterInvalidatedCallback(LivePagedList.access$getCallback$p(this.this$0));
            PagingSource r19 = (PagingSource) ZeusTransformUtils.preCheckCast(LivePagedList.access$getPagingSourceFactory$p(this.this$0).invoke(), PagingSource.class, "com.obric.memorydata.plugin");
            r19.registerInvalidatedCallback(LivePagedList.access$getCallback$p(this.this$0));
            if (ZeusTransformUtils.instanceOf(r19, LegacyPagingSource.class) == false) goto L13;
            ((LegacyPagingSource) ZeusTransformUtils.preCheckCast(r19, LegacyPagingSource.class, "com.obric.memorydata.plugin")).setPageSize(LivePagedList.access$getConfig$p(this.this$0).pageSize);
        L13:
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(LivePagedList.access$getNotifyDispatcher$p(this.this$0), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new C00341(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r19;
            this.label = 1;
            if (i.a(r10, r11, r12) != r0) goto L16;
            return r0;
        L16:
            r5 = r19;
            goto L17
        }
    }

    public LivePagedList(al r9, Key r10, PagedList.Config r11, PagedList.BoundaryCallback<Value> r12, Function0<? extends PagingSource<Key, Value>> r13, ah r14, ah r15) {
        al r16 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        Function0<PagingSource<Key, Value>> r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "coroutineScope");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r17, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(r14, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(r15, "fetchDispatcher");
        super(new InitialPagedList(r16, r14, r15, r11, r10));
        this.coroutineScope = r16;
        this.config = r11;
        this.boundaryCallback = r12;
        this.pagingSourceFactory = r17;
        this.notifyDispatcher = r14;
        this.fetchDispatcher = r15;
        this.callback = (Function0) ZeusTransformUtils.preCheckCast(new LivePagedList$callback$1(this), Function0.class, "com.obric.memorydata.plugin");
        Runnable r18 = new $$Lambda$LivePagedList$GmvDe83vyVWkg3HtqiOrVlVvCdE(this);
        this.refreshRetryCallback = r18;
        PagedList<Value> r19 = getValue();
        Intrinsics.checkNotNull(r19);
        PagedList<Value> r110 = (PagedList) ZeusTransformUtils.preCheckCast(r19, PagedList.class, "com.obric.memorydata.plugin");
        this.currentData = r110;
        r110.setRetryCallback(r18);
    }

    public static final /* synthetic */ PagedList.BoundaryCallback access$getBoundaryCallback$p(LivePagedList r0) {
        return r0.boundaryCallback;
    }

    public static final /* synthetic */ Function0 access$getCallback$p(LivePagedList r0) {
        return r0.callback;
    }

    public static final /* synthetic */ PagedList.Config access$getConfig$p(LivePagedList r0) {
        return r0.config;
    }

    public static final /* synthetic */ al access$getCoroutineScope$p(LivePagedList r0) {
        return r0.coroutineScope;
    }

    public static final /* synthetic */ PagedList access$getCurrentData$p(LivePagedList r0) {
        return r0.currentData;
    }

    public static final /* synthetic */ ah access$getFetchDispatcher$p(LivePagedList r0) {
        return r0.fetchDispatcher;
    }

    public static final /* synthetic */ ah access$getNotifyDispatcher$p(LivePagedList r0) {
        return r0.notifyDispatcher;
    }

    public static final /* synthetic */ Function0 access$getPagingSourceFactory$p(LivePagedList r0) {
        return r0.pagingSourceFactory;
    }

    public static final /* synthetic */ void access$invalidate(LivePagedList r0, boolean r1) {
        r0.invalidate(r1);
    }

    public static final /* synthetic */ void access$onItemUpdate(LivePagedList r0, PagedList r1, PagedList r2) {
        r0.onItemUpdate(r1, r2);
    }

    public static final /* synthetic */ void access$postValue(LivePagedList r0, PagedList r1) {
        r0.postValue(r1);
    }

    public static final /* synthetic */ void access$setCurrentData$p(LivePagedList r0, PagedList r1) {
        r0.currentData = r1;
    }

    private final void invalidate(boolean r9) {
        bx r0 = this.currentJob;
        if (r0 == null) goto L7;
        if (r9 == true) goto L7;
        return;
    L7:
        if (r0 == null) goto L9;
        bx.a.a(r0, null, 1, null);
    L9:
        this.currentJob = i.a(this.coroutineScope, (CoroutineContext) ZeusTransformUtils.preCheckCast(this.fetchDispatcher, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public static /* synthetic */ void lambda$GmvDe83vyVWkg3HtqiOrVlVvCdE(LivePagedList r0) {
        refreshRetryCallback$lambda$0(r0);
    }

    private final void onItemUpdate(PagedList<Value> r2, PagedList<Value> r3) {
        r2.setRetryCallback(null);
        r3.setRetryCallback(this.refreshRetryCallback);
    }

    private static final void refreshRetryCallback$lambda$0(LivePagedList r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.invalidate(true);
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        invalidate(false);
    }
}
