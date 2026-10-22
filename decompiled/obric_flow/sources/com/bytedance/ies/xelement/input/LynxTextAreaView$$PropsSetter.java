package com.bytedance.ies.xelement.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTextAreaView$$PropsSetter extends LynxBaseInputView$$PropsSetter {
    public LynxTextAreaView$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxTextAreaView r12 = (LynxTextAreaView) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1550570986: goto L18;
            case -428786256: goto L14;
            case 419784731: goto L10;
            case 2043213058: goto L6;
            default: goto L21;
        };
    L21:
        switch(r13) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.a(r5, r10, r11);
        return;
    L24:
        r12.setMinHeight(r11.f10815a.getString(r10));
        return;
    L26:
        r12.setMaxLines(r11.c(r10, Integer.MAX_VALUE));
        return;
    L28:
        r12.setMaxHeight(r11.f10815a.getString(r10));
        return;
    L30:
        r12.setRichType(r11.f10815a.getString(r10));
        return;
    L6:
        if (r10.equals("min-height") == false) goto L21;
        r13 = 3;
        goto L21
    L10:
        if (r10.equals("maxlines") == false) goto L21;
        r13 = 2;
        goto L21
    L14:
        if (r10.equals("max-height") == false) goto L21;
        r13 = 1;
        goto L21
    L18:
        if (r10.equals("richtype") == false) goto L21;
        r13 = 0;
        goto L21
    }
}
