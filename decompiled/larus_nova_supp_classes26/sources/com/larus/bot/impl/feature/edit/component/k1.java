package com.larus.bot.impl.feature.edit.component;

import android.animation.Animator;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k1 implements Animator.AnimatorListener {
    public final /* synthetic */ LarusPageBotEditBinding a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public k1(LarusPageBotEditBinding r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.m.setAlpha(0.0f);
        this.a.m.setVisibility(0);
        this.a.l.setAlpha(0.3f);
    }
}
