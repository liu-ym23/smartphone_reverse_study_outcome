package com.larus.avlink.simulInterpret.page.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 extends AnimatorListenerAdapter {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ SimultaneousInterpretFragment b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.element == false) goto L5;
        return;
    L5:
        final SimultaneousInterpretFragment r4 = this.b;
        LayoutFragmentBinding r0 = r4.l;
        if (r0 == null) goto L11;
        ConstraintLayout r1 = r0.b;
        if (r1 == null) goto L12;
        r1.post(new f0(r4));
        return;
    L12:
        return;
    }

    public g0(Ref.BooleanRef r1, SimultaneousInterpretFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
