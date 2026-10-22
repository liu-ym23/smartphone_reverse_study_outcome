package com.lynx.tasm.behavior.ui;

import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxFlattenUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    public LynxFlattenUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxFlattenUI r12 = (LynxFlattenUI) r5;
        r10.getClass();
        if (r10.equals("opacity") == false) goto L5;
        r12.setAlpha(r11.b(1.0f, r10));
        return;
    L5:
        if (r10.equals("transform") == true) goto L8;
        super.a(r5, r10, r11);
        return;
    L8:
        r12.setTransform(r11.f10815a.getArray(r10));
    }
}
