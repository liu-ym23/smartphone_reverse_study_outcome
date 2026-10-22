package com.bytedance.android.live.liveinteract.videotalk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 extends AnimatorListenerAdapter {
    public final /* synthetic */ k0 a;

    public j0(k0 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        super.onAnimationStart(r5);
        k0 r6 = this.a;
        View r0 = r6.g;
        float[] r1 = new float[2];
        if (r6.B == false) goto L5;
        float r2 = 1.0f;
    L6:
        r1[0] = r2;
        r1[1] = 0.0f;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0, "alpha", r1);
        r3.setDuration(300);
        ((ArrayList) this.a.i).add(r3);
        Unit r4 = Unit.INSTANCE;
        r6.R = r3;
        ObjectAnimator r7 = this.a.R;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgAlphaGone");
    L9:
        r7.start();
        k0 r8 = this.a;
        if (r8.B == false) goto L13;
        r8.q.start();
        return;
    L13:
        return;
    L5:
        r2 = 0.15f;
        goto L6
    }
}
