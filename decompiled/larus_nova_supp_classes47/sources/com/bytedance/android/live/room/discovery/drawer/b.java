package com.bytedance.android.live.room.discovery.drawer;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements AnimationListener {
    public final /* synthetic */ NewLiveDrawerEntranceWidget a;
    public final /* synthetic */ Animatable b;

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
    }

    public final void onAnimationReset(AnimatedDrawable2 r1) {
    }

    public final void onAnimationStart(AnimatedDrawable2 r1) {
    }

    public final void onAnimationRepeat(AnimatedDrawable2 r1) {
        if (this.a.r == false) goto L6;
        this.b.stop();
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r4) {
        NewLiveDrawerEntranceWidget r0 = this.a;
        List<String> r1 = NewLiveDrawerEntranceWidget.y;
        r0.getClass();
        if ((r4 instanceof AnimatedDrawable2) == false) goto L8;
        if (r4.getFrameCount() <= 0) goto L8;
        r4.jumpToFrame(0);
    L8:
        if (r0.Gq() == false) goto L11;
        NewLiveDrawerEntranceWidget.z = false;
        return;
    }

    public b(NewLiveDrawerEntranceWidget r1, Animatable r2) {
        this.a = r1;
        this.b = r2;
    }
}
