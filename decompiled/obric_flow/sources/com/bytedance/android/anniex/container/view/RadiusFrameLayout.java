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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/container/view/RadiusFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "radius", "", "setRadius", "(F)V", "", "radii", "([F)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RadiusFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f3202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f3203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f3204c;

    public RadiusFrameLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f3203b = new Path();
        this.f3204c = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float[] r5 = this.f3202a;
        if (r5 == null) goto L5;
        float r11 = getPaddingLeft();
        float r12 = getPaddingTop();
        float r13 = getWidth() - getPaddingRight();
        float r14 = getHeight() - getPaddingBottom();
        RectF r15 = this.f3204c;
        r15.set(r11, r12, r13, r14);
        Path r16 = this.f3203b;
        r16.reset();
        r16.addRoundRect(r15, r5, Path.Direction.CW);
        r10.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r10.clipPath(r16);
    L5:
        super.dispatchDraw(r10);
    }

    @Override // android.view.View
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float[] r5 = this.f3202a;
        if (r5 == null) goto L5;
        float r11 = getPaddingLeft();
        float r12 = getPaddingTop();
        float r13 = getWidth() - getPaddingRight();
        float r14 = getHeight() - getPaddingBottom();
        RectF r15 = this.f3204c;
        r15.set(r11, r12, r13, r14);
        Path r16 = this.f3203b;
        r16.reset();
        r16.addRoundRect(r15, r5, Path.Direction.CW);
        r10.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r10.clipPath(r16);
    L5:
        super.draw(r10);
    }

    public final void setRadius(float r5) {
        this.f3202a = new float[]{r5, r5, r5, r5, r5, r5, r5, r5};
        invalidate();
    }

    public RadiusFrameLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f3203b = new Path();
        this.f3204c = new RectF();
    }

    public final void setRadius(float[] r5) {
        Intrinsics.checkNotNullParameter(r5, "radii");
        this.f3202a = r5;
        invalidate();
    }

    public RadiusFrameLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f3203b = new Path();
        this.f3204c = new RectF();
    }
}
