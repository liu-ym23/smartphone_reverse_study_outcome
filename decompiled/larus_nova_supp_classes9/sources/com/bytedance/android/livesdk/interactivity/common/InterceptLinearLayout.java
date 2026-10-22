package com.bytedance.android.livesdk.interactivity.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class InterceptLinearLayout extends LinearLayout {
    public boolean a;

    public InterceptLinearLayout(Context r1) {
        super(r1);
        this.a = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return this.a;
    }

    public void setIsIntercept(boolean r1) {
        this.a = r1;
    }

    public InterceptLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }

    public InterceptLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = false;
    }
}
