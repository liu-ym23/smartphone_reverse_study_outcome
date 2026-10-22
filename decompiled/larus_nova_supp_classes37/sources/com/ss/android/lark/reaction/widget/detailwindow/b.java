package com.ss.android.lark.reaction.widget.detailwindow;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements ViewPager.OnPageChangeListener {
    public final /* synthetic */ a a;

    public final void onPageScrollStateChanged(int r1) {
    }

    public b(a r1) {
        this.a = r1;
    }

    public final void onPageSelected(int r3) {
        a r0 = this.a;
        r0.q = r3;
        r0.r = ((o2c.a) ListProtector.get(r0.o, r3)).a.f;
        ReactionPopupFacade.d r1 = ((ReactionPopupFacade.a) this.a.l).a.g;
        if (r1 == null) goto L6;
        r1.a(r3);
        return;
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
        a r4 = this.a;
        r4.q = r1;
        r4.r = ((o2c.a) ListProtector.get(r4.o, r1)).a.f;
    }
}
