package rjb;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Animation.AnimationListener {
    public final /* synthetic */ ViewParent a;
    public final /* synthetic */ c b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        ViewParent r3 = this.a;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r3).removeView(this.b.i);
    }

    public d(ViewParent r1, c r2) {
        this.a = r1;
        this.b = r2;
    }
}
