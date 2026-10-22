package com.bytedance.android.annie.api.view;

import a7.b;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/annie/api/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "La7/b;", "", "radius", "", "setRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public class RadiusLayout extends FrameLayout implements b {
    public float[] a;
    public final Path b;

    public RadiusLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.b = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float[] r0 = this.a;
        if (r0 == null) goto L5;
        RectF r1 = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.b.reset();
        this.b.addRoundRect(r1, r0, Path.Direction.CW);
        r10.clipPath(this.b);
    L5:
        super.dispatchDraw(r10);
    }

    public void setRadius(float r10) {
        this.a = new float[]{r10, r10, r10, r10, r10, r10, r10, r10};
        invalidate();
    }

    public RadiusLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.b = new Path();
    }

    public RadiusLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.b = new Path();
    }

    public void setRadius(float r10, float r11, float r12, float r13) {
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
