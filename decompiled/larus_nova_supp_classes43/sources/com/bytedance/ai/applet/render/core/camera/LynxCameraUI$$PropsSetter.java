package com.bytedance.ai.applet.render.core.camera;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class LynxCameraUI$$PropsSetter extends UISimpleView$.PropsSetter {
    public LynxCameraUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r10, String r11, x0 r12) {
        LynxCameraUI r0 = (LynxCameraUI) r10;
        r11.getClass();
        if (r11.equals("device-position") == true) goto L6;
        super.setProperty(r10, r11, r12);
        return;
    L6:
        r0.setDevicePosition(r12.h(r11));
    }
}
