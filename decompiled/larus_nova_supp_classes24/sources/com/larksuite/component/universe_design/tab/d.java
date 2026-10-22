package com.larksuite.component.universe_design.tab;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ UDTabLayout.c a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ValueAnimator d;

    public d(UDTabLayout.c r1, int r2, int r3, ValueAnimator r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        UDTabLayout.c r8 = this.a;
        int r0 = this.b;
        int r1 = this.c;
        float r2 = this.d.getAnimatedFraction();
        Drawable r3 = r8.a;
        if (r3 == null) goto L5;
        UDTabLayout r4 = r8.j;
        c r5 = r8.f;
        View r6 = r8.getChildAt(r0);
        View r9 = r8.getChildAt(r1);
        r5.getClass();
        c.c(r4, r6, r9, r2, r3);
        r8.postInvalidateOnAnimation();
    L5:
        UDTabLayout.c r10 = this.a;
        r10.e = this.d.getAnimatedFraction();
    }
}
