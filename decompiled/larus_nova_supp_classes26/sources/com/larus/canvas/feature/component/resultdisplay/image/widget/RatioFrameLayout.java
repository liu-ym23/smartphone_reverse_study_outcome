package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/widget/RatioFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetWidth", "targetHeight", "setTargetSize", "", "width", "height", "checkRatio", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatioFrameLayout extends FrameLayout {
    public int a;
    public int b;

    public static final class a {
    }

    static {
    }

    public RatioFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RatioFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(int r7, int r8) {
        if (r7 == this.a) goto L5;
    L6:
        this.a = r7;
        this.b = r8;
        if (r7 <= 0) goto L15;
        if (r8 <= 0) goto L15;
        double r2 = r8;
        double r0 = ((double) r7) / r2;
        if (r0 >= 0.4d) goto L13;
        this.a = (int) (r2 * 0.4d);
        goto L15
    L13:
        if (r0 <= 3.0d) goto L15;
        this.b = r7 / 3;
    L15:
        requestLayout();
        return;
    L5:
        if (r8 != this.b) goto L6;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (this.a > 0) goto L5;
    L7:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (this.b <= 0) goto L7;
        float r4 = Math.min(View.MeasureSpec.getSize(r2) / this.a, View.MeasureSpec.getSize(r3) / this.b);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.a * r4), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.b * r4), 1073741824));
    }

    public RatioFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = -1;
        this.b = -1;
    }

    public /* synthetic */ RatioFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
