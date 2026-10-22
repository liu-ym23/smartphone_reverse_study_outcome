package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import bf.e;
import bf.f;
import bf.h;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "", "item", "", "setCurrentItem", "(I)V", "", "i", "Z", "getMPagerChangeAnimation", "()Z", "setMPagerChangeAnimation", "(Z)V", "mPagerChangeAnimation", "Lbf/e;", "j", "Lbf/e;", "getMTouchHandler", "()Lbf/e;", "setMTouchHandler", "(Lbf/e;)V", "mTouchHandler", "k", "getMForceCanScroll", "setMForceCanScroll", "mForceCanScroll", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomViewPagerNG extends BaseCustomViewPager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f6573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6574k;

    public CustomViewPagerNG(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        this.f6572i = true;
        setOverScrollMode(2);
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r5) {
        if (this.f6574k == false) goto L7;
        return true;
    L7:
        return super.canScrollHorizontally(r5);
    }

    public final boolean getMForceCanScroll() {
        return this.f6574k;
    }

    public final boolean getMPagerChangeAnimation() {
        return this.f6572i;
    }

    public final e getMTouchHandler() {
        return this.f6573j;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (getMAllowHorizontalGesture() == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Integer r10 = null;
        if (r5 == null) goto L5;
        Integer r11 = Integer.valueOf(r5.getActionMasked());
    L7:
        if (r11 == null) goto L13;
        if (r11.intValue() != 1) goto L13;
        performClick();
    L13:
        if (getMAllowHorizontalGesture() == false) goto L38;
        boolean r12 = super.onTouchEvent(r5);
        e r13 = this.f6573j;
        if (r13 == null) goto L37;
        f r14 = (f) r13;
        if (r5 == null) goto L19;
        r10 = Integer.valueOf(r5.getActionMasked());
    L19:
        LynxViewPagerNG r15 = r14.f912a;
        if (r10 != null) goto L23;
    L29:
        if (r10 == null) goto L37;
        if (r10.intValue() != 3) goto L37;
        if (r15.f6581o == false) goto L36;
        r15.l(((CustomViewPagerNG) ((h) r15.j()).getMViewPager()).getCurrentItem(), true);
    L36:
        r15.f6581o = false;
        goto L37
    L23:
        if (r10.intValue() != 1) goto L29;
        if (r15.f6581o == false) goto L27;
        r15.l(((CustomViewPagerNG) ((h) r15.j()).getMViewPager()).getCurrentItem(), true);
    L27:
        r15.f6581o = false;
        return r12;
    L37:
        return r12;
    L38:
        getMInterceptTouchEventListener();
        return false;
    L5:
        r11 = null;
        goto L7
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r5) {
        PagerAdapter r10 = super.getAdapter();
        if (r10 != null) goto L5;
    L7:
        super.setCurrentItem(r5, this.f6572i);
        return;
    L5:
        if (this.g == false) goto L7;
        r5 = (r10.getCount() - r5) - 1;
        goto L7
    }

    public final void setMForceCanScroll(boolean r5) {
        this.f6574k = r5;
    }

    public final void setMPagerChangeAnimation(boolean r5) {
        this.f6572i = r5;
    }

    public final void setMTouchHandler(e r5) {
        this.f6573j = r5;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r5, boolean r10) {
        PagerAdapter r11 = super.getAdapter();
        if (r11 != null) goto L5;
    L7:
        super.setCurrentItem(r5, r10);
        return;
    L5:
        if (this.g == false) goto L7;
        r5 = (r11.getCount() - r5) - 1;
        goto L7
    }
}
