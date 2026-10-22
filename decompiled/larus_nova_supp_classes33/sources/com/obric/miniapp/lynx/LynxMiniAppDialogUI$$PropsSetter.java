package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxMiniAppDialogUI$$PropsSetter extends UIGroup$.PropsSetter {
    public LynxMiniAppDialogUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r5, String r6, com.lynx.tasm.behavior.x0 r7) {
        LynxMiniAppDialogUI r0 = (LynxMiniAppDialogUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1249474914: goto L22;
            case -77812777: goto L18;
            case 110371416: goto L14;
            case 466743410: goto L10;
            case 954925063: goto L6;
            default: goto L25;
        };
    L25:
        switch(r3) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        super.setProperty(r5, r6, r7);
        return;
    L28:
        r0.setMessage(r7.h(r6));
        return;
    L30:
        r0.setVisible(r7.b(r6, false));
        return;
    L32:
        r0.setTitle(r7.h(r6));
        return;
    L34:
        r0.setMaskColor(r7.h(r6));
        return;
    L36:
        r0.setOptions(r7.h(r6));
        return;
    L6:
        if (r6.equals("message") == false) goto L25;
        r3 = 4;
        goto L25
    L10:
        if (r6.equals("visible") == false) goto L25;
        r3 = 3;
        goto L25
    L14:
        if (r6.equals("title") == false) goto L25;
        r3 = 2;
        goto L25
    L18:
        if (r6.equals("maskColor") == false) goto L25;
        r3 = 1;
        goto L25
    L22:
        if (r6.equals("options") == false) goto L25;
        r3 = 0;
        goto L25
    }
}
