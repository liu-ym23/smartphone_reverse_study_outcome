package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.tasm.utils.i;
import com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements ViewPager.d {
    public boolean a;
    public final /* synthetic */ SwiperView b;
    public final /* synthetic */ XSwiperUI c;

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void d(int r4) {
        XSwiperUI r0 = this.c;
        if (r0.d == false) goto L8;
        m7a.a r1 = new m7a.a(r0.getSign(), "scrollend");
        r1.a("current", Integer.valueOf(r4));
        if (this.c.getLynxContext() == null) goto L9;
        this.c.getLynxContext().getEventEmitter().sendCustomEvent(r1);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void onPageScrollStateChanged(int r5) {
        XSwiperUI r0 = this.c;
        if (r0.n == true) goto L5;
        return;
    L5:
        if (r5 != 1) goto L8;
        this.a = true;
        r0.C.removeCallbacks(r0.E);
        return;
    L8:
        if (this.a == false) goto L13;
        this.a = false;
        r0.C.removeCallbacks(r0.E);
        XSwiperUI r6 = this.c;
        r6.C.postDelayed(r6.E, r6.q);
        return;
    }

    public c(XSwiperUI r1, SwiperView r2) {
        this.c = r1;
        this.b = r2;
        this.a = false;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void a(boolean r4, boolean r5) {
        XSwiperUI r0 = this.c;
        if (r0.f == false) goto L8;
        m7a.a r1 = new m7a.a(r0.getSign(), "scrolltobounce");
        r1.a("isToBegin", Boolean.valueOf(r4));
        r1.a("isToEnd", Boolean.valueOf(r5));
        if (this.c.getLynxContext() == null) goto L9;
        this.c.getLynxContext().getEventEmitter().sendCustomEvent(r1);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void c(int r4, boolean r5) {
        XSwiperUI r0 = this.c;
        if (r0.c == false) goto L8;
        m7a.a r1 = new m7a.a(r0.getSign(), "scrollstart");
        r1.a("current", Integer.valueOf(r4));
        r1.a("isDragged", Boolean.valueOf(r5));
        if (this.c.getLynxContext() == null) goto L9;
        this.c.getLynxContext().getEventEmitter().sendCustomEvent(r1);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void e(int r3, boolean r4) {
        SwiperView r0 = (SwiperView) XSwiperUI.U(this.c);
        r0.f = r3;
        r0.e();
        XSwiperUI r1 = this.c;
        if (r1.b == false) goto L9;
        if (r4 == true) goto L10;
        m7a.a r5 = new m7a.a(r1.getSign(), BaseLynxViewPager.BIND_ON_CHANGED);
        r5.a("current", Integer.valueOf(r3));
        if (this.c.getLynxContext() == null) goto L11;
        this.c.getLynxContext().getEventEmitter().sendCustomEvent(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.d
    public final void b(boolean r9, float r10, float r11) {
        this.c.recognizeGesturere();
        if (this.c.e == false) goto L13;
        long r0 = System.currentTimeMillis();
        XSwiperUI r2 = this.c;
        long r3 = r0 - r2.t;
        int r5 = r2.s;
        if (r5 > 0) goto L7;
    L9:
        r2.t = r0;
        m7a.a r1 = new m7a.a(r2.getSign(), "transition");
        r1.a("current", Integer.valueOf(this.b.a.getCurrentIndex()));
        r1.a("isDragged", Boolean.valueOf(r9));
        r1.a("dx", Float.valueOf(i.c(r10)));
        r1.a("dy", Float.valueOf(i.c(r11)));
        if (this.c.getLynxContext() == null) goto L14;
        this.c.getLynxContext().getEventEmitter().sendCustomEvent(r1);
        return;
    L14:
        return;
    L7:
        if (r3 > r5) goto L9;
        return;
    }
}
