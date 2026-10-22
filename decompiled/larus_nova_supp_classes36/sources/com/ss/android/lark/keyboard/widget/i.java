package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements Animator.AnimatorListener {
    public final /* synthetic */ Animator.AnimatorListener a;
    public final /* synthetic */ DragShrinkLayout b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        DragShrinkLayout.a r2 = this.b.e;
        if (r2 == null) goto L6;
        r2.d();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        DragShrinkLayout.a r0 = this.b.e;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        Animator.AnimatorListener r1 = this.a;
        if (r1 == null) goto L9;
        r1.onAnimationEnd(r2);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        DragShrinkLayout.a r0 = this.b.e;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        Animator.AnimatorListener r1 = this.a;
        if (r1 == null) goto L9;
        r1.onAnimationStart(r2);
        return;
    }

    public i(DragShrinkLayout r1, RichTextInputExpandPlugin.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
