package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import jm.a;

/* JADX INFO: loaded from: classes2.dex */
public class BannerViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6392a;

    public BannerViewPager(Context r5) {
        super(r5);
        this.f6392a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this, 7));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.f6392a == true) goto L5;
        return false;
    L5:
        if (getCurrentItem() != 0) goto L10;
        if (getChildCount() != 0) goto L10;
        return false;
    L10:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.f6392a == true) goto L5;
    L13:
        return false;
    L5:
        if (getCurrentItem() == 0) goto L7;
    L14:
        return super.onTouchEvent(r5);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L7:
        if (getChildCount() != 0) goto L14;
        return false;
    }

    public void setScrollable(boolean r5) {
        this.f6392a = r5;
    }

    public BannerViewPager(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f6392a = true;
        setLayerType(2, null);
    }
}
