package com.bytedance.ies.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxImpressionView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxImpressionView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxImpressionView r12 = (LynxImpressionView) r5;
        r10.getClass();
        if (r10.equals("impression-percent") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.impressionPercent(r11.c(r10, 0));
    }
}
