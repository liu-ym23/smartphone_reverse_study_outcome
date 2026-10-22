package com.suite.lark.platform.component.widget_biz_translate;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TranslateWrapperLayout a;

    public e(TranslateWrapperLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        float r4 = ((Float) r3).floatValue();
        this.a.setTranslationY(r4);
        this.a.getClass();
    }
}
