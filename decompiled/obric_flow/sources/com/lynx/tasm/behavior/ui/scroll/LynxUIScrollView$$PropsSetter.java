package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIScrollView$$PropsSetter extends LynxUIScrollViewInternal$$PropsSetter {
    public LynxUIScrollView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxUIScrollView r12 = (LynxUIScrollView) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
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
        switch(r13) {
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
        super.a(r5, r10, r11);
        return;
    L48:
        r12.setScrollEventThrottle(r11.b(0.0f, r10));
        return;
    L50:
        r12.setUpperThreshold(r11.f10815a.getString(r10));
        return;
    L52:
        r12.setInitialScrollOffset(r11.f10815a.getString(r10));
        return;
    L54:
        r12.setBounces(r11.e(r10, false));
        return;
    L56:
        r12.setEnableScroll(r11.e(r10, false));
        return;
    L58:
        r12.setInitialScrollIndex(r11.c(r10, 0));
        return;
    L60:
        r12.setScrollOrientation(r11.f10815a.getString(r10));
        return;
    L62:
        r12.setForwardsNestedScroll(r11.c(r10, 0));
        return;
    L64:
        r12.setLowerThreshold(r11.f10815a.getString(r10));
        return;
    L66:
        r12.setBackwardsNestedScroll(r11.c(r10, 0));
        return;
    L6:
        if (r10.equals("scroll-event-throttle") == false) goto L45;
        r13 = 9;
        goto L45
    L10:
        if (r10.equals("upper-threshold") == false) goto L45;
        r13 = 8;
        goto L45
    L14:
        if (r10.equals("initial-scroll-offset") == false) goto L45;
        r13 = 7;
        goto L45
    L18:
        if (r10.equals("bounces") == false) goto L45;
        r13 = 6;
        goto L45
    L22:
        if (r10.equals("enable-scroll") == false) goto L45;
        r13 = 5;
        goto L45
    L26:
        if (r10.equals("initial-scroll-index") == false) goto L45;
        r13 = 4;
        goto L45
    L30:
        if (r10.equals("scroll-orientation") == false) goto L45;
        r13 = 3;
        goto L45
    L34:
        if (r10.equals("forwards-nested-scroll") == false) goto L45;
        r13 = 2;
        goto L45
    L38:
        if (r10.equals("lower-threshold") == false) goto L45;
        r13 = 1;
        goto L45
    L42:
        if (r10.equals("backwards-nested-scroll") == false) goto L45;
        r13 = 0;
        goto L45
    }
}
