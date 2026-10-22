package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LivePortraitInputDialogV3 a;
    public final /* synthetic */ ViewGroup.LayoutParams b;

    public i(LivePortraitInputDialogV3 r1, ViewGroup.LayoutParams r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        ViewGroup.LayoutParams r0 = this.b;
        if (r0 == null) goto L9;
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L8;
        r0.height = ((Integer) r4).intValue();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L9:
        FrameLayout r5 = this.a.F;
        if (r5 == null) goto L12;
        r5.setLayoutParams(this.b);
    L12:
        FrameLayout r1 = this.a.w;
        if (r1 == null) goto L15;
        int r2 = r1.getHeight();
    L16:
        i1 r6 = new i1(r2, true);
        xs2.b.a().post(r6);
        return;
    L15:
        r2 = 0;
        goto L16
    }
}
