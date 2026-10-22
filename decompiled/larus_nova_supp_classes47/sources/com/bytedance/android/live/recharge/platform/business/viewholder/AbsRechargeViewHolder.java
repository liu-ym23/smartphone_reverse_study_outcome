package com.bytedance.android.live.recharge.platform.business.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsRechargeViewHolder<T extends RechargeItem> extends RecyclerView.ViewHolder {
    public T a;

    public abstract void U3();

    public abstract void V3();

    public AbsRechargeViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public void T3(T r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.a = r2;
    }
}
