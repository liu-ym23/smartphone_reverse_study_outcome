package jd8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v extends AnimatorListenerAdapter {
    public final /* synthetic */ u a;

    public v(u r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        u r3 = this.a;
        r3.d = null;
        r3.c = 255;
        r3.invalidateSelf();
    }
}
