package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkTabTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "SpaceItemDecoration", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkTabTitleViewHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final MultiTypeAdapter b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkTabTitleViewHolder$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public final int a;

        public SpaceItemDecoration(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
            Intrinsics.checkNotNullParameter(r3, "outRect");
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r6, "state");
            int r7 = this.a / 2;
            r3.left = r7;
            r3.right = r7;
            RecyclerView.Adapter r8 = r5.getAdapter();
            if (r8 != null) goto L6;
            return;
        L6:
            if (r5.getChildAdapterPosition(r4) != 0) goto L9;
            r3.left = 0;
        L9:
            if (r5.getChildAdapterPosition(r4) != (r8.getItemCount() - 1)) goto L12;
            r3.right = 0;
            return;
        }
    }

    public AnchorLinkTabTitleViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        Context r0 = r4.getContext();
        this.a = r4.findViewById(2131367794);
        RecyclerView r5 = r4.findViewById(2131384076);
        r5.setLayoutManager(new LinearLayoutManager(r0, 0, false));
        r5.addItemDecoration(new SpaceItemDecoration(com.bytedance.android.live.revenue.common.i.b(12)));
        MultiTypeAdapter r1 = new MultiTypeAdapter();
        r1.z2(q21.l.a.class, new q21.l());
        Unit r2 = Unit.INSTANCE;
        this.b = r1;
        r5.setAdapter(r1);
    }
}
