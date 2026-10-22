package com.obric.assistant.view.continuespeech;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ u a;

    public /* synthetic */ c(u r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        u r0 = this.a;
        Intrinsics.checkNotNullParameter(r3, "it");
        AudioSpectrumView r1 = r0.b;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r1.setWavePlayProgress(((Float) r4).floatValue());
    }
}
