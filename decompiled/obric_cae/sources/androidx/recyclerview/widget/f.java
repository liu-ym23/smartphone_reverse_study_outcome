package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.c0 f2445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2446b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k f2448n;

    public f(View r8, ViewPropertyAnimator r10, k r11, RecyclerView.c0 r12) {
        this.f2448n = r11;
        this.f2445a = r12;
        this.f2446b = r10;
        this.f2447m = r8;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        this.f2446b.setListener(null);
        this.f2447m.setAlpha(1.0f);
        k r10 = this.f2448n;
        RecyclerView.c0 r11 = this.f2445a;
        r10.c(r11);
        r10.f2477q.remove(r11);
        r10.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        this.f2448n.getClass();
    }
}
