package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r12) {
        FrameLayout r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        float r13 = ((Float) r12.getAnimatedValue()).floatValue();
        int r3 = r0.getChildCount();
        int r4 = r3 - 1;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L11;
        int r7 = (int) (((((r4 - r6) - 1) * r1) * 2) + ((r1 * 2) * r13));
        View r8 = r0.getChildAt(r6);
        int r9 = r6 * r1;
        if (r3 <= 3) goto L7;
        r9 = (int) (r9 - (r1 * r13));
    L7:
        r8.setPadding(r7, r9, r7, 0);
        if (r8.getHeight() <= r2) goto L10;
        r8.getLayoutParams().height = r8.getHeight() + ((int) ((r2 - r8.getHeight()) * r13));
        r8.requestLayout();
    L10:
        r6 = r6 + 1;
        goto L3
    }

    public b(DialogAnimationLayout r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
