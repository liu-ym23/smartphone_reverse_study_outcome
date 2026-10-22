package com.lynx.tasm.behavior.ui.scroll;

import android.view.Choreographer;
import c7.e;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.p;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.k;
import gn.f;
import hn.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIScrollView extends LynxUIScrollViewInternal {
    @f0
    public void autoScroll(ReadableMap r10, Callback r11) {
        if (r10.getBoolean("start", true) == false) goto L24;
        String r12 = r10.getString("rate", "0px");
        if (((LynxBaseScrollView) this.mView).f17351c == false) goto L8;
        int r5 = getHeight();
    L9:
        int r13 = (int) k.d(r12, r5, 0.0f, getLynxContext().f10152u);
        LynxContext r14 = this.mContext;
        if (r14 != null) goto L12;
        float r15 = 60.0f;
    L13:
        int r16 = (int) r15;
        if (r16 > 0) goto L16;
        r16 = 60;
    L16:
        LynxBaseScrollView r17 = (LynxBaseScrollView) this.mView;
        if (r13 <= 0) goto L19;
        int r18 = Math.max(r13 / r16, 1);
    L20:
        r17.a(2);
        g r19 = r17.f17349a;
        r19.c(false);
        if (r19.e == null) goto L23;
        Choreographer.getInstance().removeFrameCallback(r19.e);
        r19.e = null;
    L23:
        r19.d = r18;
        r19.e = new e(r19, 5);
        Choreographer.getInstance().postFrameCallback(r19.e);
        r19.f17347b = null;
    L28:
        r11.invoke(new Object[]{0});
        return;
    L19:
        r18 = Math.min(r13 / r16, -1);
        goto L20
    L12:
        r15 = DeviceUtils.a(r14.a());
        goto L13
    L8:
        r5 = getWidth();
        goto L9
    L24:
        LynxBaseScrollView r20 = (LynxBaseScrollView) this.mView;
        r20.f17349a.c(false);
        g r21 = r20.f17349a;
        if (r21.e == null) goto L27;
        Choreographer.getInstance().removeFrameCallback(r21.e);
        r21.e = null;
    L27:
        r20.a(0);
        goto L28
    }

    @f0
    public void scrollBy(ReadableMap r5, Callback r10) {
        String r11 = r5.getString("offset", "0px");
        if (((LynxBaseScrollView) this.mView).f17351c == false) goto L6;
        int r12 = getHeight();
    L7:
        int r13 = (int) k.d(r11, r12, 0.0f, getLynxContext().f10152u);
        int[] r14 = {r13, r13};
        LynxBaseScrollView r15 = (LynxBaseScrollView) this.mView;
        if (r15.f17351c == false) goto L10;
        int r16 = r15.getScrollY() + r14[1];
        int[] r17 = r15.getScrollRangeVertically();
        r15.scrollTo(r15.getScrollX(), Math.min(Math.max(r16, r17[0]), r17[1]));
    L11:
        r10.invoke(new Object[]{0});
        return;
    L10:
        int r18 = r15.getScrollX() + r14[0];
        int[] r19 = r15.getScrollRangeHorizontally();
        r15.scrollTo(Math.min(Math.max(r18, r19[0]), r19[1]), r15.getScrollY());
        goto L11
    L6:
        r12 = getWidth();
        goto L7
    }

    @f0
    public void scrollTo(ReadableMap r10, Callback r11) {
        String r5 = r10.getString("offset", "0px");
        if (((LynxBaseScrollView) this.mView).f17351c == false) goto L6;
        int r12 = getHeight();
    L7:
        int r13 = (int) k.d(r5, r12, 0.0f, getLynxContext().f10152u);
        boolean r14 = r10.getBoolean("smooth", r10.getBoolean("animated", true));
        int r15 = r10.getInt("index", -1);
        if (r15 >= 0) goto L10;
    L24:
        StringBuilder r16 = p.d(r15, "scrollTo index: ", " is out of range[0, ");
        r16.append(getChildCount());
        r16.append(").");
        r11.invoke(new Object[]{4, r16.toString()});
        return;
    L10:
        if (r15 >= getChildCount()) goto L24;
        int[] r17 = LynxUIScrollViewInternal.i(getChildAt(r15), this, isRtl());
        int[] r18 = {r13, r13};
        boolean r19 = isRtl();
        int r20 = r17[0];
        if (r19 == false) goto L14;
        int r21 = -r18[0];
    L15:
        int r22 = r20 + r21;
        r17[0] = r22;
        int r23 = r17[1] + r18[1];
        r17[1] = r23;
        if (r14 == false) goto L18;
        ((LynxBaseScrollView) this.mView).b(r17);
    L22:
        r11.invoke(new Object[]{0});
        return;
    L18:
        LynxBaseScrollView r24 = (LynxBaseScrollView) this.mView;
        if (r24.f17351c == false) goto L21;
        int[] r25 = r24.getScrollRangeVertically();
        r24.scrollTo(r24.getScrollX(), Math.min(Math.max(r23, r25[0]), r25[1]));
        goto L22
    L21:
        int[] r26 = r24.getScrollRangeHorizontally();
        r24.scrollTo(Math.min(Math.max(r22, r26[0]), r26[1]), r24.getScrollY());
        goto L22
    L14:
        r21 = r18[0];
        goto L15
    L6:
        r12 = getWidth();
        goto L7
    }

    @c0(name = "backwards-nested-scroll")
    public void setBackwardsNestedScroll(int r5) {
        ((LynxBaseScrollView) this.mView).setBackwardNestedScrollMode(r5);
    }

    @c0(name = "bounces")
    public void setBounces(boolean r5) {
        ((LynxBaseScrollView) this.mView).f17350b = r5;
    }

    @c0(name = "enable-scroll")
    public void setEnableScroll(boolean r5) {
        ((LynxBaseScrollView) this.mView).f = r5;
    }

    @c0(name = "forwards-nested-scroll")
    public void setForwardsNestedScroll(int r5) {
        ((LynxBaseScrollView) this.mView).setForwardNestedScrollMode(r5);
    }

    @c0(name = "initial-scroll-index")
    public void setInitialScrollIndex(final int r5) {
        ArrayList r10 = this.f10615h;
        if (r10 == null) goto L6;
        r10.add(new f(r5));
        return;
    }

    @c0(name = "initial-scroll-offset")
    public void setInitialScrollOffset(final String r5) {
        ArrayList r10 = this.f10615h;
        if (r10 == null) goto L6;
        r10.add(new gn.e(this, r5));
        return;
    }

    @c0(name = "lower-threshold")
    public void setLowerThreshold(String r5) {
        if (((LynxBaseScrollView) this.mView).f17351c == false) goto L6;
        int r10 = getHeight();
    L7:
        this.e = (int) k.d(r5, r10, 0.0f, getLynxContext().f10152u);
        return;
    L6:
        r10 = getWidth();
        goto L7
    }

    @c0(name = "scroll-event-throttle")
    public void setScrollEventThrottle(float r5) {
        this.f10612a = (long) r5;
    }

    @c0(name = "scroll-orientation")
    public void setScrollOrientation(String r5) {
        ((LynxBaseScrollView) this.mView).setVertical("vertical".equals(r5));
    }

    @c0(name = "upper-threshold")
    public void setUpperThreshold(String r5) {
        if (((LynxBaseScrollView) this.mView).f17351c == false) goto L6;
        int r10 = getHeight();
    L7:
        this.d = (int) k.d(r5, r10, 0.0f, getLynxContext().f10152u);
        return;
    L6:
        r10 = getWidth();
        goto L7
    }
}
