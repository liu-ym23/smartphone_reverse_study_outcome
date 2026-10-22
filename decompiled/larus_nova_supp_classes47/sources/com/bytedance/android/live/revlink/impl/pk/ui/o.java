package com.bytedance.android.live.revlink.impl.pk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends BaseAnimationListener {
    public final /* synthetic */ p a;

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
    }

    public o(p r1) {
        this.a = r1;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "drawable");
        super.onAnimationFrame(r7, r8);
        if (r8 != (r7.getFrameCount() - 1)) goto L11;
        HSImageView r9 = this.a.a.c.findViewById(2131383619);
        if (r9 == null) goto L7;
        r9.setVisibility(4);
    L7:
        HSImageView r10 = this.a.a.c.findViewById(2131383619);
        if (r10 == null) goto L14;
        r10.setController(null);
        return;
    L14:
        return;
    L11:
        if (r8 != (r7.getFrameCount() - 6)) goto L16;
        PkRandomView r12 = this.a.a;
        int r13 = PkRandomView.j;
        r12.getClass();
        AnimatorSet r14 = new AnimatorSet();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 1.1f});
        r3.setDuration(150);
        r3.addUpdateListener(new q(r12));
        Unit r4 = Unit.INSTANCE;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.1f, 1.0f});
        r0.setDuration(250);
        r0.addUpdateListener(new r(r12));
        r14.playSequentially(new Animator[]{r3, r0});
        r12.h = r14;
        r14.start();
        return;
    }
}
