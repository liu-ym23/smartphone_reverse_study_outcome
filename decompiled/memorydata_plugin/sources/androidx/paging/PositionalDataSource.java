package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "PositionalDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Int, T>", imports = {"androidx.paging.PagingSource"}))
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b'\u0018\u0000 '*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003:\u0005'()*+B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH'J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u001d2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH'J*\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0000\"\b\b\u0001\u0010!*\u00020\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H!0#J*\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0000\"\b\b\u0001\u0010!*\u00020\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H!0$J6\u0010%\u001a\b\u0012\u0004\u0012\u0002H!0\u0000\"\b\b\u0001\u0010!*\u00020\u00022\u001e\u0010\"\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0&0#J6\u0010%\u001a\b\u0012\u0004\u0012\u0002H!0\u0000\"\b\b\u0001\u0010!*\u00020\u00022\u001e\u0010\"\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0&0$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0090D¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/paging/PositionalDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/DataSource;", "", "()V", "isContiguous", "", "isContiguous$paging_common$annotations", "isContiguous$paging_common", "()Z", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Integer;", "load", "Landroidx/paging/DataSource$BaseResult;", TrackerImpl.PARAMS, "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "loadRange", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "map", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "Companion", "LoadInitialCallback", "LoadInitialParams", "LoadRangeCallback", "LoadRangeParams", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {
    public static final Companion Companion = null;
    private final boolean isContiguous;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$Companion;", "", "()V", "computeInitialLoadPosition", "", TrackerImpl.PARAMS, "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "totalCount", "computeInitialLoadSize", "initialLoadPosition", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final int computeInitialLoadPosition(LoadInitialParams r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
            int r1 = r2.requestedStartPosition;
            int r0 = r2.requestedLoadSize;
            int r4 = r2.pageSize;
            return Math.max(0, Math.min(((((r3 - r0) + r4) - 1) / r4) * r4, (r1 / r4) * r4));
        }

        @JvmStatic
        public final int computeInitialLoadSize(LoadInitialParams r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
            return Math.min(r3 - r2, r1.requestedLoadSize);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadInitialCallback<T> {
        public LoadInitialCallback() {
        }

        public abstract void onResult(List<? extends T> r1, int r2);

        public abstract void onResult(List<? extends T> r1, int r2, int r3);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "requestedStartPosition", "", "requestedLoadSize", "pageSize", "placeholdersEnabled", "", "(IIIZ)V", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int r2, int r3, int r4, boolean r5) {
            this.requestedStartPosition = r2;
            this.requestedLoadSize = r3;
            this.pageSize = r4;
            this.placeholdersEnabled = r5;
            boolean r1 = true;
            if (r2 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L21;
            if (r3 < 0) goto L9;
            boolean r6 = true;
        L10:
            if (r6 == false) goto L19;
            if (r4 >= 0) goto L14;
            r1 = false;
        L14:
            if (r1 == false) goto L17;
            return;
        L17:
            throw new IllegalStateException(("invalid page size: " + r4).toString());
        L19:
            throw new IllegalStateException(("invalid load size: " + r3).toString());
        L9:
            r6 = false;
            goto L10
        L21:
            throw new IllegalStateException(("invalid start position: " + r2).toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H&¨\u0006\b"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadRangeCallback<T> {
        public LoadRangeCallback() {
        }

        public abstract void onResult(List<? extends T> r1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "startPosition", "", "loadSize", "(II)V", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int r1, int r2) {
            this.startPosition = r1;
            this.loadSize = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    public static final /* synthetic */ Object access$loadRange(PositionalDataSource r2, LoadRangeParams r3, Continuation r4) {
        return r2.loadRange(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final int computeInitialLoadPosition(LoadInitialParams r1, int r2) {
        return Companion.computeInitialLoadPosition(r1, r2);
    }

    @JvmStatic
    public static final int computeInitialLoadSize(LoadInitialParams r1, int r2, int r3) {
        return Companion.computeInitialLoadSize(r1, r2, r3);
    }

    public static /* synthetic */ void isContiguous$paging_common$annotations() {
    }

    /* JADX INFO: renamed from: lambda$-zEzUtSVtSHyJcOPR8NNxGc3NYY, reason: not valid java name */
    public static /* synthetic */ List m53lambda$zEzUtSVtSHyJcOPR8NNxGc3NYY(Function1 r0, List r1) {
        return mapByPage$lambda$2(r0, r1);
    }

    public static /* synthetic */ List lambda$HNuB_7PDIVth4k901XuQgtJJDXM(Function r0, List r1) {
        return map$lambda$4(r0, r1);
    }

    public static /* synthetic */ List lambda$nb3LVZzq2GD9tCcFycFF3LlgFvs(Function1 r0, List r1) {
        return map$lambda$5(r0, r1);
    }

    private final Object loadRange(final LoadRangeParams r5, Continuation<? super DataSource.BaseResult<T>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r7), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        loadRange(r5, (LoadRangeCallback) ZeusTransformUtils.preCheckCast(new PositionalDataSource$loadRange$2$1(r5, this, r2), LoadRangeCallback.class, "com.obric.memorydata.plugin"));
        Object r4 = r0.h();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r4;
    }

    private static final List map$lambda$4(Function r3, List r4) {
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$function");
        Intrinsics.checkNotNullExpressionValue(r6, Constants.KEY_LIST);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r0.add(r5.apply(r8.next()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final List map$lambda$5(Function1 r3, List r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$function");
        Intrinsics.checkNotNullExpressionValue(r6, Constants.KEY_LIST);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r0.add(r5.invoke(r8.next()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final List mapByPage$lambda$2(Function1 r2, List r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$function");
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        return (List) ZeusTransformUtils.preCheckCast(r4.invoke(r5), List.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.DataSource
    public final Integer getKeyInternal$paging_common(T r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ Integer getKeyInternal$paging_common(Object r1) {
        return getKeyInternal$paging_common(r1);
    }

    @Override // androidx.paging.DataSource
    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Integer> r6, Continuation<? super DataSource.BaseResult<T>> r7) {
        Continuation<? super DataSource.BaseResult<T>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (r6.getType$paging_common() != LoadType.REFRESH) goto L13;
        int r0 = r6.getInitialLoadSize();
        int r3 = 0;
        if (r6.getKey() == null) goto L12;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r6.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6.getPlaceholdersEnabled() == false) goto L9;
        r0 = Math.max(r0 / r6.getPageSize(), 2) * r6.getPageSize();
        int r2 = ((r1 - (r0 / 2)) / r6.getPageSize()) * r6.getPageSize();
    L10:
        r3 = Math.max(0, r2);
        goto L12
    L9:
        r2 = r1 - (r0 / 2);
    L12:
        return loadInitial$paging_common(new LoadInitialParams(r3, r0, r6.getPageSize(), r6.getPlaceholdersEnabled()), r8);
    L13:
        Integer r4 = r6.getKey();
        Intrinsics.checkNotNull(r4);
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        int r9 = r6.getPageSize();
        if (r6.getType$paging_common() != LoadType.PREPEND) goto L17;
        r9 = Math.min(r9, r5);
        r5 = r5 - r9;
    L17:
        return loadRange(new LoadRangeParams(r5, r9), r8);
    }

    public abstract void loadInitial(LoadInitialParams r1, LoadInitialCallback<T> r2);

    public final Object loadInitial$paging_common(final LoadInitialParams r5, Continuation<? super DataSource.BaseResult<T>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r7), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        loadInitial(r5, (LoadInitialCallback) ZeusTransformUtils.preCheckCast(new PositionalDataSource$loadInitial$2$1(this, r2, r5), LoadInitialCallback.class, "com.obric.memorydata.plugin"));
        Object r4 = r0.h();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r4;
    }

    public abstract void loadRange(LoadRangeParams r1, LoadRangeCallback<T> r2);

    @Override // androidx.paging.DataSource
    public /* synthetic */ DataSource map(Function r3) {
        return (DataSource) ZeusTransformUtils.preCheckCast(map((Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin")), DataSource.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.DataSource
    public /* synthetic */ DataSource map(Function1 r3) {
        return (DataSource) ZeusTransformUtils.preCheckCast(map((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin")), DataSource.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(Function<T, V> r3) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return mapByPage(new $$Lambda$PositionalDataSource$HNuB_7PDIVth4k901XuQgtJJDXM(r4));
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(Function1<? super T, ? extends V> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return mapByPage(new $$Lambda$PositionalDataSource$nb3LVZzq2GD9tCcFycFF3LlgFvs(r4));
    }

    @Override // androidx.paging.DataSource
    public /* synthetic */ DataSource mapByPage(Function r3) {
        return (DataSource) ZeusTransformUtils.preCheckCast(mapByPage((Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin")), DataSource.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.DataSource
    public /* synthetic */ DataSource mapByPage(Function1 r3) {
        return (DataSource) ZeusTransformUtils.preCheckCast(mapByPage((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin")), DataSource.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> r3) {
        Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return (PositionalDataSource) ZeusTransformUtils.preCheckCast(new WrapperPositionalDataSource(this, r4), PositionalDataSource.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(Function1<? super List<? extends T>, ? extends List<? extends V>> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return mapByPage(new $$Lambda$PositionalDataSource$zEzUtSVtSHyJcOPR8NNxGc3NYY(r4));
    }
}
