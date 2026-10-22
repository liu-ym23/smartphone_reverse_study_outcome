package com.bytedance.lynx.media;

import androidx.annotation.Keep;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxVideoEngineUI$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public LynxVideoEngineUI$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxVideoEngineUI) r5, r10, r11, r12);
    }

    public void invoke(LynxVideoEngineUI r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1988613871: goto L70;
            case -802181223: goto L66;
            case -527962973: goto L62;
            case -357431021: goto L58;
            case -318370553: goto L54;
            case 3443508: goto L50;
            case 3526264: goto L46;
            case 3540994: goto L42;
            case 85887754: goto L38;
            case 106440182: goto L34;
            case 194959693: goto L30;
            case 458133450: goto L26;
            case 692239790: goto L22;
            case 1280029577: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L73;
        };
    L73:
        switch(r13) {
            case 0: goto L108;
            case 1: goto L106;
            case 2: goto L104;
            case 3: goto L102;
            case 4: goto L100;
            case 5: goto L98;
            case 6: goto L96;
            case 7: goto L94;
            case 8: goto L92;
            case 9: goto L90;
            case 10: goto L88;
            case 11: goto L86;
            case 12: goto L84;
            case 13: goto L82;
            case 14: goto L80;
            case 15: goto L78;
            case 16: goto L76;
            default: goto L74;
        };
    L74:
        r12.invoke(new Object[]{3});
        return;
    L76:
        r5.scrollIntoView(r11, r12);
        return;
    L78:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L80:
        r5.requestUIInfo(r11, r12);
        return;
    L82:
        r5.requestFocus(r12);
        return;
    L84:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L86:
        r5.requestFullScreen(r11, r12);
        return;
    L88:
        r5.takeScreenshot(r11, r12);
        return;
    L90:
        r5.pause(r11, r12);
        return;
    L92:
        r5.getDuration(r11, r12);
        return;
    L94:
        r5.stop(r11, r12);
        return;
    L96:
        r5.seek(r11, r12);
        return;
    L98:
        r5.play(r11, r12);
        return;
    L100:
        r5.prepare(r11, r12);
        return;
    L102:
        r5.boundingClientRect(r11, r12);
        return;
    L104:
        r5.innerText(r11, r12);
        return;
    L106:
        r5.exitFullScreen(r11, r12);
        return;
    L108:
        r5.releaseFocus(r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L73;
        r13 = 16;
        goto L73
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L73;
        r13 = 15;
        goto L73
    L14:
        if (r10.equals("requestUIInfo") == false) goto L73;
        r13 = 14;
        goto L73
    L18:
        if (r10.equals("requestFocus") == false) goto L73;
        r13 = 13;
        goto L73
    L22:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L73;
        r13 = 12;
        goto L73
    L26:
        if (r10.equals("requestFullScreen") == false) goto L73;
        r13 = 11;
        goto L73
    L30:
        if (r10.equals("takeScreenshot") == false) goto L73;
        r13 = 10;
        goto L73
    L34:
        if (r10.equals("pause") == false) goto L73;
        r13 = 9;
        goto L73
    L38:
        if (r10.equals("getDuration") == false) goto L73;
        r13 = 8;
        goto L73
    L42:
        if (r10.equals("stop") == false) goto L73;
        r13 = 7;
        goto L73
    L46:
        if (r10.equals("seek") == false) goto L73;
        r13 = 6;
        goto L73
    L50:
        if (r10.equals("play") == false) goto L73;
        r13 = 5;
        goto L73
    L54:
        if (r10.equals(MessageIndication.STATUS_PREPARE) == false) goto L73;
        r13 = 4;
        goto L73
    L58:
        if (r10.equals("boundingClientRect") == false) goto L73;
        r13 = 3;
        goto L73
    L62:
        if (r10.equals("innerText") == false) goto L73;
        r13 = 2;
        goto L73
    L66:
        if (r10.equals("exitFullScreen") == false) goto L73;
        r13 = 1;
        goto L73
    L70:
        if (r10.equals("releaseFocus") == false) goto L73;
        r13 = 0;
        goto L73
    }
}
