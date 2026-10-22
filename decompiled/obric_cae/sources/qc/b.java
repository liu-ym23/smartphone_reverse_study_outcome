package qc;

import android.animation.ValueAnimator;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f11292a;

    public b(c r8) {
        this.f11292a = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        i.f(r8, "animator");
        Object r10 = r8.getAnimatedValue();
        if (r10 == null) goto L7;
        float r11 = ((Float) r10).floatValue();
        c r12 = this.f11292a;
        r12.f11293a = r11;
        r12.b("release_anim", r12.f11293a);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
