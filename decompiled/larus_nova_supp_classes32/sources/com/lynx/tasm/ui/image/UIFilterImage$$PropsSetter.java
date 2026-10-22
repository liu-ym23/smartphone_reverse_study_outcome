package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIFilterImage$$PropsSetter extends UIImage$$PropsSetter {
    public UIFilterImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.ui.image.UIImage$$PropsSetter, com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UIFilterImage r0 = (UIFilterImage) r3;
        r4.getClass();
        if (r4.equals("drop-shadow") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setDropShadow(r5.h(r4));
    }
}
