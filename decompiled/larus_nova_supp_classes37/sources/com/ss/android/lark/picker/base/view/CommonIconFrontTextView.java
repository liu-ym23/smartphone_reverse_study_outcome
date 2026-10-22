package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class CommonIconFrontTextView extends AppCompatTextView {
    private int drawableLeftHeight;
    private int drawableLeftWidth;
    private boolean isAlignCenter;

    public CommonIconFrontTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r1) {
        super/*android.widget.TextView*/.onDraw(r1);
    }

    public CommonIconFrontTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonIconFrontTextView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.isAlignCenter = true;
        initView(r2, r3, r4);
    }

    private void initView(Context r2, AttributeSet r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130969824, 2130969825, 2130970374});
        this.drawableLeftWidth = r5.getDimensionPixelSize(1, 0);
        this.drawableLeftHeight = r5.getDimensionPixelSize(0, 0);
        this.isAlignCenter = r5.getBoolean(2, true);
        r5.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setDrawable(Drawable r4, int r5, int r6) {
        if (r5 != 0) goto L4;
        r5 = r4.getIntrinsicWidth();
    L4:
        if (r6 != 0) goto L6;
        r6 = r4.getIntrinsicHeight();
    L6:
        int r0 = (int) ((((((getBottom() - getTop()) - getCompoundPaddingBottom()) - getCompoundPaddingTop()) * (1.0f - (1.0f / Math.min(getLineCount(), getMaxLines())))) * (-1.0f)) / 2.0f);
        if (this.isAlignCenter == false) goto L9;
        r0 = 0;
    L9:
        r4.setBounds(0, r0, r5, r6 + r0);
    }

    public void setCompoundDrawables(Drawable r3, Drawable r4, Drawable r5, Drawable r6) {
        if (r3 == null) goto L4;
        setDrawable(r3, this.drawableLeftWidth, this.drawableLeftHeight);
    L4:
        super.setCompoundDrawables(r3, r4, r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        Drawable[] r6 = getCompoundDrawables();
        setCompoundDrawables(r6[0], r6[1], r6[2], r6[3]);
    }
}
