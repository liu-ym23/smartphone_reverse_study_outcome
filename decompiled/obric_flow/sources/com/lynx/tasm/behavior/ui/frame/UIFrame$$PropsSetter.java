package com.lynx.tasm.behavior.ui.frame;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIFrame$$PropsSetter extends LynxUI$$PropsSetter {
    public UIFrame$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        UIFrame r12 = (UIFrame) r5;
        r10.getClass();
        if (r10.equals("src") == false) goto L5;
        r12.setSrc(r11.f10815a.getString(r10));
        return;
    L5:
        if (r10.equals("data") == true) goto L8;
        super.a(r5, r10, r11);
        return;
    L8:
        r12.setData(r11.f10815a.getMap(r10));
    }
}
