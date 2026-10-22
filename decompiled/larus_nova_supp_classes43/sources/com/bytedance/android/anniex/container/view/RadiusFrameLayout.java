package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/container/view/RadiusFrameLayout;", "Landroid/widget/FrameLayout;", "", "radius", "", "setRadius", "", "radii", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class RadiusFrameLayout extends FrameLayout {
    public float[] a;
    public final Path b;
    public final RectF c;

    public RadiusFrameLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.b = new Path();
        this.c = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float[] r0 = this.a;
        if (r0 == null) goto L5;
        this.c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.b.reset();
        this.b.addRoundRect(this.c, r0, Path.Direction.CW);
        r10.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r10.clipPath(this.b);
    L5:
        super.dispatchDraw(r10);
    }

    @Override // android.view.View
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float[] r0 = this.a;
        if (r0 == null) goto L5;
        this.c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.b.reset();
        this.b.addRoundRect(this.c, r0, Path.Direction.CW);
        r10.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r10.clipPath(this.b);
    L5:
        super.draw(r10);
    }

    public final void setRadius(float r10) {
        this.a = new float[]{r10, r10, r10, r10, r10, r10, r10, r10};
        invalidate();
    }

    public final void setRadius(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "radii");
        this.a = r10;
        invalidate();
    }

    public RadiusFrameLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.b = new Path();
        this.c = new RectF();
    }

    public RadiusFrameLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.b = new Path();
        this.c = new RectF();
    }

    public final void a(float r10, float r11, float r12, float r13) {
        float r1 = 0;
        if (r10 <= r1) goto L5;
    L10:
        this.a = new float[]{r10, r10, r11, r11, r12, r12, r13, r13};
        invalidate();
        return;
    L5:
        if (r11 > r1) goto L10;
        if (r13 > r1) goto L10;
        if (r12 > r1) goto L10;
    }
}
