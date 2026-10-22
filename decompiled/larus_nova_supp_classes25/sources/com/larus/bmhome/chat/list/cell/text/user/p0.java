package com.larus.bmhome.chat.list.cell.text.user;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements Animator.AnimatorListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewGroup.LayoutParams c;
    public final /* synthetic */ UserTextCell d;
    public final /* synthetic */ ViewGroup e;
    public final /* synthetic */ View f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.removeView(this.b);
        ViewGroup.LayoutParams r3 = this.c;
        r3.width = -2;
        r3.height = -2;
        this.d.V(true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        this.e.addView(this.f, 0, new ViewGroup.LayoutParams(this.g, this.h));
        this.d.V(false);
    }

    public p0(ViewGroup r1, View r2, ViewGroup.LayoutParams r3, UserTextCell r4, ViewGroup r5, View r6, int r7, int r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
