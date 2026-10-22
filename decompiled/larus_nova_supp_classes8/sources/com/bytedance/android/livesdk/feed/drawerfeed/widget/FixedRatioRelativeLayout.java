package com.bytedance.android.livesdk.feed.drawerfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FixedRatioRelativeLayout extends RelativeLayout {
    public float a;

    public FixedRatioRelativeLayout(Context r1) {
        super(r1);
        this.a = 1.0f;
    }

    public void setRatio(float r1) {
        this.a = r1;
    }

    public FixedRatioRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 1.0f;
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

    public FixedRatioRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 1.0f;
    }
}
