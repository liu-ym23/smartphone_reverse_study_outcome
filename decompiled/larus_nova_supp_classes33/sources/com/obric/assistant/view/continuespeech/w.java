package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w extends u.b {
    public boolean a;
    public final /* synthetic */ u b;

    public w(u r1) {
        this.b = r1;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a = true;
        AudioGradientView r3 = this.b.a;
        if (r3 == null) goto L5;
        r3.setAnimating(false);
    L5:
        this.b.c.setAnimating(false);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        AudioGradientView r3 = this.b.a;
        if (r3 == null) goto L6;
        r3.setAnimating(false);
    L6:
        if (this.a == true) goto L9;
        this.b.c.setAnimating(false);
        return;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a = false;
        AudioGradientView r3 = this.b.a;
        if (r3 == null) goto L5;
        r3.setAnimating(true);
    L5:
        this.b.c.setAnimating(true);
    }
}
