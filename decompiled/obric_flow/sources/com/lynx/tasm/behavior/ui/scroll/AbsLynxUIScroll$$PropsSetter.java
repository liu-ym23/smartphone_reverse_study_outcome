package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AbsLynxUIScroll$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsLynxUIScroll$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        AbsLynxUIScroll r5 = (AbsLynxUIScroll) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
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
        switch(r13) {
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
        super.a(r10, r11, r12);
        return;
    L60:
        r5.setScrollLeft(r12.c(r11, 0));
        return;
    L62:
        r5.setScrollBarEnable(r12.e(r11, false));
        return;
    L64:
        r5.setUpperThreshole(r12.c(r11, 0));
        return;
    L66:
        r5.setForbidFlingFocusChange(r12.e(r11, false));
        return;
    L68:
        r5.setScrollTop(r12.c(r11, 0));
        return;
    L70:
        r5.setScrollTap(r12.e(r11, false));
        return;
    L72:
        r5.setEnableScroll(r12.e(r11, true));
        return;
    L74:
        r5.setScrollY(r12.f10815a.getDynamic(r11));
        return;
    L76:
        r5.setScrollX(r12.f10815a.getDynamic(r11));
        return;
    L78:
        r5.setEnableNewNested(r12.e(r11, false));
        return;
    L80:
        r5.setLowerThreshole(r12.c(r11, 0));
        return;
    L82:
        r5.scrollToIndex(r12.c(r11, 0));
        return;
    L84:
        r5.setBlockDescendantFocusability(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("scroll-left") == false) goto L57;
        r13 = 12;
        goto L57
    L10:
        if (r11.equals("scroll-bar-enable") == false) goto L57;
        r13 = 11;
        goto L57
    L14:
        if (r11.equals("upper-threshold") == false) goto L57;
        r13 = 10;
        goto L57
    L18:
        if (r11.equals("forbid-fling-focus-change") == false) goto L57;
        r13 = 9;
        goto L57
    L22:
        if (r11.equals("scroll-top") == false) goto L57;
        r13 = 8;
        goto L57
    L26:
        if (r11.equals("scroll-tap") == false) goto L57;
        r13 = 7;
        goto L57
    L30:
        if (r11.equals("enable-scroll") == false) goto L57;
        r13 = 6;
        goto L57
    L34:
        if (r11.equals("scroll-y") == false) goto L57;
        r13 = 5;
        goto L57
    L38:
        if (r11.equals("scroll-x") == false) goto L57;
        r13 = 4;
        goto L57
    L42:
        if (r11.equals("enable-new-nested") == false) goto L57;
        r13 = 3;
        goto L57
    L46:
        if (r11.equals("lower-threshold") == false) goto L57;
        r13 = 2;
        goto L57
    L50:
        if (r11.equals("scroll-to-index") == false) goto L57;
        r13 = 1;
        goto L57
    L54:
        if (r11.equals("block-descendant-focusability") == false) goto L57;
        r13 = 0;
        goto L57
    }
}
