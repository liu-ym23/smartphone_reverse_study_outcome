package com.larksuite.component.universe_design.dialog.frame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import h18.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class MaxWidthLinearLayout extends LinearLayout {
    public final int a;

    public MaxWidthLinearLayout(Context r2) {
        super(r2);
        this.a = Math.round(d.b(getContext(), 450));
    }

    public MaxWidthLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = Math.round(d.b(getContext(), 450));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r3);
        int r5 = View.MeasureSpec.getMode(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(r0, this.a), r5), r4);
    }

    public MaxWidthLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = Math.round(d.b(getContext(), 450));
    }
}
