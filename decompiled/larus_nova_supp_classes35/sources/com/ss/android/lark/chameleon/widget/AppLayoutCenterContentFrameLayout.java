package com.ss.android.lark.chameleon.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AppLayoutCenterContentFrameLayout extends FrameLayout {
    private int appBarLayoutId;
    private int scrollContentId;

    private boolean isUsingAppBarLayoutScrollBehavior(View r1) {
        return false;
    }

    private int calHeightToAdjust() {
        View r0 = getRootView();
        if (r0 != null) goto L5;
        return 0;
    L5:
        View r2 = r0.findViewById(this.appBarLayoutId);
        View r1 = r0.findViewById(this.scrollContentId);
        if (r2 == null) goto L13;
        if (r1 != null) goto L10;
        return 0;
    L10:
        if (isUsingAppBarLayoutScrollBehavior(r1) == true) goto L12;
        return 0;
    L12:
        return r2.getMeasuredHeight();
    L13:
        return 0;
    }

    public AppLayoutCenterContentFrameLayout(Context r1) {
        super(r1);
        init(null);
    }

    private void init(AttributeSet r4) {
        if (r4 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130968807, 2130973936}, 0, 0);
        this.appBarLayoutId = r5.getResourceId(0, 0);
        this.scrollContentId = r5.getResourceId(1, 0);
        r5.recycle();
        return;
    }

    public AppLayoutCenterContentFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r1 = View.MeasureSpec.getSize(r4);
        if (r1 <= 0) goto L5;
        r4 = View.MeasureSpec.makeMeasureSpec(r1 - calHeightToAdjust(), r0);
    L5:
        super.onMeasure(r3, r4);
    }

    public AppLayoutCenterContentFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2);
    }

    public AppLayoutCenterContentFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        init(r2);
    }
}
