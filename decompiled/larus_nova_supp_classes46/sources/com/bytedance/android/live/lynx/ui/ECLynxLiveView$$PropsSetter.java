package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ECLynxLiveView$$PropsSetter extends LynxUI$.PropsSetter {
    public ECLynxLiveView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        ECLynxLiveView r0 = (ECLynxLiveView) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1785664369: goto L38;
            case -1489589134: goto L34;
            case -1247523363: goto L30;
            case -1195248822: goto L26;
            case -982450867: goto L22;
            case -810883302: goto L18;
            case 3363353: goto L14;
            case 1379844941: goto L10;
            case 1417199286: goto L6;
            default: goto L41;
        };
    L41:
        Boolean r1 = null;
        switch(r3) {
            case 0: goto L66;
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L59;
            case 4: goto L57;
            case 5: goto L55;
            case 6: goto L50;
            case 7: goto L47;
            case 8: goto L45;
            default: goto L43;
        };
    L43:
        super.setProperty(r5, r6, r7);
        return;
    L45:
        r0.setLiveData(r7.h(r6));
        return;
    L47:
        r0.setRoomId(r7.h(r6));
        return;
    L55:
        r0.setVolume(r7.e(r6, 0.0f));
        return;
    L57:
        r0.setPoster(r7.h(r6));
        return;
    L59:
        r0.setStreamData(r7.h(r6));
        return;
    L61:
        r0.setQualities(r7.h(r6));
        return;
    L63:
        r0.setObjectfit(r7.h(r6));
        return;
    L50:
        if (r7.k(r6) == true) goto L53;
        r1 = Boolean.valueOf(r7.b(r6, false));
    L53:
        r0.setMute(r1);
        return;
    L66:
        if (r7.k(r6) == true) goto L69;
        r1 = Boolean.valueOf(r7.b(r6, false));
    L69:
        r0.setSharePlayer(r1);
        return;
    L6:
        if (r6.equals("liveData") == false) goto L41;
        r3 = 8;
        goto L41
    L10:
        if (r6.equals("room-id") == false) goto L41;
        r3 = 7;
        goto L41
    L14:
        if (r6.equals("mute") == false) goto L41;
        r3 = 6;
        goto L41
    L18:
        if (r6.equals("volume") == false) goto L41;
        r3 = 5;
        goto L41
    L22:
        if (r6.equals("poster") == false) goto L41;
        r3 = 4;
        goto L41
    L26:
        if (r6.equals("streamData") == false) goto L41;
        r3 = 3;
        goto L41
    L30:
        if (r6.equals("qualities") == false) goto L41;
        r3 = 2;
        goto L41
    L34:
        if (r6.equals("objectfit") == false) goto L41;
        r3 = 1;
        goto L41
    L38:
        if (r6.equals("share-player") == false) goto L41;
        r3 = 0;
        goto L41
    }
}
