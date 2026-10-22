package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AlignParentWidthRelativeLayout extends RelativeLayout {
    public AlignParentWidthRelativeLayout(Context r1) {
        super(r1);
    }

    public AlignParentWidthRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        int r7 = getMeasuredWidth();
        int r8 = getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L8;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() == 8) goto L7;
        ((RelativeLayout.LayoutParams) r1.getLayoutParams()).width = r7;
    L7:
        r0 = r0 + 1;
        goto L3
    }

    public AlignParentWidthRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
