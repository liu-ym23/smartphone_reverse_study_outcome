package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {
    public float a;
    public final /* synthetic */ View b;
    public final /* synthetic */ List c;
    public final /* synthetic */ View d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Object r5 = r4.getAnimatedValue();
        if ((r5 instanceof Float) == true) goto L5;
        r5 = null;
    L5:
        Float r6 = (Float) r5;
        if (r6 == null) goto L9;
        float r7 = r6.floatValue();
        View r0 = this.d;
        r0.setTranslationX(r0.getTranslationX() - (r7 - this.a));
        this.a = r7;
        return;
    }

    public u(View r1, List r2, View r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
