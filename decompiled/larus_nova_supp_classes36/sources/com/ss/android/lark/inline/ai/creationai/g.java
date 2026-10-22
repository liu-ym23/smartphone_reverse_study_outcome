package com.ss.android.lark.inline.ai.creationai;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ View b;
    public final /* synthetic */ CreationAIDragView c;

    public g(float r1, View r2, CreationAIDragView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "translationY");
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        float r6 = ((Float) r5).floatValue();
        float r0 = this.a;
        float r1 = 0.0f;
        if (r0 <= 0.0f) goto L6;
        r1 = 1 - (r6 / r0);
    L6:
        this.b.setAlpha(r1);
        Log.i("CreationAIDragView", "show, syncStatusBarColor = " + this.c.Y);
        CreationAIDragView r7 = this.c;
        if (r7.Y == false) goto L10;
        r7.q(r1);
        return;
    }
}
