package com.larus.canvas.feature.component.logic.provider;

import android.animation.Animator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateBottomProviderBinding;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements Animator.AnimatorListener {
    public final /* synthetic */ i a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public g(i r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusLayoutCanvasGenerateBottomProviderBinding r3 = this.a.g;
        if (r3 == null) goto L8;
        ConstraintLayout r4 = r3.b;
        if (r4 == null) goto L9;
        e1.q(r4);
        return;
    L9:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusLayoutCanvasGenerateBottomProviderBinding r3 = this.a.g;
        if (r3 == null) goto L8;
        ConstraintLayout r4 = r3.b;
        if (r4 == null) goto L9;
        r4.setAlpha(1.0f);
        return;
    L9:
        return;
    }
}
