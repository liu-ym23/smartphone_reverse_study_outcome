package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends BaseAnimationListener {
    public final /* synthetic */ FansClubMVIView.b a;

    public c(FansClubMVIView.b r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        FansClubMVIView r4 = this.a.a;
        r4.o(new eu0.t(r4.q));
    }
}
