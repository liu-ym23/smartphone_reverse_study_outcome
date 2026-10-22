package androidx.fragment.app;

import android.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f1948a;

    public d0(Runnable r8) {
        this.f1948a = r8;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r8) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r8) {
        this.f1948a.run();
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r8) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r8) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r8) {
    }
}
