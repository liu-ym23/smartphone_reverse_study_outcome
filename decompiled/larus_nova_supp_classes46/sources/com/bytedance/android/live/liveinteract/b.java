package com.bytedance.android.live.liveinteract;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends BaseAnimationListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Animatable b;

    public b(int r1, Animatable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super.onAnimationFrame(r2, r3);
        if (r3 != (this.a - 1)) goto L6;
        this.b.stop();
        return;
    }
}
