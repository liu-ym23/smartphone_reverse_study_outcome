package com.bytedance.ai.applet.app.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletBackButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonSizePx", "", "cornerRadiusPx", "shadowPaddingPx", "shadowRadiusPx", "strokeWidthPx", "buttonRect", "Landroid/graphics/RectF;", "strokeRect", "appliedNightMode", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "refreshTheme", "", "force", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateButtonRect", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBackButton extends AppCompatImageButton {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final RectF e;
    public final RectF f;
    public final Paint g;
    public final Paint h;

    public AppletBackButton(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public AppletBackButton(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r0 = Math.min(this.a, Math.min(getWidth(), getHeight()));
        float r1 = (getWidth() - r0) / 2.0f;
        float r11 = (getHeight() - r0) / 2.0f;
        this.e.set(r1, r11, r1 + r0, r0 + r11);
        RectF r12 = this.e;
        float r13 = this.b;
        r10.drawRoundRect(r12, r13, r13, this.g);
        this.f.set(this.e);
        float r14 = this.d / 2.0f;
        this.f.inset(r14, r14);
        float r15 = RangesKt.coerceAtLeast(this.b - r14, 0.0f);
        r10.drawRoundRect(this.f, r15, r15, this.h);
        super/*android.widget.ImageButton*/.onDraw(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r10, int r11) {
        int r0 = MathKt.roundToInt(this.a + (this.c * 2));
        setMeasuredDimension(ImageButton.resolveSize(r0, r10), ImageButton.resolveSize(r0, r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppletBackButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = getResources().getDimension(2131165339);
        this.b = getResources().getDimension(2131165336);
        this.c = getResources().getDimension(2131165337);
        float r13 = getResources().getDimension(2131165338);
        float r14 = getResources().getDimension(2131165340);
        this.d = r14;
        this.e = new RectF();
        this.f = new RectF();
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.FILL);
        this.g = r15;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeWidth(r14);
        this.h = r1;
        setBackground(null);
        setClickable(true);
        setFocusable(true);
        setScaleType(ImageView.ScaleType.CENTER);
        setImageResource(2131235792);
        setLayerType(1, null);
        int r16 = getResources().getConfiguration().uiMode;
        r15.setColor(t2.a.c(getContext(), 2130968820, 2131100389));
        r15.setShadowLayer(r13, 0.0f, 0.0f, t2.a.c(getContext(), 2130968823, 2131100398));
        r1.setColor(t2.a.c(getContext(), 2130968824, 2131100401));
        int r17 = t2.a.c(getContext(), 2130968821, 2131103681);
        int r18 = t2.a.c(getContext(), 2130968822, 2131100392);
        setImageTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{r18, r17}));
        setImageResource(2131235792);
        invalidate();
    }

    public /* synthetic */ AppletBackButton(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
