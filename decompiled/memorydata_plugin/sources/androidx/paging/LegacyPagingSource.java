package androidx.paging;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u001eB!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002J+\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "Key", "", "Value", "Landroidx/paging/PagingSource;", "fetchContext", "Lkotlin/coroutines/CoroutineContext;", "dataSource", "Landroidx/paging/DataSource;", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/DataSource;)V", "getDataSource$paging_common", "()Landroidx/paging/DataSource;", "jumpingSupported", "", "getJumpingSupported", "()Z", "pageSize", "", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "guessPageSize", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "load", "Landroidx/paging/PagingSource$LoadResult;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPageSize", "", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    private static final Companion Companion = null;
    private static final int PAGE_SIZE_NOT_SET = Integer.MIN_VALUE;
    private final DataSource<Key, Value> dataSource;
    private final CoroutineContext fetchContext;
    private int pageSize;

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {
        final /* synthetic */ LegacyPagingSource<Key, Value> $tmp0;

        AnonymousClass1(LegacyPagingSource<Key, Value> r1) {
            this.$tmp0 = r1;
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, DataSource.InvalidatedCallback.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return (Function) ZeusTransformUtils.preCheckCast(new FunctionReferenceImpl(0, this.$tmp0, LegacyPagingSource.class, "invalidate", "invalidate()V", 0), Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final void onInvalidated() {
            this.$tmp0.invalidate();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/LegacyPagingSource$Companion;", "", "()V", "PAGE_SIZE_NOT_SET", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DataSource.KeyType.values().length];
            r0[DataSource.KeyType.POSITIONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$load$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "Value", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    static final class C09422 extends SuspendLambda implements Function2<al, Continuation<? super PagingSource.LoadResult.Page<Key, Value>>, Object> {
        final /* synthetic */ DataSource.Params<Key> $dataSourceParams;
        final /* synthetic */ PagingSource.LoadParams<Key> $params;
        int label;
        final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

        C09422(LegacyPagingSource<Key, Value> r3, DataSource.Params<Key> r4, PagingSource.LoadParams<Key> r5, Continuation<? super C09422> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$dataSourceParams = r4;
            this.$params = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09422(this.this$0, this.$dataSourceParams, this.$params, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Object r4) {
            return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(al r3, Continuation<? super PagingSource.LoadResult.Page<Key, Value>> r4) {
            return ((C09422) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09422.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            PagingSource.LoadParams<Key> r7 = this.$params;
            DataSource.BaseResult r9 = (DataSource.BaseResult) ZeusTransformUtils.preCheckCast(r8, DataSource.BaseResult.class, "com.obric.memorydata.plugin");
            List<Value> r2 = r9.data;
            if (r9.data.isEmpty() == true) goto L14;
        L16:
            Object r3 = r9.getPrevKey();
        L18:
            if (r9.data.isEmpty() == true) goto L20;
        L22:
            Object r10 = r9.getNextKey();
        L24:
            return new PagingSource.LoadResult.Page(r2, r3, r10, r9.getItemsBefore(), r9.getItemsAfter());
        L20:
            if (ZeusTransformUtils.instanceOf(r7, PagingSource.LoadParams.Append.class) == false) goto L22;
            r10 = null;
            goto L24
        L14:
            if (ZeusTransformUtils.instanceOf(r7, PagingSource.LoadParams.Prepend.class) == false) goto L16;
            r3 = null;
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            DataSource<Key, Value> r11 = this.this$0.getDataSource$paging_common();
            DataSource.Params<Key> r4 = this.$dataSourceParams;
            Continuation<? super DataSource.BaseResult<Value>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = r11.load$paging_common(r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LegacyPagingSource(CoroutineContext r3, DataSource<Key, Value> r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "fetchContext");
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        this.fetchContext = r5;
        this.dataSource = r4;
        this.pageSize = Integer.MIN_VALUE;
        r4.addInvalidatedCallback((DataSource.InvalidatedCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin"));
        registerInvalidatedCallback((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final int guessPageSize(PagingSource.LoadParams<Key> r1) {
        if (ZeusTransformUtils.instanceOf(r1, PagingSource.LoadParams.Refresh.class) == false) goto L9;
        if ((r1.getLoadSize() % 3) != 0) goto L9;
        return r1.getLoadSize() / 3;
    L9:
        return r1.getLoadSize();
    }

    public final DataSource<Key, Value> getDataSource$paging_common() {
        return this.dataSource;
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        if (this.dataSource.getType$paging_common() != DataSource.KeyType.POSITIONAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.paging.PagingSource
    public Key getRefreshKey(PagingState<Key, Value> r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getType$paging_common().ordinal()];
        if (r0 != 1) goto L5;
        Integer r6 = r7.getAnchorPosition();
        if (r6 == null) goto L36;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
        int r1 = r8 - PagingState.access$getLeadingPlaceholderCount$p(r7);
        int r2 = 0;
    L19:
        if (r2 >= CollectionsKt.getLastIndex(r7.getPages())) goto L23;
        if (r1 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r7.getPages().get(r2), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData())) goto L23;
        r1 = r1 - ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r7.getPages().get(r2), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r2 = r2 + 1;
    L23:
        PagingSource.LoadResult.Page<Key, Value> r9 = r7.closestPageToPosition(r8);
        if (r9 == null) goto L27;
        Object r10 = r9.getPrevKey();
        if (r10 == null) goto L27;
    L28:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");
        return (Key) ZeusTransformUtils.preCheckCast(Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin")).intValue() + r1), Object.class, "com.obric.memorydata.plugin");
    L27:
        r10 = 0;
        goto L28
    L36:
        return null;
    L5:
        if (r0 != 2) goto L7;
        return null;
    L7:
        if (r0 != 3) goto L14;
        Integer r3 = r7.getAnchorPosition();
        if (r3 == null) goto L33;
        Value r11 = r7.closestItemToPosition(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r11 != null) goto L35;
        return null;
    L35:
        return this.dataSource.getKeyInternal$paging_common(r11);
    L33:
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Key> r9, Continuation<? super PagingSource.LoadResult<Key, Value>> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, PagingSource.LoadParams.Refresh.class) == false) goto L7;
        LoadType r0 = LoadType.REFRESH;
    L5:
        LoadType r3 = r0;
        if (this.pageSize != Integer.MIN_VALUE) goto L15;
        System.out.println("WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
        this.pageSize = guessPageSize(r9);
    L15:
        DataSource.Params r1 = new DataSource.Params(r3, r9.getKey(), r9.getLoadSize(), r9.getPlaceholdersEnabled(), this.pageSize);
        return i.a(this.fetchContext, (Function2) ZeusTransformUtils.preCheckCast(new C09422(this, r1, r9, null), Function2.class, "com.obric.memorydata.plugin"), r11);
    L7:
        if (ZeusTransformUtils.instanceOf(r9, PagingSource.LoadParams.Append.class) == false) goto L10;
        r0 = LoadType.APPEND;
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r9, PagingSource.LoadParams.Prepend.class) == false) goto L18;
        r0 = LoadType.PREPEND;
        goto L5
    L18:
        throw new NoWhenBranchMatchedException();
    }

    public final void setPageSize(int r3) {
        int r0 = this.pageSize;
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r3 == r0) goto L7;
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        this.pageSize = r3;
        return;
    L12:
        throw new IllegalStateException(("Page size is already set to " + this.pageSize + '.').toString());
    L7:
        r1 = true;
        goto L8
    }
}
