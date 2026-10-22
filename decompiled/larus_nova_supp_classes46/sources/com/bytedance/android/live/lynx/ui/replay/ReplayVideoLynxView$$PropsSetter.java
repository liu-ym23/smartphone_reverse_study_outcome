package com.bytedance.android.live.lynx.ui.replay;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ReplayVideoLynxView$$PropsSetter extends LynxUI$.PropsSetter {
    public ReplayVideoLynxView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        ReplayVideoLynxView r0 = (ReplayVideoLynxView) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1544438277: goto L42;
            case -1489589134: goto L38;
            case -982450867: goto L34;
            case -934531685: goto L30;
            case -703404533: goto L26;
            case 104264043: goto L22;
            case 369508569: goto L18;
            case 810277771: goto L14;
            case 1439562083: goto L10;
            case 2019384140: goto L6;
            default: goto L45;
        };
    L45:
        switch(r3) {
            case 0: goto L70;
            case 1: goto L68;
            case 2: goto L66;
            case 3: goto L64;
            case 4: goto L62;
            case 5: goto L60;
            case 6: goto L55;
            case 7: goto L52;
            case 8: goto L50;
            case 9: goto L48;
            default: goto L46;
        };
    L46:
        super.setProperty(r5, r6, r7);
        return;
    L48:
        r0.setLogExtra(r7.g(r6));
        return;
    L50:
        r0.setAutoPlay(r7.b(r6, false));
        return;
    L52:
        r0.setStartPosition(r7.f(r6, 0));
        return;
    L60:
        r0.setMuted(r7.b(r6, false));
        return;
    L62:
        r0.setAutoShowCover(r7.b(r6, false));
        return;
    L64:
        r0.setLoop(r7.b(r6, false));
        return;
    L66:
        r0.setPoster(r7.h(r6));
        return;
    L68:
        r0.setObjectFit(r7.h(r6));
        return;
    L70:
        r0.setEpisode(r7.h(r6));
        return;
    L55:
        if (r7.k(r6) == false) goto L57;
        Boolean r8 = null;
    L58:
        r0.setEnableEnterRoom(r8);
        return;
    L57:
        r8 = Boolean.valueOf(r7.b(r6, false));
        goto L58
    L6:
        if (r6.equals("logextra") == false) goto L45;
        r3 = 9;
        goto L45
    L10:
        if (r6.equals("autoplay") == false) goto L45;
        r3 = 8;
        goto L45
    L14:
        if (r6.equals("startposition") == false) goto L45;
        r3 = 7;
        goto L45
    L18:
        if (r6.equals("enablelynxenterroom") == false) goto L45;
        r3 = 6;
        goto L45
    L22:
        if (r6.equals("muted") == false) goto L45;
        r3 = 5;
        goto L45
    L26:
        if (r6.equals("autoshowcover") == false) goto L45;
        r3 = 4;
        goto L45
    L30:
        if (r6.equals("repeat") == false) goto L45;
        r3 = 3;
        goto L45
    L34:
        if (r6.equals("poster") == false) goto L45;
        r3 = 2;
        goto L45
    L38:
        if (r6.equals("objectfit") == false) goto L45;
        r3 = 1;
        goto L45
    L42:
        if (r6.equals("episode") == false) goto L45;
        r3 = 0;
        goto L45
    }
}
