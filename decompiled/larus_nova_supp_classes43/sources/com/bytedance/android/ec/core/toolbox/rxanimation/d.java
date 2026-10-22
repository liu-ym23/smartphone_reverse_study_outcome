package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    public d(Function1 r1, Function0 r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        this.a.invoke(r10.getAnimatedValue());
    }
}
