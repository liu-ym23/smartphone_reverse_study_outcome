package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.GroupListItemViewHolder1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fp0.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/adapter/RecentlyUsedListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder1;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecentlyUsedListAdapter extends RecyclerView.Adapter<GroupListItemViewHolder1> {
    public List<MiniAppEntranceCell> a;
    public final Function2<MiniAppEntranceCell, Integer, Unit> b;

    public final int getItemCount() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecentlyUsedListAdapter(List<MiniAppEntranceCell> r2, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "recentlyUsedList");
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        GroupListItemViewHolder1 r13 = (GroupListItemViewHolder1) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        MiniAppEntranceCell r8 = (MiniAppEntranceCell) ListProtector.get(this.a, r12);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        b.a(r13.b, r13.a, r13.e, r13.c, r13.d, r13.f, r13.g, r8, r12);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new GroupListItemViewHolder1(LayoutInflater.from(r3.getContext()).inflate(2131566940, r3, false), this.b);
    }
}
