package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder c;

    public t(LiveSmallItemBeautyAdapter r1, int r2, LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.d.put(this.b, Boolean.FALSE);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131373068).setVisibility(0);
        LiveSmallItemBeautyAdapter r4 = this.a;
        LiveSmallItemBeautyAdapter.a r0 = r4.c;
        if (r0 == null) goto L6;
        r0.a((Sticker) ListProtector.get(r4.a, this.b));
        return;
    }
}
