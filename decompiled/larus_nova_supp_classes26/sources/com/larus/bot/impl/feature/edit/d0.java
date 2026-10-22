package com.larus.bot.impl.feature.edit;

import android.animation.Animator;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 implements Animator.AnimatorListener {
    public final /* synthetic */ EditText a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public d0(AppCompatEditText r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        EditText r4 = this.a;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L7;
        r0.height = -2;
        r4.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
