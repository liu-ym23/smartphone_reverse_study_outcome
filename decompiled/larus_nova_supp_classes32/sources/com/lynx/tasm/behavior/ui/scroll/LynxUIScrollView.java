package com.lynx.tasm.behavior.ui.scroll;

import android.view.Choreographer;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.n;
import g7a.e;
import g7a.f;
import g7a.i;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(tagName = {"scroll-view-new-arch"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.scroll")
public class LynxUIScrollView extends LynxUIScrollViewInternal {
    public LynxUIScrollView(LynxContext r1) {
        super(r1);
    }

    @LynxProp(name = "backwards-nested-scroll")
    public void setBackwardsNestedScroll(int r2) {
        ((LynxBaseScrollView) this.mView).setBackwardNestedScrollMode(r2);
    }

    @LynxProp(name = "bounces")
    public void setBounces(boolean r2) {
        ((LynxBaseScrollView) this.mView).b = r2;
    }

    @LynxProp(name = "enable-scroll")
    public void setEnableScroll(boolean r2) {
        ((LynxBaseScrollView) this.mView).f = r2;
    }

    @LynxProp(name = "forwards-nested-scroll")
    public void setForwardsNestedScroll(int r2) {
        ((LynxBaseScrollView) this.mView).setForwardNestedScrollMode(r2);
    }

    @LynxProp(name = "initial-scroll-index")
    public void setInitialScrollIndex(final int r3) {
        ArrayList<LynxUIScrollViewInternal.a> r0 = this.h;
        if (r0 == null) goto L6;
        r0.add(new e(r3));
        return;
    }

    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(final String r3) {
        ArrayList<LynxUIScrollViewInternal.a> r0 = this.h;
        if (r0 == null) goto L6;
        r0.add(new g7a.d(this, r3));
        return;
    }

    @LynxProp(name = "lower-threshold")
    public void setLowerThreshold(String r4) {
        if (((LynxBaseScrollView) this.mView).c == false) goto L5;
        int r0 = getHeight();
    L6:
        this.e = (int) n.d(r4, r0, 0.0f, getLynxContext().getScreenMetrics());
        return;
    L5:
        r0 = getWidth();
        goto L6
    }

    @LynxProp(name = "scroll-event-throttle")
    public void setScrollEventThrottle(float r3) {
        this.a = (long) r3;
    }

    @LynxProp(name = "scroll-orientation")
    public void setScrollOrientation(String r3) {
        ((LynxBaseScrollView) this.mView).setVertical("vertical".equals(r3));
    }

    @LynxProp(name = "upper-threshold")
    public void setUpperThreshold(String r4) {
        if (((LynxBaseScrollView) this.mView).c == false) goto L5;
        int r0 = getHeight();
    L6:
        this.d = (int) n.d(r4, r0, 0.0f, getLynxContext().getScreenMetrics());
        return;
    L5:
        r0 = getWidth();
        goto L6
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r6, Callback r7) {
        if (r6.getBoolean("start", true) == false) goto L20;
        String r8 = r6.getString("rate", "0px");
        if (((LynxBaseScrollView) this.mView).c == false) goto L7;
        int r0 = getHeight();
    L8:
        int r9 = (int) n.d(r8, r0, 0.0f, getLynxContext().getScreenMetrics());
        LynxContext r1 = this.mContext;
        if (r1 != null) goto L11;
        float r2 = 60.0f;
    L12:
        int r3 = (int) r2;
        if (r3 > 0) goto L15;
        r3 = 60;
    L15:
        LynxBaseScrollView r4 = (LynxBaseScrollView) this.mView;
        if (r9 <= 0) goto L18;
        int r10 = Math.max(r9 / r3, 1);
    L19:
        r4.i(2);
        r4.j();
        com.lynx.tasm.behavior.ui.scroll.base.d r5 = r4.a;
        r5.g(false);
        r5.h();
        r5.d = r10;
        r5.e = new com.lynx.tasm.behavior.ui.scroll.base.d.b(r5);
        Choreographer.getInstance().postFrameCallback(r5.e);
        r5.b = null;
    L21:
        r7.invoke(new Object[]{0});
        return;
    L18:
        r10 = Math.min(r9 / r3, -1);
        goto L19
    L11:
        r2 = DeviceUtils.c(r1.getContext());
        goto L12
    L7:
        r0 = getWidth();
        goto L8
    L20:
        LynxBaseScrollView r11 = (LynxBaseScrollView) this.mView;
        r11.a.g(false);
        r11.a.h();
        r11.i(0);
        goto L21
    }

    @LynxUIMethod
    public void getScrollInfo(ReadableMap r5, Callback r6) {
        LynxBaseScrollView r7 = (LynxBaseScrollView) this.mView;
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putInt("scrollLeft", h.h(this.mContext, r7.getScrollOffsetHorizontally()));
        r0.putInt("scrollTop", h.h(this.mContext, r7.getScrollOffsetVertically()));
        r0.putInt("scrollWidth", h.h(this.mContext, r7.getScrollRangeHorizontally()[1]));
        r0.putInt("scrollHeight", h.h(this.mContext, r7.getScrollRangeVertically()[1]));
        r6.invoke(new Object[]{0, r0});
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r6, Callback r7) {
        String r8 = r6.getString("offset", "0px");
        if (((LynxBaseScrollView) this.mView).c == false) goto L5;
        int r0 = getHeight();
    L6:
        int r9 = (int) n.d(r8, r0, 0.0f, getLynxContext().getScreenMetrics());
        LynxBaseScrollView r1 = (LynxBaseScrollView) this.mView;
        if (r1.c == false) goto L9;
        int r2 = r1.getScrollY() + r9;
        int[] r10 = r1.getScrollRangeVertically();
        r1.h(Math.min(Math.max(r2, r10[0]), r10[1]));
    L10:
        r7.invoke(new Object[]{0});
        return;
    L9:
        int r3 = r1.getScrollX() + r9;
        int[] r11 = r1.getScrollRangeHorizontally();
        r1.g(Math.min(Math.max(r3, r11[0]), r11[1]));
        goto L10
    L5:
        r0 = getWidth();
        goto L6
    }

    @LynxUIMethod
    public void scrollTo(ReadableMap r7, Callback r8) {
        String r0 = r7.getString("offset", "0px");
        if (((LynxBaseScrollView) this.mView).c == false) goto L5;
        int r1 = getHeight();
    L6:
        int r2 = (int) n.d(r0, r1, 0.0f, getLynxContext().getScreenMetrics());
        boolean r3 = r7.getBoolean("smooth", r7.getBoolean("animated", true));
        int r9 = r7.getInt("index", -1);
        if (r9 >= 0) goto L9;
    L19:
        r8.invoke(new Object[]{4, "scrollTo index: " + r9 + " is out of range[0, " + getChildCount() + ")."});
        return;
    L9:
        if (r9 >= getChildCount()) goto L19;
        int[] r10 = LynxUIScrollViewInternal.M(getChildAt(r9), this, isRtl());
        int[] r4 = {r2, r2};
        boolean r5 = isRtl();
        int r6 = r10[0];
        if (r5 == false) goto L13;
        int r11 = -r4[0];
    L14:
        r10[0] = r6 + r11;
        r10[1] = r10[1] + r4[1];
        if (r3 == false) goto L17;
        ((LynxBaseScrollView) this.mView).e(r10);
    L18:
        r8.invoke(new Object[]{0});
        return;
    L17:
        ((LynxBaseScrollView) this.mView).f(r10);
        goto L18
    L13:
        r11 = r4[0];
        goto L14
    L5:
        r1 = getWidth();
        goto L6
    }

    @LynxUIMethod
    public void takeContentScreenshot(ReadableMap r9, Callback r10) {
        LynxBaseScrollView r1 = (LynxBaseScrollView) this.mView;
        if (r1 == null) goto L5;
        int r0 = r1.getScrollRangeHorizontally()[1] + r1.getWidth();
        int r3 = r1.getScrollRangeVertically()[1] + r1.getHeight();
        int r2 = r0;
    L6:
        i.d(r1, r2, r3, this.mContext, r9, r10, new f(r1));
        return;
    L5:
        r2 = 0;
        r3 = 0;
        goto L6
    }
}
