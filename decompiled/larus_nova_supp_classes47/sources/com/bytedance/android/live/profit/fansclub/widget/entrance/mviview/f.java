package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends BaseAnimationListener {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        FollowMVIView r4 = this.a.a;
        r4.o(new eu0.a0(r4.r));
    }
}
