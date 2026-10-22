package com.bytedance.android.annie.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class PullDownCloseIndicatorContainer extends FrameLayout {
    public ForceInterceptConstraintLayout a;

    public PullDownCloseIndicatorContainer(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        int r0 = r10.getAction();
        if (this.a != null) goto L8;
        if ((getParent() instanceof ForceInterceptConstraintLayout) == false) goto L8;
        this.a = (ForceInterceptConstraintLayout) getParent();
    L8:
        if (r0 == 0) goto L20;
        if (r0 != 1) goto L11;
    L16:
        ForceInterceptConstraintLayout r11 = this.a;
        if (r11 == null) goto L19;
        r11.setForceInterceptTouchEvent(false);
    L19:
        return true;
    L11:
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L16;
        return super.onTouchEvent(r10);
    L20:
        ForceInterceptConstraintLayout r12 = this.a;
        if (r12 == null) goto L23;
        r12.setForceInterceptTouchEvent(true);
    L23:
        return true;
    }

    public PullDownCloseIndicatorContainer(Context r1, AttributeSet r10) {
        super(r1, r10);
    }

    public PullDownCloseIndicatorContainer(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
    }
}
