package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ClipDrawable;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o3 extends AnimatorListenerAdapter {
    public final /* synthetic */ l3 a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ ClipDrawable c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (Intrinsics.areEqual(this.a.f, r2) == false) goto L5;
        this.a.f = null;
    L5:
        ViewGroup r3 = this.b;
        if (r3 == null) goto L11;
        ViewGroupOverlay r4 = r3.getOverlay();
        if (r4 == null) goto L12;
        r4.remove(this.c);
        return;
    L12:
        return;
    }

    public o3(l3 r1, ViewGroup r2, ClipDrawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
