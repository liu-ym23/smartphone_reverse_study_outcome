package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v extends u.b {
    public final /* synthetic */ u a;

    public v(u r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a.c.setVisibility(8);
    }

    @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a.c.setVisibility(8);
    }
}
