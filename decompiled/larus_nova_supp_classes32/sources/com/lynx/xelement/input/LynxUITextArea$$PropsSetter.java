package com.lynx.xelement.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUITextArea$$PropsSetter extends LynxUIBaseInput$$PropsSetter {
    public LynxUITextArea$$PropsSetter() {
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxUITextArea r0 = (LynxUITextArea) r3;
        r4.getClass();
        if (r4.equals("maxlines") == false) goto L5;
        r0.setMaxLines(r5.f(r4, Integer.MAX_VALUE));
        return;
    L5:
        if (r4.equals("enable-scroll-bar") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setEnableScrollBar(r5.b(r4, false));
    }
}
