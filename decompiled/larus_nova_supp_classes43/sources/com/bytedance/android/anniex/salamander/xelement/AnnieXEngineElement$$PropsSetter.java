package com.bytedance.android.anniex.salamander.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AnnieXEngineElement$$PropsSetter extends UIGroup$.PropsSetter {
    public AnnieXEngineElement$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r10, String r11, x0 r12) {
        AnnieXEngineElement r0 = (AnnieXEngineElement) r10;
        r11.getClass();
        if (r11.equals("anniexContainerId") == true) goto L6;
        super.setProperty(r10, r11, r12);
        return;
    L6:
        r0.setAnnieXContainerId(r12.h(r11));
    }
}
