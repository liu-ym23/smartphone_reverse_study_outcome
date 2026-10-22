package com.larus.bmhome.chat.component.bottom.core;

import android.animation.Animator;
import android.widget.EditText;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CoreInputComponent$l implements Animator.AnimatorListener {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ LarusWidgetInputBinding c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        com.larus.utils.e1.o(this.c.T);
        this.c.T.setAlpha(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        com.larus.utils.e1.o(this.c.T);
        this.c.T.setAlpha(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        CoreInputComponent r4 = this.a;
        EditText r0 = this.b;
        int r1 = CoreInputComponent.d3;
        r4.getClass();
        if (CoreInputComponent.d5(r0) != 1) goto L6;
        this.a.z3();
        return;
    }

    public CoreInputComponent$l(CoreInputComponent r1, EditText r2, LarusWidgetInputBinding r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
