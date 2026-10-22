package com.obric.memorydata.ui.recyclerview;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.AsyncPagingDataDiffer;
import androidx.paging.CombinedLoadStates;
import androidx.paging.ItemSnapshotList;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.RecyclerView.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001BB+\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB!\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000eB+\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\r\u0012\b\b\u0002\u0010\n\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0011J\u001c\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0086@¢\u0006\u0002\u0010!J\u001c\u0010\u001e\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J\u0019\u0010&\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0005¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010)\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010'J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+J\b\u0010,\u001a\u00020\u001bH\u0016J\u001a\u00104\u001a\u00020\u00132\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001306J\u001a\u00107\u001a\u00020\u00132\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001306J\u0014\u00108\u001a\u00020\u00132\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001309J\u0014\u0010:\u001a\u00020\u00132\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001309J\u0012\u0010;\u001a\u00020<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030>J\u0012\u0010?\u001a\u00020<2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030>J\u001e\u0010A\u001a\u00020<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030>2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030>R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130.¢\u0006\b\n\u0000\u001a\u0004\b3\u00101¨\u0006C"}, d2 = {"Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "VH", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "userSetRestorationPolicy", "", "setStateRestorationPolicy", "", "strategy", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "getItemId", "", "position", "", "setHasStableIds", "hasStableIds", "submitData", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "retry", "refresh", "getItem", "(I)Ljava/lang/Object;", "peek", "index", "snapshot", "Landroidx/paging/ItemSnapshotList;", "getItemCount", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "getOnPagesUpdatedFlow", "addLoadStateListener", "listener", "Lkotlin/Function1;", "removeLoadStateListener", "addOnPagesUpdatedListener", "Lkotlin/Function0;", "removeOnPagesUpdatedListener", "withLoadStateHeader", "Lcom/obric/oui/orecyclerview/widget/ConcatAdapter;", "header", "Lcom/obric/memorydata/ui/recyclerview/OuiLoadStateAdapter;", "withLoadStateFooter", "footer", "withLoadStateHeaderAndFooter", "OuiAdapterListUpdateCallback", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OuiPagingDataAdapter<T, VH extends RecyclerView.v> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsyncPagingDataDiffer<T> f13017b;
    private final i<CombinedLoadStates> c;
    private final i<Unit> d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter$OuiAdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "<init>", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;)V", "onInserted", "", "position", "", CommonConsts.COUNT_TYPE, "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", "payload", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class OuiAdapterListUpdateCallback implements ListUpdateCallback {
        private final RecyclerView.Adapter<?> adapter;

        public OuiAdapterListUpdateCallback(RecyclerView.Adapter<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
            this.adapter = r2;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r1, int r2, Object r3) {
            this.adapter.a(r1, r2, r3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r1, int r2) {
            this.adapter.c(r1, r2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r1, int r2) {
            this.adapter.b(r1, r2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r1, int r2) {
            this.adapter.d(r1, r2);
        }
    }

    public OuiPagingDataAdapter(DiffUtil.ItemCallback<T> r5, CoroutineContext r6, CoroutineContext r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "diffCallback");
        Intrinsics.checkNotNullParameter(r8, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r9, "workerDispatcher");
        AsyncPagingDataDiffer<T> r0 = new AsyncPagingDataDiffer(r5, (ListUpdateCallback) ZeusTransformUtils.preCheckCast(new OuiAdapterListUpdateCallback((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this, RecyclerView.Adapter.class, "com.obric.memorydata.plugin")), ListUpdateCallback.class, "com.obric.memorydata.plugin"), r8, r9);
        this.f13017b = r0;
        super.a(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        a((RecyclerView.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.b.class, "com.obric.memorydata.plugin"));
        a((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function1.class, "com.obric.memorydata.plugin"));
        this.c = r0.getLoadStateFlow();
        this.d = r0.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ OuiPagingDataAdapter(DiffUtil.ItemCallback r2, CoroutineContext r3, CoroutineContext r4, int r5, DefaultConstructorMarker r6) {
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

    private static final Unit a(a r1, a r2, CombinedLoadStates r3) {
        Intrinsics.checkNotNullParameter(r3, "loadStates");
        r1.a(r3.getPrepend());
        r2.a(r3.getAppend());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(OuiPagingDataAdapter r0) {
        b(r0);
    }

    private static final <T, VH extends RecyclerView.v> void b(OuiPagingDataAdapter<T, VH> r2) {
        if (r2.i() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT) goto L5;
        return;
    L5:
        if (((OuiPagingDataAdapter) r2).f13016a == true) goto L9;
        r2.a(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
        return;
    }

    public static /* synthetic */ Unit lambda$5iFnaRrdiyxg0isZp8Ks5lFr1fk(a r0, a r1, CombinedLoadStates r2) {
        return a(r0, r1, r2);
    }

    public final ConcatAdapter a(final a<?> r4, final a<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "header");
        Intrinsics.checkNotNullParameter(r5, "footer");
        a(new $$Lambda$OuiPagingDataAdapter$5iFnaRrdiyxg0isZp8Ks5lFr1fk(r4, r5));
        return new ConcatAdapter(new RecyclerView.Adapter[]{r4, this, r5});
    }

    public final Object a(PagingData<T> r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r2 = this.f13017b.submitData(r3, r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.Adapter.StateRestorationPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.f13016a = true;
        super.a(r2);
    }

    public final void a(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f13017b.addOnPagesUpdatedListener(r4);
    }

    public final void a(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f13017b.addLoadStateListener(r4);
    }

    public final T b(int r1) {
        return this.f13017b.getItem(r1);
    }

    public final void b() {
        this.f13017b.refresh();
    }

    public final void b(Function1<? super CombinedLoadStates, Unit> r3) {
        Function1<? super CombinedLoadStates, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f13017b.removeLoadStateListener(r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final void b_(boolean r1) {
        throw new UnsupportedOperationException("Stable ids are unsupported on OuiPagingDataAdapter.");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final long c(int r1) {
        return super.c(r1);
    }

    public final ItemSnapshotList<T> c() {
        return this.f13017b.snapshot();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f13017b.getItemCount();
    }

    public final T d(int r1) {
        return this.f13017b.peek(r1);
    }

    public final i<CombinedLoadStates> e() {
        return this.c;
    }
}
