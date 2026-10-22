package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LynxLottieView$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxLottieView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r8, String r9, x0 r10) {
        LynxLottieView r0 = (LynxLottieView) r8;
        r9.getClass();
        switch(r9.hashCode()) {
            case -1796070362: goto L58;
            case -1566748085: goto L54;
            case -1489589134: goto L50;
            case -1001078227: goto L46;
            case -795328846: goto L42;
            case 114148: goto L38;
            case 3271912: goto L34;
            case 3327652: goto L30;
            case 3443508: goto L26;
            case 3493088: goto L22;
            case 109641799: goto L18;
            case 1439562083: goto L14;
            case 1688643203: goto L10;
            case 1731948914: goto L6;
            default: goto L4;
        };
    L4:
        byte r1 = -1;
    L62:
        switch(r1) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L63;
        };
    L63:
        super.setProperty(r8, r9, r10);
        return;
    L65:
        r0.setEndFrame(r10.f(r9, -1));
        return;
    L67:
        r0.setRepeat(r10.f(r9, -1));
        return;
    L69:
        r0.setAutoPlay(r10.b(r9, true));
        return;
    L71:
        r0.setSpeed(r10.e(r9, 0.0f));
        return;
    L73:
        r0.setUpdateRate(r10.f(r9, 6));
        return;
    L75:
        r0.setPlay(r10.b(r9, false));
        return;
    L77:
        r0.setLoop(r10.b(r9, false));
        return;
    L79:
        r0.setJson(r10.h(r9));
        return;
    L81:
        r0.setSrc(r10.h(r9));
        return;
    L83:
        r0.setKeepLastFrame(r10.b(r9, true));
        return;
    L85:
        r0.setProgress(r10.e(r9, 0.0f));
        return;
    L87:
        r0.setObjectFit(r10.h(r9));
        return;
    L89:
        r0.setStartFrame(r10.f(r9, 0));
        return;
    L91:
        r0.setPlay(r10.h(r9));
        return;
    L6:
        if (r9.equals("endframe") == false) goto L4;
        r1 = 13;
        goto L62
    L10:
        if (r9.equals("repetcount") == false) goto L4;
        r1 = 12;
        goto L62
    L14:
        if (r9.equals("autoplay") == false) goto L4;
        r1 = 11;
        goto L62
    L18:
        if (r9.equals("speed") == false) goto L4;
        r1 = 10;
        goto L62
    L22:
        if (r9.equals("rate") == false) goto L4;
        r1 = 9;
        goto L62
    L26:
        if (r9.equals("play") == false) goto L4;
        r1 = 8;
        goto L62
    L30:
        if (r9.equals("loop") == false) goto L4;
        r1 = 7;
        goto L62
    L34:
        if (r9.equals("json") == false) goto L4;
        r1 = 6;
        goto L62
    L38:
        if (r9.equals("src") == false) goto L4;
        r1 = 5;
        goto L62
    L42:
        if (r9.equals("keeplastframe") == false) goto L4;
        r1 = 4;
        goto L62
    L46:
        if (r9.equals("progress") == false) goto L4;
        r1 = 3;
        goto L62
    L50:
        if (r9.equals("objectfit") == false) goto L4;
        r1 = 2;
        goto L62
    L54:
        if (r9.equals("startframe") == false) goto L4;
        r1 = 1;
        goto L62
    L58:
        if (r9.equals("playstatus") == false) goto L4;
        r1 = 0;
        goto L62
    }
}
