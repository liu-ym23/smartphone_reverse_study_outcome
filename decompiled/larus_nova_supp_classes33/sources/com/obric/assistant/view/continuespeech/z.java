package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z extends u.b {
    public boolean a;
    public final /* synthetic */ u b;

    public z(u r1) {
        this.b = r1;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        this.a = true;
        u.a(this.b, r3, true);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        u.a(this.b, r3, this.a);
    }
}
