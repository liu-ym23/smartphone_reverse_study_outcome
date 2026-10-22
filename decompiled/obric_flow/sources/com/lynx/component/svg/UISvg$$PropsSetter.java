package com.lynx.component.svg;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UISvg$$PropsSetter extends LynxUI$$PropsSetter {
    public UISvg$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        UISvg r12 = (UISvg) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1556226078: goto L14;
            case 114148: goto L10;
            case 951530617: goto L6;
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
        r12.setContent(r11.f10815a.getString(r10));
        return;
    L22:
        r12.setSource(r11.f10815a.getString(r10));
        return;
    L24:
        r12.setEnableServalSvg(r11.e(r10, false));
        return;
    L6:
        if (r10.equals("content") == false) goto L17;
        r13 = 2;
        goto L17
    L10:
        if (r10.equals("src") == false) goto L17;
        r13 = 1;
        goto L17
    L14:
        if (r10.equals("enable-serval-svg") == false) goto L17;
        r13 = 0;
        goto L17
    }
}
