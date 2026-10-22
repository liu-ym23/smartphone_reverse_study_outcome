package com.lynx.xelement.viewpager.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BaseLynxViewPager$$PropsSetter extends UISimpleView$$PropsSetter {
    public BaseLynxViewPager$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        BaseLynxViewPager r0 = (BaseLynxViewPager) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1332194002: goto L18;
            case 487784663: goto L14;
            case 630404516: goto L10;
            case 942654657: goto L6;
            default: goto L21;
        };
    L21:
        switch(r3) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r5, r6, r7);
        return;
    L24:
        r0.setSelect(r7.f(r6, 0));
        return;
    L26:
        r0.setAllowHorizontalGesture(r7.b(r6, false));
        return;
    L28:
        r0.setKeepItemView(r7.b(r6, false));
        return;
    L30:
        r0.setBackground(r7.h(r6));
        return;
    L6:
        if (r6.equals("select-index") == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r6.equals("allow-horizontal-gesture") == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r6.equals("keep-item-view") == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r6.equals("background") == false) goto L21;
        r3 = 0;
        goto L21
    }
}
