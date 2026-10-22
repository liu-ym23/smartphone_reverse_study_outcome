package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public class UIFilterImage$$PropsSetter extends UIImage$$PropsSetter {
    public UIFilterImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.ui.image.UIImage$$PropsSetter, com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, com.lynx.tasm.behavior.y0 r11) {
        UIFilterImage r12 = (UIFilterImage) r5;
        r10.getClass();
        if (r10.equals("drop-shadow") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setDropShadow(r11.f10815a.getString(r10));
    }
}
