package com.bytedance.android.livesdk.feed.drawerfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.livesdk.feed.banner.BannerViewPager;
import uv1.e;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerBannerViewPager extends BannerViewPager {
    public DrawerBannerViewPager(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        b.a().post(new e(1));
    L11:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    L6:
        if (r0 == 3) goto L8;
    L9:
        b.a().post(new e(1));
        goto L11
    }

    public DrawerBannerViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
