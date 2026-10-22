package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxOUISwitchUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxOUISwitchUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r5, String r6, com.lynx.tasm.behavior.x0 r7) {
        LynxOUISwitchUI r0 = (LynxOUISwitchUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1249474914: goto L14;
            case 270940796: goto L10;
            case 742313895: goto L6;
            default: goto L17;
        };
    L17:
        switch(r3) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r5, r6, r7);
        return;
    L20:
        r0.setChecked(r7.b(r6, false));
        return;
    L22:
        r0.setDisabled(r7.b(r6, false));
        return;
    L24:
        r0.setOptions(r7.h(r6));
        return;
    L6:
        if (r6.equals("checked") == false) goto L17;
        r3 = 2;
        goto L17
    L10:
        if (r6.equals("disabled") == false) goto L17;
        r3 = 1;
        goto L17
    L14:
        if (r6.equals("options") == false) goto L17;
        r3 = 0;
        goto L17
    }
}
