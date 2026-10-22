package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import eu0.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends BaseAnimationListener {
    public final /* synthetic */ w a;

    public v(w r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        SingleVipMVIView r4 = this.a.a;
        r4.o(new g0(r4.s));
    }
}
