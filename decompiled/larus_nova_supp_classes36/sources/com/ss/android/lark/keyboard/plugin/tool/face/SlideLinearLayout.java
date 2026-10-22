package com.ss.android.lark.keyboard.plugin.tool.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SlideLinearLayout extends LinearLayout {
    public SlideLinearLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        getParent().requestDisallowInterceptTouchEvent(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L11
    }

    public SlideLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SlideLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
