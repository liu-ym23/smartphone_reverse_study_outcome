package com.ss.android.lark.reaction.widget.panel.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionDetailViewPager extends ViewPager {
    public ReactionDetailViewPager(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 != 0) goto L5;
        getParent().requestDisallowInterceptTouchEvent(true);
    L16:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    L5:
        if (r0 != 2) goto L16;
        if (getAdapter().getCount() != (getCurrentItem() + 1)) goto L10;
    L13:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L16
    L10:
        if (getCurrentItem() == 0) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L16
    }

    public ReactionDetailViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
