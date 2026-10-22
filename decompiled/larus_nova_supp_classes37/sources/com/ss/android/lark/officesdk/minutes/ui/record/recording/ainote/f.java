package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public f(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        MmAINotePanelAnimator r0 = this.a;
        int r1 = r0.q();
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        r0.g(r1, ((Float) r5).floatValue());
    }
}
