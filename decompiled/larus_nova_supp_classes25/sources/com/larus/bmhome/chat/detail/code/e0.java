package com.larus.bmhome.chat.detail.code;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.widget.TextView;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements Animator.AnimatorListener {
    public final /* synthetic */ CodeBlockDetailFragment a;
    public final /* synthetic */ ValueAnimator b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusFragmentCodeBlockDetailBinding r3 = this.a.C;
        if (r3 == null) goto L8;
        TextView r4 = r3.h;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        if (Intrinsics.areEqual(this.a.V, this.b) == false) goto L11;
        this.a.V = null;
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusFragmentCodeBlockDetailBinding r3 = this.a.C;
        if (r3 == null) goto L8;
        TextView r4 = r3.h;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    L9:
        return;
    }

    public e0(CodeBlockDetailFragment r1, ValueAnimator r2) {
        this.a = r1;
        this.b = r2;
    }
}
