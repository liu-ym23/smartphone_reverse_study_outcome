package com.bytedance.android.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MaxWidthLinearLayout extends LinearLayout {
    public int a;

    public MaxWidthLinearLayout(Context r1) {
        super(r1);
    }

    public void setMaxWidth(int r1) {
        this.a = r1;
    }

    public MaxWidthLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        if (this.a <= 0) goto L7;
        int r0 = View.MeasureSpec.getMode(r4);
        int r1 = View.MeasureSpec.getSize(r4);
        int r2 = this.a;
        if (r1 <= r2) goto L7;
        r4 = View.MeasureSpec.makeMeasureSpec(r2, r0);
    L7:
        super.onMeasure(r4, r5);
    }

    public MaxWidthLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
