package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CodeView a;

    public b(CodeView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        if (r5.getAnimatedFraction() >= 0.5d) goto L5;
        this.a.b.setBackgroundColor(0);
        return;
    L5:
        CodeView r6 = this.a;
        r6.b.setBackgroundColor(r6.d.c);
    }
}
