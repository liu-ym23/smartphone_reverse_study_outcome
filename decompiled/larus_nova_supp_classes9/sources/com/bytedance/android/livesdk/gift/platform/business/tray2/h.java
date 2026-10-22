package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

    public h(MatchRoomGiftTrayAnimationView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.widget.FrameLayout, com.bytedance.android.livesdk.gift.platform.business.tray2.MatchRoomGiftTrayAnimationView] */
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ViewGroup.MarginLayoutParams r0 = this.a.i;
        if (r0 == null) goto L9;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L8;
        r0.topMargin = ((Integer) r3).intValue();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L9:
        ?? r4 = this.a;
        r4.setLayoutParams(r4.i);
    }
}
