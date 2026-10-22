package com.bytedance.android.live.search.impl.search.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class FixedRatioRelativeLayout extends RelativeLayout {
    public float a;

    public FixedRatioRelativeLayout(Context r2) {
        this(r2, null);
    }

    public void setRatio(float r1) {
        this.a = r1;
    }

    public FixedRatioRelativeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r4);
        float r1 = this.a;
        if (r1 <= 0.0f) goto L5;
        r5 = View.MeasureSpec.makeMeasureSpec((int) (r0 / r1), 1073741824);
    L5:
        super.onMeasure(r4, r5);
    }

    public FixedRatioRelativeLayout(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.a = 1.0f;
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130973728}, r7, 0);
        if (r8 == null) goto L6;
        this.a = r8.getFloat(0, 1.0f);
        r8.recycle();
        return;
    }
}
