package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ViewPagerWithoutScroll extends ViewPager {
    public boolean a;

    public ViewPagerWithoutScroll(Context r1) {
        super(r1);
        this.a = false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }

    public void setPagingEnabled(boolean r1) {
        this.a = r1;
    }

    public ViewPagerWithoutScroll(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }
}
