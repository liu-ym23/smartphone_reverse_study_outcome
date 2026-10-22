package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 extends q0 {
    public final /* synthetic */ ImageView a;

    public b0(ImageView r1) {
        this.a = r1;
    }

    public final void h(py.k r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = this.a.getLayoutParams();
        int r0 = s1.f(30.0f);
        r5.width = r0;
        r5.height = (r4 * r0) / r3;
        this.a.setLayoutParams(r5);
    }
}
