package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseAnimationListener {
    public final /* synthetic */ f.b a;

    public g(f.b r1) {
        this.a = r1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super.onAnimationFrame(r2, r3);
        if (r3 != (r2.getFrameCount() - 1)) goto L11;
        HSImageView r4 = this.a.a.a(2131389454);
        if (r4 == null) goto L7;
        r4.setVisibility(8);
    L7:
        HSImageView r5 = this.a.a.a(2131389454);
        if (r5 == null) goto L12;
        r5.setController(null);
        return;
    L12:
        return;
    }
}
