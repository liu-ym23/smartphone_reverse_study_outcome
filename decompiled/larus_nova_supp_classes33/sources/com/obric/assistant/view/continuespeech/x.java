package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x extends u.b {
    public final /* synthetic */ u a;

    public x(u r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        this.a.b.setVisibility(0);
    }
}
