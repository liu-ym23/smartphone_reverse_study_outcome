package com.lynx.tasm.behavior.ui.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r5, String r10, y0 r11) {
        UIView r12 = (UIView) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1389119727: goto L14;
            case -505576881: goto L10;
            case -400775539: goto L6;
            default: goto L17;
        };
    L17:
        switch(r13) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.a(r5, r10, r11);
        return;
    L20:
        r12.setBlurSampling(r11.c(r10, 0));
        return;
    L22:
        r12.copyable(r11.e(r10, false));
        return;
    L24:
        r12.setImpressionId(r11.f10815a.getString(r10));
        return;
    L6:
        if (r10.equals("blur-sampling") == false) goto L17;
        r13 = 2;
        goto L17
    L10:
        if (r10.equals("copyable") == false) goto L17;
        r13 = 1;
        goto L17
    L14:
        if (r10.equals("impression_id") == false) goto L17;
        r13 = 0;
        goto L17
    }
}
