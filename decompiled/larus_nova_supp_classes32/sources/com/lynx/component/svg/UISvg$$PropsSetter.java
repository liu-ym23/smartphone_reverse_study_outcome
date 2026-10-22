package com.lynx.component.svg;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UISvg$$PropsSetter extends LynxUI$$PropsSetter {
    public UISvg$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        UISvg r0 = (UISvg) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1556226078: goto L18;
            case 114148: goto L14;
            case 951530617: goto L10;
            case 1139622415: goto L6;
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
        r0.setColor(r7.h(r6));
        return;
    L26:
        r0.setContent(r7.h(r6));
        return;
    L28:
        r0.setSource(r7.h(r6));
        return;
    L30:
        r0.setEnableServalSvg(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("current-color") == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r6.equals(LynxAccessibilityModule.MSG_CONTENT) == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r6.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r6.equals("enable-serval-svg") == false) goto L21;
        r3 = 0;
        goto L21
    }
}
