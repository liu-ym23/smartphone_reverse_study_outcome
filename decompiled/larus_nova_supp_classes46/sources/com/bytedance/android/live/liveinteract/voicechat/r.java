package com.bytedance.android.live.liveinteract.voicechat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ s a;

    public r(s r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r7) {
        Intrinsics.checkNotNullParameter(r7, "animation");
        super.onAnimationStart(r7);
        s r8 = this.a;
        View r0 = r8.g;
        float[] r2 = new float[2];
        if (r8.B == false) goto L5;
        float r3 = 1.0f;
    L6:
        r2[0] = r3;
        r2[1] = 0.0f;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "alpha", r2);
        r1.setDuration(300);
        ((ArrayList) this.a.i).add(r1);
        Unit r4 = Unit.INSTANCE;
        r8.R = r1;
        s r9 = this.a;
        if (r9.C.getVisibility() != 0) goto L9;
        TextView r5 = this.a.C;
    L10:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{0.0f, 1.0f});
        r6.setDuration(300);
        ((ArrayList) this.a.i).add(r6);
        r9.S = r6;
        ObjectAnimator r10 = this.a.R;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("buttonBgAlphaGone");
    L13:
        r10.start();
        ObjectAnimator r11 = this.a.S;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("seatInfoAlphaShow");
    L16:
        r11.start();
        s r12 = this.a;
        if (r12.B == false) goto L20;
        r12.q.start();
        return;
    L20:
        return;
    L9:
        r5 = this.a.D;
        goto L10
    L5:
        r3 = 0.15f;
        goto L6
    }
}
