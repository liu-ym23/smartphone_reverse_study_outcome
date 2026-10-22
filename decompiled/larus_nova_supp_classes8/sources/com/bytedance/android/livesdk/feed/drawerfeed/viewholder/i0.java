package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 extends q0 {
    public final /* synthetic */ DrawerSmallLiveViewHolder a;

    public i0(DrawerSmallLiveViewHolder r1) {
        this.a = r1;
    }

    public final void h(py.k r1, int r2, int r3) {
        ViewGroup.LayoutParams r4 = this.a.R.getLayoutParams();
        r4.height = (int) (this.a.R.getWidth() * (r3 / r2));
        this.a.R.setLayoutParams(r4);
    }
}
