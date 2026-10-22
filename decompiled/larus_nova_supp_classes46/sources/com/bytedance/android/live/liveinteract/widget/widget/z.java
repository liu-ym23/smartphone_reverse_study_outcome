package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ SelectPairRankAdapter.SelectPairRankItemViewHolder a;
    public final /* synthetic */ IBaseUser b;

    public z(SelectPairRankAdapter.SelectPairRankItemViewHolder r1, IBaseUser r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        IBaseUser r3 = this.b;
        if (r3 == null) goto L6;
        this.a.i.a0(r3);
        return;
    }
}
