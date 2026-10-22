package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.a$a, reason: collision with other inner class name */
    class C0078a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f3142c;

        C0078a(c r10) {
            this.f3142c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3142c.destroyCircularRevealCache();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3142c.buildCircularRevealCache();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator a(@NonNull c r10, float r11, float r12, float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofObject(r10, c.C0079c.f3155a, c.b.f3153b, new c.e[]{new c.e(r11, r12, r13)});
        if (Build.VERSION.SDK_INT < 21) goto L10;
        c.e r15 = r10.getRevealInfo();
        if (r15 == null) goto L9;
        Animator r16 = ViewAnimationUtils.createCircularReveal((View) r10, (int) r11, (int) r12, r15.f3159c, r13);
        AnimatorSet r17 = new AnimatorSet();
        r17.playTogether(new Animator[]{r14, r16});
        return r17;
    L9:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    L10:
        return r14;
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull c r10) {
        return new C0078a(r10);
    }
}
