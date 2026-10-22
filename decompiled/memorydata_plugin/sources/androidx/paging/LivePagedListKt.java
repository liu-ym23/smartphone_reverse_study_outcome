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
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a}\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0014\u001am\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00152\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001am\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00152\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\n\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"toLiveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Value", "Key", "", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "config", "Landroidx/paging/PagedList$Config;", "initialLoadKey", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlin/jvm/functions/Function0;Landroidx/paging/PagedList$Config;Ljava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)Landroidx/lifecycle/LiveData;", "pageSize", "", "(Lkotlin/jvm/functions/Function0;ILjava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)Landroidx/lifecycle/LiveData;", "Landroidx/paging/DataSource$Factory;", "fetchExecutor", "Ljava/util/concurrent/Executor;", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;Ljava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "(Landroidx/paging/DataSource$Factory;ILjava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LivePagedListKt {
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n            PagingConfig(pageSize),\n            initialLoadKey,\n            this.asPagingSourceFactory(fetchExecutor.asCoroutineDispatcher())\n        ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData", "kotlinx.coroutines.asCoroutineDispatcher"}))
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> r8, int r9, Key r10, PagedList.BoundaryCallback<Value> r11, Executor r12) {
        Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r12, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r13, "fetchExecutor");
        return new LivePagedListBuilder(r8, PagedListConfigKt.Config$default(r9, 0, false, 0, 0, 30, null)).setInitialLoadKey(r10).setBoundaryCallback(r11).setFetchExecutor(r13).build();
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n            PagingConfig(\n                config.pageSize,\n                config.prefetchDistance,\n                config.enablePlaceholders,\n                config.initialLoadSizeHint,\n                config.maxSize\n            ),\n            initialLoadKey,\n            this.asPagingSourceFactory(fetchExecutor.asCoroutineDispatcher())\n        ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData", "kotlinx.coroutines.asCoroutineDispatcher"}))
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> r2, PagedList.Config r3, Key r4, PagedList.BoundaryCallback<Value> r5, Executor r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r7, "fetchExecutor");
        return new LivePagedListBuilder(r2, r3).setInitialLoadKey(r4).setBoundaryCallback(r5).setFetchExecutor(r7).build();
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n            PagingConfig(pageSize),\n            initialLoadKey,\n            this\n        ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData"}))
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(Function0<? extends PagingSource<Key, Value>> r10, int r11, Key r12, PagedList.BoundaryCallback<Value> r13, al r14, ah r15) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r14, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r3, "coroutineScope");
        Intrinsics.checkNotNullParameter(r15, "fetchDispatcher");
        PagedList.Config r5 = new PagedList.Config.Builder().setPageSize(r11).build();
        Executor r16 = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r16, "getMainThreadExecutor()");
        return (LiveData) ZeusTransformUtils.preCheckCast(new LivePagedList(r3, r12, r5, r13, r7, bo.a(r16), r15), LiveData.class, "com.obric.memorydata.plugin");
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n            PagingConfig(\n                config.pageSize,\n                config.prefetchDistance,\n                config.enablePlaceholders,\n                config.initialLoadSizeHint,\n                config.maxSize\n            ),\n            initialLoadKey,\n            this\n        ).liveData", imports = {"androidx.paging.Pager", "androidx.paging.PagingConfig", "androidx.paging.liveData"}))
    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(Function0<? extends PagingSource<Key, Value>> r10, PagedList.Config r11, Key r12, PagedList.BoundaryCallback<Value> r13, al r14, ah r15) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r14, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r3, "coroutineScope");
        Intrinsics.checkNotNullParameter(r15, "fetchDispatcher");
        Executor r16 = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r16, "getMainThreadExecutor()");
        return (LiveData) ZeusTransformUtils.preCheckCast(new LivePagedList(r3, r12, r11, r13, r7, bo.a(r16), r15), LiveData.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory r1, int r2, Object r3, PagedList.BoundaryCallback r4, Executor r5, int r6, Object r7) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r8 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r8, "getIOThreadExecutor()");
    L12:
        return toLiveData(r1, r2, r3, r4, r8);
    }

    public static /* synthetic */ LiveData toLiveData$default(DataSource.Factory r1, PagedList.Config r2, Object r3, PagedList.BoundaryCallback r4, Executor r5, int r6, Object r7) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r8 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r8, "getIOThreadExecutor()");
    L12:
        return toLiveData(r1, r2, r3, r4, r8);
    }

    public static /* synthetic */ LiveData toLiveData$default(Function0 r3, int r4, Object r5, PagedList.BoundaryCallback r6, al r7, ah r8, int r9, Object r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        al r12 = (al) ZeusTransformUtils.wrapperContextForParams(r7, al.class, "com.obric.memorydata.plugin");
        PagedList.BoundaryCallback r1 = null;
        if ((r9 & 2) == 0) goto L5;
        Object r13 = null;
    L7:
        if ((r9 & 4) != 0) goto L11;
        r1 = r6;
    L11:
        if ((r9 & 8) == 0) goto L13;
        al r0 = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
    L15:
        if ((r9 & 16) == 0) goto L18;
        Executor r14 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r14, "getIOThreadExecutor()");
        r8 = bo.a(r14);
    L18:
        return toLiveData(r11, r4, r13, r1, r0, r8);
    L13:
        r0 = r12;
        goto L15
    L5:
        r13 = r5;
        goto L7
    }

    public static /* synthetic */ LiveData toLiveData$default(Function0 r3, PagedList.Config r4, Object r5, PagedList.BoundaryCallback r6, al r7, ah r8, int r9, Object r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        al r12 = (al) ZeusTransformUtils.wrapperContextForParams(r7, al.class, "com.obric.memorydata.plugin");
        PagedList.BoundaryCallback r1 = null;
        if ((r9 & 2) == 0) goto L5;
        Object r13 = null;
    L7:
        if ((r9 & 4) != 0) goto L11;
        r1 = r6;
    L11:
        if ((r9 & 8) == 0) goto L13;
        al r0 = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
    L15:
        if ((r9 & 16) == 0) goto L18;
        Executor r14 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r14, "getIOThreadExecutor()");
        r8 = bo.a(r14);
    L18:
        return toLiveData(r11, r4, r13, r1, r0, r8);
    L13:
        r0 = r12;
        goto L15
    L5:
        r13 = r5;
        goto L7
    }
}
