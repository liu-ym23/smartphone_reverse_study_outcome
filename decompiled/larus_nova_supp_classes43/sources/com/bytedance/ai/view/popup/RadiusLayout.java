package com.bytedance.ai.view.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018J&\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ai/view/popup/RadiusLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "showStroke", "", "strokePaint", "Landroid/graphics/Paint;", "hasStroke", "radiusArray", "", "outRectF", "Landroid/graphics/RectF;", "outPath", "Landroid/graphics/Path;", "setRadius", "", "r", "", "setRadiusNew", "radius", "lt", "rt", "lb", "rb", "setStroke", "strokeColor", "strokeWidth", "strokeDash", "strokeGap", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", com.bytedance.android.ec.core.event.a.VALUE_ACTION_TYPE_DRAW, "clipRound", "drawStroke", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RadiusLayout extends FrameLayout {
    public final boolean a;
    public Paint b;
    public boolean c;
    public float[] d;
    public final RectF e;
    public final Path f;

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ float a;

        public a(float r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r10, Outline r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r11 != null) goto L6;
            return;
        L6:
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            float r14 = this.a;
            r11.setRoundRect(0, 0, r12, r13 + ((int) r14), r14);
        }
    }

    public RadiusLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public RadiusLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        if (this.c == true) goto L5;
        return;
    L5:
        if (this.a == false) goto L15;
        Paint r0 = this.b;
        if (r0 == null) goto L16;
        this.e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f.reset();
        Path r1 = this.f;
        RectF r11 = this.e;
        float[] r12 = this.d;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("radiusArray");
        r12 = null;
    L12:
        r1.addRoundRect(r11, r12, Path.Direction.CW);
        r10.drawPath(this.f, r0);
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.draw(r10);
    }

    public final void setRadius(float r10) {
        this.d = new float[]{r10, r10, r10, r10, r10, r10, r10, r10};
        invalidate();
    }

    public final void setRadiusNew(float r10) {
        setClipToOutline(true);
        setOutlineProvider(new a(r10));
        invalidate();
    }

    public RadiusLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = true;
        this.e = new RectF();
        this.f = new Path();
        Paint r13 = new Paint();
        r13.setAntiAlias(true);
        r13.setColor(0);
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(0);
        this.b = r13;
        this.c = false;
        invalidate();
    }

    public /* synthetic */ RadiusLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
