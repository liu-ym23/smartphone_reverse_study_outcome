package com.lynx.animax;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UIAnimaX$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public UIAnimaX$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((UIAnimaX) r5, r10, r11, r12);
    }

    public void invoke(UIAnimaX r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
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
        switch(r13) {
            case 0: goto L132;
            case 1: goto L130;
            case 2: goto L128;
            case 3: goto L126;
            case 4: goto L124;
            case 5: goto L122;
            case 6: goto L120;
            case 7: goto L118;
            case 8: goto L116;
            case 9: goto L114;
            case 10: goto L112;
            case 11: goto L110;
            case 12: goto L108;
            case 13: goto L106;
            case 14: goto L104;
            case 15: goto L102;
            case 16: goto L100;
            case 17: goto L98;
            case 18: goto L96;
            case 19: goto L94;
            case 20: goto L92;
            default: goto L90;
        };
    L90:
        r12.invoke(new Object[]{3});
        return;
    L92:
        r5.scrollIntoView(r11, r12);
        return;
    L94:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L96:
        r5.subscribeUpdateEvents(r11, r12);
        return;
    L98:
        r5.requestUIInfo(r11, r12);
        return;
    L100:
        r5.playSegment(r11, r12);
        return;
    L102:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L104:
        r5.unsubscribeUpdateEvents(r11, r12);
        return;
    L106:
        r5.takeScreenshot(r11, r12);
        return;
    L108:
        r5.pause(r11, r12);
        return;
    L110:
        r5.getDuration(r11, r12);
        return;
    L112:
        r5.subscribeUpdateEvent(r11, r12);
        return;
    L114:
        r5.stop(r11, r12);
        return;
    L116:
        r5.seek(r11, r12);
        return;
    L118:
        r5.play(r11, r12);
        return;
    L120:
        r5.boundingClientRect(r11, r12);
        return;
    L122:
        r5.unsubscribeUpdateEvent(r11, r12);
        return;
    L124:
        r5.innerText(r11, r12);
        return;
    L126:
        r5.listenAnimationUpdate(r11, r12);
        return;
    L128:
        r5.resume(r11, r12);
        return;
    L130:
        r5.getCurrentFrame(r11, r12);
        return;
    L132:
        r5.isAnimating(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L89;
        r13 = 20;
        goto L89
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L89;
        r13 = 19;
        goto L89
    L14:
        if (r10.equals("subscribeUpdateEvents") == false) goto L89;
        r13 = 18;
        goto L89
    L18:
        if (r10.equals("requestUIInfo") == false) goto L89;
        r13 = 17;
        goto L89
    L22:
        if (r10.equals("playSegment") == false) goto L89;
        r13 = 16;
        goto L89
    L26:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L89;
        r13 = 15;
        goto L89
    L30:
        if (r10.equals("unsubscribeUpdateEvents") == false) goto L89;
        r13 = 14;
        goto L89
    L34:
        if (r10.equals("takeScreenshot") == false) goto L89;
        r13 = 13;
        goto L89
    L38:
        if (r10.equals("pause") == false) goto L89;
        r13 = 12;
        goto L89
    L42:
        if (r10.equals("getDuration") == false) goto L89;
        r13 = 11;
        goto L89
    L46:
        if (r10.equals("subscribeUpdateEvent") == false) goto L89;
        r13 = 10;
        goto L89
    L50:
        if (r10.equals("stop") == false) goto L89;
        r13 = 9;
        goto L89
    L54:
        if (r10.equals("seek") == false) goto L89;
        r13 = 8;
        goto L89
    L58:
        if (r10.equals("play") == false) goto L89;
        r13 = 7;
        goto L89
    L62:
        if (r10.equals("boundingClientRect") == false) goto L89;
        r13 = 6;
        goto L89
    L66:
        if (r10.equals("unsubscribeUpdateEvent") == false) goto L89;
        r13 = 5;
        goto L89
    L70:
        if (r10.equals("innerText") == false) goto L89;
        r13 = 4;
        goto L89
    L74:
        if (r10.equals("listenAnimationUpdate") == false) goto L89;
        r13 = 3;
        goto L89
    L78:
        if (r10.equals("resume") == false) goto L89;
        r13 = 2;
        goto L89
    L82:
        if (r10.equals("getCurrentFrame") == false) goto L89;
        r13 = 1;
        goto L89
    L86:
        if (r10.equals("isAnimating") == false) goto L89;
        r13 = 0;
        goto L89
    }
}
