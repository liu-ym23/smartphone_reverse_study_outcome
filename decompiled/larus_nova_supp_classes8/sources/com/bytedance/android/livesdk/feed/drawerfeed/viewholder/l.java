package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends q0 {
    public final /* synthetic */ HSImageView a;

    public l(HSImageView r1) {
        this.a = r1;
    }

    public final void h(py.k r1, int r2, int r3) {
        ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
        r4.width = (int) (r4.height * (r2 / r3));
        this.a.setLayoutParams(r4);
    }
}
