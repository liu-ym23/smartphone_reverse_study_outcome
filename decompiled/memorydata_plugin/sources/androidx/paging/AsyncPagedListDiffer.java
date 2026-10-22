package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "AsyncPagedListDiffer is deprecated and has been replaced by AsyncPagingDataDiffer", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer<T>", imports = {"androidx.paging.AsyncPagingDataDiffer"}))
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002_`B!\b\u0017\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B\u001d\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0002\u0010\fJ\"\u0010H\u001a\u00020(2\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0+H\u0016J0\u0010J\u001a\u00020(2(\u0010K\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u0012\u0004\u0012\u00020(0+J\u0016\u0010J\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0017\u0010L\u001a\u0004\u0018\u00018\u00002\u0006\u0010M\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010NJK\u0010O\u001a\u00020(2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00172\b\u0010W\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0002\bYJ2\u0010Z\u001a\u00020(2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\"\u0010\\\u001a\u00020(2\u0018\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0+H\u0016J0\u0010]\u001a\u00020(2(\u0010K\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u0012\u0004\u0012\u00020(0+J\u0016\u0010]\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0018\u0010^\u001a\u00020(2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0016J\"\u0010^\u001a\u00020(2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00122\b\u0010W\u001a\u0004\u0018\u00010XH\u0016R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00128VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u001b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR>\u0010 \u001a2\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(0!X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010)\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0+0*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b0\u0010\u000eR\u001a\u00101\u001a\u000202X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001a\u00020\u0017X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u000e\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010;R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b=\u0010\u000eR\u0014\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u000eR\u001c\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bB\u0010\u000eR\u001a\u0010C\u001a\u00020\tX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006a"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "listUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "config", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "(Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "getConfig$paging_runtime_release$annotations", "()V", "getConfig$paging_runtime_release", "()Landroidx/recyclerview/widget/AsyncDifferConfig;", "currentList", "Landroidx/paging/PagedList;", "getCurrentList$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "itemCount", "", "getItemCount", "()I", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "getListeners$paging_runtime_release$annotations", "getListeners$paging_runtime_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "loadStateListener", "Lkotlin/reflect/KFunction2;", "Landroidx/paging/LoadType;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "type", "Landroidx/paging/LoadState;", "state", "", "loadStateListeners", "", "Lkotlin/Function2;", "getLoadStateListeners$paging_runtime_release", "()Ljava/util/List;", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager$annotations", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor$paging_runtime_release", "()Ljava/util/concurrent/Executor;", "setMainThreadExecutor$paging_runtime_release", "(Ljava/util/concurrent/Executor;)V", "maxScheduledGeneration", "getMaxScheduledGeneration$paging_runtime_release$annotations", "getMaxScheduledGeneration$paging_runtime_release", "setMaxScheduledGeneration$paging_runtime_release", "(I)V", "pagedList", "getPagedList$annotations", "pagedListCallback", "Landroidx/paging/PagedList$Callback;", "getPagedListCallback$annotations", "snapshot", "getSnapshot$annotations", "updateCallback", "getUpdateCallback$paging_runtime_release", "()Landroidx/recyclerview/widget/ListUpdateCallback;", "setUpdateCallback$paging_runtime_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;)V", "addLoadStateListener", "listener", "addPagedListListener", "callback", "getItem", "index", "(I)Ljava/lang/Object;", "latchPagedList", "newList", "diffSnapshot", "diffResult", "Landroidx/paging/NullPaddedDiffResult;", "recordingCallback", "Landroidx/paging/RecordingCallback;", "lastAccessIndex", "commitCallback", "Ljava/lang/Runnable;", "latchPagedList$paging_runtime_release", "onCurrentListChanged", "previousList", "removeLoadStateListener", "removePagedListListener", "submitList", "OnCurrentListChangedWrapper", "PagedListListener", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AsyncPagedListDiffer<T> {
    private final AsyncDifferConfig<T> config;
    private final CopyOnWriteArrayList<PagedListListener<T>> listeners;
    private final KFunction<Unit> loadStateListener;
    private final List<Function2<LoadType, LoadState, Unit>> loadStateListeners;
    private final PagedList.LoadStateManager loadStateManager;
    private Executor mainThreadExecutor;
    private int maxScheduledGeneration;
    private PagedList<T> pagedList;
    private final PagedList.Callback pagedListCallback;
    private PagedList<T> snapshot;
    public ListUpdateCallback updateCallback;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012(\u0010\u0004\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ(\u0010\u000b\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0016R3\u0010\u0004\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$OnCurrentListChangedWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "callback", "Lkotlin/Function2;", "Landroidx/paging/PagedList;", "", "(Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "onCurrentListChanged", "previousList", "currentList", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {
        private final Function2<PagedList<T>, PagedList<T>, Unit> callback;

        public OnCurrentListChangedWrapper(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> r3) {
            Function2<PagedList<T>, PagedList<T>, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.callback = r4;
        }

        public final Function2<PagedList<T>, PagedList<T>, Unit> getCallback() {
            return this.callback;
        }

        @Override // androidx.paging.AsyncPagedListDiffer.PagedListListener
        public void onCurrentListChanged(PagedList<T> r1, PagedList<T> r2) {
            this.callback.invoke(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onCurrentListChanged", "", "previousList", "Landroidx/paging/PagedList;", "currentList", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> r1, PagedList<T> r2);
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer(\n                Dispatchers.Main,\n                Dispatchers.IO,\n                config.diffCallback,\n                listUpdateCallback\n            )", imports = {"androidx.paging.AsyncPagingDataDiffer", "kotlinx.coroutines.Dispatchers"}))
    public AsyncPagedListDiffer(ListUpdateCallback r4, AsyncDifferConfig<T> r5) {
        ListUpdateCallback r6 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r4, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listUpdateCallback");
        Intrinsics.checkNotNullParameter(r5, "config");
        Executor r0 = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "getMainThreadExecutor()");
        this.mainThreadExecutor = r0;
        this.listeners = new CopyOnWriteArrayList();
        PagedList.LoadStateManager r1 = (PagedList.LoadStateManager) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$loadStateManager$1(this), PagedList.LoadStateManager.class, "com.obric.memorydata.plugin");
        this.loadStateManager = r1;
        this.loadStateListener = (KFunction) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$loadStateListener$1(r1), KFunction.class, "com.obric.memorydata.plugin");
        this.loadStateListeners = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.memorydata.plugin");
        this.pagedListCallback = (PagedList.Callback) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$pagedListCallback$1(this), PagedList.Callback.class, "com.obric.memorydata.plugin");
        setUpdateCallback$paging_runtime_release(r6);
        this.config = r5;
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer(\n                Dispatchers.Main,\n                Dispatchers.IO,\n                diffCallback,\n                listUpdateCallback\n            )", imports = {"androidx.paging.AsyncPagingDataDiffer", "kotlinx.coroutines.Dispatchers"}))
    public AsyncPagedListDiffer(RecyclerView.Adapter<?> r4, DiffUtil.ItemCallback<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "diffCallback");
        Executor r0 = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "getMainThreadExecutor()");
        this.mainThreadExecutor = r0;
        this.listeners = new CopyOnWriteArrayList();
        PagedList.LoadStateManager r1 = (PagedList.LoadStateManager) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$loadStateManager$1(this), PagedList.LoadStateManager.class, "com.obric.memorydata.plugin");
        this.loadStateManager = r1;
        this.loadStateListener = (KFunction) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$loadStateListener$1(r1), KFunction.class, "com.obric.memorydata.plugin");
        this.loadStateListeners = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.memorydata.plugin");
        this.pagedListCallback = (PagedList.Callback) ZeusTransformUtils.preCheckCast(new AsyncPagedListDiffer$pagedListCallback$1(this), PagedList.Callback.class, "com.obric.memorydata.plugin");
        setUpdateCallback$paging_runtime_release((ListUpdateCallback) ZeusTransformUtils.preCheckCast(new AdapterListUpdateCallback(r4), ListUpdateCallback.class, "com.obric.memorydata.plugin"));
        AsyncDifferConfig<T> r6 = new AsyncDifferConfig.Builder(r5).build();
        Intrinsics.checkNotNullExpressionValue(r6, "Builder(diffCallback).build()");
        this.config = r6;
    }

    public static /* synthetic */ void getConfig$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getListeners$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getLoadStateManager$annotations() {
    }

    public static /* synthetic */ void getMaxScheduledGeneration$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getPagedList$annotations() {
    }

    private static /* synthetic */ void getPagedListCallback$annotations() {
    }

    private static /* synthetic */ void getSnapshot$annotations() {
    }

    public static /* synthetic */ void lambda$6gnpAd5vPOJGRgUkdmGrSPCgJJQ(PagedList r0, PagedList r1, AsyncPagedListDiffer r2, int r3, PagedList r4, RecordingCallback r5, Runnable r6) {
        submitList$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$KEredQU-w8gMt2iL6jXlVZ68MCs, reason: not valid java name */
    public static /* synthetic */ void m50lambda$KEredQUw8gMt2iL6jXlVZ68MCs(AsyncPagedListDiffer r0, int r1, PagedList r2, PagedList r3, NullPaddedDiffResult r4, RecordingCallback r5, PagedList r6, Runnable r7) {
        submitList$lambda$2$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private final void onCurrentListChanged(PagedList<T> r4, PagedList<T> r5, Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.listeners, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((PagedListListener) ZeusTransformUtils.preCheckCast(r3.next(), PagedListListener.class, "com.obric.memorydata.plugin")).onCurrentListChanged(r4, r5);
        goto L4
    L6:
        if (r7 == null) goto L10;
        r7.run();
        return;
    }

    private static final void submitList$lambda$2(final PagedList r11, final PagedList r12, final AsyncPagedListDiffer r13, final int r14, final PagedList r15, final RecordingCallback r16, Runnable r17) {
        final Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r17, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "$newSnapshot");
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(r16, "$recordingCallback");
        NullPaddedList<T> r0 = r11.getNullPaddedList();
        NullPaddedList<T> r2 = r12.getNullPaddedList();
        DiffUtil.ItemCallback<T> r3 = r13.config.getDiffCallback();
        Intrinsics.checkNotNullExpressionValue(r3, "config.diffCallback");
        final NullPaddedDiffResult r5 = NullPaddedListDiffHelperKt.computeDiff(r0, r2, r3);
        r13.mainThreadExecutor.execute(new $$Lambda$AsyncPagedListDiffer$KEredQUw8gMt2iL6jXlVZ68MCs(r13, r14, r15, r12, r5, r16, r11, r8));
    }

    private static final void submitList$lambda$2$lambda$1(AsyncPagedListDiffer r7, int r8, PagedList r9, PagedList r10, NullPaddedDiffResult r11, RecordingCallback r12, PagedList r13, Runnable r14) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$newSnapshot");
        Intrinsics.checkNotNullParameter(r11, "$result");
        Intrinsics.checkNotNullParameter(r12, "$recordingCallback");
        if (r7.maxScheduledGeneration != r8) goto L6;
        r7.latchPagedList$paging_runtime_release(r9, r10, r11, r12, r13.lastLoad(), r6);
        return;
    }

    public void addLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> r3) {
        Function2<LoadType, LoadState, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        PagedList<T> r0 = this.pagedList;
        if (r0 == null) goto L5;
        r0.addWeakLoadStateListener(r4);
    L6:
        this.loadStateListeners.add(r4);
        return;
    L5:
        this.loadStateManager.dispatchCurrentLoadState(r4);
        goto L6
    }

    public void addPagedListListener(PagedListListener<T> r3) {
        PagedListListener<T> r4 = (PagedListListener) ZeusTransformUtils.wrapperContextForParams(r3, PagedListListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.add(r4);
    }

    public final void addPagedListListener(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> r3) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.listeners.add(new OnCurrentListChangedWrapper(r4));
    }

    public final AsyncDifferConfig<T> getConfig$paging_runtime_release() {
        return this.config;
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> r0 = this.snapshot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.pagedList;
    }

    public T getItem(int r2) {
        PagedList<T> r0 = this.snapshot;
        PagedList<T> r1 = this.pagedList;
        if (r0 != null) goto L10;
        if (r1 == null) goto L9;
        r1.loadAround(r2);
        return r1.get(r2);
    L9:
        throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
    L10:
        return r0.get(r2);
    }

    public int getItemCount() {
        PagedList<T> r0 = getCurrentList();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final CopyOnWriteArrayList<PagedListListener<T>> getListeners$paging_runtime_release() {
        return this.listeners;
    }

    public final List<Function2<LoadType, LoadState, Unit>> getLoadStateListeners$paging_runtime_release() {
        return this.loadStateListeners;
    }

    public final Executor getMainThreadExecutor$paging_runtime_release() {
        return this.mainThreadExecutor;
    }

    public final int getMaxScheduledGeneration$paging_runtime_release() {
        return this.maxScheduledGeneration;
    }

    public final ListUpdateCallback getUpdateCallback$paging_runtime_release() {
        ListUpdateCallback r0 = this.updateCallback;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("updateCallback");
        return null;
    }

    public final void latchPagedList$paging_runtime_release(PagedList<T> r5, PagedList<T> r6, NullPaddedDiffResult r7, RecordingCallback r8, int r9, Runnable r10) {
        Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "newList");
        Intrinsics.checkNotNullParameter(r6, "diffSnapshot");
        Intrinsics.checkNotNullParameter(r7, "diffResult");
        Intrinsics.checkNotNullParameter(r8, "recordingCallback");
        PagedList<T> r0 = this.snapshot;
        if (r0 == null) goto L12;
        if (this.pagedList != null) goto L12;
        this.pagedList = r5;
        r5.addWeakLoadStateListener((Function2) ZeusTransformUtils.preCheckCast(this.loadStateListener, Function2.class, "com.obric.memorydata.plugin"));
        this.snapshot = null;
        NullPaddedListDiffHelperKt.dispatchDiff(r0.getNullPaddedList(), getUpdateCallback$paging_runtime_release(), r6.getNullPaddedList(), r7);
        r8.dispatchRecordingTo(this.pagedListCallback);
        r5.addWeakCallback(this.pagedListCallback);
        if (r5.isEmpty() == true) goto L9;
        r5.loadAround(RangesKt.coerceIn(NullPaddedListDiffHelperKt.transformAnchorIndex(r0.getNullPaddedList(), r7, r6.getNullPaddedList(), r9), 0, r5.size() - 1));
    L9:
        onCurrentListChanged(r0, this.pagedList, r11);
        return;
    L12:
        throw new IllegalStateException("must be in snapshot state to apply diff");
    }

    public void removeLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> r3) {
        Function2<? super LoadType, ? super LoadState, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.loadStateListeners.remove(r4);
        PagedList<T> r2 = this.pagedList;
        if (r2 == null) goto L6;
        r2.removeWeakLoadStateListener(r4);
        return;
    }

    public void removePagedListListener(PagedListListener<T> r3) {
        PagedListListener r4 = (PagedListListener) ZeusTransformUtils.wrapperContextForParams(r3, PagedListListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.remove(r4);
    }

    public final void removePagedListListener(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> r3) {
        final Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        CollectionsKt.removeAll((List) ZeusTransformUtils.preCheckCast(this.listeners, List.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void setMainThreadExecutor$paging_runtime_release(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.mainThreadExecutor = r4;
    }

    public final void setMaxScheduledGeneration$paging_runtime_release(int r1) {
        this.maxScheduledGeneration = r1;
    }

    public final void setUpdateCallback$paging_runtime_release(ListUpdateCallback r3) {
        ListUpdateCallback r4 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.updateCallback = r4;
    }

    public void submitList(PagedList<T> r2) {
        submitList(r2, null);
    }

    public void submitList(final PagedList<T> r11, Runnable r12) {
        final Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin");
        final int r6 = this.maxScheduledGeneration + 1;
        this.maxScheduledGeneration = r6;
        PagedList<T> r13 = this.pagedList;
        if (r11 != r13) goto L8;
        if (r9 == null) goto L40;
        r9.run();
        return;
    L40:
        return;
    L8:
        if (r13 != null) goto L10;
    L15:
        PagedList<T> r2 = getCurrentList();
        if (r11 != null) goto L26;
        int r14 = getItemCount();
        if (r13 == null) goto L21;
        r13.removeWeakCallback(this.pagedListCallback);
        r13.removeWeakLoadStateListener((Function2) ZeusTransformUtils.preCheckCast(this.loadStateListener, Function2.class, "com.obric.memorydata.plugin"));
        this.pagedList = null;
    L23:
        getUpdateCallback$paging_runtime_release().onRemoved(0, r14);
        onCurrentListChanged(r2, null, r9);
        return;
    L21:
        if (this.snapshot == null) goto L23;
        this.snapshot = null;
        goto L23
    L26:
        if (getCurrentList() != null) goto L29;
        this.pagedList = r11;
        r11.addWeakLoadStateListener((Function2) ZeusTransformUtils.preCheckCast(this.loadStateListener, Function2.class, "com.obric.memorydata.plugin"));
        r11.addWeakCallback(this.pagedListCallback);
        getUpdateCallback$paging_runtime_release().onInserted(0, r11.size());
        onCurrentListChanged(null, r11, r9);
        return;
    L29:
        PagedList<T> r15 = this.pagedList;
        if (r15 == null) goto L32;
        r15.removeWeakCallback(this.pagedListCallback);
        r15.removeWeakLoadStateListener((Function2) ZeusTransformUtils.preCheckCast(this.loadStateListener, Function2.class, "com.obric.memorydata.plugin"));
        List<T> r16 = r15.snapshot();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer.submitList$lambda$0>");
        this.snapshot = (PagedList) ZeusTransformUtils.preCheckCast(r16, PagedList.class, "com.obric.memorydata.plugin");
        this.pagedList = null;
    L32:
        final PagedList<T> r3 = this.snapshot;
        if (r3 == null) goto L39;
        if (this.pagedList != null) goto L39;
        List<T> r17 = r11.snapshot();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer>");
        final PagedList r4 = (PagedList) ZeusTransformUtils.preCheckCast(r17, PagedList.class, "com.obric.memorydata.plugin");
        final RecordingCallback r8 = new RecordingCallback();
        r11.addWeakCallback((PagedList.Callback) ZeusTransformUtils.preCheckCast(r8, PagedList.Callback.class, "com.obric.memorydata.plugin"));
        this.config.getBackgroundThreadExecutor().execute(new $$Lambda$AsyncPagedListDiffer$6gnpAd5vPOJGRgUkdmGrSPCgJJQ(r3, r4, this, r6, r11, r8, r9));
        return;
    L39:
        throw new IllegalStateException("must be in snapshot state to diff");
    L10:
        if (ZeusTransformUtils.instanceOf(r11, InitialPagedList.class) == false) goto L15;
        r13.removeWeakCallback(this.pagedListCallback);
        r13.removeWeakLoadStateListener((Function2) ZeusTransformUtils.preCheckCast(this.loadStateListener, Function2.class, "com.obric.memorydata.plugin"));
        this.loadStateManager.setState(LoadType.REFRESH, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.Loading.INSTANCE, LoadState.class, "com.obric.memorydata.plugin"));
        this.loadStateManager.setState(LoadType.PREPEND, (LoadState) ZeusTransformUtils.preCheckCast(new LoadState.NotLoading(false), LoadState.class, "com.obric.memorydata.plugin"));
        this.loadStateManager.setState(LoadType.APPEND, (LoadState) ZeusTransformUtils.preCheckCast(new LoadState.NotLoading(false), LoadState.class, "com.obric.memorydata.plugin"));
        if (r9 == null) goto L41;
        r9.run();
        return;
    }
}
