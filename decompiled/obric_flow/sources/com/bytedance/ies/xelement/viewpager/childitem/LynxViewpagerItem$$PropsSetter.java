package com.bytedance.ies.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxViewpagerItem$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxViewpagerItem$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxViewpagerItem r12 = (LynxViewpagerItem) r5;
        r10.getClass();
        if (r10.equals("tag") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setTag(r11.f10815a.getString(r10));
    }
}
