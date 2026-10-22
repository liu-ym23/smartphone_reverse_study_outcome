package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", "Landroid/view/View;", "", "bgColor", "", "setDashLineColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalDashLineView extends View {
    public final Paint a;
    public final Path b;
    public int c;
    public float d;
    public float e;
    public DashPathEffect f;

    public VerticalDashLineView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public VerticalDashLineView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        this.a.setColor(this.c);
        this.a.setStrokeWidth(this.d);
        this.a.setPathEffect(this.f);
        float r0 = getWidth() / 2;
        this.b.reset();
        this.b.moveTo(r0, getHeight() + this.e);
        this.b.lineTo(r0, 0.0f);
        r10.drawPath(this.b, this.a);
    }

    public final void setDashLineColor(int r1) {
        this.c = r1;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r10) {
        super.onMeasure(r1, r10);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    public VerticalDashLineView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        Paint r13 = new Paint(1);
        this.a = r13;
        this.b = new Path();
        this.c = (int) 4294847573L;
        this.d = 1.0f;
        r13.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ VerticalDashLineView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    public final void a(float r10, float r11, float r12, float r13) {
        this.d = r10;
        this.e = r13;
        if (r11 != 0.0f) goto L5;
    L8:
        this.f = null;
    L9:
        getLayoutParams().width = (int) ((getPaddingLeft() + getPaddingRight()) + r10);
        requestLayout();
        return;
    L5:
        if (r12 == 0.0f) goto L8;
        this.f = new DashPathEffect(new float[]{r11, r12}, 0.0f);
        goto L9
    }
}
