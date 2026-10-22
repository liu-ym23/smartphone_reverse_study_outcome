package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.util.Pools;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvHitAnimationView;", "Landroid/widget/RelativeLayout;", "Landroid/graphics/PointF;", "getStartPoint", "", "gap", "", "setAnimGap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvHitAnimationView extends RelativeLayout {
    public static final /* synthetic */ int m = 0;
    public final c a;
    public final List<? extends Drawable> b;
    public final List<RelativeLayout.LayoutParams> c;
    public final List<? extends Interpolator> d;
    public final float e;
    public float f;
    public final Random g;
    public long h;
    public final int i;
    public final int j;
    public final int k;
    public int l;

    public final class a extends AnimatorListenerAdapter {
        public final ImageView a;
        public final /* synthetic */ KtvHitAnimationView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationEnd(r3);
            this.b.removeView(this.a);
            c r4 = this.b.a;
            ImageView r0 = this.a;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "imageView");
            r4.a.release(r0);
        }

        public a(KtvHitAnimationView r2, ImageView r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final View a;

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            PointF r5 = (PointF) r4;
            this.a.setX(r5.x);
            this.a.setY(r5.y);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
        }
    }

    public static final class c {
        public final Pools.SynchronizedPool<ImageView> a;

        public c() {
            this.a = new Pools.SynchronizedPool(4);
        }
    }

    public KtvHitAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvHitAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final PointF getStartPoint() {
        float r1 = this.e;
        int r2 = this.i;
        return new PointF(r1 - r2, (this.f + this.l) - r2);
    }

    public final void setAnimGap(int r1) {
        this.l = r1;
    }

    public final PointF a(PointF r5, PointF r6) {
        float r0 = r5.x - r6.x;
        int r7 = this.g.nextInt((int) ((r5.y - r6.y) + 1));
        float r2 = r6.x + (r0 / 2);
        float r1 = this.i;
        return new PointF(r2 - r1, (r6.y + r7) - r1);
    }

    public final void b(float r17, boolean r18) {
        this.f = r17;
        int r2 = this.g.nextInt(4);
        float r3 = getX();
        Drawable r4 = (Drawable) ListProtector.get(this.b, r2);
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) ListProtector.get(this.c, r2);
        c r6 = this.a;
        Context r7 = getContext();
        ImageView r8 = (ImageView) r6.a.acquire();
        if (r8 != null) goto L5;
        r8 = new ImageView(r7);
    L5:
        r8.setImageDrawable(r4);
        r8.setLayoutParams(r5);
        r8.setX(r3);
        r8.setY(r17);
        addView(r8);
        int r1 = this.g.nextInt((this.j * 2) / 3);
        int r9 = this.g.nextInt(this.k);
        if (r18 == false) goto L8;
        float r11 = (((this.f + this.l) - this.k) + r9) - this.i;
    L9:
        PointF r12 = new PointF(((this.e - this.j) + r1) - this.i, r11);
        PointF r13 = getStartPoint();
        this.h = (long) (((((r13.y - r12.y) + r13.x) - r12.x) / (this.j + this.k)) * 2000);
        if (KtvSettingHelper.o() == false) goto L12;
        ValueAnimator r14 = LiveDegradeFpsAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(a(r13, r12)), new Object[]{r13, r12}).setFpsConfig(2);
    L13:
        r14.addUpdateListener(new b(r8));
        r14.setTarget(r8);
        r14.setDuration(this.h);
        if (KtvSettingHelper.o() == false) goto L16;
        Animator r15 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f}).setFpsConfig(2);
    L18:
        if (KtvSettingHelper.o() == false) goto L20;
        Animator r16 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}).setFpsConfig(2);
    L22:
        if (KtvSettingHelper.o() == false) goto L24;
        Animator r19 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f}).setFpsConfig(2);
    L25:
        AnimatorSet r110 = new AnimatorSet();
        r110.setDuration(this.h / ((long) 3));
        r110.setInterpolator(new LinearInterpolator());
        r110.playTogether(new Animator[]{r15, r16, r19});
        r110.setTarget(r8);
        if (KtvSettingHelper.o() == false) goto L28;
        Animator r21 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(2);
    L30:
        if (KtvSettingHelper.o() == false) goto L32;
        Animator r22 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}).setFpsConfig(2);
    L34:
        if (KtvSettingHelper.o() == false) goto L36;
        Animator r23 = LiveDegradeFpsAnimator.ofFloat(r8, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f}).setFpsConfig(2);
    L37:
        AnimatorSet r24 = new AnimatorSet();
        r24.setDuration(this.h / ((long) 5));
        r24.setInterpolator(new LinearInterpolator());
        r24.setStartDelay(this.h - r24.getDuration());
        r24.playTogether(new Animator[]{r21, r22, r23});
        r24.setTarget(r8);
        AnimatorSet r25 = new AnimatorSet();
        r25.playTogether(new Animator[]{r110, r14, r24});
        List<? extends Interpolator> r26 = this.d;
        if (r26 != null) goto L40;
    L46:
        r25.setTarget(r8);
        r25.addListener(new a(this, r8));
        r25.start();
        return;
    L40:
        if ((!r26.isEmpty()) != true) goto L46;
        List<? extends Interpolator> r27 = this.d;
        if (r27 == null) goto L44;
        Interpolator r28 = (Interpolator) CollectionsKt.first(r27);
    L45:
        r25.setInterpolator(r28);
        goto L46
    L44:
        r28 = null;
        goto L45
    L36:
        r23 = ObjectAnimator.ofFloat(r8, View.SCALE_Y, new float[]{1.0f, 0.0f});
        goto L37
    L32:
        r22 = ObjectAnimator.ofFloat(r8, View.SCALE_X, new float[]{1.0f, 0.0f});
        goto L34
    L28:
        r21 = ObjectAnimator.ofFloat(r8, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L30
    L24:
        r19 = ObjectAnimator.ofFloat(r8, View.SCALE_Y, new float[]{0.0f, 1.0f});
        goto L25
    L20:
        r16 = ObjectAnimator.ofFloat(r8, View.SCALE_X, new float[]{0.0f, 1.0f});
        goto L22
    L16:
        r15 = ObjectAnimator.ofFloat(r8, View.ALPHA, new float[]{0.0f, 1.0f});
        goto L18
    L12:
        r14 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(a(r13, r12)), new Object[]{r13, r12});
        goto L13
    L8:
        r11 = (((this.f + this.l) + this.k) - r9) + this.i;
        goto L9
    }

    public KtvHitAnimationView(Context r8, AttributeSet r9, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r11);
        this.e = s1.f(56.0f);
        this.g = new Random();
        this.h = 2000;
        this.a = new c();
        this.b = CollectionsKt.listOf(new Drawable[]{s1.m(2131252081), s1.m(2131252083), s1.m(2131252082), s1.m(2131252073)});
        this.c = CollectionsKt.listOf(new RelativeLayout.LayoutParams[]{new RelativeLayout.LayoutParams(s1.f(12.0f), s1.f(12.0f)), new RelativeLayout.LayoutParams(s1.f(6.0f), s1.f(6.0f)), new RelativeLayout.LayoutParams(s1.f(6.0f), s1.f(6.0f)), new RelativeLayout.LayoutParams(s1.f(3.0f), s1.f(3.0f))});
        if (Build.VERSION.SDK_INT < 22) goto L5;
        this.d = CollectionsKt.listOf(new BaseInterpolator[]{new LinearInterpolator(), new AccelerateInterpolator(), new DecelerateInterpolator(), new AccelerateDecelerateInterpolator()});
    L5:
        this.i = s1.f(2.0f);
        this.j = s1.f(40.0f);
        this.k = s1.f(30.0f);
        this.l = s1.f(50.0f);
    }

    public /* synthetic */ KtvHitAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
