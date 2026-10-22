package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RoundRectLayout extends FrameLayout {
    public float a;
    public int b;
    public final Path c;
    public RectF d;

    public float getCornerRadius() {
        return this.a;
    }

    public RoundRectLayout(Context r1) {
        super(r1);
        this.c = new Path();
    }

    public final void a(AttributeSet r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130969639, 2130970054, 2130972492, 2130972512, 2130973766, 2130973793, 2130973831, 2130973837}, 0, 0);
        this.a = r5.getDimension(0, 0.0f);
        this.b = r5.getColor(1, 0);
        r5.recycle();
        setFillColor(this.b);
        setPadding(10, 10, 10, 10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        int r0 = r4.save();
        setLayerType(1, null);
        r4.clipPath(this.c);
        super.dispatchDraw(r4);
        r4.restoreToCount(r0);
    }

    public void setCornerRadius(float r1) {
        this.a = r1;
    }

    public void setFillColor(int r1) {
        this.b = r1;
    }

    public RoundRectLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new Path();
        a(r2);
    }

    public RoundRectLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new Path();
        a(r2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.d = new RectF(0.0f, 0.0f, r1 * 1.0f, r2 * 1.0f);
        this.c.reset();
        Path r5 = this.c;
        RectF r6 = this.d;
        float r7 = this.a;
        r5.addRoundRect(r6, r7, r7, Path.Direction.CW);
        this.c.close();
        GradientDrawable r8 = new GradientDrawable();
        r8.setCornerRadius(this.a);
        r8.setColor(this.b);
        setBackground(r8);
    }
}
