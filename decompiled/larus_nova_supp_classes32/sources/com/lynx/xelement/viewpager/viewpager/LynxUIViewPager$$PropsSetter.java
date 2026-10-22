package com.lynx.xelement.viewpager.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIViewPager$$PropsSetter extends BaseLynxViewPager$$PropsSetter {
    public LynxUIViewPager$$PropsSetter() {
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LynxUIViewPager r0 = (LynxUIViewPager) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -2087292118: goto L30;
            case -1926922070: goto L26;
            case -1705023195: goto L22;
            case -1504749759: goto L18;
            case -169901481: goto L14;
            case 504748326: goto L10;
            case 2126196810: goto L6;
            default: goto L33;
        };
    L33:
        switch(r4) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        super.setProperty(r6, r7, r8);
        return;
    L36:
        r0.setDistinguishSwipeTap(r8.b(r7, true));
        return;
    L38:
        r0.setSinglePageTouch(r8.b(r7, false));
        return;
    L40:
        r0.setEnableScroll(r8.b(r7, false));
        return;
    L42:
        r0.setAndroidAlwaysOverscroll(r8.b(r7, false));
        return;
    L44:
        r0.setPageChangeAnimation(r8.b(r7, false));
        return;
    L46:
        r0.setInitialSelect(r8.f(r7, 0));
        return;
    L48:
        r0.setForceCanScroll(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("android-distinguish-swipe-tap") == false) goto L33;
        r4 = 6;
        goto L33
    L10:
        if (r7.equals("single-page-touch") == false) goto L33;
        r4 = 5;
        goto L33
    L14:
        if (r7.equals("enable-scroll") == false) goto L33;
        r4 = 4;
        goto L33
    L18:
        if (r7.equals("android-always-overscroll") == false) goto L33;
        r4 = 3;
        goto L33
    L22:
        if (r7.equals("page-change-animation") == false) goto L33;
        r4 = 2;
        goto L33
    L26:
        if (r7.equals("initial-select-index") == false) goto L33;
        r4 = 1;
        goto L33
    L30:
        if (r7.equals("android-force-can-scroll") == false) goto L33;
        r4 = 0;
        goto L33
    }
}
