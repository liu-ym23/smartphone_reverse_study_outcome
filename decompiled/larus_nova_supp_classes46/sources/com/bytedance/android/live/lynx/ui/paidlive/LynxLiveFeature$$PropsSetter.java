package com.bytedance.android.live.lynx.ui.paidlive;

import com.bytedance.ies.xelement.live.LynxLiveLight$;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LynxLiveFeature$$PropsSetter extends LynxLiveLight$.PropsSetter {
    public LynxLiveFeature$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        LynxLiveFeature r0 = (LynxLiveFeature) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -387704902: goto L18;
            case -172848379: goto L14;
            case 3363353: goto L10;
            case 369508569: goto L6;
            default: goto L21;
        };
    L21:
        Boolean r1 = null;
        switch(r3) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L32;
            case 3: goto L26;
            default: goto L23;
        };
    L23:
        super.setProperty(r5, r6, r7);
        return;
    L37:
        r0.setRoom(r7.h(r6));
        return;
    L39:
        r0.setExtraLogParams(r7.g(r6));
        return;
    L26:
        if (r7.k(r6) == true) goto L29;
        r1 = Boolean.valueOf(r7.b(r6, false));
    L29:
        r0.setEnableEnterRoom(r1);
        return;
    L32:
        if (r7.k(r6) == true) goto L35;
        r1 = Boolean.valueOf(r7.b(r6, false));
    L35:
        r0.setVolume(r1);
        return;
    L6:
        if (r6.equals("enablelynxenterroom") == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r6.equals("mute") == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r6.equals("roomdata") == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r6.equals("extralogparams") == false) goto L21;
        r3 = 0;
        goto L21
    }
}
