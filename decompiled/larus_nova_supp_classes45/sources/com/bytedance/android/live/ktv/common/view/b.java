package com.bytedance.android.live.ktv.common.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(HSImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Object r0 = r6.getAnimatedValue();
        if ((r0 instanceof PointF) == true) goto L5;
        r0 = null;
    L5:
        PointF r1 = (PointF) r0;
        if (r1 == null) goto L9;
        this.a.setX(r1.x);
        this.a.setY(r1.y);
        this.a.setRotation(r6.getCurrentPlayTime() % ((long) 360));
        return;
    }
}
