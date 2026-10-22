package com.lynx.tasm.behavior.ui.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIComponent$$PropsSetter extends UIView$$PropsSetter {
    public UIComponent$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UIComponent r0 = (UIComponent) r3;
        r4.getClass();
        if (r4.equals("z-index") == false) goto L5;
        r0.setZIndex(r5.f(r4, 0));
        return;
    L5:
        if (r4.equals("item-key") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setItemKey(r5.h(r4));
    }
}
