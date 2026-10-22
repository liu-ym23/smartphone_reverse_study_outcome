package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ HSImageView a;

    public e(HSImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        PointF r5 = (PointF) r4;
        this.a.setX(r5.x);
        this.a.setY(r5.y);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
