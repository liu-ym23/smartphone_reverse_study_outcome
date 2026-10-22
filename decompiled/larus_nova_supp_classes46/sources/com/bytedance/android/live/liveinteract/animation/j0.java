package com.bytedance.android.live.liveinteract.animation;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 extends BaseAnimationListener {
    public j0() {
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
