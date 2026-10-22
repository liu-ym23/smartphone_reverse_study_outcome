package com.bytedance.ies.xelement.viewpager.foldview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class BaseLynxFoldView$$PropsSetter extends UISimpleView$$PropsSetter {
    public BaseLynxFoldView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        BaseLynxFoldView r5 = (BaseLynxFoldView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1662739435: goto L14;
            case -1221994365: goto L10;
            case 1819831630: goto L6;
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
        super.a(r10, r11, r12);
        return;
    L20:
        r5.setGranularity(r12.b(0.01f, r11));
        return;
    L22:
        r5.setScrollEnable(r12.e(r11, true));
        return;
    L24:
        r5.setCompatContainerPopup(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("granularity") == false) goto L17;
        r13 = 2;
        goto L17
    L10:
        if (r11.equals("scroll-enable") == false) goto L17;
        r13 = 1;
        goto L17
    L14:
        if (r11.equals("compat-container-popup") == false) goto L17;
        r13 = 0;
        goto L17
    }
}
