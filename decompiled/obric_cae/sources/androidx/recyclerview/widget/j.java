package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f2463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2464b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k f2466n;

    public j(k r8, k.a r10, ViewPropertyAnimator r11, View r12) {
        this.f2466n = r8;
        this.f2463a = r10;
        this.f2464b = r11;
        this.f2465m = r12;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        this.f2464b.setListener(null);
        View r10 = this.f2465m;
        r10.setAlpha(1.0f);
        r10.setTranslationX(0.0f);
        r10.setTranslationY(0.0f);
        k.a r11 = this.f2463a;
        RecyclerView.c0 r12 = r11.f2480b;
        k r13 = this.f2466n;
        r13.c(r12);
        r13.f2478r.remove(r11.f2480b);
        r13.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        RecyclerView.c0 r10 = this.f2463a.f2480b;
        this.f2466n.getClass();
    }
}
