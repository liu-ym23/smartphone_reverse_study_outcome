package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends b {
    public ValueAnimator d;
    public final Function0<Unit> e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamesticker.t01.anim.a$a, reason: collision with other inner class name */
    public static final class C0365a extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ a b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.c(TaskState.END);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.c(TaskState.END);
            this.a.V2().setVisibility(8);
            this.b.e.invoke();
        }

        public C0365a(i r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "HideContainerTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r0 = this.c;
        if (r0 == null) goto L14;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0.V2(), "translationY", new float[]{0.0f, -r0.getHeight()});
        this.d = r1;
        if (r1 == null) goto L7;
        r1.setDuration(500);
    L7:
        ValueAnimator r2 = this.d;
        if (r2 == null) goto L10;
        r2.addListener(new C0365a(r0, this));
    L10:
        ValueAnimator r3 = this.d;
        if (r3 == null) goto L14;
        r3.start();
    L14:
        if (this.c != null) goto L17;
        c(TaskState.END);
        return;
    }

    public a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onGone");
        this.e = r2;
    }
}
