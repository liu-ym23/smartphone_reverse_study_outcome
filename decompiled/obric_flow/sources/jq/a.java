package jq;

import android.animation.Animator;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f18418c;

    public /* synthetic */ a(Object r5, float r10, int r11) {
        this.f18416a = r11;
        this.f18417b = r5;
        this.f18418c = r10;
    }

    private final void a(Animator r5) {
    }

    private final void b(Animator r5) {
    }

    private final void c(Animator r5) {
    }

    private final void d(Animator r5) {
    }

    private final void e(Animator r5) {
    }

    private final void f(Animator r5) {
    }

    private final void g(Animator r5) {
    }

    private final void h(Animator r5) {
    }

    private final void i(Animator r5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        int r10 = this.f18416a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f18416a) {
            case 0: goto L6;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        ((p) this.f18417b).t(this.f18418c, true);
        return;
    L6:
        float r10 = this.f18418c * 0.2f;
        ((b) this.f18417b).f18420a.setAlpha(r10);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        int r10 = this.f18416a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f18416a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        float r10 = this.f18418c * 0.2f;
        ((b) this.f18417b).f18420a.setAlpha(r10);
        return;
    }
}
