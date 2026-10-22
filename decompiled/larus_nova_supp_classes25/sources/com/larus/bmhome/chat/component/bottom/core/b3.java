package com.larus.bmhome.chat.component.bottom.core;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LarusWidgetInputBinding a;

    public /* synthetic */ b3(LarusWidgetInputBinding r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        LarusWidgetInputBinding r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r3, "it");
        FrameLayout r2 = r0.T;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setAlpha(((Float) r4).floatValue());
    }
}
