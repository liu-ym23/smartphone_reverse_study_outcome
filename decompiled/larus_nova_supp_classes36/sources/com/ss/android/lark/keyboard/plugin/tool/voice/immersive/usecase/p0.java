package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;

    public p0(View r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "fraction");
        View r0 = this.a;
        float r1 = this.b;
        r0.setTranslationY(r1 - (r4.getAnimatedFraction() * r1));
        this.a.setAlpha(r4.getAnimatedFraction());
    }
}
