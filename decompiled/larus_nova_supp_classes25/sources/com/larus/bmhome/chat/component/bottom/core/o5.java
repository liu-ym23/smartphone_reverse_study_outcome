package com.larus.bmhome.chat.component.bottom.core;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ EditText a;

    public /* synthetic */ o5(EditText r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        EditText r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L7;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = ((Integer) r5).intValue();
        r0.setLayoutParams(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
