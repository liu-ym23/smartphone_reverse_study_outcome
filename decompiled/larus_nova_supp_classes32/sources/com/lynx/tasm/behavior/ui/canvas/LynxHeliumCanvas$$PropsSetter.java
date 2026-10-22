package com.lynx.tasm.behavior.ui.canvas;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxHeliumCanvas$$PropsSetter extends LynxUI$$PropsSetter {
    public LynxHeliumCanvas$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LynxHeliumCanvas r0 = (LynxHeliumCanvas) r3;
        r4.getClass();
        if (r4.equals("consume-android-events") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setConsumeAllEvents(r5.b(r4, false));
    }
}
