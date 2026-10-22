package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import a20.e;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.OpenFeatureRecentUsedListRecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureGroupRecentUsedListItemViewHolder;
import f10.d;
import f10.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends me.drakeet.multitype.b<d, OpenFeatureGroupRecentUsedListItemViewHolder> {
    public final e b;

    public b(a20.d r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        OpenFeatureGroupRecentUsedListItemViewHolder r5 = (OpenFeatureGroupRecentUsedListItemViewHolder) r3;
        d r6 = (d) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "recentUsedGroupList");
        List<f> r7 = r6.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "itemList");
        Object r8 = ((RecyclerView.ViewHolder) r5).itemView;
        if ((r8 instanceof OpenFeatureRecentUsedListRecyclerView) == false) goto L10;
        if (r8 == null) goto L9;
        OpenFeatureRecentUsedListRecyclerView r9 = (OpenFeatureRecentUsedListRecyclerView) r8;
        Intrinsics.checkNotNullParameter(r7, "itemList");
        OpenFeatureRecentUsedGroupListAdapter r0 = r9.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.a = r7;
        RecyclerView.Adapter r11 = r9.getAdapter();
        if (r11 == null) goto L11;
        r11.notifyDataSetChanged();
        return;
    L11:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.OpenFeatureRecentUsedListRecyclerView");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new OpenFeatureGroupRecentUsedListItemViewHolder(new OpenFeatureRecentUsedListRecyclerView(r5.getContext(), new OpenFeatureRecentUsedGroupListAdapter(CollectionsKt.emptyList(), this.b)));
    }
}
