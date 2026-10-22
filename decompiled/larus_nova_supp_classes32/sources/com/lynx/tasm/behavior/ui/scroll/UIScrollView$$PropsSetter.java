package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIScrollView$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    public UIScrollView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        UIScrollView r0 = (UIScrollView) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1305579111: goto L46;
            case -746453530: goto L42;
            case -711580976: goto L38;
            case 293962082: goto L34;
            case 294508746: goto L30;
            case 616977828: goto L26;
            case 1013897100: goto L22;
            case 1730905463: goto L18;
            case 1868120577: goto L14;
            case 2107607620: goto L10;
            case 2119882642: goto L6;
            default: goto L49;
        };
    L49:
        Integer r1 = null;
        switch(r4) {
            case 0: goto L81;
            case 1: goto L79;
            case 2: goto L77;
            case 3: goto L75;
            case 4: goto L70;
            case 5: goto L67;
            case 6: goto L65;
            case 7: goto L60;
            case 8: goto L57;
            case 9: goto L55;
            case 10: goto L53;
            default: goto L51;
        };
    L51:
        super.setProperty(r6, r7, r8);
        return;
    L53:
        r0.setEnableOverflowHiddenPaddingVisible(r8.b(r7, true));
        return;
    L55:
        r0.setItemSnap(r8.g(r7));
        return;
    L57:
        r0.setEnableNewBounce(r8.b(r7, false));
        return;
    L65:
        r0.setForceCanScroll(r8.b(r7, false));
        return;
    L67:
        r0.setPreferenceConsumeGesture(r8.b(r7, false));
        return;
    L75:
        r0.setFadingEdgeLength(r8.h(r7));
        return;
    L77:
        r0.setScrollOrientation(r8.h(r7));
        return;
    L79:
        r0.setTouchSlop(r8.h(r7));
        return;
    L81:
        r0.setEnableNestedScroll(r8.b(r7, false));
        return;
    L60:
        if (r8.k(r7) == true) goto L63;
        r1 = Integer.valueOf(r8.f(r7, 0));
    L63:
        r0.setInitialScrollToIndex(r1);
        return;
    L70:
        if (r8.k(r7) == true) goto L73;
        r1 = Integer.valueOf(r8.f(r7, 0));
    L73:
        r0.setInitialScrollOffset(r1);
        return;
    L6:
        if (r7.equals("android-enable-overflow-hidden-padding-visible") == false) goto L49;
        r4 = 10;
        goto L49
    L10:
        if (r7.equals("item-snap") == false) goto L49;
        r4 = 9;
        goto L49
    L14:
        if (r7.equals("android-enable-new-bounce") == false) goto L49;
        r4 = 8;
        goto L49
    L18:
        if (r7.equals("initial-scroll-to-index") == false) goto L49;
        r4 = 7;
        goto L49
    L22:
        if (r7.equals("force-can-scroll") == false) goto L49;
        r4 = 6;
        goto L49
    L26:
        if (r7.equals("android-preference-consume-gesture") == false) goto L49;
        r4 = 5;
        goto L49
    L30:
        if (r7.equals("initial-scroll-offset") == false) goto L49;
        r4 = 4;
        goto L49
    L34:
        if (r7.equals("fading-edge-length") == false) goto L49;
        r4 = 3;
        goto L49
    L38:
        if (r7.equals("scroll-orientation") == false) goto L49;
        r4 = 2;
        goto L49
    L42:
        if (r7.equals("android-touch-slop") == false) goto L49;
        r4 = 1;
        goto L49
    L46:
        if (r7.equals("enable-nested-scroll") == false) goto L49;
        r4 = 0;
        goto L49
    }
}
