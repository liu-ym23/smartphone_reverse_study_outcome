package com.bytedance.android.livesdk.gamesticker.hok.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class c extends com.bytedance.android.livesdk.gamesticker.hok.anim.a {
    public AnimatorSet d;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function0 b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.invoke();
        }

        public a(Function0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
        AnimatorSet r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
    }

    public c() {
    }

    public static HokGameRoleView f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGetter");
        if (r2.d().getVisibility() != 8) goto L7;
        return r2.d();
    L7:
        if (r2.a().getVisibility() != 8) goto L11;
        return r2.a();
    L11:
        return r2.d();
    }

    public static HokGameRoleView g(g r1) {
        Intrinsics.checkNotNullParameter(r1, "viewGetter");
        if (r1.d().getVisibility() != 0) goto L7;
        return r1.d();
    L7:
        if (r1.a().getVisibility() != 0) goto L11;
        return r1.a();
    L11:
        return r1.d();
    }

    public static boolean h(g r1) {
        Intrinsics.checkNotNullParameter(r1, "viewGetter");
        if (r1.d().getVisibility() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1.a().getVisibility() == 0) goto L8;
        return false;
    }

    public static boolean i(g r1) {
        Intrinsics.checkNotNullParameter(r1, "viewGetter");
        if (r1.b().getVisibility() != 0) goto L5;
    L10:
        return true;
    L5:
        if (r1.c().getVisibility() == 0) goto L10;
        if (r1.e().getVisibility() == 0) goto L10;
        return false;
    }

    public final ValueAnimator j(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        g r0 = this.c;
        if (r0 == null) goto L5;
        float r1 = r0.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r4, "translationY", new float[]{r1, 0.0f});
    L5:
        r1 = s1.f(28.0f);
        goto L7
    }

    public final ValueAnimator k(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        g r0 = this.c;
        if (r0 == null) goto L5;
        float r1 = r0.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r5, "translationY", new float[]{0.0f, -r1});
    L5:
        r1 = s1.f(28.0f);
        goto L7
    }

    public final void m(View r9, View r10, Function0<Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "inView");
        Intrinsics.checkNotNullParameter(r10, "outView");
        Intrinsics.checkNotNullParameter(r11, "onStart");
        Intrinsics.checkNotNullParameter(r12, "onEnd");
        l(r9, r10, null, null, r11, r12);
    }

    public final void l(View r4, View r5, View r6, View r7, Function0<Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r4, "inView");
        Intrinsics.checkNotNullParameter(r5, "outView");
        Intrinsics.checkNotNullParameter(r8, "onStart");
        Intrinsics.checkNotNullParameter(r9, "onEnd");
        List r0 = CollectionsKt.mutableListOf(new ValueAnimator[]{j(r4), k(r5)});
        if (r6 == null) goto L6;
        if (r7 == null) goto L6;
        r0.add(j(r6));
        r0.add(k(r7));
        r4.toString();
        r5.toString();
        r6.toString();
        r7.toString();
    L6:
        AnimatorSet r10 = new AnimatorSet();
        this.d = r10;
        r10.playTogether(CollectionsKt.toList(r0));
        AnimatorSet r11 = this.d;
        if (r11 == null) goto L9;
        r11.setDuration(500);
    L9:
        AnimatorSet r12 = this.d;
        if (r12 == null) goto L12;
        r12.addListener(new a(r8, r9));
    L12:
        AnimatorSet r13 = this.d;
        if (r13 == null) goto L16;
        r13.start();
        return;
    }
}
