package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fB)\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\r\u0012\b\b\u0002\u0010\u000b\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u001b\u001a\u00020\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u001dJ\u0014\u0010\u001e\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010!\u001a\u00020\"H\u0005¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"J\u0019\u0010'\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010(\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#J\u0006\u0010)\u001a\u00020\u0017J\u001a\u0010*\u001a\u00020\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u001dJ\u0014\u0010+\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fJ\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001aJ\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0016J\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003J\u001c\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000008J\u001f\u00104\u001a\u00020\u00172\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000008H\u0086@ø\u0001\u0000¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020;2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=J\u0012\u0010>\u001a\u00020;2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030=J\u001e\u0010@\u001a\u00020;2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030=2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Landroidx/paging/PagingDataAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V", "workerDispatcher", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "", "getOnPagesUpdatedFlow", "userSetRestorationPolicy", "", "addLoadStateListener", "listener", "Lkotlin/Function1;", "addOnPagesUpdatedListener", "Lkotlin/Function0;", "getItem", "position", "", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "peek", "index", "refresh", "removeLoadStateListener", "removeOnPagesUpdatedListener", "retry", "setHasStableIds", "hasStableIds", "setStateRestorationPolicy", "strategy", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "submitData", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLoadStateFooter", "Landroidx/recyclerview/widget/ConcatAdapter;", "footer", "Landroidx/paging/LoadStateAdapter;", "withLoadStateHeader", "header", "withLoadStateHeaderAndFooter", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    private final i<CombinedLoadStates> loadStateFlow;
    private final i<Unit> onPagesUpdatedFlow;
    private boolean userSetRestorationPolicy;

    public PagingDataAdapter(DiffUtil.ItemCallback<T> r8) {
        Intrinsics.checkNotNullParameter(r8, "diffCallback");
        this(r8, null, null, 6, null);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> r7, CoroutineContext r8) {
        CoroutineContext r2 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r8, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "diffCallback");
        Intrinsics.checkNotNullParameter(r2, "mainDispatcher");
        this(r7, r2, null, 4, null);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> r5, CoroutineContext r6, CoroutineContext r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "diffCallback");
        Intrinsics.checkNotNullParameter(r8, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r9, "workerDispatcher");
        AsyncPagingDataDiffer<T> r0 = new AsyncPagingDataDiffer(r5, (ListUpdateCallback) ZeusTransformUtils.preCheckCast(new AdapterListUpdateCallback((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this, RecyclerView.Adapter.class, "com.obric.memorydata.plugin")), ListUpdateCallback.class, "com.obric.memorydata.plugin"), r8, r9);
        this.differ = r0;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver((RecyclerView.AdapterDataObserver) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.AdapterDataObserver.class, "com.obric.memorydata.plugin"));
        addLoadStateListener((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function1.class, "com.obric.memorydata.plugin"));
        this.loadStateFlow = r0.getLoadStateFlow();
        this.onPagesUpdatedFlow = r0.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback r2, CoroutineContext r3, CoroutineContext r4, int r5, DefaultConstructorMarker r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");
    L8:
        this(r2, r7, r8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback r4, ah r5) {
        Intrinsics.checkNotNullParameter(r4, "diffCallback");
        Intrinsics.checkNotNullParameter(r5, "mainDispatcher");
        this(r4, (CoroutineContext) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback r1, ah r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L5:
        this(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback r3, ah r4, ah r5) {
        Intrinsics.checkNotNullParameter(r3, "diffCallback");
        Intrinsics.checkNotNullParameter(r4, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r5, "workerDispatcher");
        this(r3, (CoroutineContext) ZeusTransformUtils.preCheckCast(r4, CoroutineContext.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback r2, ah r3, ah r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ba.a();
    L8:
        this(r2, r3, r4);
    }

    private static final <T, VH extends RecyclerView.ViewHolder> void _init_$considerAllowingStateRestoration(PagingDataAdapter<T, VH> r2) {
        if (r2.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT) goto L5;
        return;
    L5:
        if (((PagingDataAdapter) r2).userSetRestorationPolicy == true) goto L9;
        r2.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
        return;
    }

    public static final /* synthetic */ void access$_init_$considerAllowingStateRestoration(PagingDataAdapter r0) {
        _init_$considerAllowingStateRestoration(r0);
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differ.addLoadStateListener(r4);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differ.addOnPagesUpdatedListener(r4);
    }

    public final T getItem(int r1) {
        return this.differ.getItem(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r1) {
        return super.getItemId(r1);
    }

    public final i<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final i<Unit> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    public final T peek(int r1) {
        return this.differ.peek(r1);
    }

    public final void refresh() {
        this.differ.refresh();
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differ.removeLoadStateListener(r4);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.differ.removeOnPagesUpdatedListener(r4);
    }

    public final void retry() {
        this.differ.retry();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r1) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(r2);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    public final Object submitData(PagingData<T> r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r2 = this.differ.submitData(r3, r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    public final void submitData(Lifecycle r2, PagingData<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "pagingData");
        this.differ.submitData(r2, r3);
    }

    public final ConcatAdapter withLoadStateFooter(final LoadStateAdapter<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "footer");
        addLoadStateListener((Function1) ZeusTransformUtils.preCheckCast(new C09551(r4), Function1.class, "com.obric.memorydata.plugin"));
        return new ConcatAdapter(new RecyclerView.Adapter[]{this, r4});
    }

    public final ConcatAdapter withLoadStateHeader(final LoadStateAdapter<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "header");
        addLoadStateListener((Function1) ZeusTransformUtils.preCheckCast(new C09561(r4), Function1.class, "com.obric.memorydata.plugin"));
        return new ConcatAdapter(new RecyclerView.Adapter[]{r4, this});
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(final LoadStateAdapter<?> r4, final LoadStateAdapter<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "header");
        Intrinsics.checkNotNullParameter(r5, "footer");
        addLoadStateListener((Function1) ZeusTransformUtils.preCheckCast(new C09571(r4, r5), Function1.class, "com.obric.memorydata.plugin"));
        return new ConcatAdapter(new RecyclerView.Adapter[]{r4, this, r5});
    }
}
