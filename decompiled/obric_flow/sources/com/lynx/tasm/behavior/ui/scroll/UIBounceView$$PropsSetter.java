package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIBounceView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIBounceView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        UIBounceView r12 = (UIBounceView) r5;
        r10.getClass();
        if (r10.equals("direction") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setDirection(r11.f10815a.getDynamic(r10));
    }
}
