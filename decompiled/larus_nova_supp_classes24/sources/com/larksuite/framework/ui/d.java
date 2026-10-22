package com.larksuite.framework.ui;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewTransitionContainer<View> a;

    public d(ViewTransitionContainer<View> r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.invalidate();
    }
}
