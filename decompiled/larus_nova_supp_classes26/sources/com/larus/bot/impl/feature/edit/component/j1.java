package com.larus.bot.impl.feature.edit.component;

import android.animation.Animator;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j1 implements Animator.AnimatorListener {
    public final /* synthetic */ LarusPageBotEditBinding a;
    public final /* synthetic */ BotUpdateViewModel b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        this.a.m.setVisibility(8);
        o3.h("sp_polish", null, null, Boolean.FALSE, Boolean.valueOf(this.b.hasUsedPolishDesc()), Integer.valueOf(this.b.getPolishCnt()), "bot_description_modify_page", 390);
    }

    public j1(LarusPageBotEditBinding r1, BotUpdateViewModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
