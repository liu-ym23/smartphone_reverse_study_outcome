package q02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.revenue.common.utils.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements q02.a {

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            if (r3 == null) goto L6;
            r3.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            if (r3 == null) goto L6;
            r3.e();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            if (r3 == null) goto L6;
            r3.d();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            d r3 = this.a;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }
    }

    public f() {
    }

    @Override // q02.a
    public final Animator b(View r6, d r7) {
        if (r6 == null) goto L5;
        float r1 = r6.getX();
    L6:
        Animator r8 = LiveDegradeFpsAnimator.ofFloat(r6, "translationX", new float[]{r1, 0.0f});
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{r8});
        r0.setDuration(250);
        r0.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r0.addListener(new b(r7));
        return r0;
    L5:
        r1 = 0.0f;
        goto L6
    }

    @Override // q02.a
    public final Animator c(View r4, d r5) {
        Animator r6 = LiveDegradeFpsAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{r6});
        r0.setDuration(250);
        r0.addListener(new c(r5));
        return r0;
    }

    @Override // q02.a
    public final Animator d(View r5, d r6) {
        Animator r1 = LiveDegradeFpsAnimator.ofFloat(r5, "scaleX", new float[]{1.35f, 1.0f});
        Animator r7 = LiveDegradeFpsAnimator.ofFloat(r5, "scaleY", new float[]{1.35f, 1.0f});
        AnimatorSet r2 = new AnimatorSet();
        r2.playTogether(new Animator[]{r1, r7});
        r2.setDuration(200);
        r2.addListener(new a(r6));
        return r2;
    }

    @Override // q02.a
    public final void a(View r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setX(r2);
        r1.setY(r3);
    }
}
