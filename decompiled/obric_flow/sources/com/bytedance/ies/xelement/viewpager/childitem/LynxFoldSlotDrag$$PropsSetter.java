package com.bytedance.ies.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxFoldSlotDrag$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    public LynxFoldSlotDrag$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxFoldSlotDrag r12 = (LynxFoldSlotDrag) r5;
        r10.getClass();
        if (r10.equals("enable-drag") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setEnableDrag(r11.e(r10, true));
    }
}
