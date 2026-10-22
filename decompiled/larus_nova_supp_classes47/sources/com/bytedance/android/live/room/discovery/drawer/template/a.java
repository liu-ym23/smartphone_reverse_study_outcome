package com.bytedance.android.live.room.discovery.drawer.template;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements AnimationListener {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;
    public final /* synthetic */ Animatable b;

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
    }

    public final void onAnimationReset(AnimatedDrawable2 r1) {
    }

    public final void onAnimationStart(AnimatedDrawable2 r1) {
    }

    public final void onAnimationRepeat(AnimatedDrawable2 r1) {
        if (this.a.d == false) goto L6;
        this.b.stop();
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        LiveDrawerEntranceCommonWidget r0 = this.a;
        List<String> r1 = LiveDrawerEntranceCommonWidget.G;
        r0.getClass();
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
    L7:
        LiveDrawerEntranceCommonWidget.H = false;
        return;
    L5:
        if (r3.getFrameCount() <= 0) goto L7;
        r3.jumpToFrame(0);
        goto L7
    }

    public a(LiveDrawerEntranceCommonWidget r1, Animatable r2) {
        this.a = r1;
        this.b = r2;
    }
}
