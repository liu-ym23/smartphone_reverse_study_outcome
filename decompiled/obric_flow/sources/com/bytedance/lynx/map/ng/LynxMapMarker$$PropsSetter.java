package com.bytedance.lynx.map.ng;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxMapMarker$$PropsSetter extends UIView$$PropsSetter {
    public LynxMapMarker$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxMapMarker r12 = (LynxMapMarker) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -2002209467: goto L14;
            case -1764865924: goto L10;
            case -1555043537: goto L6;
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
        r12.setAnnotation(r11.f10815a.getMap(r10));
        return;
    L22:
        r12.setUserMarker(r11.e(r10, false));
        return;
    L24:
        r12.setUseCustomizedView(r11.e(r10, false));
        return;
    L6:
        if (r10.equals("annotation") == false) goto L17;
        r13 = 2;
        goto L17
    L10:
        if (r10.equals("user-marker") == false) goto L17;
        r13 = 1;
        goto L17
    L14:
        if (r10.equals("android-enable-customized-view") == false) goto L17;
        r13 = 0;
        goto L17
    }
}
