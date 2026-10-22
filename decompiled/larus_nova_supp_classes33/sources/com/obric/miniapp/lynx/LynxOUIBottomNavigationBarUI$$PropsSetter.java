package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxOUIBottomNavigationBarUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxOUIBottomNavigationBarUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r3, String r4, com.lynx.tasm.behavior.x0 r5) {
        LynxOUIBottomNavigationBarUI r0 = (LynxOUIBottomNavigationBarUI) r3;
        r4.getClass();
        if (r4.equals("options") == false) goto L5;
        r0.setOptions(r5.h(r4));
        return;
    L5:
        if (r4.equals("selectedIndex") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setSelectedIndex(r5.f(r4, 0));
    }
}
