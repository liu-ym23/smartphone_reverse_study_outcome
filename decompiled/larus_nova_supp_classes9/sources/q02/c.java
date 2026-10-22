package q02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.revenue.common.utils.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements q02.a {

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

    /* JADX INFO: renamed from: q02.c$c, reason: collision with other inner class name */
    public static final class C0267c extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;

        public C0267c(d r1) {
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

    public c() {
    }

    @Override // q02.a
    public final Animator b(View r5, d r6) {
        if (r5 == null) goto L4;
        float r0 = r5.getAlpha();
    L5:
        Animator r7 = LiveDegradeFpsAnimator.ofFloat(r5, "alpha", new float[]{r0, 1.0f});
        AnimatorSet r1 = new AnimatorSet();
        r1.playTogether(new Animator[]{r7});
        r1.setDuration(200);
        r1.addListener(new b(r6));
        return r1;
    L4:
        r0 = 0.0f;
        goto L5
    }

    @Override // q02.a
    public final Animator c(View r4, d r5) {
        Animator r6 = LiveDegradeFpsAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{r6});
        r0.setDuration(200);
        r0.addListener(new C0267c(r5));
        return r0;
    }

    @Override // q02.a
    public final Animator d(View r6, d r7) {
        Animator r1 = LiveDegradeFpsAnimator.ofFloat(r6, "scaleX", new float[]{1.35f, 1.0f});
        Animator r8 = LiveDegradeFpsAnimator.ofFloat(r6, "scaleY", new float[]{1.35f, 1.0f});
        AnimatorSet r2 = new AnimatorSet();
        r2.playTogether(new Animator[]{r1, r8});
        r2.setDuration(200);
        r2.setInterpolator(new PathInterpolator(0.29f, 0.22f, 0.21f, 1.5f));
        r2.addListener(new a(r7));
        return r2;
    }

    @Override // q02.a
    public final void a(View r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setX(0.0f);
        r1.setY(r3);
        r1.setAlpha(0.0f);
    }
}
