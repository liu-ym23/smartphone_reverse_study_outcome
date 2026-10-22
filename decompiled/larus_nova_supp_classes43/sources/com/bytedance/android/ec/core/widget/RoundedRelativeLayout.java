package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RoundedRelativeLayout extends RelativeLayout {
    public int a;

    public float getBorderRadius() {
        return this.a;
    }

    public RoundedRelativeLayout(Context r10) {
        this(r10, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        int r0 = this.a;
        super.dispatchDraw(r10);
    }

    public void setBorderRadius(int r1) {
        this.a = r1;
        invalidate();
    }

    public RoundedRelativeLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public RoundedRelativeLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.a = 0;
        TypedArray r13 = r10.getTheme().obtainStyledAttributes(r11, new int[]{2130972522, 2130973851}, r12, 0);
        if (r13.hasValue(1) == false) goto L5;
        this.a = r13.getDimensionPixelOffset(1, 0);
    L5:
        r13.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r10, int r11, int r12) {
        super.onSizeChanged(r1, r10, r11, r12);
        if (this.a <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new e0(this.a, r1, r10));
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r10, int r11, int r12, int r13) {
        super.onLayout(r1, r10, r11, r12, r13);
    }
}
