package com.lynx.xelement.scroll.coordinator.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollCoordinatorSlotDrag$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    public LynxUIScrollCoordinatorSlotDrag$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxUIScrollCoordinatorSlotDrag r0 = (LynxUIScrollCoordinatorSlotDrag) r3;
        r4.getClass();
        if (r4.equals("enable-drag") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setEnableDrag(r5.b(r4, true));
    }
}
