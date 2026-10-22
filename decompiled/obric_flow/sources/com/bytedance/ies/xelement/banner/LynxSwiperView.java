package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.k;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pm.a;
import qe.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u0007J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H\u0007¢\u0006\u0004\b \u0010\u0014J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0003H\u0007¢\u0006\u0004\b$\u0010\u0007J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0003H\u0007¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\bH\u0007¢\u0006\u0004\b(\u0010\u000bJ\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0003H\u0007¢\u0006\u0004\b*\u0010\u0007J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0003H\u0007¢\u0006\u0004\b,\u0010\u0007J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u0018J\u0017\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0015H\u0007¢\u0006\u0004\b0\u0010\u0018J\u0017\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0015H\u0007¢\u0006\u0004\b1\u0010\u0018J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\b3\u0010\u0007¨\u00064"}, d2 = {"Lcom/bytedance/ies/xelement/banner/LynxSwiperView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/ies/xelement/banner/Banner;", "", "enable", "", "setIndicator", "(Z)V", "", "color", "setIndicatorColor", "(Ljava/lang/String;)V", "setIndicatorActiveColor", "mode", "setMode", "autoplay", "setAutoPlay", "", "index", "setCurrentIndex", "(I)V", "Lpm/a;", "previousMarginValue", "setPreviousMargin", "(Lpm/a;)V", "nextMarginValue", "setNextMargin", "pageMargin", "setPageMargin", "id", "setCurrentItemId", "interval", "setInterval", "duration", "setDuration", "circular", "setCircular", "hideShadow", "setHideShadow", "shadowColor", "setShadowColor", "touchable", "setTouchable", "smoothScroll", "setSmoothScroll", "itemWidth", "setItemWidth", "margin", "setStartMargin", "setEndMargin", "useHardware", "setRenderHardwareTexture", "x-element-swiper_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxSwiperView extends UISimpleView<Banner> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6395c;
    public boolean d;
    public int e;

    public LynxSwiperView(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
    }

    public final int b(a r5) {
        Intrinsics.checkNotNullParameter(r5, "itemWidth");
        if (r5.getType() != ReadableType.String) goto L17;
        String r10 = r5.asString();
        if (StringsKt.k(r10, "px") == false) goto L7;
    L8:
        int r11 = (int) k.d(r10, 0.0f, 10.0f, this.mContext.f10152u);
        Integer r12 = Integer.valueOf(r11);
        if (r11 >= 0) goto L11;
    L13:
        r12 = null;
    L14:
        if (r12 != null) goto L16;
        return 0;
    L16:
        return r12.intValue();
    L11:
        if (r11 > this.mContext.f10152u.widthPixels) goto L13;
    L7:
        if (StringsKt.k(r10, "rpx") == true) goto L8;
        return 0;
    L17:
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Log.d("Django", "createView");
        LynxFeatureCounter.a(63, this.mContext.A);
        LynxError r5 = new LynxError(220101, "A legacy x-swiper is created, please use the new x-swiper instead.", "Please check the official Lynx documentation to enable the `useNewSwiper` config", "error");
        r5.f9990a = true;
        getLynxContext().b(r5);
        Banner r11 = new Banner(r10);
        r11.setTwoItemCircularSwipe(false);
        r11.setOnPageChangeListener(new LynxSwiperView$createView$1$1(this));
        return r11;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return ((Banner) this.mView).A;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "child");
        Log.d("Django", "child: " + r5 + " index: " + r10);
        if ((r5 instanceof LynxUI) == false) goto L14;
        this.mChildren.add(r10, r5);
        Banner r11 = (Banner) this.mView;
        LynxUI r12 = (LynxUI) r5;
        if (r12 == null) goto L10;
        r11.F.add(r12);
        if (r11.f6380n == false) goto L10;
        View r13 = new View(r11.getContext());
        r13.setClickable(false);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(r11.f6373c, r11.d);
        int r15 = r11.f6372b;
        r14.leftMargin = r15;
        r14.rightMargin = r15;
        r11.B.addView(r13, r14);
        int r16 = r11.f6387v;
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(1);
        r17.setColor(r16);
        r13.setBackground(r17);
        r11.f6391z.add(r13);
    L10:
        if (r11.C == null) goto L12;
        r11.f();
        r11.C.notifyDataSetChanged();
    L12:
        r11.a();
        r5.setParent(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((Banner) this.mView).setPadding(r5, r11, r10, r12);
        Banner r13 = (Banner) this.mView;
        r13.f6390y = getWidth();
        ((Banner) this.mView).g();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        ((Banner) this.mView).b(0);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        if ((r5 instanceof LynxUI) == false) goto L25;
        this.mChildren.remove(r5);
        Banner r10 = (Banner) this.mView;
        LynxUI r11 = (LynxUI) r5;
        Iterator r12 = r10.F.iterator();
    L6:
        if (r12.hasNext() == false) goto L26;
        if (((LynxUI) r12.next()) != r11) goto L6;
        r10.F.remove(r11);
        if (r10.f6380n == false) goto L16;
        r10.f6391z.remove(0);     // Catch: Exception -> L13
        LinearLayout r13 = r10.B;     // Catch: Exception -> L13
        r13.removeView(r13.getChildAt(0));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r10.C == null) goto L18;
        r10.f();
        r10.C.notifyDataSetChanged();
    L18:
        r10.a();
        return;
    L26:
        return;
    }

    @c0(defaultBoolean = false, name = "autoplay")
    public final void setAutoPlay(boolean r5) {
        Banner r10 = (Banner) this.mView;
        r10.f6382p = r5;
        qe.a r11 = r10.G;
        r10.removeCallbacks(r11);
        r10.postDelayed(r11, r10.e);
    }

    @c0(defaultBoolean = false, name = "circular")
    public final void setCircular(boolean r5) {
        Banner r10 = (Banner) this.mView;
        if (r10.f6381o == r5) goto L8;
        BannerViewPager r11 = r10.A;
        int r12 = r10.e(r11.getCurrentItem());
        r10.f6381o = r5;
        b r13 = r10.C;
        if (r13 == null) goto L9;
        r13.notifyDataSetChanged();
        r11.setCurrentItem(r12);
        return;
    L9:
        return;
    }

    @c0(defaultInt = 0, name = "current")
    public final void setCurrentIndex(int r5) {
        ((Banner) this.mView).b(r5);
    }

    @c0(name = "current-item-id")
    public final void setCurrentItemId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Iterator<T> r10 = this.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((LynxBaseUI) r11).getName(), r5) == false) goto L4;
    L9:
        LynxBaseUI r12 = (LynxBaseUI) r11;
        if (r12 == null) goto L16;
        ((Banner) this.mView).b(this.mChildren.indexOf(r12));
        return;
    L16:
        return;
    L8:
        r11 = null;
        goto L9
    }

    @c0(defaultInt = 500, name = "duration")
    public final void setDuration(int r5) {
        ((Banner) this.mView).f = r5;
    }

    @c0(name = "end-margin")
    public final void setEndMargin(a r5) {
        Intrinsics.checkNotNullParameter(r5, "margin");
        ((Banner) this.mView).f6377k = b(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        Log.d("Django", "events: " + r5);
        if (r5 == null) goto L6;
        this.f6393a = r5.containsKey("change");
        this.f6394b = r5.containsKey("transition");
        this.f6395c = r5.containsKey("scrollstart");
        this.d = r5.containsKey("scrollend");
        return;
    }

    @c0(defaultBoolean = true, name = "hideshadow")
    public final void setHideShadow(boolean r5) {
        ((Banner) this.mView).f6384r = r5;
    }

    @c0(defaultBoolean = false, name = "indicator-dots")
    public final void setIndicator(boolean r5) {
        Log.d("Django", "indicator-dots:" + r5);
        ((Banner) this.mView).f6380n = r5;
    }

    @c0(name = "indicator-active-color")
    public final void setIndicatorActiveColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        Banner r10 = (Banner) this.mView;     // Catch: Exception -> L5
        r10.f6386u = ColorUtils.b(r5);     // Catch: Exception -> L5
        return;
    }

    @c0(name = "indicator-color")
    public final void setIndicatorColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        Banner r10 = (Banner) this.mView;     // Catch: Exception -> L5
        r10.f6387v = ColorUtils.b(r5);     // Catch: Exception -> L5
        return;
    }

    @c0(defaultInt = 5000, name = "interval")
    public final void setInterval(int r5) {
        Banner r10 = (Banner) this.mView;
        r10.e = r5;
        qe.a r11 = r10.G;
        r10.removeCallbacks(r11);
        r10.postDelayed(r11, r10.e);
    }

    @c0(name = "item-width")
    public final void setItemWidth(a r5) {
        Intrinsics.checkNotNullParameter(r5, "itemWidth");
        ((Banner) this.mView).f6378l = b(r5);
    }

    @c0(name = "mode")
    public final void setMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        Banner r10 = (Banner) this.mView;
        r10.f6379m = r5;
        if (r5.equals("coverflow") == false) goto L5;
    L8:
        r10.d(r10.f6379m, r10.g, r10.f6374h, r10.f6375i);
        return;
    L5:
        if (r5.equals("flat-coverflow") == true) goto L8;
        r10.f6384r = true;
        r10.f6385t = Color.argb(128, 0, 0, 0);
        goto L8
    }

    @c0(name = "next-margin")
    public final void setNextMargin(a r5) {
        Intrinsics.checkNotNullParameter(r5, "nextMarginValue");
        if (r5.getType() != ReadableType.String) goto L17;
        String r10 = r5.asString();
        if (StringsKt.k(r10, "px") == false) goto L7;
    L8:
        int r11 = (int) k.d(r10, 0.0f, -1.0f, this.mContext.f10152u);
        Integer r12 = Integer.valueOf(r11);
        if (r11 >= 0) goto L11;
    L13:
        r12 = null;
    L14:
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
        Banner r14 = (Banner) this.mView;
        r14.f6375i = r13;
        r14.d(r14.f6379m, r14.g, r14.f6374h, r13);
        return;
    L19:
        return;
    L11:
        if (r11 > this.mContext.f10152u.widthPixels) goto L13;
    L7:
        if (StringsKt.k(r10, "rpx") == true) goto L8;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(int r5) {
        super.setOverflow(r5);
        ((Banner) this.mView).setOverflow(r5);
    }

    @c0(name = "page-margin")
    public final void setPageMargin(a r5) {
        Intrinsics.checkNotNullParameter(r5, "pageMargin");
        if (r5.getType() != ReadableType.String) goto L17;
        String r10 = r5.asString();
        if (StringsKt.k(r10, "px") == false) goto L7;
    L8:
        int r11 = (int) k.d(r10, 0.0f, 10.0f, this.mContext.f10152u);
        Integer r12 = Integer.valueOf(r11);
        if (r11 >= 0) goto L11;
    L13:
        r12 = null;
    L14:
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
        Banner r14 = (Banner) this.mView;
        r14.g = r13;
        r14.d(r14.f6379m, r13, r14.f6374h, r14.f6375i);
        return;
    L19:
        return;
    L11:
        if (r11 > this.mContext.f10152u.widthPixels) goto L13;
    L7:
        if (StringsKt.k(r10, "rpx") == true) goto L8;
        return;
    }

    @c0(name = "previous-margin")
    public final void setPreviousMargin(a r5) {
        Intrinsics.checkNotNullParameter(r5, "previousMarginValue");
        if (r5.getType() != ReadableType.String) goto L17;
        String r10 = r5.asString();
        if (StringsKt.k(r10, "px") == false) goto L7;
    L8:
        int r11 = (int) k.d(r10, 0.0f, -1.0f, this.mContext.f10152u);
        Integer r12 = Integer.valueOf(r11);
        if (r11 >= 0) goto L11;
    L13:
        r12 = null;
    L14:
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
        Banner r14 = (Banner) this.mView;
        r14.f6374h = r13;
        r14.d(r14.f6379m, r14.g, r13, r14.f6375i);
        return;
    L19:
        return;
    L11:
        if (r11 > this.mContext.f10152u.widthPixels) goto L13;
    L7:
        if (StringsKt.k(r10, "rpx") == true) goto L8;
        return;
    }

    @c0(name = "hardware_texture")
    public final void setRenderHardwareTexture(boolean r5) {
        if (r5 == false) goto L5;
        ((Banner) this.mView).setLayerTextureType(2);
        return;
    L5:
        ((Banner) this.mView).setLayerTextureType(0);
    }

    @c0(name = "shadow-color")
    public final void setShadowColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "shadowColor");
        Banner r10 = (Banner) this.mView;     // Catch: Exception -> L5
        r10.f6385t = ColorUtils.b(r5);     // Catch: Exception -> L5
        return;
    }

    @c0(defaultBoolean = true, name = "smooth-scroll")
    public final void setSmoothScroll(boolean r5) {
        Banner r10 = (Banner) this.mView;
        r10.s = r5;
        r10.d(r10.f6379m, r10.g, r10.f6374h, r10.f6375i);
    }

    @c0(name = "start-margin")
    public final void setStartMargin(a r5) {
        Intrinsics.checkNotNullParameter(r5, "margin");
        ((Banner) this.mView).f6376j = b(r5);
    }

    @c0(defaultBoolean = false, name = "touchable")
    public final void setTouchable(boolean r5) {
        Banner r10 = (Banner) this.mView;
        r10.f6383q = r5;
        BannerViewPager r11 = r10.A;
        if (r11 == null) goto L6;
        r11.setScrollable(r5);
        return;
    }
}
