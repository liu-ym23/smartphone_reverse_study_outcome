package com.larus.extension.summary_card.impl.cell;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements Animator.AnimatorListener {
    public final /* synthetic */ SummaryCardBox a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public t(SummaryCardBox r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        View r4 = this.a.x;
        if (r4 == null) goto L5;
        e1.o(r4);
    L5:
        MaxHeightRelativeLayout r5 = this.a.u;
        if (r5 == null) goto L8;
        r5.setAlpha(1.0f);
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
        View r4 = this.a.x;
        if (r4 == null) goto L5;
        e1.o(r4);
    L5:
        ConstraintLayout r5 = this.a.z;
        if (r5 == null) goto L12;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L11;
        r0.height = -2;
        r5.setLayoutParams(r0);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.a.x;
        if (r3 == null) goto L5;
        r3.setAlpha(1.0f);
    L5:
        MaxHeightRelativeLayout r4 = this.a.u;
        if (r4 == null) goto L8;
        e1.x(r4);
    L8:
        MaxHeightRelativeLayout r5 = this.a.u;
        if (r5 == null) goto L12;
        r5.setAlpha(0.0f);
        return;
    }
}
