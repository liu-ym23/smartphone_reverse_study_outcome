package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/business/multitask_management/impl/view/FadeEdgeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "edgeSizePx", "", "maskStopCount", "curvePower", "maskPaint", "Landroid/graphics/Paint;", "topGradient", "Landroid/graphics/LinearGradient;", "bottomGradient", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updateGradients", "buildTopMaskStops", "Lcom/larus/business/multitask_management/impl/view/FadeEdgeRecyclerView$MaskStops;", "stopCount", "power", "buildBottomMaskStops", "easeIn", "t", "easeOut", "alphaToMaskColor", "alpha", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "MaskStops", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FadeEdgeRecyclerView extends RecyclerView {
    public final float a;
    public final int b;
    public final float c;
    public final Paint d;
    public LinearGradient e;
    public LinearGradient f;

    public FadeEdgeRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FadeEdgeRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        LinearGradient r0 = this.e;
        LinearGradient r1 = this.f;
        if (r0 == null) goto L22;
        if (r1 == null) goto L22;
        if (getWidth() <= 0) goto L22;
        if (getHeight() <= 0) goto L22;
        boolean r2 = canScrollVertically(-1);
        boolean r3 = canScrollVertically(1);
        if (r2 == true) goto L15;
        if (r3 == true) goto L15;
        super/*android.view.ViewGroup*/.dispatchDraw(r13);
        return;
    L15:
        float r4 = Math.min(this.a, getHeight() / 2.0f);
        int r5 = r13.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super/*android.view.ViewGroup*/.dispatchDraw(r13);
        if (r2 == false) goto L18;
        this.d.setShader(r0);
        r13.drawRect(0.0f, 0.0f, getWidth(), r4, this.d);
    L18:
        if (r3 == false) goto L20;
        this.d.setShader(r1);
        r13.drawRect(0.0f, getHeight() - r4, getWidth(), getHeight(), this.d);
    L20:
        this.d.setShader(null);
        r13.restoreToCount(r5);
        return;
    L22:
        super/*android.view.ViewGroup*/.dispatchDraw(r13);
    }

    public FadeEdgeRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = c7.b(16);
        this.b = 8;
        this.c = 3.0f;
        Paint r5 = new Paint(1);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.d = r5;
    }

    public /* synthetic */ FadeEdgeRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onSizeChanged(int r20, int r21, int r22, int r23) {
        super.onSizeChanged(r20, r21, r22, r23);
        if (r20 <= 0) goto L22;
        if (r21 <= 0) goto L22;
        float r2 = this.a;
        float r3 = 0.0f;
        if (r2 <= 0.0f) goto L22;
        float r9 = r21;
        float r1 = Math.min(r2, r9 / 2.0f);
        int r4 = this.b;
        float r5 = this.c;
        int r6 = RangesKt.coerceAtLeast(r4, 2);
        int[] r15 = new int[r6];
        float[] r7 = new float[r6];
        int r8 = r6 - 1;
        float r11 = 1.0f;
        if (r8 < 0) goto L14;
        int r12 = 0;
    L11:
        float r13 = r12 / r8;
        double r10 = 1.0f - RangesKt.coerceIn(r13, r3, 1.0f);
        float r14 = r5;
        float r16 = 1.0f - ((float) Math.pow(r10, RangesKt.coerceAtLeast(r5, 1.0f)));
        r7[r12] = r13;
        r15[r12] = Color.argb((int) ((RangesKt.coerceIn(r16, 0.0f, 1.0f) * 255.0f) + 0.5f), 0, 0, 0);
        if (r12 == r8) goto L14;
        r12 = r12 + 1;
        r5 = r14;
        r3 = 0.0f;
    L14:
        Intrinsics.checkNotNullParameter(r15, "colors");
        Intrinsics.checkNotNullParameter(r7, "positions");
        int r17 = this.b;
        float r18 = this.c;
        int r19 = RangesKt.coerceAtLeast(r17, 2);
        int[] r24 = new int[r19];
        float[] r25 = new float[r19];
        int r26 = r19 - 1;
        if (r26 < 0) goto L20;
        int r110 = 0;
    L17:
        float r111 = r110 / r26;
        int r112 = r110;
        float r113 = r9;
        float r114 = 1.0f - ((float) Math.pow(RangesKt.coerceIn(r111, 0.0f, r11), RangesKt.coerceAtLeast(r18, r11)));
        r25[r112] = r111;
        r24[r112] = Color.argb((int) ((RangesKt.coerceIn(r114, 0.0f, 1.0f) * 255.0f) + 0.5f), 0, 0, 0);
        if (r112 == r26) goto L21;
        r110 = r112 + 1;
        r9 = r113;
        r11 = 1.0f;
    L21:
        Intrinsics.checkNotNullParameter(r24, "colors");
        Intrinsics.checkNotNullParameter(r25, "positions");
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, r1, r15, r7, Shader.TileMode.CLAMP);
        this.f = new LinearGradient(0.0f, r113 - r1, 0.0f, r113, r24, r25, Shader.TileMode.CLAMP);
        return;
    L20:
        r113 = r9;
    L22:
        this.e = null;
        this.f = null;
    }
}
