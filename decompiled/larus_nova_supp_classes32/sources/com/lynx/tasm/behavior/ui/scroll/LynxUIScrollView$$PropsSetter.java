package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollView$$PropsSetter extends LynxUIScrollViewInternal$$PropsSetter {
    public LynxUIScrollView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        LynxUIScrollView r0 = (LynxUIScrollView) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -2116748730: goto L42;
            case -1571036001: goto L38;
            case -1475521756: goto L34;
            case -711580976: goto L30;
            case -411446853: goto L26;
            case -169901481: goto L22;
            case 70310635: goto L18;
            case 294508746: goto L14;
            case 660290816: goto L10;
            case 875338749: goto L6;
            default: goto L45;
        };
    L45:
        switch(r3) {
            case 0: goto L66;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L60;
            case 4: goto L58;
            case 5: goto L56;
            case 6: goto L54;
            case 7: goto L52;
            case 8: goto L50;
            case 9: goto L48;
            default: goto L46;
        };
    L46:
        super.setProperty(r5, r6, r7);
        return;
    L48:
        r0.setScrollEventThrottle(r7.e(r6, 0.0f));
        return;
    L50:
        r0.setUpperThreshold(r7.h(r6));
        return;
    L52:
        r0.setInitialScrollOffset(r7.h(r6));
        return;
    L54:
        r0.setBounces(r7.b(r6, false));
        return;
    L56:
        r0.setEnableScroll(r7.b(r6, false));
        return;
    L58:
        r0.setInitialScrollIndex(r7.f(r6, 0));
        return;
    L60:
        r0.setScrollOrientation(r7.h(r6));
        return;
    L62:
        r0.setForwardsNestedScroll(r7.f(r6, 0));
        return;
    L64:
        r0.setLowerThreshold(r7.h(r6));
        return;
    L66:
        r0.setBackwardsNestedScroll(r7.f(r6, 0));
        return;
    L6:
        if (r6.equals("scroll-event-throttle") == false) goto L45;
        r3 = 9;
        goto L45
    L10:
        if (r6.equals("upper-threshold") == false) goto L45;
        r3 = 8;
        goto L45
    L14:
        if (r6.equals("initial-scroll-offset") == false) goto L45;
        r3 = 7;
        goto L45
    L18:
        if (r6.equals("bounces") == false) goto L45;
        r3 = 6;
        goto L45
    L22:
        if (r6.equals("enable-scroll") == false) goto L45;
        r3 = 5;
        goto L45
    L26:
        if (r6.equals("initial-scroll-index") == false) goto L45;
        r3 = 4;
        goto L45
    L30:
        if (r6.equals("scroll-orientation") == false) goto L45;
        r3 = 3;
        goto L45
    L34:
        if (r6.equals("forwards-nested-scroll") == false) goto L45;
        r3 = 2;
        goto L45
    L38:
        if (r6.equals("lower-threshold") == false) goto L45;
        r3 = 1;
        goto L45
    L42:
        if (r6.equals("backwards-nested-scroll") == false) goto L45;
        r3 = 0;
        goto L45
    }
}
