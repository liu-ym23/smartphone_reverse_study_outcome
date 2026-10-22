package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\b'\u0018\u0000 d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0006abcdefB?\b\u0000\u0012\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0012J \u0010?\u001a\u00020(2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010B2\u0006\u0010@\u001a\u00020\u0012H\u0007J \u0010C\u001a\u00020(2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%J\b\u0010E\u001a\u00020(H&J\"\u0010F\u001a\u00020(2\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%H'J\u001d\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020'H\u0000¢\u0006\u0002\bJJ\u0018\u0010K\u001a\u0004\u0018\u00018\u00002\u0006\u0010L\u001a\u00020*H\u0096\u0002¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0007J\b\u0010P\u001a\u00020*H\u0007J\u000e\u0010Q\u001a\u00020(2\u0006\u0010L\u001a\u00020*J\u0010\u0010R\u001a\u00020(2\u0006\u0010L\u001a\u00020*H'J\u0018\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0007J\u001d\u0010V\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0000¢\u0006\u0002\bWJ\u0018\u0010X\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0007J\u000e\u0010Y\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0012J \u0010Z\u001a\u00020(2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%J\b\u0010[\u001a\u00020(H\u0016J\u0018\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020'H\u0017J\u0012\u0010_\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0007J\f\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000BR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0014\u0010 \u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u0004\u0018\u00010\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R,\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b2\u0010,R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0014\u0010;\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010,R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006g"}, d2 = {"Landroidx/paging/PagedList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/AbstractList;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", Scraps.STORAGE, "Landroidx/paging/PagedStorage;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "callbacks", "", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "getConfig", "()Landroidx/paging/PagedList$Config;", "getCoroutineScope$paging_common", "()Lkotlinx/coroutines/CoroutineScope;", "dataSource", "Landroidx/paging/DataSource;", "getDataSource$annotations", "()V", "getDataSource", "()Landroidx/paging/DataSource;", "isDetached", "", "()Z", "isImmutable", "lastKey", "getLastKey", "()Ljava/lang/Object;", "loadStateListeners", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "", "loadedCount", "", "getLoadedCount", "()I", "getNotifyDispatcher$paging_common", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getPagingSource", "()Landroidx/paging/PagingSource;", "positionOffset", "getPositionOffset", "refreshRetryCallback", "Ljava/lang/Runnable;", "getRefreshRetryCallback$paging_common", "()Ljava/lang/Runnable;", "setRefreshRetryCallback$paging_common", "(Ljava/lang/Runnable;)V", "requiredRemainder", "getRequiredRemainder$paging_common", "size", "getSize", "getStorage$paging_common", "()Landroidx/paging/PagedStorage;", "addWeakCallback", "callback", "previousSnapshot", "", "addWeakLoadStateListener", "listener", "detach", "dispatchCurrentLoadState", "dispatchStateChangeAsync", "type", "state", "dispatchStateChangeAsync$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getNullPaddedList", "Landroidx/paging/NullPaddedList;", "lastLoad", "loadAround", "loadAroundInternal", "notifyChanged", "position", CommonConsts.COUNT_TYPE, "notifyInserted", "notifyInserted$paging_common", "notifyRemoved", "removeWeakCallback", "removeWeakLoadStateListener", "retry", "setInitialLoadState", "loadType", "loadState", "setRetryCallback", "snapshot", "BoundaryCallback", "Builder", "Callback", "Companion", "Config", "LoadStateManager", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PagedList<T> extends AbstractList<T> {
    public static final Companion Companion = null;
    private final List<WeakReference<Callback>> callbacks;
    private final Config config;
    private final al coroutineScope;
    private final List<WeakReference<Function2<LoadType, LoadState, Unit>>> loadStateListeners;
    private final ah notifyDispatcher;
    private final PagingSource<?, T> pagingSource;
    private Runnable refreshRetryCallback;
    private final int requiredRemainder;
    private final PagedStorage<T> storage;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/paging/PagedList$BoundaryCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "onItemAtEndLoaded", "", "itemAtEnd", "(Ljava/lang/Object;)V", "onItemAtFrontLoaded", "itemAtFront", "onZeroItemsLoaded", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class BoundaryCallback<T> {
        public BoundaryCallback() {
        }

        public void onItemAtEndLoaded(T r1) {
            Intrinsics.checkNotNullParameter(r1, "itemAtEnd");
        }

        public void onItemAtFrontLoaded(T r1) {
            Intrinsics.checkNotNullParameter(r1, "itemAtFront");
        }

        public void onZeroItemsLoaded() {
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u0002*\b\b\u0002\u0010\u0003*\u00020\u00022\u00020\u0002B#\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB7\b\u0016\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010B7\b\u0016\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0013J\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0007J!\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0019J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010)\u001a\u00020$H\u0007R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/paging/PagedList$Builder;", "Key", "", "Value", "dataSource", "Landroidx/paging/DataSource;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;)V", "pageSize", "", "(Landroidx/paging/DataSource;I)V", "pagingSource", "Landroidx/paging/PagingSource;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedList$Config;)V", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;I)V", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initialKey", "Ljava/lang/Object;", "notifyDispatcher", "build", "Landroidx/paging/PagedList;", "setBoundaryCallback", "setCoroutineScope", "setFetchDispatcher", "setFetchExecutor", "fetchExecutor", "Ljava/util/concurrent/Executor;", "setInitialKey", "(Ljava/lang/Object;)Landroidx/paging/PagedList$Builder;", "setNotifyDispatcher", "setNotifyExecutor", "notifyExecutor", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData, which no longer supports constructing snapshots of loaded data manually.", replaceWith = @ReplaceWith(expression = "Pager.flow", imports = {"androidx.paging.Pager"}))
    public static final class Builder<Key, Value> {
        private BoundaryCallback<Value> boundaryCallback;
        private final Config config;
        private al coroutineScope;
        private DataSource<Key, Value> dataSource;
        private ah fetchDispatcher;
        private Key initialKey;
        private final PagingSource.LoadResult.Page<Key, Value> initialPage;
        private ah notifyDispatcher;
        private final PagingSource<Key, Value> pagingSource;

        public Builder(DataSource<Key, Value> r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "dataSource");
            this(r9, PagedListConfigKt.Config$default(r10, 0, false, 0, 0, 30, null));
        }

        public Builder(DataSource<Key, Value> r4, Config r5) {
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            Intrinsics.checkNotNullParameter(r5, "config");
            this.coroutineScope = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
            this.pagingSource = null;
            this.dataSource = r4;
            this.initialPage = null;
            this.config = r5;
        }

        public Builder(PagingSource<Key, Value> r9, PagingSource.LoadResult.Page<Key, Value> r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "pagingSource");
            Intrinsics.checkNotNullParameter(r10, "initialPage");
            this(r9, r10, PagedListConfigKt.Config$default(r11, 0, false, 0, 0, 30, null));
        }

        public Builder(PagingSource<Key, Value> r4, PagingSource.LoadResult.Page<Key, Value> r5, Config r6) {
            Intrinsics.checkNotNullParameter(r4, "pagingSource");
            Intrinsics.checkNotNullParameter(r5, "initialPage");
            Intrinsics.checkNotNullParameter(r6, "config");
            this.coroutineScope = (al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin");
            this.pagingSource = r4;
            this.dataSource = null;
            this.initialPage = r5;
            this.config = r6;
        }

        private static /* synthetic */ void getCoroutineScope$annotations() {
        }

        public final PagedList<Value> build() {
            ah r0 = this.fetchDispatcher;
            if (r0 != null) goto L5;
            r0 = ba.c();
        L5:
            ah r6 = r0;
            PagingSource<Key, Value> r1 = this.pagingSource;
            if (r1 != null) goto L12;
            DataSource<Key, Value> r2 = this.dataSource;
            if (r2 == null) goto L10;
            LegacyPagingSource r3 = new LegacyPagingSource((CoroutineContext) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.class, "com.obric.memorydata.plugin"), r2);
        L11:
            r1 = (PagingSource) ZeusTransformUtils.preCheckCast(r3, PagingSource.class, "com.obric.memorydata.plugin");
            goto L12
        L10:
            r3 = null;
        L12:
            PagingSource<Key, Value> r4 = r1;
            if (ZeusTransformUtils.instanceOf(r4, LegacyPagingSource.class) == false) goto L15;
            ((LegacyPagingSource) ZeusTransformUtils.preCheckCast(r4, LegacyPagingSource.class, "com.obric.memorydata.plugin")).setPageSize(this.config.pageSize);
        L15:
            if (r4 == null) goto L17;
            boolean r5 = true;
        L18:
            if (r5 == false) goto L25;
            Companion r7 = PagedList.Companion;
            PagingSource.LoadResult.Page<Key, Value> r8 = this.initialPage;
            al r9 = this.coroutineScope;
            ah r10 = this.notifyDispatcher;
            if (r10 != null) goto L23;
            r10 = (ah) ZeusTransformUtils.preCheckCast(ba.b().a(), ah.class, "com.obric.memorydata.plugin");
        L23:
            return r7.create(r4, r8, r9, r10, r6, this.boundaryCallback, this.config, this.initialKey);
        L25:
            throw new IllegalStateException("PagedList cannot be built without a PagingSource or DataSource".toString());
        L17:
            r5 = false;
            goto L18
        }

        public final Builder<Key, Value> setBoundaryCallback(BoundaryCallback<Value> r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).boundaryCallback = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder<Key, Value> setCoroutineScope(al r4) {
            al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "coroutineScope");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).coroutineScope = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder<Key, Value> setFetchDispatcher(ah r4) {
            Intrinsics.checkNotNullParameter(r4, "fetchDispatcher");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).fetchDispatcher = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        @Deprecated(message = "Passing an executor will cause it get wrapped as a CoroutineDispatcher, consider passing a CoroutineDispatcher directly", replaceWith = @ReplaceWith(expression = "setFetchDispatcher(fetchExecutor.asCoroutineDispatcher())", imports = {"kotlinx.coroutines.asCoroutineDispatcher"}))
        public final Builder<Key, Value> setFetchExecutor(Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "fetchExecutor");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.fetchDispatcher = bo.a(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder<Key, Value> setInitialKey(Key r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).initialKey = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder<Key, Value> setNotifyDispatcher(ah r4) {
            Intrinsics.checkNotNullParameter(r4, "notifyDispatcher");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).notifyDispatcher = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        @Deprecated(message = "Passing an executor will cause it get wrapped as a CoroutineDispatcher, consider passing a CoroutineDispatcher directly", replaceWith = @ReplaceWith(expression = "setNotifyDispatcher(fetchExecutor.asCoroutineDispatcher())", imports = {"kotlinx.coroutines.asCoroutineDispatcher"}))
        public final Builder<Key, Value> setNotifyExecutor(Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "notifyExecutor");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.notifyDispatcher = bo.a(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Landroidx/paging/PagedList$Callback;", "", "()V", "onChanged", "", "position", "", CommonConsts.COUNT_TYPE, "onInserted", "onRemoved", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onChanged(int r1, int r2);

        public abstract void onInserted(int r1, int r2);

        public abstract void onRemoved(int r1, int r2);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008b\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0006*\u00020\u0001\"\b\b\u0002\u0010\u0005*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u0001H\u0006H\u0007¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Landroidx/paging/PagedList$Companion;", "", "()V", "create", "Landroidx/paging/PagedList;", ExifInterface.GPS_DIRECTION_TRUE, "K", "pagingSource", "Landroidx/paging/PagingSource;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "config", "Landroidx/paging/PagedList$Config;", "key", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagedList;", "dispatchNaiveUpdatesSinceSnapshot", "", "currentSize", "", "snapshotSize", "callback", "Landroidx/paging/PagedList$Callback;", "dispatchNaiveUpdatesSinceSnapshot$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final <K, T> PagedList<T> create(PagingSource<K, T> r12, PagingSource.LoadResult.Page<K, T> r13, al r14, ah r15, ah r16, BoundaryCallback<T> r17, Config r18, K r19) {
            al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r14, al.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "pagingSource");
            Intrinsics.checkNotNullParameter(r2, "coroutineScope");
            Intrinsics.checkNotNullParameter(r15, "notifyDispatcher");
            Intrinsics.checkNotNullParameter(r16, "fetchDispatcher");
            Intrinsics.checkNotNullParameter(r18, "config");
            if (r13 != null) goto L5;
            PagingSource.LoadResult.Page<K, T> r7 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new PagedList$Companion$create$resolvedInitialPage$1(r12, new PagingSource.LoadParams.Refresh(r19, r18.initialLoadSizeHint, r18.enablePlaceholders), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        L7:
            return (PagedList) ZeusTransformUtils.preCheckCast(new ContiguousPagedList(r12, r2, r15, r16, r17, r18, r7, r19), PagedList.class, "com.obric.memorydata.plugin");
        L5:
            r7 = r13;
            goto L7
        }

        public final void dispatchNaiveUpdatesSinceSnapshot$paging_common(int r1, int r2, Callback r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            if (r2 >= r1) goto L9;
            if (r2 <= 0) goto L6;
            r3.onChanged(0, r2);
        L6:
            int r4 = r1 - r2;
            if (r4 <= 0) goto L15;
            r3.onInserted(r2, r4);
            return;
        L15:
            return;
        L9:
            if (r1 <= 0) goto L11;
            r3.onChanged(0, r1);
        L11:
            int r5 = r2 - r1;
            if (r5 == 0) goto L17;
            r3.onRemoved(r1, r5);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/paging/PagedList$Config;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "(IIZII)V", "Builder", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        public static final Companion Companion = null;
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int maxSize;
        public final int pageSize;
        public final int prefetchDistance;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagedList$Config$Builder;", "", "()V", "enablePlaceholders", "", "initialLoadSizeHint", "", "maxSize", "pageSize", "prefetchDistance", "build", "Landroidx/paging/PagedList$Config;", "setEnablePlaceholders", "setInitialLoadSizeHint", "setMaxSize", "setPageSize", "setPrefetchDistance", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Builder {
            public static final Companion Companion = null;
            public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private boolean enablePlaceholders;
            private int initialLoadSizeHint;
            private int maxSize;
            private int pageSize;
            private int prefetchDistance;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/PagedList$Config$Builder$Companion;", "", "()V", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                    this();
                }
            }

            static {
                Companion = new Companion(null);
            }

            public Builder() {
                this.pageSize = -1;
                this.prefetchDistance = -1;
                this.initialLoadSizeHint = -1;
                this.enablePlaceholders = true;
                this.maxSize = Integer.MAX_VALUE;
            }

            public final Config build() {
                if (this.prefetchDistance >= 0) goto L6;
                this.prefetchDistance = this.pageSize;
            L6:
                if (this.initialLoadSizeHint >= 0) goto L9;
                this.initialLoadSizeHint = this.pageSize * 3;
            L9:
                if (this.enablePlaceholders == false) goto L11;
            L15:
                int r0 = this.maxSize;
                if (r0 == Integer.MAX_VALUE) goto L23;
                if (r0 >= (this.pageSize + (this.prefetchDistance * 2))) goto L23;
                throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.pageSize + ", prefetchDist=" + this.prefetchDistance + ", maxSize=" + this.maxSize);
            L23:
                return new Config(this.pageSize, this.prefetchDistance, this.enablePlaceholders, this.initialLoadSizeHint, this.maxSize);
            L11:
                if (this.prefetchDistance != 0) goto L15;
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }

            public final Builder setEnablePlaceholders(boolean r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).enablePlaceholders = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public final Builder setInitialLoadSizeHint(int r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).initialLoadSizeHint = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public final Builder setMaxSize(int r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).maxSize = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }

            public final Builder setPageSize(int r5) {
                Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
                if (r5 < 1) goto L7;
                r2.pageSize = r5;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            L7:
                throw new IllegalArgumentException("Page size must be a positive number");
            }

            public final Builder setPrefetchDistance(int r4) {
                ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).prefetchDistance = r4;
                return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/paging/PagedList$Config$Companion;", "", "()V", "MAX_SIZE_UNBOUNDED", "", "getMAX_SIZE_UNBOUNDED$annotations", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Config(int r1, int r2, boolean r3, int r4, int r5) {
            this.pageSize = r1;
            this.prefetchDistance = r2;
            this.enablePlaceholders = r3;
            this.initialLoadSizeHint = r4;
            this.maxSize = r5;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0012J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H'J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0018"}, d2 = {"Landroidx/paging/PagedList$LoadStateManager;", "", "()V", "endState", "Landroidx/paging/LoadState;", "getEndState", "()Landroidx/paging/LoadState;", "setEndState", "(Landroidx/paging/LoadState;)V", "refreshState", "getRefreshState", "setRefreshState", "startState", "getStartState", "setStartState", "dispatchCurrentLoadState", "", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "onStateChanged", "type", "state", "setState", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadStateManager {
        private LoadState endState;
        private LoadState refreshState;
        private LoadState startState;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[LoadType.values().length];
                r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public LoadStateManager() {
            this.refreshState = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
            this.startState = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
            this.endState = (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin");
        }

        public final void dispatchCurrentLoadState(Function2<? super LoadType, ? super LoadState, Unit> r3) {
            Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            r4.invoke(LoadType.REFRESH, this.refreshState);
            r4.invoke(LoadType.PREPEND, this.startState);
            r4.invoke(LoadType.APPEND, this.endState);
        }

        public final LoadState getEndState() {
            return this.endState;
        }

        public final LoadState getRefreshState() {
            return this.refreshState;
        }

        public final LoadState getStartState() {
            return this.startState;
        }

        public abstract void onStateChanged(LoadType r1, LoadState r2);

        public final void setEndState(LoadState r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.endState = r2;
        }

        public final void setRefreshState(LoadState r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.refreshState = r2;
        }

        public final void setStartState(LoadState r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.startState = r2;
        }

        public final void setState(LoadType r3, LoadState r4) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "state");
            int r0 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
            if (r0 == 1) goto L18;
            if (r0 == 2) goto L14;
            if (r0 == 3) goto L10;
        L21:
            onStateChanged(r3, r4);
            return;
        L10:
            if (Intrinsics.areEqual(this.endState, r4) == false) goto L12;
            return;
        L12:
            this.endState = r4;
            goto L21
        L14:
            if (Intrinsics.areEqual(this.startState, r4) == false) goto L16;
            return;
        L16:
            this.startState = r4;
            goto L21
        L18:
            if (Intrinsics.areEqual(this.refreshState, r4) == false) goto L20;
            return;
        L20:
            this.refreshState = r4;
            goto L21
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PagedList(PagingSource<?, T> r3, al r4, ah r5, PagedStorage<T> r6, Config r7) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "pagingSource");
        Intrinsics.checkNotNullParameter(r8, "coroutineScope");
        Intrinsics.checkNotNullParameter(r5, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(r6, Scraps.STORAGE);
        Intrinsics.checkNotNullParameter(r7, "config");
        this.pagingSource = r3;
        this.coroutineScope = r8;
        this.notifyDispatcher = r5;
        this.storage = r6;
        this.config = r7;
        this.requiredRemainder = (r7.prefetchDistance * 2) + r7.pageSize;
        this.callbacks = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.loadStateListeners = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List access$getLoadStateListeners$p(PagedList r0) {
        return r0.loadStateListeners;
    }

    @JvmStatic
    public static final <K, T> PagedList<T> create(PagingSource<K, T> r10, PagingSource.LoadResult.Page<K, T> r11, al r12, ah r13, ah r14, BoundaryCallback<T> r15, Config r16, K r17) {
        al r4 = (al) ZeusTransformUtils.wrapperContextForParams(r12, al.class, "com.obric.memorydata.plugin");
        return Companion.create(r10, r11, r4, r13, r14, r15, r16, r17);
    }

    @Deprecated(message = "DataSource is deprecated and has been replaced by PagingSource. PagedList offers indirect ways of controlling fetch ('loadAround()', 'retry()') so that you should not need to access the DataSource/PagingSource.")
    public static /* synthetic */ void getDataSource$annotations() {
    }

    public final void addWeakCallback(Callback r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        CollectionsKt.removeAll(this.callbacks, (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        this.callbacks.add(new WeakReference(r5));
    }

    @Deprecated(message = "Dispatching a diff since snapshot created is behavior that can be instead tracked by attaching a Callback to the PagedList that is mutating, and tracking changes since calling PagedList.snapshot().")
    public final void addWeakCallback(List<? extends T> r3, Callback r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r5 == null) goto L6;
        if (r5 == this) goto L6;
        Companion.dispatchNaiveUpdatesSinceSnapshot$paging_common(size(), r5.size(), r4);
    L6:
        addWeakCallback(r4);
    }

    public final void addWeakLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> r5) {
        Function2<? super LoadType, ? super LoadState, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        CollectionsKt.removeAll(this.loadStateListeners, (Function1) ZeusTransformUtils.preCheckCast(C09501.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        this.loadStateListeners.add(new WeakReference(r6));
        dispatchCurrentLoadState(r6);
    }

    public abstract void detach();

    public abstract void dispatchCurrentLoadState(Function2<? super LoadType, ? super LoadState, Unit> r1);

    public final void dispatchStateChangeAsync$paging_common(LoadType r8, LoadState r9) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "state");
        i.a(this.coroutineScope, (CoroutineContext) ZeusTransformUtils.preCheckCast(this.notifyDispatcher, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new PagedList$dispatchStateChangeAsync$1(this, r8, r9, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r1) {
        return this.storage.get(r1);
    }

    public final Config getConfig() {
        return this.config;
    }

    public final al getCoroutineScope$paging_common() {
        return this.coroutineScope;
    }

    public final DataSource<?, T> getDataSource() {
        PagingSource<?, T> r3 = getPagingSource();
        if (ZeusTransformUtils.instanceOf(r3, LegacyPagingSource.class) == false) goto L7;
        DataSource<?, T> r4 = ((LegacyPagingSource) ZeusTransformUtils.preCheckCast(r3, LegacyPagingSource.class, "com.obric.memorydata.plugin")).getDataSource$paging_common();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.paging.DataSource<*, T of androidx.paging.PagedList>");
        return r4;
    L7:
        throw new IllegalStateException("Attempt to access dataSource on a PagedList that was instantiated with a " + r3.getClass().getSimpleName() + " instead of a DataSource");
    }

    public abstract Object getLastKey();

    public final int getLoadedCount() {
        return this.storage.getStorageCount();
    }

    public final ah getNotifyDispatcher$paging_common() {
        return this.notifyDispatcher;
    }

    public final NullPaddedList<T> getNullPaddedList() {
        return (NullPaddedList) ZeusTransformUtils.preCheckCast(this.storage, NullPaddedList.class, "com.obric.memorydata.plugin");
    }

    public PagingSource<?, T> getPagingSource() {
        return this.pagingSource;
    }

    public final int getPositionOffset() {
        return this.storage.getPositionOffset();
    }

    public final Runnable getRefreshRetryCallback$paging_common() {
        return this.refreshRetryCallback;
    }

    public final int getRequiredRemainder$paging_common() {
        return this.requiredRemainder;
    }

    public int getSize() {
        return this.storage.size();
    }

    public final PagedStorage<T> getStorage$paging_common() {
        return this.storage;
    }

    public abstract boolean isDetached();

    public boolean isImmutable() {
        return isDetached();
    }

    public final int lastLoad() {
        return this.storage.getLastLoadAroundIndex();
    }

    public final void loadAround(int r4) {
        if (r4 < 0) goto L8;
        if (r4 >= size()) goto L8;
        this.storage.setLastLoadAroundIndex(r4);
        loadAroundInternal(r4);
        return;
    L8:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + size());
    }

    public abstract void loadAroundInternal(int r1);

    public final void notifyChanged(int r4, int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(this.callbacks, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Callback r0 = (Callback) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Callback.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.onChanged(r4, r5);
        goto L6
    }

    public final void notifyInserted$paging_common(int r4, int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(this.callbacks, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Callback r0 = (Callback) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Callback.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.onInserted(r4, r5);
        goto L6
    }

    public final void notifyRemoved(int r4, int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(this.callbacks, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Callback r0 = (Callback) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Callback.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.onRemoved(r4, r5);
        goto L6
    }

    @Override // java.util.AbstractList, java.util.List
    public final T remove(int r1) {
        return (T) removeAt(r1);
    }

    public Object removeAt(int r1) {
        return super.remove(r1);
    }

    public final void removeWeakCallback(final Callback r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        CollectionsKt.removeAll(this.callbacks, (Function1) ZeusTransformUtils.preCheckCast(new C09511(r3), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void removeWeakLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> r3) {
        final Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        CollectionsKt.removeAll(this.loadStateListeners, (Function1) ZeusTransformUtils.preCheckCast(new C09521(r4), Function1.class, "com.obric.memorydata.plugin"));
    }

    public void retry() {
    }

    public void setInitialLoadState(LoadType r1, LoadState r2) {
        Intrinsics.checkNotNullParameter(r1, "loadType");
        Intrinsics.checkNotNullParameter(r2, "loadState");
    }

    public final void setRefreshRetryCallback$paging_common(Runnable r3) {
        this.refreshRetryCallback = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }

    public final void setRetryCallback(Runnable r3) {
        this.refreshRetryCallback = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return getSize();
    }

    public final List<T> snapshot() {
        if (isImmutable() == false) goto L5;
        Object r2 = ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.memorydata.plugin");
    L7:
        return (List) r2;
    L5:
        r2 = ZeusTransformUtils.preCheckCast(new SnapshotPagedList(this), List.class, "com.obric.memorydata.plugin");
        goto L7
    }
}
