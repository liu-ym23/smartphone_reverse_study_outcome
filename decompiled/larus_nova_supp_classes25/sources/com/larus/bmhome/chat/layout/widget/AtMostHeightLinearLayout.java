package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class AtMostHeightLinearLayout extends LinearLayout {
    public AtMostHeightLinearLayout(Context r1) {
        super(r1);
    }

    public AtMostHeightLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (getVisibility() != 8) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        return;
    L5:
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AtMostHeightLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
