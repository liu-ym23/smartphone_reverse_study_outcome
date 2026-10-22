package com.obric.oui.calendar;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f12252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f12254c;

    public c0(d0 r5, CharSequence r10, int r11) {
        this.f12254c = r5;
        this.f12252a = r10;
        this.f12253b = r11;
    }

    @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        d0 r10 = this.f12254c;
        r10.b(r10.f12261a, 0);
        r10.f12261a.setAlpha(1.0f);
    }

    @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        d0 r10 = this.f12254c;
        r10.f12261a.setText(this.f12252a);
        int r11 = this.f12253b;
        TextView r12 = r10.f12261a;
        r10.b(r12, r11);
        ViewPropertyAnimator r13 = r12.animate();
        if (r10.g != 1) goto L5;
        r13.translationX(0.0f);
    L6:
        r13.alpha(1.0f).setDuration(r10.d).setInterpolator(r10.f).setListener(new a()).start();
        return;
    L5:
        r13.translationY(0.0f);
        goto L6
    }
}
