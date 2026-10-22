package com.obric.oui.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes3.dex */
class CalendarPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12169a;

    public CalendarPager(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.f12169a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r5) {
        if (this.f12169a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r5) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.f12169a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.f12169a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.f12169a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r5) == false) goto L7;
        return true;
    }
}
