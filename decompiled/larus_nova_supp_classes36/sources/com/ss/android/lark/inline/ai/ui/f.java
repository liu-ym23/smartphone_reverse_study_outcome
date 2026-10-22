package com.ss.android.lark.inline.ai.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ InlineAIDragView c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ float f;

    public f(int r1, int r2, InlineAIDragView r3, int r4, int r5, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        Object r6 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
        float r7 = ((Float) r6).floatValue();
        int r0 = this.a;
        float r1 = r0 + ((this.b - r0) * r7);
        ViewGroup r2 = this.c.c;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (this.c.i != null) goto L5;
        int r4 = -2;
    L6:
        r3.height = r4;
        r2.setLayoutParams(r3);
        int r8 = this.d;
        float r9 = r8 + ((this.e - r8) * r7);
        ViewGroup r10 = this.c.c;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.bottomMargin = (int) r9;
        r10.setLayoutParams(r12);
        float r13 = this.f;
        this.c.c.setTranslationY(r13 + ((0.0f - r13) * r7));
        return;
    L5:
        r4 = (int) r1;
        goto L6
    }
}
