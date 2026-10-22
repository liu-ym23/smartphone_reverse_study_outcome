package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class WebcastImage$$PropsSetter extends LynxUI$.PropsSetter {
    public WebcastImage$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        WebcastImage r0 = (WebcastImage) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case 114148: goto L14;
            case 371164613: goto L10;
            case 1615004818: goto L6;
            default: goto L17;
        };
    L17:
        switch(r3) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r5, r6, r7);
        return;
    L20:
        r0.setAutoPlay(r7.b(r6, false));
        return;
    L22:
        r0.setFadeDuration(r7.f(r6, 0));
        return;
    L24:
        r0.setSrc(r7.h(r6));
        return;
    L6:
        if (r6.equals("auto-play") == false) goto L17;
        r3 = 2;
        goto L17
    L10:
        if (r6.equals("fade-duration") == false) goto L17;
        r3 = 1;
        goto L17
    L14:
        if (r6.equals("src") == false) goto L17;
        r3 = 0;
        goto L17
    }
}
