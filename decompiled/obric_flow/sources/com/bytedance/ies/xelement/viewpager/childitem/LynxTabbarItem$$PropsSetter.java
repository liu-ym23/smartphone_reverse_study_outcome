package com.bytedance.ies.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTabbarItem$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxTabbarItem$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxTabbarItem r12 = (LynxTabbarItem) r5;
        r10.getClass();
        if (r10.equals("select") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setSelect(r11.e(r10, false));
    }
}
