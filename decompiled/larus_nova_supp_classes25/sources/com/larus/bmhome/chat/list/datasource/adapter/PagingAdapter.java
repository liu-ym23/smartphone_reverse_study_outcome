package com.larus.bmhome.chat.list.datasource.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import bh8.d;
import com.larus.bmhome.chat.adapter.MessageAdapter$Companion$diff$1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.base.MessageCellAdapter;
import com.larus.bmhome.social.page.datasource.diff.ActionListDiffer;
import com.larus.bmhome.social.page.datasource.event.a;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vr8.f;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007B%\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00028\u0001H\u0086@¢\u0006\u0002\u0010$J*\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010&\u001a\u00020'2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH$J%\u0010(\u001a\u00020\u001f2\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u001f0*¢\u0006\u0002\b+J\u0017\u0010,\u001a\u0004\u0018\u00018\u00002\u0006\u0010-\u001a\u00020\tH\u0004¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\tJ\u0014\u00100\u001a\u00020\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002J\u0014\u00103\u001a\u00020\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002J\u001e\u00104\u001a\u00020\u001f2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u0010-\u001a\u00020\tH\u0017J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0010\u00108\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;", "T", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Event", "Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/bmhome/chat/list/base/MessageCellAdapter;", "prefetchDistance", "", "diff", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "<init>", "(ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;)V", "dataSource", "", "getDataSource", "()Ljava/util/List;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "differ", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "getDiffer", "()Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "differ$delegate", "Lkotlin/Lazy;", "prefetcher", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingPrefetch;", "resetPrefetchAll", "", "enablePrepend", "", "collectEvent", "event", "(Lcom/larus/bmhome/social/page/datasource/event/IActionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDiff", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "safeNotify", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getItem", "position", "(I)Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "getItemCount", "registerDataSourceObserver", "observer", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "unregisterDataSourceObserver", "onBindViewHolder", "holder", "Lcom/larus/list/arch/FlowListViewHolder;", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class PagingAdapter<T extends b, Event extends a<T>, VH extends RecyclerView.ViewHolder> extends MessageCellAdapter<T> {
    public final DiffUtil.ItemCallback<T> g;
    public RecyclerView h;
    public final Lazy i;
    public final f j;

    public abstract ActionListDiffer E2(PagingAdapterListUpdateCallback r1, DiffUtil.ItemCallback r2);

    public com.larus.bmhome.social.page.datasource.diff.b<T, Event> F2() {
        return (com.larus.bmhome.social.page.datasource.diff.b) this.i.getValue();
    }

    public final int getItemCount() {
        return z2().size();
    }

    public final List<T> z2() {
        return F2().c();
    }

    public final void G2(final Function1<? super MessageCellAdapter<T>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        d.a(this.h, new bh8.a(r3, this));
    }

    public void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.h = r2;
    }

    public void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        this.h = null;
    }

    public PagingAdapter(MessageAdapter$Companion$diff$1 r2, vr8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "diff");
        Intrinsics.checkNotNullParameter(r3, "loader");
        this.g = r2;
        this.i = LazyKt.lazy(new bh8.b(this));
        this.j = new f(r3);
    }

    public void B2(FlowListViewHolder<T> r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        super.B2(r6, r7);
        f r8 = this.j;
        int r0 = getItemCount();
        r8.getClass();
        if (r0 <= 0) goto L24;
        if (r0 <= 0) goto L25;
        int r1 = r8.a;
        int r2 = r1 - r7;
        if (r0 > r1) goto L10;
        r1 = r0 / 2;
    L10:
        int r3 = ((r1 + r7) + 1) - r0;
        if (r2 > 0) goto L13;
    L16:
        if (r3 > 0) goto L18;
        return;
    L18:
        if (r8.d == 0) goto L20;
        FLogger.a.i("SimplePagingPrefetch/Intercept", "scheduleAppend——intercept");
        return;
    L20:
        FLogger.a.i("SimplePagingPrefetch", "scheduleAppend");
        r8.d = 1;
        r8.f.run();
        return;
    L13:
        if (r8.e == 0) goto L15;
        FLogger.a.i("SimplePagingPrefetch/Intercept", "schedulePrepend——intercept");
        goto L16
    L15:
        FLogger.a.i("SimplePagingPrefetch", "schedulePrepend");
        r8.e = 1;
        r8.g.run();
        goto L16
    L25:
        return;
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return C2(r1, r2);
    }
}
