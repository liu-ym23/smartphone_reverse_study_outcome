package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class AtMostHeightFrameLayout extends FrameLayout {
    public AtMostHeightFrameLayout(Context r1) {
        super(r1);
    }

    public AtMostHeightFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AtMostHeightFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
