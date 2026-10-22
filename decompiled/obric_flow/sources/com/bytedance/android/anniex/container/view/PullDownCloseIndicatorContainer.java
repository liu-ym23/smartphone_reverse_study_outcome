package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class PullDownCloseIndicatorContainer extends FrameLayout {
    public PullDownCloseIndicatorContainer(Context r5) {
        super(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        int r10 = r5.getAction();
        getParent();
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L11;
        if (r10 == 3) goto L11;
        return super.onTouchEvent(r5);
    L11:
        return true;
    }

    public PullDownCloseIndicatorContainer(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public PullDownCloseIndicatorContainer(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
