package com.bytedance.android.live.browser.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PullDownCloseIndicatorContainer extends FrameLayout {
    public ForceInterceptConstraintLayout a;

    public PullDownCloseIndicatorContainer(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (this.a != null) goto L8;
        if ((getParent() instanceof ForceInterceptConstraintLayout) == false) goto L8;
        this.a = (ForceInterceptConstraintLayout) getParent();
    L8:
        if (r0 == 0) goto L20;
        if (r0 != 1) goto L11;
    L16:
        ForceInterceptConstraintLayout r5 = this.a;
        if (r5 == null) goto L19;
        r5.setForceInterceptTouchEvent(false);
    L19:
        return true;
    L11:
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L16;
        return super.onTouchEvent(r4);
    L20:
        ForceInterceptConstraintLayout r6 = this.a;
        if (r6 == null) goto L23;
        r6.setForceInterceptTouchEvent(true);
    L23:
        return true;
    }

    public PullDownCloseIndicatorContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public PullDownCloseIndicatorContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
