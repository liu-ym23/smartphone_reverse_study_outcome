package com.lynx.animax;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIAnimaX$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<UIAnimaX> {
    public UIAnimaX$$MethodInvoker() {
    }

    public void invoke(UIAnimaX r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1998037676: goto L86;
            case -1222700566: goto L82;
            case -934426579: goto L78;
            case -929558362: goto L74;
            case -527962973: goto L70;
            case -407658560: goto L66;
            case -357431021: goto L62;
            case 3443508: goto L58;
            case 3526264: goto L54;
            case 3540994: goto L50;
            case 47962023: goto L46;
            case 85887754: goto L42;
            case 106440182: goto L38;
            case 194959693: goto L34;
            case 247486643: goto L30;
            case 692239790: goto L26;
            case 1396926815: goto L22;
            case 1419773105: goto L18;
            case 1486822828: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L89;
        };
    L89:
        switch(r4) {
            case 0: goto L111;
            case 1: goto L110;
            case 2: goto L109;
            case 3: goto L108;
            case 4: goto L107;
            case 5: goto L106;
            case 6: goto L105;
            case 7: goto L104;
            case 8: goto L103;
            case 9: goto L102;
            case 10: goto L101;
            case 11: goto L100;
            case 12: goto L99;
            case 13: goto L98;
            case 14: goto L97;
            case 15: goto L96;
            case 16: goto L95;
            case 17: goto L94;
            case 18: goto L93;
            case 19: goto L92;
            case 20: goto L91;
            default: goto L90;
        };
    L90:
        r9.invoke(new Object[]{3});
        return;
    L91:
        r6.scrollIntoView(r8, r9);
        return;
    L92:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L93:
        r6.subscribeUpdateEvents(r8, r9);
        return;
    L94:
        r6.requestUIInfo(r8, r9);
        return;
    L95:
        r6.playSegment(r8, r9);
        return;
    L96:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L97:
        r6.unsubscribeUpdateEvents(r8, r9);
        return;
    L98:
        r6.takeScreenshot(r8, r9);
        return;
    L99:
        r6.pause(r8, r9);
        return;
    L100:
        r6.getDuration(r8, r9);
        return;
    L101:
        r6.subscribeUpdateEvent(r8, r9);
        return;
    L102:
        r6.stop(r8, r9);
        return;
    L103:
        r6.seek(r8, r9);
        return;
    L104:
        r6.play(r8, r9);
        return;
    L105:
        r6.boundingClientRect(r8, r9);
        return;
    L106:
        r6.unsubscribeUpdateEvent(r8, r9);
        return;
    L107:
        r6.innerText(r8, r9);
        return;
    L108:
        r6.listenAnimationUpdate(r8, r9);
        return;
    L109:
        r6.resume(r8, r9);
        return;
    L110:
        r6.getCurrentFrame(r8, r9);
        return;
    L111:
        r6.isAnimating(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L89;
        r4 = 20;
        goto L89
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L89;
        r4 = 19;
        goto L89
    L14:
        if (r7.equals("subscribeUpdateEvents") == false) goto L89;
        r4 = 18;
        goto L89
    L18:
        if (r7.equals("requestUIInfo") == false) goto L89;
        r4 = 17;
        goto L89
    L22:
        if (r7.equals("playSegment") == false) goto L89;
        r4 = 16;
        goto L89
    L26:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L89;
        r4 = 15;
        goto L89
    L30:
        if (r7.equals("unsubscribeUpdateEvents") == false) goto L89;
        r4 = 14;
        goto L89
    L34:
        if (r7.equals("takeScreenshot") == false) goto L89;
        r4 = 13;
        goto L89
    L38:
        if (r7.equals("pause") == false) goto L89;
        r4 = 12;
        goto L89
    L42:
        if (r7.equals("getDuration") == false) goto L89;
        r4 = 11;
        goto L89
    L46:
        if (r7.equals("subscribeUpdateEvent") == false) goto L89;
        r4 = 10;
        goto L89
    L50:
        if (r7.equals("stop") == false) goto L89;
        r4 = 9;
        goto L89
    L54:
        if (r7.equals("seek") == false) goto L89;
        r4 = 8;
        goto L89
    L58:
        if (r7.equals("play") == false) goto L89;
        r4 = 7;
        goto L89
    L62:
        if (r7.equals("boundingClientRect") == false) goto L89;
        r4 = 6;
        goto L89
    L66:
        if (r7.equals("unsubscribeUpdateEvent") == false) goto L89;
        r4 = 5;
        goto L89
    L70:
        if (r7.equals("innerText") == false) goto L89;
        r4 = 4;
        goto L89
    L74:
        if (r7.equals("listenAnimationUpdate") == false) goto L89;
        r4 = 3;
        goto L89
    L78:
        if (r7.equals("resume") == false) goto L89;
        r4 = 2;
        goto L89
    L82:
        if (r7.equals("getCurrentFrame") == false) goto L89;
        r4 = 1;
        goto L89
    L86:
        if (r7.equals("isAnimating") == false) goto L89;
        r4 = 0;
        goto L89
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((UIAnimaX) r1, r2, r3, r4);
    }
}
