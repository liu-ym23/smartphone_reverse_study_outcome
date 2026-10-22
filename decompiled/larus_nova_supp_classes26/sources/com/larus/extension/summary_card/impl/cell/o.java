package com.larus.extension.summary_card.impl.cell;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements Animator.AnimatorListener {
    public final /* synthetic */ SummaryCardBox a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public o(SummaryCardBox r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        TextView r4 = this.a.y;
        if (r4 == null) goto L5;
        e1.o(r4);
    L5:
        View r5 = this.a.v;
        if (r5 == null) goto L8;
        e1.o(r5);
    L8:
        ConstraintLayout r6 = this.a.z;
        if (r6 == null) goto L15;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L14;
        r0.height = -2;
        r6.setLayoutParams(r0);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        TextView r4 = this.a.y;
        if (r4 == null) goto L5;
        e1.o(r4);
    L5:
        View r5 = this.a.v;
        if (r5 == null) goto L8;
        e1.o(r5);
    L8:
        ConstraintLayout r6 = this.a.z;
        if (r6 == null) goto L15;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L14;
        r0.height = -2;
        r6.setLayoutParams(r0);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.y;
        if (r3 == null) goto L5;
        e1.o(r3);
    L5:
        View r4 = this.a.v;
        if (r4 == null) goto L9;
        e1.o(r4);
        return;
    }
}
