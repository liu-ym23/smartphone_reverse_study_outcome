package com.lynx.xelement.viewpager.viewpager;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/ReversingOnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public final class ReversingOnPageChangeListener implements ViewPager.OnPageChangeListener {
    public final ViewPager.OnPageChangeListener a;
    public final BaseCustomViewPager b;
    public final PagerAdapter c;

    public final void onPageScrollStateChanged(int r2) {
        this.a.onPageScrollStateChanged(r2);
    }

    public final void onPageSelected(int r3) {
        PagerAdapter r0 = this.c;
        if (this.b.g == false) goto L6;
        if (r0 == null) goto L6;
        r3 = (r0.getCount() - r3) - 1;
    L6:
        this.a.onPageSelected(r3);
    }

    public ReversingOnPageChangeListener(ViewPager.OnPageChangeListener r2, BaseCustomViewPager r3, PagerAdapter r4) {
        Intrinsics.checkNotNullParameter(r2, "mListener");
        Intrinsics.checkNotNullParameter(r3, "mViewPager");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void onPageScrolled(int r6, float r7, int r8) {
        int r0 = this.b.getWidth();
        PagerAdapter r1 = this.c;
        if (this.b.g == false) goto L15;
        if (r1 == null) goto L15;
        int r9 = r1.getCount();
        float r2 = r0;
        int r3 = ((int) ((1 - r1.getPageWidth(r6)) * r2)) + r8;
    L6:
        if (r6 >= r9) goto L9;
        if (r3 <= 0) goto L9;
        r6 = r6 + 1;
        r3 = r3 - ((int) (r1.getPageWidth(r6) * r2));
    L9:
        r6 = (r9 - r6) - 1;
        r8 = -r3;
        r7 = r8 / (r2 * r1.getPageWidth(r6));
    L15:
        this.a.onPageScrolled(r6, r7, r8);     // Catch: NullPointerException -> L12
        return;
    L12:
        e = move-exception;
        LLog.e("ReversingOnPageChangeListener", e.toString());
    }
}
