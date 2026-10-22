package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends BaseAnimationListener {
    public final /* synthetic */ a0 a;

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
    }

    public final void onAnimationStart(AnimatedDrawable2 r1) {
    }

    public z(a0 r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        MediaAnchorInfoWidget r3 = this.a.a;
        int r0 = MediaAnchorInfoWidget.x;
        ((HSImageView) r3.m.getValue()).setVisibility(8);
    }
}
