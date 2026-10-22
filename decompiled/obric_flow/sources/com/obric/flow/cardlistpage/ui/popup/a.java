package com.obric.flow.cardlistpage.ui.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f11807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f11808c;

    public /* synthetic */ a(b r5, AnimatorSet r10, int r11) {
        this.f11806a = r11;
        this.f11807b = r5;
        this.f11808c = r10;
    }

    private final void a(Animator r5) {
    }

    private final void b(Animator r5) {
    }

    private final void c(Animator r5) {
    }

    private final void d(Animator r5) {
    }

    private final void e(Animator r5) {
    }

    private final void f(Animator r5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        int r10 = this.f11806a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        int r10 = this.f11806a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        int r10 = this.f11806a;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f11806a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        b r10 = this.f11807b;
        r10.e = this.f11808c;
        r10.d.invoke();
        return;
    L6:
        b r11 = this.f11807b;
        r11.e = this.f11808c;
    }
}
