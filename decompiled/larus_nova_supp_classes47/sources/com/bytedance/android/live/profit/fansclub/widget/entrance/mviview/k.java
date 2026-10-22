package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends BaseAnimationListener {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        this.a.a.q.setVisibility(8);
    }
}
