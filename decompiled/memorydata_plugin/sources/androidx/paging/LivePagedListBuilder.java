package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bp;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B#\b\u0017\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\b\u0017\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB)\b\u0017\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fB)\b\u0017\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001f0\u001eJ\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012J\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010#\u001a\u00020$J!\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010'R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\"\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/paging/LivePagedListBuilder;", "Key", "", "Value", "dataSourceFactory", "Landroidx/paging/DataSource$Factory;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;)V", "pageSize", "", "(Landroidx/paging/DataSource$Factory;I)V", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/paging/PagedList$Config;)V", "(Lkotlin/jvm/functions/Function0;I)V", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "getBoundaryCallback$annotations", "()V", "getConfig$annotations", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initialLoadKey", "Ljava/lang/Object;", "build", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "setBoundaryCallback", "setCoroutineScope", "setFetchExecutor", "fetchExecutor", "Ljava/util/concurrent/Executor;", "setInitialLoadKey", "key", "(Ljava/lang/Object;)Landroidx/paging/LivePagedListBuilder;", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback<Value> boundaryCallback;
    private final PagedList.Config config;
    private al coroutineScope;
    private final DataSource.Factory<Key, Value> dataSourceFactory;
    private ah fetchDispatcher;
    private Key initialLoadKey;
    private final Function0<PagingSource<Key, Value>> pagingSourceFactory;

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n                PagingConfig(pageSize),\n                initialLoadKey,\n                dataSourceFactory.asPagingSourceFactory(Dispatchers.IO)\n            ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData", "kotlinx.coroutines.Dispatchers"}))
    public LivePagedListBuilder(DataSource.Factory<Key, Value> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dataSourceFactory");
        this(r2, new PagedList.Config.Builder().setPageSize(r3).build());
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n                PagingConfig(\n                    config.pageSize,\n                    config.prefetchDistance,\n                    config.enablePlaceholders,\n                    config.initialLoadSizeHint,\n                    config.maxSize\n                ),\n                initialLoadKey,\n                dataSourceFactory.asPagingSourceFactory(Dispatchers.IO)\n            ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData", "kotlinx.coroutines.Dispatchers"}))
    public LivePagedListBuilder(DataSource.Factory<Key, Value> r4, PagedList.Config r5) {
        Intrinsics.checkNotNullParameter(r4, "dataSourceFactory");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.coroutineScope = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
        Executor r0 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "getIOThreadExecutor()");
        this.fetchDispatcher = bo.a(r0);
        this.pagingSourceFactory = null;
        this.dataSourceFactory = r4;
        this.config = r5;
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n                PagingConfig(pageSize),\n                initialLoadKey,\n                this\n            ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData"}))
    public LivePagedListBuilder(Function0<? extends PagingSource<Key, Value>> r3, int r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pagingSourceFactory");
        this(r5, new PagedList.Config.Builder().setPageSize(r4).build());
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n                PagingConfig(\n                    config.pageSize,\n                    config.prefetchDistance,\n                    config.enablePlaceholders,\n                    config.initialLoadSizeHint,\n                    config.maxSize\n                ),\n                initialLoadKey,\n                this\n            ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData"}))
    public LivePagedListBuilder(Function0<? extends PagingSource<Key, Value>> r4, PagedList.Config r5) {
        Function0<PagingSource<Key, Value>> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.coroutineScope = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
        Executor r0 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "getIOThreadExecutor()");
        this.fetchDispatcher = bo.a(r0);
        this.pagingSourceFactory = r6;
        this.dataSourceFactory = null;
        this.config = r5;
    }

    private static /* synthetic */ void getBoundaryCallback$annotations() {
    }

    private static /* synthetic */ void getConfig$annotations() {
    }

    private static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public final LiveData<PagedList<Value>> build() {
        Function0<PagingSource<Key, Value>> r0 = this.pagingSourceFactory;
        if (r0 != null) goto L8;
        DataSource.Factory<Key, Value> r1 = this.dataSourceFactory;
        if (r1 == null) goto L7;
        r0 = r1.asPagingSourceFactory(this.fetchDispatcher);
        goto L8
    L7:
        r0 = null;
    L8:
        Function0<PagingSource<Key, Value>> r6 = r0;
        if (r6 == null) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        al r3 = this.coroutineScope;
        Key r4 = this.initialLoadKey;
        PagedList.Config r5 = this.config;
        PagedList.BoundaryCallback<Value> r7 = this.boundaryCallback;
        Executor r8 = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r8, "getMainThreadExecutor()");
        return (LiveData) ZeusTransformUtils.preCheckCast(new LivePagedList(r3, r4, r5, r7, r6, bo.a(r8), this.fetchDispatcher), LiveData.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("LivePagedList cannot be built without a PagingSourceFactory or DataSource.Factory".toString());
    L11:
        r2 = false;
        goto L12
    }

    public final LivePagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> r4) {
        ((LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin")).boundaryCallback = r4;
        return (LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin");
    }

    public final LivePagedListBuilder<Key, Value> setCoroutineScope(al r4) {
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "coroutineScope");
        ((LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin")).coroutineScope = r5;
        return (LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin");
    }

    public final LivePagedListBuilder<Key, Value> setFetchExecutor(Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "fetchExecutor");
        LivePagedListBuilder r1 = (LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin");
        r1.fetchDispatcher = bo.a(r5);
        return (LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin");
    }

    public final LivePagedListBuilder<Key, Value> setInitialLoadKey(Key r4) {
        ((LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin")).initialLoadKey = r4;
        return (LivePagedListBuilder) ZeusTransformUtils.preCheckCast(this, LivePagedListBuilder.class, "com.obric.memorydata.plugin");
    }
}
