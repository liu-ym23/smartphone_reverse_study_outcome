package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class MaxScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11246a;

    public MaxScrollView(Context r5) {
        super(r5);
        this.f11246a = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = this.f11246a;
        if (r11 <= 0) goto L5;
        r10 = View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r5, r10);
    }

    public void setMaxHeight(int r5) {
        this.f11246a = r5;
        requestLayout();
    }

    public MaxScrollView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f11246a = 0;
    }

    public MaxScrollView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f11246a = 0;
    }
}
