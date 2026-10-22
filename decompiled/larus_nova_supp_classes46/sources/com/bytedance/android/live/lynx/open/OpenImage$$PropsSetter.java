package com.bytedance.android.live.lynx.open;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.ui.image.UIImage$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class OpenImage$$PropsSetter extends UIImage$.PropsSetter {
    public OpenImage$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r3, String r4, x0 r5) {
        OpenImage r0 = (OpenImage) r3;
        r4.getClass();
        if (r4.equals("fade-duration") == true) goto L6;
        super.setProperty(r3, r4, r5);
        return;
    L6:
        r0.setFadeDuration(r5.f(r4, 0));
    }
}
