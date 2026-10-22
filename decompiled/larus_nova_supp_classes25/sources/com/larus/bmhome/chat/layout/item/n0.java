package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 implements Animator.AnimatorListener {
    public final /* synthetic */ ExpertCardBox a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

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
    public final void onAnimationEnd(Animator r3) {
        Boolean r4 = Boolean.valueOf(this.c);
        ExpertCardBox.n(this.a).put(this.b, r4);
        ExpertCardBox.b r5 = this.a.p;
        if (r5 == null) goto L6;
        r5.a = this.c;
        return;
    }

    public n0(ExpertCardBox r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
