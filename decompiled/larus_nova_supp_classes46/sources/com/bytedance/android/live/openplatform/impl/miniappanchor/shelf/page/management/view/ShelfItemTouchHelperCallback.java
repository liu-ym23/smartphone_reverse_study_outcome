package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfItemTouchHelperCallback extends ItemTouchHelper.Callback {
    public final a a;

    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    public final void onSwiped(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "viewHolder");
    }

    public final boolean isLongPressDragEnabled() {
        return this.a.isDraggable();
    }

    public ShelfItemTouchHelperCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.a = r2;
    }

    public final void clearView(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        super.clearView(r2, r3);
        if (r2.isComputingLayout() == true) goto L6;
        this.a.g();
        return;
    }

    public final int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public final void onSelectedChanged(RecyclerView.ViewHolder r1, int r2) {
        super.onSelectedChanged(r1, r2);
        if (r2 != 2) goto L6;
        this.a.c();
        return;
    }

    public final boolean onMove(RecyclerView r2, RecyclerView.ViewHolder r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "target");
        this.a.r(r3, r4);
        return true;
    }
}
