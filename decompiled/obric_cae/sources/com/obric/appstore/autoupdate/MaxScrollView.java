package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class MaxScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5363a;

    public MaxScrollView(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f5363a = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = this.f5363a;
        if (r11 <= 0) goto L5;
        r10 = View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r8, r10);
    }

    public void setMaxHeight(int r8) {
        this.f5363a = r8;
        requestLayout();
    }
}
