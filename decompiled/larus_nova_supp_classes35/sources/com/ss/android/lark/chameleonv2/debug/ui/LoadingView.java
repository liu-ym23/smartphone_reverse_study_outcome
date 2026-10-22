package com.ss.android.lark.chameleonv2.debug.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/debug/ui/LoadingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxColor", "degree360", "mWidth", BuildConfig.FLAVOR, "mPadding", "startAngle", "mPaint", "Landroid/graphics/Paint;", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initPaint", "startAnim", "stopAnim", "valueAnimator", "Landroid/animation/ValueAnimator;", "startViewAnim", "startF", "endF", "time", BuildConfig.FLAVOR, "chameleon-debug_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingView extends View {
    public final int a;
    public final int b;
    public float c;
    public float d;
    public float e;
    public Paint f;
    public ValueAnimator g;

    public LoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        Paint r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r0 = null;
    L5:
        int r4 = this.a;
        r0.setColor(Color.argb(100, r4, r4, r4));
        float r1 = this.c;
        float r3 = 2;
        float r5 = r1 / r3;
        float r6 = r1 / r3;
        float r2 = (r1 / r3) - this.d;
        Paint r7 = this.f;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r7 = null;
    L8:
        r11.drawCircle(r5, r6, r2, r7);
        Paint r8 = this.f;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        r8 = null;
    L11:
        r8.setColor(-1);
        float r9 = this.d;
        float r10 = this.c;
        RectF r12 = new RectF(r9, r9, r10 - r9, r10 - r9);
        float r13 = this.e;
        Paint r14 = this.f;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPaint");
        Paint r15 = null;
    L15:
        r11.drawArc(r12, r13, 100.0f, false, r15);
        return;
    L14:
        r15 = r14;
        goto L15
    }

    public LoadingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (getMeasuredWidth() <= getMeasuredHeight()) goto L5;
        int r3 = getMeasuredHeight();
    L6:
        this.c = r3;
        this.d = 5.0f;
        return;
    L5:
        r3 = getMeasuredWidth();
        goto L6
    }

    public LoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        this.b = 360;
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        r5.setStyle(Paint.Style.STROKE);
        r5.setColor(-1);
        r5.setStrokeWidth(8.0f);
        this.f = r5;
    }
}
