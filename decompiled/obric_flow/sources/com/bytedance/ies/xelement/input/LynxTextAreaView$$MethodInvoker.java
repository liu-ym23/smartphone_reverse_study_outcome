package com.bytedance.ies.xelement.input;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxTextAreaView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public LynxTextAreaView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxTextAreaView) r5, r10, r11, r12);
    }

    public void invoke(LynxTextAreaView r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1904435132: goto L82;
            case -1725570346: goto L78;
            case -1436387831: goto L74;
            case -1148585618: goto L70;
            case -906021636: goto L66;
            case -527962973: goto L62;
            case -366821380: goto L58;
            case -357431021: goto L54;
            case 3027047: goto L50;
            case 97604824: goto L46;
            case 194959693: goto L42;
            case 692239790: goto L38;
            case 923542547: goto L34;
            case 1073937649: goto L30;
            case 1194478112: goto L26;
            case 1212545271: goto L22;
            case 1406685743: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L85;
        };
    L85:
        switch(r13) {
            case 0: goto L126;
            case 1: goto L124;
            case 2: goto L122;
            case 3: goto L120;
            case 4: goto L118;
            case 5: goto L116;
            case 6: goto L114;
            case 7: goto L112;
            case 8: goto L110;
            case 9: goto L108;
            case 10: goto L106;
            case 11: goto L104;
            case 12: goto L102;
            case 13: goto L100;
            case 14: goto L98;
            case 15: goto L96;
            case 16: goto L94;
            case 17: goto L92;
            case 18: goto L90;
            case 19: goto L88;
            default: goto L86;
        };
    L86:
        r12.invoke(new Object[]{3});
        return;
    L88:
        r5.scrollIntoView(r11, r12);
        return;
    L90:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L92:
        r5.requestUIInfo(r11, r12);
        return;
    L94:
        r5.setValue(r11, r12);
        return;
    L96:
        r5.sendDelEvent(r11, r12);
        return;
    L98:
        r5.setInputFilter(r11);
        return;
    L100:
        r5.getTextInfo(r12);
        return;
    L102:
        r5.setSelectionRange(r11, r12);
        return;
    L104:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L106:
        r5.takeScreenshot(r11, r12);
        return;
    L108:
        r5.focus(r12);
        return;
    L110:
        r5.blur(r12);
        return;
    L112:
        r5.boundingClientRect(r11, r12);
        return;
    L114:
        r5.resetSelectionMenu();
        return;
    L116:
        r5.innerText(r11, r12);
        return;
    L118:
        r5.select(r12);
        return;
    L120:
        r5.addText(r11, r12);
        return;
    L122:
        r5.addMention(r11, r12);
        return;
    L124:
        r5.getSelection(r12);
        return;
    L126:
        r5.controlKeyBoard(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L85;
        r13 = 19;
        goto L85
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L85;
        r13 = 18;
        goto L85
    L14:
        if (r10.equals("requestUIInfo") == false) goto L85;
        r13 = 17;
        goto L85
    L18:
        if (r10.equals("setValue") == false) goto L85;
        r13 = 16;
        goto L85
    L22:
        if (r10.equals("sendDelEvent") == false) goto L85;
        r13 = 15;
        goto L85
    L26:
        if (r10.equals("setInputFilter") == false) goto L85;
        r13 = 14;
        goto L85
    L30:
        if (r10.equals("getTextInfo") == false) goto L85;
        r13 = 13;
        goto L85
    L34:
        if (r10.equals("setSelectionRange") == false) goto L85;
        r13 = 12;
        goto L85
    L38:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L85;
        r13 = 11;
        goto L85
    L42:
        if (r10.equals("takeScreenshot") == false) goto L85;
        r13 = 10;
        goto L85
    L46:
        if (r10.equals("focus") == false) goto L85;
        r13 = 9;
        goto L85
    L50:
        if (r10.equals("blur") == false) goto L85;
        r13 = 8;
        goto L85
    L54:
        if (r10.equals("boundingClientRect") == false) goto L85;
        r13 = 7;
        goto L85
    L58:
        if (r10.equals("resetSelectionMenu") == false) goto L85;
        r13 = 6;
        goto L85
    L62:
        if (r10.equals("innerText") == false) goto L85;
        r13 = 5;
        goto L85
    L66:
        if (r10.equals("select") == false) goto L85;
        r13 = 4;
        goto L85
    L70:
        if (r10.equals("addText") == false) goto L85;
        r13 = 3;
        goto L85
    L74:
        if (r10.equals("addMention") == false) goto L85;
        r13 = 2;
        goto L85
    L78:
        if (r10.equals("getSelection") == false) goto L85;
        r13 = 1;
        goto L85
    L82:
        if (r10.equals("controlKeyBoard") == false) goto L85;
        r13 = 0;
        goto L85
    }
}
