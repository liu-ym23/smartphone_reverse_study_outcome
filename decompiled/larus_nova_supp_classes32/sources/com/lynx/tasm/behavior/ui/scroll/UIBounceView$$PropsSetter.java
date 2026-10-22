package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIBounceView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIBounceView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UIBounceView r0 = (UIBounceView) r3;
        r4.getClass();
        if (r4.equals("direction") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setDirection(r5.d(r4));
    }
}
