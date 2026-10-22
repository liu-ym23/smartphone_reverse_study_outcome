package com.bytedance.android.live.recharge.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ RechargePagerAdapter.RechargeItemAdapter a;
    public final /* synthetic */ RechargeItem b;
    public final /* synthetic */ AbsRechargeViewHolder c;
    public final /* synthetic */ int d;

    public a(RechargePagerAdapter.RechargeItemAdapter r1, RechargeItem r2, AbsRechargeViewHolder r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        RechargeItem r5 = this.b;
        if ((r5 instanceof RechargeItem.CustomItem) == false) goto L6;
        this.a.b.g.F7(r5);
        return;
    L6:
        if ((r5 instanceof RechargeItem.a) == true) goto L8;
        return;
    L8:
        if (((RecyclerView.ViewHolder) this.c).itemView.isSelected() == false) goto L10;
        return;
    L10:
        RechargePagerAdapter.f(this.a.b, this.c, false, this.d);
    }
}
