package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import bf.a;
import bf.b;
import bf.c;
import bf.d;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.xelement.overlay.e;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.google.android.material.tabs.TabLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.p;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.i;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001d\u0010\u000bJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0007H\u0007¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0007H\u0007¢\u0006\u0004\b&\u0010\u000bJ\u0017\u0010'\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b'\u0010\u001aJ\u0017\u0010(\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b(\u0010\u001aJ\u0017\u0010)\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b)\u0010\u001aJ\u0017\u0010*\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010+\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0004\b+\u0010\u001aJ\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0017H\u0007¢\u0006\u0004\b-\u0010\u001aJ\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0017H\u0007¢\u0006\u0004\b/\u0010\u001aJ\u0017\u00100\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b0\u0010\u000bJ\u0017\u00103\u001a\u00020\t2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\t2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b5\u00104J\u0017\u00107\u001a\u00020\t2\u0006\u00106\u001a\u00020\rH\u0007¢\u0006\u0004\b7\u0010\u0010J\u0017\u00109\u001a\u00020\t2\u0006\u00108\u001a\u000201H\u0007¢\u0006\u0004\b9\u00104J#\u0010>\u001a\u00020\t2\u0006\u0010;\u001a\u00020:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<H'¢\u0006\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "K", "Lxe/i;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/u0;", "", "color", "", "setBackground", "(Ljava/lang/String;)V", "setTabbarBackground", "", OpenPageMethod.ALIGN_LEFT, "setTabPaddingLeft", "(I)V", "right", "setTabPaddingRight", "top", "setTabPaddingTop", "bottom", "setTabPaddingBottom", "", "textSize", "setSelectedTextSize", "(F)V", "setSelectedTextColor", "setUnSelectedTextSize", "setUnSelectedTextColor", "setTabIndicatorColor", "bool", "setIndicatorVisibility", "value", "setTabInterspace", "gravity", "setTablayoutGravity", "boldMode", "setTextBoldMode", "setTabHeight", "setTabHeightRpx", "setTabIndicatorWidth", "setTabIndicatorHeight", "setTabIndicatorRadius", "height", "setBorderHeight", "width", "setBorderWidth", "setBorderLineColor", "", "enable", "setTabBarDragEnable", "(Z)V", "setAllowHorizontalGesture", "selectIndex", "setSelect", "keepItemView", "setKeepItemView", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseLynxViewPager<K extends BaseCustomViewPager, T extends i> extends UISimpleView<T> implements u0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f6568h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6571c;
    public String d;
    public boolean e;
    public i f;
    public c g;

    public BaseLynxViewPager(b0 r5, z r10) {
        super(r5, r10);
        this.f6570b = true;
        this.d = "";
    }

    public void b(Context r5) {
        j().getMViewPager().setMInterceptTouchEventListener(new a(this));
        this.g = new c();
        j().setTabSelectedListener$x_element_fold_view_release(this.g);
        j().setTabClickListenerListener(new d(this));
        k();
        j().addOnAttachStateChangeListener(new b(this, 0));
    }

    public abstract void c(LynxViewpagerItem r5, int r10);

    public void i(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if ((r5 instanceof LynxUI) == false) goto L20;
        this.mChildren.add(r10, r5);
        ((LynxUI) r5).setParent(this);
        if ((r5 instanceof LynxViewpagerItem) == false) goto L15;
        LynxViewpagerItem r11 = (LynxViewpagerItem) r5;
        if (r11.getProps().containsKey("tag") == false) goto L12;
        StringBuilder r12 = p.d(r10, "insertChild: at ", " with tag = ");
        r12.append(String.valueOf(r11.f6548a));
        LynxLog.b(2, "LynxViewPager", r12.toString());
        i r13 = j();
        String r14 = String.valueOf(r11.f6548a);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "tag");
        r13.f23117i.add(r14);
        if (r14.length() <= 0) goto L11;
        r13.c(null);
    L11:
        al.a r15 = new al.a(this, r10);
        Intrinsics.checkNotNullParameter(r15, "mPropChaneListener");
        r11.f6549b = r15;
    L12:
        c(r11, r10);
        return;
    L15:
        if ((r5 instanceof LynxTabBarView) == false) goto L18;
        j().setTabBarElementAdded(true);
        j().setTabLayout((LynxTabBarView) r5);
        return;
    L18:
        LynxLog.b(4, "LynxViewPager", "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }

    public final i j() {
        i r5 = this.f;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        return null;
    }

    public abstract void k();

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        int r5 = this.mChildren.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L15;
        LynxBaseUI r11 = this.mChildren.get(r10);
        if (this.e == true) goto L12;
        if ((r11 instanceof LynxUI) == false) goto L12;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r11).getView()) == true) goto L12;
    L14:
        r10 = r10 + 1;
    L12:
        if ((r11 instanceof UIGroup) == false) goto L14;
        ((UIGroup) r11).layoutChildren();
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r10) {
        Intrinsics.checkNotNullParameter(r10, "child");
        if ((r10 instanceof LynxUI) == false) goto L32;
        this.mChildren.remove(r10);
        ze.a r5 = null;
        ((LynxUI) r10).setParent(null);
        if ((r10 instanceof LynxViewpagerItem) == false) goto L20;
        LynxViewpagerItem r11 = (LynxViewpagerItem) r10;
        if (r11.getProps().containsKey("tag") == false) goto L17;
        i r12 = j();
        String r13 = String.valueOf(r11.f6548a);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "tag");
        if (r13.length() == 0) goto L17;
        ArrayList r14 = r12.f23117i;
        if (r14.contains(r13) == false) goto L15;
        r14.remove(r13);
    L15:
        if (r14.size() <= 0) goto L17;
        r12.c(null);
    L17:
        i r15 = j();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r11, "child");
        r15.f = true;
        r15.f23116h.remove(r11);
        return;
    L20:
        if ((r10 instanceof LynxTabBarView) == false) goto L30;
        i r16 = j();
        ze.a r17 = ((LynxTabBarView) r10).f6514b;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L25:
        if (r5 == null) goto L28;
        r16.removeView(r5);
        return;
    L28:
        r16.getClass();
        return;
    L24:
        r5 = r17;
        goto L25
    L30:
        LynxLog.b(4, "LynxViewPager", "x-viewpager's child illegal, please check behaviors or child tag");
        return;
    }

    @f0
    public abstract void selectTab(ReadableMap r5, Callback r10);

    @c0(name = "allow-horizontal-gesture")
    public final void setAllowHorizontalGesture(boolean r5) {
        j().setAllowHorizontalGesture(r5);
    }

    @c0(name = "background")
    public final void setBackground(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setBackgroundColor(com.lynx.jsbridge.a.b(r5));
    }

    @c0(name = "border-height")
    public final void setBorderHeight(float r5) {
        j().setBorderHeight(r5);
    }

    @c0(name = "border-color")
    public final void setBorderLineColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setBorderLineColor(r5);
    }

    @c0(name = "border-width")
    public final void setBorderWidth(float r5) {
        j().setBorderWidth(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r10) {
        super.setEvents(r10);
        if (r10 == null) goto L11;
        this.f6569a = true;
        this.f6571c = r10.containsKey("tabbarcellappear");
        boolean r11 = r10.containsKey("tabbarcelldisappear");
        if (this.f6571c == true) goto L7;
        if (r11 == true) goto L7;
        return;
    L7:
        i r12 = j();
        int r5 = getSign();
        o r13 = new o(this, 1);
        r12.getClass();
        Intrinsics.checkNotNullParameter("tabbarcellappear", "appearEventType");
        Intrinsics.checkNotNullParameter("tabbarcelldisappear", "disappearEventType");
        Intrinsics.checkNotNullParameter(r13, "listener");
        if (r12.C == true) goto L13;
        DisplayMetrics r14 = DisplayMetricsHolder.b(r12.getContext());
        int r15 = r14.widthPixels;
        int r16 = r14.heightPixels;
        r12.A.set(0, 0, r15, r16);
        r12.D = r5;
        r12.E = r13;
        r12.F = "tabbarcellappear";
        r12.G = "tabbarcelldisappear";
        int r17 = 1;
        r12.getViewTreeObserver().addOnDrawListener(new e(r12, r17));
        r12.getViewTreeObserver().addOnScrollChangedListener(new com.bytedance.ies.xelement.overlay.d(r12, r17));
        r12.C = true;
        return;
    L13:
        return;
    }

    @c0(name = "hide-indicator")
    public final void setIndicatorVisibility(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bool");
        if (Intrinsics.areEqual(r5, "true") == false) goto L8;
        TabLayout r10 = j().getMTabLayout();
        if (r10 == null) goto L9;
        r10.setSelectedTabIndicator(null);
        return;
    L9:
        return;
    }

    @c0(name = "keep-item-view")
    public final void setKeepItemView(boolean r5) {
        this.e = r5;
        j().setKeepItemView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r5) {
        super.setLynxDirection(r5);
        j().setLynxDirection(r5);
    }

    @c0(name = "select-index")
    public final void setSelect(int r5) {
        TabLayout r10 = j().getMTabLayout();
        if (r10 != null) goto L5;
    L7:
        if (r5 < 0) goto L14;
        PagerAdapter r11 = j().getMViewPager().getAdapter();
        if (r11 == null) goto L11;
        int r12 = r11.getCount();
    L12:
        if (r5 >= r12) goto L14;
        j().setCurrentSelectIndex(r5);
        goto L14
    L11:
        r12 = 0;
    L14:
        j().setSelectedIndex(r5);
        return;
    L5:
        if (r10.getSelectedTabPosition() != r5) goto L7;
    }

    @c0(name = "selected-text-color")
    public final void setSelectedTextColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setSelectedTextColor(r5);
    }

    @c0(name = "selected-text-size")
    public final void setSelectedTextSize(float r5) {
        j().setSelectedTextSize(r5);
    }

    @c0(name = "tabbar-drag")
    public final void setTabBarDragEnable(boolean r5) {
        j().setTabBarDragEnable(r5);
    }

    @c0(name = "tab-height")
    public final void setTabHeight(float r5) {
        j().b(r5, false);
    }

    @c0(name = "tab-height-rpx")
    public final void setTabHeightRpx(float r5) {
        j().b(r5, true);
    }

    @c0(name = "tab-indicator-color")
    public final void setTabIndicatorColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setSelectedTabIndicatorColor(r5);
    }

    @c0(name = "tab-indicator-height")
    public final void setTabIndicatorHeight(float r5) {
        j().setTabIndicatorHeight(r5);
    }

    @c0(name = "tab-indicator-radius")
    public final void setTabIndicatorRadius(float r5) {
        j().setTabIndicatorRadius(r5);
    }

    @c0(name = "tab-indicator-width")
    public final void setTabIndicatorWidth(float r5) {
        j().setTabIndicatorWidth(r5);
    }

    @c0(name = "tab-inter-space")
    public final void setTabInterspace(float r5) {
        j().setTabInterspace(r5);
    }

    @c0(name = "tab-padding-bottom")
    public final void setTabPaddingBottom(int r5) {
        j().setTabPaddingBottom(r5);
    }

    @c0(name = "tab-padding-left")
    public final void setTabPaddingLeft(int r5) {
        j().setTabPaddingStart(r5);
    }

    @c0(name = "tab-padding-right")
    public final void setTabPaddingRight(int r5) {
        j().setTabPaddingEnd(r5);
    }

    @c0(name = "tab-padding-top")
    public final void setTabPaddingTop(int r5) {
        j().setTabPaddingTop(r5);
    }

    @c0(name = "tabbar-background")
    public final void setTabbarBackground(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setTabbarBackground(r5);
    }

    @c0(name = "tab-layout-gravity")
    public final void setTablayoutGravity(String r5) {
        Intrinsics.checkNotNullParameter(r5, "gravity");
        j().setTablayoutGravity(r5);
    }

    @c0(name = "text-bold-mode")
    public final void setTextBoldMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "boldMode");
        j().setTextBold(r5);
    }

    @c0(name = "unselected-text-color")
    public final void setUnSelectedTextColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j().setUnSelectedTextColor(r5);
    }

    @c0(name = "unselected-text-size")
    public final void setUnSelectedTextSize(float r5) {
        j().setUnSelectedTextSize(r5);
    }

    @Override // com.lynx.tasm.behavior.u0
    public final void b() {
        if (j().getMChanged() == false) goto L9;
        i r5 = j();
        if (r5.f == false) goto L7;
        r5.f = false;
        ArrayList r10 = r5.g;
        r10.clear();
        r10.addAll(r5.f23116h);
        r5.d.notifyDataSetChanged();
        r5.e();
    L7:
        i(j().getMViewPager().getCurrentItem());
        return;
    }
}
