package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static Animator.AnimatorListener a(c r2) {
        final c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }

    public static Animator a(c r7, float r8, float r9, float r10) {
        c r11 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        ObjectAnimator r0 = ObjectAnimator.ofObject(r11, c.b.f3846a, c.a.f3844a, new c.d[]{new c.d(r8, r9, r10)});
        if (Build.VERSION.SDK_INT < 21) goto L10;
        c.d r2 = r11.getRevealInfo();
        if (r2 == null) goto L9;
        Animator r12 = ViewAnimationUtils.createCircularReveal((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), (int) r8, (int) r9, r2.c, r10);
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r0, r12});
        return r13;
    L9:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    L10:
        return r0;
    }
}
