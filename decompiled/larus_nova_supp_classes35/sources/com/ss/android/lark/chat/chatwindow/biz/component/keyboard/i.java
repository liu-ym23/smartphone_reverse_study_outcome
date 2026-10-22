package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Animator.AnimatorListener {
    public final /* synthetic */ MessageListAnimationContainer a;
    public final /* synthetic */ RecyclerView b;

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
    public final void onAnimationEnd(Animator r2) {
        this.a.setTranslationY(0.0f);
        this.b.setTranslationY(0.0f);
        this.a.setAnimType(MessageListAnimationContainer.AnimType.None);
    }

    public i(MessageListAnimationContainer r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
