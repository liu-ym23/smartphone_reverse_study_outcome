package com.larus.dora.impl.device.settings.gesture.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/widget/DoraGGestureGuidanceMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maskColor", "hollowPath", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "targetRect", "Landroid/graphics/RectF;", "porterDuffXfermode", "Landroid/graphics/PorterDuffXfermode;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setTargetRect", "rect", "setDarkMode", "isDarkMode", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGGestureGuidanceMaskView extends View {
    public final Path a;
    public final Paint b;
    public RectF c;
    public final PorterDuffXfermode d;

    public static final class a {
    }

    static {
    }

    public DoraGGestureGuidanceMaskView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraGGestureGuidanceMaskView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        this.a.reset();
        this.a.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
        RectF r0 = this.c;
        if (r0 == null) goto L5;
        this.a.addRect(r0, Path.Direction.CCW);
    L5:
        this.b.setXfermode(this.d);
        r8.drawPath(this.a, this.b);
        this.b.setXfermode(null);
    }

    public final void setDarkMode(boolean r3) {
        if (r3 == false) goto L4;
        float r4 = 0.6f;
    L5:
        this.b.setAlpha((int) (255 * r4));
        return;
    L4:
        r4 = 0.15f;
        goto L5
    }

    public final void setTargetRect(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        this.c = r2;
        invalidate();
    }

    public DoraGGestureGuidanceMaskView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = ContextCompat.getColor(r2, 2131100641);
        this.a = new Path();
        Paint r6 = new Paint();
        r6.setAntiAlias(true);
        r6.setColor(r5);
        r6.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
        this.b = r6;
        this.d = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    public /* synthetic */ DoraGGestureGuidanceMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
