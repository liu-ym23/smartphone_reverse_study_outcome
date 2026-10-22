package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements q02.a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.a$a, reason: collision with other inner class name */
    public static final class C0059a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ q02.d a;

        public b(q02.d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a;
            if (r3 == null) goto L6;
            r3.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a;
            if (r3 == null) goto L6;
            r3.e();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ q02.d a;

        public c(q02.d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a;
            if (r3 == null) goto L6;
            r3.d();
            return;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ q02.d a;

        public d(q02.d r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }
    }

    static {
    }

    public a() {
    }

    @Override // q02.a
    public final Animator b(View r4, q02.d r5) {
        if (r4 == null) goto L4;
        float r0 = r4.getAlpha();
    L5:
        int r1 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r6 = ObjectAnimatorCompat.a.a(r4, "alpha", r0, 1.0f);
        r6.f = 200;
        r6.addListener(new c(r5));
        return r6;
    L4:
        r0 = 0.0f;
        goto L5
    }

    @Override // q02.a
    public final Animator c(View r4, q02.d r5) {
        int r0 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r6 = ObjectAnimatorCompat.a.a(r4, "alpha", 1.0f, 0.0f);
        r6.f = 200;
        r6.addListener(new d(r5));
        return r6;
    }

    @Override // q02.a
    public final Animator d(View r6, q02.d r7) {
        int r0 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r8 = ObjectAnimatorCompat.a.a(r6, "scaleY", 1.35f, 1.0f);
        r8.f = 200;
        r8.g = new PathInterpolator(0.29f, 0.22f, 0.21f, 1.5f);
        r8.addListener(new b(r7));
        return r8;
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
