package com.larus.extension.summary_card.impl.cell;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements Animator.AnimatorListener {
    public final /* synthetic */ SummaryCardBox a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public p(SummaryCardBox r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.a.x;
        if (r3 == null) goto L5;
        e1.o(r3);
    L5:
        View r4 = this.a.v;
        if (r4 == null) goto L8;
        e1.o(r4);
    L8:
        TextView r5 = this.a.y;
        if (r5 == null) goto L11;
        e1.o(r5);
    L11:
        MaxHeightRelativeLayout r6 = this.a.u;
        if (r6 == null) goto L15;
        r6.setAlpha(1.0f);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.a.x;
        if (r3 == null) goto L5;
        e1.o(r3);
    L5:
        View r4 = this.a.v;
        if (r4 == null) goto L8;
        e1.o(r4);
    L8:
        TextView r5 = this.a.y;
        if (r5 == null) goto L11;
        e1.o(r5);
    L11:
        MaxHeightRelativeLayout r6 = this.a.u;
        if (r6 == null) goto L15;
        r6.setAlpha(1.0f);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.a.x;
        if (r3 == null) goto L5;
        r3.setAlpha(1.0f);
    L5:
        MaxHeightRelativeLayout r4 = this.a.u;
        if (r4 == null) goto L9;
        r4.setAlpha(0.0f);
        return;
    }
}
