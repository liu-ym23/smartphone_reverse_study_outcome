package com.ss.android.lark.inline.ai.creationai;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CreationAIDragView c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;

    public e(int r1, int r2, CreationAIDragView r3, float r4, float r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
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
        if (this.c.j != null) goto L5;
        int r4 = -2;
    L6:
        r3.height = r4;
        r2.setLayoutParams(r3);
        float r8 = this.d;
        this.c.c.setTranslationY(r8 + ((this.e - r8) * r7));
        return;
    L5:
        r4 = (int) r1;
        goto L6
    }
}
