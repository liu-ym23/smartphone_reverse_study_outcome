package com.lynx.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxViewpagerItem$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxViewpagerItem$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxViewpagerItem r0 = (LynxViewpagerItem) r3;
        r4.getClass();
        if (r4.equals("tag") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setTag(r5.h(r4));
    }
}
