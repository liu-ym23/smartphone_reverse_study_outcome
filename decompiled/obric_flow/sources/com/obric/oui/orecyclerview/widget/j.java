package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13835c;

    public /* synthetic */ j(Object r5, int r10) {
        this.f13833a = r10;
        this.f13835c = r5;
        this.f13834b = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        switch(this.f13833a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13834b = true;
        return;
    L6:
        this.f13834b = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f13833a) {
            case 0: goto L9;
            default: goto L5;
        };
    L5:
        if (this.f13834b == true) goto L16;
        ((CircularProgressView) this.f13835c).a();
        return;
    L16:
        return;
    L9:
        if (this.f13834b == false) goto L11;
        this.f13834b = false;
        return;
    L11:
        l r10 = (l) this.f13835c;
        if (((Float) r10.f13866z.getAnimatedValue()).floatValue() != 0.0f) goto L14;
        r10.A = 0;
        r10.f(0);
        return;
    L14:
        r10.A = 2;
        r10.s.invalidate();
    }
}
