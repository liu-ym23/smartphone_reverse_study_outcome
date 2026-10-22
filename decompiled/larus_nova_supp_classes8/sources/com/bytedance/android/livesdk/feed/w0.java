package com.bytedance.android.livesdk.feed;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ LiveDrawerPagerSlidingTabStrip a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LiveDrawerPagerSlidingTabStrip r0 = this.a;
        r0.h = r0.f.getCurrentItem();
        LiveDrawerPagerSlidingTabStrip r1 = this.a;
        int r2 = r1.h;
        int r3 = r1.e.getChildCount();
        if (r3 == 0) goto L21;
        if (r2 < 0) goto L21;
        if (r2 >= r3) goto L21;
        View r4 = r1.e.getChildAt(r2);
        r4.setSelected(true);
        Object r5 = r4.getTag();
        if ((r5 instanceof LiveDrawerPagerSlidingTabStrip.d) == false) goto L21;
        LiveDrawerPagerSlidingTabStrip.d r6 = (LiveDrawerPagerSlidingTabStrip.d) r5;
        String r7 = r1.F.get(r2);
        if (TextUtils.isEmpty(r7) == true) goto L16;
        View r8 = r6.c;
        if ((r8 instanceof HSImageView) == false) goto L16;
        r8.setVisibility(0);
        ImageLoader.bindImage(r6.c, r7);
    L16:
        if (TextUtils.isEmpty(r1.G.get(r2)) == true) goto L19;
        r6.a.setTextColor(s1.i(r1.G.get(r2), r1.n));
    L19:
        if (r1.M != 1) goto L21;
        r6.a.setTypeface(Typeface.DEFAULT_BOLD);
    L21:
        LiveDrawerPagerSlidingTabStrip r9 = this.a;
        LiveDrawerPagerSlidingTabStrip.a(r9, r9.h, 0);
    }

    public w0(LiveDrawerPagerSlidingTabStrip r1) {
        this.a = r1;
    }
}
