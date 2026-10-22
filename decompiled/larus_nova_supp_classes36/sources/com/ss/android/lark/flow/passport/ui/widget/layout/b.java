package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ CommonContainerLayout a;
    public final /* synthetic */ boolean b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Function1<Boolean, Unit> r3 = this.a.getOnImeChangedEndListener();
        if (r3 == null) goto L6;
        r3.invoke(Boolean.valueOf(this.b));
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Function1<Boolean, Unit> r3 = this.a.getOnImeChangedEndListener();
        if (r3 == null) goto L6;
        r3.invoke(Boolean.valueOf(this.b));
        return;
    }

    public b(CommonContainerLayout r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
