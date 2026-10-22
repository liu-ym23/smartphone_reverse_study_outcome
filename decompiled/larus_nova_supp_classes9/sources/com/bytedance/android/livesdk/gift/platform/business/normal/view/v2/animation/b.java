package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayContainerView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayWaveControllerView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public AnimatedDrawable2 a;
    public AnimatorSet b;
    public final HSImageView c;
    public final ViewGroup d;
    public final TrayWaveControllerView e;
    public final q02.d f;
    public final boolean g;
    public final NormalGiftMessage h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b$b, reason: collision with other inner class name */
    public static final class C0061b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ Pair b;

        public C0061b(b r1, Pair r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayContainerView] */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            Object r1 = null;
            if ((r5 instanceof Integer) == true) goto L5;
            r5 = null;
        L5:
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L19;
            int r7 = r6.intValue();
            ViewGroup r0 = this.a.d;
            if ((r0 instanceof TrayContainerView) == false) goto L11;
            r1 = r0;
        L11:
            ?? r2 = (TrayContainerView) r1;
            if (r2 == 0) goto L20;
            float r8 = r7;
            if (((Number) this.b.getSecond()).intValue() <= r8) goto L16;
            boolean r3 = true;
        L17:
            boolean r9 = this.a.g;
            r2.b = r8;
            r2.a = r3;
            r2.c = r9;
            r2.invalidate();
            return;
        L16:
            r3 = false;
            goto L17
        L20:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            q02.d r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L8;
            q02.d r3 = this.a.f;
            if (r3 == null) goto L9;
            r3.d();
            return;
        L9:
            return;
        }

        public c(b r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        i = s1.f(65.0f);
        j = s1.f(168.0f);
        k = s1.f(53.0f);
        l = s1.f(138.0f);
    }

    public final void b() {
        AnimatedDrawable2 r0 = this.a;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.a = null;
        TrayWaveControllerView r1 = this.e;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        AnimatorSet r2 = this.b;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isRunning() != true) goto L21;
        AnimatorSet r3 = this.b;
        if (r3 == null) goto L15;
        r3.removeAllListeners();
    L15:
        AnimatorSet r4 = this.b;
        if (r4 == null) goto L18;
        r4.cancel();
    L18:
        this.b = null;
        return;
    }

    public final void a(boolean r10) {
        ViewGroup r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(0);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        if (this.g == false) goto L8;
        Pair r3 = new Pair(Integer.valueOf(k), Integer.valueOf(l));
    L9:
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue()});
        if (r4 == null) goto L12;
        r4.addUpdateListener(new C0061b(this, r3));
        r4.addListener(new c(this, r10));
        r4.setDuration(850);
        r4.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.4f, 1.0f));
    L13:
        AnimatorSet r11 = new AnimatorSet();
        this.b = r11;
        r11.playTogether(new Animator[]{r4, r1});
        AnimatorSet r13 = this.b;
        if (r13 == null) goto L17;
        r13.start();
        return;
    L17:
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = new Pair(Integer.valueOf(i), Integer.valueOf(j));
        goto L9
    }

    public b(HSImageView r1, ViewGroup r2, TrayWaveControllerView r3, q02.d r4, boolean r5, NormalGiftMessage r6) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }
}
