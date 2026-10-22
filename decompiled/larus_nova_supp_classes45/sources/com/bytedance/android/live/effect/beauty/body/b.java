package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveBodyBeautyAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder c;

    public b(LiveBodyBeautyAdapter r1, int r2, LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.e.put(this.b, Boolean.FALSE);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) this.c).itemView.findViewById(2131373068).setVisibility(0);
        LiveBodyBeautyAdapter r4 = this.a;
        LiveBodyBeautyAdapter.a r0 = r4.d;
        if (r0 == null) goto L6;
        r0.a((Sticker) ListProtector.get(r4.a, this.b));
        return;
    }
}
