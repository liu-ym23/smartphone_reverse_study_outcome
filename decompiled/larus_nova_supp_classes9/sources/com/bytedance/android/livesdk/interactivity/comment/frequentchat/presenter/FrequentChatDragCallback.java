package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/presenter/FrequentChatDragCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatDragCallback extends ItemTouchHelper.Callback {
    public final t62.a a;

    public static final class a {
    }

    static {
    }

    public final float getMoveThreshold(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        return 1.0f;
    }

    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    public final boolean isLongPressDragEnabled() {
        return false;
    }

    public final void onSwiped(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "viewHolder");
    }

    public FrequentChatDragCallback(t62.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final void clearView(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        super.clearView(r2, r3);
        if ((r3 instanceof FrequentChatViewHolder) == true) goto L5;
        r3 = null;
    L5:
        FrequentChatViewHolder r4 = (FrequentChatViewHolder) r3;
        if (r4 == null) goto L12;
        CardView r5 = r4.b;
        if (r5 == null) goto L13;
        r5.setCardElevation(0.0f);
        return;
    L13:
        return;
    }

    public final int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public final void onSelectedChanged(RecyclerView.ViewHolder r3, int r4) {
        if (r4 == 2) goto L6;
    L15:
        super.onSelectedChanged(r3, r4);
        return;
    L6:
        if ((r3 instanceof FrequentChatViewHolder) == true) goto L8;
        RecyclerView.ViewHolder r0 = null;
    L9:
        FrequentChatViewHolder r1 = (FrequentChatViewHolder) r0;
        if (r1 == null) goto L17;
        CardView r2 = r1.b;
        if (r2 == null) goto L18;
        r2.setCardElevation(10.0f);
        goto L15
    L18:
        return;
    L17:
        return;
    L8:
        r0 = r3;
        goto L9
    }

    public final boolean onMove(RecyclerView r2, RecyclerView.ViewHolder r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "target");
        this.a.J(r3.getAdapterPosition(), r4.getAdapterPosition());
        return true;
    }
}
