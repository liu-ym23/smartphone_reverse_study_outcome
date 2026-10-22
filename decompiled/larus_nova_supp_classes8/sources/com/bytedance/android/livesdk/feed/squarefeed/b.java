package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseOpenFeedFragment a;

    public b(BaseOpenFeedFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        InterceptTouchLayout r0 = this.a.T90();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r1;
        if (r3 == null) goto L17;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L16;
        r3.topMargin = ((Integer) r5).intValue();
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L17:
        InterceptTouchLayout r6 = this.a.T90();
        if (r6 == null) goto L21;
        r6.requestLayout();
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
