package com.lynx.xelement.blur;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIBlurView$$PropsSetter extends UIView$$PropsSetter {
    public LynxUIBlurView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LynxUIBlurView r0 = (LynxUIBlurView) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -866653701: goto L18;
            case -91134698: goto L14;
            case 681292984: goto L10;
            case 1574384313: goto L6;
            default: goto L21;
        };
    L21:
        switch(r4) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r6, r7, r8);
        return;
    L24:
        r0.setExperimentalUpdateBlurRadius(r8.b(r7, false));
        return;
    L26:
        r0.setBlurRadius(r8.h(r7));
        return;
    L28:
        r0.setCaptureTarget(r8.h(r7));
        return;
    L30:
        r0.setEnableAutoBlur(r8.b(r7, true));
        return;
    L6:
        if (r7.equals("experimental-update-blur-radius") == false) goto L21;
        r4 = 3;
        goto L21
    L10:
        if (r7.equals("blur-radius") == false) goto L21;
        r4 = 2;
        goto L21
    L14:
        if (r7.equals("android-capture-target") == false) goto L21;
        r4 = 1;
        goto L21
    L18:
        if (r7.equals("enable-auto-blur") == false) goto L21;
        r4 = 0;
        goto L21
    }
}
