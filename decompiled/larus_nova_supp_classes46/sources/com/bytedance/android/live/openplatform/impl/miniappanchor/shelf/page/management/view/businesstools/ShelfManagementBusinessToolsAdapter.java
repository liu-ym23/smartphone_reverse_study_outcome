package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bq0.a;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.CouponItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.PrivateMsgItemViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/ShelfManagementBusinessToolsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementBusinessToolsAdapter extends RecyclerView.Adapter<BaseBusinessToolItemViewHolder> {
    public List<? extends a> a;
    public final BaseBusinessToolItemViewHolder.a b;

    public final int getItemCount() {
        return this.a.size();
    }

    public ShelfManagementBusinessToolsAdapter(BaseBusinessToolItemViewHolder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "businessToolItemListener");
        this.b = r2;
        this.a = CollectionsKt.emptyList();
    }

    public final int getItemViewType(int r2) {
        return ((a) ListProtector.get(this.a, r2)).b().ordinal();
    }

    public final void y2(List<? extends a> r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if (r0.add(((a) r2).b()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        this.a = r1;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        BaseBusinessToolItemViewHolder r4 = (BaseBusinessToolItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.T3((a) ListProtector.get(this.a, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131566933, r4, false);
        if (r5 != BusinessToolType.Coupon.ordinal()) goto L6;
        return new CouponItemViewHolder(r6, this.b);
    L6:
        if (r5 != BusinessToolType.PrivateMsg.ordinal()) goto L9;
        return new PrivateMsgItemViewHolder(r6, this.b);
    L9:
        return new BaseBusinessToolItemViewHolder(r6, this.b);
    }
}
