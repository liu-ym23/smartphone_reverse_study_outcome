package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class HeartScaleView extends View {
    public static final /* synthetic */ int l = 0;
    public float a;
    public float b;
    public final Paint c;
    public final RectF d;
    public final Bitmap e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    private final AnimatorSet getHideLargeAnimatorSet() {
        return (AnimatorSet) this.k.getValue();
    }

    private final AnimatorSet getHideNormalAnimatorSet() {
        return (AnimatorSet) this.j.getValue();
    }

    private final ValueAnimator getShakeInfiniteAnimator() {
        return (ValueAnimator) this.g.getValue();
    }

    private final ValueAnimator getShakeOnceAnimator() {
        return (ValueAnimator) this.f.getValue();
    }

    private final AnimatorSet getShowAnimatorSet() {
        return (AnimatorSet) this.h.getValue();
    }

    private final AnimatorSet getTurnLargeAnimatorSet() {
        return (AnimatorSet) this.i.getValue();
    }

    public HeartScaleView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        Unit r1 = Unit.INSTANCE;
        this.c = r0;
        this.d = new RectF();
        this.e = BitmapFactory.decodeResource(r3.getResources(), 2131250967);
        this.f = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$shakeOnceAnimator$2(this));
        this.g = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$shakeInfiniteAnimator$2(this));
        this.h = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$showAnimatorSet$2(this));
        this.i = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$turnLargeAnimatorSet$2(this));
        this.j = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$hideNormalAnimatorSet$2(this));
        this.k = InfraKotlinExtsKt.mainThreadLazy(new HeartScaleView$hideLargeAnimatorSet$2(this));
    }

    public static final /* synthetic */ ValueAnimator a(HeartScaleView r0) {
        return r0.getShakeInfiniteAnimator();
    }

    public static final /* synthetic */ ValueAnimator b(HeartScaleView r0) {
        return r0.getShakeOnceAnimator();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        r6.save();
        RectF r0 = this.d;
        float r2 = 1;
        float r3 = 2;
        r0.left = (getWidth() * (r2 - this.a)) / r3;
        r0.top = (getHeight() * (r2 - this.a)) / r3;
        r0.right = r0.left + (getWidth() * this.a);
        r0.bottom = r0.top + (getHeight() * this.a);
        float r1 = this.b;
        if (r1 == 0.0f) goto L5;
        r6.rotate(r1, this.d.centerX(), this.d.centerY());
    L5:
        r6.drawBitmap(this.e, null, this.d, this.c);
        r6.restore();
    }
}
