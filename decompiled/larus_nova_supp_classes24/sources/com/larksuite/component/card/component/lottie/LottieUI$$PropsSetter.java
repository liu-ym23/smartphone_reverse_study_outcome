package com.larksuite.component.card.component.lottie;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LottieUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LottieUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        LottieUI r0 = (LottieUI) r3;
        r4.getClass();
        if (r4.equals("src") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setSrc(r5.h(r4));
    }
}
