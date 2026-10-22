package com.bytedance.android.live.browser.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {
    public boolean a;

    public ForceInterceptConstraintLayout(Context r1) {
        super(r1);
        this.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == false) goto L9;
        if (r2.getAction() == 0) goto L9;
        return true;
    L9:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 1) goto L5;
    L6:
        setForceInterceptTouchEvent(false);
    L8:
        return super/*android.view.ViewGroup*/.onTouchEvent(r3);
    L5:
        if (r3.getAction() != 3) goto L8;
        goto L6
    }

    public void setForceInterceptTouchEvent(boolean r1) {
        this.a = r1;
    }

    public ForceInterceptConstraintLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }

    public ForceInterceptConstraintLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = false;
    }
}
