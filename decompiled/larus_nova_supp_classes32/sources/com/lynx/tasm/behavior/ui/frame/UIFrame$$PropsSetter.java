package com.lynx.tasm.behavior.ui.frame;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIFrame$$PropsSetter extends LynxUI$$PropsSetter {
    public UIFrame$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        UIFrame r0 = (UIFrame) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1751360826: goto L38;
            case -1468080088: goto L34;
            case -877443322: goto L30;
            case -698355755: goto L26;
            case -285654696: goto L22;
            case 114148: goto L18;
            case 3076010: goto L14;
            case 626516761: goto L10;
            case 1301162757: goto L6;
            default: goto L41;
        };
    L41:
        switch(r3) {
            case 0: goto L64;
            case 1: goto L62;
            case 2: goto L60;
            case 3: goto L58;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L52;
            case 7: goto L47;
            case 8: goto L44;
            default: goto L42;
        };
    L42:
        super.setProperty(r5, r6, r7);
        return;
    L44:
        r0.setAutoHeight(r7.b(r6, false));
        return;
    L52:
        r0.setData(r7.d(r6));
        return;
    L54:
        r0.setSrc(r7.h(r6));
        return;
    L56:
        r0.setPresetWidth(r7.h(r6));
        return;
    L58:
        r0.setPresetHeight(r7.h(r6));
        return;
    L60:
        r0.setEmbeddedMode(r7.f(r6, 0));
        return;
    L62:
        r0.setAutoWidth(r7.b(r6, false));
        return;
    L64:
        r0.setGlobalProps(r7.d(r6));
        return;
    L47:
        if (r7.k(r6) == false) goto L49;
        Boolean r8 = null;
    L50:
        r0.setEnableMultiAsyncThread(r8);
        return;
    L49:
        r8 = Boolean.valueOf(r7.b(r6, false));
        goto L50
    L6:
        if (r6.equals("auto-height") == false) goto L41;
        r3 = 8;
        goto L41
    L10:
        if (r6.equals("enable-multi-async-thread") == false) goto L41;
        r3 = 7;
        goto L41
    L14:
        if (r6.equals(LynxResourceModule.DATA_KEY) == false) goto L41;
        r3 = 6;
        goto L41
    L18:
        if (r6.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L41;
        r3 = 5;
        goto L41
    L22:
        if (r6.equals("preset-width") == false) goto L41;
        r3 = 4;
        goto L41
    L26:
        if (r6.equals("preset-height") == false) goto L41;
        r3 = 3;
        goto L41
    L30:
        if (r6.equals("embedded-mode") == false) goto L41;
        r3 = 2;
        goto L41
    L34:
        if (r6.equals("auto-width") == false) goto L41;
        r3 = 1;
        goto L41
    L38:
        if (r6.equals("global-props") == false) goto L41;
        r3 = 0;
        goto L41
    }
}
