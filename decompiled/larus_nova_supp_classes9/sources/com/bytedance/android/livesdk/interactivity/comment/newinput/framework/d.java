package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.ValueAnimator;
import android.widget.HorizontalScrollView;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ b b;

    public d(ValueAnimator r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        HorizontalScrollView r3 = this.b.m;
        Object r0 = this.a.getAnimatedValue();
        if (r0 == null) goto L7;
        a1.p(r3, ((Integer) r0).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
