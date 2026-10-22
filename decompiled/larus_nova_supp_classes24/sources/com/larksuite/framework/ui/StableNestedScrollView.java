package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class StableNestedScrollView extends NestedScrollView {
    public StableNestedScrollView(Context r1) {
        super(r1);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return super.onInterceptTouchEvent(r1);
    L4:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    L4:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return false;
    }

    public StableNestedScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public StableNestedScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
