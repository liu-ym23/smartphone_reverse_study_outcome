package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q02.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements q02.a {

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

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b$b, reason: collision with other inner class name */
    public static final class C0060b extends AnimatorListenerAdapter {
        public final /* synthetic */ d a;

        public C0060b(d r1) {
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

    public b() {
    }

    @Override // q02.a
    public final Animator b(View r6, d r7) {
        if (r6 == null) goto L5;
        float r1 = r6.getX();
    L6:
        int r2 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r8 = ObjectAnimatorCompat.a.a(r6, "translationX", r1, 0.0f);
        r8.f = 250;
        r8.g = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        r8.addListener(new C0060b(r7));
        return r8;
    L5:
        r1 = 0.0f;
        goto L6
    }

    @Override // q02.a
    public final Animator c(View r4, d r5) {
        int r0 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r6 = ObjectAnimatorCompat.a.a(r4, "alpha", 1.0f, 0.0f);
        r6.f = 250;
        r6.addListener(new c(r5));
        return r6;
    }

    @Override // q02.a
    public final Animator d(View r5, d r6) {
        int r0 = ObjectAnimatorCompat.l;
        List r1 = CollectionsKt.listOf(new String[]{"scaleX", "scaleY"});
        Intrinsics.checkNotNullParameter(r1, "methods");
        ObjectAnimatorCompat r2 = new ObjectAnimatorCompat();
        r2.setTarget(r5);
        ArrayList r7 = (ArrayList) r2.b;
        r7.addAll(r1);
        r2.d = 1.35f;
        r2.e = 1.0f;
        r2.f = 200;
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
