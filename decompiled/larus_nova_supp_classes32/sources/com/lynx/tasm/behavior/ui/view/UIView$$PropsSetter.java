package com.lynx.tasm.behavior.ui.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        UIView r0 = (UIView) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1389119727: goto L18;
            case -505576881: goto L14;
            case -400775539: goto L10;
            case 327124377: goto L6;
            default: goto L21;
        };
    L21:
        switch(r4) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r6, r7, r8);
        return;
    L24:
        r0.setBlurAutoUpdate(r8.b(r7, true));
        return;
    L26:
        r0.setBlurSampling(r8.f(r7, 0));
        return;
    L28:
        r0.copyable(r8.b(r7, false));
        return;
    L30:
        r0.setImpressionId(r8.h(r7));
        return;
    L6:
        if (r7.equals("android-enable-auto-blur") == false) goto L21;
        r4 = 3;
        goto L21
    L10:
        if (r7.equals("blur-sampling") == false) goto L21;
        r4 = 2;
        goto L21
    L14:
        if (r7.equals("copyable") == false) goto L21;
        r4 = 1;
        goto L21
    L18:
        if (r7.equals("impression_id") == false) goto L21;
        r4 = 0;
        goto L21
    }
}
