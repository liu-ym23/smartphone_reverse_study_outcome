package com.larksuite.component.card.component.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardLynxImageUI$$PropsSetter extends LynxUI$.PropsSetter {
    public UniversalCardLynxImageUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        UniversalCardLynxImageUI r0 = (UniversalCardLynxImageUI) r3;
        r4.getClass();
        if (r4.equals("previewImages") == false) goto L5;
        r0.setPreviewImages(r5.a(r4));
        return;
    L5:
        if (r4.equals("props") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setImageContent(r5.g(r4));
    }
}
