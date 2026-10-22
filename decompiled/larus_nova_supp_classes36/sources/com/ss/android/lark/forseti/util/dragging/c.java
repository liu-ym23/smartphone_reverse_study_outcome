package com.ss.android.lark.forseti.util.dragging;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ a.InterfaceC0068a a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public c(a.InterfaceC0068a r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        a.InterfaceC0068a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationEnd(r2);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        a.InterfaceC0068a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationStart(r2);
        return;
    }
}
