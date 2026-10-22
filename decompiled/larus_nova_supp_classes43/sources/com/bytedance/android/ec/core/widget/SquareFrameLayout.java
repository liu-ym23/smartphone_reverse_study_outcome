package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(Context r1) {
        super(r1);
    }

    public SquareFrameLayout(Context r1, AttributeSet r10) {
        super(r1, r10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r10) {
        super.onMeasure(r1, r1);
    }

    public SquareFrameLayout(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
    }
}
