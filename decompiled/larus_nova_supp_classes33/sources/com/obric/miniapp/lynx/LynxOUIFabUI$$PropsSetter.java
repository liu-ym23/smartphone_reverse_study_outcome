package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxOUIFabUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxOUIFabUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r3, String r4, com.lynx.tasm.behavior.x0 r5) {
        LynxOUIFabUI r0 = (LynxOUIFabUI) r3;
        r4.getClass();
        if (r4.equals("options") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setOptions(r5.h(r4));
    }
}
