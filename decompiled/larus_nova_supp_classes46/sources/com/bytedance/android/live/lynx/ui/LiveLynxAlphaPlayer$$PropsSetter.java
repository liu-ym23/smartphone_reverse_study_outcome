package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveLynxAlphaPlayer$$PropsSetter extends UISimpleView$.PropsSetter {
    public LiveLynxAlphaPlayer$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LiveLynxAlphaPlayer r0 = (LiveLynxAlphaPlayer) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -2133601602: goto L26;
            case -982450867: goto L22;
            case 114148: goto L18;
            case 3327652: goto L14;
            case 838895478: goto L10;
            case 1439562083: goto L6;
            default: goto L29;
        };
    L29:
        switch(r4) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        super.setProperty(r6, r7, r8);
        return;
    L32:
        r0.setAutoPlay(r8.b(r7, true));
        return;
    L34:
        r0.setLastFrame(r8.h(r7));
        return;
    L36:
        r0.setLoop(r8.b(r7, false));
        return;
    L38:
        r0.setSrc(r8.h(r7));
        return;
    L40:
        r0.setPoster(r8.h(r7));
        return;
    L42:
        r0.setKeepLastFrame(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("autoplay") == false) goto L29;
        r4 = 5;
        goto L29
    L10:
        if (r7.equals("last-frame") == false) goto L29;
        r4 = 4;
        goto L29
    L14:
        if (r7.equals("loop") == false) goto L29;
        r4 = 3;
        goto L29
    L18:
        if (r7.equals("src") == false) goto L29;
        r4 = 2;
        goto L29
    L22:
        if (r7.equals("poster") == false) goto L29;
        r4 = 1;
        goto L29
    L26:
        if (r7.equals("keep-last-frame") == false) goto L29;
        r4 = 0;
        goto L29
    }
}
