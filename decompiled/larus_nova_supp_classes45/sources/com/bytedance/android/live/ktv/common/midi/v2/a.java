package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.a$a, reason: collision with other inner class name */
    public static final class C0211a implements Animator.AnimatorListener {
        public final /* synthetic */ Function1 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public C0211a(Function1 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.invoke(r2);
        }
    }

    public static final void a(Animator r1, Function1<? super Animator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$addAimatorEndListener");
        Intrinsics.checkNotNullParameter(r2, "onAnimationEnd");
        r1.addListener(new C0211a(r2));
    }
}
