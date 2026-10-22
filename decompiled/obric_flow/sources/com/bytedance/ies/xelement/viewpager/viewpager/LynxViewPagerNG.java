package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import bf.f;
import bf.h;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.lynx.animax.i;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/LynxViewPagerNG;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG;", "Lbf/h;", "", "enable", "", "setPageChangeAnimation", "(Z)V", "setForceCanScroll", "setSinglePageTouch", "isAlwaysOverScroll", "setAndroidAlwaysOverscroll", "isDistinguish", "setDistinguishSwipeTap", "", "selectIndex", "setInitialSelect", "(I)V", "setEnableScroll", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "setDragGesture", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxViewPagerNG extends BaseLynxViewPager<CustomViewPagerNG, h> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6581o;

    public LynxViewPagerNG(b0 r5, z r10) {
        super(r5, r10);
        this.f6577k = true;
        this.f6580n = -1;
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void b(Context r5) {
        super.b(r5);
        ((CustomViewPagerNG) ((h) j()).getMViewPager()).setMTouchHandler(new f(this));
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void c(LynxViewpagerItem r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        h r11 = (h) j();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        r11.setMChanged(true);
        if (r11.getMTabLayout() != null) goto L5;
    L7:
        if (r10 >= 0) goto L9;
    L12:
        r11.getMPendingChildren().add(r5);
        return;
    L9:
        if (r10 > r11.getMPendingChildren().size()) goto L12;
        r11.getMPendingChildren().add(r10, r5);
        return;
    L5:
        if (Intrinsics.areEqual(r11.H, Boolean.TRUE) == false) goto L7;
        r10 = r10 - 1;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        h r10 = new h(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f = r10;
        b(r5);
        return (h) j();
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void i(int r5) {
        if (this.f6579m == r5) goto L6;
        this.f6579m = r5;
        m(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    public final void k() {
        ((CustomViewPagerNG) ((h) j()).getMViewPager()).addOnPageChangeListener(new LynxViewPagerNG$initViewPagerChangeListener$1(this));
    }

    public final void l(int r5, boolean r10) {
        r r11 = getLynxContext().g;
        i r12 = new i(getSign(), "willchange");
        r12.a("isDragged", Boolean.valueOf(r10));
        r12.a("index", Integer.valueOf(r5));
        r11.b(r12);
    }

    public final void m(int r5) {
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter("", "scene");
        r r10 = getLynxContext().g;
        i r11 = new i(getSign(), "change");
        r11.a("isDragged", Boolean.valueOf(this.f6575i));
        r11.a("index", Integer.valueOf(r5));
        r10.b(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        if (this.mFirstRender == false) goto L13;
        int r5 = this.f6580n;
        if (r5 == (-1)) goto L13;
        if (r5 < 0) goto L13;
        PagerAdapter r10 = ((CustomViewPagerNG) ((h) j()).getMViewPager()).getAdapter();
        if (r10 == null) goto L10;
        int r11 = r10.getCount();
    L11:
        if (r5 >= r11) goto L13;
        ((h) j()).setCurrentSelectIndex(this.f6580n);
        this.f6579m = ((CustomViewPagerNG) ((h) j()).getMViewPager()).getCurrentItem();
        goto L13
    L10:
        r11 = 0;
    L13:
        this.mFirstRender = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        ((h) j()).f23113a.setCurrentItem(0, false);
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager
    @f0
    public void selectTab(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("success", Boolean.FALSE);
        if (r10.hasKey("index") == false) goto L27;
        int r12 = r10.getInt("index");
        if (r12 < 0) goto L23;
        PagerAdapter r13 = ((CustomViewPagerNG) ((h) j()).getMViewPager()).getAdapter();
        if (r13 == null) goto L9;
        int r14 = r13.getCount();
    L10:
        if (r12 >= r14) goto L23;
        l(r12, false);
        if (r10.hasKey("smooth") == false) goto L18;
        boolean r15 = r10.getBoolean("smooth", true);
        ((h) j()).f23113a.setCurrentItem(r12, r15);
        if (r15 == false) goto L16;
    L19:
        r5.put("success", Boolean.TRUE);
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{0, r5});
        return;
    L31:
        return;
    L16:
        if (this.f6579m == ((CustomViewPagerNG) ((h) j()).getMViewPager()).getCurrentItem()) goto L19;
        int r16 = ((CustomViewPagerNG) ((h) j()).getMViewPager()).getCurrentItem();
        this.f6579m = r16;
        m(r16);
        goto L19
    L18:
        ((h) j()).f23113a.setCurrentItem(r12, true);
        goto L19
    L9:
        r14 = 0;
    L23:
        r5.put("msg", "index out of bounds");
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{4, r5});
        return;
    L32:
        return;
    L27:
        r5.put("msg", "no index key");
        if (r11 == null) goto L33;
        r11.invoke(new Object[]{4, r5});
        return;
    }

    @c0(defaultBoolean = false, name = "android-always-overscroll")
    public final void setAndroidAlwaysOverscroll(boolean r5) {
        ((h) j()).setViewPagerOverScrollMode(r5);
    }

    @c0(defaultBoolean = true, name = "android-distinguish-swipe-tap")
    public final void setDistinguishSwipeTap(boolean r5) {
        this.f6577k = r5;
    }

    @f0
    public final void setDragGesture(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.put("success", Boolean.FALSE);
        if (r5.hasKey("canDrag") == false) goto L5;
        setAllowHorizontalGesture(r5.getBoolean("canDrag"));
    L5:
        if (r10 == null) goto L8;
        r10.invoke(new Object[]{0, r11});
        return;
    }

    @c0(name = "enable-scroll")
    public final void setEnableScroll(boolean r5) {
        ((h) j()).setAllowHorizontalGesture(r5);
    }

    @c0(name = "android-force-can-scroll")
    public final void setForceCanScroll(boolean r5) {
        ((h) j()).setForceCanScroll(r5);
    }

    @c0(name = "initial-select-index")
    public final void setInitialSelect(int r5) {
        this.f6580n = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(int r5) {
        super.setOverflow(r5);
        boolean r10 = true;
        if (r5 == 1) goto L6;
        r10 = false;
    L6:
        ((h) j()).setClipChildren(r10);
        ((CustomViewPagerNG) ((h) j()).getMViewPager()).setClipChildren(r10);
    }

    @c0(name = "page-change-animation")
    public final void setPageChangeAnimation(boolean r5) {
        ((h) j()).setPagerChangeAnimation(r5);
    }

    @c0(name = "single-page-touch")
    public final void setSinglePageTouch(boolean r5) {
        this.f6578l = r5;
    }
}
