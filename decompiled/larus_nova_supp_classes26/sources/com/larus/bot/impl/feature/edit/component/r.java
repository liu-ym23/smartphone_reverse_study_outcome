package com.larus.bot.impl.feature.edit.component;

import android.animation.Animator;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r implements Animator.AnimatorListener {
    public final /* synthetic */ LarusPageBotEditBinding a;
    public final /* synthetic */ BotCreateViewModel b;
    public final /* synthetic */ BotCreateDescPolishComponent c;

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
        String r2 = this.b.getBotCreateTrace().d();
        String r3 = this.b.getBotCreateTrace().c();
        Boolean r4 = Boolean.valueOf(this.b.getBotCreateTrace().j());
        Boolean r5 = Boolean.valueOf(this.b.getBotCreateTrace().k());
        Integer r6 = Integer.valueOf(this.b.getBotCreateTrace().m());
        ru8.a r11 = this.c.F2();
        if (r11 == null) goto L5;
        String r12 = r11.getCurrentPage();
    L6:
        o3.h("sp_polish", r2, r3, r4, r5, r6, r12, 384);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public r(LarusPageBotEditBinding r1, BotCreateViewModel r2, BotCreateDescPolishComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
