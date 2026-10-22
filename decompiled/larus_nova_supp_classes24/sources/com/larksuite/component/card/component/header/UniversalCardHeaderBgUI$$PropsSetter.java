package com.larksuite.component.card.component.header;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardHeaderBgUI$$PropsSetter extends LynxUI$.PropsSetter {
    public UniversalCardHeaderBgUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UniversalCardHeaderBgUI r0 = (UniversalCardHeaderBgUI) r3;
        r4.getClass();
        if (r4.equals("props") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setProps(r5.g(r4));
    }
}
