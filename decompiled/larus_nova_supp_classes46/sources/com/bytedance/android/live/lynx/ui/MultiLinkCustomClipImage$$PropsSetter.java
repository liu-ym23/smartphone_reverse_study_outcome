package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkCustomClipImage$$PropsSetter extends LynxUI$.PropsSetter {
    public MultiLinkCustomClipImage$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        MultiLinkCustomClipImage r0 = (MultiLinkCustomClipImage) r3;
        r4.getClass();
        if (r4.equals("src") == false) goto L5;
        r0.setSrc(r5.h(r4));
        return;
    L5:
        if (r4.equals("slots") == true) goto L8;
        super.setProperty(r3, r4, r5);
        return;
    L8:
        r0.setSlots(r5.d(r4));
    }
}
