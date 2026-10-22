package com.obric.oui.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
class CalendarPager extends ViewPager {
    public boolean a;

    public CalendarPager(Context r1) {
        super(r1);
        this.a = true;
    }

    public final boolean canScrollHorizontally(int r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.view.ViewGroup*/.canScrollVertically(r2) == false) goto L7;
        return true;
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

    public CalendarPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
    }
}
