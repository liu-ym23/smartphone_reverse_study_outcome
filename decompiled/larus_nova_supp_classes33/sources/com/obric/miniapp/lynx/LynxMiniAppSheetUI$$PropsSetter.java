package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxMiniAppSheetUI$$PropsSetter extends UIGroup$.PropsSetter {
    public LynxMiniAppSheetUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r5, String r6, com.lynx.tasm.behavior.x0 r7) {
        LynxMiniAppSheetUI r0 = (LynxMiniAppSheetUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1249474914: goto L26;
            case 51507070: goto L22;
            case 51835267: goto L18;
            case 110371416: goto L14;
            case 113126854: goto L10;
            case 466743410: goto L6;
            default: goto L29;
        };
    L29:
        switch(r3) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        super.setProperty(r5, r6, r7);
        return;
    L32:
        r0.setVisible(r7.b(r6, false));
        return;
    L34:
        r0.setWidth(r7.h(r6));
        return;
    L36:
        r0.setTitle(r7.h(r6));
        return;
    L38:
        r0.setCloseOnMask(r7.b(r6, false));
        return;
    L40:
        r0.setCloseOnBack(r7.b(r6, false));
        return;
    L42:
        r0.setOptions(r7.h(r6));
        return;
    L6:
        if (r6.equals("visible") == false) goto L29;
        r3 = 5;
        goto L29
    L10:
        if (r6.equals("width") == false) goto L29;
        r3 = 4;
        goto L29
    L14:
        if (r6.equals("title") == false) goto L29;
        r3 = 3;
        goto L29
    L18:
        if (r6.equals("closeOnMask") == false) goto L29;
        r3 = 2;
        goto L29
    L22:
        if (r6.equals("closeOnBack") == false) goto L29;
        r3 = 1;
        goto L29
    L26:
        if (r6.equals("options") == false) goto L29;
        r3 = 0;
        goto L29
    }
}
