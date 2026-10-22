package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public k(View r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "va");
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Integer) == true) goto L5;
        r3 = null;
    L5:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
        s.a(this.a, r5);
        return;
    }
}
