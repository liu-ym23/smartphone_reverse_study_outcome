package com.bytedance.android.livesdk.interactivity.quickcomment;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;

    public e(ValueAnimator r1, View r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ViewGroup.LayoutParams r5 = this.b.getLayoutParams();
        r5.height = (int) (this.c * (1 - this.a.getAnimatedFraction()));
        this.b.setLayoutParams(r5);
    }
}
