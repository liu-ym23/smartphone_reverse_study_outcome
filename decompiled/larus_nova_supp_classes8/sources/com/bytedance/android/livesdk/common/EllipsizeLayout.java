package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EllipsizeLayout extends LinearLayout {
    public EllipsizeLayout(Context r2) {
        this(r2, null);
    }

    public EllipsizeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r17, int r18) {
        if (getOrientation() != 0) goto L41;
        if (View.MeasureSpec.getMode(r17) != 1073741824) goto L41;
        int r0 = getChildCount();
        int r1 = 0;
        TextView r2 = null;
        int r3 = 0;
        boolean r4 = false;
        int r5 = 0;
    L7:
        boolean r6 = true;
        if (r3 >= r0) goto L28;
        if (r4 == true) goto L28;
        View r14 = getChildAt(r3);
        if (r14 == null) goto L26;
        if (r14.getVisibility() == 8) goto L26;
        if ((r14 instanceof TextView) == false) goto L21;
        TextView r7 = (TextView) r14;
        if (r7.getEllipsize() == null) goto L21;
        if (r2 != null) goto L20;
        r7.setMaxWidth(Integer.MAX_VALUE);
        r2 = r7;
        goto L21
    L20:
        r4 = true;
    L21:
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14.getLayoutParams();
        if (r15.weight > 0.0f) goto L25;
        r6 = false;
    L25:
        r4 = r4 | r6;
        measureChildWithMargins(r14, r17, 0, r18, 0);
        r5 = r5 + ((r14.getMeasuredWidth() + r15.leftMargin) + r15.rightMargin);
    L26:
        r3 = r3 + 1;
    L28:
        if (r2 == null) goto L32;
        if (r5 == 0) goto L32;
        r6 = false;
    L32:
        boolean r8 = r4 | r6;
        int r9 = View.MeasureSpec.getSize(r17);
        if (r8 == true) goto L41;
        if (r5 <= r9) goto L41;
        int r10 = r2.getMeasuredWidth() - (r5 - r9);
        if (r10 < 0) goto L39;
        r1 = r10;
    L39:
        r2.setMaxWidth(r1);
    L41:
        super.onMeasure(r17, r18);
    }

    public EllipsizeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
