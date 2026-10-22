package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.c0 f2453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2454b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2455m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2456n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2457o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k f2458p;

    public h(k r8, RecyclerView.c0 r10, int r11, View r12, int r13, ViewPropertyAnimator r14) {
        this.f2458p = r8;
        this.f2453a = r10;
        this.f2454b = r11;
        this.f2455m = r12;
        this.f2456n = r13;
        this.f2457o = r14;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        int r10 = this.f2454b;
        View r11 = this.f2455m;
        if (r10 == 0) goto L6;
        r11.setTranslationX(0.0f);
    L6:
        if (this.f2456n == 0) goto L9;
        r11.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        this.f2457o.setListener(null);
        k r10 = this.f2458p;
        RecyclerView.c0 r11 = this.f2453a;
        r10.c(r11);
        r10.f2476p.remove(r11);
        r10.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        this.f2458p.getClass();
    }
}
