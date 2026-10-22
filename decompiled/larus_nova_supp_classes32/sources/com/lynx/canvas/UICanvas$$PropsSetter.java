package com.lynx.canvas;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;
import com.miui.easygo.constant.EasyGoDbTable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UICanvas$$PropsSetter extends LynxUI$$PropsSetter {
    public UICanvas$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UICanvas r0 = (UICanvas) r3;
        r4.getClass();
        if (r4.equals(EasyGoDbTable.Server.NAME) == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setName(r5.h(r4));
    }
}
