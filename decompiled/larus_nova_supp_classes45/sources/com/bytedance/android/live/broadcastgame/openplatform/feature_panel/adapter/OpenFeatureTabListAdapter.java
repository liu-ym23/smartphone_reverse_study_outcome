package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f20.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/OpenFeatureTabListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabListAdapter extends RecyclerView.Adapter<AbsOpenFeatureTabListItemViewHolder<Object>> {
    public final f a;
    public List<f10.f> b;
    public final Long c;

    public final int getItemViewType(int r1) {
        return r1;
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void setData(List<f10.f> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.b = r2;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        AbsOpenFeatureTabListItemViewHolder r6 = (AbsOpenFeatureTabListItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        f r1 = this.a;
        Object r7 = ListProtector.get(this.b, r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        r1.a(r7).d(r6, r7);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, KtvSubElement.CONTAINER);
        f r0 = this.a;
        Object r5 = ListProtector.get(this.b, r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r5, "data");
        return (AbsOpenFeatureTabListItemViewHolder) r0.a(r5).a(LayoutInflater.from(r3.getContext()), r3);
    }

    public OpenFeatureTabListAdapter(List<f10.f> r2, List<? extends f20.a<?, ?>> r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "iconList");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.b = r2;
        this.c = r4;
        this.a = new f(r3);
    }
}
