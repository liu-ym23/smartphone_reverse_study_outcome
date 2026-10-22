package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AbsLynxUIScroll$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsLynxUIScroll$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        AbsLynxUIScroll r0 = (AbsLynxUIScroll) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -2039913758: goto L54;
            case -2032847360: goto L50;
            case -1571036001: goto L46;
            case -445000626: goto L42;
            case -402166408: goto L38;
            case -402166407: goto L34;
            case -169901481: goto L30;
            case 65137827: goto L26;
            case 65138261: goto L22;
            case 257565167: goto L18;
            case 660290816: goto L14;
            case 1751260029: goto L10;
            case 2019037959: goto L6;
            default: goto L57;
        };
    L57:
        switch(r4) {
            case 0: goto L84;
            case 1: goto L82;
            case 2: goto L80;
            case 3: goto L78;
            case 4: goto L76;
            case 5: goto L74;
            case 6: goto L72;
            case 7: goto L70;
            case 8: goto L68;
            case 9: goto L66;
            case 10: goto L64;
            case 11: goto L62;
            case 12: goto L60;
            default: goto L58;
        };
    L58:
        super.setProperty(r6, r7, r8);
        return;
    L60:
        r0.setScrollLeft(r8.f(r7, 0));
        return;
    L62:
        r0.setScrollBarEnable(r8.b(r7, false));
        return;
    L64:
        r0.setUpperThreshole(r8.f(r7, 0));
        return;
    L66:
        r0.setForbidFlingFocusChange(r8.b(r7, false));
        return;
    L68:
        r0.setScrollTop(r8.f(r7, 0));
        return;
    L70:
        r0.setScrollTap(r8.b(r7, false));
        return;
    L72:
        r0.setEnableScroll(r8.b(r7, true));
        return;
    L74:
        r0.setScrollY(r8.d(r7));
        return;
    L76:
        r0.setScrollX(r8.d(r7));
        return;
    L78:
        r0.setEnableNewNested(r8.b(r7, false));
        return;
    L80:
        r0.setLowerThreshole(r8.f(r7, 0));
        return;
    L82:
        r0.scrollToIndex(r8.f(r7, 0));
        return;
    L84:
        r0.setBlockDescendantFocusability(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("scroll-left") == false) goto L57;
        r4 = 12;
        goto L57
    L10:
        if (r7.equals("scroll-bar-enable") == false) goto L57;
        r4 = 11;
        goto L57
    L14:
        if (r7.equals("upper-threshold") == false) goto L57;
        r4 = 10;
        goto L57
    L18:
        if (r7.equals("forbid-fling-focus-change") == false) goto L57;
        r4 = 9;
        goto L57
    L22:
        if (r7.equals("scroll-top") == false) goto L57;
        r4 = 8;
        goto L57
    L26:
        if (r7.equals("scroll-tap") == false) goto L57;
        r4 = 7;
        goto L57
    L30:
        if (r7.equals("enable-scroll") == false) goto L57;
        r4 = 6;
        goto L57
    L34:
        if (r7.equals("scroll-y") == false) goto L57;
        r4 = 5;
        goto L57
    L38:
        if (r7.equals("scroll-x") == false) goto L57;
        r4 = 4;
        goto L57
    L42:
        if (r7.equals("enable-new-nested") == false) goto L57;
        r4 = 3;
        goto L57
    L46:
        if (r7.equals("lower-threshold") == false) goto L57;
        r4 = 2;
        goto L57
    L50:
        if (r7.equals("scroll-to-index") == false) goto L57;
        r4 = 1;
        goto L57
    L54:
        if (r7.equals("block-descendant-focusability") == false) goto L57;
        r4 = 0;
        goto L57
    }
}
