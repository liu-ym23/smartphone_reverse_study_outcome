package com.lynx.xelement.scroll.coordinator;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BaseScrollCoordinator$$PropsSetter extends UISimpleView$$PropsSetter {
    public BaseScrollCoordinator$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        BaseScrollCoordinator r0 = (BaseScrollCoordinator) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1662739435: goto L14;
            case -169901481: goto L10;
            case 1819831630: goto L6;
            default: goto L17;
        };
    L17:
        switch(r4) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r6, r7, r8);
        return;
    L20:
        r0.setGranularity(r8.e(r7, 0.01f));
        return;
    L22:
        r0.setScrollEnable(r8.b(r7, true));
        return;
    L24:
        r0.setCompatContainerPopup(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("granularity") == false) goto L17;
        r4 = 2;
        goto L17
    L10:
        if (r7.equals("enable-scroll") == false) goto L17;
        r4 = 1;
        goto L17
    L14:
        if (r7.equals("compat-container-popup") == false) goto L17;
        r4 = 0;
        goto L17
    }
}
