package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u001c\u0010!\u001a\u00020\u00112\b\b\u0001\u0010\"\u001a\u00020\u00112\b\b\u0001\u0010#\u001a\u00020\u0011H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerLoadingVIew;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "gradient", "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "translateXY", "", "textColor", "", "textColorAlpha", "shimmerColors", "", "shimmerPositions", "", "animator", "Landroid/animation/ValueAnimator;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startShimmer", "stopShimmer", "applyAlpha", "color", "alpha", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ShimmerLoadingVIew extends View {
    public static final /* synthetic */ int h = 0;
    public final Paint a;
    public LinearGradient b;
    public final Matrix c;
    public float d;
    public final int[] e;
    public final float[] f;
    public ValueAnimator g;

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.larus.utils.t0.c(new e1(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.g = null;
    }

    public ShimmerLoadingVIew(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        if (this.b != null) goto L5;
        LinearGradient r0 = new LinearGradient(-getWidth(), -getHeight(), 0.0f, 0.0f, this.e, this.f, Shader.TileMode.CLAMP);
        this.b = r0;
        this.a.setShader(r0);
    L5:
        Matrix r1 = this.c;
        float r2 = this.d;
        r1.setTranslate(r2, r2);
        LinearGradient r3 = this.b;
        if (r3 == null) goto L8;
        r3.setLocalMatrix(this.c);
    L8:
        r11.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), 20.0f, 20.0f, this.a);
    }

    public ShimmerLoadingVIew(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.a = new Paint(1);
        this.c = new Matrix();
        int r0 = ContextCompat.getColor(r6, v19.c.b(2130970533, r6, 2131102542));
        if (r7 == null) goto L8;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130972247});
        r0 = r8.getColor(0, r0);     // Catch: Throwable -> L10
        r8.recycle();
    L10:
        th = move-exception;
        r8.recycle();
        throw th;
    L8:
        this.e = new int[]{r0, (16777215 & r0) | (-1728053248), r0};
        this.f = new float[]{0.0f, 0.5f, 1.0f};
        setLayerType(2, null);
    }
}
