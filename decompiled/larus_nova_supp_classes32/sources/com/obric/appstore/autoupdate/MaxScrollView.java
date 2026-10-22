package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MaxScrollView extends ScrollView {
    public int a;

    public MaxScrollView(Context r1) {
        super(r1);
        this.a = 0;
    }

    public void setMaxHeight(int r1) {
        this.a = r1;
        requestLayout();
    }

    public MaxScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        int r0 = this.a;
        if (r0 <= 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r2, r3);
    }

    public MaxScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 0;
    }
}
