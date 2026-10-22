package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BottomSheet {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public b b;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    public static final class c {
        public final View a;
        public final LinearLayout b;
        public final View c;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (LinearLayout) r2.findViewById(2131364516);
            this.c = r2.findViewById(2131364522);
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ BottomSheet a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(BottomSheet r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.c().a.setVisibility(8);
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.onDismiss();
            return;
        }
    }

    static {
    }

    public abstract View a(ViewGroup r1);

    public final void b() {
        AnimatorSet r0 = new AnimatorSet().setDuration(300);
        r0.addListener(new d(this));
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(c().b, "translationY", new float[]{0.0f, c().b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(c().c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r0.start();
    }

    public final c c() {
        return (c) this.a.getValue();
    }

    public BottomSheet(final Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = LazyKt.lazy(new BottomSheet$viewHolder$2(r2, this));
    }
}
