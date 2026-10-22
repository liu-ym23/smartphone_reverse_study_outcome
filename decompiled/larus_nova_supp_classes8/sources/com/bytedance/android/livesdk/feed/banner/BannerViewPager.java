package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.uikit.rtl.RtlViewPager;
import com.bytedance.android.livesdkapi.view.ISupportNestedScrollViewPager;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BannerViewPager extends RtlViewPager {
    public static final /* synthetic */ int d = 0;
    public boolean a;
    public Boolean b;
    public MotionEvent c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private ISupportNestedScrollViewPager getParentViewPager() {
        ?? r0 = this;
    L3:
        if (r0 == 0) goto L8;
        if ((r0 instanceof ISupportNestedScrollViewPager) == true) goto L8;
        r0 = r0.getParent();
    L8:
        return (ISupportNestedScrollViewPager) r0;
    }

    public final void i() {
        if (this.a == false) goto L5;
        return;
    L5:
        Logger.d("BannerViewPager", "enableParent");
        this.a = true;
        ISupportNestedScrollViewPager r0 = getParentViewPager();
        if (r0 == null) goto L11;
        Boolean r1 = this.b;
        if (r1 == null) goto L12;
        r0.supportNestViewPagerNoScroll(r1.booleanValue());
        this.b = null;
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        if (getChildCount() > 1) goto L6;
        return;
    L6:
        if (this.a == true) goto L8;
        return;
    L8:
        Logger.d("BannerViewPager", "disableParent");
        this.a = false;
        ISupportNestedScrollViewPager r1 = getParentViewPager();
        if (r1 != null) goto L11;
        return;
    L11:
        if (this.b != null) goto L13;
        this.b = Boolean.valueOf(r1.isSupportNestViewPagerNoScroll());
    L13:
        r1.supportNestViewPagerNoScroll(false);
    }

    public BannerViewPager(Context r1) {
        super(r1);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        boolean r0 = super/*androidx.viewpager.widget.ViewPager*/.onInterceptTouchEvent(r4);
        if (r4.getAction() != 0) goto L6;
        h();
    L10:
        this.c = r4;
        return r0;
    L6:
        if (r4.getAction() != 2) goto L9;
        if (r0 == false) goto L10;
        h();
        goto L10
    L9:
        i();
        goto L10
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        super.setOnPageChangeListener(r1);
    }

    public BannerViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
