package com.lynx.tasm.behavior.ui;

import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxFlattenUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    public LynxFlattenUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxFlattenUI r0 = (LynxFlattenUI) r3;
        r4.getClass();
        if (r4.equals("opacity") == false) goto L5;
        r0.setAlpha(r5.e(r4, 1.0f));
        return;
    L5:
        if (r4.equals("transform") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setTransform(r5.a(r4));
    }
}
