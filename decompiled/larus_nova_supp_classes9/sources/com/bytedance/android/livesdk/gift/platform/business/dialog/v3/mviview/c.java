package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftMVIDetailView a;
    public final /* synthetic */ ViewGroup.LayoutParams b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public c(ObjectAnimator r1, GiftMVIDetailView r2, ViewGroup.LayoutParams r3, int r4, int r5, View r6) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L7;
        float r6 = ((Float) r5).floatValue();
        ViewGroup.LayoutParams r0 = this.b;
        int r1 = this.c;
        int r2 = this.d;
        r0.width = (int) ((r6 * (r1 - r2)) + r2);
        this.a.x().setLayoutParams(this.b);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
