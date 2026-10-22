package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ s b;
    public final /* synthetic */ Animatable c;

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        this.b.b.invoke();
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable2");
        this.b.c.invoke();
    }

    public r(s r1, Animatable r2) {
        this.b = r1;
        this.c = r2;
        this.a = -1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "drawable2");
        if (r4 < this.a) goto L5;
    L8:
        this.b.e.invoke(Integer.valueOf(r4), Integer.valueOf(r3.getFrameCount()));
        this.a = r4;
        return;
    L5:
        if (this.b.d == false) goto L7;
        this.c.jumpToFrame(r3.getFrameCount() - 1);
    L7:
        this.c.stop();
        goto L8
    }
}
