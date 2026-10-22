package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002)*B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\u0018\u00010#J\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019J\u0016\u0010%\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0007J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Landroidx/paging/AccessorState;", "Key", "", "Value", "()V", "blockStates", "", "Landroidx/paging/AccessorState$BlockState;", "[Landroidx/paging/AccessorState$BlockState;", "errors", "Landroidx/paging/LoadState$Error;", "[Landroidx/paging/LoadState$Error;", "pendingRequests", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "refreshAllowed", "", "getRefreshAllowed", "()Z", "setRefreshAllowed", "(Z)V", "add", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "clearErrors", "", "clearPendingRequest", "clearPendingRequests", "computeLoadStates", "Landroidx/paging/LoadStates;", "computeLoadTypeState", "Landroidx/paging/LoadState;", "getPendingBoundary", "Lkotlin/Pair;", "getPendingRefresh", "setBlockState", "state", "setError", "errorState", "BlockState", "PendingRequest", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AccessorState<Key, Value> {
    private final BlockState[] blockStates;
    private final LoadState.Error[] errors;
    private final ArrayDeque<PendingRequest<Key, Value>> pendingRequests;
    private boolean refreshAllowed;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum BlockState extends Enum<BlockState> {
        private static final /* synthetic */ BlockState[] $VALUES = null;
        public static final BlockState COMPLETED = null;
        public static final BlockState REQUIRES_REFRESH = null;
        public static final BlockState UNBLOCKED = null;

        private static final /* synthetic */ BlockState[] $values() {
            return new BlockState[]{UNBLOCKED, COMPLETED, REQUIRES_REFRESH};
        }

        static {
            UNBLOCKED = new BlockState("UNBLOCKED", 0);
            COMPLETED = new BlockState("COMPLETED", 1);
            REQUIRES_REFRESH = new BlockState("REQUIRES_REFRESH", 2);
            $VALUES = $values();
        }

        private BlockState(String r1, int r2) {
            super(r1, r2);
        }

        public static BlockState valueOf(String r2) {
            return (BlockState) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlockState.class, r2), BlockState.class, "com.obric.memorydata.plugin");
        }

        public static BlockState[] values() {
            return (BlockState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlockState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "Key", "", "Value", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPagingState", "()Landroidx/paging/PagingState;", "setPagingState", "(Landroidx/paging/PagingState;)V", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PendingRequest<Key, Value> {
        private final LoadType loadType;
        private PagingState<Key, Value> pagingState;

        public PendingRequest(LoadType r2, PagingState<Key, Value> r3) {
            Intrinsics.checkNotNullParameter(r2, "loadType");
            Intrinsics.checkNotNullParameter(r3, "pagingState");
            this.loadType = r2;
            this.pagingState = r3;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final PagingState<Key, Value> getPagingState() {
            return this.pagingState;
        }

        public final void setPagingState(PagingState<Key, Value> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.pagingState = r2;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[BlockState.values().length];
            r1[BlockState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[BlockState.REQUIRES_REFRESH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[BlockState.UNBLOCKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public AccessorState() {
        int r0 = LoadType.values().length;
        BlockState[] r1 = new BlockState[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = BlockState.UNBLOCKED;
        r3 = r3 + 1;
        goto L3
    L5:
        this.blockStates = r1;
        int r4 = LoadType.values().length;
        LoadState.Error[] r5 = new LoadState.Error[r4];
    L6:
        if (r2 >= r4) goto L8;
        r5[r2] = null;
        r2 = r2 + 1;
        goto L6
    L8:
        this.errors = r5;
        this.pendingRequests = new ArrayDeque();
    }

    private final LoadState computeLoadTypeState(LoadType r8) {
        BlockState r0 = this.blockStates[r8.ordinal()];
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.pendingRequests, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        if (((PendingRequest) ZeusTransformUtils.preCheckCast(r2.next(), PendingRequest.class, "com.obric.memorydata.plugin")).getLoadType() != r8) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
        r4 = true;
        goto L16
    L13:
        r3 = false;
    L16:
        if (r4 == true) goto L18;
    L22:
        Object r7 = this.errors[r8.ordinal()];
        if (r7 != null) goto L21;
        int r9 = WhenMappings.$EnumSwitchMapping$1[r0.ordinal()];
        if (r9 == 1) goto L37;
        if (r9 != 2) goto L30;
    L34:
        LoadState.NotLoading r10 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
    L40:
        return (LoadState) ZeusTransformUtils.preCheckCast(r10, LoadState.class, "com.obric.memorydata.plugin");
    L30:
        if (r9 == 3) goto L34;
        throw new NoWhenBranchMatchedException();
    L37:
        if (WhenMappings.$EnumSwitchMapping$0[r8.ordinal()] == 1) goto L34;
        r10 = LoadState.NotLoading.Companion.getComplete$paging_common();
    L21:
        return (LoadState) ZeusTransformUtils.preCheckCast(r7, LoadState.class, "com.obric.memorydata.plugin");
    L18:
        if (r0 == BlockState.REQUIRES_REFRESH) goto L22;
        r7 = LoadState.Loading.INSTANCE;
        goto L21
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final boolean add(LoadType r7, PagingState<Key, Value> r8) {
        Intrinsics.checkNotNullParameter(r7, "loadType");
        Intrinsics.checkNotNullParameter(r8, "pagingState");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pendingRequests, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((PendingRequest) ZeusTransformUtils.preCheckCast(r1, PendingRequest.class, "com.obric.memorydata.plugin")).getLoadType() != r7) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
    L12:
        PendingRequest r2 = (PendingRequest) ZeusTransformUtils.preCheckCast(r1, PendingRequest.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        r2.setPagingState(r8);
        return false;
    L16:
        BlockState r3 = this.blockStates[r7.ordinal()];
        if (r3 != BlockState.REQUIRES_REFRESH) goto L23;
        if (r7 == LoadType.REFRESH) goto L23;
        this.pendingRequests.add(new PendingRequest(r7, r8));
        return false;
    L23:
        if (r3 == BlockState.UNBLOCKED) goto L28;
        if (r7 == LoadType.REFRESH) goto L28;
        return false;
    L28:
        if (r7 != LoadType.REFRESH) goto L31;
        setError(LoadType.REFRESH, null);
    L31:
        if (this.errors[r7.ordinal()] == null) goto L33;
        return false;
    L33:
        return this.pendingRequests.add(new PendingRequest(r7, r8));
    L8:
        r5 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final void clearErrors() {
        int r0 = this.errors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.errors[r1] = null;
        r1 = r1 + 1;
        goto L3
    }

    public final void clearPendingRequest(final LoadType r3) {
        Intrinsics.checkNotNullParameter(r3, "loadType");
        CollectionsKt.removeAll((List) ZeusTransformUtils.preCheckCast(this.pendingRequests, List.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void clearPendingRequests() {
        this.pendingRequests.clear();
    }

    public final LoadStates computeLoadStates() {
        LoadState r0 = computeLoadTypeState(LoadType.REFRESH);
        LoadState r1 = computeLoadTypeState(LoadType.APPEND);
        return new LoadStates(r0, computeLoadTypeState(LoadType.PREPEND), r1);
    }

    public final Pair<LoadType, PagingState<Key, Value>> getPendingBoundary() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pendingRequests, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        PendingRequest r4 = (PendingRequest) ZeusTransformUtils.preCheckCast(r1, PendingRequest.class, "com.obric.memorydata.plugin");
        if (r4.getLoadType() != LoadType.REFRESH) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
    L14:
        PendingRequest r7 = (PendingRequest) ZeusTransformUtils.preCheckCast(r1, PendingRequest.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        return null;
    L17:
        return TuplesKt.to(r7.getLoadType(), r7.getPagingState());
    L8:
        if (this.blockStates[r4.getLoadType().ordinal()] != BlockState.UNBLOCKED) goto L10;
        r5 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public final PagingState<Key, Value> getPendingRefresh() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pendingRequests, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r0 = r5.next();
        if (((PendingRequest) ZeusTransformUtils.preCheckCast(r0, PendingRequest.class, "com.obric.memorydata.plugin")).getLoadType() != LoadType.REFRESH) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        PendingRequest r6 = (PendingRequest) ZeusTransformUtils.preCheckCast(r0, PendingRequest.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L15;
        return null;
    L15:
        return r6.getPagingState();
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public final boolean getRefreshAllowed() {
        return this.refreshAllowed;
    }

    public final void setBlockState(LoadType r2, BlockState r3) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.blockStates[r2.ordinal()] = r3;
    }

    public final void setError(LoadType r2, LoadState.Error r3) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        this.errors[r2.ordinal()] = r3;
    }

    public final void setRefreshAllowed(boolean r1) {
        this.refreshAllowed = r1;
    }
}
