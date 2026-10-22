package com.bytedance.ies.xelement.viewpager.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxViewPagerNG$$PropsSetter extends BaseLynxViewPager$$PropsSetter {
    public LynxViewPagerNG$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxViewPagerNG r5 = (LynxViewPagerNG) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
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
        switch(r13) {
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
        super.a(r10, r11, r12);
        return;
    L36:
        r5.setDistinguishSwipeTap(r12.e(r11, true));
        return;
    L38:
        r5.setSinglePageTouch(r12.e(r11, false));
        return;
    L40:
        r5.setEnableScroll(r12.e(r11, false));
        return;
    L42:
        r5.setAndroidAlwaysOverscroll(r12.e(r11, false));
        return;
    L44:
        r5.setPageChangeAnimation(r12.e(r11, false));
        return;
    L46:
        r5.setInitialSelect(r12.c(r11, 0));
        return;
    L48:
        r5.setForceCanScroll(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("android-distinguish-swipe-tap") == false) goto L33;
        r13 = 6;
        goto L33
    L10:
        if (r11.equals("single-page-touch") == false) goto L33;
        r13 = 5;
        goto L33
    L14:
        if (r11.equals("enable-scroll") == false) goto L33;
        r13 = 4;
        goto L33
    L18:
        if (r11.equals("android-always-overscroll") == false) goto L33;
        r13 = 3;
        goto L33
    L22:
        if (r11.equals("page-change-animation") == false) goto L33;
        r13 = 2;
        goto L33
    L26:
        if (r11.equals("initial-select-index") == false) goto L33;
        r13 = 1;
        goto L33
    L30:
        if (r11.equals("android-force-can-scroll") == false) goto L33;
        r13 = 0;
        goto L33
    }
}
