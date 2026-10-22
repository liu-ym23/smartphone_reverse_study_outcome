package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class MaxScrollView extends ScrollView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5605c;

    public MaxScrollView(Context r10) {
        super(r10);
        this.f5605c = 0;
    }

    public MaxScrollView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f5605c = 0;
    }

    public MaxScrollView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f5605c = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = this.f5605c;
        if (r12 <= 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r10, r11);
    }

    public void setMaxHeight(int r10) {
        this.f5605c = r10;
        requestLayout();
    }
}
