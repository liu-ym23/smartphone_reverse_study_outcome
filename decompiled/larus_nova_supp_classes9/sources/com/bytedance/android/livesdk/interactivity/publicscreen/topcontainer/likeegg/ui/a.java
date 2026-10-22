package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LikeEggView a;

    public a(LikeEggView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Integer) == true) goto L5;
        r3 = null;
    L5:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
        LikeEggProgressBar r0 = this.a.a;
        if (r0 == null) goto L12;
        r0.setProgress(r5);
        return;
    L12:
        return;
    }
}
