package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.c0 f2449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2450b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k f2452n;

    public g(View r8, ViewPropertyAnimator r10, k r11, RecyclerView.c0 r12) {
        this.f2452n = r11;
        this.f2449a = r12;
        this.f2450b = r8;
        this.f2451m = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        this.f2450b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        this.f2451m.setListener(null);
        k r10 = this.f2452n;
        RecyclerView.c0 r11 = this.f2449a;
        r10.c(r11);
        r10.f2475o.remove(r11);
        r10.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        this.f2452n.getClass();
    }
}
