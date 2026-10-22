package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ int b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r14) {
        FrameLayout r0 = this.a;
        int r1 = this.b;
        float r15 = ((Float) r14.getAnimatedValue()).floatValue();
        int r2 = r0.getChildCount();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L35;
        int r5 = r2 - 1;
        int r6 = r5 - r4;
        View r7 = r0.getChildAt(r6);
        if (r7 == null) goto L44;
        jpc.a r8 = (jpc.a) r7.getTag();
        if (r8 == null) goto L45;
        int r9 = r8.b;
        if (r6 >= r5) goto L13;
        int r10 = r5 - r6;
    L15:
        if (r10 < 3) goto L18;
        r10 = 3;
    L18:
        int r11 = 2;
        int r12 = (int) (r9 + ((((r10 * r1) * 2) - r9) * r15));
        int r13 = r8.c;
        if (r6 >= r5) goto L21;
        int r16 = r6;
    L22:
        if (r16 >= 2) goto L24;
        r11 = r16;
    L24:
        r7.setPadding(r12, (int) (r13 + (((r11 * r1) - r13) * r15)), r12, 0);
        if (r6 != r5) goto L34;
        if (r8.a <= r7.getHeight()) goto L30;
        r7.getLayoutParams().height = r7.getHeight() + ((int) ((r8.a - r7.getHeight()) * r15));
        r7.requestLayout();
        goto L34
    L30:
        if (r8.a != 0) goto L34;
        if (r7.getLayoutParams().height == (-2)) goto L34;
        r7.getLayoutParams().height = -2;
        r7.requestLayout();
    L34:
        r4 = r4 + 1;
        goto L3
    L21:
        r16 = r5;
        goto L22
    L13:
        r10 = 0;
        goto L15
    L45:
        return;
    L44:
        return;
    }

    public d(DialogAnimationLayout r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
