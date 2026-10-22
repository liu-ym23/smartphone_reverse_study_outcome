package com.mcxtzhang.swipemenulib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CstViewPager extends ViewPager {
    private static final String TAG = "zxt/CstViewPager";
    private int mLastX;
    private int mLastY;

    public CstViewPager(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public CstViewPager(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    private boolean isHorizontalScroll(int r2, int r3) {
        if (Math.abs(r3 - this.mLastY) >= Math.abs(r2 - this.mLastX)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isReachLastPage() {
        PagerAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
        return false;
    L5:
        if ((r0.getCount() - 1) != getCurrentItem()) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isReactFirstPage() {
        if (getCurrentItem() != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isScrollLeft(int r1) {
        if ((r1 - this.mLastX) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isScrollRight(int r1) {
        if ((r1 - this.mLastX) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = (int) r7.getX();
        int r1 = (int) r7.getY();
        if (r7.getAction() == 2) goto L6;
    L18:
        boolean r2 = false;
    L19:
        this.mLastX = r0;
        this.mLastY = r1;
        boolean r6 = super.onInterceptTouchEvent(r7);
        if (r2 == true) goto L25;
        if (r6 == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return true;
    L6:
        if (isHorizontalScroll(r0, r1) == false) goto L18;
        if (isReactFirstPage() == false) goto L13;
        if (isScrollRight(r0) == true) goto L18;
    L13:
        if (isReachLastPage() == true) goto L15;
    L17:
        r2 = true;
        goto L19
    L15:
        if (isScrollLeft(r0) == false) goto L17;
        goto L17
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }
}
