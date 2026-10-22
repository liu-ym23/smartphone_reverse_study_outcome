package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MmAINotePanelAnimator a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;

    public h(MmAINotePanelAnimator r1, int r2, int r3, int r4, int r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        Object r7 = r6.getAnimatedValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Float");
        float r8 = ((Float) r7).floatValue();
        MmAINotePanelAnimator r0 = this.a;
        int r1 = this.b;
        int r2 = MathKt.roundToInt(r1 + ((this.c - r1) * r8));
        int r3 = this.d;
        r0.f(r2, MathKt.roundToInt(r3 + ((this.e - r3) * r8)), this.f, false);
    }
}
