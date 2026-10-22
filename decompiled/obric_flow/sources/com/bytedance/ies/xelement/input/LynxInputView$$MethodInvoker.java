package com.bytedance.ies.xelement.input;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxInputView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public LynxInputView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxInputView) r5, r10, r11, r12);
    }

    public void invoke(LynxInputView r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1904435132: goto L70;
            case -1725570346: goto L66;
            case -1148585618: goto L62;
            case -906021636: goto L58;
            case -527962973: goto L54;
            case -357431021: goto L50;
            case 3027047: goto L46;
            case 97604824: goto L42;
            case 194959693: goto L38;
            case 692239790: goto L34;
            case 923542547: goto L30;
            case 1194478112: goto L26;
            case 1212545271: goto L22;
            case 1406685743: goto L18;
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
        r5.setValue(r11, r12);
        return;
    L84:
        r5.sendDelEvent(r11, r12);
        return;
    L86:
        r5.setInputFilter(r11);
        return;
    L88:
        r5.setSelectionRange(r11, r12);
        return;
    L90:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L92:
        r5.takeScreenshot(r11, r12);
        return;
    L94:
        r5.focus(r12);
        return;
    L96:
        r5.blur(r12);
        return;
    L98:
        r5.boundingClientRect(r11, r12);
        return;
    L100:
        r5.innerText(r11, r12);
        return;
    L102:
        r5.select(r12);
        return;
    L104:
        r5.addText(r11, r12);
        return;
    L106:
        r5.getSelection(r12);
        return;
    L108:
        r5.controlKeyBoard(r11, r12);
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
        if (r10.equals("setValue") == false) goto L73;
        r13 = 13;
        goto L73
    L22:
        if (r10.equals("sendDelEvent") == false) goto L73;
        r13 = 12;
        goto L73
    L26:
        if (r10.equals("setInputFilter") == false) goto L73;
        r13 = 11;
        goto L73
    L30:
        if (r10.equals("setSelectionRange") == false) goto L73;
        r13 = 10;
        goto L73
    L34:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L73;
        r13 = 9;
        goto L73
    L38:
        if (r10.equals("takeScreenshot") == false) goto L73;
        r13 = 8;
        goto L73
    L42:
        if (r10.equals("focus") == false) goto L73;
        r13 = 7;
        goto L73
    L46:
        if (r10.equals("blur") == false) goto L73;
        r13 = 6;
        goto L73
    L50:
        if (r10.equals("boundingClientRect") == false) goto L73;
        r13 = 5;
        goto L73
    L54:
        if (r10.equals("innerText") == false) goto L73;
        r13 = 4;
        goto L73
    L58:
        if (r10.equals("select") == false) goto L73;
        r13 = 3;
        goto L73
    L62:
        if (r10.equals("addText") == false) goto L73;
        r13 = 2;
        goto L73
    L66:
        if (r10.equals("getSelection") == false) goto L73;
        r13 = 1;
        goto L73
    L70:
        if (r10.equals("controlKeyBoard") == false) goto L73;
        r13 = 0;
        goto L73
    }
}
