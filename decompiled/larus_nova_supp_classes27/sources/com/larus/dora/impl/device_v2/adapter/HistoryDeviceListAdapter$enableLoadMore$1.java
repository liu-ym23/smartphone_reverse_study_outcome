package com.larus.dora.impl.device_v2.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/larus/dora/impl/device_v2/adapter/HistoryDeviceListAdapter$enableLoadMore$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryDeviceListAdapter$enableLoadMore$1 extends RecyclerView.OnScrollListener {
    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        LinearLayoutManager r5 = r2.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r6 = r5;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        r6.getItemCount();
        r6.findLastVisibleItemPosition();
        throw null;
    L5:
        r6 = null;
        goto L6
    }
}
