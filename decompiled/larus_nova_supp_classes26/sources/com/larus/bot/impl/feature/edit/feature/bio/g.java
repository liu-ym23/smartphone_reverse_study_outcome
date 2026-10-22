package com.larus.bot.impl.feature.edit.feature.bio;

import android.animation.Animator;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements Animator.AnimatorListener {
    public final /* synthetic */ f a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public g(f r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        AppCompatEditText r4 = this.a.a.b;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L7;
        r0.height = -2;
        r4.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
