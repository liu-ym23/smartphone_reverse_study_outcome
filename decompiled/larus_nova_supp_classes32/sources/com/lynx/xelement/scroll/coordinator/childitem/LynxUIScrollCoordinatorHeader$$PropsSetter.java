package com.lynx.xelement.scroll.coordinator.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollCoordinatorHeader$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxUIScrollCoordinatorHeader$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxUIScrollCoordinatorHeader r0 = (LynxUIScrollCoordinatorHeader) r3;
        r4.getClass();
        if (r4.equals("android-consume-gesture") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setHandleGesture(r5.b(r4, false));
    }
}
