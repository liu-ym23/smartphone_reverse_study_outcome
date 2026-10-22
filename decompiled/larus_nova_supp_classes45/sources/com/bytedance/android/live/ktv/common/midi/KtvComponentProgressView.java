package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvComponentProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentProgressView extends View {
    public float a;
    public final float b;
    public SweepGradient c;
    public final Paint d;
    public final RectF e;
    public ValueAnimator f;
    public ValueAnimator g;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ KtvComponentProgressView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b(KtvComponentProgressView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            KtvComponentProgressView r3 = this.a;
            r3.a = 0.0f;
            r3.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            KtvComponentProgressView r3 = this.a;
            r3.a = 0.0f;
            r3.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2, r3);
            KtvComponentProgressView r4 = this.a;
            r4.a = 0.0f;
            r4.invalidate();
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvComponentProgressView a;

        public c(KtvComponentProgressView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            KtvComponentProgressView r0 = this.a;
            r0.a = r5;
            r0.invalidate();
            return;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvComponentProgressView a;

        public d(KtvComponentProgressView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "va");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            KtvComponentProgressView r0 = this.a;
            r0.a = r5;
            r0.invalidate();
            return;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvComponentProgressView a;

        public e(KtvComponentProgressView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            KtvComponentProgressView r3 = this.a;
            r3.a = 100.0f;
            r3.invalidate();
        }
    }

    static {
    }

    public KtvComponentProgressView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentProgressView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.g;
        if (r1 == null) goto L8;
        r1.removeAllListeners();
    L8:
        ValueAnimator r2 = this.g;
        if (r2 == null) goto L12;
        r2.cancel();
        return;
    }

    public final void b() {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.g;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (this.a <= 0) goto L26;
        ValueAnimator r2 = this.f;
        if (r2 == null) goto L13;
        r2.removeAllUpdateListeners();
    L13:
        ValueAnimator r3 = this.f;
        if (r3 == null) goto L16;
        r3.cancel();
    L16:
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{this.a, 0.0f}).setDuration(500);
        this.f = r4;
        if (r4 == null) goto L19;
        r4.addListener(new b(this));
    L19:
        ValueAnimator r5 = this.f;
        if (r5 == null) goto L22;
        r5.addUpdateListener(new c(this));
    L22:
        ValueAnimator r6 = this.f;
        if (r6 == null) goto L27;
        r6.start();
        return;
    L27:
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.f;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.g;
        if (r2 == null) goto L11;
        r2.removeAllUpdateListeners();
    L11:
        ValueAnimator r3 = this.g;
        if (r3 == null) goto L15;
        r3.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        float r5 = (this.a / 100.0f) * 360;
        r9.drawArc(this.e, 270 - r5, r5, false, this.d);
    }

    public final void setProgress(float r2) {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
    L5:
        ValueAnimator r1 = this.g;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.a = r2;
        invalidate();
    }

    public final void c(long r4, long r6) {
        float r0 = this.a;
        if (r0 < 100.0f) goto L5;
        return;
    L5:
        if (r0 != 0.0f) goto L9;
        float r1 = (r6 / r4) * 100;
        this.a = r1;
        if (r1 < 100.0f) goto L9;
        return;
    L9:
        ValueAnimator r2 = this.g;
        if (r2 == null) goto L12;
        r2.removeAllUpdateListeners();
    L12:
        ValueAnimator r3 = this.g;
        if (r3 == null) goto L15;
        r3.removeAllListeners();
    L15:
        ValueAnimator r5 = this.g;
        if (r5 == null) goto L18;
        r5.cancel();
    L18:
        long r7 = r4 - r6;
        if (r7 >= 0) goto L21;
        r7 = 0;
    L21:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{this.a, 100.0f});
        this.g = r8;
        if (r8 == null) goto L24;
        r8.setDuration(r7);
    L24:
        ValueAnimator r9 = this.g;
        if (r9 == null) goto L27;
        r9.addUpdateListener(new d(this));
    L27:
        ValueAnimator r11 = this.g;
        if (r11 == null) goto L30;
        r11.addListener(new e(this));
    L30:
        ValueAnimator r12 = this.g;
        if (r12 == null) goto L35;
        r12.start();
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if (this.c != null) goto L6;
        SweepGradient r1 = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, new int[]{ColorProtector.parseColor("#FF72C8"), ColorProtector.parseColor("#63E5FF"), ColorProtector.parseColor("#FF72C8")}, null);
        this.c = r1;
        this.d.setShader(r1);
        RectF r11 = this.e;
        float r0 = 0;
        float r2 = this.b;
        r11.set((r2 / 2.0f) + r0, r0 + (r2 / 2.0f), getMeasuredWidth() - (this.b / 2.0f), getMeasuredHeight() - (this.b / 2));
        return;
    }

    public KtvComponentProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 100.0f;
        float r5 = UtilityKotlinExtentionsKt.h(1.5f);
        this.b = r5;
        Paint r6 = new Paint();
        this.d = r6;
        this.e = new RectF();
        r6.setAntiAlias(true);
        r6.setStrokeWidth(r5);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeCap(Paint.Cap.ROUND);
    }

    public /* synthetic */ KtvComponentProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
