package com.bytedance.ies.xelement.viewpager.viewpager;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lynx.base.log.LynxLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/ReversingOnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReversingOnPageChangeListener implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager.OnPageChangeListener f6583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseCustomViewPager f6584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PagerAdapter f6585c;

    public ReversingOnPageChangeListener(ViewPager.OnPageChangeListener r5, BaseCustomViewPager r10, PagerAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "mListener");
        Intrinsics.checkNotNullParameter(r10, "mViewPager");
        this.f6583a = r5;
        this.f6584b = r10;
        this.f6585c = r11;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r5) {
        this.f6583a.onPageScrollStateChanged(r5);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r10, float r11, int r12) {
        BaseCustomViewPager r5 = this.f6584b;
        int r13 = r5.getWidth();
        if (r5.g == false) goto L16;
        PagerAdapter r14 = this.f6585c;
        if (r14 == null) goto L16;
        int r15 = r14.getCount();
        float r16 = r13;
        int r17 = ((int) ((1 - r14.getPageWidth(r10)) * r16)) + r12;
    L7:
        if (r10 >= r15) goto L10;
        if (r17 <= 0) goto L10;
        r10 = r10 + 1;
        r17 = r17 - ((int) (r14.getPageWidth(r10) * r16));
    L10:
        r10 = (r15 - r10) - 1;
        r12 = -r17;
        r11 = r12 / (r14.getPageWidth(r10) * r16);
    L16:
        this.f6583a.onPageScrolled(r10, r11, r12);     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        LynxLog.b(4, "ReversingOnPageChangeListener", e.toString());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r5) {
        if (this.f6584b.g == false) goto L7;
        PagerAdapter r10 = this.f6585c;
        if (r10 == null) goto L7;
        r5 = (r10.getCount() - r5) - 1;
    L7:
        this.f6583a.onPageSelected(r5);
    }
}
