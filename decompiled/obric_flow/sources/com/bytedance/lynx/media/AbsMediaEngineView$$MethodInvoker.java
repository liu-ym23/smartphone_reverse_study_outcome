package com.bytedance.lynx.media;

import androidx.annotation.Keep;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AbsMediaEngineView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public AbsMediaEngineView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((AbsMediaEngineView) r5, r10, r11, r12);
    }

    public void invoke(AbsMediaEngineView r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1988613871: goto L62;
            case -527962973: goto L58;
            case -357431021: goto L54;
            case -318370553: goto L50;
            case 3443508: goto L46;
            case 3526264: goto L42;
            case 3540994: goto L38;
            case 85887754: goto L34;
            case 106440182: goto L30;
            case 194959693: goto L26;
            case 692239790: goto L22;
            case 1280029577: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L65;
        };
    L65:
        switch(r13) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L80;
            case 9: goto L78;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L72;
            case 13: goto L70;
            case 14: goto L68;
            default: goto L66;
        };
    L66:
        r12.invoke(new Object[]{3});
        return;
    L68:
        r5.scrollIntoView(r11, r12);
        return;
    L70:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L72:
        r5.requestUIInfo(r11, r12);
        return;
    L74:
        r5.requestFocus(r12);
        return;
    L76:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L78:
        r5.takeScreenshot(r11, r12);
        return;
    L80:
        r5.pause(r11, r12);
        return;
    L82:
        r5.getDuration(r11, r12);
        return;
    L84:
        r5.stop(r11, r12);
        return;
    L86:
        r5.seek(r11, r12);
        return;
    L88:
        r5.play(r11, r12);
        return;
    L90:
        r5.prepare(r11, r12);
        return;
    L92:
        r5.boundingClientRect(r11, r12);
        return;
    L94:
        r5.innerText(r11, r12);
        return;
    L96:
        r5.releaseFocus(r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L65;
        r13 = 14;
        goto L65
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L65;
        r13 = 13;
        goto L65
    L14:
        if (r10.equals("requestUIInfo") == false) goto L65;
        r13 = 12;
        goto L65
    L18:
        if (r10.equals("requestFocus") == false) goto L65;
        r13 = 11;
        goto L65
    L22:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L65;
        r13 = 10;
        goto L65
    L26:
        if (r10.equals("takeScreenshot") == false) goto L65;
        r13 = 9;
        goto L65
    L30:
        if (r10.equals("pause") == false) goto L65;
        r13 = 8;
        goto L65
    L34:
        if (r10.equals("getDuration") == false) goto L65;
        r13 = 7;
        goto L65
    L38:
        if (r10.equals("stop") == false) goto L65;
        r13 = 6;
        goto L65
    L42:
        if (r10.equals("seek") == false) goto L65;
        r13 = 5;
        goto L65
    L46:
        if (r10.equals("play") == false) goto L65;
        r13 = 4;
        goto L65
    L50:
        if (r10.equals(MessageIndication.STATUS_PREPARE) == false) goto L65;
        r13 = 3;
        goto L65
    L54:
        if (r10.equals("boundingClientRect") == false) goto L65;
        r13 = 2;
        goto L65
    L58:
        if (r10.equals("innerText") == false) goto L65;
        r13 = 1;
        goto L65
    L62:
        if (r10.equals("releaseFocus") == false) goto L65;
        r13 = 0;
        goto L65
    }
}
