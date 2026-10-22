package com.obric.assistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0015J(\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014J\b\u0010)\u001a\u00020\u001dH\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/view/WindowFadingLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radii", "", "(Landroid/content/Context;[F)V", "maskPaint", "Landroid/graphics/Paint;", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "topFadeHeight", "", "bottomFadeHeight", "isTopFadeEnabled", "", "isBottomFadeEnabled", "topGradient", "Landroid/graphics/LinearGradient;", "bottomGradient", "bg", "Landroid/graphics/drawable/GradientDrawable;", "init", "", "setFadeHeight", "height", "setBottomFadeHeight", "setTopFadeEnabled", "enabled", "setBottomFadeEnabled", "onSizeChanged", "w", "h", "oldw", "oldh", "updateGradients", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setupFading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowFadingLayout extends FrameLayout {
    public final Paint a;
    public final PorterDuffXfermode b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;
    public LinearGradient g;
    public LinearGradient h;
    public final GradientDrawable i;

    public WindowFadingLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WindowFadingLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        float r5 = getHeight();
        if (r5 > 0.0f) goto L5;
        return;
    L5:
        this.g = new LinearGradient(0.0f, 0.0f, 0.0f, this.c, new int[]{0, -16777216}, null, Shader.TileMode.CLAMP);
        this.h = new LinearGradient(0.0f, r5 - this.d, 0.0f, r5, new int[]{-16777216, 0}, null, Shader.TileMode.CLAMP);
    }

    private final void setupFading(Canvas r12) {
        int r0 = r12.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r12);
        if (this.e == false) goto L10;
        if (this.c <= 0.0f) goto L10;
        LinearGradient r1 = this.g;
        if (r1 == null) goto L10;
        this.a.setShader(r1);
        r12.drawRect(0.0f, 0.0f, getWidth(), this.c, this.a);
        this.a.setShader(null);
    L10:
        if (this.f == true) goto L12;
    L16:
        r12.restoreToCount(r0);
        return;
    L12:
        if (this.d <= 0.0f) goto L16;
        LinearGradient r2 = this.h;
        if (r2 == null) goto L16;
        this.a.setShader(r2);
        r12.drawRect(0.0f, getHeight() - this.d, getWidth(), getHeight(), this.a);
        this.a.setShader(null);
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (this.e == false) goto L7;
        if (this.c <= 0.0f) goto L7;
    L10:
        setupFading(r3);
        return;
    L7:
        if (this.f == true) goto L9;
    L11:
        super.dispatchDraw(r3);
        return;
    L9:
        if (this.d <= 0.0f) goto L11;
        goto L10
    }

    public final void setBottomFadeEnabled(boolean r2) {
        if (this.f == r2) goto L6;
        this.f = r2;
        invalidate();
        return;
    }

    public final void setBottomFadeHeight(float r2) {
        if (this.d != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.d = r2;
        a();
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setFadeHeight(float r4) {
        boolean r1 = true;
        if (this.c != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L12:
        this.c = r4;
        this.d = r4;
        a();
        invalidate();
        return;
    L8:
        if (this.d == r4) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L12;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTopFadeEnabled(boolean r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        invalidate();
        return;
    }

    public WindowFadingLayout(Context r4, float[] r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 6, 0);
        this.a.setXfermode(this.b);
        setClickable(false);
        setFocusable(false);
        this.i.setCornerRadii(r5);
        setBackground(this.i);
        setClipToOutline(true);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    }

    public WindowFadingLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Paint(1);
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.c = i5.d0();
        int r5 = aia.f.a;
        this.d = c7.b(132);
        this.e = true;
        this.f = true;
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(0);
        this.i = r6;
    }

    public /* synthetic */ WindowFadingLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a();
    }
}
