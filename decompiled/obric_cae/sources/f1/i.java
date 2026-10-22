package f1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f7283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f7284b;

    public i(h r8, n.b r10) {
        this.f7284b = r8;
        this.f7283a = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        this.f7283a.remove(r8);
        this.f7284b.f7274w.remove(r8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        this.f7284b.f7274w.add(r8);
    }
}
