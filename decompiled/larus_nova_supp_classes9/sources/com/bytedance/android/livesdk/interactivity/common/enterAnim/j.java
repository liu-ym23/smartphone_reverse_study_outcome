package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.ValueAnimator;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WindScreenRebirthAnimTrayView a;

    public j(WindScreenRebirthAnimTrayView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        a1.p(this.a.c, (int) r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
