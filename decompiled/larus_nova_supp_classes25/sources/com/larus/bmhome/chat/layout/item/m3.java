package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ClipDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m3 extends AnimatorListenerAdapter {
    public final /* synthetic */ l3 a;
    public final /* synthetic */ ClipDrawable b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.a.getOverlay().remove(this.b);
    }

    public m3(l3 r1, ClipDrawable r2) {
        this.a = r1;
        this.b = r2;
    }
}
