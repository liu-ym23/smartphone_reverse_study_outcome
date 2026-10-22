package com.bytedance.android.livesdk.interactivity.barrage.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class InterceptConstraintLayout extends ConstraintLayout {
    public boolean a;

    public InterceptConstraintLayout(Context r1) {
        super(r1);
        this.a = false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return this.a;
    }

    public void setmIsIntercept(boolean r1) {
        this.a = r1;
    }

    public InterceptConstraintLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }

    public InterceptConstraintLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = false;
    }
}
